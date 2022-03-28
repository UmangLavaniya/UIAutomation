package com.tbsq.navigation.pages.batras;

import com.commoon.core.framework.web.utils.ElementActions;
import com.tbsq.navigation.pages.SmartWebBasePage;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AppointmentPage extends SmartWebBasePage {
    protected ElementActions elementActions;
    private RemoteWebDriver driver;

    private static final Logger logger = Logger.getLogger(AppointmentPage.class);

    public AppointmentPage(RemoteWebDriver driver) {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver, this);
        elementActions = new ElementActions(this.driver);
    }

    @FindBy(id = "request_name")
    protected WebElement patientName;

    @FindBy(id = "request_contact_no")
    protected WebElement patientMobileNumber;

    @FindBy(id = "request_email")
    protected WebElement patientEmail;

    @FindBy(id = "terms_and_conditions_chk")
    protected WebElement checkTnC;

    @FindBy(id = "request_a_call_btn")
    protected WebElement nextButton;

   /* @FindBy(xpath = "//span[text()=\"Select City\"]")
    protected WebElement selectCityDropdown;

    @FindBy(xpath = "//input[@class=\"select2-search__field\"]")
    protected WebElement selectCitySearchText;

    @FindBy(xpath = "//li[text()=\"+city+\"]")
    protected WebElement selectCity;*/

    @FindBy(xpath = "//span[@id=\"select2-city_tmp-container\"]")
    protected WebElement selectCityDropdown;

    @FindBy(xpath = "//input[@class=\"select2-search__field\"]")
    protected WebElement selectCitySearchText;

    @FindBy(xpath = "//select[@id=\"clinic_tmp\"]")
    protected WebElement selectClinic;

    @FindBy(xpath="//input[@id=\"day_tmp\"]")
    protected WebElement selectDay;

    @FindBy(xpath = "//select[@id=\"time_tmp\"]")
    protected WebElement selectTimeOption;
    String selectTimeOptions="//select[@id=\"time_tmp\"]/option";

    @FindBy(id = "payment_type")
    protected WebElement selectPaymentType;

    @FindBy(xpath="//button[text()=\"CONFIRM YOUR APPOINTMENT\"]")
    protected WebElement bookingConfirmationButton;

    @FindBy(xpath = "//h4[text()=\"YOUR APPOINTMENT IS CONFIRMED\"]")
    protected WebElement bookingConfirmationMessage;

    public void enterPatientDetails(String name,String mobileNumber,String emailId)
    {
        elementActions.sendKeys(patientName,name);
        elementActions.sendKeys(patientMobileNumber,mobileNumber);
        elementActions.sendKeys(patientEmail,emailId);
    }

    public void selectCity(String city)
    {
        elementActions.click(selectCityDropdown);
        elementActions.sendKeys(selectCitySearchText,city);
        elementActions.click("//li[text()="+"\"" +city+ "\""+"]");
    }
    public void enterAppointmentDetails(String city,String clinic,String day,String paymentType)
    {
        selectCity(city);
        elementActions.selectOption(selectClinic,clinic);
        elementActions.sendKeys(selectDay,day);
        elementActions.click(selectTimeOptions);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ie)
        {
            System.out.println("Exception is : " + ie);
        }
        elementActions.click(selectTimeOption);
        try {
            Thread.sleep(3000);
        }
        catch (InterruptedException ie)
        {
            System.out.println("Exception is : " + ie);
        }
        elementActions.selectFirstEnabledOption(selectTimeOptions);
        elementActions.selectOption(selectPaymentType,paymentType);
    }

    public void bookAppointment(String name,String mobileNumber,String emailId,String city,String clinic,String day,String paymentType)
    {
        enterPatientDetails(name,mobileNumber,emailId);
        elementActions.click(checkTnC);
        elementActions.click(nextButton);
        enterAppointmentDetails(city, clinic, day, paymentType);
        elementActions.click(bookingConfirmationButton);
    }

    public boolean verifyBooking()
    {
        return elementActions.isDisplayed(bookingConfirmationMessage);
    }

}
