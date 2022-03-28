package com.tbsq.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.commoon.core.framework.web.utils.ElementActions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author umangkumar
 *
 */
public class LoginPage extends SmartWebBasePage {
	protected ElementActions elementActions;
	private static final Logger logger = Logger.getLogger(HomePage.class);

	public LoginPage(RemoteWebDriver driver) {
		super(driver);
		elementActions = new ElementActions(this.driver);
	}

	@FindBy(xpath="//span[contains(@id,\"select2-country_code\")]")
	protected WebElement countryDropdown;

	@FindBy(xpath="//input[@type=\"search\"]")
	protected WebElement countrySearchText;

	@FindBy(xpath="//li[@class=\"select2-results__option select2-results__option--highlighted\" and contains(text(),\"(India)\")]")
	protected WebElement countrySelectionOption;

	@FindBy(xpath="//input[@type='tel']")
	protected WebElement telephoneNumber;
	
	@FindBy(xpath="//button[contains(text(),\"Let's\")]")
	protected WebElement letsGoButton;

	public void logIn(String country,String phoneNumber)
	{
		logger.info("Starting log in process");
		elementActions.click(countryDropdown);
		elementActions.sendKeys(countrySearchText,country);
		elementActions.click(countrySelectionOption);
		elementActions.sendKeys(telephoneNumber,phoneNumber);
		elementActions.click(letsGoButton);
	}
}
