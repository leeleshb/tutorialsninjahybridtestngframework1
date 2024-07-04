package com.tutorialsninja.qa.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.BaseTest;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.HomePage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends BaseTest{
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws IOException {
		
		readConfigPropertiesFile();
		readTestdataPropertiesFile();
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browserName"));
		HomePage homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
		homePage.selectRegisterOption();
	}
	
	
	@Test(priority = 1)
	public void verifyRegisteringAnAccountWithMandatoryFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPass"));
		registerPage.clickOnPrivacyPolicyFieldCheckbox();
		registerPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		String actualHeading = accountPage.accountCreatedMessageText();
		String expectedHeading = dataprop.getProperty("headingMessage");
		Assert.assertEquals(actualHeading, expectedHeading, "Heading is not matching");
		accountPage.clickOnContinueButton();
		
	}
	
	@Test(priority = 2)
	public void verifyRegisteringAnAccountWithAllFields() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(Utilities.generateEmailWithTimeStamp());
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPass"));
		registerPage.clickOnNewsletterRadioButton();
		registerPage.clickOnPrivacyPolicyFieldCheckbox();
		registerPage.clickOnContinueButton();
		AccountPage accountPage = new AccountPage(driver);
		String actualHeading = accountPage.accountCreatedMessageText();
		String expectedHeading = dataprop.getProperty("headingMessage");
		Assert.assertEquals(actualHeading, expectedHeading, "Heading is not matching");
		accountPage.clickOnContinueButton();
		
	}
	
	@Test(priority = 3)
	public void verifyRegisteringAnAccountWithExistingEmail() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.enterFirstName(dataprop.getProperty("firstName"));
		registerPage.enterLastName(dataprop.getProperty("lastName"));
		registerPage.enterEmailAddress(prop.getProperty("validEmail"));
		registerPage.enterTelephone(dataprop.getProperty("telephone"));
		registerPage.enterPassword(dataprop.getProperty("password"));
		registerPage.enterConfirmPassword(dataprop.getProperty("confirmPass"));
		registerPage.clickOnNewsletterRadioButton();
		registerPage.clickOnPrivacyPolicyFieldCheckbox();
		registerPage.clickOnContinueButton();
		String actualEmailWarning = registerPage.retrieveEmailAlreadyRegisteredWarningMessageText();
		String expectedEmailWarning = dataprop.getProperty("EmailWarning");
		Assert.assertEquals(actualEmailWarning, expectedEmailWarning , "Warning message is not matching");
		
	}
	
	@Test(priority = 4)
	public void verifyRegisteringAnAccountWithoutFillingAnyDetails() {
		
		RegisterPage registerPage = new RegisterPage(driver);
		registerPage.clickOnContinueButton();
		
		String actualWarningMessage = registerPage.retrievePrivacyPolicyWarningMessageText();
		Assert.assertTrue(actualWarningMessage.contains(dataprop.getProperty("privacyPolicyWarning")), "Actual warning message is not verified");
		
		String actualFirstNameWarning = registerPage.retrieveFirstNameWarningMessageText();
		Assert.assertTrue(actualFirstNameWarning.contains(dataprop.getProperty("firstNameWarning")), "First name is not verified");
		
		String actualLastNameWarning = registerPage.retrieveLastNameWarningMessageText();
		Assert.assertTrue(actualLastNameWarning.contains(dataprop.getProperty("lastNameWarning")), "Last name is not verified");
		
		String actualEmailWarning = registerPage.retrieveEmailWarningMessageText();
		Assert.assertTrue(actualEmailWarning.contains(dataprop.getProperty("emailWarning")), "Email is not verified");
		
		String actualTelephoneWarning = registerPage.retrieveTelephoneWarningMessageText();
		Assert.assertTrue(actualTelephoneWarning.contains(dataprop.getProperty("telephoneWarning")), "Telephone is not verified");
		
		String actualPasswordWarning = registerPage.retrievePasswordWarningMessageText();
		Assert.assertTrue(actualPasswordWarning.contains(dataprop.getProperty("passwordWarning")), "Password is not verified");
		
	}
	
}
