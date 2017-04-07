package edu.ben.bu_club_central.JUnitTests.clubMembershipDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.ClubMembershipDao;

public class ClubMembershipDao_checkIfUserInClub {

	private ClubMembershipDao cmDao = new ClubMembershipDao();
	
	@Test
	public void enableUserTest() {
		boolean expected = true;
		boolean actual = cmDao.checkIfUserInClub(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void enableUserTest2() {
		boolean expected = false;
		boolean actual = cmDao.checkIfUserInClub(1, 2);
		assertEquals(expected, actual);
	}

}
