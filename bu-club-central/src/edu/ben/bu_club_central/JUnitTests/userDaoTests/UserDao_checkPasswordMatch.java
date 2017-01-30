package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;
import junit.framework.Assert;

public class UserDao_checkPasswordMatch {
	private UserDao uDao = new UserDao();

	@Test
	public void test1() {
		Assert.assertEquals(true, uDao.checkPasswordMatch("root", "root"));
	}
	@Test
	public void test2() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("Root", "root"));
	}
	@Test
	public void test3() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("root", "oot"));
	}
	@Test
	public void test4() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("password", "pass word"));
	}
	@Test
	public void test5() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("root ", "root"));
	}
	@Test
	public void test6() {
		Assert.assertEquals(true, uDao.checkPasswordMatch("ro ot", "ro ot"));
	}
	@Test
	public void test7() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("123", "321"));
	}
	@Test
	public void test8() {
		Assert.assertEquals(false, uDao.checkPasswordMatch("", ""));
	}

}
