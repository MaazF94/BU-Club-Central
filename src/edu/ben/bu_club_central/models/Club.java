package edu.ben.bu_club_central.models;

public class Club {
	private String club_name;
	private String pet_name;
	private String club_description;
	private int club_id_num;
	private String pet_email;
	private String advisor_name;
	private String preference;
	private int enabled;
	
	
	public Club (int club_id_num, String club_name, String pet_name, String club_description, String pet_email, String advisor_name,String preference, int enabled) {
		this.club_name = club_name;
		this.pet_name = pet_name;
		this.club_description = club_description;
		this.club_id_num = club_id_num;
		this.pet_email = pet_email;
		this.advisor_name = advisor_name;
		this.preference = preference;
		this.enabled = enabled;
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


	public String getPreference() {
		return preference;
	}


	public void setPreference(String preference) {
		this.preference = preference;
	}

	
	
	
	
	
	
	
}
