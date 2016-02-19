package com.pulselms.app.framework;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	// Set this to twice the number of times to retry
		private int remainingRetries = EnvParameters.RETRY_ATTEMPT * 2;

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.testng.IRetryAnalyzer#retry(org.testng.ITestResult)
		 */
		@Override
		public boolean retry(ITestResult result) {
			if (remainingRetries > 0) {
				result.setStatus(ITestResult.SUCCESS_PERCENTAGE_FAILURE);
				remainingRetries = remainingRetries - 1;
				return true;
			} else {
				return false;
			}
		}
	}
