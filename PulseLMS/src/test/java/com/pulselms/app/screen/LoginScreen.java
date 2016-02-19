package com.pulselms.app.screen;

import com.pulselms.app.framework.AppiumBase;
import com.pulselms.app.framework.ObjectLocators;
import com.pulselms.app.framework.Until;

/**
 * Screen Class which represents the Login Screen
 * @author Cognizant
 *
 */

public class LoginScreen extends AppiumBase {

	private static String ReaderPlusHeader = ObjectLocators.getLocator("ReaderPlusHeader");
	private static String Username = ObjectLocators.getLocator("Username");
	private static String Password = ObjectLocators.getLocator("Password");
	private static String Submit = ObjectLocators.getLocator("Submit");
	private static String LoginError = ObjectLocators.getLocator("LoginError");
	private static String VersionNumber = ObjectLocators.getLocator("VersionNumber");

	/*
	 * public LoginScreen(AppiumDriver<?> driver) { super(driver); }
	 */

	public void login(String user, String pass) {

		type(Username, user);
		type(Password, pass);
		clickOnElement(Submit);

	}
	
	public void waitForLoginScreenToLoad() {
		
		wait(Until.elementsToBeDisplayed(ReaderPlusHeader));
	}

	public void waitForLoginProcess() {

		wait(Until.elementToBeInvisible(Username));
	}

	public String getReaderPlusHeaderText() {
		
		return getText(ReaderPlusHeader);
	}
	
	public boolean isReaderPlusHeaderPresent() {

		if (isElementPresent(ReaderPlusHeader))
			return true;
		else
			return false;
	}

	public boolean isUsernameTextFieldPresent() {

		if (isElementPresent(Username))
			return true;
		else
			return false;
	}

	public boolean isPasswordTextFieldPresent() {

		if (isElementPresent(Password))
			return true;
		else
			return false;
	}

	public boolean isSubmitButtonPresent() {

		if (isElementPresent(Submit))
			return true;
		else
			return false;
	}

	public boolean isVersionNumberPresent() {

		if (isElementPresent(VersionNumber))
			return true;
		else
			return false;
	}

	public String getLoginErrorMessage() {

		wait(Until.textToBePresentInElement(LoginError, "username"));
		return getText(LoginError).trim();
	}

	public String getUsernameErrorMessage() {

		wait(Until.textToBePresentInElement(LoginError, "username"));
		return getText(LoginError).trim();
	}

	public String getPasswordErrorMessage() {

		wait(Until.textToBePresentInElement(LoginError, "password"));
		return getText(LoginError).trim();
	}

	public String getOfflineLoginErrorMessage() {

		wait(Until.textToBePresentInElement(LoginError, "Network"));
		return getText(LoginError).trim();
	}

}
