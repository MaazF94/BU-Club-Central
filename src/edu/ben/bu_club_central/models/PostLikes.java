package edu.ben.bu_club_central.models;

public class PostLikes {
	private int idpost_likes;
	private int post_id;
	private int user_id_num;
	
	public PostLikes(int post_id, int user_id_num) {
		this.post_id = post_id;
		this.user_id_num = user_id_num;
	}

	public int getIdpost_likes() {
		return idpost_likes;
	}

	public void setIdpost_likes(int idpost_likes) {
		this.idpost_likes = idpost_likes;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getUser_id_num() {
		return user_id_num;
	}

	public void setUser_id_num(int user_id_num) {
		this.user_id_num = user_id_num;
	}
	
	

}
