package com.tbsq.navigation.pages;

import com.commoon.core.framework.web.utils.ElementActions;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends SmartWebBasePage{
    protected ElementActions elementActions;
    private RemoteWebDriver driver;

    private static final Logger logger = Logger.getLogger(HomePage.class);

    public MenuPage(RemoteWebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementActions = new ElementActions(this.driver);
    }

    @FindBy(xpath = "//a[@class=\"add-btn add-btn-item btn-dish btn-primary \"]")
    protected WebElement addFirstItemButton;

    @FindBy(xpath = "//a[@class=\"add-btn add-sku-btn btn-primary\"]")
    protected WebElement addItem;

    @FindBy(xpath = "//a[@class=\"to-plus btn-primary test\"]")
    protected WebElement increaseQuantity;

    @FindBy(id = "checkoutButton")
    protected WebElement checkoutButton;

    public void addItem(int quantity)
    {
        elementActions.click(addFirstItemButton);
        elementActions.click(addItem);
        for(int i=1;i<quantity;i++) {
            elementActions.click(increaseQuantity);
            try {
                Thread.sleep(2000);
            }
            catch (InterruptedException ie)
            {
                System.err.println(ie);
            }
        }
    }

    public void checkOut()
    {
        elementActions.click(checkoutButton);
    }

}
