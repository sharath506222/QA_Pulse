package com.pulselms.app.test;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.SearchPanelScreen;
import com.pulselms.app.screen.TOCPanelScreen;
import com.pulselms.base.test.MobileBaseTest;

public class TOCTest extends MobileBaseTest {
	
	@Test
	public void TOCMenuDisplayVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(tocPanel.isTOCIconPresent(), true);

	}

	@Test
	public void TOCTaponBookDisplayVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(tocPanel.isTOCIconPresent(), true);

	}

	@Test
	public void TapOnTOCMenuDisplayVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);

	}

	@Test
	public void TapAnypageonTOCMenuDisplayVerificationTest() {
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
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.toponReadingPage();
		Assert.assertEquals(searchpanel.isReadingLayoutPresent(), true);
		searchpanel.backButton();
		Assert.assertEquals(searchpanel.isReadingLayoutPresent(), true);
	}

	@Test
	public void TapOnTOCTableofcontentListDisplayVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		Assert.assertEquals(tocPanel.isTOCListPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

	@Test
	public void TapOnTOCHighlightandDisplayCorrespondingPageVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		int tocSectionPageNumber = tocPanel.getSectionPageNumber(2);
		tocPanel.tapOnTOCSection(2);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), tocSectionPageNumber);
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), false);
		// Need to check with Highlighted lines

	}

	@Test
	// Need to checking swiping the pages
	public void TOCSwipingThroughPagesTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.swipeTopToBottom();
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		Assert.assertEquals(tocPanel.isTOCListPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

	@Test

	public void TOCSwipingCurrentPagesTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.swipeTopToBottom();
		readingViewScreen.sleep(2);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		readingViewScreen.swipeRightToLeft();
		Assert.assertEquals(tocPanel.isTOCListPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

	@Test

	public void TOCNavigatetoPagesThroughProgressIndicatorTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.swipeTopToBottom();
		readingViewScreen.sleep(2);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		int totalPages = readingViewScreen.getTotalPageNumber();
		if (totalPages % 2 != 0)
			totalPages = totalPages + 1;

		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		// tocPanel.getHighlightDisplay(10);

		Assert.assertEquals(tocPanel.isTOCListPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

	@Test
	public void TOCHyperLinkTextDisplayTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		tocPanel.getSectionPageNumber(3);
		tocPanel.tapOnTOCSection(3);
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber);
		tocPanel.tapTOC();
		// tocPanel.getHighlightDisplay(10);
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

	@Test
	public void TOCLandscapeModeandPortraitModeTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		readingViewScreen.rotateDeviceToLandscape();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		readingViewScreen.rotateDeviceToPortrait();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);

	}

	@Test
	public void TOCPanelRunningInBackgroundTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.tapTOC();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		try {
			readingViewScreen.runAppInBackground(2);
		} catch (WebDriverException e) {
			log.info("Ignoring App Activity Error");
		}
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.disableOptionbars();
		tocPanel.tapTOC();
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		Assert.assertEquals(tocPanel.isTOCHeaderPresent(), true);

	}

}
