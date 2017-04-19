package edu.ben.bu_club_central.daos;

import mailDispatcher.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;
import jbcrypt.BCrypt;

public class UserDao {
	private String tableName = "user";
	private int enabled = 1;
	private int disabled = 0;
	private int default_user_id = 1;

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	// Register user method works
	public boolean registerUser(String first_name, String last_name, String username, String passwrd, int id_num,
			String email) {
		String sql = "INSERT INTO " + tableName
				+ " (first_name, last_name, username, passwrd, id_num, email, role_id, enabled) VALUES ('" + first_name
				+ "', '" + last_name + "', '" + username + "', '" + passwrd + "', " + id_num + ", '" + email + "', "
				+ default_user_id + ", " + enabled + ")";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		
		return false;
	}
	
	public boolean checkPasswordUsernameMatch(String username, String password) {
		boolean result = false;
		
		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "'";
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				if(BCrypt.checkpw(password, rs.getString("passwrd"))) {
					result = true;
				}
			}
			rs.close();
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
	public boolean userPasswordChange(String username, String passwrd, int id_num, String email) {
		String sql = "UPDATE " + tableName + " SET passwrd='" + passwrd + "'" + " WHERE username='" + username + "'"
				+ "and id_num='" + id_num + "'" + "and email='" + email + "'";
		System.out.println(sql);
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
	 * This method will allow the admin to change the user role ID
	 * 
	 * @param first_name
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @param userIDs
	 * @return true or false
	 */
	public boolean userRoleChanges(int[] roleIDs, int[] userIDs, int[] clubIDs) {
		boolean didUpdate = false;
		boolean result = true;

		String sql;
		// Take care of all board members first
		for (int j = 0; j < clubIDs.length; j++) {
			if (j == 0) {
				for (int k = 0; k < roleIDs.length; k++) {
					if (roleIDs[k] != 0) {
						if (roleIDs[k] == 2) {
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
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @param username
	 * @return false if not able to change username
	 */
	public boolean userUsernameChange(String first_name, String last_name, int id_num, String email, String username) {
		String sql = "UPDATE " + tableName + " SET username='" + username + "'" + " WHERE first_name='" + first_name
				+ "'" + "and last_name='" + last_name + "'" + "and id_num='" + id_num + "'" + "and email='" + email
				+ "'";

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

	public boolean editUsername(int user_id, String username) {
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

	public boolean editPassword(int user_id, String password) {
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

	public boolean editEmail(int user_id, String email) {
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

	/**
	 * Checks to make sure username only contains letters and numbers
	 * 
	 * @param username
	 * @return true or false
	 */
	// Test cases created
	public boolean checkUsernameChars(String username) {
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
	 * @return
	 */
	public boolean checkUsernameExist(String username) {
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
	 * @param password2
	 * @return true if passwords match or false
	 */
	// Test cases created
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
	 * @param last_name
	 * @return
	 */
	// Test cases created for this method
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
	 * @return
	 */
	// Tests cases created for this method
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
	 * @return
	 */
	public boolean checkId_num(String id_num) {
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
					
					return false;
				}
			}
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists 2");
			e.printStackTrace();
		}
		
		return true;
	}

	public User getUserByUsername(String username) {
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
				
				return null;
			} else {
				// user = new User(rs.getString("first_name"),
				// rs.getString("last_name"), rs.getString("username"),
				// rs.getString("passwrd"), rs.getInt("id_num"),
				// rs.getString("email"), rs.getInt("role_id"),
				// rs.getInt("iduser"));

				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));

				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
				rs.close();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	public LinkedList<User> getAllUsers() {
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
						rs.getInt("iduser"), rs.getInt("enabled"));

				// user.setRole_id(rs.getInt("role_id"));
				// user.setEnabled(rs.getInt("enabled"));
				userList.add(user);
			}
			rs.close();
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
	 * @return
	 */
	public boolean add_removeFromClub(String add_remove, String id_num, int club_id) {
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

	public boolean editUserEmail(String oldEmail, String newEmail, String id_num) {
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

	public User getUserByIdNum(int id_num) {
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
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return null;
			} else {
				// user = new User(rs.getString("first_name"),
				// rs.getString("last_name"), rs.getString("username"),
				// rs.getString("passwrd"), rs.getInt("id_num"),
				// rs.getString("email"), rs.getInt("role_id"),
				// rs.getInt("iduser"));

				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));
				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}

	public void deleteUser(String id_num) {

		String sql = "SELECT * FROM " + tableName;

		try {
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				PreparedStatement ps;

				ps = conn.prepareStatement("DELETE FROM " + tableName + " WHERE id_num = " + id_num);

				System.out.println(ps);

				ps.executeUpdate();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void disableUser(int userIdNum) {
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

	public int getUserDisableEnableStatus(int userId) {
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return status;
	}

	public void enableUser(int userIdNum) {
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

	public LinkedList<User> getAllUsersForClub(int club_id_num) {
		User user;
		LinkedList<User> userList = new LinkedList<User>();

		String sql = "SELECT * FROM " + tableName + "  WHERE club_id_num = " + club_id_num;
		System.out.println(sql);

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
				// user = new User(rs.getString("first_name"),
				// rs.getString("last_name"), rs.getString("username"),
				// rs.getString("passwrd"), rs.getInt("id_num"),
				// rs.getString("email"), rs.getInt("role_id"),
				// rs.getInt("iduser"));

				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));
				userList.add(user);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	/**
	 * Display club gets the list of current clubs and adds them to a linked
	 * list. This allows them to be displayed in a JSP
	 * 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<User> displayUsers() {
		LinkedList<User> results = new LinkedList<User>();
		String sql;

		sql = "SELECT * FROM " + tableName + " WHERE enabled = 1 and role_id <> 3";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				// User newUser = new
				// User(cs.getString("first_name"),cs.getString("last_name"),
				// cs.getString("username"), cs.getString("passwrd"),
				// cs.getInt("id_num"), cs.getString("email"),
				// cs.getInt("role_id"), cs.getInt("iduser"));
				User newUser = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));

				results.add(newUser);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}

	public LinkedList<User> displayUsersInfo(int userID) {
		LinkedList<User> results = new LinkedList<User>();
		String sql;

		sql = "SELECT * FROM " + tableName + " WHERE enabled = 1 and iduser = " + userID;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {

				// User newUser = new
				// User(cs.getString("first_name"),cs.getString("last_name"),
				// cs.getString("username"), cs.getString("passwrd"),
				// cs.getInt("id_num"), cs.getString("email"),
				// cs.getInt("role_id"), cs.getInt("iduser"));
				User newUser = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));

				results.add(newUser);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return results;
	}

	public LinkedList<User> getUsersByClub(int clubId) {
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
					// user = new User (rs.getString("first_name"),
					// rs.getString("last_name"), rs.getString("username"),
					// rs.getString("passwrd"), rs.getInt("id_num"),
					// rs.getString("email"),
					// rs.getInt("role_id"), rs.getInt("enabled"));

					user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
							rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
							rs.getInt("iduser"), rs.getInt("enabled"));

					// user.setRole_id(rs.getInt("role_id"));
					userList.add(user);
				}

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	/**
	 * Get's the IDUser of the user based on first name, last name, and email
	 * 
	 * @param first_name
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @return the id of the user
	 */
	public int getIDUser(String first_name, String last_name, int id_num, String email) {
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

	public LinkedList<User> getAllBoardMembersForEachClub(int club_id_num) {
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
				// user = new User(rs.getString("first_name"),
				// rs.getString("last_name"), rs.getString("username"),
				// rs.getString("passwrd"), rs.getInt("id_num"),
				// rs.getString("email"),
				// rs.getInt("role_id"), rs.getInt("enabled"));

				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"));

				userList.add(user);

			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;

	}

}