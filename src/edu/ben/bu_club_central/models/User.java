package edu.ben.bu_club_central.models;

public class User {
	private String first_name;
	private String last_name;
	private String username;
	private String password;
	private int id_num;
	private String email;
	private int role_id;
	private int enabled;
	private int club_id_num;
	
	

	

	public User(String first_name, String last_name, String username, String password, int id_num, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.username = username;
		this.password = password;
		this.id_num = id_num;
		this.email = email;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId_num() {
		return id_num;
	}

	public void setId_num(int id_num) {
		this.id_num = id_num;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	
	public int getEnabled() {
		return enabled;
	}

	public void setEnabled(int enabled) {
		this.enabled = enabled;
	}
	
	public int getClub_id_num() {
		return club_id_num;
	}

	public void setClub_id_num(int club_id_num) {
		this.club_id_num = club_id_num;
	}
	
	
}
