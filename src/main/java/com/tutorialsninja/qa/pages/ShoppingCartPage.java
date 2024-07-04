package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

	WebDriver driver;
	
	@FindBy(linkText="iMac")
	private WebElement validSearchProduct;
	
	@FindBy(xpath="//span[text()='Shopping Cart']")
	private WebElement shoppingCart;
	
	public ShoppingCartPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean displayStatusOfValidSearchProduct() {
		
		boolean displayStatus = validSearchProduct.isDisplayed();
		return displayStatus;
	}
	
	public void clickOnShoppingCartHeaderOption() {
		
		shoppingCart.click();
	}
}
