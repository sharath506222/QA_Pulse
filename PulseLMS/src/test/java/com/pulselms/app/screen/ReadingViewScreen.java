package com.pulselms.app.screen;

import java.util.HashMap;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

public class ReadingViewScreen extends AppiumBase {
	
	private static String LoadingIcon = ObjectLocators.getLocator("LoadingIcon");
	private static String PreparingText = ObjectLocators.getLocator("PreparingText");
	private static String ProgressBarPageNumber = ObjectLocators.getLocator("ProgressBarPageNumber");
	private static String TopOptionBar = ObjectLocators.getLocator("TopOptionBar");
	private static String BottomOptionBar = ObjectLocators.getLocator("BottomOptionBar");
	private static String ReadingLayout = ObjectLocators.getLocator("ReadingLayout");
	private static String TransientScrollOverlay = ObjectLocators.getLocator("TransientScrollOverlay");
	private static String SearchIcon = ObjectLocators.getLocator("SearchIcon");
	private static String SettingsIcon = ObjectLocators.getLocator("SettingsIcon");
	private static String NotesIcon = ObjectLocators.getLocator("NotesIcon");
	private static String BookmarkIcon = ObjectLocators.getLocator("BookmarkIcon");
	private static String TOCIcon = ObjectLocators.getLocator("TOCIcon");
	private static String ProgressBar = ObjectLocators.getLocator("ProgressBar");
	private static String PageNumber = ObjectLocators.getLocator("PageNumber");
	private static String LeftPageNumber = ObjectLocators.getLocator("LeftPageNumber");
	private static String RightPageNumber = ObjectLocators.getLocator("RightPageNumber");
	private static String BookmarkImage = ObjectLocators.getLocator("BookmarkImage");
	private static String BookemarkImageLeft = ObjectLocators.getLocator("BookemarkImageLeft");
	private static String HighlightIcon=ObjectLocators.getLocator("HighlightIcon");
	
	public void waitForReadingViewScreen() {
		
		wait(Until.elementsToBePresent(LoadingIcon));
	}
	
	public void waitForPageToLoad() {
		wait(Until.elementToBeInvisible(LoadingIcon));
	}
	
	public void waitForBookPagesToLoad() {
		
		wait(Until.elementsToBePresent(ProgressBarPageNumber));
		String text=getText(ProgressBarPageNumber);
		int timeOut=0;
		while(timeOut<=60)
		{
			text=getText(ProgressBarPageNumber);
			sleep(1);
			timeOut++;
			if(text.contains("Page"))
			break;
		}
		
	}
	
	public void waitForOptionBarsToDisappear() {
		
		wait(Until.elementToBeInvisible(TopOptionBar));
		wait(Until.elementToBeInvisible(BottomOptionBar));
	}
	
	public boolean isLoadingIconPresent() {
		
		return isElementPresent(LoadingIcon);
	}
	
	public boolean isPreparingTextPresent() {
		
		return isElementPresent(PreparingText);
	}
	
	public String getPreparingText() {
		
		return getText(PreparingText);
	}
	
	public void navigateBackToBookShelf() {
		
		pressBackButton();
		wait(Until.elementToBeInvisible(LoadingIcon));
		
	}
	
	public boolean isScrollOverlayPresent() {
		
		wait(Until.elementToBePresent(TransientScrollOverlay));
		return isElementPresent(TransientScrollOverlay);
	}
	
	public void enableOptionBars() {
		
		if (!(isElementVisible(BottomOptionBar))) {
			
			clickOnElement(ReadingLayout);
			sleep(2);
		}
		if (!(isElementVisible(BottomOptionBar))) {
			
			clickOnElement(ReadingLayout);
			sleep(2);
		}
	}
	
	public void disableOptionbars() {
		
		if (isElementVisible(BottomOptionBar)) {
			
			clickOnElement(ReadingLayout);
			sleep(2);
		}
		if (isElementVisible(BottomOptionBar)) {
			
			clickOnElement(ReadingLayout);
			sleep(2);
		}
	}
	
	public boolean isTopOptionBarPresent() {
		
		return isElementPresent(TopOptionBar);
		
	}
	
	public boolean isBottomOptionBarPresent() {
		
		return isElementPresent(BottomOptionBar);
	}
	
	public void tapOnTOCIcon() {
		
		clickOnElement(TOCIcon);
		wait(Until.elementToBeInvisible(TOCIcon));
	}
	
	public void tapOnNotesIcon() {
		
		clickOnElement(NotesIcon);
		wait(Until.elementToBeInvisible(NotesIcon));
		
	}
	
	public void tapOnBookmarkIcon() {
		
		clickOnElement(BookmarkIcon);
		wait(Until.elementToBeInvisible(BookmarkIcon));
		
	}
	public boolean isSearchIconPresent() {
		
		return isElementPresent(SearchIcon);
		
	}
	
	public boolean isSettingsIconPresent() {
		
		return isElementPresent(SettingsIcon);
	}
	
	public boolean isTOCIconPresent() {
		
		return isElementPresent(TOCIcon);
	}
	
	public boolean isNotesIconPresent() {
		
		return isElementPresent(NotesIcon);
	}
	
	public boolean isBookmarkIconPresent() {
		
		return isElementPresent(BookmarkIcon);
	}
	
	public boolean isProgressBarPresent() {
		
		return isElementPresent(ProgressBar);
	}
	public boolean isProgressBarIndicateTheValidPage(int pageNumber) {
		
		wait(Until.elementsToBePresent(ProgressBarPageNumber));
		String text=getText(ProgressBarPageNumber);
		if (text.contains("Page "+pageNumber+" of"))
			return true;
		else
			return false;
		
	}
	
	public void scrollProgressBar() {
		
		tapElement(ProgressBar, 500);
		tapElement(ProgressBar, 500);
	}
	
	public int getTotalPageNumber() {
		
		log.info(getText(ProgressBarPageNumber).split("\\s+")[0]);
		log.info(getText(ProgressBarPageNumber).split("\\s+")[1]);
		log.info(getText(ProgressBarPageNumber).split("\\s+")[2]);
		log.info(getText(ProgressBarPageNumber).split("\\s+")[3]);
		return Integer.parseInt(getText(ProgressBarPageNumber).split("\\s+")[3]); 
	}
	
	public int getCurrentPageNumber() {
		
		enableOptionBars();
		return Integer.parseInt(getText(ProgressBarPageNumber).split("\\s+")[1]);
	}
	
	public boolean isPageNumberPresent() {
		
		return isElementPresent(PageNumber);
	}
	
	public boolean isLeftSidePageNumberPresent() {
		
		return isElementPresent(LeftPageNumber);
	}
	
	public boolean isRightSidePageNumberPresent() {
		
		return isElementPresent(RightPageNumber);
	}
	
	public int getCurrentPageNumberInBook() {
		
		return Integer.parseInt(getAttribute(PageNumber,"name"));
	}
	
	public int getLeftSidePageNumberInBook() {
		
		return Integer.parseInt(getAttribute(LeftPageNumber,"name"));
	}
	
	public int getRightSidePageNumberInBook() {
		
		return Integer.parseInt(getAttribute(RightPageNumber,"name"));
	}
	
	public boolean isBookmarkImagePresent() {
		
		return isElementPresent(BookmarkImage);
	}
	
	public boolean isLeftSideBookmarkImagePresent() {
		
		return isElementPresent(BookemarkImageLeft);
	}
	
	public void swipeLeftToRight() {
		
		Dimension size=driver.manage().window().getSize();
		int endx = (int) (size.width * 0.8); 
		int startx = (int) (size.width * 0.20); 
		int starty = size.height / 2; 
		swipeAtPosition(startx, starty, endx, starty, 100);
		
	}
	
	public void swipeRightToLeft() {
		
		Dimension size=driver.manage().window().getSize();
		int startx = (int) (size.width * 0.20); 
		int endx = (int) (size.width * 0.80); 
		int starty = size.height / 2; 
		swipeAtPosition(startx, starty, endx, starty, 100);
	}
	
	public void swipeBottomToTop() { //x= 160 y=960 end-x=640 end-y=640
		
		Dimension size=driver.manage().window().getSize();
		int startx = (int) (size.width * 0.20); 
		int starty = (int) (size.height * 0.75); 
		int endy = size.height / 2; 
		swipeAtPosition(startx, starty, startx, endy, 100);
	}
	
	
public void swipeTopToBottom() { //x= 160 y=960 end-x=640 end-y=640
		
		Dimension size=driver.manage().window().getSize();
		int startx = (int) (size.width * 0.20); 
		int starty = (int) (size.height * 0.75); 
		int endy = size.height / 2; 
		swipeAtPosition(startx, endy, startx, starty, 100);
	}
	
	
	public void swipeReadingLayout() {
		
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    HashMap<String, Double> swipeObject = new HashMap<String, Double>();
		    swipeObject.put("startX", 0.95);
		    swipeObject.put("startY", 0.5);
		    swipeObject.put("endX", 0.05);
		    swipeObject.put("endY", 0.5);
		    swipeObject.put("duration", 1.8);
		    js.executeScript("mobile: swipe", swipeObject);
	
	}
	
	public void swicthToWebView() {
		switchToWebView();
	}
	
	public void takeHighLight() {
		
		WebElement element=findElementWithText("tagname;p","Glossary");
		Point point = element.getLocation();
		Dimension size = element.getSize();
		int x= point.getX() + Math.round(size.getWidth() / 2);
		int y = point.getY() + Math.round(size.getHeight() / 2);
		driver.context("NATIVE_APP");
		tapPostion(x, y, 4);
		wait(Until.elementsToBeDisplayed(HighlightIcon));
		tapElement(HighlightIcon);
		wait(Until.elementToBeInvisible(HighlightIcon));
		
	}


}
 