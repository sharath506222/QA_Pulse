package com.pulselms.app.test;

import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.base.test.MobileBaseTest;

public class NotesAndHighlightsTest  extends MobileBaseTest {
	
	@Test
	public void TakeHightlightsTest() {

		handleTestFairySecutiryPopup();
	/*	LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("vg@uat.com", "hudson102");
		loginScreen.waitForLoginProcess(); */
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
	/*	myBookShelfScreen.tapOnBook(1);
		myBookShelfScreen.waitForBookDownload(1); */
		myBookShelfScreen.tapOnBook(1); 
		ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver, ReadingViewScreen.class);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.swicthToWebView();
		readingViewScreen.takeHighLight();
		

	}

}
