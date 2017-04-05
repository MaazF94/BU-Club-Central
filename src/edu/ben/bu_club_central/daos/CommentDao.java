package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Comment;


public class CommentDao {

	private String tableName = "bu_club_central.comments";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();
	
	public void addComent(String comment, int eventId, int userId) {
		String sql = "INSERT INTO " + tableName + "(comment, eventId, userId) VALUES ('" + comment + "', '" + eventId + "', '" + userId + "')";
		System.out.println(sql);
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public LinkedList<Comment> getCommentsByEventId(int eventId) {
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
			while(rs.next()) {
				c = new Comment(rs.getInt("idcomments"), rs.getString("comment"), rs.getInt("eventId"), rs.getInt("userId"), rs.getString("createdOn"));
				commentList.add(c);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commentList;
	}
	
	
	public Comment getCommentByCommentId(int commentId) {
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
				comment = new Comment(rs.getInt("idcomments"), rs.getString("comment"), rs.getInt("eventId"), rs.getInt("userId"), rs.getString("createdOn"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return comment;
		
	}
	
	
	public void editComment(int commentId, String comment) {
		String sql = "UPDATE " + tableName + " SET comment='" + comment + "' WHERE idcomments=" + commentId;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteComment(int commentId) {
		String sql = "DELETE FROM " + tableName + " WHERE idcomments=" + commentId;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	
}
