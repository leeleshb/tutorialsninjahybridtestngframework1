package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseTest;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.pages.SearchPage;
import com.tutorialsninja.qa.pages.ShoppingCartPage;

public class ShoppingCartTest extends BaseTest{

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@Test(priority = 1)
	public void verifyAddingTheProductToCartFromProductDisplayPage() {
				
		HomePage homePage = new HomePage(driver);
		homePage.enterProductNameIntoSearchBoxField(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickOnValidProduct();
		searchPage.clickOnAddToCartButton();
		searchPage.clickOnShoppingCartLink();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		Assert.assertTrue(shoppingCartPage.displayStatusOfValidSearchProduct(), "Search product is not displayed");
	}
	
	@Test(priority = 2)
	public void verifyAddingTheProductToCartFromWishListPage() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		homePage.enterProductNameIntoSearchBoxField(dataprop.getProperty("validProduct"));
		homePage.clickOnSearchButton();
		SearchPage searchPage = new SearchPage(driver);
		searchPage.clickOnAddToWishlist();
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickOnMyWishListHeaderOption();
		accountPage.clickOnAddToCartButton();
		ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
		shoppingCartPage.clickOnShoppingCartHeaderOption();
		Assert.assertTrue(shoppingCartPage.displayStatusOfValidSearchProduct(), "Search product is not displayed");
		
	}
}
