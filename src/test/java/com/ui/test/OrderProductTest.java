package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.constants.Size.*;
import com.ui.pages.SearchResultPage;

public class OrderProductTest extends TestBase {
	
	SearchResultPage searchResultPage;
	String searchTerm = "Printed Summer Dress";
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		searchResultPage =homePage.goToLoginPage().doLoginWith("wofeb80381@leabro.com", "Password")
				.searchProduct(searchTerm);
	}
	
	
	@Test(description="Verify user is able to order a product", groups= {"sanity","smoke","e2e"})
	public void orderAProduct() {
		String suucessMessage = searchResultPage.clickOnProduct(0).selectSize(M).addProductToCart().clickOnCheckout().goToConfirmAddressPage().goToShippingPage().goToPaymentPage().goToBankWirePaymentPage();
	Assert.assertEquals(suucessMessage, "Your order on My Shop is complete.");
	}

}
