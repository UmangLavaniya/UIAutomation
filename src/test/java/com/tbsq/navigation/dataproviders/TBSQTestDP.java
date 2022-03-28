/**
 * 
 */
package com.tbsq.navigation.dataproviders;

import org.testng.annotations.DataProvider;

/**
 * @author umangkumar
 *
 */


public class TBSQTestDP {
	
	public static final String COUNTRY="(India)";
	public static final String PHONE_NUMBER="9876543210";
	public static final int QUANTITY=3;
	
	@DataProvider
	public static Object[][] orderPlacementDP()
	{
		return new Object[][] { { COUNTRY,PHONE_NUMBER,QUANTITY } };
	}

}
