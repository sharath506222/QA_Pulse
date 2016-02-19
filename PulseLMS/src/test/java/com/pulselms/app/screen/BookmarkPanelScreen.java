package com.pulselms.app.screen;

import java.util.List;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

public class BookmarkPanelScreen extends AppiumBase {

	private static String BookmarkPanel = ObjectLocators.getLocator("RightPanel");
	private static String BookmarkPanelIcon = ObjectLocators.getLocator("BookmarkPanelIcon");
	private static String Bookmarkslist = ObjectLocators.getLocator("Bookmarkslist");
	private static String ReadingLayout = ObjectLocators.getLocator("ReadingLayout");
	private static String Bookmarkheader = ObjectLocators.getLocator("Bookmarkheader");
	private static String Bookmarksempty = ObjectLocators.getLocator("Bookmarksempty");
	private static String PageIndex = ObjectLocators.getLocator("PageIndex");
	private static String BookmarkDescription = ObjectLocators.getLocator("BookmarkDescription");
	private static String HighlightDelete = ObjectLocators.getLocator("HighlightDelete");
	private static String BookmarksPanelbyIndex = ObjectLocators.getLocator("BookmarksPanelbyIndex");

	private static String allbookmarks = ObjectLocators.getLocator("allbookmarks");

	public boolean isBookmarkPanelPresent() {

		return isElementPresent(BookmarkPanel);
	}

	public boolean isBookmarkPanelIconPresent() {

		return isElementPresent(BookmarkPanelIcon);
	}

	public void tapBookmarkPanel() {

		clickOnElement(BookmarkPanelIcon);
		wait(Until.elementsToBePresent(Bookmarkheader));

	}

	public boolean isBookmarkPanelListPresent() {

		return isElementPresent(Bookmarkslist);
	}

	public void backButton() {

		navigateBack();
	}

	public boolean isReadingLayoutPresent() {

		clickOnElement(ReadingLayout);

		return isElementPresent(ReadingLayout);

	}

	public boolean isBookmarkPanelHeaderPresent() {
		wait(Until.elementsToBePresent(Bookmarkheader));

		return isElementPresent(Bookmarkheader);
	}

	public boolean isBookmarkPanelEmptyPresent() {

		return isElementPresent(Bookmarksempty);
	}

	public boolean isBookmarkPanelPageIndexPresent() {
		wait(Until.elementsToBePresent(PageIndex));

		return isElementPresent(PageIndex);
	}

	public boolean isBookmarkDescriptionPresent() {

		return isElementPresent(BookmarkDescription);
	}

	public boolean isBookmarkPanelDeleteIconPresent() {

		return isElementPresent(HighlightDelete);
	}

	public List<String> BookmarksPanelList() {

		return getTextOfSimilarElements(PageIndex);

	}

	public void tapPageIndex() {

		tapElement(PageIndex);

	}

	public int getBookmarksCount() {

		System.out.println("ALL Bookmarkslist Sting " + allbookmarks);
		int AllBookmarksBeforeDeleteCount1 = getListSize(allbookmarks);
		System.out.println("Checking Before Delete the bookmarks" + AllBookmarksBeforeDeleteCount1);
		return AllBookmarksBeforeDeleteCount1;

	}

	public void tapOnBookmarksPanel(int index) {

		String bookmarksPanelIndex = BookmarksPanelbyIndex.replace("index", Integer.toString(index));

		tapElement(bookmarksPanelIndex);

		log.info(bookmarksPanelIndex);

	}

	public void bookMarkPanelDelete() {
		tapElement(HighlightDelete);

	}

}
