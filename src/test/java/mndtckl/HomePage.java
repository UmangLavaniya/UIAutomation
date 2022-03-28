package mndtckl;

import com.commoon.core.framework.web.utils.ElementActions;
import com.tbsq.navigation.pages.SmartWebBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class HomePage extends SmartWebBasePage {
    protected ElementActions elementActions;
    private static final Logger logger = Logger.getLogger(HomePage.class);

    public HomePage(RemoteWebDriver driver) {
        super(driver);
        elementActions = new ElementActions(this.driver);
    }

    public void isTagPresent(String tagName)
    {
        List<WebElement> elements=driver.findElements(By.xpath("//div[@class=\"question\"]//a[@rel=\"tag\"]"));
        for (WebElement element:elements) {
            if(element.getText().equals(tagName))
            {
                logger.info("Tag is present : " + tagName);
            }
            else
            {
                logger.info("Tag is not present : " + tagName);
            }
        }
    }

}
