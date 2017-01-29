package edu.ben.bu_club_central.JUnitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;
import junit.framework.Assert;

public class UserDao_checkUsernameChars {
	
	UserDao uDao = new UserDao();

	@Test
	public void test1() {
		Assert.assertEquals(true, uDao.checkUsernameChars("ibirkholz"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, uDao.checkUsernameChars("@abc"));
	}
	@Test
	public void test3() {
		Assert.assertEquals(true, uDao.checkUsernameChars("123abc"));
	}
	@Test
	public void test4() {
		Assert.assertEquals(false, uDao.checkUsernameChars("5955/*/-+"));
	}
	@Test
	public void test5() {
		Assert.assertEquals(true, uDao.checkUsernameChars("uhIUOJIOhoijf78967857"));
	}
	@Test
	public void test6() {
		Assert.assertEquals(false, uDao.checkUsernameChars("ibirkho lz"));
	}
	@Test
	public void test7() {
		Assert.assertEquals(false, uDao.checkUsernameChars(" "));
	}
	@Test
	public void test8() {
		Assert.assertEquals(false, uDao.checkUsernameChars(""));
	}
}
