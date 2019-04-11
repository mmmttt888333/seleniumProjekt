package com.automationapproach.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.automationapproach.base.BasePageObject;

public class EcosiaLandingPage extends BasePageObject<EcosiaLandingPage>{
	
	private static final String url = "https://www.ecosia.org";
	private By searchBox = By.cssSelector("#__layout > div > section.search-section.section > div.content > form > div.input-wrapper > input");
	private By searchButton = By.cssSelector(".button-submit");
	private By jumpToPhilosophyButton = By.cssSelector(".scroll-down");
	private By shareEcosiaButton = By.cssSelector("a[data-v-25058203] > [data-v-ab3e1330]");
	private By closePlantTreesAddButton = By.cssSelector("button.icon-button:nth-child(4)");

	public EcosiaLandingPage(WebDriver driver) {
		super(driver);
	}
	
	public void launch()
	{
		Reporter.log("Launch page " + url);
		getPage(url);
	}
	
	public void fillSearchBox(final String text) {
		Reporter.log("Fill search box with search term '" + text + "'.");
		fillField(text, searchBox);
	}
	
	public EcosiaResultsPage clickSearchButton() {
		Reporter.log("Click search button and head to EcosiaResultsPage.");
		clickButton(searchButton);
		return new EcosiaResultsPage(driver);
	}
	
	public void clickJumpToPhilosophyButton() {
		Reporter.log("Click 'JumpToPhilosophy' button.");
		clickButton(jumpToPhilosophyButton);
	}
	
	public void clickClosePlantTreesAddButton() {
		Reporter.log("Click the close button to close the 'PlantTrees' advertising.");
		clickButton(closePlantTreesAddButton);
	}	
	
	
	public Boolean jumpToPhilosophyButtonIsDiplayed() {
		return elementIsDisplayed(jumpToPhilosophyButton);
	}
	
	public Boolean shareEcosiaButtonIsDiplayed() {
		return elementIsDisplayed(shareEcosiaButton);
	}
	
	public void waitUntilPageHasLoaded() {
		waitForVisibilityOf(searchBox);
	}

}
