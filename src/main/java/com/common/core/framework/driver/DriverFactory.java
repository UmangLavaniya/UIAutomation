package com.common.core.framework.driver;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.common.core.framework.constants.Constant;
import com.common.core.framework.exception.AutomationException;
import com.common.core.framework.utils.FileUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author umangkumar
 *
 */
public class DriverFactory {

	final static Logger logger= Logger.getLogger(DriverFactory.class);
	private OptionsManager optionsManager = new OptionsManager();
	private static ThreadLocal<RemoteWebDriver> tlDriver = new ThreadLocal<RemoteWebDriver>();

	private RemoteWebDriver createDriverInstance() throws IOException {
		instantiateDriver();
		return getDriver();
	}

	public synchronized void instantiateDriver() throws IOException {
		String browser = getBrowserValue();
		boolean remoteDriver = Boolean.parseBoolean(FileUtils.getKeyFromPropertyFile("remoteDriver"));
		DesiredCapabilities capabilities = new DesiredCapabilities();
		/*
		 * if (browser.equalsIgnoreCase(Constant.BROWSER_CHROME)) { tlDriver.set(new
		 * ChromeDriver(optionsManager.getChromeOptions())); }
		 */

		if (remoteDriver) {
			URL seleniumGridURL = null;
			try {
				seleniumGridURL = new URL((String) "http://selenium-grid-p02.sixt.de:5000/wd/hub");
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
			capabilities.setBrowserName(browser);
			tlDriver.set(new RemoteWebDriver(seleniumGridURL, capabilities));
		} else {
			if (browser.equalsIgnoreCase(Constant.BROWSER_FIREFOX)) {
				logger.info("The Browser is : " + browser);
				tlDriver = ThreadLocal.withInitial(() -> new FirefoxDriver(optionsManager.getFirefoxOptions()));
			} else if (browser.equalsIgnoreCase(Constant.BROWSER_CHROME)) {
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			}
		}

	}

	/**
	 * 
	 * @return driver
	 */
	public static synchronized RemoteWebDriver getDriver() {
		logger.info("Thread id = " + Thread.currentThread().getId());
		return tlDriver.get();
	}

	public static synchronized void terminateThreadDriver() {
		logger.info("Thread id = " + Thread.currentThread().getId());
		tlDriver.remove();
	}

	/**
	 * to quit the driver
	 */
	public static synchronized void quitDriverInstance() {
		if (!(tlDriver.get() == null)) {
			tlDriver.get().quit();
		} else {
			try {
				throw new Exception("WebDriver Exception Occurred");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String getBrowserValue() throws IOException {
		String browser = null;
		try {
			browser = (String) FileUtils.getKeyFromPropertyFile("browser");
		}
		catch (IOException e) {
			logger.error("Problem while opening file");
		}
		if (browser.equals("") || browser == null) {
			throw new AutomationException(Constant.BROWSER_NULL_MESSAGE);
		}
		return browser;
	}
	
	public RemoteWebDriver setWebDriverManager() throws IOException {
		String browser = getBrowserValue();

		if (browser.equalsIgnoreCase(Constant.BROWSER_CHROME)) {
			WebDriverManager.chromedriver().setup();
			return createDriverInstance();
		}
		if (browser.equalsIgnoreCase(Constant.BROWSER_FIREFOX)) {
			WebDriverManager.firefoxdriver().setup();
			return createDriverInstance();
		} else {
			return null;
		}

	}

}
