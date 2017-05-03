package edu.ben.bu_club_central.JUnitTest.EventDao;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ben.bu_club_central.daos.DatabaseConnection;
import edu.ben.bu_club_central.daos.EventsDao;


/**
 * 
 * @author Frank Rooks
 *
 */
public class TestEventDao {

	private int eventID =  14;
	EventsDao ed= new EventsDao();
	/**
	 * Tests if the add event works
	 */
	@Test
	public void testAddEvent() {
		DatabaseConnection dc = new DatabaseConnection();
		dc.getConn();
		
		ed.addEvent("Test Event", "This is a testcase to add an event", "Coal ben", 34, "2017", "08", "15", "2017", "08", "15", "other");
		dc.getConn();
		boolean expected = true;
		boolean actual = ed.EventExists("Test Event");
		assertEquals(expected, actual);	
	
	}
	
	/**
	 * Test if the delete event by id works. It works when given the right id
	 */
	@Test
	public void testDeleteEvent() {
		DatabaseConnection dc = new DatabaseConnection();
		dc.getConn();
		
		ed.deleteEventByEventId(eventID++);
		dc.getConn();
		boolean expected = false;
		boolean actual = ed.EventExists("Test Event");
		assertEquals(expected, actual);	
	
	}

}
