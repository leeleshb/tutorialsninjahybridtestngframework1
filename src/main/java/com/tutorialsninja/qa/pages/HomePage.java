package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccountDropMenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement searchBox;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement searchButton;
	
	@FindBy(linkText="Logout")
	private WebElement logoutOption;
	
	public HomePage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public void clickOnMyAccount() {
		
		myAccountDropMenu.click();
	}
	
	public void selectLoginOption() {
		
		loginOption.click();
	}
	
	public void selectRegisterOption() {
		
		registerOption.click();
	}
	
	public void enterProductNameIntoSearchBoxField(String productName) {
		
		searchBox.sendKeys(productName);
	}
	
	public void clickOnSearchButton() {
		
		searchButton.click();
	}
	
	public void clickOnLogoutButton() {
		
		logoutOption.click();
	}
}
