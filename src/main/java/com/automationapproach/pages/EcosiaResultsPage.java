package com.automationapproach.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.automationapproach.base.BasePageObject;

public class EcosiaResultsPage extends BasePageObject<EcosiaResultsPage>{
	
	private By searchBox = By.tagName("input");
	private By webCategoryButton = By.xpath("//a[contains(.,'Web')]");

	public EcosiaResultsPage(WebDriver driver) {
		super(driver);
	}
	
	public void waitUntilPageHasLoaded() {
		waitForVisibilityOf(searchBox);
	}
	
	public Boolean webCategoryIsOpen()
	{
		final String cssValue = cssValueOfElement(webCategoryButton, "font-weight");
		return cssValue.equals("700");
	}
	
	public String textOfSearchBox()
	{
		return attributeOfElement(searchBox, "value");
	}

}
