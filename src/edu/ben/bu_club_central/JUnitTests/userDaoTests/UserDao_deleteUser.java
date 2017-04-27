//package edu.ben.bu_club_central.JUnitTests.userDaoTests;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import edu.ben.bu_club_central.daos.UserDao;
//
//public class UserDao_deleteUser {
//
//	private UserDao uDao = new UserDao();
//	
//	@Test
//	public void deleteUserTest() {
//		int expected = -1;
//		uDao.deleteUser("2148795");
//		int actual = uDao.getUserDisableEnableStatus(19);
//
//		assertEquals(expected, actual);
//	}
//	
//	@Test
//	public void deleteUserTest2() {
//		int expected = -1;
//		uDao.deleteUser("2180100");
//		int actual = uDao.getUserDisableEnableStatus(21);
//
//		assertEquals(expected, actual);
//		
//		uDao.registerUser("Maaz", "Fitter", "mfitter", "internet22", 2180100, "maazfitter@gmail.com");
//	}
//	
//	@Test
//	public void deleteUserTest3() {
//		int expected = -1;
//		uDao.deleteUser("2160987");
//		int actual = uDao.getUserDisableEnableStatus(19);
//
//		assertEquals(expected, actual);
//		
//		uDao.registerUser("Mariam", "Sayeedi", "msayeedi", "whynot", 2160987, "msayeedi@gmail.com");
//	}
//	
//	@Test
//	public void deleteUserTest4() {
//		int expected = -1;
//		uDao.deleteUser("2654987");
//		int actual = uDao.getUserDisableEnableStatus(23);
//
//		assertEquals(expected, actual);
//		
//		uDao.registerUser("Shireen", "Sayeedi", "ssayeedi", "letmein", 2654987, "ssayeedi@gmail.com");
//	}
//
//}
