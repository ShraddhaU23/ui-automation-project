package com.utility;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	public WebDriver driver;
	Logger logger = LoggerUtility.getLogger(this.getClass());

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser " + browserName);

		if (browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		} else if (browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {

		WebElement element = driver.findElement(locator);
		element.click();
		logger.info("Element found and performed click operation");
	}

	public void enterText(By locator, String value) {

		WebElement element = driver.findElement(locator);
		element.sendKeys(value);
		logger.info("Element found and entered text " + value);
	}

	public String getVisibleText(By locator) {

		WebElement element = driver.findElement(locator);
		String text = element.getText();
		logger.info("Element found and returning visible text " + text);
		return text;
	}

	public void tearDown() {
		driver.close();
	}
}
