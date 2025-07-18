package com.ui.test;

import static com.constants.Browser.CHROME;

import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({ com.ui.listeners.TestListener.class })
public class InvalidCredsLoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static final String INVALID_EMAIL_ADDRESS = "abctyu2@gmail.com";
	private static final String INVALID_PASSWORD = "abctyu2@gmail.com";

	@Test(description = "Verify user is able to login into the application", groups = { "e2e",
			"smoke","sanity" })
	public void loginTest() {

		String username = homePage.goToLoginPage().doLoginWithInvalidCredentials(INVALID_EMAIL_ADDRESS, INVALID_PASSWORD).getErrorMsg();
		Assert.assertEquals(username, "Authentication failed.");
	}
}

	
