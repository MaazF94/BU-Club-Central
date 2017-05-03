package edu.ben.bu_club_central.daos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.ItemForCheckout;

public class BenUnionDao {
	private DatabaseConnection dbc;
	private Connection conn;
	private String tableName = "items_for_checkout";

	public boolean checkOutItem(String item, String checkedOutBy) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "INSERT INTO " + tableName + " (Item_Name, checked_out_by, checkoutTime) values " + "( '" + item + "', '"
				+ checkedOutBy + "' , NOW());";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.execute();
			ps.close();
			conn.close();
			dbc.closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean checkInItem(int itemId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "UPDATE " + tableName + " SET checkinTime = NOW() WHERE checkinTime IS NULL AND itemID = " + itemId + ";";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			conn.close();
			dbc.closeConnection();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public LinkedList<ItemForCheckout> getItemsNotCheckedIn() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "SELECT * FROM " + tableName + " WHERE checkinTime IS NULL;";
		PreparedStatement ps;
		ItemForCheckout item = null;
		LinkedList<ItemForCheckout> itemList = new LinkedList();
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String checkOutTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(rs.getTimestamp("checkoutTime"));
				item = new ItemForCheckout(rs.getInt("itemID"), rs.getString("item_Name"),
						rs.getString("checked_out_by"), checkOutTime);
				itemList.add(item);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return itemList;
	}
}
