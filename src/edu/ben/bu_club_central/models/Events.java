package edu.ben.bu_club_central.models;

public class Events {
	/**
	 * private Integer class variable
	 */
	private int eventId;

	/**
	 * private String class variable
	 */
	private String event_name;

	/**
	 * private String class variable
	 */
	private String description;

	/**
	 * private String class variable
	 */
	private String location;

	/**
	 * private Integer class variable
	 */
	private int rsvp_count;

	/**
	 * private Integer class variable
	 */
	private int club_id_num;

	/**
	 * private Integer class variable
	 */
	private int acutal_count;

	/**
	 * private String class variable
	 */
	private String category;

	/**
	 * Constructor
	 * 
	 * @param event_name
	 *            String
	 * @param description
	 *            String
	 * @param location
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @param category
	 *            String
	 */
	public Events(String event_name, String description, String location, int club_id_num, String category) {
		this.event_name = event_name;
		this.description = description;
		this.location = location;
		this.club_id_num = club_id_num;
		this.category = category;
	}

	/**
	 * getter
	 * 
	 * @return actual count Integer
	 */
	public int getAcutal_count() {
		return acutal_count;
	}

	/**
	 * setter
	 * 
	 * @param acutal_count
	 *            Integer
	 */
	public void setAcutal_count(int acutal_count) {
		this.acutal_count = acutal_count;
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
	 * @return rsvp count Integer
	 */
	public int getRsvp_count() {
		return rsvp_count;
	}

	/**
	 * setter
	 * 
	 * @param rsvp_count
	 *            Integer
	 */
	public void setRsvp_count(int rsvp_count) {
		this.rsvp_count = rsvp_count;
	}

	/**
	 * 
	 * @param event_name
	 *            String
	 * @param date
	 *            String
	 * @return int id generate an id number for the event using the ascii values
	 *         of the chars making up event_name and date;
	 */
	private int createID(String event_name, String date) {
		int id = 0;
		for (int i = 0; i < event_name.length(); i++) {
			id += (int) event_name.charAt(i);
		}
		for (int j = 0; j < date.length(); j++) {
			id += (int) date.charAt(j);
		}
		return id;
	}

	/**
	 * @return the event_name
	 */
	public String getEvent_name() {
		return event_name;
	}

	/**
	 * @param event_name
	 *            the event_name to set
	 */
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location
	 *            the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the club_id_num
	 */
	public int getClub_id_num() {
		return club_id_num;
	}

	/**
	 * @param club_id_num
	 *            the club_id_num to set
	 */
	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}

	/**
	 * getter
	 * 
	 * @return category String
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * setter
	 * 
	 * @param category
	 *            String
	 */
	public void setCategory(String category) {
		this.category = category;
	}
}
