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

/**
 * @author raza The connector for the events table in the database
 *
 */
public class EventsDao {

	private String tableName = "bu_club_central.event";
	private Events eventObj;
	private final int rsvpInitalCount = 0;

	private DatabaseConnection dbc;
	private Connection conn;

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
				// event.setAcutal_count(cs.getInt("acutal_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println(results.size());

		return results;
	}

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
				// event.setAcutal_count(rs.getInt("acutal_count"));
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return event;
	}

	public LinkedList<Events> getAllEventsByClubId(int clubId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + clubId;
		// System.out.println(sql);

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
				// event.setAcutal_count(rs.getInt("acutal_count"));

				list.add(event);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println(list.size());

		return list;
	}

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
	 * @return
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

	public LinkedList<Events> getAllEventsByEventName(String eventName) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE event_name like '%" + eventName + "%'";
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
		// System.out.println(list.size());

		return list;
	}

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
		// System.out.println(list.size());

		return list;
	}

	public LinkedList<Events> getLast3Events() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Events> results = new LinkedList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName + " LIMIT 3";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getInt("club_id_num"), cs.getString("category"));
				event.setEventId(cs.getInt("idevent"));
				event.setRsvp_count(cs.getInt("rsvp_count"));
				// event.setAcutal_count(cs.getInt("acutal_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println(results.size());

		return results;
	}

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
				// event.setAcutal_count(cs.getInt("acutal_count"));
				results.add(event);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// System.out.println(results.size());

		return results;
	}

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

}