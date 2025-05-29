package com.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.constants.Browser;

public abstract class BrowserUtility {

	public WebDriver driver;

	public WebDriver getDriver() {
		return driver;
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public BrowserUtility(Browser browserName) {
		if (browserName == Browser.CHROME) {
			driver = new ChromeDriver();
		} else if (browserName == Browser.EDGE) {
			driver = new EdgeDriver();
		} else if (browserName == Browser.FIREFOX) {
			driver = new FirefoxDriver();
		}
	}

	public void goToWebsite(String url) {

		driver.get(url);
	}

	public void maximizeWindow() {

		driver.manage().window().maximize();
	}

	public void clickOn(By locator) {

		WebElement element = driver.findElement(locator);
		element.click();
	}

	public void enterText(By locator, String value) {

		WebElement element = driver.findElement(locator);
		element.sendKeys(value);
	}

	public String getVisibleText(By locator) {

		WebElement element = driver.findElement(locator);
		String text = element.getText();
		return text;
	}
}
