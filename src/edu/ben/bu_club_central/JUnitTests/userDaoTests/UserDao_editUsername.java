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
	
	@Test
	public void editUsernameTest3() {
		boolean expected = true;
		boolean actual = uDao.editUsername(2, "msayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest4() {
		boolean expected = true;
		boolean actual = uDao.editUsername(2, "mariamsayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest5() {
		boolean expected = true;
		boolean actual = uDao.editUsername(3, "shireensayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest6() {
		boolean expected = true;
		boolean actual = uDao.editUsername(3, "ssayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest7() {
		boolean expected = false;
		boolean actual = uDao.editUsername(5, "shireensayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest8() {
		boolean expected = false;
		boolean actual = uDao.editUsername(10, "ssayeedi");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editUsernameTest9() {
		boolean expected = false;
		boolean actual = uDao.editUsername(15, "ssayeedi");
		assertEquals(expected, actual);
	}

}
