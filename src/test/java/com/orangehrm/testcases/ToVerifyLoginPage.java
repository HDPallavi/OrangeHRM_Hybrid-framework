package com.orangehrm.testcases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.orangehrm.pages.LoginPage;
import com.orangehrm.utility.BaseClass;
import com.orangehrm.utility.Helper;

/*
 *@author Pallavi
 *This class is to verify all elements in login page
 */
public class ToVerifyLoginPage extends BaseClass
{
	 @Test(priority=1)
	 public void testSldcLogins() 
	 {
		 logger=report.createTest("Login to orangehrm");
		 LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		 lp.validLoginToApplication( excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));//it will read data from excel
		 Helper.captureScreenshot(driver);
		 logger.pass("Login success");
	 }
	  
}
