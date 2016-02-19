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
import com.pulselms.base.test.MobileBaseTest;

/**
 * MyBookShelf Test Class which has test scenarios for Book Shelf module
 * @author Cognizant
 *
 */
public class MyBookShelfTest extends MobileBaseTest {
	
		
	@Test
	public void MyBookShelfDisplayOrderVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		List<String> bookList=new ArrayList<String>();
		bookList=myBookShelfScreen.getBookList();
		List<String> copyOfBookList = new ArrayList<String>();
		for (String book : bookList) {
			
			copyOfBookList.add(book);
		}
		log.info(bookList);
		Collections.sort(copyOfBookList,String.CASE_INSENSITIVE_ORDER);
		log.info(copyOfBookList);
		Assert.assertEquals(copyOfBookList.equals(bookList), true);
		
	}
	
	@Test
	public void MyBookShelfCloudDownArrowIconVerificationTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		Assert.assertEquals(myBookShelfScreen.isCloudDownArrowIconPresentForAllBooks(),true);
	}
	
	@Test
	public void MyBookShelfDashBoardViewTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		Assert.assertEquals(myBookShelfScreen.isBookShelfLayoutPresent(), true);
		myBookShelfScreen.goToMyNotes();
		myBookShelfScreen.navigateBackToMyBookShelf();
		Assert.assertEquals(myBookShelfScreen.isBookShelfLayoutPresent(), true);
		
	}
	
	@Test
	public void MyBookShelfScreenOrientationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.rotateDeviceToLandscape();
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isMyNotesTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isSerachButtonPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isSignOutLinkPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isVersionNumberPresent(), true);
		myBookShelfScreen.rotateDeviceToPortrait();
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isMyNotesTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isSerachButtonPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isSignOutLinkPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
		Assert.assertEquals(myBookShelfScreen.isVersionNumberPresent(), true);
		
	}
	
	@Test
	public void MyBookShelfProvisionedBookListToTheUserTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		List<String> actualBookList=new ArrayList<String>();
		actualBookList=myBookShelfScreen.getBookList();
		List<String> expectedBookList = new ArrayList<String>();
		expectedBookList.add("All About Mummies");
		expectedBookList.add("Life Orientation");
		expectedBookList.add("Focus: Life Sciences");
		expectedBookList.add("Life Skills");
		Assert.assertEquals(expectedBookList.size(), actualBookList.size());
		Assert.assertEquals(expectedBookList.equals(actualBookList), true);
		
	}
	
	@Test
	public void MyBookShelfScrollingViewVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("reader3.sa@uat.com", password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		List<String> bookList=new ArrayList<String>();
		bookList=myBookShelfScreen.getBookList();
		log.info(bookList);
		myBookShelfScreen.scrollBookShelf();
		List<String> bookListAfterScroll=new ArrayList<String>();
		bookListAfterScroll=myBookShelfScreen.getBookList();
		log.info(bookListAfterScroll);
		Assert.assertEquals(bookListAfterScroll.equals(bookList), false);
		
	}
	
	@Test(enabled=false)
	public void MyBookShelfOfflineErrorVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.setWifiConnection(false);
		myBookShelfScreen.tapOnBook(1);
		//take fews screenshot to capture the screen with toast message 
		// iterate through the screenshots and find out the error
		
	}
	
	@Test(enabled=false)
	public void MyBookShelfOfflineErrorVerificationFromPausedStateTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.setWifiConnection(false);
		//take fews screenshot to capture the screen with toast message 
		// iterate through the screenshots and find out the error
		
	}
	
	@Test
	public void MyBookShelfDownloadOrderVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.tapOnBook(2);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(2), true);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Downloading");
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(3), "Downloading");
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(2), "Queued");
		
	}
	
	@Test
	public void MyBookShelfDownloadingIndicatorVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.isProgressTextPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Downloading");
		
	}
	
	
	@Test
	public void MyBookShelfPausedStateVerificationTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.sleep(1);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.sleep(1);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(1), false);
		Assert.assertEquals(myBookShelfScreen.isProgressTextPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Paused");
		
	}
	
	@Test
	public void MyBookShelfDownloadStateWhenResumingAppFromBackGroundTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.sleep(1);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.isProgressTextPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(3), "Downloading");
		myBookShelfScreen.runAppInBackground(2);
	//	Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.isProgressTextPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(3), "Paused");
	}
	
	@Test
	public void MyBookShelfFromPausedStateToDownloadStateTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.sleep(1);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Downloading");		
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.sleep(1);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Paused");
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.sleep(1);
		Assert.assertEquals(myBookShelfScreen.isProgressIndicatorPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.isProgressTextPresentInBook(1), true);
		Assert.assertEquals(myBookShelfScreen.getProgressTextInBook(1), "Downloading");
		
		
	}
	
	
	@Test
	public void MyBookShelfNewLabelOnDownloadedBookTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		Assert.assertEquals(myBookShelfScreen.isNewLabelPresentInBook(2), true);
		Assert.assertEquals(myBookShelfScreen.isShadedIconPresentInBook(2), true);
		Assert.assertEquals(myBookShelfScreen.getNewLabelTextInBook(2), "new");
		
	}
	
	@Test
	public void MyBookShelfDownloadedBookStateWhenResumingAppFromBackGroundTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.runAppInBackground(2);
		Assert.assertEquals(myBookShelfScreen.isNewLabelPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.isShadedIconPresentInBook(3), true);
		Assert.assertEquals(myBookShelfScreen.getNewLabelTextInBook(3), "new");
		
	}
	
	
	@Test
	public void MyBookShelfTapOnDownloadedBookAndVerifyReadingViewElementsTest() throws Exception {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isLoadingIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isPreparingTextPresent(), true);
		Assert.assertEquals(readingViewScreen.getPreparingText(), "Preparing Book ..");
		
	}
	
	@Test
	public void MyBookShelfTapOnDownloadedBookInOfflineModeAndVerifyReadingViewElementsTest() throws Exception {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1);
		myBookShelfScreen.setWifiConnection(false);
		myBookShelfScreen.tapOnBook(1);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		Assert.assertEquals(readingViewScreen.isLoadingIconPresent(), true);
		Assert.assertEquals(readingViewScreen.isPreparingTextPresent(), true);
		Assert.assertEquals(readingViewScreen.getPreparingText(), "Preparing Book ..");
		
	}
	
	@Test
	public void MyBookShelfShadeIconShouldNotPresentForAlreadyOpenedBookTest() {
		
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
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.navigateBackToBookShelf();
		Assert.assertEquals(myBookShelfScreen.isShadedIconPresentInBook(2), false);
		Assert.assertEquals(myBookShelfScreen.isNewLabelPresentInBook(2), false);
		
	}
	
	@Test
	public void MyBookShelfShadeIconShouldNotPresentForAlreadyOpenedBookAfterResumingAppFromBackgroundTest() {
		
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.tapOnBook(3);
		myBookShelfScreen.waitForBookDownload(3);
		myBookShelfScreen.tapOnBook(3);
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.navigateBackToBookShelf();
		readingViewScreen.runAppInBackground(2);
		Assert.assertEquals(myBookShelfScreen.isShadedIconPresentInBook(3), false);
		Assert.assertEquals(myBookShelfScreen.isNewLabelPresentInBook(3), false);
		
	}
	
	@Test
	public void MyBookShelfShadeIconShouldNotPresentInOfflineModeForAlreadyOpenedBookTest() {
		
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
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.setWifiConnection(false);
		readingViewScreen.navigateBackToBookShelf();
		Assert.assertEquals(myBookShelfScreen.isShadedIconPresentInBook(2), false);
		Assert.assertEquals(myBookShelfScreen.isNewLabelPresentInBook(2), false);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

		
		
	
	


}
