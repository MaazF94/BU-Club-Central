package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_disableUser {

	private UserDao uDao = new UserDao();
	
	@Test
	public void disableUserTest() {
		int expected = 0;
		uDao.disableUser(2180100);
		int actual = uDao.getUserDisableEnableStatus(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void disableUserTest2() {
		int expected = 0;
		uDao.disableUser(2160987);
		int actual = uDao.getUserDisableEnableStatus(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void disableUserTest3() {
		int expected = 0;
		uDao.disableUser(2654987);
		int actual = uDao.getUserDisableEnableStatus(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void disableUserTest4() {
		int expected = -1;
		uDao.disableUser(5);
		int actual = uDao.getUserDisableEnableStatus(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void disableUserTest5() {
		int expected = -1;
		uDao.disableUser(10);
		int actual = uDao.getUserDisableEnableStatus(10);
		assertEquals(expected, actual);
	}

}
