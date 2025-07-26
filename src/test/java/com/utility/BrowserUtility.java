package com.utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.constants.Browser;

public abstract class BrowserUtility {

	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	private Logger logger = LoggerUtility.getLogger(this.getClass());
	private WebDriverWait wait;

	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		this.driver.set(driver);
		wait = new WebDriverWait(driver,Duration.ofSeconds(30L));
	}

	public BrowserUtility(Browser browserName) {
		logger.info("Launching browser " + browserName);

		if (browserName == Browser.CHROME) {
			driver.set(new ChromeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
		} else if (browserName == Browser.EDGE) {
			driver.set(new EdgeDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
		} else if (browserName == Browser.FIREFOX) {
			driver.set(new FirefoxDriver());
			wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
		}
	}

	public BrowserUtility(Browser browserName, boolean isHeadless) {
		logger.info("Launching browser " + browserName);
		if (browserName == Browser.CHROME) {
			if (isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			} else {
				driver.set(new ChromeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			}
		} else if (browserName == Browser.EDGE) {
			if (isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new EdgeDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			} else {
				driver.set(new EdgeDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			}
		}

		else if (browserName == Browser.FIREFOX) {
			if (isHeadless) {
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("disable-gpu");
				driver.set(new FirefoxDriver(options));
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			} else {
				driver.set(new FirefoxDriver());
				wait = new WebDriverWait(driver.get(),Duration.ofSeconds(30L));
			}
		}
	}

	public void goToWebsite(String url) {
		logger.info("Visiting the website " + url);
		driver.get().get(url);
	}

	public void maximizeWindow() {
		logger.info("Maximizing the browser window");
		driver.get().manage().window().maximize();
	}

	public void clickOn(By locator) {

		//WebElement element = driver.get().findElement(locator);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		logger.info("Element found and performed click operation");
	}
	public void clickOnCheckBox(By locator) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.click();
		logger.info("Element found and performed click operation");
	}

	public void clickOn(WebElement element) {
		
		element.click();
		logger.info("Element found and performed click operation");
	}

	public void enterText(By locator, String value) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(value);
		logger.info("Element found and entered text " + value);
	}
	
	public void clearTextBox(By locator) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.clear();
		logger.info("Element found and textbox is cleared ");
	}

	public void selectFromDropdown(By dropDownLocator, String optionToSelect) {
		WebElement element = driver.get().findElement(dropDownLocator);
		Select select = new Select(element);
		select.selectByVisibleText(optionToSelect);
		logger.info("Option selected from dropdown " + optionToSelect);

	}

	public void enterSpecialKey(By locator, Keys keyToEnter) {

		//WebElement element = driver.get().findElement(locator);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		element.sendKeys(keyToEnter);
		logger.info("Element found and entered key " + keyToEnter);
	}

	public String getVisibleText(By locator) {

		WebElement element = driver.get().findElement(locator);
		String text = element.getText();
		logger.info("Element found and returning visible text " + text);
		return text;
	}

	public String getVisibleText(WebElement element) {

		String text = element.getText();
		logger.info("Returning visible text " + text);
		return text;
	}

	public List<String> getAllVisibleText(By locator) {

		List<WebElement> elementList = driver.get().findElements(locator);
		List<String> list = new ArrayList<String>();
		for (WebElement element : elementList) {
			System.out.println(getVisibleText(element));
			list.add(getVisibleText(element));
		}

		return list;
	}
	
	public List<WebElement> getAllElements(By locator) {

		List<WebElement> elementList = driver.get().findElements(locator);

		return elementList;
	}
	

	public String takeScreenshot(String name) {

		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "//screenshots//" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;

	}

	public static void quit() {
		System.out.println("Tear down the browser");
		if (driver.get() != null) {
			try {
				driver.get().quit();
			} catch (Exception e) {
				System.err.println("Error during driver quit: " + e.getMessage());
			} finally {
				driver.remove();
			}

		}
	}

}
