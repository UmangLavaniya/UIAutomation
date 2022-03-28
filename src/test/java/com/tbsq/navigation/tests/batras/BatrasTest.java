package com.tbsq.navigation.tests.batras;

import com.tbsq.navigation.dataproviders.batras.BatrasTestDP;
import com.tbsq.navigation.pages.batras.AppointmentPage;
import com.tbsq.navigation.pages.batras.HomePage;
import com.tbsq.navigation.tests.SmartWebBaseTest;
import org.testng.annotations.Test;

public class BatrasTest extends SmartWebBaseTest {
    @Test(priority = 1, dataProvider = "bookAppointmentDP", dataProviderClass = BatrasTestDP.class)
    public void batrasConsultationTest(String name,String mobileNumber,String emailId,String city,String clinic,String day,String paymentType) {
        HomePage homePage=new HomePage(this.driver);
        homePage.mouseHoverTreatment();
        homePage.clickChildImmunity();
        homePage.openAndCloseChatBot();
        homePage.clickOnConsultation();
        AppointmentPage appointmentPage=new AppointmentPage(homePage.driver);
        appointmentPage.bookAppointment(name, mobileNumber, emailId, city, clinic, day,paymentType);
        appointmentPage.verifyBooking();
    }
}
