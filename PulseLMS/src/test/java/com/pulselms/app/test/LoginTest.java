package com.pulselms.app.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.LoginScreen;
import com.pulselms.app.screen.MyBookShelfScreen;
import com.pulselms.base.test.MobileBaseTest;

/**
 * Login Screen Test class which has test scenarios for Login module
 * 
 * @author Cognizant
 *
 */
public class LoginTest extends MobileBaseTest {

	
	@Test
	public void loginWithValidCredentialsTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
	}

	@Test
	public void loginScreenUIElementsCheckTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		Assert.assertEquals(loginScreen.isReaderPlusHeaderPresent(), true);
		// Assert.assertEquals(loginScreen.getReaderPlusHeaderText(),"Reader+");
		Assert.assertEquals(loginScreen.isUsernameTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isPasswordTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isSubmitButtonPresent(), true);
		Assert.assertEquals(loginScreen.isVersionNumberPresent(), true);
	}

	@Test
	public void loginScreenOrientationTest() {
		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.rotateDeviceToLandscape();
		Assert.assertEquals(loginScreen.isReaderPlusHeaderPresent(), true);
		Assert.assertEquals(loginScreen.isUsernameTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isPasswordTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isSubmitButtonPresent(), true);
		Assert.assertEquals(loginScreen.isVersionNumberPresent(), true);
		loginScreen.rotateDeviceToPortrait();
		Assert.assertEquals(loginScreen.isReaderPlusHeaderPresent(), true);
		Assert.assertEquals(loginScreen.isUsernameTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isPasswordTextFieldPresent(), true);
		Assert.assertEquals(loginScreen.isSubmitButtonPresent(), true);
		Assert.assertEquals(loginScreen.isVersionNumberPresent(), true);
	}

	@Test
	public void logoutTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		myBookShelfScreen.signOut();
		Assert.assertEquals(myBookShelfScreen.isSignOutNotPresent(), true);
	}

	@Test
	public void loginInOfflineModeTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.setWifiConnection(false);
		loginScreen.login(username, password);
		String actualErrorMsg = loginScreen.getOfflineLoginErrorMessage();
		loginScreen.setWifiConnection(true);
		Assert.assertTrue(actualErrorMsg.contains("Network not available"));
		Assert.assertTrue(actualErrorMsg.contains("Please check network and try again"));
	}

	@Test
	public void loginWithInvalidCredentialsTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("reader123@pearson.com", "hudson");
		Assert.assertEquals(loginScreen.getLoginErrorMessage(), "Invalid username and/or password");
	}

	@Test
	public void loginWithEmptyUsernameTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("", "hudson");
		Assert.assertEquals(loginScreen.getUsernameErrorMessage(), "Please enter your username");
	}

	@Test
	public void loginWithEmptyPasswordTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("reader123@pearson.com", "");
		Assert.assertEquals(loginScreen.getPasswordErrorMessage(), "Please enter your password");
	}

	// New Test cases
	@Test
	public void loginWithInvalidUsernameTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("reader123@pearson.com", "hudson102");
		Assert.assertEquals(loginScreen.getPasswordErrorMessage(), "Invalid username and/or password");
	}

	@Test
	public void loginWithInvalidPasswordTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("automation.student@qa.com", "hudson");
		Assert.assertEquals(loginScreen.getPasswordErrorMessage(), "Invalid username and/or password");
	}

	@Test
	public void loginWithResetPasswordEnterOldPasswordTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.login("test1.student@pearson.com", "hudson102");
		Assert.assertEquals(loginScreen.getPasswordErrorMessage(), "Invalid username and/or password");
	}

	// Need to implement for Webservices for Password reset
	@Test
	public void loginWithResetNewPasswordTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.login("test1.student@pearson.com", "hudson103");
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		Assert.assertEquals(myBookShelfScreen.isMyBookShelfTabPresent(), true);
	}

	@Test
	public void verifyFirstLastNameTest() {

		handleTestFairySecutiryPopup();
		LoginScreen loginScreen = PageFactory.instantiatePage(driver, LoginScreen.class);
		loginScreen.waitForLoginScreenToLoad();
		loginScreen.login(username, password);
		loginScreen.waitForLoginProcess();
		MyBookShelfScreen myBookShelfScreen = PageFactory.instantiatePage(driver, MyBookShelfScreen.class);
		String firstLastName = myBookShelfScreen.getFirstNameLastNamefText();

		Assert.assertTrue(firstLastName.contains("AUTOMATION STUDENT"));

	}

}
