package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.Locale;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import edu.ben.bu_club_central.models.Comment;

public class CommentDao {
	/**
	 * database table name
	 */
	private String tableName = "bu_club_central.comments";

	/**
	 * database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * connection
	 */
	private Connection conn;

	/**
	 * adds a comment
	 * 
	 * @param comment
	 *            String
	 * @param eventId
	 *            Integer
	 * @param userId
	 *            Integer
	 */
	public void addComent(String comment, int eventId, int userId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + "(comment, eventId, userId) VALUES ('" + comment + "', '" + eventId
				+ "', '" + userId + "')";
		System.out.println(sql);
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

	/**
	 * gets all comments for an event
	 * 
	 * @param eventId
	 *            Integer
	 * @return linked list of comment objects
	 */
	public LinkedList<Comment> getCommentsByEventId(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE eventId=" + eventId;

		LinkedList<Comment> commentList = new LinkedList<Comment>();
		Comment c;
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
				c = new Comment(rs.getInt("idcomments"), rs.getString("comment"), rs.getInt("eventId"),
						rs.getInt("userId"), rs.getString("createdOn"));
				commentList.add(c);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return commentList;
	}

	/**
	 * gets a comment by its id
	 * 
	 * @param commentId
	 *            Integer
	 * @return comment object
	 */
	public Comment getCommentByCommentId(int commentId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE idcomments=" + commentId;

		PreparedStatement ps;
		ResultSet rs = null;
		Comment comment = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			rs.next();
			comment = new Comment(rs.getInt("idcomments"), rs.getString("comment"), rs.getInt("eventId"),
					rs.getInt("userId"), rs.getString("createdOn"));
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comment;

	}

	/**
	 * edits comment
	 * 
	 * @param commentId
	 *            Integer
	 * @param comment
	 *            String
	 */
	public void editComment(int commentId, String comment) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET comment='" + comment + "' WHERE idcomments=" + commentId;

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

	/**
	 * deletes comment
	 * 
	 * @param commentId
	 *            Integer
	 */
	public void deleteComment(int commentId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "DELETE FROM " + tableName + " WHERE idcomments=" + commentId;

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

	/**
	 * adds a like to a comment
	 * 
	 * @param commentId
	 *            Integer
	 * @param currentLikes
	 *            Integer
	 */
	public void addLikeToComment(int commentId, int currentLikes) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET likesCount=  likesCount + 1 WHERE idcomments=" + commentId;

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

	/**
	 * gets the total number of likes for a comment
	 * 
	 * @param commentId
	 *            Integer
	 * @return Integer number of likes
	 */
	public int getNumOfLikes(int commentId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT likesCount from " + tableName + " WHERE idcomments= '" + commentId + "'";

		int likes = 0;
		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {

				likes = rs.getInt("likesCount");
			}
			;
			rs.close();
			conn.close();
			dbc.closeConnection();
			return likes;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * parses the data in the database
	 * 
	 * @param date
	 *            String
	 * @return String date
	 * @throws Exception
	 *             exception
	 */
	public String getparsedDate(String date) throws Exception {

		DateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss", Locale.US);
		String s1 = date;
		String s2 = null;
		java.util.Date d;
		try {
			d = sdf.parse(s1);
			s2 = (new SimpleDateFormat("MM/yyyy")).format(d);

		} catch (ParseException e) {

			e.printStackTrace();
		}

		return s2;

	}

}
