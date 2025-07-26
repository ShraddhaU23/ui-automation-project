package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class ShippingPage extends BrowserUtility {

	private static By ACCEPT_TERMS_LOCATOR = By.id("uniform-cgv");
	private static By PROCEED_TO_CHECKOUT_LOCATOR = By.xpath("//button[@name='processCarrier']");
	

	public ShippingPage(WebDriver driver) {
		super(driver);
		
	}

	public PaymentPage goToPaymentPage() {
		clickOnCheckBox(ACCEPT_TERMS_LOCATOR);
		clickOn(PROCEED_TO_CHECKOUT_LOCATOR);
		return new PaymentPage(getDriver());
	}
}
