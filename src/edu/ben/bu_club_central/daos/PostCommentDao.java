package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.PostComments;


public class PostCommentDao {
	private String tableName = "post_comments";
	
	private DatabaseConnection dbc = new DatabaseConnection();
	
	private Connection conn = dbc.getConn();
	
	public void addPostComment(int postId, int user_id_num, String comment) {
		String sql = "INSERT INTO " + tableName + " (postId, user_id_num, comment) VALUES ('" + postId + "', '" + user_id_num + "', '" + comment + "')";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public LinkedList<PostComments> getAllCommentsForPost(int postId) {
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
			while(rs.next()) {
				PostComments comment = new PostComments(rs.getInt("idpost_comments"), rs.getInt("postId"), rs.getInt("user_id_num"), rs.getString("comment"));
				commentList.add(comment);
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return commentList;
	}
	
}
