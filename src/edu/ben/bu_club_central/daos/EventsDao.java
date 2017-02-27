/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.util.*;
import edu.ben.bu_club_central.models.Events;

/**
 * @author raza The connector for the events table in the database
 *
 */
public class EventsDao {
	private String tableName = "bu_club_central.event";
	private Events eventObj;
	private final int rsvpInitalCount = 0;

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	/**
	 * 
	 * @param event_name
	 * @param description
	 * @param location
	 * @param type_of_event
	 * @param date
	 * @param funding
	 * @param expected_count
	 * @param length_of_event
	 * @param time
	 * @param club_id_num
	 *            add a single event object into the database
	 */
	public void addEvent(String event_name, String description, String location, int club_id_num) {
		String sql = "INSERT INTO " + tableName
				+ "(event_name, description, location,rsvp_count, club_id_num) VALUES ('" + event_name + "', '" + description + "', '" + location + "', '" + rsvpInitalCount + "', '"  + club_id_num + "')";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public LinkedList<Events> getAllEvents() {
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				
				results.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}
	
	
	public void increaseRSVPCount(int eventId) {
		String sql = "SELECT * FROM " + tableName + " WHERE idevent=" + eventId;
		
		int rsvpCount = 0;
		
		
		PreparedStatement ps, ps2;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			rs.next();
			rsvpCount = rs.getInt("rsvp_count");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		rsvpCount = rsvpCount + 1;
		
		String sql2 = "UPDATE " + tableName + " SET rsvp_count=" + rsvpCount + " WHERE idevent=" + eventId;
		
		
		try {
			ps2 = conn.prepareStatement(sql2);
			ps2.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	
	
	
	
}
