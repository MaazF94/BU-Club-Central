package edu.ben.bu_club_central.models;

public class Events {
	
	private int idevent;
	private String event_name;
	private String description;
	private String location;
	private int expected_count;
	private int length_of_event;
	private String type_of_event;
	private String date;
	private int time;
	private String funding;
	private int club_id_num;
	
	public Events(String event_name, String description, String location, String type_of_event,
			String date, String funding, int expected_count, int length_of_event, int time, int club_id_num){
		this.event_name = event_name;
		this.description = description;
		this.location = location;
		this.type_of_event = type_of_event;
		this.date = date;
		this.funding = funding;
		this.expected_count = expected_count;
		this.length_of_event = length_of_event;
		this.time = time;
		this.club_id_num = club_id_num;
		idevent = createID(event_name, date);
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

