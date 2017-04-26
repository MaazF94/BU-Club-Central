package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventUserFeedbackDao {
	/**
	 * database table name
	 */
	private String tableName = "bu_club_central.event_feedback";

	/**
	 * database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * connection
	 */
	private Connection conn;

	/**
	 * This method inserts feedback
	 * 
	 * @param eventId
	 *            Integer
	 * @param userId
	 *            Integer
	 * @param feedback
	 *            String
	 */
	public void insertFeedback(int eventId, int userId, String feedback) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + " (eventId, id_num, feedback) VALUES (?, ?, ?)";

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, eventId);
			ps.setInt(2, userId);
			ps.setString(3, feedback);
			ps.execute();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
