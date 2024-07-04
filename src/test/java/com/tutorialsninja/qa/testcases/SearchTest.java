package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseTest;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends BaseTest{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	
	@Test(priority = 1)
	public void verifySearchWithValidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterProductNameIntoSearchBoxField(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		Assert.assertTrue(searchPage.displayStatusOfValidProduct(), "Search product is not displayed");
	}
	
	@Test(priority = 2)
	public void verifySearchWithInvalidProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.enterProductNameIntoSearchBoxField(dataprop.getProperty("invalidProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchResult = searchPage.retreiveNoProductMessageText();
		Assert.assertTrue(actualSearchResult.contains(dataprop.getProperty("noProductMatchesHeading")), "Search product is not displayed");
	}
	
	@Test(priority = 3)
	public void verifySearchWithoutProduct() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		String actualSearchResult = searchPage.retreiveNoProductMessageText();
		Assert.assertTrue(actualSearchResult.contains(dataprop.getProperty("noProductMatchesHeading")), "Search product is not displayed");
	}
}
