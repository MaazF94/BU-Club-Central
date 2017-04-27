package edu.ben.bu_club_central.models;

public class DocumentForAdmin {
	/**
	 * private String class variable
	 */
	private String name;

	/**
	 * private Integer class variable
	 */
	private int from_id_num;

	/**
	 * private char class variable
	 */
	private char file;

	/**
	 * private boolean class variable
	 */
	private boolean accept_deny;

	/**
	 * private boolean class variable
	 */
	private boolean active;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            String
	 * @param from_id_num
	 *            Integer
	 * @param c
	 *            char
	 * @param accept_deny
	 *            boolean
	 * @param active
	 *            boolean
	 */
	public DocumentForAdmin(String name, int from_id_num, char c, boolean accept_deny, boolean active) {
		this.name = name;
		this.from_id_num = from_id_num;
		this.file = c;
		this.accept_deny = accept_deny;
		this.active = active;
	}

	/**
	 * getter
	 * 
	 * @return name String
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * setter
	 * 
	 * @param name
	 *            String
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * getter
	 * 
	 * @return id num Integer
	 */
	public int getFrom_id_num() {
		return this.from_id_num;
	}

	/**
	 * setter
	 * 
	 * @param from_id_num
	 *            Integer
	 */
	public void setFrom_id_num(int from_id_num) {
		this.from_id_num = from_id_num;
	}

	/**
	 * getter
	 * 
	 * @return file char
	 */
	public char getFile() {
		return this.file;
	}

	/**
	 * setter
	 * 
	 * @param file
	 *            char
	 */
	public void setFile(char file) {
		this.file = file;
	}

	/**
	 * getter
	 * 
	 * @return accept_deny boolean
	 */
	public boolean getAccept_Deny() {
		return this.accept_deny;
	}

	/**
	 * setter
	 * 
	 * @param accept_deny
	 *            boolean
	 */
	public void setAccept_Deny(boolean accept_deny) {
		this.accept_deny = accept_deny;
	}

	/**
	 * getter
	 * 
	 * @return active boolean
	 */
	public boolean getActive() {
		return this.active;
	}

	/**
	 * setter
	 * 
	 * @param active
	 *            boolean
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

}
