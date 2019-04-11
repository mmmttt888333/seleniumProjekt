package com.automationapproach.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseWebTest {

	protected WebDriver driver;
	protected Logger log;

	@Parameters({ "browser" })
	@BeforeMethod
	protected void setUp(@Optional("firefox") String browser) {

		driver = BrowserFactory.getDriver(browser);

	}

	@AfterMethod
	protected void tearDown() {

		driver.quit();

	}

}
