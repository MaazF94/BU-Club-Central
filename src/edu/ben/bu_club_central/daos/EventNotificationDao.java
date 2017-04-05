package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.EventNotification;
import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;

public class EventNotificationDao {
	private String tableName = "bu_club_central.event_notifications";
	
	private DatabaseConnection dbc = new DatabaseConnection();
	
	private Connection conn = dbc.getConn();
	
	
	/**
	 * every time a new event is added this method will add each user to this table with a flag set to false menaing 
	 * they have not seen that event yet
	 * @param eventId
	 */
	public void addEventsAndUsers(int eventId) {
		UserDao uDao = new UserDao();
		
		LinkedList<User> userList = new LinkedList<User>();
		userList = uDao.getAllUsers();
		
		PreparedStatement ps;
		
		
		String sql = "INSERT into " + tableName + " VALUES (?, ?, ?)";
		
		int listIndex = 0;
		int listSize = userList.size();
		
		while(listIndex < listSize) {
			try {
				ps = conn.prepareStatement(sql);
				ps.setInt(1, eventId);
				ps.setInt(2, userList.get(listIndex).getId_num());
				ps.setBoolean(3, false);
				ps.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			listIndex++;
		}
	}
	
	
	/**
	 * this gets all the events that the user has not seen yet from the event notification table
	 * @param id_num
	 * @return
	 */
	public LinkedList<Events> getEventNotifications(int id_num) {
		LinkedList<EventNotification> eventNotificationList = new LinkedList<EventNotification>();
		EventNotification eN;
		
		String sql = "SELECT * FROM " + tableName + " WHERE flag = false and userId = " + id_num;
		
		PreparedStatement ps;
		ResultSet rs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				eN = new EventNotification(rs.getInt("eventId"), rs.getInt("userId"));
				eN.setFlag(rs.getBoolean("flag"));
				
				eventNotificationList.add(eN);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int eventNotificationIndex = 0;
		int eventNotificationListSize = eventNotificationList.size();
		
		LinkedList<Events> eventsList = new LinkedList<Events>();
		Events event;
		
		EventsDao eDao = new EventsDao();
		
		while(eventNotificationIndex < eventNotificationListSize) {
			event = eDao.getEventByEventId(eventNotificationList.get(eventNotificationIndex).getEventId());
			
			eventsList.add(event);
			
			eventNotificationIndex++;
		}
		
		
		return eventsList;
		
		
	}
	
	/**
	 * this method flips the flag on the event notification table when a user visits the event details page of that event
	 * @param eventId
	 * @param id_num
	 */
	public void checkedNotification(int eventId, int id_num) {
		String sql = "UPDATE " + tableName + " SET flag = true WHERE eventId = " + eventId + " AND userId = " + id_num;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	

}
