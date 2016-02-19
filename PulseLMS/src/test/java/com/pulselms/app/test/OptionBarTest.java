package com.pulselms.app.test;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.BookmarkPanelScreen;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.NotesPanelScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.TOCPanelScreen;
import com.pulselms.base.test.MobileBaseTest;

public class OptionBarTest extends MobileBaseTest {
	
	
	@Test
	public void OptionBarBasicVerificationTest() {
		
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
	public void OptionBarsDisplayFunctionalityTest() {
		
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
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), true);
		readingViewScreen.disableOptionbars();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		
	}
	
	@Test
	public void OptionBarsStatusWhileResumingTheBookFromBookShelfTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.navigateBackToBookShelf();
		myBookShelfScreen.tapOnBook(2);
		readingViewScreen.waitForReadingViewScreen();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), true);
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		
		
	}
	
	@Test
	public void OptionBarsStatusWhileResumingTheBookFromBackgroundTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		myBookShelfScreen.tapOnBook(2);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		try {
		readingViewScreen.runAppInBackground(3);
		} catch(WebDriverException e)
		{
			log.info("Ignoring App Activity Error");
		}
		myBookShelfScreen.tapOnBook(2);
		readingViewScreen.waitForReadingViewScreen();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), true);
		readingViewScreen.waitForOptionBarsToDisappear();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		
		
	}
	
	@Test
	public void OptionBarUIElementsVerificationTest() {
		
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
		Assert.assertEquals(readingViewScreen.isSearchIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isSettingsIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isTOCIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isNotesIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isBookmarkIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isProgressBarPresent(), true);
		Assert.assertEquals(readingViewScreen.isProgressBarIndicateTheValidPage(1), true);
		
	}
	
	@Test
	public void TOCIconFunctionalityVerificationTest() {
		
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
		readingViewScreen.tapOnTOCIcon();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
		Assert.assertEquals(tocPanel.isTOCPanelPresent(), true);
		
	}
	
	@Test
	public void NotesIconFucntionalityVerificationTest() {
		
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
		readingViewScreen.tapOnNotesIcon();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		NotesPanelScreen notesPanel=PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		Assert.assertEquals(notesPanel.isNotesPanelPresent(), true);
		
	}
	
	
	@Test
	public void BookmarkIconFucntionalityVerificationTest() {
		
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
		readingViewScreen.tapOnBookmarkIcon();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);
		BookmarkPanelScreen bookmarkPanel=PageFactory.instantiatePage(driver, BookmarkPanelScreen.class);
		Assert.assertEquals(bookmarkPanel.isBookmarkPanelPresent(), true);
		
	}
	
	@Test
	public void OptionBarsProgressBarFunctionalityVerificationTest() {
		
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
		readingViewScreen.scrollProgressBar();
		readingViewScreen.waitForPageToLoad();
		int totalPages = readingViewScreen.getTotalPageNumber();
		if (totalPages%2!=0)
			totalPages=totalPages+1;
		Assert.assertEquals(readingViewScreen.getCurrentPageNumber(), totalPages/2);
	//	TOCPanelScreen tocPanel = PageFactory.instantiatePage(driver, TOCPanelScreen.class);
	// Has to write steps for validating the TOC Panel selected item	
		
	}
	

}
