package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.fail;

import org.junit.Test;

import edu.ben.bu_club_central.daos.UserDao;
import junit.framework.Assert;

public class UserDao_checkId_num {
	private UserDao uDao =  new UserDao();
	
	@Test
	public void test1() {
		Assert.assertEquals(true, uDao.checkId_num("123456"));
	}

	@Test
	public void test2() {
		Assert.assertEquals(false, uDao.checkId_num("123gf456"));
	}
	
	@Test
	public void test3() {
		Assert.assertEquals(false, uDao.checkId_num(""));
	}
	
	@Test
	public void test4() {
		Assert.assertEquals(false, uDao.checkId_num(" "));
	}
	
	@Test
	public void test5() {
		Assert.assertEquals(false, uDao.checkId_num(")(&*kj-0809"));
	}
	
	@Test
	public void test6() {
		Assert.assertEquals(true, uDao.checkId_num("1"));
	}
	
	@Test
	public void test7() {
		Assert.assertEquals(false, uDao.checkId_num("1234 56"));
	}
	
	@Test
	public void test8() {
		Assert.assertEquals(false, uDao.checkId_num("0.1"));
	}
}
