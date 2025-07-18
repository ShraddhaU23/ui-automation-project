package com.ui.test;

import java.net.MalformedURLException;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utility.BrowserUtility;
import com.utility.LambdaTestUtility;
import com.utility.LoggerUtility;

public class TestBase {

	protected HomePage homePage;
	Logger logger = LoggerUtility.getLogger(this.getClass());
	boolean isLambdaTest;
	
	@Parameters({"browser","isLambdaTest","isHeadless"})
	@BeforeMethod(description = "Load the homepage of the website")
	public void setUp(
			@Optional("chrome")String browser,
			@Optional("false")boolean isLambdaTest, 
			@Optional("false")boolean isHeadless, ITestResult result) throws MalformedURLException {
		this.isLambdaTest= isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(browser,result.getMethod().getMethodName() );
			homePage = new HomePage(lambdaDriver);
		}
		
		else {
			logger.info("Loads the homepage of the website");
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()),isHeadless);
		}
		
	}

	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod(description="Tear down the browser")
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}
		else {
			BrowserUtility.quit();
	}
}
}
