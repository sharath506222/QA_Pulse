package com.pulselms.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.SearchScreen;
import com.pulselms.base.test.MobileBaseTest;

public class SearchTest extends MobileBaseTest {
	
	private static String keyword = "Life Orientation";

	@Test
	public void SearchButtonVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);

		Assert.assertEquals(searchscreen.isSearchButtonPresent(), true);

	}

	@Test
	public void SearchButtonClickVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);

		searchscreen.SearchButtonClick();

		Assert.assertEquals(searchscreen.isSearchBookshelfPresent(), true);
		Assert.assertEquals(searchscreen.isSearchBookShelf(), true);
		//Assert.assertEquals(searchscreen.getSearchBookShelfText(), "    Search Bookshelf. Editing.");
		//Assert.assertEquals(searchscreen.getSearchBookShelfText().contains("Search Bookshelf"), true);
		
	}

	// Need to test this Test once Close button available in search
	@Test
	public void SearchEnteredTextVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);
		searchscreen.SearchButtonClick();
		searchscreen.CloseButtonClick();
		Assert.assertEquals(searchscreen.isSearchClosePresent(), false);
		Assert.assertEquals(searchscreen.isSearchButtonPresent(), true);

	}

	@Test
	public void SearchClearTextVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);
		searchscreen.search(keyword);
		searchscreen.getSearchBookShelfText();
		searchscreen.CloseButtonClick();
		List<String> bookList = new ArrayList<String>();
		bookList = myBookShelfScreen.getBookList();
		List<String> copyOfBookList = new ArrayList<String>();
		for (String book : bookList) {

			copyOfBookList.add(book);
		}
		log.info(bookList);
		Collections.sort(copyOfBookList, String.CASE_INSENSITIVE_ORDER);
		log.info(copyOfBookList);

		Assert.assertEquals(searchscreen.isSearchClearPresent(), false);
		Assert.assertEquals(copyOfBookList.equals(bookList), true);
		Assert.assertEquals(searchscreen.getSearchBookShelfText(),"    Search Bookshelf. Editing.");
		
	}

	@Test
	public void SearchBooksMatchingVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		SearchScreen searchScreen = PageFactory.instantiatePage(driver, SearchScreen.class);
		searchScreen.search(keyword);
		List<String> bookList = new ArrayList<String>();
		bookList = myBookShelfScreen.getBookList();
		for (String book : bookList) {
			Assert.assertEquals(book.contains(keyword), true);
		}
		log.info(bookList);
		Assert.assertEquals(searchScreen.isSearchClearPresent(), false);
		

	}

	@Test
	public void SearchRunningAppBackgroundandResumeTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);

		searchscreen.search(keyword);

		searchscreen.runAppInBackground(3);

		searchscreen.search(keyword);
		List<String> bookList = new ArrayList<String>();
		bookList = myBookShelfScreen.getBookList();
		for (String book : bookList) {
			Assert.assertEquals(book.contains(keyword), true);
		}
		log.info(bookList);
		Assert.assertEquals(searchscreen.isSearchClearPresent(), false);

		Assert.assertEquals(searchscreen.isSearchBookshelfPresent(), true);

	}

	@Test
	public void SearchOpenBookandReturnBookshelfBackTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);
		searchscreen.search(keyword);

		myBookShelfScreen.tapOnBook(1);

		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.navigateBackToBookShelf();
		List<String> bookList = new ArrayList<String>();
		bookList = myBookShelfScreen.getBookList();
		for (String book : bookList) {
			Assert.assertEquals(book.contains(keyword), true);

		}
		log.info(bookList);

		Assert.assertEquals(searchscreen.isSearchBookshelfPresent(), true);

	}

	@Test
	public void SearchOfflineVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		SearchScreen searchscreen = PageFactory.instantiatePage(driver, SearchScreen.class);
		searchscreen.setWifiConnection(false);
		searchscreen.search(keyword);

		List<String> bookList = new ArrayList<String>();
		bookList = myBookShelfScreen.getBookList();
		for (String book : bookList) {
			Assert.assertEquals(book.contains(keyword), true);

		}
		log.info(bookList);

		Assert.assertEquals(searchscreen.isSearchClearPresent(), false);
		Assert.assertEquals(searchscreen.isSearchBookshelfPresent(), true);

	}
}
