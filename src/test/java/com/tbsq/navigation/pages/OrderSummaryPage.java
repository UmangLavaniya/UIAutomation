package com.tbsq.navigation.pages;

import com.commoon.core.framework.web.utils.ElementActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OrderSummaryPage extends SmartWebBasePage{
    protected ElementActions elementActions;
    private RemoteWebDriver driver;

    private static final Logger logger = Logger.getLogger(HomePage.class);
    private String sucessOrderMessage="Your Order has been successfully sent to kitchen";

    public OrderSummaryPage(RemoteWebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementActions = new ElementActions(this.driver);
    }

    @FindBy(xpath = "//p[@id=\"message\"]")
    protected WebElement successOrderMessage;

    @FindBy(xpath = "//td[contains(text(),\"Order ID\")]/span")
    protected WebElement orderId;

    @FindBy(xpath="//div[@class=\"loading-scroll\"]/span[text()=\"Please wait...\"]")
    protected WebElement loadingElement;

    public void orderVerification()
    {
        elementActions.waitForElementToDisappear(loadingElement);
        Assert.assertEquals(successOrderMessage.getText(),sucessOrderMessage);
        Assert.assertNotNull(orderId.getText());
    }
}
