package com.ui.pages;

import static com.constants.Env.QA;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.LoggerUtility;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	private static final LoginPage LoginPage = null;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public HomePage(Browser browserName,boolean isHeadless) {
		super(browserName,isHeadless);
		goToWebsite(JSONUtility.readJSON(QA));
		maximizeWindow();
	}
	public HomePage(WebDriver driver) {
		super(driver);
		goToWebsite(JSONUtility.readJSON(QA));
	}

	public LoginPage goToLoginPage() {
		logger.info("Trying to perform click to go to Sign In Page");
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage = new LoginPage(getDriver());
		return loginPage;
	}
}

