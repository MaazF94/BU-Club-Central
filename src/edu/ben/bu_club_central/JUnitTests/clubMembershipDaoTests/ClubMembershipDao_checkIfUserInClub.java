package edu.ben.bu_club_central.JUnitTests.clubMembershipDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.ClubMembershipDao;

public class ClubMembershipDao_checkIfUserInClub {

	private ClubMembershipDao cmDao = new ClubMembershipDao();
	
	@Test
	public void checkIfUserInClubTest() {
		boolean expected = true;
		boolean actual = cmDao.checkIfUserInClub(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest2() {
		boolean expected = false;
		boolean actual = cmDao.checkIfUserInClub(1, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest3() {
		boolean expected = false;
		boolean actual = cmDao.checkIfUserInClub(2, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest4() {
		boolean expected = false;
		boolean actual = cmDao.checkIfUserInClub(3, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest5() {
		boolean expected = true;
		boolean actual = cmDao.checkIfUserInClub(3, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest6() {
		boolean expected = true;
		boolean actual = cmDao.checkIfUserInClub(4, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void checkIfUserInClubTest7() {
		boolean expected = true;
		boolean actual = cmDao.checkIfUserInClub(5, 1);
		assertEquals(expected, actual);
	}

}
