package com.ui.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class SearchResultPage extends BrowserUtility {

	private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");
	private static final By PRODUCT_NAME_LIST = By.xpath("//h5[@itemprop='name']/a");

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	public String getSearchResultTitle() {
		return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
	}

	public boolean isSearchTermPresentInProductList(String searchTerm) {
		List<String> keyword = Arrays.asList(searchTerm.toLowerCase().split(searchTerm));
		List<String> productNamesList = getAllVisibleText(PRODUCT_NAME_LIST);
		boolean result = productNamesList.stream()
				.anyMatch(name -> (keyword.stream().anyMatch(name.toLowerCase()::contains)));

		return result;
	}

	public ProductDetailPage clickOnProduct(int index) {
		clickOn(getAllElements(PRODUCT_NAME_LIST).get(index));
		ProductDetailPage productDetailPage = new ProductDetailPage(getDriver());
		return productDetailPage;
	}

}
