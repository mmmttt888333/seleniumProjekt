package com.automationapproach.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver getDriver(String browser) {
		WebDriver driver;
		switch (browser) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_win32_2.45/chromedriver.exe");
			driver = new ChromeDriver();
			break;

		default:
			System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver_win64_23.0/geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}

}