package edu.ben.bu_club_central.models;

public class Document {
	/**
	 * private string class variable
	 */
	private String name;

	/**
	 * private string class variable
	 */
	private String description;

	/**
	 * private string class variable
	 */
	private String file_path;

	/**
	 * Constructor
	 * 
	 * @param name
	 *            String
	 * @param description
	 *            String
	 * @param file_path
	 *            String
	 */
	public Document(String name, String description, String file_path) {
		this.name = name;
		this.description = description;
		this.file_path = file_path;
	}

	/**
	 * getter
	 * 
	 * @return name string
	 */
	public String getName() {
		return name;
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
	 * @return description String
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * setter
	 * 
	 * @param description
	 *            String
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * getter
	 * 
	 * @return file path String
	 */
	public String getfilePath() {
		return file_path;
	}

	/**
	 * setter
	 * 
	 * @param file_path
	 *            String
	 */
	public void setFilePath(String file_path) {
		this.file_path = file_path;
	}

}
