package com.utility;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LambdaTestUtility {

	private static final String HUBURL = "https://hub.lambdatest.com/wd/hub";
	private static final ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static final ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();

	public static WebDriver initializeLambdaTestSession(String browser, String testName) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "127");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "umredkarshraddha97");
        ltOptions.put("accessKey","LT_Kcl4j6cdeuR6Rtmo9jJGBObPxzfdxKszqBpatlYSQhn0wNc");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "4.23.0");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver =null;
        try {
        driver = new RemoteWebDriver(new URL(HUBURL), capabilitiesLocal.get());
        }catch(MalformedURLException e) {
        	e.printStackTrace();
        }
        driverLocal.set(driver);
	
	return driverLocal.get();

}
	
	public static void quitSession() {
		if(driverLocal.get()!=null) {
			driverLocal.get().quit();
		}
	}
}
