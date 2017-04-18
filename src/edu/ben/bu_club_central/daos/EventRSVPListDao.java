package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;



public class EventRSVPListDao {
	private String tableName = "bu_club_central.event_rsvp_list";

	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	

	public void rsvpUserForEvent(int eventId, int user_id_num) {
		String sql = "INSERT INTO " + tableName + " (eventId, user_id_num) VALUES ('" + eventId + "', '" + user_id_num + "')";
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	/**
	 * This method checks the event rsvp list to see if the person has already rsvp for a certain event
	 * @param eventId
	 * @param user_id_num
	 * @return true if the user already rsvp for that event or false if the user has not rsvp for that event yet
	 */
	public boolean checkUserRsvpForEvent(int eventId, int user_id_num) {
		String sql = "SELECT * FROM " + tableName + " WHERE eventId = '" + eventId + "' AND user_id_num = '" + user_id_num + "'";
		
		PreparedStatement ps;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs.next()) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return true;
				
			}else {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	
	public LinkedList<User> getAllUsersForEvent(int eventId) {
		UserDao uDao = new UserDao();
		User u;
		
		LinkedList<User> userList = new LinkedList<User>();
		
		
		
		String sql = "SELECT * FROM " + tableName + " WHERE eventId=" + eventId;
		
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
				u = uDao.getUserByIdNum(rs.getInt("user_id_num"));
				userList.add(u);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
		
	}
	
	
	public LinkedList<Events> getAllEventsThatuserRSVP(int userId) {
		LinkedList<Integer> eventIdList = new LinkedList<Integer>();
		LinkedList<Events> eventList = new LinkedList<Events>();
		Events event;
		
		String sql = "SELECT * FROM " + tableName + " WHERE event_rsvp_list.user_id_num=" + userId;
		
		PreparedStatement ps, ps2;
		ResultSet rs, rs2;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				eventIdList.add(rs.getInt("eventId"));
				
			
			
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "SELECT * FROM bu_club_central.event WHERE idevent=?";
		int eventIdListIndex = 0;
		int eventIdListSize = eventIdList.size();
		try {
			
			
			while(eventIdListIndex < eventIdListSize) {
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, eventIdList.get(eventIdListIndex));
				rs2 = ps2.executeQuery();
				rs2.next();
				event = new Events(rs2.getString("event_name"), rs2.getString("description"), rs2.getString("location"), rs2.getInt("club_id_num"));
				event.setEventId(rs2.getInt("idevent"));
				eventList.add(event);
				
				eventIdListIndex++;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}
	
	
	public void unRSVPForEvent(int eventId, int id_num) {
		String sql = "DELETE FROM " + tableName + " WHERE eventId=" + eventId + " AND user_id_num=" + id_num;
		
		PreparedStatement ps;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
}