package com.pulselms.app.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.SearchPanelScreen;
import com.pulselms.base.test.MobileBaseTest;

public class SearchPanelTest extends MobileBaseTest {

	private static String keyword = "fffffffffffffffff";

	@Test
	public void SearchPanelOptionBarsDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(searchpanel.isSearchIconPresent(), true);

	}

	@Test
	public void SearchPanelTaponSearchDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.tapOnPanelSearch();
		searchpanel.toponReadingPage();
		Assert.assertEquals(searchpanel.isReadingLayoutPresent(), true);
		searchpanel.backButton();
		Assert.assertEquals(searchpanel.isReadingLayoutPresent(), true);

	}

	@Test
	public void SearchPanelTopBottomBarVerifyFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.tapOnPanelSearchWaiting();
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		Assert.assertEquals(searchpanel.isLayoutSearchPresent(), false);
	}

	@Test
	public void SearchInBookVerifyFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.tapOnPanelSearch();
		String searchbook = searchpanel.getSearchBook();
		Assert.assertTrue(searchbook.contains("Search in Book"));

	}

	@Test
	public void SearchClosePresentTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.search(keyword);
		Assert.assertEquals(searchpanel.isSearchClosePresent(), true);

	}

	// New Test Cases added
	@Test
	public void SearchPanelPasteDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.search("adasdqweqweqwejhjsdfhsdjkfhsdhfsdfsdfhsd");
		searchpanel.doubletapOnPanelSearch();
		Assert.assertEquals(searchpanel.isSearchPanelPastePresent(), true);

	}

	@Test
	public void SearchPanelSelectAllDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.search("adasdqweqweqwejhjsdfhsdjkfhsdhfsdfsdfhsd");
		searchpanel.doubletapOnPanelSearchforSelectAll();
		Assert.assertEquals(searchpanel.isSearchSelectAllPresent(), true);

	}

	@Test
	public void SearchPanelCutDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.search("adasdqweqweqwejhjsdfhsdjkfhsdhfsdfsdfhsd");
		searchpanel.doubletapOnPanelSearchforSelectAll();
		Assert.assertEquals(searchpanel.isSearchCutPresent(), true);
		searchpanel.clickOnCut();
		String searchbook = searchpanel.getSearchBook();
		Assert.assertTrue(searchbook.contains("Search in Book"));

	}

	@Test
	public void SearchPanelCopyDisplayFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.search("adasdqweqweqwejhjsdfhsdjkfhsdhfsdfsdfhsd");
		searchpanel.doubletapOnPanelSearchforSelectAll();
		Assert.assertEquals(searchpanel.isSearchCopyPresent(), true);
		searchpanel.clickOnCopy();
		String searchbook = searchpanel.getSearchBook();
		Assert.assertTrue(searchbook.contains("adasdqweqweqwejhjsdfhsdjkfhsdhfsdfsdfhsd"));

	}

	}
