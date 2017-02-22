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
	private String tableName = "bu_club_central.event";
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
	 * add a single event object into the database
	 */
	private void addEvent(String event_name, String description, String location, String type_of_event,
			String date, String funding, int expected_count, int length_of_event, int time, int club_id_num){
		String sql = "INSERT INTO " + tableName 
				+ "(event_name, description, location, date, funding, expected_count, length_of_event, time, type_of_event," 
				+ " club_id_num) VALUES ('" + event_name + "', '" + description + "', '" + location +
				"', '" + date + "', '" + funding + "', '" + expected_count + "', '" + length_of_event +
				"', '" + type_of_event + "', '" + time + "', '" + club_id_num + "')";
		PreparedStatement ps;
		try{
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<Events> getAllEvents(){
		ArrayList<Events> results = new ArrayList<Events>();
		String sql;
		sql = "SELECT * FROM " + tableName;
		
		try{
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			
			while(cs.next()){
				Events event = new Events(cs.getString("event_name"), cs.getString("description"), cs.getString("location"),
						cs.getString("type_of_event"), cs.getString("date"), cs.getString("funding"), cs.getInt("expected_count"), 
						cs.getInt("length_of_event"), cs.getInt("time"), cs.getInt("club_id_num"));
				results.add(event);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return results;
	}
}
