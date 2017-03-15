package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import edu.ben.bu_club_central.models.ClubMembership;

public class ClubMembershipDao {

	/**
	 * Establishes the name of the table being used
	 */
	private String tableName = "bu_club_central.club_membership";

	/**
	 * intialized clubMembership object
	 */
	private ClubMembership clubMembershipObject;

	/**
	 * intializes connection to database
	 */
	private DatabaseConnection dbc = new DatabaseConnection();
	/**
	 * connects to the database
	 */
	private Connection conn = dbc.getConn();

	/**
	 * adds user to club(s). Have to keep in mind, duplicate entries. This is
	 * handled.
	 * 
	 * @param memberships
	 * @return true if added, false if not
	 */
	public boolean addUserToClubs(List<ClubMembership> memberships) {

		boolean result = true;
		String sql = "";

		for (int i = 0; i < memberships.size(); i++) {
			ClubMembership m = memberships.get(i);

			sql = "INSERT INTO " + tableName + " (club_ID, user_ID, role_ID, active) VALUES (" + m.getClubID() + ", "
					+ m.getUserID() + ", " + m.getRoleID() + ", " + m.getActive() + ") ";

			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
				if (ps.executeUpdate() != 1) {
					throw new SQLException();
				}
			} catch (SQLException e) {
				System.out.println("Already exists");
				e.printStackTrace();
				result = false;
			}
		}

		return result;
	}

	/**
	 * Count members in a club by club ID
	 * 
	 * @param club_id
	 * @return the number of members in a club
	 */
	public int countClubMembers(int club_id) {
		String sql = "";
		int memberCount = 0;

		sql = "SELECT COUNT(club_id) FROM " + tableName + " WHERE club_id = " + club_id + " AND active = 1";

		PreparedStatement ps;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			System.out.println("Club does not exist");
			e.printStackTrace();
		}

		try {
			if (!rs.next()) {
				return 0;
			} else {
				memberCount = rs.getInt("COUNT(club_id)");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return memberCount;
	}

	/**
	 * Allows the user to leave a club
	 * 
	 * @param user_id
	 * @param club_id
	 * @return true if worked, otherwise false
	 */
	public boolean userLeavesClub(int user_id, int club_id) {
		String sql = "";

		sql = "UPDATE " + tableName + " SET active = 0 WHERE user_id = " + user_id + " AND club_id = " + club_id;

		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				return true;
			} else {
				throw new SQLException();
			}
		} catch (SQLException e) {
			System.out.println("User does not exist in club");
			e.printStackTrace();
		}

		return false;
	}

}
