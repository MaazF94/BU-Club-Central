package edu.ben.bu_club_central.models;

public class EventNotification {
	/**
	 * private Integer class variable
	 */
	private int eventId;

	/**
	 * private Integer class variable
	 */
	private int userId;

	/**
	 * private boolean class variable
	 */
	private boolean flag;

	/**
	 * Constructor
	 * 
	 * @param eventId
	 *            Integer
	 * @param userId
	 *            Integer
	 */
	public EventNotification(int eventId, int userId) {
		this.eventId = eventId;
		this.userId = userId;
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
	 * setter
	 * 
	 * @param eventId
	 *            Integer
	 */
	public void setEventId(int eventId) {
		this.eventId = eventId;
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
	 * setter
	 * 
	 * @param userId
	 *            Integer
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * 
	 * @return flag boolean
	 */
	public boolean isFlag() {
		return flag;
	}

	/**
	 * setter
	 * 
	 * @param flag
	 *            boolean
	 */
	public void setFlag(boolean flag) {
		this.flag = flag;
	}

}
