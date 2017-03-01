/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.util.*;
import edu.ben.bu_club_central.models.Events;

/**
 * @author raza 
 * The connector for the events table in the database
 *
 */
public class EventsDao {
	private String tableName = "event";
	private Events eventObj;

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
	 *  add a single event object into the database
	 */
	public void addEvent(String event_name, String description, String location, String type_of_event, String date,
			String funding, int expected_count, int length_of_event, int time, int club_id_num) {
		String sql = "INSERT INTO " + tableName
				+ "(event_name, description, location, date, funding, expected_count, length_of_event, time, type_of_event,"
				+ " club_id_num) VALUES ('" + event_name + "', '" + description + "', '" + location + "', '" + date
				+ "', '" + funding + "', '" + expected_count + "', '" + length_of_event + "', '" + type_of_event
				+ "', '" + time + "', '" + club_id_num + "')";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * get all the events in the database
	 * 
	 * @return ArrayList
	 */
	public ArrayList<Events> getAllEvents() {
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
	 */

	public Events getAnEvent(String eventName) {
		String sql;
		sql = "SELECT * FROM " + tableName +
				"WHERE event_name = "+ eventName +";";
		Events event = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			event = new Events(cs.getString("event_name"), cs.getString("description"),
					cs.getString("location"), cs.getString("type_of_event"), cs.getString("date"),
					cs.getString("funding"), cs.getInt("expected_count"), cs.getInt("length_of_event"),
					cs.getInt("time"), cs.getInt("club_id_num"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return event;
	}
	/**
	 * update an event name in the database using the previous eventName
	 *  return true if successful
	 * 
	 * @param prevEventName
	 * @param eventName
	 * @return boolean
	 */
	public boolean updateEventName(String prevEventName, String eventName){
		String sql;
		sql = "UPDATE " + tableName + "SET event_name = '" + eventName + "' WHERE eventID = (SELECT eventID FROM " + tableName 
				+ "WHERE event_name = " + prevEventName + ");";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/***
	 * update the event description in the database, search for the correct even using the eventName
	 *  return true if successful
	 *  
	 * @param EventName
	 * @param description
	 * @return boolean
	 */
	
	public boolean updateEventDescription(String EventName, String description){
		String sql;
		sql = "UPDATE " + tableName + "SET description = '" + description + "' WHERE eventID = (SELECT eventID FROM " + tableName 
				+ "WHERE event_name = " + EventName + ");";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	/**
	 * update the event location for an event in the database, search for it using event name
	 *  return true if successful
	 * 
	 * @param EventName
	 * @param location
	 * @return boolean
	 */
	
	public boolean updateEventLocation(String EventName, String location){
		String sql;
		sql = "UPDATE " + tableName + "SET location = '" + location + "' WHERE eventID = (SELECT eventID FROM " + tableName 
				+ "WHERE event_name = " + EventName + ");";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * update the time of the event. search database using the event_name
	 *  return true if successful
	 * 
	 * @param EventName
	 * @param time
	 * @return boolean
	 */
	
	public boolean updateEventTime(String EventName, int time){
		String sql;
		sql = "UPDATE " + tableName + "SET time = '" + time + "' WHERE eventID = (SELECT eventID FROM " + tableName 
				+ "WHERE event_name = " + EventName + ");";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	/**
	 * delete an event from the database
	 * return true if successful
	 * 
	 * @param EventName
	 * @return boolean
	 */
	public boolean deleteEvent(String EventName){
		String sql;
		sql = "DELETE FROM " + tableName + "WHERE event_name = " + EventName + ";";
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
		} catch (SQLException e){
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
