/**
 * 
 */
package edu.ben.bu_club_central.models;

/**
 * @author razak
 *
 */
public class Student {
	private String fullName;
	private String buID;
	private String email;
	private String phone;
	
	public Student (String fullName, String buID) {
		this.fullName = fullName;
		this.buID = buID;
		email = null;
		phone = null;
	}

	public Student (String fullName, String buID, String emailorPhone) {
		this.fullName = fullName;
		this.buID = buID;
		email = emailorPhone;
		phone = emailorPhone;
	}
	
	public Student (String fullName, String buID, String email, String phone) {
		this.fullName = fullName;
		this.buID = buID;
		this.email = email;
		this.phone = phone;
	}

}
