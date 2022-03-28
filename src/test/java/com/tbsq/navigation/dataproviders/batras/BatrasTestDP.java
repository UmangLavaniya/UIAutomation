package com.tbsq.navigation.dataproviders.batras;

import org.testng.annotations.DataProvider;

public class BatrasTestDP {
    public static final String NAME="XYZ";
    public static final String MOBILE_NUMBER="9876543210";
    public static final String EMAIL="xyz@gmail.com";
    public static final String CITY="AGRA";
    public static final String CLINIC="121-C_M G ROAD AGRA";
    public static final String DAY="2022-03-31";
    public static final String PAYMENT_TYPE="CC-199";


    @DataProvider
    public static Object[][] bookAppointmentDP()
    {
        return new Object[][] { { NAME,MOBILE_NUMBER,EMAIL,CITY,CLINIC,DAY,PAYMENT_TYPE } };
    }
}
