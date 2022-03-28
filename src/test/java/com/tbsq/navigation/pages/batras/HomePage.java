package com.tbsq.navigation.pages.batras;

import com.commoon.core.framework.web.utils.ElementActions;
import com.tbsq.navigation.pages.SmartWebBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends SmartWebBasePage {
    protected ElementActions elementActions;
    private static final Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        elementActions = new ElementActions(this.driver);
    }

    @FindBy(xpath="//a[contains(text(),\"TREATMENTS\") and @id=\"navbarDropdown0\"]")
    protected WebElement treatmentDropdown;

    @FindBy(xpath="//li[@class=\"nav-item\"]/a[text()=\"Child Health\"]")
    protected WebElement childHealth;

    @FindBy(xpath="//li/a[text()=\"Immunity\"]")
    protected WebElement childHealthImmunity;

    @FindBy(xpath = "//button[@id=\"chatNowBtn\"]")
    protected WebElement chatNowButton;

    @FindBy(xpath = "//div[@id=\"headerCloseButton\"]/span")
    protected WebElement closeChatNow;

    @FindBy(xpath = "//a[@href=\"/book-an-appointment\" and text()=\"CONSULT NOW\"]")
    protected WebElement consultNowButton;

    public void mouseHoverTreatment()
    {
        elementActions.mouseHover(treatmentDropdown);
    }

    public void clickChildImmunity()
    {
        elementActions.click(childHealth);
        elementActions.click(childHealthImmunity);
    }

    public void openAndCloseChatBot()
    {
        elementActions.click(chatNowButton);
        elementActions.switchToFrame("kenytChatWindow");
        elementActions.click(closeChatNow);
        elementActions.switchToDefaultContent();
    }

    public void clickOnConsultation()
    {
        elementActions.click(consultNowButton);
    }
}
