//package edu.ben.bu_club_central.JUnitTests.userDaoTests;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import edu.ben.bu_club_central.daos.UserDao;
//
//public class UserDao_changePassword {
//
//	private UserDao uDao = new UserDao();
//	@Test
//	public void userPasswordChangeSuccessTest() {
//		boolean expected = true;
//		boolean actual = uDao.userPasswordChange("maazfitter", "internet22", 2180100, "maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeSuccessTest2() {
//		boolean expected = true;
//		boolean actual = uDao.userPasswordChange("Maazfitter", "internet22", 2180100, "maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeSuccessTest3() {
//		boolean expected = true;
//		boolean actual = uDao.userPasswordChange("MaazFitter", "internet22", 2180100, "maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeSuccessTest4() {
//		boolean expected = true;
//		boolean actual = uDao.userPasswordChange("MaazFitter", "internet22", 2180100, "Maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeSuccessTest5() {
//		boolean expected = true;
//		boolean actual = uDao.userPasswordChange("MaazFitter", "internet22", 2180100, "MaazFitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeFailureNameTest() {
//		boolean expected = false;
//		boolean actual = uDao.userPasswordChange("maazfittter", "internet22", 2180100, "maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeFailureIDTest2() {
//		boolean expected = false;
//		boolean actual = uDao.userPasswordChange("maazfitter", "internet22", 2180101, "maazfitter@gmail.com");
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void userPasswordChangeFailureEmailTest3() {
//		boolean expected = false;
//		boolean actual = uDao.userPasswordChange("maazfitter", "internet22", 2180100, "maazfitterr@gmail.com");
//		assertEquals(expected, actual);
//	}
//
//}
