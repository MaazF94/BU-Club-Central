/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import java.util.Date;

import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.Events;
import javafx.event.Event;

public class EventsDao {

	/**
	 * database table name
	 */
	private String tableName = "bu_club_central.event";

	/**
	 * event object
	 */
	private Events eventObj;

	/**
	 * default value for the rsvp count of an event
	 */
	private final int rsvpInitalCount = 0;

	/**
	 * database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * Connection
	 */
	private Connection conn;

	/**
	 * Adds an event to the database
	 * 
	 * @param event_name
	 *            String
	 * @param description
	 *            String
	 * @param location
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @param startyear
	 *            String
	 * @param startmonth
	 *            String
	 * @param startday
	 *            String
	 * @param endyear
	 *            String
	 * @param endmonth
	 *            String
	 * @param endday
	 *            String
	 * @param category
	 *            String
	 */
	public void addEvent(String event_name, String description, String location, int club_id_num, String startyear,
			String startmonth, String startday, String endyear, String endmonth, String endday, String category) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String startDate = startyear + "-" + startmonth + "-" + startday;
		String endDate = endyear + "-" + endmonth + "-" + endday;

		String sql = "INSERT INTO " + tableName
				+ "(event_name, description, location, rsvp_count, club_id_num, startDate, endDate, category) VALUES ('"
				+ event_name + "', '" + description + "', '" + location + "', '" + rsvpInitalCount + "', '"
				+ club_id_num + "', '" + startDate + "', '" + endDate + "', '" + category + "')";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Gets all the events in the database
	 * 
	 * @return linked list of events
	 */
	public LinkedList<Events> getAllEvents() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"), cs.getString("category"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * Increases the rsvp count for a specific event
	 * 
	 * @param eventId
	 *            Integer
	 */
	public void increaseRSVPCount(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			ps2.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets an event from a specific event id
	 * 
	 * @param eventId
	 *            Integer
	 * @return event object
	 */
	public Events getEventByEventId(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"),
						rs.getInt("club_id_num"), rs.getString("category"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
	}

	/**
	 * gets all the events for a specific club
	 * 
	 * @param clubId
	 *            Integer
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getAllEventsByClubId(int clubId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + clubId;

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
			while (rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"),
						rs.getInt("club_id_num"), rs.getString("category"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				list.add(event);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * this method edits an event
	 * 
	 * @param idevent
	 *            Integer
	 * @param eventName
	 *            String
	 * @param description
	 *            String
	 * @param location
	 *            String
	 * @param rsvp_count
	 *            Integer
	 */
	public void editEvent(int idevent, String eventName, String description, String location, int rsvp_count) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET event_name='" + eventName + "', description='" + description
				+ "', location='" + location + "', rsvp_count=" + rsvp_count + " WHERE idevent=" + idevent;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method deletes and event by event id number
	 * 
	 * @param eventId
	 *            Integer
	 */
	public void deleteEventByEventId(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "DELETE FROM " + tableName + " WHERE idevent=" + eventId;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * this method gets all events for paging
	 * 
	 * @param offset
	 *            Integer
	 * @param noOfRecords
	 *            Integer
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getAllEventsForPaging(int offset, int noOfRecords) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT SQL_CALC_FOUND_ROWS * FROM " + tableName + "LIMIT " + offset + "," + noOfRecords;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"), cs.getString("category"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * returns the event id of the last event to be created this method goes in
	 * part with the event notification methods
	 * 
	 * @return Integer
	 */
	public int getLatestEventId() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " ORDER BY idevent DESC LIMIT 1";

		int eventId = 0;
		PreparedStatement ps;
		ResultSet rs;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			rs.next();

			eventId = rs.getInt("idevent");
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventId;
	}

	/**
	 * gets event by name
	 * 
	 * @param eventName
	 *            String
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getAllEventsByEventName(String eventName) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE event_name like '%" + eventName + "%'";
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
			while (rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"),
						rs.getInt("club_id_num"), rs.getString("category"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				list.add(event);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * updates the actual count for an event
	 * 
	 * @param acutalCount
	 *            Integer
	 * @param eventId
	 *            Integer
	 */
	public void increaseActualCount(int acutalCount, int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET acutal_count=" + acutalCount + " WHERE idevent=" + eventId;

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets all events by category
	 * 
	 * @param category
	 *            String
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getAllEventsByCategory(String category) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE category = '" + category + "'";
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
			while (rs.next()) {
				event = new Events(rs.getString("event_name"), rs.getString("description"), rs.getString("location"),
						rs.getInt("club_id_num"), rs.getString("category"));
				event.setRsvp_count(rs.getInt("rsvp_count"));
				event.setEventId(rs.getInt("idevent"));
				list.add(event);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * gets the 3 most recent events
	 * 
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getLast3Events() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName + " order by startDate DESC LIMIT 3";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"), cs.getString("category"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * adds a like to an event
	 * 
	 * @param eventId
	 *            Integer
	 * @param currentLikes
	 *            Integer
	 */
	public void addLikeToEvent(int eventId, int currentLikes) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET likes=  likes + 1 WHERE idevent=" + eventId;

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * gets the total number of likes for an event
	 * 
	 * @param eventId
	 *            Integer
	 * @return Integer
	 */
	public int getNumOfLikes(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT likes from " + tableName + " WHERE idevent= '" + eventId + "'";

		int likes = 0;
		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				likes = rs.getInt("likes");
			}
			;
			rs.close();
			conn.close();
			dbc.closeConnection();
			return likes;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return 0;
	}

	/**
	 * gets the most popular events
	 * 
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getMostPopular() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName + " Order by likes DESC LIMIT 3";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"), cs.getString("category"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * decreases the rsvp count for an event
	 * 
	 * @param eventId
	 *            Integer
	 */
	public void decreaseAttendanceCount(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE idevent=" + eventId;

		int count = 0;

		PreparedStatement ps = null, ps2;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			count = rs.getInt("rsvp_count");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		String sql2 = "UPDATE " + tableName + " SET rsvp_count=" + (count - 1) + " WHERE idevent=" + eventId;
		try {
			ps2 = conn.prepareStatement(sql2);
			ps2.executeUpdate();
			ps.close();
			ps2.close();
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean EventExists(String event) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		
		boolean eventExists = false;
		
		String sql = "SELECT * FROM "+tableName+" WHERE event_name = '" + event + "'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String events = rs.getString("event_name");
				
				if (events.contains(event)) {
					eventExists = true;
				}
			}
			conn.close();
			dbc.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventExists;
	}

}