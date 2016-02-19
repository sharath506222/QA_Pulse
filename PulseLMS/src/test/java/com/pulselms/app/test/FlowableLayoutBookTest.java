package com.pulselms.app.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.base.test.MobileBaseTest;

public class FlowableLayoutBookTest extends MobileBaseTest {
	
		
	@Test
	public void FlowableLayoutBasicBookLoadingTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
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
	public void FlowableLayoutBookSwipingThroughPagesTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isScrollOverlayPresent(), true);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		int currentPageNumber = readingViewScreen.getCurrentPageNumber();
		readingViewScreen.swipeBottomToTop();
		readingViewScreen.sleep(1);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber+1);
		readingViewScreen.disableOptionbars();
		readingViewScreen.waitForOptionBarsToDisappear();
		readingViewScreen.enableOptionBars();
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		currentPageNumber = readingViewScreen.getCurrentPageNumber(); 
		readingViewScreen.swipeTopToBottom();
		readingViewScreen.sleep(1);
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), currentPageNumber-1);
		
	}

}
