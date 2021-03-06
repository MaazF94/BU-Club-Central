package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import edu.ben.bu_club_central.models.User;
import jbcrypt.BCrypt;

public class UserDao {
	/**
	 * class variable for the table name of this class in the database
	 */
	private String tableName = "user";

	/**
	 * class variable for when registering a user the default is enabled
	 */
	private int enabled = 1;

	/**
	 * class variable for a method that when you disable a user
	 */
	private int disabled = 0;

	/**
	 * class variable for the default role id when registering users which is
	 * user a regular member
	 */
	private int default_role_id = 1;

	/**
	 * the declaration of the database connection class
	 */
	private DatabaseConnection dbc;

	/**
	 * the declaration of the connection class
	 */
	private Connection conn;

	/**
	 * The method registers users into the database
	 * 
	 * @param first_name
	 *            String
	 * @param last_name
	 *            String
	 * @param username
	 *            String
	 * @param passwrd
	 *            String
	 * @param id_num
	 *            integer
	 * @param email
	 *            String
	 * @return true if the user is registered in the database false otherwise
	 */
	public boolean registerUser(String first_name, String last_name, String username, String passwrd, int id_num,
			String email) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName
				+ " (first_name, last_name, username, passwrd, id_num, email, role_id, enabled) VALUES ('" + first_name
				+ "', '" + last_name + "', '" + username + "', '" + passwrd + "', " + id_num + ", '" + email + "', "
				+ default_role_id + ", " + enabled + ")";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
			return true;
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method checks to make sure that the username and password that are
	 * entered when logging in are from the same user
	 * 
	 * @param username
	 *            String
	 * @param password
	 *            String
	 * @return true if they match false otherwise
	 */
	public boolean checkPasswordUsernameMatch(String username, String password) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		boolean result = false;

		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "'";

		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (BCrypt.checkpw(password, rs.getString("passwrd"))) {
					result = true;
				}
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * This method will allow a user to change their password, used when they
	 * click 'forget password'
	 * 
	 * @param username
	 * @param passwrd
	 *            the new password that the user wants
	 * @param id_num
	 * @param email
	 * @return false if not able to change password
	 */
	public boolean userCheckEmailExists(String email) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT email from " + tableName + " WHERE email = '" + email + "'";
		System.out.println(sql);
		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Did not pull from email to see if it exists");
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				if (rs.getString("email").equals(email)) {
					rs.close();
					conn.close();
					dbc.closeConnection();
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Did not pull from email to see if it exists 2");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method updates the users password
	 * 
	 * @param username
	 *            String
	 * @param passwrd
	 *            String
	 * @param id_num
	 *            Integer
	 * @return true if the update was successful or false otherwise
	 */
	public boolean userUpdatePassword(String username, String passwrd, int id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET passwrd='" + passwrd + "'" + " WHERE username='" + username + "'"
				+ "and id_num='" + id_num + "'";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method gets all the users from a specific club
	 * 
	 * @param club_id_num
	 *            Integer
	 * @return A list of user models in that club
	 */
	public LinkedList<User> getAllUsersForClub(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		User user;
		LinkedList<User> userList = new LinkedList<User>();

		String sql = "SELECT u.first_name, u.last_name, u.id_num, u.email, u.iduser, u.preference, u.club_id_num FROM " + tableName
				+ " u INNER JOIN club_membership cm on u.iduser = cm.user_ID WHERE cm.club_ID = " + club_id_num
				+ " and cm.active = 1";
		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {

				user = new User(rs.getString("first_name"), rs.getString("last_name"), "", "", rs.getInt("id_num"),
						rs.getString("email"), 0, rs.getInt("iduser"), 0, rs.getString("preference"), rs.getInt("club_id_num"));
				userList.add(user);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * This method changes the users role
	 * 
	 * @param roleIDs
	 *            Integer array
	 * @param userIDs
	 *            Integer array
	 * @param clubIDs
	 *            Integer array
	 * @return true if user role is updated false otherwise
	 */
	public boolean userRoleChanges(int[] roleIDs, int[] userIDs, int[] clubIDs) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		boolean didUpdate = false;
		boolean result = true;

		String sql;
		// Take care of all board members first
		for (int j = 0; j < clubIDs.length; j++) {
			if (j == 0) {
				for (int k = 0; k < roleIDs.length; k++) {
					if (roleIDs[k] != 0) {
						if (roleIDs[k] == 2 && clubIDs[j] > 0) {
							sql = "UPDATE " + tableName + " SET role_id=" + roleIDs[k] + ", club_id_num = " + clubIDs[j]
									+ " WHERE iduser=" + userIDs[k];

							PreparedStatement ps;
							try {
								ps = conn.prepareStatement(sql);
								if (ps.executeUpdate() == 1) {
									didUpdate = true;
									sql = "UPDATE bu_club_central.club_membership" + " SET role_id=" + roleIDs[k]
											+ " WHERE user_id=" + userIDs[k];
									if (didUpdate == true) {
										ps = conn.prepareStatement(sql);
										ps.executeUpdate();
									}
									didUpdate = false;
								} else {
									throw new SQLException();
								}
							} catch (SQLException e) {
								System.out.println("Did not update");
								e.printStackTrace();
								return false;
							}
							j++;
						}
					}
				}
			}
		}
		// handle the rest
		for (int i = 0; i < roleIDs.length; i++) {
			if (roleIDs[i] != 0) {
				if (roleIDs[i] != 2) {
					sql = "UPDATE " + tableName + " SET role_id=" + roleIDs[i] + ", club_id_num = null WHERE iduser="
							+ userIDs[i];

					PreparedStatement ps;
					try {
						ps = conn.prepareStatement(sql);
						if (ps.executeUpdate() == 1) {
							didUpdate = true;
							sql = "UPDATE bu_club_central.club_membership" + " SET role_id=" + roleIDs[i]
									+ " WHERE user_id=" + userIDs[i];
							if (didUpdate == true) {
								ps = conn.prepareStatement(sql);
								ps.executeUpdate();
							}
							didUpdate = false;
						} else {
							throw new SQLException();
						}
					} catch (SQLException e) {
						System.out.println("Did not update");
						e.printStackTrace();
						return false;
					}

				}
			}
		}
		return result;
	}

	/**
	 * This method will allow a user to change their username, used when they
	 * click 'forgot username'
	 * 
	 * @param first_name
	 *            String
	 * @param last_name
	 *            String
	 * @param id_num
	 *            Integer
	 * @param username
	 *            String
	 * @return false if not able to change username
	 */
	public boolean userForgotUsernameUpdate(String first_name, String last_name, int id_num, String username) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET username='" + username + "'" + " WHERE first_name='" + first_name
				+ "'" + "and last_name='" + last_name + "'" + "and id_num='" + id_num + "'";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method updates the username
	 * 
	 * @param user_id
	 *            Integer
	 * @param username
	 *            String
	 * @return true if updated or false otherwise
	 */
	public boolean editUsername(int user_id, String username) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET username = '" + username + "' WHERE iduser =" + user_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * THis method updates the users password
	 * 
	 * @param user_id
	 *            Integer
	 * @param password
	 *            String
	 * @return true if it is updated or false otherwise
	 */
	public boolean editPassword(int user_id, String password) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET passwrd = '" + password + "' WHERE iduser =" + user_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This mehtod updates the email of the user
	 * 
	 * @param user_id
	 *            Integer
	 * @param email
	 *            String
	 * @return true if it updates the email false otherwise
	 */
	public boolean editEmail(int user_id, String email) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET email = '" + email + "' WHERE iduser =" + user_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editFirstName(int user_id, String first_name) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET first_name = '" + first_name + "' WHERE iduser =" + user_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean editLastName(int user_id, String last_name) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET last_name = '" + last_name + "' WHERE iduser =" + user_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Checks to make sure username only contains letters and numbers
	 * 
	 * @param username
	 *            String
	 * @return true if username only contains characters false otherwise
	 */
	public boolean checkUsernameChars(String username) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		char unameArray[] = username.toCharArray();
		for (int i = 0; i < unameArray.length; i++) {
			if (!Character.isLetterOrDigit(unameArray[i])) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
		}

		if (username.equals(null) || username.equals("")) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return false;
		}

		return true;
	}

	/**
	 * Checks to see if the username in the database exists
	 * 
	 * @param username
	 *            String
	 * @return true if username already exists flase otherwise
	 */
	public boolean checkUsernameExist(String username) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName;

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists");
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				if (rs.getString("username").equals(username)) {
					return true;
				}
			}
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists 2");
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Checks to make sure passwords match or returns false otherwise ie: null,
	 * spaces, empty string
	 * 
	 * @param password1
	 *            String
	 * @param password2
	 *            String
	 * @return true if passwords match or false otherwise
	 */
	public boolean checkPasswordMatch(String password1, String password2) {
		if (password1.equals(null) || password2.equals(null)) {
			return false;
		}
		if (password1.equals("") || password2.equals("")) {
			return false;
		}
		if (password1.equals(password2)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to make sure that first and last name both only contain letters
	 * 
	 * @param first_name
	 *            String
	 * @param last_name
	 *            String
	 * @return true if first and last name contain only characters or false
	 *         otherwise
	 */
	public boolean checkName(String first_name, String last_name) {
		char fnameArray[] = first_name.toCharArray();
		char lnameArray[] = last_name.toCharArray();

		if (first_name.equals(null) || last_name.equals(null)) {
			return false;
		}
		if (first_name.equals("") || last_name.equals("")) {
			return false;
		}
		for (int i = 0; i < fnameArray.length; i++) {
			if (!Character.isLetter(fnameArray[i])) {
				return false;
			}
		}

		for (int i = 0; i < lnameArray.length; i++) {
			if (!Character.isLetter(lnameArray[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks to make sure that the email is of standard format
	 * 
	 * @param email
	 *            String
	 * @return true if the email is in the right format false otherwise
	 */
	public boolean checkEmail(String email) {
		String email_format = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if (email.matches(email_format)) {
			return true;
		}
		return false;
	}

	/**
	 * Checks to make sure id num is all numbers
	 * 
	 * @param id_num
	 *            String
	 * @return true if the id number is only numbers false otherwise
	 */
	public boolean checkId_num(String id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		char[] idNumArray = id_num.toCharArray();

		if (id_num.equals(null) || id_num.equals("")) {
			return false;
		}

		for (int i = 0; i < id_num.length(); i++) {
			if (!Character.isDigit(idNumArray[i])) {
				return false;
			}
		}

		String sql = "SELECT * FROM " + tableName + " WHERE id_num='" + id_num + "'";

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists");
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				if (rs.getInt("id_num") == Integer.parseInt(id_num)) {
					rs.close();
					conn.close();
					dbc.closeConnection();
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists 2");
			e.printStackTrace();
		}
		return true;
	}

	/**
	 * This method gets the user by their email
	 * 
	 * @param email
	 *            String
	 * @return User object
	 */
	public User getUserByEmail(String email) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		User user = null;
		String sql = "SELECT * FROM " + tableName + " WHERE email='" + email + "'";

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (!rs.next()) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));

				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * This method gets a user by their username
	 * 
	 * @param username
	 *            String
	 * @return user object
	 */
	public User getUserByUsername(String username) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		User user = null;
		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "'";

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (!rs.next()) {
				rs.close();
				conn.close();
				dbc.closeConnection();
				return null;
			} else {

				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));

				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
				rs.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * This method gets all the users in the database
	 * 
	 * @return a linkedlist of user objects
	 */
	public LinkedList<User> getAllUsers() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		User user;
		LinkedList<User> userList = new LinkedList<User>();

		String sql = "SELECT * FROM " + tableName;

		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
				userList.add(user);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * Adds or removes users from club
	 * 
	 * @param add_remove
	 *            String value that is either add or remove to determine what
	 *            sql string to create
	 * @param id_num
	 *            the id number of the user that is being added/removed from
	 *            club
	 * @param club_id
	 *            the id of the club that the user is being added or removed
	 *            from
	 * @return true if successful false otherwise
	 */
	public boolean add_removeFromClub(String add_remove, String id_num, int club_id) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		PreparedStatement ps;

		if (add_remove.equals("Add")) {
			sql = "UPDATE " + tableName + " SET club_id_num='" + club_id + "' WHERE id_num=" + id_num;
		} else {
			sql = "UPDATE " + tableName + " SET club_id_num='0' WHERE id_num=" + id_num;
		}
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * Checks to make sure that value pasted in is all numbers
	 * 
	 * @param num
	 *            String num
	 * @return true if value passed in is all numeric false otherwise
	 */
	public boolean checkNumericOnly(String num) {
		char[] numArray = num.toCharArray();

		for (int i = 0; i < num.length(); i++) {
			if (!Character.isDigit(numArray[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * This method updates the users email
	 * 
	 * @param oldEmail
	 *            String
	 * @param newEmail
	 *            String
	 * @param id_num
	 *            String
	 * @return tru if the username is updated false otherwise
	 */
	public boolean editUserEmail(String oldEmail, String newEmail, String id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET email='" + newEmail + "' WHERE id_num=" + id_num;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean updatePreference(String[] preferences, int userID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String joinedPreferences = String.join(",", preferences);
		
				String sql = "UPDATE " + tableName + " SET preference='" + joinedPreferences + "' WHERE iduser=" + userID;
		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * This method gets the user by their id number
	 * 
	 * @param id_num
	 *            Integer
	 * @return user object
	 */
	public User getUserByIdNum(int id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		User user = null;
		String sql = "SELECT * FROM " + tableName + " WHERE id_num=" + id_num;

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (!rs.next()) {
				try {
					rs.close();
					conn.close();
					dbc.closeConnection();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
				rs.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * this method disables a user
	 * 
	 * @param userIdNum
	 *            Integer
	 */
	public void disableUser(int userIdNum) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET enabled = 0 WHERE id_num = " + userIdNum;

		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method gets the status of a user from their user id
	 * 
	 * @param userId
	 * @return 0 if disabled, 1 if enabled, and -1 if user not found
	 */
	public int getUserDisableEnableStatus(int userId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM USER where idUser = " + userId;
		int status = -1;
		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if (!rs.next()) {

				return -1;
			} else {
				status = rs.getInt("enabled");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	/**
	 * This methof enabled a user from their user id
	 * 
	 * @param userIdNum
	 *            Integer
	 */
	public void enableUser(int userIdNum) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET enabled = 1 WHERE id_num = " + userIdNum;

		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Display club gets the list of current clubs and adds them to a linked
	 * list. This allows them to be displayed in a JSP
	 * 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<User> displayUsers() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<User> results = new LinkedList<User>();
		String sql;

		sql = "SELECT * FROM " + tableName + " WHERE enabled = 1 and role_id <> 3";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User newUser = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
				results.add(newUser);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * This method gets a user object from a user id
	 * 
	 * @param userID
	 *            Integer
	 * @return user object
	 */
	public LinkedList<User> displayUsersInfo(int userID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<User> results = new LinkedList<User>();
		String sql;

		sql = "SELECT * FROM " + tableName + " WHERE enabled = 1 and iduser = " + userID;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				User newUser = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
				results.add(newUser);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * This method gets all the users from a club
	 * 
	 * @param clubId
	 *            Integer
	 * @return linked list of user objects for a specific club
	 */
	public LinkedList<User> getUsersByClub(int clubId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<User> userList = new LinkedList<User>();

		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num =" + clubId;

		PreparedStatement ps = null;
		ResultSet rs = null;
		User user;

		try {
			ps = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				if (rs.getInt("enabled") == 1) {
					user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
							rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
							rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
					userList.add(user);
				}
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	/**
	 * Get's the IDUser of the user based on first name, last name, and email
	 * 
	 * @param first_name
	 *            String
	 * @param last_name
	 *            String
	 * @param id_num
	 *            Integer
	 * @param email
	 *            String
	 * @return the id of the user
	 */
	public int getIDUser(String first_name, String last_name, int id_num, String email) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "";
		int userID = 0;

		sql = "SELECT iduser FROM " + tableName + " WHERE first_name = '" + first_name + "' " + " AND last_name = '"
				+ last_name + "' " + " AND id_num = '" + id_num + "' " + " AND email = '" + email + "'";

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		try {
			if (!rs.next()) {
				return 0;
			} else {
				userID = rs.getInt("iduser");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userID;
	}

	/**
	 * This method gets all member from a specific club with role id 2
	 * 
	 * @param club_id_num
	 *            Integer
	 * @return linked list of user objects
	 */
	public LinkedList<User> getAllBoardMembersForEachClub(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num = " + club_id_num + " AND role_id = 2";

		LinkedList<User> userList = new LinkedList<User>();
		User user;

		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (rs.next()) {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"), rs.getInt("club_id_num"));
				userList.add(user);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	/**
	 * set the intinal club for a new user when they first join the site
	 * @param user_id int
	 * @param club_id_num int
	 */
	public void addClubForNewUser(int user_id, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		String sql = "UPDATE " + tableName + " SET club_id_num=" + club_id_num + " WHERE id_num=" + user_id;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * 
	 * @param id_num
	 * @return
	 */
	public boolean checkForNullClubIdNum(int id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		boolean result = false;
		int value = -1;
		
		String sql = "SELECT * FROM " + tableName + " WHERE id_num=" + id_num;
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			value = rs.getInt("club_id_num");
			if (value == 0) {
				result = true;
				return result;
			}
			ps.close();
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	

}