package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Post;

public class PostDao {
	/**
	 * class variable for the table name in the database
	 */
	private String tableName = "bu_club_central.post";

	/**
	 * Declaration of database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * declaration of connection
	 */
	private Connection conn;

	/**
	 * This method adds a post to the database
	 * 
	 * @param title
	 *            String name of post
	 * @param contents
	 *            String the description of post
	 * @param club_id_num
	 *            int id number of club that the post belongs to
	 * @param user_id_num
	 *            int id number of user who created post
	 */
	public void addPost(String title, String contents, int club_id_num, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + " (title, contents, club_id_num, id_num_of_user) VALUES ('" + title
				+ "', '" + contents + "', '" + club_id_num + "', '" + user_id_num + "')";

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
	 * This mehtod gets all the posts for a specific club
	 * 
	 * @param club_id_num
	 *            Integer
	 * @return linked list of post objects
	 */
	public LinkedList<Post> getAllPostsByClubId(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			while (rs.next()) {
				newPost = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"),
						rs.getInt("id_num_of_user"));
				newPost.setIdpost(rs.getInt("idpost"));
				newPost.setNumOfLikes(rs.getInt("numOfLikes"));
				postList.add(newPost);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;
	}

	/**
	 * This method gets all posts in the database
	 * 
	 * @return linked list of post objects
	 */
	public LinkedList<Post> getAllPosts() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			while (rs.next()) {
				newPost = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"),
						rs.getInt("id_num_of_user"));
				newPost.setIdpost(rs.getInt("idpost"));
				newPost.setNumOfLikes(rs.getInt("numOfLikes"));
				postList.add(newPost);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postList;
	}

	/**
	 * This method gets a post from a specific post id
	 * 
	 * @param idPost
	 *            Integer
	 * @return post object
	 */
	public Post getPostByPostId(int idPost) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			post = new Post(rs.getString("title"), rs.getString("contents"), rs.getInt("club_id_num"),
					rs.getInt("id_num_of_user"));
			post.setIdpost(rs.getInt("idpost"));
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	/**
	 * This method lets you edit a post
	 * 
	 * @param idpost
	 *            Integer
	 * @param title
	 *            String
	 * @param contents
	 *            String
	 */
	public void editPost(int idpost, String title, String contents) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET title='" + title + "', contents='" + contents + "' WHERE idpost="
				+ idpost;

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
	 * This method deletes a post
	 * 
	 * @param idpost
	 *            Integer
	 */
	public void deletePost(int idpost) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "DELETE FROM " + tableName + " WHERE idpost=" + idpost;

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
	 * This method will increase the like ount for a post
	 * 
	 * @param postId
	 *            Integer
	 */
	public void likePost(int postId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE idpost=" + postId;
		int numLikes = 0;
		PreparedStatement ps, ps2;
		ResultSet rs;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			numLikes = rs.getInt("numOfLikes");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		numLikes = numLikes + 1;
		String sql2 = "UPDATE " + tableName + " SET numOfLikes=" + numLikes + " WHERE idpost=" + postId;
		try {
			ps2 = conn.prepareStatement(sql2);
			ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
