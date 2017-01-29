package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDao {
	private String tableName = "bu_club_central.user";
	private int enabled = 1;
	private int disabled = 0;
	

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

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
	
	public boolean checkUsernameChars(String username) {
		char unameArray [] = username.toCharArray();
		for (int i = 0; i < unameArray.length; i++) {
			if(!Character.isLetterOrDigit(unameArray[i])) {
				return false;
			}
		}
		return true;
	}
	
	public boolean checkUsernameExist(String username) {
		String sql = "SELECT * FROM " + tableName + " WHERE username='" + username + "'";
		return true;
	}
	
	
	public boolean checkPasswordMatch(String password1, String password2) {
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

	public boolean checkEmail() {
		return true;
	}
	
	
	
	
	
}
