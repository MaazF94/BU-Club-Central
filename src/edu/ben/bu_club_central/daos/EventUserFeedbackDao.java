package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventUserFeedbackDao {
	private String tableName = "bu_club_central.event_feedback";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();
	
	public void insertFeedback(int eventId, int userId, String feedback) {
		String sql = "INSERT INTO " + tableName + " (eventId, id_num, feedback) VALUES (?, ?, ?)";
		
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eventId);
			ps.setInt(2, userId);
			ps.setString(3, feedback);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
