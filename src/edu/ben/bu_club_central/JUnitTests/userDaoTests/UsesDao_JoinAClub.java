package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import edu.ben.bu_club_central.daos.ClubMembershipDao;
import edu.ben.bu_club_central.daos.UserDao;
import edu.ben.bu_club_central.models.ClubMembership;

public class UsesDao_JoinAClub {

	private ClubMembershipDao cmDao = new ClubMembershipDao();
	List<ClubMembership> memberships = new ArrayList<ClubMembership>();
	UserDao uDao = new UserDao();

	
	@Test
	public void UserJoinsClubTest() {
		
		ClubMembership m = new ClubMembership(2, 1, 1, true);
		memberships.add(m);
				
		boolean expected = false;
		boolean actual = cmDao.addUserToClubs(memberships);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsClubTest2() {
		
		ClubMembership m = new ClubMembership(5, 1, 1, true);
		memberships.add(m);
				
		boolean expected = false;
		boolean actual = cmDao.addUserToClubs(memberships);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsMultipleClubsTest() {
		ClubMembership m = new ClubMembership(3, 1, 1, true);
		memberships.add(m);
		m = new ClubMembership(4, 1, 1, true);
		memberships.add(m);
		
		boolean expected = false;
		boolean actual = cmDao.addUserToClubs(memberships);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsMultipleClubsTest2() {
		ClubMembership m = new ClubMembership(6, 1, 1, true);
		memberships.add(m);
		m = new ClubMembership(7, 1, 1, true);
		memberships.add(m);
		
		boolean expected = false;
		boolean actual = cmDao.addUserToClubs(memberships);
		assertEquals(expected, actual);
	}
	
	@Test
	public void UserJoinsSameClubsTest() {
		ClubMembership m = new ClubMembership(3, 1, 1, true);
		memberships.add(m);
		m = new ClubMembership(4, 1, 1, true);
		memberships.add(m);
		
		boolean expected = false;
		boolean actual = cmDao.addUserToClubs(memberships);
		assertEquals(expected, actual);
	}

}
