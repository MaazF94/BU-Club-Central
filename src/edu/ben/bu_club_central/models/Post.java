package edu.ben.bu_club_central.models;

public class Post {
	/**
	 * private Integer class variable
	 */
	private int idpost;

	/**
	 * private String class variable
	 */
	private String title;

	/**
	 * private String class variable
	 */
	private String contents;

	/**
	 * private Integer class variable
	 */
	private int club_id_num;

	/**
	 * private Integer class variable
	 */
	private int user_id_num;

	/**
	 * private Integer class variable
	 */
	private int numOfLikes;

	/**
	 * Constructor
	 * 
	 * @param title
	 *            String
	 * @param contents
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @param user_id_num
	 *            Integer
	 */
	public Post(String title, String contents, int club_id_num, int user_id_num) {
		this.title = title;
		this.contents = contents;
		this.club_id_num = club_id_num;
		this.user_id_num = user_id_num;
	}

	/**
	 * getter
	 * 
	 * @return number of likes Integer
	 */
	public int getNumOfLikes() {
		return numOfLikes;
	}

	/**
	 * setter
	 * 
	 * @param numOfLikes
	 *            Integer
	 */
	public void setNumOfLikes(int numOfLikes) {
		this.numOfLikes = numOfLikes;
	}

	/**
	 * getter
	 * 
	 * @return id post Integer
	 */
	public int getIdpost() {
		return idpost;
	}

	/**
	 * setter
	 * 
	 * @param idpost
	 *            Integer
	 */
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}

	/**
	 * getter
	 * 
	 * @return title String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * getter
	 * 
	 * @return contents String
	 */
	public String getContents() {
		return contents;
	}

	/**
	 * getter
	 * 
	 * @return club id num Integer
	 */
	public int getClub_id_num() {
		return club_id_num;
	}

	/**
	 * getter
	 * 
	 * @return user id num Integer
	 */
	public int getUser_id_num() {
		return user_id_num;
	}

}
