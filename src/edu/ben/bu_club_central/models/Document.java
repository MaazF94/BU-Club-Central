package edu.ben.bu_club_central.models;

public class Document {
	
	private String name;
	private String description;
	private String file_path;
	
	public Document(String name, String description, String file_path) {
		this.name = name;
		this.description = description;
		this.file_path = file_path;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getfilePath() {
		return file_path;
	}
	
	public void setFilePath(String file_path) {
		this.file_path = file_path;
	}

}
