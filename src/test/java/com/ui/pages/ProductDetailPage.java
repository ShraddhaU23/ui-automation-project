package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Size;
import com.utility.BrowserUtility;

public class ProductDetailPage extends BrowserUtility {
	
	private static final By SIZE_DROPDOWN_LOCATOR= By.id("group_1");
	private static final By ADD_TO_CART_BUTTON_LOCATOR= By.id("add_to_cart");
	private static final By PROCEED_TO_CHECKOUT_BUTTON_LOCATOR= By.xpath("//a[@title='Proceed to checkout']");

	public ProductDetailPage(WebDriver driver) {
		super(driver);
	
	}
	
	public ProductDetailPage selectSize(Size size) {
		selectFromDropdown(SIZE_DROPDOWN_LOCATOR, size.toString());
		return new ProductDetailPage(getDriver());
	}
	
	public ProductDetailPage addProductToCart() {
		clickOn(ADD_TO_CART_BUTTON_LOCATOR);
		return new ProductDetailPage(getDriver());
	}
	
	public ShoppingCartPage clickOnCheckout() {
		clickOn(PROCEED_TO_CHECKOUT_BUTTON_LOCATOR);
		ShoppingCartPage shoppingCartPage =new ShoppingCartPage(getDriver());
		return shoppingCartPage;
	}

}
