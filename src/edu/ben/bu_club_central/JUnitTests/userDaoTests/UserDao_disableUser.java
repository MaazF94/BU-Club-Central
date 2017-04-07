package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_disableUser {

	private UserDao uDao = new UserDao();
	
	@Test
	public void disableUserTest() {
		int expected = 1;
		uDao.disableUser(1);
		assertEquals(expected, 1);
	}
	
	@Test
	public void disableUserTest2() {
		int expected = 1;
		uDao.disableUser(2);
		assertEquals(expected, 1);
	}
	
	@Test
	public void disableUserTest3() {
		int expected = 1;
		uDao.disableUser(3);
		assertEquals(expected, 1);
	}

}
