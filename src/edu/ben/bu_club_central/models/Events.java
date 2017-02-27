package edu.ben.bu_club_central.models;

public class Events {
	
	private int eventId;
	private String event_name;
	private String description;
	private String location;
	private int rsvp_count;
	private int club_id_num;
	
	public Events(String event_name, String description, String location, int club_id_num){
		this.event_name = event_name;
		this.description = description;
		this.location = location;
		this.club_id_num = club_id_num;
	}
	
	
	
	
	
	
	public int getEventId() {
		return eventId;
	}






	public void setEventId(int eventId) {
		this.eventId = eventId;
	}






	public String getEvent_name() {
		return event_name;
	}






	public String getDescription() {
		return description;
	}






	public String getLocation() {
		return location;
	}






	public int getRsvp_count() {
		return rsvp_count;
	}






	public void setRsvp_count(int rsvp_count) {
		this.rsvp_count = rsvp_count;
	}






	public int getClub_id_num() {
		return club_id_num;
	}






	/**
	 * 
	 * @param event_name
	 * @param date
	 * @return int id
	 * generate an id number for the event using the ascii values of the chars making up event_name and date;
	 */
	private int createID(String event_name, String date){
		int id = 0;
		for(int i = 0; i < event_name.length(); i++){
			id += (int) event_name.charAt(i);
		}
		for(int j = 0; j < date.length(); j++){
			id += (int) date.charAt(j);
		}
		return id;
	}
}

