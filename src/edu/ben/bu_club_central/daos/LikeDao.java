package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Likes;
import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class LikeDao {
	/**
	 * table name in database
	 */
	private String tableName = "bu_club_central.likes";

	/**
	 * database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * connection
	 */
	private Connection conn;

	/**
	 * This mehtod adds a like
	 * 
	 * @param idUser
	 *            Integer
	 * @param idevent
	 *            Integer
	 */
	public void addLike(int idUser, int idevent) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + " ( idUser, idevent) VALUES ( '" + idUser + "', '" + idevent + "')";

		PreparedStatement ps = null;
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
	 * This method gets all like for events
	 * 
	 * @param idevent
	 *            Integer
	 * @return linked list of likes objects
	 */
	public LinkedList<Likes> getAllLikesByEventId(int idevent) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			while (rs.next()) {
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return likeList;
	}

}
