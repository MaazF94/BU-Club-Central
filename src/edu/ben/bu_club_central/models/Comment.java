package edu.ben.bu_club_central.models;

public class Comment {
	private int idcomment;
	private String comment;
	private int eventId;
	private int userId;
	
	public Comment(int idcomment, String comment, int eventId, int userId) {
		this.idcomment = idcomment;
		this.comment = comment;
		this.eventId = eventId;
		this.userId = userId;
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
	
	
}
