package edu.ben.bu_club_central.JUnitTest.ClubDao;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.ClubDao;
import edu.ben.bu_club_central.daos.DatabaseConnection;


/**
 * 
 * @author Frank Rooks
 * @ version 1
 *
 */
public class ClubDaoTest {

	ClubDao cd = new ClubDao();
	
	/**
	 * Checks to see if adding club works, shouldnt work until the admin accepts the club.
	 */
	@Test
	public void testAddClub() {
		DatabaseConnection dc = new DatabaseConnection();
		dc.getConn();
		
		cd.addClub("TestClub", "Joel", "This is to test if it is working", 1, "Joel@almostDone.com", "Larry Pollack", "other");
		
		boolean expected = true;
		boolean actual =cd.ClubExists("TestClub");
		assertEquals(expected, actual);	
	
	}

}
