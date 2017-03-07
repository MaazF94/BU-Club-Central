package edu.ben.bu_club_central.daos;
import mailDispatcher.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;


import edu.ben.bu_club_central.models.User;

public class UserDao {
	private String tableName = "bu_club_central.user";
	private int enabled = 1;
	private int disabled = 0;

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	// Register user method works
	public void registerUser(String first_name, String last_name, String username, String passwrd, int id_num,
			String email) {
		String sql = "INSERT INTO " + tableName
				+ " (first_name, last_name, username, passwrd, id_num, email, enabled) VALUES ('" + first_name + "', '"
				+ last_name + "', '" + username + "', '" + passwrd + "', '" + id_num + "', '" + email + "', '" + enabled
				+ "')";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
		// send email to a newly registered user
		//come back later to this and use html in your email to make it look better and expand the message some more.
		String subject = "Thank You for Registering " + first_name + "!";
		String content = "Hello <h1>" + first_name + "</h1>,\n";
		content += "\n\n";
		content += "We'd like to thank you for registering for Club Central! There are multiple things you can do here at\n";
		content += "Club Central, such as, RSVP for events, join a club, get notified of events you're RSVP'ed to. And much more!\n";
		content += "\nWe hope you enjoy using the website!\n";
		content += "\n\nRegards,";
		content += "\n BU Club Central";
		SendMail.email("BUclubcentral@gmail.com", username, "thefirm123", email, subject, content);
		
	}
	/**
	 * This method will allow a user to change their password, used when they click 'forget password'
	 * @param username
	 * @param passwrd the new password that the user wants
	 * @param id_num
	 * @param email
	 * @return false if not able to change password
	 */
	public boolean userPasswordChange(String username, String passwrd, int id_num, String email) {
		String sql = "UPDATE " + tableName + " SET passwrd='" + passwrd + "'" + " WHERE username='" + username + "'" + "and id_num='" + id_num + "'" + "and email='"
		+ email + "'";
		
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
	/**
	 * This method will allow a user to change their username, used when they click 'forgot username'
	 * @param first_name
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @param username
	 * @return false if not able to change username
	 */
	public boolean userUsernameChange(String first_name, String last_name, int id_num, String email, String username) {
		String sql = "UPDATE " + tableName + " SET username='" + username + "'" + " WHERE first_name='" + first_name + "'" 
	     + "and last_name='" + last_name + "'" + "and id_num='" + id_num + "'" + "and email='" + email + "'";
		
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

	/**
	 * This method will allow a user to "join" a club. Implemented on the Join A Club page.
	 * @param first_name
	 * @param last_name
	 * @param id_num
	 * @param email
	 * @param club_id_num
	 * @return false if not able to join
	 */
	public boolean userJoinClub(String first_name, String last_name, int id_num, String email, int club_id_num) {
		String sql;
		sql = "UPDATE " + tableName + " SET club_id_num='" + club_id_num + "'" + " WHERE first_name='" + first_name + "'" 
			     + "and last_name='" + last_name + "'" + "and id_num='" + id_num + "'" + "and email='" + email + "'";
				
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
				return false;
			}
		}

		if (username.equals(null) || username.equals("")) {
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
		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "'";

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
			}else {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
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
			while(rs.next()) {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
	}

	/**
	 * Adds or removes users from club 
	 * @param add_remove String value that is either add or remove to determine what sql string to create
	 * @param id_num the id number of the user that is being added/removed from club
	 * @param club_id the id of the club that the user is being added or removed from
	 * @return
	 */
	public boolean add_removeFromClub(String add_remove, String id_num, int club_id) {
		String sql;
		PreparedStatement ps;
		
		
		if(add_remove.equals("Add")) {
			sql = "UPDATE " + tableName + " SET club_id_num='" + club_id + "' WHERE id_num=" + id_num;
		}else {
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
	 * @param num String num 
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
				return null;
			}else {
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"));
				user.setRole_id(rs.getInt("role_id"));
				user.setClub_id_num(rs.getInt("club_id_num"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}
	
	
	
	
	
	
	
	
	
	
}
