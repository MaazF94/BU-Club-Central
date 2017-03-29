package edu.ben.bu_club_central.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Club;



public class ClubDao {
	/**
	 * Establishes the name of the table being used
	 */
	private String tableName = "bu_club_central.club";
	/**
	 * intialized club object
	 */
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
	private DatabaseConnection dbc = new DatabaseConnection();
	/**
	 * connects to the database
	 */
	private Connection conn = dbc.getConn();
	
	public int clubID =0;

	/**
	 * Adds a new club to the database table
	 * @param club_name name of the club
	 * @param pet_name the name of the head petitioner for the club
	 * @param club_description a description of the club
	 * @param enabled either 1 or 0
	 * @param pet_email the head petitioners email
	 * @param advisor_name the name of the clubs advisor
	 */
	public void addClub( String club_name, String pet_name, String club_description, int enabled, String pet_email, String advisor_name ) {
		String sql = "INSERT INTO " + tableName
				+ " (club_id_num, club_name, pet_name, club_description, enabled, pet_email, advisor_name) VALUES ('" + ++clubID + "', '" + club_name + "', '"+ pet_name + "', '" + club_description + "', '"+
				 enabled + "','" + pet_email+"','"+advisor_name+ "')"; 
	
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
	}
	
	/**
	 * Display club gets the list of current clubs and adds them to a linked list. This allows them to be displayed in a JSP 
	 * @return the linked list of the current clubs.
	 */
	public LinkedList<Club> displayClub() {
	 LinkedList<Club> results = new LinkedList<Club>();
		String sql;
		
		
		sql = "SELECT * FROM " + tableName;
		
			

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			
			while (cs.next()) {
				
				Club newClub = new Club( cs.getInt("club_id_num"), cs.getString("club_name"),cs.getString("pet_name"), cs.getString("club_description"), cs.getString("pet_email"), cs.getString("advisor_name") );
				results.add(newClub);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	public Club getClubById(int clubId) {
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
			while(rs.next()) {
				club = new Club( rs.getInt("club_id_num"), rs.getString("club_name"),rs.getString("pet_name"), rs.getString("club_description"), rs.getString("pet_email"), rs.getString("advisor_name") );
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return club;
	}
	
	public LinkedList<Club> getAllClubs() {
		String sql = "SELECT * FROM " + tableName;
		
		PreparedStatement ps;
		ResultSet rs = null;
		Club club = null;
		LinkedList<Club> clubList =  new LinkedList<Club>();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				club = new Club( rs.getInt("club_id_num"), rs.getString("club_name"),rs.getString("pet_name"), rs.getString("club_description"), rs.getString("pet_email"), rs.getString("advisor_name") );
				club.setMemeber_count(rs.getInt("member_count"));
				club.setEnabled(rs.getInt("enabled"));
				clubList.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clubList;
	}

//	public void deleteClub( String club_name) {
//		String sql = "DELETE FROM" + tableName + "WHERE club_name ="+ "'"+ club_name +"'"; 
//	
//		PreparedStatement ps;  
//		try {
//			ps = conn.prepareStatement(sql);
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("Did not update");
//			e.printStackTrace();
//		}
//		
//	}
//	
	public void deleteClub(String club_id_num) {
		String sql = "SELECT * FROM " + tableName;
		
		try {
			PreparedStatement query = conn.prepareStatement(sql);
			ResultSet rs = query.executeQuery();

			if (rs.next()) {
				PreparedStatement ps;
				
				ps = conn.prepareStatement("DELETE FROM " + tableName + " WHERE club_id_num = " + "'"+club_id_num+"'");

				System.out.println(ps);

				ps.executeUpdate();
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public void disableClub(int club_id_num) {
		String sql = "UPDATE " + tableName + " SET enabled = 0 WHERE club_id_num = " + club_id_num;
		
	PreparedStatement ps;
	ResultSet rs;
	
	try {
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * allow board member to edit club description from dashboard
	 * @param club_description
	 * @param club_id_num
	 */
	public void editClubDescription(String club_description, int club_id_num) {
		String sql = "UPDATE " + tableName + " SET club_description = '" + club_description + "'" + 
						" WHERE club_id_num = " + club_id_num;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
	}

	
	public void enableClub(int club_id_num) {
		String sql = "UPDATE " + tableName + " SET enabled = 1 WHERE club_id_num = " + club_id_num;
		
	PreparedStatement ps;
	ResultSet rs;
	
	try {
		ps = conn.prepareStatement(sql);
		ps.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	}
	

}
