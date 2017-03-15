package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Post;

public class PostDao {
	private String tableName = "bu_club_central.post";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	/**
	 * This method adds a post to the database
	 * @param title String name of post
	 * @param contents String the description of post
	 * @param club_id_num int id number of club that the post belongs to
	 * @param user_id_num int id number of user who created post
	 */
	public void addPost(String title, String contents, int club_id_num, int user_id_num) {
		String sql = "INSERT INTO " + tableName + " (title, contents, club_id_num, id_num_of_user) VALUES ('" + title + "', '" + contents
				+ "', '" + club_id_num + "', '" + user_id_num + "')";

		PreparedStatement ps = null;  
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	public LinkedList<Post> getAllPostsByClubId(int club_id_num) {
		LinkedList<Post> postList = new LinkedList<Post>();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + club_id_num;
		
		PreparedStatement ps;
		ResultSet rs = null;
		Post newPost;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				newPost = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"), rs.getInt("id_num_of_user"));
				newPost.setIdpost(rs.getInt("idpost"));
				postList.add(newPost);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return postList;
	}
	
	public LinkedList<Post> getAllPosts() {
		LinkedList<Post> postList = new LinkedList<Post>();
		String sql = "SELECT * FROM " + tableName;
		
		PreparedStatement ps;
		ResultSet rs = null;
		Post newPost;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while(rs.next()) {
				newPost = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"), rs.getInt("id_num_of_user"));
				newPost.setIdpost(rs.getInt("idpost"));
				postList.add(newPost);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return postList;
	}
	
	public Post getPostByPostId(int idPost) {
		String sql = "SELECT * FROM " + tableName + " WHERE idpost=" + idPost;
		
		Post post = null;
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs.next();
			post = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"), rs.getInt("id_num_of_user"));
			post.setIdpost(rs.getInt("idpost"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return post;
	}
	
	
	public void editPost(int idpost, String title, String contents) {
		String sql = "UPDATE " + tableName + " SET title='" + title + "', contents='" + contents + "' WHERE idpost=" + idpost;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deletePost(int idpost) {
		String sql = "DELETE FROM " + tableName + " WHERE idpost=" + idpost;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}
