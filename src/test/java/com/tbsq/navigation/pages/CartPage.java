package com.tbsq.navigation.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.common.core.framework.base.BasePage;
import com.common.core.framework.exception.AutomationException;
import com.commoon.core.framework.web.utils.ElementActions;
import org.testng.Assert;

/**
 * @author umangkumar
 *
 */
public class CartPage extends BasePage {

	private RemoteWebDriver driver;
	protected ElementActions elementActions;

	private static final Logger logger = Logger.getLogger(HomePage.class);

	public CartPage(RemoteWebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementActions = new ElementActions(this.driver);
	}

	@FindBy(xpath = "//ul[@class=\"detail-item \"]//div[@class=\"add-val\"]")
	protected WebElement quantityValue;

	@FindBy(xpath = "//a[contains(text(),\"Pay By Cash\")]")
	protected WebElement payByCashButton;

	public void verifyCart(int quantity) {
		Assert.assertEquals(elementActions.getText(quantityValue), String.valueOf(quantity));
	}

	public void payInCash()
	{
		elementActions.click(payByCashButton);
	}
}
