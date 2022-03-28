package com.common.core.framework.base;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.common.core.framework.driver.DriverFactory;
import com.commoon.core.framework.web.utils.ElementActions;
import com.commoon.core.framework.web.utils.URLAction;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

/**
 * @author umangkumar
 *
 */
public class BasePage extends DriverFactory {

	public RemoteWebDriver driver;
	public ElementActions elementActions;
	private static final Logger logger=Logger.getLogger(BasePage.class);
	
	/*
	 * Below constructor checks whether driver is already initialized, if not it
	 * will create and initialize
	 */
	public BasePage(RemoteWebDriver driver) {

		if (driver == null) {
			try {
				this.driver = new DriverFactory().setWebDriverManager();
				logger.info("Driver is null and initializing it in BasePage class");
				elementActions = new ElementActions(this.driver);
				logger.debug("Initializing driver in BasePage");
				this.driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				URLAction urlAction = new URLAction();
				urlAction.launchUrl(this.driver);
				driver=this.driver;
				elementActions.waitForPageLoad();
			} catch (IOException e) {
				e.printStackTrace();
			}

		} else {
			this.driver = driver;
			logger.info("Driver is not null and it is in BasePage class");
			elementActions = new ElementActions(driver);
		}
		
	}

}
