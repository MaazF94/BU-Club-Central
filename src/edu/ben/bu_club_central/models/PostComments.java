package edu.ben.bu_club_central.models;

public class PostComments {
	private int idPostComment;
	private int postId;
	private int user_id_num;
	private String comment;
	
	public PostComments(int idPostComment, int postId, int user_id_num, String comment) {
		this.idPostComment = idPostComment;
		this.postId = postId;
		this.user_id_num = user_id_num;
		this.comment = comment;
	}

	public int getIdPostComment() {
		return idPostComment;
	}

	public void setIdPostComment(int idPostComment) {
		this.idPostComment = idPostComment;
	}

	public int getPostId() {
		return postId;
	}

	public void setPostId(int postId) {
		this.postId = postId;
	}

	public int getUser_id_num() {
		return user_id_num;
	}

	public void setUser_id_num(int user_id_num) {
		this.user_id_num = user_id_num;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
	
	

}
