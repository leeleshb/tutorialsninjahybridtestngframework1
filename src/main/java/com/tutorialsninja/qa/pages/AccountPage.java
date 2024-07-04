package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;
	
	//Objects
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	@FindBy(xpath="//div[@id='content']/h1")
	private WebElement accountCreatedMessage;
	
	@FindBy(linkText="Continue")
	private WebElement continueButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutOption;
	
	@FindBy(xpath="//i[@class='fa fa-heart']")
	private WebElement myWishList;
	
	@FindBy(xpath="//button[@data-original-title='Add to Cart']")
	private WebElement addToCartButton; 
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean getDisplayStatusOfEditYourAccountInformationOption() {
		
		boolean displayStatus = editYourAccountInformationOption.isDisplayed();
		return displayStatus;
	}
	
	public String accountCreatedMessageText() {
		
		String accountCreatedText = accountCreatedMessage.getText();
		return accountCreatedText;
	}
	
	public void clickOnContinueButton() {
		
		continueButton.click();
	}
	
	public void clickOnLogoutButton() {
		
		logoutOption.click();
	}
	
	public void clickOnMyWishListHeaderOption() {
		
		myWishList.click();
	}
	
	public void clickOnAddToCartButton() {
		
		addToCartButton.click();
	}
}
