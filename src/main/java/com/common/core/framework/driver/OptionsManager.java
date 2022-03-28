package com.common.core.framework.driver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

/**
 * @author umangkumar
 *
 */
public class OptionsManager {
	// Get Chrome Options
	public ChromeOptions getChromeOptions() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		options.addArguments("--ignore-certificate-errors");
		options.addArguments("--disable-popup-blocking");
		return options;
	}

	public FirefoxOptions getFirefoxOptions() {
		// Get Firefox Options
		FirefoxBinary firefoxBinary = new FirefoxBinary();
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(firefoxBinary);
		FirefoxProfile profile = new FirefoxProfile();
		options.setProfile(profile);
		profile.setAcceptUntrustedCertificates(true);
		profile.setAssumeUntrustedCertificateIssuer(false);
		options.setCapability(FirefoxDriver.PROFILE, profile);
		return options;
	}

}
