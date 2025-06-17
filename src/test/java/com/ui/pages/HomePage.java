package com.ui.pages;

import org.openqa.selenium.By;

import com.constants.Browser;
import static com.constants.Env.*;
import com.utility.BrowserUtility;
import com.utility.JSONUtility;
import com.utility.PropertiesUtil;

public final class HomePage extends BrowserUtility {

	private static final By SIGN_IN_LOCATOR = By.xpath("//a[contains(text(),'Sign in')]");
	private static final LoginPage LoginPage = null;

	public HomePage(Browser browserName) {
		super(browserName);
		goToWebsite(JSONUtility.readJSON(QA));
		maximizeWindow();
	}

	public LoginPage goToLoginPage() {
		clickOn(SIGN_IN_LOCATOR);
		LoginPage loginPage =new LoginPage(getDriver());
		return loginPage;
	}

}
