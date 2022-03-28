package com.common.core.framework.base;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

/**
 * @author umangkumar
 *
 */
public class BaseTest {

	private long testExecutionStartTime;
	public RemoteWebDriver driver;

	static final Logger logger = Logger.getLogger(BaseTest.class);

	/*
	 * Below method will kill driver
	 */
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	/*
	 * Below method called after test suite complete 1. It calls tear down method to
	 * kill if any browsers exist 2. It calculates the time taken for test suite to
	 * complete
	 */
	@AfterTest(alwaysRun = true)
	public void afterTestSuite() {
		tearDown();
		long executionTime = System.currentTimeMillis() - testExecutionStartTime;
		if (executionTime > 0) {
			logger.info("Test Suite Execution Time: " + (executionTime) / 1000 / 60 + " minutes.");
		}

	}

	/*
	 * Below method will get execute before test suite starts 1. Initialize the test
	 * execution starts time
	 */
	@BeforeSuite(alwaysRun = true)
	public void beforeTestSuite(ITestContext testContex) {
		testExecutionStartTime = System.currentTimeMillis();
	}

}
