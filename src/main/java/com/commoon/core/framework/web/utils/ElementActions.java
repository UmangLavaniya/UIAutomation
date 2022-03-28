package com.commoon.core.framework.web.utils;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import com.common.core.framework.constants.Constant;

import lombok.NonNull;

/**
 * @author umangkumar
 *
 */
public class ElementActions {

	public RemoteWebDriver driver;
	public WebDriverWait wait;
	public Actions actions;
	public Select select;
	
	final static Logger logger= Logger.getLogger(ElementActions.class);

	public ElementActions(RemoteWebDriver driver) {
		this.driver = driver;
	}

	/**
	 * 
	 * @param webelement
	 * @param value
	 */
	public void selectOption(@NonNull WebElement element, @NonNull Object value) {
		List<WebElement> options = element.findElements(getTagName("option"));
		select = new Select(element);
		waitForPageLoad();
		try {
			for (WebElement option : options) {
				if (option.isDisplayed()) {
					if (value instanceof String) {
						select.selectByValue((String) value);
						logger.debug("Value is String");
						break;
					} else if (value instanceof Integer) {
						select.selectByIndex((Integer) value);
						logger.debug("Value is int");
						break;
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	

	/**
	 * 
	 * @param Selector
	 * @return Selector
	 */
	public By getTagName(@NonNull String Selector) {
		waitForPageLoad();
		return By.tagName(Selector);
	}

	/**
	 * Below method used to wait for full dom to load
	 */
	public void waitForPageLoad() {
		logger.debug("Waiting for page load");
		WebDriverWait wait = new WebDriverWait(driver, 30, 500);
		wait.until((WebDriver webDriver) -> {
			JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
			return "complete".equals(javascriptExecutor.executeScript("return document.readyState"));
		});
	}

	/**
	 * @param element
	 */
	public void mouseHover(@NonNull WebElement element) {
		logger.debug("Performing mouse hover operation on : " + element);
		waitForPageLoad();
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	/**
	 * 
	 * @param element
	 */
	public void waitForElementToBeClickable(@NonNull WebElement element) {
		try {
			logger.debug("Waiting for element to be clickable: " + element);
			waitForPageLoad();
			wait = new WebDriverWait(driver, Constant.ELEMENT_WAIT_TIME);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			throw new TestException("The following element is not clickable: " + element);
		}
	}

	/**
	 * @param element
	 */
	public void click(WebElement element) {
		logger.debug("Clicking element : " + element);
		waitForPageLoad();
		waitForElementToBeClickable(element);
		element.click();
	}

	/**
	 * @param element
	 */
	public void clear(WebElement element) {
		logger.debug("Clearing text of element : " + element);
		waitForPageLoad();
		waitForElementToBeClickable(element);
		element.clear();
	}
	
	/**
	 * 
	 * @param element
	 * @param value
	 */
	public void sendKeys(@NonNull WebElement element, @NonNull String value) {
		try {
			logger.debug("Sending : "+value+ " for element : " + element);
			waitForPageLoad();
			waitForElementToBeClickable(element);
			element.sendKeys(value);
		} catch (Exception e) {
			throw new TestException(
					String.format("Error in sending [%s] to the following element: [%s]", value, element.toString()));
		}
	}

	/**
	 *
	 * @param element
	 */
	public String getText(@NonNull WebElement element)
	{
		logger.debug("Getting text of element : " + element);
		waitForPageLoad();
		waitForElementToBeClickable(element);
		return element.getText();
	}

	/**
	 *
	 * @param element
	 */
	public void waitForElementToDisappear(@NonNull WebElement element)
	{
		logger.debug("Waiting for element : "+ element+ " to disappear");
		while (element.isDisplayed()) {
			try {
				logger.info("Element is still present");
				Thread.sleep(500);
			}catch (InterruptedException ie)
			{
				logger.error("Waiting....."+ie);
			}
		}
	}
}
