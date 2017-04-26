package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Events;
import edu.ben.bu_club_central.models.User;

public class EventRSVPListDao {
	/**
	 * database table name
	 */
	private String tableName = "bu_club_central.event_rsvp_list";

	/**
	 * database connection
	 */
	private DatabaseConnection dbc;

	/**
	 * connection
	 */
	private Connection conn;

	/**
	 * this rsvps a user for an event
	 * 
	 * @param eventId
	 *            Integer
	 * @param user_id_num
	 *            Integer
	 */
	public void rsvpUserForEvent(int eventId, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "INSERT INTO " + tableName + " (eventId, user_id_num) VALUES ('" + eventId + "', '" + user_id_num
				+ "')";

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
	 * This method checks the event rsvp list to see if the person has already
	 * rsvp for a certain event
	 * 
	 * @param eventId
	 * @param user_id_num
	 * @return true if the user already rsvp for that event or false if the user
	 *         has not rsvp for that event yet
	 */
	public boolean checkUserRsvpForEvent(int eventId, int user_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE eventId = '" + eventId + "' AND user_id_num = '"
				+ user_id_num + "'";

		PreparedStatement ps;
		ResultSet rs = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs.next()) {
				rs.close();
				conn.close();
				dbc.closeConnection();
				return true;

			} else {

				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * gets all users that are going to an event
	 * 
	 * @param eventId
	 *            Integer
	 * @return linked list of user objects
	 */
	public LinkedList<User> getAllUsersForEvent(int eventId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
			while (rs.next()) {
				u = uDao.getUserByIdNum(rs.getInt("user_id_num"));
				userList.add(u);

			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;

	}

	/**
	 * gets all events that a user said that they will be going to
	 * 
	 * @param userId
	 *            Integer
	 * @return linked list of event objects
	 */
	public LinkedList<Events> getAllEventsThatuserRSVP(int userId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Integer> eventIdList = new LinkedList<Integer>();
		LinkedList<Events> eventList = new LinkedList<Events>();
		Events event;

		String sql = "SELECT * FROM " + tableName + " WHERE event_rsvp_list.user_id_num=" + userId;

		PreparedStatement ps, ps2;
		ResultSet rs, rs2;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				eventIdList.add(rs.getInt("eventId"));
			}
			rs.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		String sql2 = "SELECT * FROM bu_club_central.event WHERE idevent=?";
		int eventIdListIndex = 0;
		int eventIdListSize = eventIdList.size();
		try {

			while (eventIdListIndex < eventIdListSize) {
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, eventIdList.get(eventIdListIndex));
				rs2 = ps2.executeQuery();
				rs2.next();
				event = new Events(rs2.getString("event_name"), rs2.getString("description"), rs2.getString("location"),
						rs2.getInt("club_id_num"), rs2.getString("category"));
				event.setEventId(rs2.getInt("idevent"));
				eventList.add(event);

				eventIdListIndex++;
			}
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return eventList;
	}

	/**
	 * this removes a user from the rsvp list for an event
	 * 
	 * @param eventId
	 *            Integer
	 * @param id_num
	 *            Integer
	 */
	public void unRSVPForEvent(int eventId, int id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "DELETE FROM " + tableName + " WHERE eventId=" + eventId + " AND user_id_num=" + id_num;

		PreparedStatement ps;

		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}