package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_enableUser {

	private UserDao uDao = new UserDao();
	
	@Test
	public void enableUserTest() {
		int expected = 1;
		uDao.enableUser(1);
		assertEquals(expected, 1);
	}
	
	@Test
	public void enableUserTest2() {
		int expected = 1;
		uDao.enableUser(2);
		assertEquals(expected, 1);
	}
	
	@Test
	public void enableUserTest3() {
		int expected = 1;
		uDao.enableUser(3);
		assertEquals(expected, 1);
	}

}
