package com.automationapproach.base;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageObject<T> {
	
	protected WebDriver driver;
	protected WebDriverWait wait;

	protected BasePageObject(WebDriver driver) {
	
		this.driver = driver;
		wait = new WebDriverWait(driver, 40);
	}
	
	@SuppressWarnings("unchecked")
	protected T getPage(String url) {
		driver.get(url);
		return (T) this;
	}
	
	protected void fillField(String text, By elementLocator) {
		find(elementLocator).clear();
		find(elementLocator).sendKeys(text );		
	}
	
	protected void clickButton(By elementLocator) {
		find(elementLocator).click();		
	}

	private WebElement find(By elementLocator) {
		return driver.findElement(elementLocator);
	}	
	
	protected void waitForVisibilityOf(By elementLocator, Integer... timeOutInSeconds) {
		int attempts = 0;
		while (attempts < 2) {
			try {
				waitFor(ExpectedConditions.visibilityOfElementLocated(elementLocator), (timeOutInSeconds.length > 0 ? timeOutInSeconds[0] : null));
				break;
			} catch (StaleElementReferenceException e) {
				e.printStackTrace();
			}
			attempts++;
			
		}		
	}
	
	private void waitFor(ExpectedCondition<WebElement> condition, Integer timeOutInSeconds) {
		timeOutInSeconds = timeOutInSeconds != null ? timeOutInSeconds : 30;
		wait = new WebDriverWait(driver, timeOutInSeconds);
		wait.until(condition);
	}
	
	public String pageTitle() {
		return driver.getTitle();
	}
	
	protected String cssValueOfElement(By elementLocator, final String cssProperty) {
		return find(elementLocator).getCssValue(cssProperty);
	}
	
	protected String attributeOfElement(By elementLocator, final String attribute) {
		return find(elementLocator).getAttribute(attribute);
	}
	
	protected String textOfElement(By elementLocator) {
		return find(elementLocator).getText();
	}
	
	protected Boolean elementIsDisplayed(By elementLocator) {
		return find(elementLocator).isDisplayed();
	}
}
