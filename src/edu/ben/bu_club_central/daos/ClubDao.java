package edu.ben.bu_club_central.daos;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Club;
import edu.ben.bu_club_central.models.User;

public class ClubDao {
	private String tableName = "club";

	private Club clubObject;
	/**
	 * variable to distinguish user
	 */
	private int enabled = 1;
	/**
	 * variable to distinguish user
	 */
	private int disabled = 0;
	/**
	 * intializes connection to database
	 */
	private DatabaseConnection dbc;
	/**
	 * connects to the database
	 */
	private Connection conn;

	public int clubID = 0;

	/**
	 * Adds a new club to the database table
	 * 
	 * @param club_name
	 *            name of the club
	 * @param pet_name
	 *            the name of the head petitioner for the club
	 * @param club_description
	 *            a description of the club
	 * @param enabled
	 *            either 1 or 0
	 * @param pet_email
	 *            the head petitioners email
	 * @param advisor_name
	 *            the name of the clubs advisor
	 * @param string
	 */
	public boolean addClub(String club_name, String pet_name, String club_description, int enabled, String pet_email,
			String advisor_name, String preference) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT max(club_id_num) from " + tableName + "";
		System.out.println("This is the preference: " + preference);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {

				clubID = cs.getInt("max(club_id_num)");
				++clubID;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		sql = "INSERT INTO " + tableName

				+ " (club_id_num, club_name, pet_name, club_description, enabled, pet_email, advisor_name, preference) VALUES ("
				+ clubID + ", '" + club_name + "', '" + pet_name + "', '" + club_description + "', " + enabled + ",'"
				+ pet_email + "','" + advisor_name + "','" + preference + "')";

		try {
			PreparedStatement ps;
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
		}

		return false;
	}

	/**
	 * Display club gets the list of current clubs and adds them to a linked
	 * list. This allows them to be displayed in a JSP
	 * 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<Club> displayClub() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Club> results = new LinkedList<Club>();
		String sql;

		sql = "SELECT * FROM " + tableName + " where enabled = 1";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {

				Club newClub = new Club(cs.getInt("club_id_num"), cs.getString("club_name"), cs.getString("pet_name"),
						cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name"),
						cs.getInt("enabled"), cs.getString("meeting_time"), cs.getString("meeting_freq"),
						cs.getString("meeting_loc"), cs.getString("broadcast_update"), cs.getString("preference"));
				results.add(newClub);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	/**
	 * Display club gets the list of current clubs and adds them to a linked
	 * list. This allows them to be displayed in a JSP
	 * 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<Club> displayClubWithoutBM() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Club> results = new LinkedList<Club>();
		String sql;

		sql = "SELECT * FROM " + tableName
				+ " left outer join user on club.club_id_num = user.club_id_num where club.enabled = 1 and user.club_id_num is null";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {

				Club newClub = new Club(cs.getInt("club_id_num"), cs.getString("club_name"), cs.getString("pet_name"),
						cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name"),
						cs.getInt("enabled"), cs.getString("meeting_time"), cs.getString("meeting_freq"),
						cs.getString("meeting_loc"), cs.getString("broadcast_update"), cs.getString("preference"));

				results.add(newClub);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	/**
	 * Display club gets the list of current clubs and adds them to a linked
	 * list. This allows them to be displayed in a JSP
	 * 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<Club> displayClubForAdmin() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Club> results = new LinkedList<Club>();
		String sql;

		sql = "SELECT * FROM " + tableName + ";";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {

				Club newClub = new Club(cs.getInt("club_id_num"), cs.getString("club_name"), cs.getString("pet_name"),
						cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name"),
						cs.getInt("enabled"), cs.getString("meeting_time"), cs.getString("meeting_freq"),
						cs.getString("meeting_loc"), cs.getString("broadcast_update"), cs.getString("preference"));

				results.add(newClub);
			}
			cs.close();

			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	/**
	 * gets a club by its id
	 * 
	 * @param clubId
	 *            Integer
	 * @return club object
	 */
	public Club getClubById(int clubId) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + " WHERE club_id_num=" + clubId;

		PreparedStatement ps;
		ResultSet rs = null;
		Club club = null;

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {

			while (rs.next()) {
				club = new Club(rs.getInt("club_id_num"), rs.getString("club_name"), rs.getString("pet_name"),
						rs.getString("club_description"), rs.getString("pet_email"), rs.getString("advisor_name"),
						rs.getInt("enabled"), rs.getString("meeting_time"), rs.getString("meeting_freq"),
						rs.getString("meeting_loc"), rs.getString("broadcast_update"), rs.getString("preference"));

			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return club;
	}

	/**
	 * gets all the clubs
	 * 
	 * @return linked list of club objects
	 */
	public LinkedList<Club> getAllClubs() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName;

		PreparedStatement ps;
		ResultSet rs = null;
		Club club = null;
		LinkedList<Club> clubList = new LinkedList<Club>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				club = new Club(rs.getInt("club_id_num"), rs.getString("club_name"), rs.getString("pet_name"),
						rs.getString("club_description"), rs.getString("pet_email"), rs.getString("advisor_name"),
						rs.getInt("enabled"), rs.getString("meeting_time"), rs.getString("meeting_freq"),
						rs.getString("meeting_loc"), rs.getString("broadcast_update"), rs.getString("preference"));

				clubList.add(club);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clubList;
	}

	/**
	 * deletes a club
	 * 
	 * @param club_id_num
	 *            String
	 */
	public void deleteClub(String club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName;

		try {
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				PreparedStatement ps;

				ps = conn.prepareStatement(
						"DELETE FROM " + tableName + " WHERE club_id_num = " + "'" + club_id_num + "'");

				System.out.println(ps);

				ps.executeUpdate();
				ps.close();
				conn.close();
				dbc.closeConnection();

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * allow board member to edit club description from dashboard
	 * 
	 * @param club_description
	 *            String
	 * @param club_id_num
	 *            Integer
	 */
	public boolean editClubDescription(String club_description, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET club_description = '" + club_description + "'"
				+ " WHERE club_id_num = " + club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * edits meeting time
	 * 
	 * @param meeting_time
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @return true if edited false otherwise
	 */
	public boolean editClubMeetingTime(String meeting_time, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET meeting_time = '" + meeting_time + "'" + " WHERE club_id_num = "
				+ club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * edit club meeting location
	 * 
	 * @param meeting_loc
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @return true if updated false otherwise
	 */
	public boolean editClubMeetingLoc(String meeting_loc, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET meeting_loc = '" + meeting_loc + "'" + " WHERE club_id_num = "
				+ club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @param meeting_freq
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @return true if updated false otherwise
	 */
	public boolean editClubMeetingFreq(String meeting_freq, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET meeting_freq = '" + meeting_freq + "'" + " WHERE club_id_num = "
				+ club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * 
	 * @param broadcast
	 *            String
	 * @param club_id_num
	 *            Integer
	 * @return true if updated false otherwise
	 */
	public boolean editClubBroadcast(String broadcast, int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET broadcast_update = '" + broadcast + "'" + " WHERE club_id_num = "
				+ club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			if (ps.executeUpdate() == 1) {
				ps.close();
				conn.close();
				dbc.closeConnection();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * disable club
	 * 
	 * @param club_id_num
	 *            Integer
	 */
	public void disableClub(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET enabled = 0 WHERE club_id_num = " + club_id_num;

		PreparedStatement ps;
		ResultSet rs;

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
	 * enable club
	 * 
	 * @param club_id_num
	 *            Integer
	 */
	public void enableClub(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "UPDATE " + tableName + " SET enabled = 1 WHERE club_id_num = " + club_id_num;

		PreparedStatement ps;
		ResultSet rs;

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
	 * counts how many people are in each club
	 * 
	 * @param club_id_num
	 *            Integer
	 * @return Integer
	 */
	public int countMemebers(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<User> list = new LinkedList<User>();
		User user;
		String sql = "SELECT * FROM  bu_club_central.user WHERE club_id_num = " + club_id_num;
		int size = 0;
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
				user = new User(rs.getString("first_name"), rs.getString("last_name"), rs.getString("username"),
						rs.getString("passwrd"), rs.getInt("id_num"), rs.getString("email"), rs.getInt("role_id"),
						rs.getInt("iduser"), rs.getInt("enabled"), rs.getString("preference"),
						rs.getInt("club_id_num"));

				list.add(user);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		size = list.size();

		return size;
	}

	/**
	 * shoes club preferences
	 * 
	 * @param preference
	 *            String
	 * @return linked list of club objects
	 */
	public LinkedList<Club> displayClubByPreference(String preference) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Club> results = new LinkedList<Club>();
		String sql;

		sql = "SELECT * FROM " + tableName + " where preference =" + "'" + preference + "'" + " and enabled = 1";
		System.out.println(sql);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();

			while (cs.next()) {

				Club newClub = new Club(cs.getInt("club_id_num"), cs.getString("club_name"), cs.getString("pet_name"),
						cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name"),
						cs.getInt("enabled"), cs.getString("meeting_time"), cs.getString("meeting_freq"),
						cs.getString("meeting_loc"), cs.getString("broadcast_update"), cs.getString("preference"));

				results.add(newClub);
			}
			cs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public LinkedList<Club> displayClubsByUserPreference(String preference) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		LinkedList<Club> results = new LinkedList<Club>();
		String sql;
		String[] preferenceArray = null;
		if (preference.contains(",")) {
			preferenceArray = preference.split(",");
		} else {
			preferenceArray = preference.split(" ");
		}

		for (int i = 0; i < preferenceArray.length; i++) {
			sql = "SELECT * FROM " + tableName + " where preference =" + "'" + preferenceArray[i] + "'";
			System.out.println(sql);
			try {
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet cs = ps.executeQuery();

				while (cs.next()) {

					Club newClub = new Club(cs.getInt("club_id_num"), cs.getString("club_name"),
							cs.getString("pet_name"), cs.getString("club_description"), cs.getString("pet_email"),
							cs.getString("advisor_name"), cs.getInt("enabled"), cs.getString("meeting_time"),
							cs.getString("meeting_freq"), cs.getString("meeting_loc"), cs.getString("broadcast_update"),
							cs.getString("preference"));

					results.add(newClub);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return results;
	}

	public boolean addImage(int club_id_num, InputStream is, long size) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "UPDATE " + tableName + " SET club_image = ? WHERE club_id_num = " + club_id_num + ";";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setBinaryStream(1, is, (int) size);
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

	public byte[] getClubPhoto(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "SELECT club_image from " + tableName + " WHERE club_id_num = " + club_id_num + ";";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				byte[] content = rs.getBytes("club_image");
				return content;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	/**
	 * gets all the clubs
	 * 
	 * @return linked list of club objects
	 */
	public LinkedList<Club> getAllClubsWithEvents() {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql = "SELECT * FROM " + tableName + "where ";

		PreparedStatement ps;
		ResultSet rs = null;
		Club club = null;
		LinkedList<Club> clubList = new LinkedList<Club>();

		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				club = new Club(rs.getInt("club_id_num"), rs.getString("club_name"), rs.getString("pet_name"),
						rs.getString("club_description"), rs.getString("pet_email"), rs.getString("advisor_name"),
						rs.getInt("enabled"), rs.getString("meeting_time"), rs.getString("meeting_freq"),
						rs.getString("meeting_loc"), rs.getString("broadcast_update"), rs.getString("preference"));

				clubList.add(club);
			}
			rs.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return clubList;
	}

	public boolean ClubExists(String club) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();

		boolean clubExists = false;

		String sql = "SELECT * FROM " + tableName + " WHERE club_name = '" + club + "'";

		try {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String clubs = rs.getString("event_name");

				if (clubs.contains(club)) {
					clubExists = true;
				}
			}
			conn.close();
			dbc.closeConnection();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return clubExists;
	}
	

	
	
	
	

	public boolean addPresident(int club_id_num, String President) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Update " + tableName + " SET President = '" + President + "' WHERE club_id_num = " + club_id_num + ";";
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

	public boolean addVicePresident(int club_id_num, String VicePresident) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Update " + tableName + " SET Vice_President = '" + VicePresident + "' WHERE club_id_num = " + club_id_num
				+ ";";
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

	public boolean addTreasurer(int club_id_num, String Treasurer) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Update " + tableName + " SET Treasurer = '" + Treasurer + "' WHERE club_id_num = " + club_id_num + ";";
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

	public boolean addSecretary(int club_id_num, String Secretary) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Update " + tableName + " SET Secretary = '" + Secretary + "' WHERE club_id_num = " + club_id_num + ";";
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

	public String getPresident(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Select President FROM club WHERE club_id_num = " + club_id_num + ";";
		PreparedStatement ps;
		String President = "";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				President = rs.getString("President");
			}
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return "n/a";
		}
		if (President == null) {
			return "None Assigned";
		} else {
			return President;
		}
	}

	public String getVicePresident(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Select Vice_President FROM club WHERE club_id_num = " + club_id_num + ";";
		PreparedStatement ps;
		String VicePresident = "N/A";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				VicePresident = rs.getString("Vice_President");
			}
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return "n/a";
		}
		if (VicePresident == null) {
			return "None Assigned";
		} else {
			return VicePresident;
		}
	}

	public String getTreasurer(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Select Treasurer FROM club WHERE club_id_num = " + club_id_num + ";";
		PreparedStatement ps;
		String Treasurer = "N/A";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Treasurer = rs.getString("Treasurer");
			}
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return "n/a";
		}
		if (Treasurer == null) {
			return "None Assigned";
		} else {
			return Treasurer;
		}
	}

	public String getSecretary(int club_id_num) {
		dbc = new DatabaseConnection();
		conn = dbc.getConn();
		String sql;
		sql = "Select Secretary FROM club WHERE club_id_num = " + club_id_num + ";";
		PreparedStatement ps;
		String Secretary = "N/A";
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Secretary = rs.getString("Secretary");
			}
			ps.close();
			conn.close();
			dbc.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
			return "n/a";
		}
		if (Secretary == null) {
			return "None Assigned";
		} else {
			return Secretary;
		}
	}

}
