package edu.ben.bu_club_central.models;

public class EventRSVPList {
	private int idevent_rsvp_list;
	private int eventId;
	private int user_id_num;
	
	
	public EventRSVPList(int idevent_rsvp_list, int eventId, int user_id_num) {
		this.idevent_rsvp_list = idevent_rsvp_list;
		this.eventId = eventId;
		this.user_id_num = user_id_num;
	}


	public int getIdevent_rsvp_list() {
		return idevent_rsvp_list;
	}


	public int getEventId() {
		return eventId;
	}


	public int getUser_id_num() {
		return user_id_num;
	}
	
	

}