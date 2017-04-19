package edu.ben.bu_club_central.models;

public class Club {
	private String club_name;
	private String pet_name;
	private String club_description;
	private int club_id_num;
	private String pet_email;
	private String advisor_name;
	private int enabled;
	private String meeting_time;
	private String meeting_freq;
	private String meeting_loc;
	private String broadcast_update;
	
	
	public Club (int club_id_num, String club_name, String pet_name, String club_description, String pet_email,
			String advisor_name, int enabled, String meeting_time, String meeting_freq, String meeting_loc,
			String broadcast_update) {
		this.club_name = club_name;
		this.pet_name = pet_name;
		this.club_description = club_description;
		this.club_id_num = club_id_num;
		this.pet_email = pet_email;
		this.advisor_name = advisor_name;
		this.enabled = enabled;
		this.meeting_time = meeting_time;
		this.meeting_freq = meeting_freq;
		this.meeting_loc = meeting_loc;
		this.broadcast_update = broadcast_update;
	}


	public String getClub_name() {
		return club_name;
	}


	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}


	public String getPet_name() {
		return pet_name;
	}


	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}


	public String getClub_description() {
		return club_description;
	}


	public void setClub_description(String club_description) {
		this.club_description = club_description;
	}


	public int getClub_id_num() {
		return club_id_num;
	}


	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}


	public String getPet_email() {
		return pet_email;
	}


	public void setPet_email(String pet_email) {
		this.pet_email = pet_email;
	}


	public String getAdvisor_name() {
		return advisor_name;
	}


	public void setAdvisor_name(String advisor_name) {
		this.advisor_name = advisor_name;
	}

	public int getEnabled() {
		return enabled;
	}


	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public String getMeeting_Time() {
		return meeting_time;
	}


	public void setMeeting_Time(String meeting_time) {
		this.meeting_time = meeting_time;
	}
	
	public String getMeeting_Freq() {
		return meeting_freq;
	}


	public void setMeeting_Freq(String meeting_freq) {
		this.meeting_freq = meeting_freq;
	}
	
	public String getMeeting_Loc() {
		return meeting_loc;
	}


	public void setMeeting_Loc(String meeting_loc) {
		this.meeting_loc = meeting_loc;
	}
	
	
	public String getBroadcast_Update() {
		return broadcast_update;
	}


	public void setBroadcast_Update(String broadcast_update) {
		this.broadcast_update = broadcast_update;
	}

	
	
	
	
	
	
	
}
