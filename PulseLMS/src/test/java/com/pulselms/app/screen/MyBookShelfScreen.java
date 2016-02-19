package com.pulselms.app.screen;

import io.appium.java_client.MobileElement;
import io.appium.java_client.SwipeElementDirection;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

/**
 * Screen Class which represents the My BookShelf Screen
 * 
 * @author Cognizant
 * 
 */

public class MyBookShelfScreen extends AppiumBase {

	private static String MyBookShelfTab = ObjectLocators
			.getLocator("MyBookShelfTab");
	private static String MyNotesTab = ObjectLocators.getLocator("MyNotesTab");
	private static String SearchButton = ObjectLocators
			.getLocator("SearchButton");
	private static String SignOut = ObjectLocators.getLocator("SignOut");
	private static String BookShelfLayout = ObjectLocators
			.getLocator("BookShelfLayout");
	private static String BookOverlay = ObjectLocators
			.getLocator("BookOverlay");
	private static String CloudDownArrowIcon = ObjectLocators
			.getLocator("CloudDownArrowIcon");
	private static String BookList = ObjectLocators.getLocator("BookList");
	private static String VersionNumber = ObjectLocators
			.getLocator("VersionNumber");
	private static String BookByIndex = ObjectLocators
			.getLocator("BookByIndex");
	private static String ProgressIndicator = ObjectLocators
			.getLocator("ProgressIndicator");
	private static String ProgressText = ObjectLocators
			.getLocator("ProgressText");
	private static String NewLabel = ObjectLocators.getLocator("NewLabel");
	private static String ShadeIcon = ObjectLocators.getLocator("ShadeIcon");
	private static String PreparedStatus = ObjectLocators
			.getLocator("PreparedStatus");
	private static String IndexedStatus = ObjectLocators
			.getLocator("IndexedStatus");

	public void goToMyNotes() {

		clickOnElement(MyNotesTab);
	}

	public void navigateBackToMyBookShelf() {
		clickOnElement(MyBookShelfTab);
		wait(Until.elementsToBePresent(BookShelfLayout));
	}

	public boolean isMyBookShelfTabPresent() {

		if (isElementPresent(MyBookShelfTab))
			return true;
		else
			return false;
	}

	public void signOut() {

		clickOnElement(SignOut);
		wait(Until.elementToBeInvisible(SignOut));
	}

	public boolean isSignOutNotPresent() {

		if (isElementChecked(SignOut))
			return false;
		else
			return true;
	}

	public boolean isBookShelfLayoutPresent() {

		return isElementPresent(BookShelfLayout);
	}

	public boolean isMyNotesTabPresent() {
		return isElementPresent(MyNotesTab);
	}

	public boolean isSerachButtonPresent() {
		return isElementPresent(SearchButton);
	}

	public boolean isSignOutLinkPresent() {
		return isElementPresent(SignOut);
	}

	public boolean isVersionNumberPresent() {

		return isElementPresent(VersionNumber);

	}

	public int getNumberOfBooks() {
		return getListSize(BookList);
	}

	public List<String> getBookList() {

		return getTextOfSimilarElements(BookList);

	}

	public void scrollBookShelf() {

		MobileElement bookOverlay = (MobileElement) driver
				.findElement(By
						.xpath("//android.widget.GridView/android.widget.LinearLayout/android.widget.FrameLayout"));
		bookOverlay.swipe(SwipeElementDirection.DOWN, 200);
		bookOverlay.swipe(SwipeElementDirection.UP, 200);

	}

	public void tapOnBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		tapElement(bookByIndex);
		log.info(bookByIndex);

	}

	public void waitForBookDownload(int index) {

		while (isProgressIndicatorPresentInBook(index)) {

		}

	}

	public boolean isProgressIndicatorPresentInBook(int index) {
		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex),
				ProgressIndicator);
	}

	public boolean isProgressTextPresentInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex), ProgressText);

	}

	public boolean isNewLabelPresentInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex), NewLabel);
	}

	public boolean isShadedIconPresentInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex), ShadeIcon);
	}

	public String getProgressTextInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return getTextWithInElement(findElement(bookByIndex), ProgressText);
	}

	public String getNewLabelTextInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return getTextWithInElement(findElement(bookByIndex), NewLabel);

	}

	public boolean isCloudDownArrowIconPresentForAllBooks() {

		boolean flag = false;
		List<WebElement> bookOverlayList = getSimilarElements(BookOverlay);
		for (WebElement element : bookOverlayList) {
			if (isElementPresentInElement(element, CloudDownArrowIcon))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public boolean isOnCloudNotIndexBookStatusTextPresentInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex),
				IndexedStatus);

	}

	public boolean isPreparedStatusTextPresentInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return isElementPresentInElement(findElement(bookByIndex),
				PreparedStatus);

	}

	public String getPreparedBookStatusTextInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return getTextWithInElement(findElement(bookByIndex), PreparedStatus);
	}

	public String getProgressIndexdedBookStatusTextInBook(int index) {

		String bookByIndex = BookByIndex.replace("index",
				Integer.toString(index));
		return getTextWithInElement(findElement(bookByIndex), IndexedStatus);
	}

	public void waitForBookExtractionProcess(int index) {

		while (getPreparedBookStatusTextInBook(index).contains("extracting")) {

		}

	}

	public void waitForBookIndexingProcess(int index) {

		while (getProgressIndexdedBookStatusTextInBook(index).contains(
				"indexing")) {

		}

	}
	public String getFirstNameLastNamefText() {

		String firstLastName = driver.findElement(By.id("com.pearson.android.readerplus.dev:id/logout")).getText();
		
		return firstLastName;
	}

}
