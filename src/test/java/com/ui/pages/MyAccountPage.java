package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public final class MyAccountPage extends BrowserUtility {

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@class='account']//span");
	private static final By SEARCH_TEXTBOX_LOCATOR = By.xpath("//input[@id='search_query_top']");
	private static final By SEARCH_ICON_LOCATOR = By.xpath("//button[@name='submit_search']");
	private static final By ADD_NEW_ADDRESS_LOCATOR = By.xpath("//ul[@class='myaccount-link-list']/li[1]/a");

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	public String getUserName() {
		return getVisibleText(USER_NAME_LOCATOR);
	}
	
	public SearchResultPage searchProduct(String productName) {
		 enterText(SEARCH_TEXTBOX_LOCATOR, productName);
		 enterSpecialKey(SEARCH_TEXTBOX_LOCATOR,Keys.ENTER);
		 SearchResultPage searchResultPage = new SearchResultPage(getDriver());
		 return searchResultPage;
	}
	
	public AddressPage goToAddressPage() {
		clickOn(ADD_NEW_ADDRESS_LOCATOR);
		AddressPage addressPage =new AddressPage(getDriver());
		return addressPage;
	}
}
