package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class PaymentPage extends BrowserUtility {

	private static By PAY_BY_BANK_WIRE_BUTTON_LOCATOR = By.xpath("//a[@title='Pay by bank wire']");
	private static By CONFIRM_BUTTON_LOCATOR = By.xpath("//p[contains(@class,'cart_navigation clearfix')]/button");
	private static By SUCCESS_MSG_LOCATOR = By.xpath("//p[contains(@class,'success')]");
	
	
	public PaymentPage(WebDriver driver) {
		super(driver);
		
	}
	
	public String goToBankWirePaymentPage() {
		
		clickOn(PAY_BY_BANK_WIRE_BUTTON_LOCATOR);
		clickOn(CONFIRM_BUTTON_LOCATOR);
		return getVisibleText(SUCCESS_MSG_LOCATOR);
		
	}

}
