/**
 * 
 */
package edu.ben.bu_club_central.models;

/**
 * @author razak
 *
 */
public class Student {
	/**
	 * private class String variable
	 */
	private String fullName;

	/**
	 * private class String variable
	 */
	private String buID;

	/**
	 * private class String variable
	 */
	private String email;

	/**
	 * private class String variable
	 */
	private String phone;

	/**
	 * Constructor for Student class
	 * 
	 * @param fullName
	 *            String
	 * @param buID
	 *            String
	 */
	public Student(String fullName, String buID) {
		this.fullName = fullName;
		this.buID = buID;
		email = null;
		phone = null;
	}

	/**
	 * Constructor for Student class
	 * 
	 * @param fullName
	 *            String
	 * @param buID
	 *            String
	 * @param emailorPhone
	 *            String
	 */
	public Student(String fullName, String buID, String emailorPhone) {
		this.fullName = fullName;
		this.buID = buID;
		email = emailorPhone;
		phone = emailorPhone;
	}

	/**
	 * Constructor for Student class
	 * 
	 * @param fullName
	 *            String
	 * @param buID
	 *            String
	 * @param email
	 *            String
	 * @param phone
	 *            String
	 */
	public Student(String fullName, String buID, String email, String phone) {
		this.fullName = fullName;
		this.buID = buID;
		this.email = email;
		this.phone = phone;
	}

}
