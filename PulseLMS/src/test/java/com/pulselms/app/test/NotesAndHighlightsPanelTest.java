package com.pulselms.app.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.app.screen.MyNotesScreen;
import com.pulselms.app.screen.NotesPanelScreen;
import com.pulselms.app.screen.ReadingViewScreen;
import com.pulselms.app.screen.SearchPanelScreen;
import com.pulselms.base.test.MobileBaseTest;

public class NotesAndHighlightsPanelTest extends MobileBaseTest {
	

	@Test
	public void NotesIconFucntionalityVerificationTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), true);
		Assert.assertEquals(notesPanel.isNotesPanelIconPresent(), true);

	}

	@Test
	public void TaponNotesIconFucntionalityVerificationTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		notesPanel.backButton();
		Assert.assertEquals(notesPanel.isReadingLayoutPresent(), true);
		notesPanel.toponReadingPage();
		Assert.assertEquals(notesPanel.isReadingLayoutPresent(), true);
	}

	@Test
	public void TaponNotesIconTopandBottomBarDisableTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		SearchPanelScreen searchpanel = PageFactory.instantiatePage(driver, SearchPanelScreen.class);
		searchpanel.toponReadingPage();
		Assert.assertEquals(readingViewScreen.isTopOptionBarPresent(), false);
		Assert.assertEquals(readingViewScreen.isBottomOptionBarPresent(), false);

	}

	@Test
	public void DisplayPageIndexandHighlightTextTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		Assert.assertEquals(notesPanel.isHighlightandNoteTextPresent(), true);
		Assert.assertEquals(notesPanel.isHighLightTextPresent(), true);
		Assert.assertEquals(notesPanel.isPageIndexPresent(), true);

	}

	@Test
	public void TapOnPageIndexTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		notesPanel.tapPageIndex();
		Assert.assertEquals(notesPanel.isReadingLayoutPresent(), true);

	}

	@Test
	public void SaveEditandDeleteHighlightTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		notesPanel.SaveHighlights();
		Assert.assertEquals(notesPanel.isHighlightDeletePresent(), true);
		Assert.assertEquals(notesPanel.isHighlightEditPresent(), true);
		Assert.assertEquals(notesPanel.isHighlightSavePresent(), true);
		notesPanel.deleteHighlights();
		Assert.assertEquals(notesPanel.isHighlightDeletePresent(), false);
	}

	@Test
	public void SaveHighlightTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		MyNotesScreen myNotesScreen = PageFactory.instantiatePage(driver, MyNotesScreen.class);
		String gettext = myNotesScreen.getNoteText(1);
		myNotesScreen.MyNotesSave("Testingtest");
		Assert.assertNotEquals(gettext, "Testing");

	}

	@Test
	public void DisplayLandscapeandPortraitTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		readingViewScreen.rotateDeviceToLandscape();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		readingViewScreen.rotateDeviceToPortrait();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);

	}

	@Test
	public void NoteandHighlightsPanelRunningInBackgroundTest() {

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
		readingViewScreen.waitForBookPagesToLoad();
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);
		try {
			readingViewScreen.runAppInBackground(2);
		} catch (WebDriverException e) {
			log.info("Ignoring App Activity Error");
		}
		myBookShelfScreen.tapOnBook(2);
		myBookShelfScreen.waitForBookDownload(2);
		readingViewScreen.waitForReadingViewScreen();
		readingViewScreen.disableOptionbars();
		notesPanel.tapNoteIcon();
		Assert.assertEquals(notesPanel.isNotesandHighlightsPresent(), true);

	}

	@Test
	public void DisplayHighlightsandNotesOrderTest() {

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
		readingViewScreen.enableOptionBars();
		NotesPanelScreen notesPanel = PageFactory.instantiatePage(driver, NotesPanelScreen.class);
		notesPanel.tapNoteIcon();
		List<String> NoteandHighlightsList = new ArrayList<String>();
		NoteandHighlightsList = notesPanel.NotesandHighlights();
		List<Integer> NoteslistOriginal = new ArrayList<Integer>();

		for (String note : NoteandHighlightsList) {

			log.info(NoteandHighlightsList);
			NoteslistOriginal.add(Integer.parseInt((note.split(" "))[1]));
		}
		List<Integer> NoteslistCopy = new ArrayList<Integer>();
		for (String note : NoteandHighlightsList) {
			log.info(NoteandHighlightsList);
			NoteslistCopy.add(Integer.parseInt((note.split(" "))[1]));
		}
		log.info(NoteslistOriginal);
		Collections.sort(NoteslistCopy);
		log.info(NoteslistCopy);
		Assert.assertEquals(NoteslistOriginal.equals(NoteslistCopy), true);

	}

	/*
	 * @Test // Scrolling the highlights and notes commented. sometimes working
	 * only public void HighlightsandNotesScrollingVerficallyTest() {
	 * 
	 * // TC:6 handleTestFairySecutiryPopup(); LoginScreen
	 * loginScreen=PageFactory.instantiatePage(driver, LoginScreen.class);
	 * loginScreen.login(username, password); loginScreen.waitForLoginProcess();
	 * MyBookShelfScreen myBookShelfScreen=PageFactory.instantiatePage(driver,
	 * MyBookShelfScreen.class); myBookShelfScreen.tapOnBook(2);
	 * myBookShelfScreen.waitForBookDownload(2); myBookShelfScreen.tapOnBook(2);
	 * ReadingViewScreen readingViewScreen = PageFactory.instantiatePage(driver,
	 * ReadingViewScreen.class); readingViewScreen.waitForReadingViewScreen();
	 * readingViewScreen.waitForBookPagesToLoad();
	 * readingViewScreen.enableOptionBars(); NotesPanelScreen
	 * notesPanel=PageFactory.instantiatePage(driver, NotesPanelScreen.class);
	 * notesPanel.tapNoteIcon(); List<String> NotesList=new ArrayList<String>();
	 * NotesList=notesPanel.getNotesandHighlights();
	 * notesPanel.scrollNotesandHighlights(); List<String>
	 * NoteandHighlightsList=new ArrayList<String>();
	 * NoteandHighlightsList=notesPanel.getNotesandHighlights();
	 * System.out.println("Testing scroll testing"+NoteandHighlightsList );
	 * Assert.assertEquals(NoteandHighlightsList.equals(NotesList), false); }
	 */

}
