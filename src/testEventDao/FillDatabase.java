package testEventDao;
import java.text.ParseException;

import edu.ben.bu_club_central.daos.EventsDao;
import edu.ben.bu_club_central.models.Events;
/**
 * 
 * @author razak
 * used to fill database with dummy data
 * Run before you run the testcases
 */
public class FillDatabase {
	public static void main(String []args) throws ParseException{
		int num = 0;
		do{
		String eventName = "Darwin Day" + num++;
		String desc = "A day filled with fun and more" + num++;
		String loc = "Juricha-Suchy Museum and the Quad" + num ++;
		String eType= "Social" + num++;
		String date= "2017-02-07";
		String funds = "club funds" + num++;
		int expectedCount = 90 + num ++;
		int duration = 2;
		int time = 1230;
		int clubID = 123;
		
		Events ev = new Events(eventName, desc, loc, eType, date, funds, expectedCount, duration, time, clubID);
		EventsDao ed = new EventsDao();
		if (ed.addEvent(ev)){
			System.out.println("SUCCESS");
		}else{
			System.out.println("FAILURE, Event already exists");
		}
		}while(num < 30);
	}
}
