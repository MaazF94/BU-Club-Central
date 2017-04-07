package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_editEmail {

	private UserDao uDao = new UserDao();
	
	@Test
	public void editEmailTest() {
		boolean expected = true;
		boolean actual = uDao.editEmail(1, "mfitter@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest2() {
		boolean expected = true;
		boolean actual = uDao.editEmail(1, "maazfitter@gmail.com");
		assertEquals(expected, actual);
	}

}
