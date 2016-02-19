package com.pulselms.base.test;

import java.net.MalformedURLException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.pulselms.app.framework.MobileBase;
import com.pulselms.app.framework.PageFactory;
import com.pulselms.app.screen.TestFairyScreen;

/**
 * This is Mobile Base Test for all Mobile Test classes that has pre and post test
 * configuration for Appium
 * 
 * @author Cognizant
 * 
 */
public class MobileBaseTest extends MobileBase {

	protected static String username="automation.student@qa.com";
	protected static String password="hudson102";
	protected static final Logger log = Logger.getLogger(MobileBaseTest.class);

	@BeforeClass
	public void setUp() {
		selectAppPackageDetails();
	}

	@BeforeMethod
	public void setUpMethod() throws MalformedURLException {

		setUpAppium();
		
	}

	@AfterMethod
	public void tearDown() {
		driver.closeApp();
		driver.quit();
	}


	public void handleTestFairySecutiryPopup() {
		log.info("Checking for TestFairy Security Popup");
		TestFairyScreen testFairyScreen = PageFactory.instantiatePage(driver,
				TestFairyScreen.class);
		testFairyScreen.closeTestFairyPrivacyPolicy();
	}

}
