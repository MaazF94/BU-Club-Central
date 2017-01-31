package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private String username = "root";
	private String password = "root";
	private String url ="jdbc:mysql://localhost:3306/bu_club_central";

	private Connection conn = null;
	
	public DatabaseConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			try {
				conn = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {
				System.out.println("Cant get connection");
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			System.out.println("Driver manager not foun");
			e.printStackTrace();
		}
	}

	public Connection getConn() {
		return conn;
	}
	
	public void closeConnection() {
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println("Cant close connection");
			e.printStackTrace();
		}
	}
	
	
}
