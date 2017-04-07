package edu.ben.bu_club_central.models;

public class Likes {

		private int idlike;
		private User idUser;
		
		private int idevent;
		
		public Likes(int idlike, User i, int idevent){
			this.idlike= idlike;
			this.idUser= idUser;
			
			this.idevent= idevent;
		}
		
		
		
		
		
		public int getIdlike() {
			return idlike;
		}
		public void setIdlike(int idlike) {
			this.idlike = idlike;
		}
		public User getIdUser() {
			return idUser;
		}
		public void setIdUser(User idUser) {
			this.idUser = idUser;
		}
		
		public int getIdevent() {
			return idevent;
		}
		public void setIdevent(int idevent) {
			this.idevent = idevent;
		}
		
		
		
		
}
