package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class EventRSVPListDao {
	private String tableName = "bu_club_central.event_rsvp_list";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	

	public void rsvpUserForEvent(int eventId, int user_id_num) {
		String sql = "INSERT INTO " + tableName + " (eventId, user_id_num) VALUES ('" + eventId + "', '" + user_id_num + "')";
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * This method checks the event rsvp list to see if the person has already rsvp for a certain event
	 * @param eventId
	 * @param user_id_num
	 * @return true if the user already rsvp for that event or false if the user has not rsvp for that event yet
	 */
	public boolean checkUserRsvpForEvent(int eventId, int user_id_num) {
		String sql = "SELECT * FROM " + tableName + " WHERE eventId = '" + eventId + "' AND user_id_num = '" + user_id_num + "'";
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
	
}
