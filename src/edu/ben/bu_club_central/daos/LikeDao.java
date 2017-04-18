package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Likes;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LikeDao {
	private String tableName = "bu_club_central.likes";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	/**
	 * 
	 * @param idlike
	 * @param idUser
	 * @param likeCount
	 * @param idevent
	 */
	public void addLike( int idUser,  int idevent) {
		
		String sql = "INSERT INTO " + tableName + " ( idUser, idevent) VALUES ( '" + idUser
				+ "', '" + idevent + "')";

		PreparedStatement ps = null;  
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	public LinkedList<Likes> getAllLikesByEventId(int idevent) {
		LinkedList<Likes> likeList = new LinkedList<Likes>();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + idevent;
		PreparedStatement ps;
		ResultSet rs = null;
		Likes newLike;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				//newLike = new Likes(Integer.parseInt(rs.getString("idlike")), Integer.parseInt(rs.getString("idUser")), Integer.parseInt(rs.getString("idevent")) );
				//newLike.setIdlike(rs.getInt("idlike"));
				//likeList.add(newLike);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return likeList;
	}
	
	
	
	
	
	
}
