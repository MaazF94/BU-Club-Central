package edu.ben.bu_club_central.models;

public class Comment {
	/**
	 * private Integer class variable
	 */
	private int idcomment;

	/**
	 * private String class variable
	 */
	private String comment;

	/**
	 * private Integer class variable
	 */
	private int eventId;

	/**
	 * private Integer class variable
	 */
	private int userId;

	/**
	 * private String class variable
	 */
	private String createdOn;

	/**
	 * Constructor
	 * 
	 * @param idcomment
	 *            Integer
	 * @param comment
	 *            String
	 * @param eventId
	 *            Integer
	 * @param userId
	 *            Intger
	 * @param createdOn
	 *            String
	 */
	public Comment(int idcomment, String comment, int eventId, int userId, String createdOn) {
		this.idcomment = idcomment;
		this.comment = comment;
		this.eventId = eventId;
		this.userId = userId;
		this.createdOn = createdOn;
	}

	/**
	 * getter
	 * 
	 * @return id comment Integer
	 */
	public int getIdcomment() {
		return idcomment;
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
	 * getter
	 * 
	 * @return event id Integer
	 */
	public int getEventId() {
		return eventId;
	}

	/**
	 * getter
	 * 
	 * @return user id Integer
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * getter
	 * 
	 * @return created on String
	 */
	public String getCreatedOn() {
		return createdOn;
	}

	/**
	 * setter
	 * 
	 * @param createdOn
	 *            String
	 */
	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

}
