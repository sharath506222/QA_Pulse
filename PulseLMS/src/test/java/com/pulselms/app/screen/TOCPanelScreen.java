package com.pulselms.app.screen;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

public class TOCPanelScreen extends AppiumBase {

	private static String TOCHeader = ObjectLocators.getLocator("TOCHeader");
	private static String TOCPanel = ObjectLocators.getLocator("RightPanel");
	private static String TOCSection = ObjectLocators.getLocator("TOCSection");
	private static String SectionTopic = ObjectLocators.getLocator("SectionTopic");
	private static String SectionPageNumber = ObjectLocators.getLocator("SectionPageNumber");
	private static String TOCIcon = ObjectLocators.getLocator("TOCIcon");
	private static String TOCList = ObjectLocators.getLocator("TOCList");

	public void waitForTOCScreenToLoad() {

		wait(Until.elementsToBePresent(TOCHeader));
	}

	public boolean isTOCPanelPresent() {

		return isElementPresent(TOCPanel);
	}

	public boolean isTOCIconPresent() {

		return isElementPresent(TOCIcon);
	}

	public void tapOnTOCSection(int index) {

		String TOCSectionByIndex = TOCSection.replace("index", Integer.toString(index));
		tapElement(TOCSectionByIndex);
		wait(Until.elementToBeInvisible(TOCPanel));
	}

	public String getSectionTopic(int index) {

		String TOCSectionByIndex = TOCSection.replace("index", Integer.toString(index));
		return getTextWithInElement(findElement(TOCSectionByIndex), SectionTopic);
	}

	public int getSectionPageNumber(int index) {

		String TOCSectionByIndex = TOCSection.replace("index", Integer.toString(index));
		return Integer.parseInt(getTextWithInElement(findElement(TOCSectionByIndex), SectionPageNumber));
	}

	// Added for TOC
	public void tapTOC() {

		clickOnElement(TOCIcon);
		wait(Until.elementsToBePresent(TOCHeader));
	}

	public void TOCReadingPage() {

		clickOnElement(TOCSection);

	}

	public boolean isTOCListPresent() {

		return isElementPresent(TOCList);

	}

	public boolean isTOCHeaderPresent() {

		return isElementPresent(TOCHeader);

	}

	public void getHighlightDisplay(int index) {

		String TOCSectionByIndex = TOCHeader.replace("index", Integer.toString(index));
		driver.findElementByXPath(TOCSectionByIndex).getCssValue("color");

	}

	public void enableTopOptionBars() {

		clickOnElement(TOCIcon);

	}

}
