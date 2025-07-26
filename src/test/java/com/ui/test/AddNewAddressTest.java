package com.ui.test;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ui.pages.AddressPage;
import com.ui.pages.MyAccountPage;
import com.ui.pojo.AddressPOJO;
import com.utility.FakeAddressUtility;

@Listeners({ com.ui.listeners.TestListener.class })

public class AddNewAddressTest extends TestBase {

	private MyAccountPage myAccountPage;
	private AddressPage addressPage;
	private AddressPOJO addressPOJO;
	
	
	@BeforeMethod(description="Valid user logs into the application")
	public void setUp() {
		myAccountPage =homePage.goToLoginPage().doLoginWith("wofeb80381@leabro.com", "Password");
		addressPOJO = FakeAddressUtility.getFakeAddress();
				}
	

	@Test(description="Verify user is able to add new address", groups= {"smoke","e2e", "sanity"})
	public void addNewAddress() {
		String addressString = myAccountPage.goToAddressPage().saveAddress(addressPOJO);
		Assert.assertEquals(addressString, addressPOJO.getAddressAlias().toUpperCase());
	}
	
}
