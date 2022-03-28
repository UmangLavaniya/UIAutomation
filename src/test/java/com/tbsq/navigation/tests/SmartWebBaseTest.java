package com.tbsq.navigation.tests;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.common.core.framework.base.BaseTest;

/**
 * @author umangkumar
 *
 */
public class SmartWebBaseTest extends BaseTest{
	
	private static final Logger logger=Logger.getLogger(SmartWebBaseTest.class);
	
	@BeforeMethod(alwaysRun = true)
	public void beforeTestMethod(Method method) {
		logger.info((Thread.currentThread() + " Start method " + method.getName()));
	}
	
	@AfterMethod(alwaysRun = true)
	public void afterTestMethod(Method method) {
		logger.info((Thread.currentThread() + " Finish method " + method.getName()));
	}
}
