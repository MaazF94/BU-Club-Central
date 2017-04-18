package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_enableUser {

	private UserDao uDao = new UserDao();
	
	@Test
	public void enableUserTest() {
		int expected = 1;
		uDao.enableUser(2180100);
		int actual = uDao.getUserDisableEnableStatus(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void enableUserTest2() {
		int expected = 1;
		uDao.enableUser(2160987);
		int actual = uDao.getUserDisableEnableStatus(2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void enableUserTest3() {
		int expected = 1;
		uDao.enableUser(2654987);
		int actual = uDao.getUserDisableEnableStatus(1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void enableUserTest4() {
		int expected = -1;
		uDao.enableUser(5);
		int actual = uDao.getUserDisableEnableStatus(5);
		assertEquals(expected, actual);
	}
	
	@Test
	public void enableUserTest5() {
		int expected = -1;
		uDao.enableUser(10);
		int actual = uDao.getUserDisableEnableStatus(10);
		assertEquals(expected, actual);
	}

}
