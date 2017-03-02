package testEventDao;
import edu.ben.bu_club_central.*;
import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

public class TestGetAnEventMethod {
	
	@Test
	public void testGAVM1() throws ParseException{
		Events ev = null;
		EventsDao ed = new EventsDao();
		ev = ed.getAnEvent("TEST EVENT");
		assertEquals("TEST EVENT", ev.getEvent_name());
	}
	
	@Test
	public void testGAVM2() throws ParseException{
		Events ev = null;
		EventsDao ed = new EventsDao();
		ev = ed.getAnEvent("Darwin DAY!");
		assertEquals("Darwin DAY!", ev.getEvent_name());
	}
	
	@Test
	public void testGAVM3() throws ParseException{
		Events ev = null;
		EventsDao ed = new EventsDao();
		ev = ed.getAnEvent("Darwin DAY!");
		assertNotEquals("Darwin Day!", ev.getEvent_name());
	}
	
	@Test
	public void testGAVM4() throws ParseException{
		Events ev = null;
		EventsDao ed = new EventsDao();
		ev = ed.getAnEvent("TEST");
		assertEquals(null, ev);
	}
}
