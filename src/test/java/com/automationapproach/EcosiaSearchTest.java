package com.automationapproach;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationapproach.base.BaseWebTest;
import com.automationapproach.base.CsvDataProvider;
import com.automationapproach.pages.EcosiaLandingPage;
import com.automationapproach.pages.EcosiaResultsPage;

public class EcosiaSearchTest extends BaseWebTest {
	
	@Test(dataProvider = "CsvDataProvider", dataProviderClass = CsvDataProvider.class)
	public void ecosiaSearchTest(Map<String, String> testData) {
		
		// 1. open ecosia page - https://www.ecosia.org
		EcosiaLandingPage landingPage = new EcosiaLandingPage(driver);
		landingPage.launch();
		landingPage.waitUntilPageHasLoaded();
		
		// 2. verifications
		// 2.1 make sure button 'jumpToEcosiaPhilosophy' is existing
		Assert.assertTrue(landingPage.jumpToPhilosophyButtonIsDiplayed(), "Button 'jumpToEcosiaPhilosophy' is not displayed.");
		
		// 2.2 verify page title - Ecosia – Die Suchmaschine, die Bäume pflanzt
		Assert.assertEquals(landingPage.pageTitle(), "Ecosia – Die Suchmaschine, die Bäume pflanzt");
		
		// 3. enter search string on Ecosia landing page
		final String searchTerm = testData.get("serachTerm");
		landingPage.fillSearchBox(searchTerm);
		
		// 4. click search button and wait for results page to load
		EcosiaResultsPage resultsPage = landingPage.clickSearchButton();
		resultsPage.waitUntilPageHasLoaded();
		
		// 5. verifications
		// 5.1 title of page correct - "[search string entered in step 4] - Ecosia"
		final String expectedPageTitle = searchTerm + " - Ecosia";
		Assert.assertEquals(resultsPage.pageTitle(), expectedPageTitle, "Unexpected page title.");
		
		// 5.2 correct navigation bar element loaded - "web"
		Assert.assertTrue(resultsPage.webCategoryIsOpen(), "Category 'Web' is not open.");
		
		// 5.3 search bar on result page contains correct search string - the one entered in step 3
		Assert.assertEquals(resultsPage.textOfSearchBox(), searchTerm, "Unexpected search box content.");
		
	}	

}
