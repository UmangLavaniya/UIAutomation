package com.commoon.core.framework.web.utils;

import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.common.core.framework.constants.Constant;
import com.common.core.framework.exception.AutomationException;
import com.common.core.framework.utils.FileUtils;

/**
 * @author umangkumar
 *
 */
public class URLAction  {

	
	
	public void launchUrl(RemoteWebDriver driver) {
		String url = getAppUrl();
		try {
			driver.get(url);
		} catch (Exception e) {
			throw new AutomationException(Constant.URL_NULL_MESSAGE);
		}
	}

	public String getAppUrl() {
		String url = null;
		try {
			url = (String)FileUtils.getKeyFromPropertyFile("url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (url.equals("") || url == null) {
			throw new AutomationException(Constant.URL_NULL_MESSAGE);
		}
		return url;
	}

	public String getCurrentAppUrl(RemoteWebDriver driver) {
		try {
			return driver.getCurrentUrl();
		} catch (Exception e) {
			throw new com.common.core.framework.exception.AutomationException("Issue with current URL or it's blank");
		}
	}

}
