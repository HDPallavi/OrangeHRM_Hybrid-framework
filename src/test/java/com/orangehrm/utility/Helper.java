
package com.orangehrm.utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

/**
 * @author Pallavi
 *
 */
public class Helper 
{
	//Screenshots, alerts, frames, multiple windows, sync issues, java script executor
	public static String captureScreenshot(WebDriver driver ) 
	{
		File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/screenshots/orangehrm_"+getCurrentDateTime()+".png";
		
		
		try 
		{
			
			FileHandler.copy(src, new File(screenshotPath));
			
		} 
		catch (IOException e) 
		{
			
			System.out.println("Unable to capture screeshot"+e.getMessage());
		}
		return screenshotPath;
	}
	public static String getCurrentDateTime() 
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss3");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
	}
}
