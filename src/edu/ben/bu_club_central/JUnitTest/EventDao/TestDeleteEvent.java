package edu.ben.bu_club_central.JUnitTest.EventDao;
import edu.ben.bu_club_central.*;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;

import static org.junit.Assert.*;

import java.text.ParseException;


import static org.junit.Assert.*;


import org.junit.Test;

public class TestDeleteEvent {

	@Test
	public void testDV() throws ParseException{
		String oldName = "Darwin Day6";
		EventsDao ed = new EventsDao();
		//ed.deleteEvent(oldName);
		Events ev = null;
		//ev = ed.getAnEvent(oldName);
		assertEquals(null, ev);
	}
	
	@Test
	public void testDV2() throws ParseException{
		String oldName = "Darwin Day12";
		EventsDao ed = new EventsDao();
		//ed.deleteEvent(oldName);
		Events ev = null;
		//ev = ed.getAnEvent(oldName);
		assertEquals(null, ev);
	}
	
	@Test
	public void testDV3() throws ParseException{
		String oldName = "Darwin Day24";
		EventsDao ed = new EventsDao();
	//	ed.deleteEvent(oldName);
		Events ev = null;
		//ev = ed.getAnEvent(oldName);
		assertEquals(null, ev);
	}
	
	@Test
	public void testDV4() throws ParseException{
		String oldName = "Darwin Day18";
		EventsDao ed = new EventsDao();
	//	ed.deleteEvent(oldName);
		Events ev = null;
	//	ev = ed.getAnEvent(oldName);
		assertEquals(null, ev);
	}

}
