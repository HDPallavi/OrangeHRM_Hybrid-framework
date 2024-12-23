package com.orangehrm.utility;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * This class is to keep preconditions required before start testcases and postcondition required after testcase
 * @author pallavi
 *
 */
public class BaseClass 
{
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report; 
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() 
	{
		excel=new ExcelDataProvider();
		config=new ConfigDataProvider();
		ExtentHtmlReporter extent=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/reports/REMCScheduling-"+Helper.getCurrentDateTime()+".html"));
		report=new ExtentReports();
		report.attachReporter(extent);
	}
	
	@BeforeClass
	public void setUp() 
	{
		driver=BrowserFactory.openApplication(driver,config.getBrowser(),config.getStagingURL());
	}
	
	/*@AfterClass
	public void tearDown() 
	{
		BrowserFactory.closeApplication(driver);
	}*/
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			Helper.captureScreenshot(driver);
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		
		report.flush();
	
	}
	
	
}
