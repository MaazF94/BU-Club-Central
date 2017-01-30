package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;

public class UserDao_checkName {
	private UserDao uDao = new UserDao();
	
	
	@Test
	public void test1() {
		Assert.assertEquals(true, uDao.checkName("Ian", "Birkholz"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, uDao.checkName("I1an", "Bi5rkholz"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, uDao.checkName("", "Birkholz"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(false, uDao.checkName("Ian", ""));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(false, uDao.checkName(" ", "Birkholz"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(false, uDao.checkName("Ia   n", "Birkholz"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(false, uDao.checkName("Ian", "Birkh olz"));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(false, uDao.checkName("Ia#$$n", "Birkholz"));
	}

	@Test
	public void test9() {
		Assert.assertEquals(false, uDao.checkName("Ian", "Birk/*-+holz"));
	}
}
