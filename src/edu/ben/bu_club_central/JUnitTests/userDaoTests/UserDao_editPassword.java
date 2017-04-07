package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_editPassword {

	private UserDao uDao = new UserDao();
	
	@Test
	public void editPasswordTest() {
		boolean expected = true;
		boolean actual = uDao.editPassword(1, "internet22");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest2() {
		boolean expected = true;
		boolean actual = uDao.editPassword(1, "letmein1994");
		assertEquals(expected, actual);
	}

}
