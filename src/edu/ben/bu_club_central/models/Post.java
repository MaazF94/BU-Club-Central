package edu.ben.bu_club_central.models;

public class Post {
	private int idpost;
	private String title;
	private String contents;
	private int club_id_num;
	private int user_id_num;
	
	public Post(String title, String contents, int club_id_num, int user_id_num) {
		this.title = title;
		this.contents = contents;
		this.club_id_num = club_id_num;
		this.user_id_num = user_id_num;
	}

	
	
	
	public int getIdpost() {
		return idpost;
	}




	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}




	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public int getClub_id_num() {
		return club_id_num;
	}

	public int getUser_id_num() {
		return user_id_num;
	}
	
	

}
