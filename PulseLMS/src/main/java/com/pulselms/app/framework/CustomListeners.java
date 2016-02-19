package com.pulselms.app.framework;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_AVI;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.IInvokedMethod;
import org.testng.IResultMap;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.Utils;

/**
 * This class is representing the TestNG Listener and we can override the
 * methods which gets invoked before and after the tests get executed by TestNG
 * 
 * @author Cognizant
 * 
 */
public class CustomListeners implements ITestListener {

	private static final String ESCAPE_PROPERTY = "org.uncommons.reportng.escape-output";
	private static ScreenRecorder recorder = null;
	int retryCount = EnvParameters.RETRY_ATTEMPT;
	public static String testResultVideos = "";
	private String testRoot = EnvParameters.TEST_ROOT_DIR;
	public String sFilename;

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {

		recorder = null;
		removeIncorrectlyFailedTests(context);
	}

	public void onStart(ITestContext context) {

		System.setProperty(ESCAPE_PROPERTY, "false"); // set this for TESTNG
		for (ITestNGMethod testMethod : context.getAllTestMethods()) {
			testMethod.setRetryAnalyzer(new RetryAnalyzer());
		}
		recorder = null;
	}

	public void onTestFailure(ITestResult result) {

		String sTestMethodName = result.getMethod().getMethodName();
		String sTestSuiteName = result.getTestClass().getRealClass()
				.getSimpleName();
		String timeTaken = Long.toString((result.getEndMillis() - result
				.getStartMillis()) / 1000);
		String testName = result.getTestClass().getName() + "."
				+ result.getMethod().getMethodName();
		LoggerUtil.log("<<<*** END: " + sTestSuiteName + "." + sTestMethodName
				+ " ***>>> ");
		LoggerUtil
				.log("=====================================================================================");
		LoggerUtil.log("Test Failed :" + testName + ", Took " + timeTaken
				+ " seconds");
		if (EnvParameters.CAPTURE_VIDEO) {
			try {
				if (recorder != null)
					recorder.stop();
			} catch (Exception e) {
				throw new BrowserBotException("Error with video recording "
						+ e.getMessage());
			}
			File videoFile = WebUtils.lastFileModified(testResultVideos);
			File oldName = new File(videoFile.getAbsolutePath());
			File newName = new File(testResultVideos + File.separator
					+ sTestMethodName + ".avi");
			WebUtils.renameFile(oldName, newName);
		}
		if (result.getMethod().getRetryAnalyzer().retry(result)) {
			LoggerUtil.log("Retrying test : " + testName + ", " + retryCount
					+ " time(s)");
			Reporter.log("Retrying test : '" + testName + "', " + retryCount
					+ " time(s)");
			result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
			retryCount++;
		} else {
			Reporter.log("Test failed after max allowed retries  : " + testName);
		}
		if (EnvParameters.CAPTURE_SCREENSHOT) {
			takeScreenShot(sTestMethodName);
			Reporter.log("<a href='../../screenshots/"
					+ result.getMethod().getMethodName()
					+ ".png'><img src='../../screenshots/"
					+ result.getMethod().getMethodName()
					+ ".png' height='100' width='100'/><br></a>");
		}
		if (EnvParameters.CAPTURE_VIDEO) {

			try {
				if (recorder != null)
					recorder.stop();
			} catch (Exception e) {
				throw new BrowserBotException("Error with video recording "
						+ e.getMessage());
			}
			File videoFile = WebUtils.lastFileModified(testResultVideos);
			System.out.println(videoFile.getName());
			File oldName = new File(videoFile.getAbsolutePath());
			File newName = new File(testResultVideos + File.separator
					+ sTestMethodName + ".avi");
			WebUtils.renameFile(oldName, newName);
			Reporter.log("<a href='../../videos/"
					+ result.getMethod().getMethodName()
					+ ".avi'><img src='../../../media/video_icon.png' height='100' width='100'/><br></a>");
		}

	}

	public void onTestSkipped(ITestResult iTestResult) {
		String timeTaken = Long
				.toString((iTestResult.getEndMillis() - iTestResult
						.getStartMillis()) / 1000);
		String testName = iTestResult.getTestClass().getName() + "."
				+ iTestResult.getMethod().getMethodName();
		LoggerUtil
				.log("/////////////////////////////////////////////////////////////////////////////////////////");
		LoggerUtil.log("Test Skipped :" + testName + ", Took " + timeTaken
				+ " seconds");

		try {
			if (recorder != null)
				recorder.stop();
			// String sFilename = testResultVideos + File.separator+
			// sTestSuiteName + "." + sTestMethodName + ".avi";
			File videofile = WebUtils.lastFileModified(testResultVideos);
			// Delete the video file on test pass because we don't need it any
			// more :)

			if (videofile.exists()) {
				videofile.delete();
			}

		} catch (Exception e) {
			throw new BrowserBotException("Error with video recording "
					+ e.getMessage());
		}

	}

	public void onTestStart(ITestResult iTestResult) {

		String sTestMethodName = iTestResult.getMethod().getMethodName();
		String sTestSuiteName = iTestResult.getTestClass().getRealClass()
				.getSimpleName();
		LoggerUtil
				.log("===============================================================================================");
		LoggerUtil.log("<<<*** START: " + sTestSuiteName + "."
				+ sTestMethodName + " ***>>> ");
		testResultVideos = testRoot + File.separator + "target"
				+ File.separator + "videos";
		WebUtils.createFolder(testResultVideos);
		if (EnvParameters.CAPTURE_VIDEO) {
			File videofile = new File(testResultVideos + File.separator
					+ sTestMethodName + ".avi");
			if (videofile.exists()) {
				videofile.delete();
			}

			try {
				startRecording();
			} catch (Exception e) {
				throw new BrowserBotException(
						"Error starting with video recording " + e.getMessage());
			}
		}
	}

	public void onTestSuccess(ITestResult iTestResult) {
		String sTestMethodName = iTestResult.getMethod().getMethodName();
		String sTestSuiteName = iTestResult.getTestClass().getRealClass()
				.getSimpleName();
		String timeTaken = Long
				.toString((iTestResult.getEndMillis() - iTestResult
						.getStartMillis()) / 1000);
		String testName = iTestResult.getTestClass().getName() + "."
				+ iTestResult.getMethod().getMethodName();

		LoggerUtil.log("<<<*** END: " + sTestSuiteName + "." + sTestMethodName
				+ " ***>>> ");
		LoggerUtil
				.log("=====================================================================================");
		LoggerUtil.log("Test Passed :" + testName + ", Took " + timeTaken
				+ " seconds");
		if (EnvParameters.CAPTURE_VIDEO) {
			try {
				if (recorder != null)
					recorder.stop();
				// String sFilename = testResultVideos + File.separator+
				// sTestSuiteName + "." + sTestMethodName + ".avi";
				File videofile = WebUtils.lastFileModified(testResultVideos);
				// Delete the video file on test pass because we don't need it
				// any
				// more :)

				if (videofile.exists()) {
					videofile.delete();
				}

			} catch (Exception e) {
				throw new BrowserBotException(
						"Error starting with video recording " + e.getMessage());
			}
		}

	}

	private static void startRecording() throws Exception {

		try {
			GraphicsConfiguration gc = GraphicsEnvironment
					.getLocalGraphicsEnvironment().getDefaultScreenDevice()
					.getDefaultConfiguration();

			recorder = new ScreenRecorder(gc, gc.getBounds(), new Format(
					MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
					new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
							CompressorNameKey,
							ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE, DepthKey,
							24, FrameRateKey, Rational.valueOf(15), QualityKey,
							1.0f, KeyFrameIntervalKey, 15 * 60), new Format(
							MediaTypeKey, MediaType.VIDEO, EncodingKey,
							"black", FrameRateKey, Rational.valueOf(30)), null,
					new File(testResultVideos));
			recorder.start();
		} catch (Exception e) {
			// to-do
		}
	}

	public void takeScreenShot(String methodName) {
		// get the driver
		WebDriver driver = WebDriverBase.getDriver();
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot in d drive with test
		// method name
		try {
			FileUtils.copyFile(scrFile, new File("target" + File.separator
					+ "screenshots" + File.separator + methodName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// @Override
	public void afterInvocation(IInvokedMethod method, ITestResult result) {
		Reporter.setCurrentTestResult(result);

		if (method.isTestMethod()) {

			List<Throwable> verificationFailures = VerifySafe
					.getVerificationFailures();
			// if there are verification failures...
			if (verificationFailures.size() > 0) {
				// set the test to failed
				result.setStatus(ITestResult.FAILURE);

				// if there is an assertion failure add it to
				// verificationFailures
				if (result.getThrowable() != null) {
					verificationFailures.add(result.getThrowable());
				}

				int size = verificationFailures.size();
				// if there's only one failure just set that
				if (size == 1) {
					result.setThrowable(verificationFailures.get(0));
				} else {
					// create a failure message with all failures and stack
					// traces (except last failure)
					StringBuffer failureMessage = new StringBuffer(
							"Multiple failures (").append(size)
							.append("):\n\n");
					for (int i = 0; i < size; i++) {
						failureMessage.append("Failure ").append(i + 1)
								.append(" of ").append(size).append(":\n");
						Throwable t = verificationFailures.get(i);
						String errorMessage = null;
						errorMessage = Utils.stackTrace(t, false)[1];
						failureMessage.append(errorMessage).append("\n\n");
					}

					Throwable merged = new Throwable(failureMessage.toString());
					//

					result.setThrowable(merged);
				}
			}
		}
	}

	private IResultMap removeIncorrectlyFailedTests(ITestContext test) {
		List<ITestNGMethod> failsToRemove = new ArrayList<ITestNGMethod>();
		IResultMap returnValue = test.getFailedTests();
		for (ITestResult result : test.getFailedTests().getAllResults()) {
			long failedResultTime = result.getEndMillis();
			for (ITestResult resultToCheck : test
					.getFailedButWithinSuccessPercentageTests().getAllResults()) {
				if (failedResultTime == resultToCheck.getEndMillis()) {
					failsToRemove.add(resultToCheck.getMethod());
					break;
				}
			}
			for (ITestResult resultToCheck : test.getPassedTests()
					.getAllResults()) {
				if (failedResultTime == resultToCheck.getEndMillis()) {
					failsToRemove.add(resultToCheck.getMethod());
					break;
				}
			}
		}
		for (ITestNGMethod method : failsToRemove) {
			returnValue.removeResult(method);
		}
		return returnValue;
	}

}
