/**
 * 
 */
package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Raza Mohammed
 *
 */
public class ItemsForCheckoutDao {
	/**
	 * Initializes connection to database
	 */
	private DatabaseConnection dbc;
	/**
	 * connects to the database
	 */
	private Connection conn;
	private String tableName = "items_for_checkout";

	public void checkoutWiiU(String name, String studentID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String checkoutby = name + ", " + studentID;
		String sql = "INSERT into " + tableName + "(Item_Name, checked_out_by, checkoutTime) values ('WiiU', '"
				+ checkoutby + "', " + "NOW());";
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
		}
	}

	public void checkinWiiU(String name, String studentID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String checkoutby = name + ", " + studentID;
		String sql = "UPDATE " + tableName + " SET";
	}

	public void checkoutPool(String name, String studentID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String checkoutby = name + ", " + studentID;
		String sql = "INSERT into " + tableName + "(Item_Name, checked_out_by, checkoutTime) values ('Pool', '"
				+ checkoutby + "', " + "NOW());";
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
		}
	}

	public void checkinPool(String name, String studentID) {

	}

	public void checkoutAirHockey(String name, String studentID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String checkoutby = name + ", " + studentID;
		String sql = "INSERT into " + tableName + "(Item_Name, checked_out_by, checkoutTime) values ('Air Hockey', '"
				+ checkoutby + "', " + "NOW());";
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
		}
	}

	public void checkinAirHockey(String name, String studentID) {

	}

	public void checkoutPingPong(String name, String studentID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String checkoutby = name + ", " + studentID;
		String sql = "INSERT into " + tableName + "(Item_Name, checked_out_by, checkoutTime) values ('Ping Pong', '"
				+ checkoutby + "', " + "NOW());";
		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
		}
	}

	public void checkinPingPong(String name, String studentID) {

	}

	public boolean checkedOut(int itemId) {
		return false;
	}
}
