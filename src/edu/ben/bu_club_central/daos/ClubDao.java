package edu.ben.bu_club_central.daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import edu.ben.bu_club_central.models.Club;


public class ClubDao {
	private String tableName = "bu_club_central.club";
	
	private Club clubObject;
	private int enabled = 1;
	private int disabled = 0;
	
	private DatabaseConnection dbc = new DatabaseConnection();
	private Connection conn = dbc.getConn();

	
	public void addClub( String club_name, int club_id_num, int member_count, int enabled ) {
		String sql = "INSERT INTO " + tableName
				+ " (club_name, club_id_num, member_count, enabled) VALUES ('" + club_name + "', '"+ club_id_num + "', '" + member_count + "', '"  + enabled
				+ "')"; 
	
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Did not update");
			e.printStackTrace();
		}
	}

	public LinkedList<Club> displayClub() {
	 LinkedList<Club> results = new LinkedList<Club>();
		String sql;
		
		
		sql = "SELECT * FROM " + tableName;
		
			System.out.println(sql);

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet cs = ps.executeQuery();
			
			while (cs.next()) {
				
				Club newClub = new Club( cs.getString("club_name"), cs.getInt("club_id_num"));
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
				club = new Club(rs.getString("club_name"), rs.getInt("club_id_num"));
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
		LinkedList<Club> clubList = null;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				club = new Club(rs.getString("club_name"), rs.getInt("club_id_num"));
				clubList.add(club);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return clubList;
	}
	

}
