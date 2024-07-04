package com.tutorialsninja.qa.testcases;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertNotSame;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseTest;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;

public class LogoutTest extends BaseTest{

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		readConfigPropertiesFile();
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
	}
	
	@Test(priority = 1)
	public void verifyLogoutFromMyAccountDropmenu() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		homePage.clickOnMyAccount();
		homePage.clickOnLogoutButton();
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickOnContinueButton();
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 2)
	public void verifyLogoutBySelectingLogoutFromRightOptionColumn() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		AccountPage accountPage = new AccountPage(driver);
		accountPage.clickOnLogoutButton();
		accountPage.clickOnContinueButton();
		String expectedTitle = "Your Store";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(priority = 3)
	public void VerifyApplicationSessionStatusAfterLoggingAndClosingTheBrowserWithoutLogout() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		driver.close();
		driver.get(prop.getProperty("url"));
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']/h2[text()='My Account']")).isDisplayed());
	}

	
	@Test(priority = 4)
	public void VerifyLogoutAndBrowsingBack() {
		
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		homePage.clickOnMyAccount();
		homePage.clickOnLogoutButton();
		driver.navigate().back();
		Assert.assertFalse(driver.findElement(By.xpath("//div[@id='content']/h2[text()='My Account']")).isDisplayed());
	}
}
