/**
 * 
 */
package com.tbsq.navigation.pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import com.common.core.framework.base.BasePage;
import com.commoon.core.framework.web.utils.ElementActions;

/**
 * @author umangkumar
 *
 */
public class SmartWebBasePage extends BasePage{
	protected ElementActions elementActions;
	
	public SmartWebBasePage(RemoteWebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
		elementActions = new ElementActions(this.driver);
	}
	
}
