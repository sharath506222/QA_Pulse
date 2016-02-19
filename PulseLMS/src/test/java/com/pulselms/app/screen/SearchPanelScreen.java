package com.pulselms.app.screen;

import org.openqa.selenium.By;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

import io.appium.java_client.android.AndroidKeyCode;

public class SearchPanelScreen extends AppiumBase {

	private static String OptionBarSearch = ObjectLocators.getLocator("OptionBarSearch");
	private static String SearchInBook = ObjectLocators.getLocator("SearchInBook");
	private static String ReadingLayout = ObjectLocators.getLocator("ReadingLayout");
	private static String DisplaySearchPanel = ObjectLocators.getLocator("DisplaySearchPanel");
	private static String SearchLayout = ObjectLocators.getLocator("SearchLayout");
	private static String SearchClose = ObjectLocators.getLocator("SearchClose");
	private static String NoResultFound = ObjectLocators.getLocator("NoResultFound");
	private static String SearchResultCount = ObjectLocators.getLocator("SearchResultCount");
//	private static String SearchPaste = ObjectLocators.getLocator("SearchPaste");
//	private static String SearchTextBar = ObjectLocators.getLocator("SearchTextBar");
	private static String ImageButton = ObjectLocators.getLocator("ImageButton");
	private static String Paste = ObjectLocators.getLocator("Paste");
	private static String SearchSelectAll = ObjectLocators.getLocator("SearchSelectAll");
	private static String SearchCut = ObjectLocators.getLocator("SearchCut");
	private static String SearchCopy = ObjectLocators.getLocator("SearchCopy");

	public boolean isSearchIconPresent() {

		return isElementPresent(OptionBarSearch);

	}

	public void toponReadingPage() {

		clickOnElement(ReadingLayout);

	}

	public void tapOnPanelSearch() {

		clickOnElement(OptionBarSearch);
		wait(Until.elementToBeInvisible(OptionBarSearch));
	}

	public void tapOnPanelSearchWaiting() {

		tapElement(OptionBarSearch);

	}

	public boolean isSearchLayoutPresent() {

		return isElementPresent(DisplaySearchPanel);

	}

	public boolean isReadingLayoutPresent() {

		clickOnElement(ReadingLayout);

		return isElementPresent(ReadingLayout);

	}

	public boolean isLayoutSearchPresent() {

		return isElementPresent(SearchLayout);

	}

	public String getSearchBook() {

		String searchBook = driver.findElement(By.id("com.pearson.android.readerplus.dev:id/search_edit")).getText();

		return searchBook;
	}

	public boolean isSearchClosePresent() {

		return isElementPresent(SearchClose);

	}

	public void search(String keyword) {

		clickOnElement(OptionBarSearch);
		type(SearchInBook, keyword);

	}

	public void searchSubmit() {
		// submit(SearchInBook);
		sendKeyEvent(AndroidKeyCode.ENTER);
	}

	public boolean isSearchNoResultFoundPresent() {

		return isElementPresent(NoResultFound);

	}

	public boolean isSearchResultsCountPresent() {

		return isElementPresent(SearchResultCount);

	}

	public void backButton() {

		navigateBack();
		navigateBack();
	}

	public void doubletapOnPanelSearch() {

		tapElement(SearchInBook, 2000);
		tapElement(ImageButton);
		tapElement(Paste);
		wait(Until.elementToBePresent(SearchInBook));
	}

	public boolean isSearchPanelPastePresent() {

		return isElementPresent(SearchInBook);

	}

	public void doubletapOnPanelSearchforSelectAll() {

		tapElement(SearchInBook, 2000);

		wait(Until.elementToBePresent(SearchInBook));
	}

	public void clickOnCut() {

		tapElement(SearchCut, 2000);

		wait(Until.elementToBePresent(SearchInBook));
	}

	public void clickOnCopy() {

		tapElement(SearchCopy, 2000);

		wait(Until.elementToBePresent(SearchInBook));
	}

	public boolean isSearchSelectAllPresent() {

		return isElementPresent(SearchSelectAll);

	}

	public boolean isSearchCutPresent() {

		return isElementPresent(SearchCut);

	}

	public boolean isSearchCopyPresent() {

		return isElementPresent(SearchCopy);

	}

}