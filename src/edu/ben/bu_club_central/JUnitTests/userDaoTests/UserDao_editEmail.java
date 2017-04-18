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
	
	@Test
	public void editEmailTest3() {
		boolean expected = true;
		boolean actual = uDao.editEmail(2, "mariamsayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest4() {
		boolean expected = true;
		boolean actual = uDao.editEmail(1, "msayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest5() {
		boolean expected = true;
		boolean actual = uDao.editEmail(3, "shireensayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest6() {
		boolean expected = true;
		boolean actual = uDao.editEmail(3, "ssayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest7() {
		boolean expected = false;
		boolean actual = uDao.editEmail(5, "ssayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest8() {
		boolean expected = false;
		boolean actual = uDao.editEmail(10, "ssayeedi@gmail.com");
		assertEquals(expected, actual);
	}
	
	@Test
	public void editEmailTest9() {
		boolean expected = false;
		boolean actual = uDao.editEmail(15, "ssayeedi@gmail.com");
		assertEquals(expected, actual);
	}

}
