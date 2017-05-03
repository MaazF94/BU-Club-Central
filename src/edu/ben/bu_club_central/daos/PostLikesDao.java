package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PostLikesDao {
	private String tableName = "post_likes";

	
	/**
	 * intializes connection to database
	 */
	private DatabaseConnection dbc;
	/**
	 * connects to the database
	 */
	private Connection conn;
	
	
	/**
	 * 
	 * @param post_id Integer
	 * @param user_id_num Integer
	 */
	public void addPostLike(int post_id, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		String sql = "INSERT INTO " + tableName + "(post_id, user_id_num) VALUES (" + post_id + ", " + user_id_num + ")";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 
	 * @param post_id
	 * @param user_id_num
	 * @return
	 */
	public boolean userLikedPost(int post_id, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		String sql = "SELECT * FROM " + tableName + " WHERE post_id=" + post_id + " AND user_id_num=" + user_id_num;
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			if (rs.next()) {
				ps.close();
				rs.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
		
	}
	
	/**
	 * 
	 * @param post_id
	 * @param user_id_num
	 */
	public void unLikePost(int post_id, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		String sql = "DELETE FROM " + tableName + " WHERE post_id=" + post_id + " AND user_id_num=" + user_id_num;
		
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


}
