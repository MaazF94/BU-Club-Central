package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.PostComments;

public class PostCommentDao {
	/**
	 * class variable for table name in database
	 */
	private String tableName = "post_comments";

	/**
	 * declaration of database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * declaration of connection
	 */
	private Connection conn;

	/**
	 * This method add a comment for a post into the database
	 * 
	 * @param postId
	 *            Integer
	 * @param user_id_num
	 *            Integer
	 * @param comment
	 *            String
	 */
	public void addPostComment(int postId, int user_id_num, String comment) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + " (postId, user_id_num, comment) VALUES ('" + postId + "', '"
				+ user_id_num + "', '" + comment + "')";

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
	 * This method gets all the comments for a specific post
	 * 
	 * @param postId
	 *            Integer
	 * @return linked list of post comment objects
	 */
	public LinkedList<PostComments> getAllCommentsForPost(int postId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE postId=" + postId;

		LinkedList<PostComments> commentList = new LinkedList<PostComments>();

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
				PostComments comment = new PostComments(rs.getInt("idpost_comments"), rs.getInt("postId"),
						rs.getInt("user_id_num"), rs.getString("comment"));
				commentList.add(comment);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

}
