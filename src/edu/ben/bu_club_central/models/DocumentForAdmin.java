package edu.ben.bu_club_central.models;

import java.io.File;

public class DocumentForAdmin {
	
	private String name;
	private int from_id_num;
	private File file;
	private boolean accept_deny;
	private boolean active;
	
	public DocumentForAdmin(String name, int from_id_num, File file, boolean accept_deny, boolean active) {
		this.name = name;
		this.from_id_num = from_id_num;
		this.file = file;
		this.accept_deny = accept_deny;
		this.active = active;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getFrom_id_num() {
		return this.from_id_num;
	}
	
	public void setFrom_id_num(int from_id_num) {
		this.from_id_num = from_id_num;
	}
	
	public File getFile() {
		return this.file;
	}
	
	public void setFile(File file) {
		this.file = file;
	}
	
	public boolean getAccept_Deny() {
		return this.accept_deny;
	}
	
	public void setAccept_Deny(boolean accept_deny) {
		this.accept_deny = accept_deny;
	}
	
	public boolean getActive() {
		return this.active;
	}
	
	public void setActive(boolean active) {
		this.active = active;
	}

}
