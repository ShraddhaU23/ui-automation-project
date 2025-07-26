package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.MyAccountPage;


@Listeners({ com.ui.listeners.TestListener.class })


public class SearchProductTest extends TestBase {
  
	MyAccountPage myAccountPage;
	String searchTerm = "Printed Summer Dress";

	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		myAccountPage =homePage.goToLoginPage().doLoginWith("wofeb80381@leabro.com", "Password");
	}
	
	@Test(description="Verify user is able to search for a product and correct products are displayed", groups= {"sanity","smoke","e2e"})
	public void verifyProductSearchTest() {
		boolean actualResult = myAccountPage.searchProduct(searchTerm).isSearchTermPresentInProductList(searchTerm);
		Assert.assertEquals(actualResult, true);
	}
	
	
}
