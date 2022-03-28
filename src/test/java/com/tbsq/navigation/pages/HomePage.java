package com.tbsq.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.commoon.core.framework.web.utils.ElementActions;
import org.openqa.selenium.support.PageFactory;

/**
 * @author umangkumar
 *
 */
public class HomePage extends SmartWebBasePage {
	
	protected ElementActions elementActions;
	private RemoteWebDriver driver;
	private static final Logger logger = Logger.getLogger(HomePage.class);

	public HomePage(RemoteWebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		elementActions = new ElementActions(this.driver);
	}

	@FindBy(xpath = "//a[contains(@data-text,\"Dine In\")]")
	protected WebElement dineInSelection;

	public void dineInSelection()
	{
		elementActions.click(dineInSelection);
	}
}
