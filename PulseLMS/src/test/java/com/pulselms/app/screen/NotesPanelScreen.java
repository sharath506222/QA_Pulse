package com.pulselms.app.screen;

import java.util.List;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

public class NotesPanelScreen extends AppiumBase {

	private static String NotesPanel = ObjectLocators.getLocator("RightPanel");
	private static String NotesIcon = ObjectLocators.getLocator("NotesIcon");
	private static String HighlightsHeader = ObjectLocators.getLocator("HighlightsHeader");
	private static String PageIndex = ObjectLocators.getLocator("PageIndex");
	private static String HighlightText = ObjectLocators.getLocator("HighlightText");
	private static String HighlightandNoteText = ObjectLocators.getLocator("HighlightandNoteText");
	private static String ReadingLayout = ObjectLocators.getLocator("ReadingLayout");
	private static String HighlightSave = ObjectLocators.getLocator("HighlightSave");

	private static String HighlightDelete = ObjectLocators.getLocator("HighlightDelete");
	private static String HighlightEdit = ObjectLocators.getLocator("HighlightEdit");

	public boolean isNotesPanelPresent() {

		return isElementPresent(NotesPanel);
	}

	public boolean isHighlightSavePresent() {

		return isElementPresent(HighlightSave);
	}

	public boolean isHighlightDeletePresent() {

		return isElementPresent(HighlightDelete);
	}

	public boolean isHighlightEditPresent() {

		return isElementPresent(HighlightEdit);
	}

	public boolean isNotesPanelIconPresent() {

		return isElementPresent(NotesIcon);
	}

	public boolean isNotesandHighlightsPresent() {

		return isElementPresent(HighlightsHeader);
	}

	public void tapNoteIcon() {

		clickOnElement(NotesIcon);
		wait(Until.elementsToBePresent(HighlightsHeader));
	}

	public boolean isPageIndexPresent() {

		return isElementPresent(PageIndex);
	}

	public boolean isHighLightTextPresent() {

		return isElementPresent(HighlightText);
	}

	public boolean isHighlightandNoteTextPresent() {

		return isElementPresent(HighlightandNoteText);
	}

	public void tapPageIndex() {

		clickOnElement(PageIndex);
		wait(Until.elementsToBePresent(ReadingLayout));
	}

	public boolean isReadingLayoutPresent() {

		clickOnElement(ReadingLayout);

		return isElementPresent(ReadingLayout);

	}

	public void toponReadingPage() {

		clickOnElement(ReadingLayout);

	}

	public void backButton() {

		navigateBack();
		navigateBack();
	}

	public void SaveHighlights() {

		clickOnElement(HighlightText);

	}

	public List<String> NotesandHighlights() {

		return getTextOfSimilarElements(PageIndex);

	}

	public List<String> getNotesandHighlights() {

		return getTextOfSimilarElements(PageIndex);

	}

	public void deleteHighlights() {

		clickOnElement(HighlightDelete);

	}

	public void scrollNotesandHighlights() {

		MobileElement bookOverlay = (MobileElement) driver
				.findElementById("com.pearson.android.readerplus.dev:id/list");
		// .xpath("//android.widget.GridView/android.widget.LinearLayout/android.widget.FrameLayout"));

		bookOverlay.swipe(SwipeElementDirection.DOWN, 100);
		bookOverlay.swipe(SwipeElementDirection.UP, 100);

	}
}
