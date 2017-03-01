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
				+ " (club_name, pet_name, club_description, enabled, pet_email, advisor_name) VALUES ('" + club_name + "', '"+ pet_name + "', '" + club_description + "', '"+
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
				
				Club newClub = new Club( cs.getString("club_name"), cs.getInt("idClub"));
				results.add(newClub);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return results;
	}

	

}
