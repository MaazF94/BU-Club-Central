package edu.ben.bu_club_central.JUnitTests.userDaoTests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ UserDao_checkEmail.class, UserDao_checkId_num.class, UserDao_checkName.class,
		UserDao_checkPasswordMatch.class, UserDao_checkUsernameChars.class })
public class AllTests {

}
