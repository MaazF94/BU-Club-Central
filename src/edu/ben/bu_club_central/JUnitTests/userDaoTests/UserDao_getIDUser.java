package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_getIDUser {

	private UserDao uDao = new UserDao();
	
	@Test
	public void getUserIDTest() {
		int expected = 1;
		int actual = uDao.getIDUser("maaz", "fitter", 2180100, "maazfitter@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUserIDTest2() {
		int expected = 2;
		int actual = uDao.getIDUser("mariam", "sayeedi", 2160987, "mariamsayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void getUserIDTest3() {
		int expected = 3;
		int actual = uDao.getIDUser("shireen", "sayeedi", 2654987, "shireensayeedi@gmail.com");
		assertEquals(expected, actual);
	}

}
