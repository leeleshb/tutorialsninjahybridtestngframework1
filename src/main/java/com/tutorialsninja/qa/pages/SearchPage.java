package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {

	WebDriver driver;
	
	//Objects
	@FindBy(linkText="iMac")
	private WebElement validProduct;
	
	@FindBy(xpath="//div[@id='content']/p[2]")
	private WebElement noProductMessageText;
	
	@FindBy(id="button-cart")
	private WebElement addToCartButton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']/a[2]")
	private WebElement shoppingCartLink;
	
	@FindBy(xpath="//button[@data-original-title='Add to Wish List']/i[@class='fa fa-heart']")
	private WebElement addToWishListLink;
	
	public SearchPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public boolean displayStatusOfValidProduct() {
		
		boolean displayStatus = validProduct.isDisplayed();
		return displayStatus;
	}
	
	public String retreiveNoProductMessageText() {
		
		String noProductMessage = noProductMessageText.getText();
		return noProductMessage;
	}
	
	public void clickOnValidProduct() {
		
		validProduct.click();
	}
	
	public void clickOnAddToCartButton() {
		
		addToCartButton.click();
	}
	
	public void clickOnShoppingCartLink() {
		
		shoppingCartLink.click();
	}
	
	public void clickOnAddToWishlist() {
		
		addToWishListLink.click();
	}
}
