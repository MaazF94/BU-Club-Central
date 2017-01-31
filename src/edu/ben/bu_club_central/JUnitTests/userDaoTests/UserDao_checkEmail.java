package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;
import junit.framework.Assert;

public class UserDao_checkEmail {
	private UserDao uDao = new UserDao();
	
	@Test
	public void test1() {
		Assert.assertEquals(true, uDao.checkEmail("ian.birkholz@gmail.com"));
	}
	
	@Test
	public void test2() {
		Assert.assertEquals(false, uDao.checkEmail("ian.birkholz gmail.com"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, uDao.checkEmail("ian.birkholz@gmail"));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(true, uDao.checkEmail("eisnikesb@gmail.com"));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(true, uDao.checkEmail("b2218804@ben.edu"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(true, uDao.checkEmail("ian@gmail.com.com"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(true, uDao.checkEmail("ian.birkholz@gov.org"));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(false, uDao.checkEmail("(&&*&^&*)(*@gmail.com"));
	}
	
	@Test
	public void test9() {
		Assert.assertEquals(false, uDao.checkEmail("ian/birkholz@gmail.com"));
	}

}
