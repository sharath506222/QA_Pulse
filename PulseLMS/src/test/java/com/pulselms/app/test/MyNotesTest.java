package com.pulselms.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyNotesScreen;
import com.pulselms.base.test.MobileBaseTest;

public class MyNotesTest extends MobileBaseTest {
	

	@Test
	public void MyNotesDisplayOrderVerificationTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		List<String> bookList = new ArrayList<String>();
		bookList = myNotesScreen.getMyNotesList();
		List<String> copyOfBookList = new ArrayList<String>();
		log.info(bookList);
		for (String book : bookList) {

			copyOfBookList.add(book);
		}
		Collections.sort(copyOfBookList, String.CASE_INSENSITIVE_ORDER);
		log.info(copyOfBookList);
		Assert.assertEquals(copyOfBookList.equals(bookList), true);

	}

	@Test
	public void MyNotesDashBoardViewTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		Assert.assertEquals(myNotesScreen.isMyNotesTabPresent(), true);
		myNotesScreen.goToMyNotes();
		myNotesScreen.navigateBackToMyBookShelf();
		Assert.assertEquals(myNotesScreen.isMyNotesTabPresent(), true);

	}

	@Test
	public void MyNotesNoteSectionElementsVerificationTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		log.info("Verify the Index");
		Assert.assertEquals(myNotesScreen.getProgressPageIndex(1), true);
		Assert.assertEquals(myNotesScreen.getProgressHighlighted(1), true);
		Assert.assertEquals(myNotesScreen.getProgressComments(1), true);
		

		
	}

	@Test
	public void MyNotesNoteWindowCancelFunctionalityTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		myNotesScreen.tapOnNote(1);
		myNotesScreen.MyNotesCancel();
		Assert.assertEquals(myNotesScreen.isMyNotesTabPresent(), true);
		
	}

	@Test
	public void MyNotesNoteWindowBackButtonTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		myNotesScreen.tapOnNote(1);
		myNotesScreen.MyNoteBackbutton();
		Assert.assertEquals(myNotesScreen.isMyNotesTabPresent(), true);
	}

	@Test
	public void MyNotesNoteWindowSaveNotesTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		String gettext=myNotesScreen.getNoteText(1);
		System.out.println("Before Saving Notes Gettext-->"+gettext);
		//get note text before save
		myNotesScreen.tapOnNote(1);
		myNotesScreen.MyNotesSave("Testing");
		Assert.assertNotEquals(gettext, "Testing");
	
	}

	
	@Test
	public void MyNotesNotesListForSelectedBookTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		Assert.assertEquals(myNotesScreen.isMyNotesSelectedbooksPresent(), true);
		Assert.assertEquals(myNotesScreen.isMyNotesSelectedNotesPresent(), true);
	
	}
	@Test(priority=8)
	public void MyNotesNoteWindowDeleteNotesTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		myNotesScreen.goToMyNotes();
		//take the notes count 
		int CountBD =myNotesScreen.getNotesCount();
		myNotesScreen.tapOnNote(1);
		System.out.println("Checking the count before delete"+CountBD);
		myNotesScreen.MyNotesDelete();
		int CountAD =myNotesScreen.getNotesCount();
		Assert.assertEquals(CountAD, CountBD-1);

	}
}
