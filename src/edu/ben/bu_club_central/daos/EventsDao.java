/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.util.*;

import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.Events;
import javafx.event.Event;

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
				+ "(event_name, description, location, rsvp_count, club_id_num) VALUES ('" + event_name + "', '" + description + "', '" + location + "', '" + rsvpInitalCount + "', '"  + club_id_num + "')";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
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
				event.setAcutal_count(cs.getInt("acutal_count"));
				
				results.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(results.size());
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

	public Events getEventByEventId(int eventId) {
		String sql = "SELECT * FROM " + tableName + " WHERE idevent=" + eventId;
		
		
		PreparedStatement ps;
		ResultSet rs = null;
		Events event = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"), rs.getInt("club_id_num"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				event.setAcutal_count(rs.getInt("acutal_count"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return event;
		
	}
	
	public LinkedList<Events> getAllEventsByClubId(int clubId) {
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + clubId;
		//System.out.println(sql);
		
		
		LinkedList<Events> list = new LinkedList<Events>();
		Events event;
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			while(rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"), rs.getInt("club_id_num"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				event.setAcutal_count(rs.getInt("acutal_count"));
				
				list.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(list.size());
		return list;
	}
	
	public void editEvent(int idevent, String eventName, String description, String location, int rsvp_count) {
		String sql = "UPDATE " + tableName + " SET event_name='" + eventName + "', description='" + description + "', location='" + location + "', rsvp_count=" + rsvp_count + " WHERE idevent=" + idevent ;
	
		PreparedStatement ps;
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void deleteEventByEventId(int eventId) {
		String sql = "DELETE FROM " + tableName + " WHERE idevent=" + eventId;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public LinkedList<Events> getAllEventsForPaging(int offset, int noOfRecords) {
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + tableName+ "LIMIT " +offset+ ","+noOfRecords;
		

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


	/**
	 * returns the event id of the last event to be created this method
	 * goes in part with the event notification methods
	 * @return
	 */
	public int getLatestEventId() {
		String sql = "SELECT * FROM " + tableName + " ORDER BY idevent DESC LIMIT 1";
		
		int eventId = 0;
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			rs.next();
			
			eventId = rs.getInt("idevent");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return eventId;
	}
	public LinkedList<Events> getAllEventsByEventName(String eventName) {
		String sql = "SELECT * FROM " + tableName + " WHERE event_name = '"+eventName+"'";
		System.out.println(sql);
		
		
		LinkedList<Events> list = new LinkedList<Events>();
		Events event;
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			while(rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"), rs.getInt("club_id_num"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				
				list.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(list.size());
		return list;
	}
	
	
	public void increaseActualCount(int acutalCount, int eventId) {
		String sql = "UPDATE " + tableName + " SET acutal_count=" + acutalCount + " WHERE idevent=" + eventId ;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
