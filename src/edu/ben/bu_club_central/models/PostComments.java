package edu.ben.bu_club_central.models;

public class PostComments {
	/**
	 * private Integer class variable
	 */
	private int idPostComment;

	/**
	 * private Integer class variable
	 */
	private int postId;

	/**
	 * private Integer class variable
	 */
	private int user_id_num;

	/**
	 * private String class variable
	 */
	private String comment;

	/**
	 * Constructor
	 * 
	 * @param idPostComment
	 *            Integer
	 * @param postId
	 *            Integer
	 * @param user_id_num
	 *            Integer
	 * @param comment
	 *            String
	 */
	public PostComments(int idPostComment, int postId, int user_id_num, String comment) {
		this.idPostComment = idPostComment;
		this.postId = postId;
		this.user_id_num = user_id_num;
		this.comment = comment;
	}

	/**
	 * getter
	 * 
	 * @return id post comment Integer
	 */
	public int getIdPostComment() {
		return idPostComment;
	}

	/**
	 * setter
	 * 
	 * @param idPostComment
	 *            Integer
	 */
	public void setIdPostComment(int idPostComment) {
		this.idPostComment = idPostComment;
	}

	/**
	 * getter
	 * 
	 * @return post id Integer
	 */
	public int getPostId() {
		return postId;
	}

	/**
	 * setter
	 * 
	 * @param postId
	 *            Integer
	 */
	public void setPostId(int postId) {
		this.postId = postId;
	}

	/**
	 * getter
	 * 
	 * @return user id num Integer
	 */
	public int getUser_id_num() {
		return user_id_num;
	}

	/**
	 * setter
	 * 
	 * @param user_id_num
	 *            Integer
	 */
	public void setUser_id_num(int user_id_num) {
		this.user_id_num = user_id_num;
	}

	/**
	 * getter
	 * 
	 * @return comment String
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * setter
	 * 
	 * @param comment
	 *            String
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
