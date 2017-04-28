package edu.ben.bu_club_central.models;

public class Likes {
	/**
	 * private Integer class variable
	 */
	private int idlike;

	/**
	 * private User object class variable
	 */
	private User idUser;

	/**
	 * private Integer class variable
	 */
	private int idevent;

	/**
	 * Constructor
	 * 
	 * @param idlike
	 *            Integer
	 * @param i
	 *            User object
	 * @param idevent
	 *            Integer
	 */
	public Likes(int idlike, User i, int idevent) {
		this.idlike = idlike;
		this.idUser = idUser;
		this.idevent = idevent;
	}

	/**
	 * getter
	 * 
	 * @return id like Integer
	 */
	public int getIdlike() {
		return idlike;
	}

	/**
	 * setter
	 * 
	 * @param idlike
	 *            Integer
	 */
	public void setIdlike(int idlike) {
		this.idlike = idlike;
	}

	/**
	 * getter
	 * 
	 * @return id user User Object
	 */
	public User getIdUser() {
		return idUser;
	}

	/**
	 * setter
	 * 
	 * @param idUser
	 *            user Object
	 */
	public void setIdUser(User idUser) {
		this.idUser = idUser;
	}

	/**
	 * getter
	 * 
	 * @return id event Integer
	 */
	public int getIdevent() {
		return idevent;
	}

	/**
	 * setter
	 * 
	 * @param idevent
	 *            Integer
	 */
	public void setIdevent(int idevent) {
		this.idevent = idevent;
	}

}
