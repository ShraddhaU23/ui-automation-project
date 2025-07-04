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
public class LoginTest extends TestBase {

	Logger logger = LoggerUtility.getLogger(this.getClass());

	@Test(description = "Verify user is able to login into the application", groups = { "e2e",
			"smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestdataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
	public void loginTest(User user) {

		String username = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUserName();
		Assert.assertEquals(username, "John Weber");
	}

	/*
	 * @Test(description = "Verify user is able to login into the application",
	 * groups = { "e2e", "smoke" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LoginTestExcelDataProvider", retryAnalyzer =
	 * com.ui.listeners.MyRetryAnalyzer.class) public void loginExcelTest(User user)
	 * {
	 * 
	 * String username =
	 * homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()) .getUserName(); Assert.assertEquals(username,
	 * "John Weber");
	 * 
	 * }
	 */
}
