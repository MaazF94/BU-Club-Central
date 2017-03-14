package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_changeUsername {

	private UserDao uDao = new UserDao();
	@Test
	public void userUsernameChangeSuccessTest() {
		boolean expected = true;
		boolean actual = uDao.userUsernameChange("Maaz", "Fitter", 2180100, "maazfitter@gmail.com", "mfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureFirstNameTest() {
		boolean expected = false;
		boolean actual = uDao.userUsernameChange("Maaaz", "Fitter", 2180100, "maazfitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureFirstNameTest2() {
		boolean expected = true;
		boolean actual = uDao.userUsernameChange("maaz", "Fitter", 2180100, "maazfitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureLastNameTest() {
		boolean expected = false;
		boolean actual = uDao.userUsernameChange("Maaz", "Fittter", 2180100, "maazfitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureLastNameTest2() {
		boolean expected = true;
		boolean actual = uDao.userUsernameChange("Maaz", "fitter", 2180100, "maazfitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureIDTest() {
		boolean expected = false;
		boolean actual = uDao.userUsernameChange("Maaz", "Fitter", 2180108, "maazfitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureEmailTest() {
		boolean expected = false;
		boolean actual = uDao.userUsernameChange("Maaz", "Fitter", 2180100, "maazfitterr@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}
	
	@Test
	public void userUsernameChangeFailureEmailTest2() {
		boolean expected = true;
		boolean actual = uDao.userUsernameChange("Maaz", "Fitter", 2180100, "MaazFitter@gmail.com", "maazfitter");
		assertEquals(expected, actual);
	}

}
