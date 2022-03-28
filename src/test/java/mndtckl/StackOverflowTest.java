package mndtckl;

import com.tbsq.navigation.tests.SmartWebBaseTest;
import org.testng.annotations.Test;

public class StackOverflowTest extends SmartWebBaseTest {
    @Test
    public void stackOverflowTest()
    {
        HomePage homePage=new HomePage(this.driver);
        homePage.isTagPresent("path-variables");
        //homePage.isTagPresent("random-tag");
    }
}
