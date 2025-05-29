package com.ui.test;

import static com.constants.Browser.CHROME;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ui.pages.HomePage;

public class LoginTest {
	
	HomePage homePage;
	
	@BeforeMethod(description="Load the homepage of the website")
	public void setUp() {
		 homePage = new HomePage(CHROME);
	}

@Test(description="Verify user is able to login into the application",groups={"e2e","smoke"})
	public void loginTest(){

		String username = homePage.goToLoginPage().doLoginWith("wofeb80381@leabro.com", "Password").getUserName();
		Assert.assertEquals(username, "John Weber");
	}

}
