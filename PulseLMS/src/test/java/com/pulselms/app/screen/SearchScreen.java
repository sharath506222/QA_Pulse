package com.pulselms.app.screen;

import org.openqa.selenium.By;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;

public class SearchScreen extends AppiumBase {
	private static String SearchButton = ObjectLocators.getLocator("SearchButton");
	private static String SearchBookshelf = ObjectLocators.getLocator("SearchBookshelf");
	private static String CloseButton = ObjectLocators.getLocator("CloseButton");

	public boolean isSearchButtonPresent() {
		return isElementPresent(SearchButton);
	}

	public boolean isSearchBookshelfPresent() {
		return isElementPresent(SearchBookshelf);
	}

	public boolean isSearchClosePresent() {
		return isElementPresent(CloseButton);
	}

	public boolean isSearchKeyboardPresent() {
		return isElementPresent(SearchButton);
	}

	public boolean isSearchClearPresent() {

		return driver.findElement(By.id("android:id/search_src_text")).equals("");

	}

	public void SearchButtonClick() {

		clickOnElement(SearchButton);

	}

	public void CloseButtonClick() {

		clickOnElement(CloseButton);

	}

	public void search(String keyword) {

		clickOnElement(SearchButton);
		type(SearchBookshelf, keyword);

	}

	public String getSearchBookShelfText() {

		String bookShelftext = driver.findElement(By.id("android:id/search_src_text")).getText();
		
		return bookShelftext;
	}
	public boolean isSearchBookShelf() {

		String bookShelftext = driver.findElement(By.id("android:id/search_src_text")).getText();
		
	boolean bookShelf =	bookShelftext.contains("Search Bookshelf");
		
		return bookShelf;
	}
}
