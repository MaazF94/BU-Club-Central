package edu.ben.bu_club_central.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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

	public int getRsvp_count() {
		return rsvp_count;
	}

	public void setRsvp_count(int rsvp_count) {
		this.rsvp_count = rsvp_count;
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

	/**
	 * @return the event_name
	 */
	public String getEvent_name() {
		return event_name;
	}

	/**
	 * @param event_name the event_name to set
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
	 * @param description the description to set
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
	 * @param location the location to set
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
	 * @param club_id_num the club_id_num to set
	 */
	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}
}

