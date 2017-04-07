package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_userRoleChanges {
	private UserDao uDao = new UserDao();

	@Test
	public void userRoleChanges() {
		boolean expected = true;
		boolean actual = uDao.userRoleChanges(1, 1);
		assertEquals(expected, actual);
	}
	
	@Test
	public void userRoleChanges2() {
		boolean expected = true;
		boolean actual = uDao.userRoleChanges(1, 2);
		assertEquals(expected, actual);
	}
	
	@Test
	public void userRoleChanges3() {
		boolean expected = true;
		boolean actual = uDao.userRoleChanges(1, 3);
		assertEquals(expected, actual);
	}

}
