package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseTest;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;


public class LoginTest extends BaseTest{

	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectLoginOption();
		
	}
	
	@Test(priority = 1, dataProvider = "dataSupply")
	public void VerifyLoginWithValidCredentials(String email, String password) {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(email);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
		AccountPage accountPage = new AccountPage(driver);
		Assert.assertTrue(accountPage.getDisplayStatusOfEditYourAccountInformationOption(), "Edit your account information, option is not displayed");
	}
	
	@DataProvider
	public Object[][] dataSupply() throws IOException {
		
		Object[][] arr = Utilities.getTestDataFromExcel("Login");
		return arr;
	}
	
	@Test(priority = 2)
	public void VerifyLoginWithInvalidCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(dataprop.getProperty("invalidPass"));
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = dataprop.getProperty("warningMessage");
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage);
	}
	
	@Test(priority = 3)
	public void VerifyLoginWithInvalidEmailAndValidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		loginPage.enterPassword(prop.getProperty("validPass"));
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = dataprop.getProperty("warningMessage");
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Actual and expected result matches perfectly");
	}
	
	@Test(priority = 4)
	public void VerifyLoginWithValidEmailAndInvalidPassword() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.enterEmailAddress(prop.getProperty("validEmail"));
		loginPage.enterPassword(dataprop.getProperty("invalidPass"));
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = dataprop.getProperty("warningMessage");
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Actual and expected result matches perfectly");
	}
	
	@Test(priority = 5)
	public void VerifyLoginWithoutCredentials() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.clickOnLoginButton();
		String expectedWarningMessage = dataprop.getProperty("warningMessage");
		String actualWarningMessage = loginPage.retrieveEmailPasswordNotMatchingWarningMessageText();
		Assert.assertEquals(actualWarningMessage, expectedWarningMessage, "Actual and expected result matches perfectly");
	}
	
}
