package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserDao {
	private String tableName = "bu_club_central.user";
	private int enabled = 1;
	private int disabled = 0;
	

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	//Register user method works
	public void registerUser(String first_name, String last_name, String username, String passwrd, int id_num,
			String email) {
		String sql = "INSERT INTO " + tableName + " (first_name, last_name, username, passwrd, id_num, email, enabled) VALUES ('"
				+ first_name + "', '" + last_name + "', '" + username + "', '" + passwrd + "', '" + id_num + "', '"
				+ email + "', '" + enabled + "')";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
	}
	
	/**
	 * Checks to make sure username only contains letters and numbers
	 * @param username
	 * @return true or false
	 */
	public boolean checkUsernameChars(String username) {
		char unameArray [] = username.toCharArray();
		for (int i = 0; i < unameArray.length; i++) {
			if(!Character.isLetterOrDigit(unameArray[i])) {
				return false;
			}
		}
		
		if(username.equals(null) || username.equals("")) {
			return false;
		}
		return true;
	}
	
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
			while(rs.next()) {
				if(rs.getString("username").equals(username)) {
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
	 * Checks to make sure passwords match or returns false otherwise
	 * ie: null, spaces, empty string
	 * @param password1
	 * @param password2
	 * @return true if passwords match or false
	 */
	public boolean checkPasswordMatch(String password1, String password2) {
		if(password1.equals(null) || password2.equals(null)) {
			return false;
		}
		
		if(password1.equals("") || password2.equals("")) {
			return false;
		}
		
		if(password1.equals(password2)) {
			return true;
		}
		return false;
	}
	
	public boolean checkName(String first_name, String last_name) {
		char fnameArray [] = first_name.toCharArray();
		char lnameArray [] = last_name.toCharArray();
		
		
		if(first_name.equals(null) || last_name.equals(null)) {
			return false;
		}
		
		for(int i = 0; i < fnameArray.length; i++) {
			if(!Character.isLetter(fnameArray[i])) {
				return false;
			}
		}
		
		for(int i = 0; i < lnameArray.length; i++) {
			if(!Character.isLetter(lnameArray[i])) {
				return false;
			}
		}
		
		return true;
	}

	public boolean checkEmail(String email) {
//		InternetAddress email = new InternetAddress(email);
		
		return true;
	}
	
	
	
	
	
}
