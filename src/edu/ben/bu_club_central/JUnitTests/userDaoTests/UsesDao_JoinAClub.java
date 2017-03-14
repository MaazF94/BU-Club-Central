package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UsesDao_JoinAClub {

	private UserDao uDao = new UserDao();

	@Test
	public void UserJoinsClubSuccessTest() {
		boolean expected = true;
		boolean actual = uDao.userJoinClub("Maaz", "Fitter", 2180100, "maazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubSuccessTest2() {
		boolean expected = true;
		boolean actual = uDao.userJoinClub("maaz", "Fitter", 2180100, "maazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubSuccessTest3() {
		boolean expected = true;
		boolean actual = uDao.userJoinClub("Maaz", "fitter", 2180100, "maazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubSuccessTest4() {
		boolean expected = true;
		boolean actual = uDao.userJoinClub("Maaz", "Fitter", 2180100, "MaazFitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubFailureTest1() {
		boolean expected = false;
		boolean actual = uDao.userJoinClub("Maaaz", "Fitter", 2180100, "maazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubFailureTest2() {
		boolean expected = false;
		boolean actual = uDao.userJoinClub("Maaz", "Fittter", 2180100, "maazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubFailureTest3() {
		boolean expected = false;
		boolean actual = uDao.userJoinClub("Maaz", "Fitter", 2180100, "maaazfitter@gmail.com", 2);
		assertEquals(expected, actual);
	}


}
