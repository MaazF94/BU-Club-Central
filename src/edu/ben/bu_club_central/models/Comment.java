package edu.ben.bu_club_central.models;

public class Comment {
	private int idcomment;
	private String comment;
	private int eventId;
	private int userId;
	private String createdOn;
	
	public Comment(int idcomment, String comment, int eventId, int userId, String createdOn) {
		this.idcomment = idcomment;
		this.comment = comment;
		this.eventId = eventId;
		this.userId = userId;
		this.createdOn = createdOn;
	}

	public int getIdcomment() {
		return idcomment;
	}

	public String getComment() {
		return comment;
	}

	public int getEventId() {
		return eventId;
	}

	public int getUserId() {
		return userId;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}
	
	
}
