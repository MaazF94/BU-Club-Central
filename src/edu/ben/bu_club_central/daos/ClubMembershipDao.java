package edu.ben.bu_club_central.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.ClubMembership;
import edu.ben.bu_club_central.models.Post;

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
	private DatabaseConnection dbc;
	/**
	 * connects to the database
	 */
	private Connection conn;

	/**
	 * adds user to club(s). Have to keep in mind, duplicate entries. This is
	 * handled.
	 * 
	 * @param memberships
	 * @return true if added, false if not
	 */
	public boolean addUserToClubs(List<ClubMembership> memberships) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		boolean result = true;
		String sql = "";

		for (int i = 0; i < memberships.size(); i++) {
			ClubMembership m = memberships.get(i);

			sql = "INSERT INTO " + tableName + " (club_ID, user_ID, role_ID, active) VALUES (" + m.getClubID() + ", "
					+ m.getUserID() + ", " + m.getRoleID() + ", " + m.getActive()
					+ ") ON DUPLICATE KEY UPDATE active = 1 ";

			PreparedStatement ps;
			try {
				ps = conn.prepareStatement(sql);
				ps.executeUpdate(sql);
			} catch (SQLException e) {
				System.out.println("Already exists");
				e.printStackTrace();
				result = false;
			}
		}

		return result;
	}

	/**
	 * adds user to club(s). Have to keep in mind, duplicate entries. This is
	 * handled.
	 * 
	 * @param memberships
	 * @return true if added, false if not
	 */
	public boolean checkIfUserInClub(int club_id, int user_id) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "";
		ResultSet rs = null;

		sql = "SELECT club_id, user_id, active FROM " + tableName + " WHERE club_id = " + club_id + " AND user_id = "
				+ user_id + " AND active = 1";
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery(sql);
		} catch (SQLException e) {
			System.out.println("Does not exist");
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				if (rs.getString("club_id").equals(Integer.toString(club_id))) {
					if (rs.getString("user_id").equals(Integer.toString(user_id))) {
						if (rs.getString("active").equals(Integer.toString(1))) {
							rs.close();
							conn.close();
							dbc.closeConnection();
							return true;
						}
					}
				}
			}
		} catch (SQLException e) {
			System.out.println("Did not pull from username to see if it exists 2");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * Count members in a club by club ID
	 * 
	 * @param club_id
	 * @return the number of members in a club
	 */
	public int countClubMembers(int club_id) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
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
				rs.close();
				conn.close();
				dbc.closeConnection();
				return 0;
			} else {
				memberCount = rs.getInt("COUNT(club_id)");
				rs.close();
				conn.close();
				dbc.closeConnection();
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
	 * @param club_id_nums
	 * @return true if worked, otherwise false
	 */
	public boolean userLeavesClub(int user_id, int[] club_id_nums) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "";
		boolean result = true;

		for (int i = 0; i < club_id_nums.length; i++) {
			if (club_id_nums[i] != 0) {
				sql = "UPDATE " + tableName + " SET active = 0 WHERE user_id = " + user_id + " AND club_id = "
						+ club_id_nums[i];

				PreparedStatement ps;
				try {
					ps = conn.prepareStatement(sql);
					ps.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("User does not exist in club");
					e.printStackTrace();
					result = false;
				}
			}
		}
		return result;
	}

	/**
	 * removes a user from a club
	 * 
	 * @param club_id
	 *            Integer
	 * @param userIDs
	 *            Integer array
	 */
	public void removeUserFromClub(int club_id, int[] userIDs) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "";

		for (int i = 0; i < userIDs.length; i++) {
			if (userIDs[i] != 0) {
				sql = "UPDATE " + tableName + " SET active = 0 WHERE user_id = " + userIDs[i] + " AND club_id = "
						+ club_id;

				PreparedStatement ps;

				try {
					ps = conn.prepareStatement(sql);
					ps.executeUpdate(sql);
				} catch (SQLException e) {
					System.out.println("User does not exist in club");
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Used to display which clubs a user is in on dashboard
	 * 
	 * @param user_id
	 * @return list of clubs user is in
	 */
	public LinkedList<ClubMembership> displayUserClubInfo(int user_id) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<ClubMembership> ClubMembershipList = new LinkedList<ClubMembership>();
		String sql = "";

		sql = "SELECT * from " + tableName + " CM inner join club C, user U"
				+ " where C.club_id_num = CM.club_ID and CM.user_ID = U.iduser and CM.user_ID = " + user_id
				+ " and active = 1";

		PreparedStatement ps;
		ResultSet rs = null;
		;
		ClubMembership newClubMembership;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				newClubMembership = new ClubMembership(rs.getInt("club_ID"), rs.getInt("user_ID"), rs.getInt("role_ID"),
						rs.getBoolean("active"), rs.getString("club_name"));
				ClubMembershipList.add(newClubMembership);

			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ClubMembershipList;
	}

	/**
	 * Used to display which clubs a user is in on dashboard
	 * 
	 * @param user_id
	 * @return list of clubs user is in
	 */
	public LinkedList<ClubMembership> displayUserPastClubInfo(int user_id) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<ClubMembership> ClubMembershipList = new LinkedList<ClubMembership>();
		String sql = "";

		sql = "SELECT * from " + tableName + " CM inner join club C, user U"
				+ " where C.club_id_num = CM.club_ID and CM.user_ID = U.iduser and CM.user_ID = " + user_id
				+ " and active = 0";

		PreparedStatement ps;
		ResultSet rs = null;
		;
		ClubMembership newClubMembership;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				newClubMembership = new ClubMembership(rs.getInt("club_ID"), rs.getInt("user_ID"), rs.getInt("role_ID"),
						rs.getBoolean("active"), rs.getString("club_name"));
				ClubMembershipList.add(newClubMembership);

			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return ClubMembershipList;
	}
	
	/**
	 * gets all the clubs a user is apart of
	 * @param user_ID Integer
	 * @return linked list of club objects
	 */
	public LinkedList<Club> getAllClubsApartOf(int user_ID) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE user_ID=" + user_ID + " and active = 1";
		
		LinkedList<Integer> clubIdNumList = new LinkedList<Integer>();
		
		PreparedStatement ps, ps2;
		ResultSet rs, cs;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				clubIdNumList.add(rs.getInt("club_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int index = 0;
		int size = clubIdNumList.size();
		
		LinkedList<Club> clubList = new LinkedList<Club>();
		
		String sql2 = "SELECT * FROM bu_club_central.club WHERE club_id_num=?";
		
		while(index < size) {
			try {
				ps2 = conn.prepareStatement(sql2);
				ps2.setInt(1, clubIdNumList.get(index));
				cs = ps2.executeQuery();
				cs.next();
				clubList.add(new Club(cs.getInt("club_id_num"), cs.getString("club_name"), cs.getString("pet_name"),
						cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name"),
						cs.getInt("enabled"), cs.getString("meeting_time"), cs.getString("meeting_freq"),
						cs.getString("meeting_loc"), cs.getString("broadcast_update"), cs.getString("preference")));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			index++;
		}
		
		try {
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clubList;
	}

}
