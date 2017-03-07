package edu.ben.bu_club_central.JUnitTest.EventDao;
import edu.ben.bu_club_central.*;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;

import static org.junit.Assert.*;

import java.text.ParseException;


import static org.junit.Assert.*;

import org.junit.Test;

public class TestUpdateEvent {
	/**
	 * test updating the name of an event.
	 * @throws ParseException
	 */
	@Test
	public void testUVName1() throws ParseException {
		String newName = "Darwin day!";
		String oldName = "Darwin DAY!";
		EventsDao ed = new EventsDao();
		//ed.updateEventName(oldName, newName);
		Events ev = null;
		//ev = ed.getAnEvent(newName);
		assertEquals(newName, ev.getEvent_name());
	}
	
	@Test
	public void testUVName2() throws ParseException{
		String newName = "DARWIN DAY!";
		String oldName = "D Day";
		EventsDao ed = new EventsDao();
		//ed.updateEventName(oldName, newName);
		Events evn = null;
		Events evo = null;
		//evn = ed.getAnEvent(newName);
		//evo = ed.getAnEvent("Darwin Day");
		assertEquals(null, evo);
	}
	
	@Test
	public void testUVName3() throws ParseException{
		String newName = "Darwin DAY!";
		String oldName = "Darwin day!";
		EventsDao ed = new EventsDao();
		//ed.updateEventName(oldName, newName);
		Events ev = null;
		//ev = ed.getAnEvent(newName);
		assertEquals(newName, ev.getEvent_name());
	}
	
	@Test
	public void testUVLoc1() throws ParseException{
		String eventName = "Darwin DAY!";
		String loc = "QUAD1";
		EventsDao ed = new EventsDao();
		//ed.updateEventLocation(eventName, loc);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		assertEquals(loc, ev.getLocation());
	}
	
	@Test
	public void testUVLoc2() throws ParseException{
		String eventName = "Darwin DAY!";
		String loc = "QUAD and KRASA Basement";
		EventsDao ed = new EventsDao();
		//ed.updateEventLocation(eventName, loc);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		assertEquals(loc, ev.getLocation());
	}
	
	@Test 
	public void testUVDesc1() throws ParseException{
		String eventName = "Darwin DAY!";
		String desc = "This is a new description";
		EventsDao ed = new EventsDao();
		//ed.updateEventDescription(eventName, desc);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		assertEquals(desc, ev.getDescription());
	}
	
	@Test 
	public void testUVDesc2() throws ParseException{
		String eventName = "Darwin DAY!";
		String desc = "This is another new description";
		EventsDao ed = new EventsDao();
		//ed.updateEventDescription(eventName, desc);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		assertEquals(desc, ev.getDescription());
	}
	
	@Test
	public void testUVTime1() throws ParseException{
		String eventName = "Darwin DAY!";
		int time = 12;
		EventsDao ed = new EventsDao();
		//ed.updateEventTime(eventName, time);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		//assertEquals(time, ev.getTime());
	}
	
	@Test
	public void testUVTime2() throws ParseException{
		String eventName = "Darwin DAY!";
		int time = 2130;
		EventsDao ed = new EventsDao();
		//ed.updateEventTime(eventName, time);
		Events ev = null;
		//ev = ed.getAnEvent(eventName);
		//assertEquals(time, ev.getTime());
	}

}
