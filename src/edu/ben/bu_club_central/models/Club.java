package edu.ben.bu_club_central.models;

public class Club {
	/**
	 * private String class variable
	 */
	private String club_name;

	/**
	 * private String class variable
	 */
	private String pet_name;

	/**
	 * private String class variable
	 */
	private String club_description;

	/**
	 * private Integer class variable
	 */
	private int club_id_num;

	/**
	 * private String class variable
	 */
	private String pet_email;

	/**
	 * private String class variable
	 */
	private String advisor_name;

	/**
	 * private String class variable
	 */
	private String preference;
	/**
	 * private Integer class variable
	 */
	private int enabled;

	/**
	 * private String class variable
	 */
	private String meeting_time;

	/**
	 * private String class variable
	 */
	private String meeting_freq;

	/**
	 * private String class variable
	 */
	private String meeting_loc;

	/**
	 * private String class variable
	 */
	private String broadcast_update;

	/**
	 * Constructor
	 * 
	 * @param club_id_num
	 *            Integer
	 * @param club_name
	 *            String
	 * @param pet_name
	 *            String
	 * @param club_description
	 *            String
	 * @param pet_email
	 *            String
	 * @param advisor_name
	 *            String
	 * @param enabled
	 *            Integer
	 * @param meeting_time
	 *            String
	 * @param meeting_freq
	 *            String
	 * @param meeting_loc
	 *            String
	 * @param broadcast_update
	 *            String
	 * @param preference
	 *            String
	 */
	public Club(int club_id_num, String club_name, String pet_name, String club_description, String pet_email,
			String advisor_name, int enabled, String meeting_time, String meeting_freq, String meeting_loc,
			String broadcast_update, String preference) {

		this.club_name = club_name;
		this.pet_name = pet_name;
		this.club_description = club_description;
		this.club_id_num = club_id_num;
		this.pet_email = pet_email;
		this.advisor_name = advisor_name;
		this.preference = preference;
		this.enabled = enabled;
		this.meeting_time = meeting_time;
		this.meeting_freq = meeting_freq;
		this.meeting_loc = meeting_loc;
		this.broadcast_update = broadcast_update;
	}

	/**
	 * getter
	 * 
	 * @return club name String
	 */
	public String getClub_name() {
		return club_name;
	}

	/**
	 * setter
	 * 
	 * @param club_name
	 *            String
	 */
	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	/**
	 * getter
	 * 
	 * @return pet name String
	 */
	public String getPet_name() {
		return pet_name;
	}

	/**
	 * setter
	 * 
	 * @param pet_name
	 *            String
	 */
	public void setPet_name(String pet_name) {
		this.pet_name = pet_name;
	}

	/**
	 * getter
	 * 
	 * @return club description String
	 */
	public String getClub_description() {
		return club_description;
	}

	/**
	 * setter
	 * 
	 * @param club_description
	 *            String
	 */
	public void setClub_description(String club_description) {
		this.club_description = club_description;
	}

	/**
	 * getter
	 * 
	 * @return club id num Integer
	 */
	public int getClub_id_num() {
		return club_id_num;
	}

	/**
	 * setter
	 * 
	 * @param club_id_num
	 *            Integer
	 */
	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}

	/**
	 * getter
	 * 
	 * @return pet email String
	 */
	public String getPet_email() {
		return pet_email;
	}

	/**
	 * setter
	 * 
	 * @param pet_email
	 *            String
	 */
	public void setPet_email(String pet_email) {
		this.pet_email = pet_email;
	}

	/**
	 * getter
	 * 
	 * @return advisor name String
	 */
	public String getAdvisor_name() {
		return advisor_name;
	}

	/**
	 * setter
	 * 
	 * @param advisor_name
	 *            String
	 */
	public void setAdvisor_name(String advisor_name) {
		this.advisor_name = advisor_name;
	}

	/**
	 * getter
	 * 
	 * @return enabled Integer
	 */
	public int getEnabled() {
		return enabled;
	}

	/**
	 * setter
	 * 
	 * @param enabled
	 *            Integer
	 */
	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}

	/**
	 * getter
	 * 
	 * @return meeting time String
	 */
	public String getMeeting_Time() {
		return meeting_time;
	}

	/**
	 * setter
	 * 
	 * @param meeting_time
	 *            String
	 */
	public void setMeeting_Time(String meeting_time) {
		this.meeting_time = meeting_time;
	}

	/**
	 * getter
	 * 
	 * @return meeting frequency String
	 */
	public String getMeeting_Freq() {
		return meeting_freq;
	}

	/**
	 * setter
	 * 
	 * @param meeting_freq
	 *            String
	 */
	public void setMeeting_Freq(String meeting_freq) {
		this.meeting_freq = meeting_freq;
	}

	/**
	 * getter
	 * 
	 * @return meeting location String
	 */
	public String getMeeting_Loc() {
		return meeting_loc;
	}

	/**
	 * setter
	 * 
	 * @param meeting_loc
	 *            String
	 */
	public void setMeeting_Loc(String meeting_loc) {
		this.meeting_loc = meeting_loc;
	}

	/**
	 * setter
	 * 
	 * @return broadcast update String
	 */
	public String getBroadcast_Update() {
		return broadcast_update;
	}

	/**
	 * setter
	 * 
	 * @param broadcast_update
	 *            String
	 */
	public void setBroadcast_Update(String broadcast_update) {
		this.broadcast_update = broadcast_update;
	}

	/**
	 * getter
	 * 
	 * @return preference String
	 */
	public String getPreference() {
		return preference;
	}

	/**
	 * setter
	 * 
	 * @param preference
	 *            String
	 */
	public void setPreference(String preference) {
		this.preference = preference;
	}

}
