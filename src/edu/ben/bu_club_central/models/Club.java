package edu.ben.bu_club_central.models;

public class Club {
	private String club_name;
	private int club_id_num;
	private int member_count;
	
	public Club (String club_name, int club_id_num) {
		this.club_name = club_name;
		this.club_id_num = club_id_num;
	}

	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	public int getClub_id_num() {
		return club_id_num;
	}

	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}

	public int getMember_count() {
		return member_count;
	}

	public void setMember_count(int member_count) {
		this.member_count = member_count;
	}
	
	
	
}
