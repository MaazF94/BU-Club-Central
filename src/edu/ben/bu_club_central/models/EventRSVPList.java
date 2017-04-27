package edu.ben.bu_club_central.models;

public class EventRSVPList {
	/**
	 * private Integer class variable
	 */
	private int idevent_rsvp_list;

	/**
	 * private Integer class variable
	 */
	private int eventId;

	/**
	 * private Integer class variable
	 */
	private int user_id_num;

	/**
	 * Constructor
	 * 
	 * @param idevent_rsvp_list
	 *            Integer
	 * @param eventId
	 *            Integer
	 * @param user_id_num
	 *            Integer
	 */
	public EventRSVPList(int idevent_rsvp_list, int eventId, int user_id_num) {
		this.idevent_rsvp_list = idevent_rsvp_list;
		this.eventId = eventId;
		this.user_id_num = user_id_num;
	}

	/**
	 * getter
	 * 
	 * @return id event rsvp list Integer
	 */
	public int getIdevent_rsvp_list() {
		return idevent_rsvp_list;
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
	 * @return user id num Integer
	 */
	public int getUser_id_num() {
		return user_id_num;
	}

}
