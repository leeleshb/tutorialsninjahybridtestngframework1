package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;
	
	//Objects
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailAddressField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(xpath="//input[@name='newsletter'][@value='1']")
	private WebElement newsletterRadioButton;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	private WebElement emailAlreadyRegisteredWarning;
	
	@FindBy(xpath="//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarning;
	
	@FindBy(xpath="//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement firstNameWarning;
	
	@FindBy(xpath="//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement lastNameWarning;
	
	@FindBy(xpath="//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement emailWarning;
	
	@FindBy(xpath="//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement telephoneWarning;
	
	@FindBy(xpath="//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement passwordWarning;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void enterFirstName(String firstNameText) {
		
		firstNameField.sendKeys(firstNameText);
	}
	
	public void enterLastName(String lastNameText) {
		
		lastNameField.sendKeys(lastNameText);
	}
	
	public void enterEmailAddress(String emailText) {
		
		emailAddressField.sendKeys(emailText);
	}
	
	public void enterTelephone(String telephoneText) {
		
		telephoneField.sendKeys(telephoneText);
	}
	
	public void enterPassword(String passwordText) {
		
		passwordField.sendKeys(passwordText);
	}
	
	public void enterConfirmPassword(String confirmPasswordText) {
		
		confirmPasswordField.sendKeys(confirmPasswordText);
	}
	
	public void clickOnNewsletterRadioButton() {
		
		newsletterRadioButton.click();
	}
	
	public void clickOnPrivacyPolicyFieldCheckbox() {
		
		privacyPolicyField.click();
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
	
	public String retrieveEmailAlreadyRegisteredWarningMessageText() {
		
		String emailWarningText = emailAlreadyRegisteredWarning.getText();
		return emailWarningText;
	}
	
	public String retrievePrivacyPolicyWarningMessageText() {
		
		String privacyPolicyWarningText = privacyPolicyWarning.getText();
		return privacyPolicyWarningText;
	}
	
	public String retrieveFirstNameWarningMessageText() {
		
		String firstNameWarningText = firstNameWarning.getText();
		return firstNameWarningText;
	}
	
	public String retrieveLastNameWarningMessageText() {
		
		String lastNameWarningText = lastNameWarning.getText();
		return lastNameWarningText;
	}
	
	public String retrieveEmailWarningMessageText() {
		
		String emailWarningText = emailWarning.getText();
		return emailWarningText;
	}
	
	public String retrieveTelephoneWarningMessageText() {
		
		String telephoneWarningText = telephoneWarning.getText();
		return telephoneWarningText;
	}
	
	public String retrievePasswordWarningMessageText() {
		
		String passwordWarningText = passwordWarning.getText();
		return passwordWarningText;
	}

}
