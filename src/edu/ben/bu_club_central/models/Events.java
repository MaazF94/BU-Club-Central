package edu.ben.bu_club_central.models;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Events {
	
	private int idevent;
	private String event_name;
	private String description;
	private String location;
	private int expected_count;
	private int length_of_event;
	private String type_of_event;
	private java.sql.Date date;
	private int time;
	private String funding;
	private int club_id_num;
	
	public Events(String event_name, String description, String location, String type_of_event,
			String date, String funding, int expected_count, int length_of_event, int time, int club_id_num) throws ParseException{
		this.setEvent_name(event_name);
		this.setDescription(description);
		this.setLocation(location);
		this.setType_of_event(type_of_event);
		this.setDate(date);
		this.setFunding(funding);
		this.setExpected_count(expected_count);
		this.setLength_of_event(length_of_event);
		this.setTime(time);
		this.setClub_id_num(club_id_num);
		setIdevent(createID(event_name, date));
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
	 * @return the idevent
	 */
	public int getIdevent() {
		return idevent;
	}

	/**
	 * @param idevent the idevent to set
	 */
	public void setIdevent(int idevent) {
		this.idevent = idevent;
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
	 * @return the expected_count
	 */
	public int getExpected_count() {
		return expected_count;
	}

	/**
	 * @param expected_count the expected_count to set
	 */
	public void setExpected_count(int expected_count) {
		this.expected_count = expected_count;
	}

	/**
	 * @return the length_of_event
	 */
	public int getLength_of_event() {
		return length_of_event;
	}

	/**
	 * @param length_of_event the length_of_event to set
	 */
	public void setLength_of_event(int length_of_event) {
		this.length_of_event = length_of_event;
	}

	/**
	 * @return the type_of_event
	 */
	public String getType_of_event() {
		return type_of_event;
	}

	/**
	 * @param type_of_event the type_of_event to set
	 */
	public void setType_of_event(String type_of_event) {
		this.type_of_event = type_of_event;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the funding
	 */
	public String getFunding() {
		return funding;
	}

	/**
	 * @param funding the funding to set
	 */
	public void setFunding(String funding) {
		this.funding = funding;
	}

	/**
	 * @return the date
	 */
	public String getDate() {
		DateFormat df = new SimpleDateFormat("MM/dd/yyyy");
		String date = df.format(this.date);
		return date;
	}
	public java.sql.Date getSqlDate(){
		return date;
	}

	/**
	 * @param date the date to set
	 * @throws ParseException 
	 */
	public void setDate(String date) {
		this.date = java.sql.Date.valueOf(date);
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

