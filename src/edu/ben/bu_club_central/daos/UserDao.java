package edu.ben.bu_club_central.daos;
import mailDispatcher.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import edu.ben.bu_club_central.models.User;

public class UserDao {
	private String tableName = "bu_club_central.user";
	private int enabled = 1;
	private int disabled = 0;
	private User userObject;

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

	
	public boolean userLogin(String username, String password) {
		userObject = null;
		System.out.println(username + " " + password);
		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "' and passwrd='" + password + "'";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
//			System.out.println(rs.getString("username"));
			if(!rs.next()) {
				System.out.println("Null user");
				return false;
			}else {
				userObject = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"), rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"));
				userObject.setRole_id((Integer) rs.getInt("role_id"));
				userObject.setClub_id_num((Integer) rs.getInt("club_id_num"));
			}
		} catch (SQLException e) {
			System.out.println("Did not login");
			e.printStackTrace();
		}
		return true;
	}

	public User getUserObject() {
		return userObject;
	}
}
