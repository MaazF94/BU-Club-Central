package edu.ben.bu_club_central.models;

public class User {
	/**
	 * private String class variable
	 */
	private String first_name;

	/**
	 * private String class variable
	 */
	private String last_name;

	/**
	 * private String class variable
	 */
	private String username;

	/**
	 * private String class variable
	 */
	private String password;

	/**
	 * private Integer class variable
	 */
	private int id_num;

	/**
	 * private String class variable
	 */
	private String email;

	/**
	 * private Integer class variable
	 */
	private int role_id;

	/**
	 * private Integer class variable
	 */
	private int enabled;

	/**
	 * private Integer class variable
	 */
	private int club_id_num;

	/**
	 * private Integer class variable
	 */
	private int user_id;

	/**
	 * private String class variable
	 */
	private String preference;

	/**
	 * Constructor for User object
	 * 
	 * @param first_name
	 *            String
	 * @param last_name
	 *            String
	 * @param username
	 *            String
	 * @param password
	 *            String
	 * @param id_num
	 *            Integer
	 * @param email
	 *            String
	 * @param role_id
	 *            Integer
	 * @param user_id
	 *            Integer
	 * @param enabled
	 *            Integer
	 * @param preference
	 *            String
	 */
	public User(String first_name, String last_name, String username, String password, int id_num, String email,
			int role_id, int user_id, int enabled, String preference) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.id_num = id_num;
		this.email = email;
		this.role_id = role_id;
		this.user_id = user_id;
		this.enabled = enabled;
		this.preference = preference;
	}

	/**
	 * getter
	 * 
	 * @return first name String
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * setter
	 * 
	 * @param first_name
	 *            String
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * getter
	 * 
	 * @return last name String
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * setter
	 * 
	 * @param last_name
	 *            String
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * getter
	 * 
	 * @return username String
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * setter
	 * 
	 * @param username
	 *            String
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * getter
	 * 
	 * @return password String
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * setter
	 * 
	 * @param password
	 *            String
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * getter
	 * 
	 * @return id_num Integer
	 */
	public int getId_num() {
		return id_num;
	}

	/**
	 * setter
	 * 
	 * @param id_num
	 *            Integer
	 */
	public void setId_num(int id_num) {
		this.id_num = id_num;
	}

	/**
	 * getter
	 * 
	 * @return email String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * setter
	 * 
	 * @param email
	 *            String
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * getter
	 * 
	 * @return role_id Integer
	 */
	public int getRole_id() {
		return role_id;
	}

	/**
	 * setter
	 * 
	 * @param role_id
	 *            String
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
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
	 * @return user id Integer
	 */
	public int getUser_id() {
		return user_id;
	}

	/**
	 * setter
	 * 
	 * @param user_id
	 *            Integer
	 */
	public void setUser_id(int user_id) {
		this.user_id = user_id;
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
