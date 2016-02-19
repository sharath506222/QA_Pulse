package com.pulselms.app.screen;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

public class MyNotesScreen extends AppiumBase {

	private static String MyBookShelfTab = ObjectLocators.getLocator("MyBookShelfTab");
	private static String MyNotesTab = ObjectLocators.getLocator("MyNotesTab");
	private static String SearchButton = ObjectLocators.getLocator("SearchButton");
	private static String SignOut = ObjectLocators.getLocator("SignOut");
	private static String MyNotesLayout = ObjectLocators.getLocator("MyNotesLayout");
	private static String BookShelfLayout = ObjectLocators.getLocator("BookShelfLayout");
	private static String BookOverlay = ObjectLocators.getLocator("BookOverlay");
	private static String CloudDownArrowIcon = ObjectLocators.getLocator("CloudDownArrowIcon");
	private static String BookList = ObjectLocators.getLocator("BookList");
	private static String MyNotesList = ObjectLocators.getLocator("MyNotesList");
	private static String VersionNumber = ObjectLocators.getLocator("VersionNumber");
	private static String DownloadingIcon = ObjectLocators.getLocator("DownloadingIcon");
	private static String PausedIcon = ObjectLocators.getLocator("PausedIcon");
	private static String QueuedIcon = ObjectLocators.getLocator("QueuedIcon");
//	private static String BookByIndex = ObjectLocators.getLocator("BookByIndex");
	private static String MyNotesbyIndex = ObjectLocators.getLocator("MyNotesbyIndex");
	private static String PageIndex = ObjectLocators.getLocator("PageIndex");
	private static String Highlighted = ObjectLocators.getLocator("Highlighted");
	private static String Comments = ObjectLocators.getLocator("Comments");
	private static String MyNotesCancel = ObjectLocators.getLocator("MyNotesCancel");
	private static String MyNotesSave = ObjectLocators.getLocator("MyNotesSave");
	private static String MyNotesselectedBooks = ObjectLocators.getLocator("MyNotesselectedBooks");
	private static String MyNotesSelectedNotes = ObjectLocators.getLocator("MyNotesSelectedNotes");
	private static String AllNotesCount= ObjectLocators.getLocator("AllNotesCount");
	private static String AllNotes= ObjectLocators.getLocator("AllNotes");

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

	public boolean isMyNotesSelectedbooksPresent() {

		if (isElementPresent(MyNotesselectedBooks))
			return true;
		else
			return false;
	}

	public boolean isMyNotesSelectedNotesPresent() {

		if (isElementPresent(MyNotesSelectedNotes))
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

	public boolean ispageIndexPresent() {

		return isElementPresent(PageIndex);
	}

	public boolean isHighlightedPresent() {

		return isElementPresent(Highlighted);
	}

	public boolean isCommentsPresent() {

		return isElementPresent(Comments);
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
	public int getNumberOfMyNotesBooks() {
		return getListSize(MyNotesList);
	}

	public List<String> getBookList() {

		return getTextOfSimilarElements(BookList);

	}
public List<String> getMyNotesList() {
		
		return getTextOfSimilarElements(MyNotesList);
		
	}
	/*
	 * public boolean isNotewindowPresent() { return
	 * isElementVisible(propKey)(SignOut); }
	 */

	public void navigateBackToMyNotes() {
		clickOnElement(MyNotesTab);
		wait(Until.elementsToBePresent(MyNotesLayout));
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

	public boolean isDownloadingIconPresentForAllBooks() {

		boolean flag = false;
		List<WebElement> bookOverlayList = getSimilarElements(BookOverlay);
		for (WebElement element : bookOverlayList) {
			if (isElementPresentInElement(element, DownloadingIcon))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public boolean isPausedIconPresentForAllBooks() {

		boolean flag = false;
		List<WebElement> bookOverlayList = getSimilarElements(BookOverlay);
		for (WebElement element : bookOverlayList) {
			if (isElementPresentInElement(element, PausedIcon))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public boolean isQueuedDownArrowIconPresentForAllBooks() {

		boolean flag = false;
		List<WebElement> bookOverlayList = getSimilarElements(BookOverlay);
		for (WebElement element : bookOverlayList) {
			if (isElementPresentInElement(element, QueuedIcon))
				flag = true;
			else {
				flag = false;
				break;
			}
		}
		return flag;

	}

	public void NavigateMyNotes() {
		clickOnElement(MyNotesTab);
		wait(Until.elementsToBePresent(MyNotesLayout));

		
	}
	/*
	 * public boolean isAlertPresent(){ try{ driver.switchTo().alert(); return
	 * true; }//try catch(Exception e){ return false; }//catch }
	 */

	public void tapOnNote(int index) {

		String myNotesbyIndex = MyNotesbyIndex.replace("index", Integer.toString(index));
	
		tapElement(myNotesbyIndex);

		
		log.info(myNotesbyIndex);

	}
	
	
	
	public String getNoteText(int index) {
		String myNotesbyIndex = MyNotesbyIndex.replace("index", Integer.toString(index));
		return getTextWithInElement(findElement(myNotesbyIndex), Comments);
		
	}

	public boolean getProgressHighlighted(int index) {

		MyNotesbyIndex = MyNotesbyIndex.replace("index", Integer.toString(index));
		
		return isElementPresentInElement(findElement(MyNotesbyIndex), Highlighted);
	}

	public boolean getProgressPageIndex(int index) {

		MyNotesbyIndex = MyNotesbyIndex.replace("index", Integer.toString(index));
		
		return isElementPresentInElement(findElement(MyNotesbyIndex), PageIndex);
	}

	public boolean getProgressComments(int index) {

		MyNotesbyIndex = MyNotesbyIndex.replace("index", Integer.toString(index));
		
		return isElementPresentInElement(findElement(MyNotesbyIndex), Comments);
	}
	
	public int getNotesCount(){
	//int AllNotesCount1=0;
		
	// int  AllNotesCount1= Integer.parseInt(AllNotesCount);
		 System.out.println("ALL NOTES Sting "+AllNotes);
	 int  AllNotesBeforeDeleteCount1=getListSize(AllNotes);
	 System.out.println("Checking Before Delete the Notes"+AllNotesBeforeDeleteCount1);
	 return AllNotesBeforeDeleteCount1;
	
	}
	public void MyNotesDeleteAftercounts(){
		//int AllNotesCount1=0;
			
		// int  AllNotesCount1= Integer.parseInt(AllNotesCount);
		 int  AllNotesAfterDeleteCount1=AllNotesCount.length();
		 System.out.println("Checking After delete Notes"+AllNotesAfterDeleteCount1);
		
		}

	public void MyNotesCancel() {

		/*
		 * if (isElementPresent(TestFairy_PrivacyPolicy)) {
		 */
		clickOnElement(MyNotesCancel);
		wait(Until.elementToBeInvisible(MyNotesCancel));
		// }
	}

	public void MyNotesSave(String text) {
		tapElement(Highlighted);
		
		driver.findElement(By.id("com.pearson.android.readerplus.dev:id/note_edit")).clear();
		WebElement save = driver.findElement(By.id("com.pearson.android.readerplus.dev:id/note_edit"));
		save.sendKeys(text);
		driver.findElement(By.id("com.pearson.android.readerplus.dev:id/save_text")).click();
		
	}

	public void MyNotesDelete() {
		tapElement(Highlighted);
		
		driver.findElement(By.id("com.pearson.android.readerplus.dev:id/delete_image")).click();
		
	}
	
	
	public boolean isMyNotesSavePresent() {

		if (isElementPresent(MyNotesSave))
			return true;
		else
			return false;
	}

	public void MyNoteBackbutton() {
		tapElement(Highlighted);

		
		driver.navigate().back();
		driver.navigate().back();
		
	}
	
}