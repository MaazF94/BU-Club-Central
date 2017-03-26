package edu.ben.bu_club_central.models;

public class ClubMembership {

	private int club_membership_ID;
	private int club_ID;
	private int user_ID;
	private int role_ID;
	private boolean active;
	private String club_name;
	
	/**
	 * Constructor
	 * 
	 * @param club_ID
	 * @param user_ID
	 * @param role_ID
	 * @param active
	 */
	public ClubMembership(int club_ID, int user_ID, int role_ID, boolean active, String club_name) {
		this.club_ID = club_ID;
		this.user_ID = user_ID;
		this.role_ID = role_ID;
		this.active = active;
		this.club_name = club_name;
	}

	/**
	 * get active level
	 * 
	 * @return true or false
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * set active level
	 * 
	 * @param active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * get club membership ID
	 * 
	 * @return club memebrship id
	 */
	public int getClubMembershipID() {
		return club_membership_ID;
	}

	/**
	 * get club ID
	 * 
	 * @return club ID
	 */
	public int getClubID() {
		return club_ID;
	}
	
	public String getClub_name() {
		return club_name;
	}

	public void setClub_name(String club_name) {
		this.club_name = club_name;
	}

	/**
	 * set club ID
	 * 
	 * @param club_ID
	 */
	public void setClubID(int club_ID) {
		this.club_ID = club_ID;
	}

	/**
	 * get user id
	 * 
	 * @return user id
	 */
	public int getUserID() {
		return user_ID;
	}

	/**
	 * set user id
	 * 
	 * @param user_ID
	 */
	public void setUserID(int user_ID) {
		this.user_ID = user_ID;
	}

	/**
	 * get role ID
	 * 
	 * @return role id
	 */
	public int getRoleID() {
		return role_ID;
	}

	/**
	 * set role ID
	 * 
	 * @param role_ID
	 */
	public void setRoleID(int role_ID) {
		this.role_ID = role_ID;
	}

}
