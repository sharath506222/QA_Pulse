package com.pulselms.app.framework;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class MobileBase {

	protected static AppiumDriver<?> driver;
	protected static String AppPackage;
	protected static String AppActivity;
	protected static String AppWaitActivity;
	protected static File appDir;
	protected static File app;
	protected static final Logger log = Logger.getLogger(MobileBase.class);

	public void setUpAppium() throws MalformedURLException {

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("VERSION", EnvParameters.VERSION);
		cap.setCapability("deviceName", EnvParameters.DEVICE);
		cap.setCapability("platformName", EnvParameters.PLATFORM);

		if (EnvParameters.PLATFORM.equals("Android")) {
			cap.setCapability("noReset", "true");
			cap.setCapability("appPackage", AppPackage);
			cap.setCapability("appActivity", AppActivity);
			cap.setCapability("appWaitActivity", AppWaitActivity);
			if (EnvParameters.ENV.equals("QA")) {
				appDir = new File("build" + File.separator + "QA");
			} else if (EnvParameters.ENV.equals("STAGE")) {
				appDir = new File("build" + File.separator + "STAGE");
			} else if (EnvParameters.ENV.equals("PROD")) {
				appDir = new File("build" + File.separator + "PROD");
			} else {
				throw new BrowserBotException("Not a valid Environment");
			}
			app = new File(appDir, WebUtils.getFile(appDir.getAbsolutePath(), "apk"));
			cap.setCapability("app", app.getAbsolutePath());
			driver = new AndroidDriver<WebElement>(new URL(
					EnvParameters.APPIUM_SERVER), cap);
		}

		else if (EnvParameters.PLATFORM.equals("IOS")) {
			cap.setCapability("fullReset", "true");
			if (EnvParameters.ENV.equals("QA")) {
				appDir = new File("build" + File.separator + "QA");
			} else if (EnvParameters.ENV.equals("STAGE")) {
				appDir = new File("build" + File.separator + "STAGE");
			} else if (EnvParameters.ENV.equals("PROD")) {
				appDir = new File("build" + File.separator + "PROD");
			} else {
				throw new BrowserBotException("Not a valid Environment");
			}
			app = new File(appDir, WebUtils.getFile(appDir.getAbsolutePath(), "ipa"));
			cap.setCapability("app", app.getAbsolutePath());
			driver = new IOSDriver<WebElement>(new URL(
					EnvParameters.APPIUM_SERVER), cap);
		} else
			throw new BrowserBotException("Not a valid Platform");

	}

	@AfterMethod
	public void tearDown() {
		driver.closeApp();
		driver.quit();
	}

	protected void selectAppPackageDetails() {

		if (EnvParameters.PLATFORM.equals("Android")) {
			if (EnvParameters.ENV.equals("PROD")) {
				AppPackage = TestData.getData("PROD_AppPackage");
				AppActivity = TestData.getData("PROD_AppActivity");
				AppWaitActivity = TestData.getData("PROD_AppWaitActivity");

			} else if (EnvParameters.ENV.equals("QA")) {
				AppPackage = TestData.getData("QA_AppPackage");
				AppActivity = TestData.getData("QA_AppActivity");
				AppWaitActivity = TestData.getData("QA_AppWaitActivity");

			} else if (EnvParameters.ENV.equals("STAGE")) {
				AppPackage = TestData.getData("STG_AppPackage");
				AppActivity = TestData.getData("STG_AppActivity");
				AppWaitActivity = TestData.getData("STG_AppWaitActivity");

			} else
				throw new BrowserBotException("Not a valid Environment");
		}
	}

}
