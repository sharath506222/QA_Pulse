package com.pulselms.app.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.TOCPanelScreen;
import com.pulselms.base.test.MobileBaseTest;

public class FixedLayoutBookTest extends MobileBaseTest {
	
	@Test
	public void FixedLayoutBasicBookLoadingTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), true);
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		
	}
	
	@Test
	public void FixedLayoutBookInPortriatModeTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		Assert.assertEquals(readingViewScreen.isPageNumberPresent(), true);
		Assert.assertEquals(readingViewScreen.isBookmarkImagePresent(), true);
		Assert.assertEquals(readingViewScreen.isLeftSideBookmarkImagePresent(), false);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), readingViewScreen.getCurrentPageNumberInBook());
		Assert.assertEquals(readingViewScreen.isRightSidePageNumberPresent(), false);
			
		
	}
	
	@Test
	public void FixedLayoutBookInLandscapeModeTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.rotateDeviceToLandscape();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isRightSidePageNumberPresent(), true);
		Assert.assertEquals(readingViewScreen.isLeftSidePageNumberPresent(), true);
		Assert.assertEquals(readingViewScreen.isBookmarkImagePresent(), true);
		Assert.assertEquals(readingViewScreen.isLeftSideBookmarkImagePresent(), true);
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(currentPageNumber, readingViewScreen.getLeftSidePageNumberInBook());
		Assert.assertEquals(currentPageNumber+1, readingViewScreen.getRightSidePageNumberInBook());
				
	}
	
	@Test
	public void FixedLayoutBookSwipingThroughPagesTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.swipeRightToLeft();
		readingViewScreen.sleep(1);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber+1);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		currentPageNumber = readingViewScreen.getCurrentPageNumber(); 
		readingViewScreen.swipeLeftToRight();
		readingViewScreen.sleep(1);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber-1);
		
	}
	
	
	@Test
	public void FixedLayoutBookNavigatingToPagesThroughTOCPanelTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.tapOnTOCIcon();
		TOCPanelScreen tocPanel=PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		tocPanel.waitForTOCScreenToLoad();
		int tocSectionPageNumber =tocPanel.getSectionPageNumber(3);
		tocPanel.tapOnTOCSection(3);
		readingViewScreen.enableOptionBars();
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), tocSectionPageNumber);
		Assert.assertEquals(readingViewScreen.getLeftSidePageNumberInBook(), tocSectionPageNumber);
		
	}
	
	@Test
	public void FixedLayoutBookNavigatingToPagesThroughProgressIndicatorTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		int totalPages = readingViewScreen.getTotalPageNumber();
		if (totalPages%2!=0)
			totalPages=totalPages+1;
		int currentPageNumber=readingViewScreen.getCurrentPageNumber();
		Assert.assertEquals(currentPageNumber, totalPages/2);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.getLeftSidePageNumberInBook(), currentPageNumber);
	}
	
	@Test
	public void FixedLayoutBookPageVerificationWhileResumingFromBookShelfTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		int totalPages = readingViewScreen.getTotalPageNumber();
		int pageNumberBeforeNavigatingBackToBookShelf = readingViewScreen.getCurrentPageNumber();
		if (totalPages%2!=0)
			totalPages=totalPages+1;
		Assert.assertEquals(pageNumberBeforeNavigatingBackToBookShelf, totalPages/2);
		readingViewScreen.navigateBackToBookShelf();
		myBookShelfScreen.tapOnBook(1);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int pageNumberAfterResumingFromBookShelf=readingViewScreen.getCurrentPageNumber();
		Assert.assertEquals(pageNumberAfterResumingFromBookShelf, pageNumberBeforeNavigatingBackToBookShelf);
		
	}
	
}
