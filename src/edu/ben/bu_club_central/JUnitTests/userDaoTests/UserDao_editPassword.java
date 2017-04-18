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
	
	@Test
	public void editPasswordTes3() {
		boolean expected = true;
		boolean actual = uDao.editPassword(2, "qurratulain");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest4() {
		boolean expected = true;
		boolean actual = uDao.editPassword(2, "internet22");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest5() {
		boolean expected = true;
		boolean actual = uDao.editPassword(3, "letmein");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest6() {
		boolean expected = true;
		boolean actual = uDao.editPassword(3, "hello");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest7() {
		boolean expected = false;
		boolean actual = uDao.editPassword(5, "letmein");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest8() {
		boolean expected = false;
		boolean actual = uDao.editPassword(10, "hello");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editPasswordTest9() {
		boolean expected = false;
		boolean actual = uDao.editPassword(15, "hello");
		assertEquals(expected, actual);
	}

}
