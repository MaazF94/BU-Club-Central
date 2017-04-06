package edu.ben.bu_club_central.models;

public class EventNotification {
	
	private int eventId;
	private int userId;
	private boolean flag;
	
	public EventNotification(int eventId, int userId) {
		this.eventId = eventId;
		this.userId = userId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
	

}
