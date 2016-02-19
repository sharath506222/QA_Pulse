package com.pulselms.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.BookmarkPanelScreen;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.base.test.MobileBaseTest;


public class BookmarksPanelTest extends MobileBaseTest {
	

	@Test
	public void BookmarkIconVerificationTest() {

		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		Assert.assertEquals(bookmarksicon.isBookmarkPanelIconPresent(), true);

	}

	@Test
	public void TapBookmarkIconVerificationTest() {

		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		bookmarksicon.backButton();
		Assert.assertEquals(bookmarksicon.isReadingLayoutPresent(), true);

	}

	@Test
	public void TaponBookmarksPanelIconTopandBottomBarDisableTest() {

	

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);

	}

	@Test
	public void TaponBookmarksPanelHeaderPresentTest() {

		

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(5);
		myBookShelfScreen.waitForBookDownload(5);
		myBookShelfScreen.tapOnBook(5);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		Assert.assertEquals(bookmarksicon.isBookmarkPanelEmptyPresent(), true);

	}

	@Test
	public void PageIndexandBookmarksPanelHeaderPresentTest() {

		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		Assert.assertEquals(bookmarksicon.isBookmarkPanelPageIndexPresent(), true);
		Assert.assertEquals(bookmarksicon.isBookmarkPanelDeleteIconPresent(), true);
		Assert.assertEquals(bookmarksicon.isBookmarkDescriptionPresent(), true);

	}

	@Test
	public void DisplayBookmarksPanelListOrderTest() {



		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		List<String> BookmarksPanelList = new ArrayList<String>();
		BookmarksPanelList = bookmarksicon.BookmarksPanelList();
		List<Integer> bookmarkspanelOriginal = new ArrayList<Integer>();

		for (String note : BookmarksPanelList) {

			log.info(BookmarksPanelList);
			bookmarkspanelOriginal.add(Integer.parseInt((note.split(" "))[1]));
		}
		List<Integer> bookmarklistCopy = new ArrayList<Integer>();
		for (String note : BookmarksPanelList) {
			log.info(BookmarksPanelList);
			bookmarklistCopy.add(Integer.parseInt((note.split(" "))[1]));
		}
		log.info(bookmarkspanelOriginal);
		Collections.sort(bookmarklistCopy);
		log.info(bookmarklistCopy);
		Assert.assertEquals(bookmarkspanelOriginal.equals(bookmarklistCopy), true);

	}

	@Test
	public void TapOnPageIndexTest() {

	

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		bookmarksicon.tapPageIndex();
		Assert.assertEquals(bookmarksicon.isReadingLayoutPresent(), true);

	}

	@Test
	public void BookmarksTittlePresentTest() {

	

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);

	}

	@Test
	public void BookmarksPanelDeleteTest() {

		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		int CountBD = bookmarksicon.BookmarksPanelList().size();
		bookmarksicon.bookMarkPanelDelete();
		int CountAD = bookmarksicon.BookmarksPanelList().size();

		Assert.assertEquals(CountAD, CountBD - 1);

	}

	@Test
	public void DisplayLandscapeandPortraitTest() {



		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		readingViewScreen.rotateDeviceToLandscape();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		readingViewScreen.rotateDeviceToPortrait();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);

	}

	@Test
	public void bookMarksPanelRunningInBackgroundTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		BookmarkPanelScreen bookmarksicon = PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);
		try {
			readingViewScreen.runAppInBackground(3);
		} catch (WebDriverException e) {
			log.info("Ignoring App Activity Error");
		}
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		bookmarksicon.tapBookmarkPanel();
		Assert.assertEquals(bookmarksicon.isBookmarkPanelHeaderPresent(), true);

	}

}
