/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.text.ParseException;
import java.util.*;
import edu.ben.bu_club_central.models.Events;

/**
 * @author raza The connector for the events table in the database
 *
 */
public class EventsDao {
	private String tableName = "event";

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
	 * 
	 *            add a single event object into the database
	 */
	public boolean addEvent(Events ev) {
		if (!checkIfEventExists(ev.getEvent_name())) {
			String sql = "INSERT INTO " + tableName 
					+ "(idEvent, event_name, description, location, date, funding, expected_count, length_of_event, time, type_of_event,"
					+ " club_id_num) VALUES ("+ ev.getIdevent() + ", \"" + ev.getEvent_name() + "\", \"" + ev.getDescription() + "\", \"" + ev.getLocation() + "\", '"
					+ ev.getSqlDate() + "', \"" + ev.getFunding() + "\", " + ev.getExpected_count() + ", " + ev.getLength_of_event() +", " + ev.getTime()
					+ ", '" + ev.getType_of_event() + "', " + ev.getClub_id_num() + ")";
			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
				ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			}
			return true;
		}else {
			return false;
		}
	}

	/**
	 * get all the events in the database
	 * 
	 * @return ArrayList
	 * @throws ParseException 
	 */
	public ArrayList<Events> getAllEvents() throws ParseException {
		ArrayList<Events> results = new ArrayList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName;

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {
				Events event = new Events(cs.getString("event_name"), cs.getString("description"),
						cs.getString("location"), cs.getString("type_of_event"), cs.getString("date"),
						cs.getString("funding"), cs.getInt("expected_count"), cs.getInt("length_of_event"),
						cs.getInt("time"), cs.getInt("club_id_num"));
				results.add(event);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	/**
	 * get a single event from the database using the name of the event
	 * 
	 * 
	 * @param eventName
	 * @return Events
	 * @throws ParseException 
	 */

	public Events getAnEvent(String eventName) throws ParseException {
		String sql;
		sql = "SELECT * FROM " + tableName + " WHERE event_name = '" + eventName + "';";
		Events event = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			if(cs.next()){
			event = new Events(cs.getString("event_name"), cs.getString("description"), cs.getString("location"),
					cs.getString("type_of_event"), cs.getString("date"), cs.getString("funding"),
					cs.getInt("expected_count"), cs.getInt("length_of_event"), cs.getInt("time"),
					cs.getInt("club_id_num"));
			}else{
				return event;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
	}

	/**
	 * update an event name in the database using the previous eventName return
	 * true if successful
	 * 
	 * @param prevEventName
	 * @param eventName
	 * @return boolean
	 */
	public boolean updateEventName(String prevEventName, String eventName) {
		String sql;
		sql = "UPDATE " + tableName + " SET event_name = '" + eventName + "' WHERE idevent = (SELECT idevent FROM "
				+ "(SELECT * FROM " + tableName + ") AS tempTable WHERE event_name = '" + prevEventName + "');";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/***
	 * update the event description in the database, search for the correct even
	 * using the eventName return true if successful
	 * 
	 * @param EventName
	 * @param description
	 * @return boolean
	 */

	public boolean updateEventDescription(String EventName, String description) {
		String sql;
		sql = "UPDATE " + tableName + " SET description = '" + description + "' WHERE idevent = (SELECT idevent FROM "
				+ "(SELECT * FROM "+ tableName + ") AS tempTable WHERE event_name = '" + EventName + "');";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * update the event location for an event in the database, search for it
	 * using event name return true if successful
	 * 
	 * @param EventName
	 * @param location
	 * @return boolean
	 */

	public boolean updateEventLocation(String EventName, String location) {
		String sql;
		sql = "UPDATE " + tableName + " SET location = '" + location + "' WHERE idevent = (SELECT idevent FROM "
				+ "(SELECT * FROM "+ tableName + ") AS tempTable WHERE event_name = '" + EventName + "');";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * update the time of the event. search database using the event_name return
	 * true if successful
	 * 
	 * @param EventName
	 * @param time
	 * @return boolean
	 */

	public boolean updateEventTime(String EventName, int time) {
		String sql;
		sql = "UPDATE " + tableName + " SET time = " + time + " WHERE idevent = (SELECT idevent FROM "
				+ "(SELECT * FROM "+ tableName + ") AS tempTable WHERE event_name = '" + EventName + "');";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * delete an event from the database return true if successful
	 * 
	 * @param EventName
	 * @return boolean
	 */
	public boolean deleteEvent(String EventName) {
		String sql;
		sql = "DELETE FROM " + tableName + " WHERE event_name = '" + EventName + "';";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	private boolean checkIfEventExists(String EventName) {
		String sql;
		sql = "SELECT * FROM " + tableName + " WHERE event_name = '" + EventName + "';";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (!rs.next()) {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}
}
