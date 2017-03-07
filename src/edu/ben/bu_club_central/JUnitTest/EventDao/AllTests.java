package edu.ben.bu_club_central.JUnitTest.EventDao;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestDeleteEvent.class, TestGetAnEventMethod.class, TestUpdateEvent.class })
public class AllTests {

}
