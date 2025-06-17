package com.ui.test;

import static com.constants.Browser.CHROME;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;
import com.ui.pojo.User;

public class LoginTest {

	HomePage homePage;

	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp() {
		homePage = new HomePage(CHROME);
	}

	/*
	 * @Test(description = "Verify user is able to login into the application",
	 * groups = { "e2e", "smoke" }, dataProviderClass =
	 * com.ui.dataproviders.LoginDataProvider.class, dataProvider =
	 * "LoginTestdataProvider")
	 * 
	 * public void loginTest(User user) {
	 * 
	 * String username =
	 * homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),
	 * user.getPassword()) .getUserName(); Assert.assertEquals(username,
	 * "John Weber"); }
	 */

	@Test(description = "Verify user is able to login into the application", groups = { "e2e",
			"smoke" }, dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestExcelDataProvider")
	public void loginExcelTest(User user) {

		String username = homePage.goToLoginPage().doLoginWith(user.getEmailAddress(), user.getPassword())
				.getUserName();
		Assert.assertEquals(username, "John Weber");
	}
}
