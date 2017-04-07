package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_editUsername {

	private UserDao uDao = new UserDao();
	
	@Test
	public void editUsernameTest() {
		boolean expected = true;
		boolean actual = uDao.editUsername(1, "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest2() {
		boolean expected = true;
		boolean actual = uDao.editUsername(1, "mfitter");
		assertEquals(expected, actual);
	}

}
