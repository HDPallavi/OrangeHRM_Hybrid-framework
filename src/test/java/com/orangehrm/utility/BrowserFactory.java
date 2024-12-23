package com.orangehrm.utility;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

/* This is a separate class to open application and close application
 * This will return the browser
 * @author pallavi
 */
public class BrowserFactory 
{
	public static WebDriver openApplication(WebDriver driver, String browserName, String appUrl) //Return type is WebDriver bcz it will return driver
	{
		if(browserName.equals("Chrome")) //if browser name equals to chrome 
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equals("Firefox")) //if browser name equals to firefox
		{
			System.setProperty("webdriver.gecko.driver", "./driver/geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserName.equals("IE")) //if browser name equal to IE
		{
			System.setProperty("webdriver.ie.driver", "./driver/IEDriverServer.exe");
			driver=new FirefoxDriver();
		}
		else 
		{
			System.out.println("we do not support this browser");
		}
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();//maximize window
		driver.get(appUrl);//enter app url
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;//return respective driver
	}

	public static void closeApplication(WebDriver driver) 
	{
		driver.quit();
	}
}
