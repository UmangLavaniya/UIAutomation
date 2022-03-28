package com.tbsq.navigation.tests;

import com.tbsq.navigation.dataproviders.TBSQTestDP;
import com.tbsq.navigation.pages.*;
import org.testng.annotations.Test;

public class SmartWebOrderTest extends SmartWebBaseTest{

    @Test(priority = 1, dataProvider = "orderPlacementDP", dataProviderClass = TBSQTestDP.class)
    public void foodOrderTest(String country,String phoneNumber,int quantity) {
        LoginPage loginPage=new LoginPage(this.driver);
        //this.driver=loginPage.driver;
        loginPage.logIn(country,phoneNumber);
        //this.driver=loginPage.driver;
        HomePage homePage = new HomePage(loginPage.driver);
        homePage.dineInSelection();
        MenuPage menuPage = new MenuPage(loginPage.driver);
        menuPage.addItem(quantity);
        menuPage.checkOut();
        CartPage cartPage = new CartPage(loginPage.driver);
        cartPage.verifyCart(quantity);
        cartPage.payInCash();
        OrderSummaryPage orderSummaryPage = new OrderSummaryPage(loginPage.driver);
        orderSummaryPage.orderVerification();
    }
}
