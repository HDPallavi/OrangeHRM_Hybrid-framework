package com.orangehrm.pages;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

/* This class is to locate all elements in login page
 * @Pallavi
 */
public class LoginPage 
{
	WebDriver driver;
	
	public LoginPage(WebDriver ldriver)//Constructor , this l driver come from test case what ever driver passes it will come here
	{
		this.driver=ldriver;
	}
	
	@FindBy(name="username")
	public WebElement username;
	@FindBy(name="password")
	public WebElement password;
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginbutton;
	
	public void validLoginToApplication(String un,String pwd) 
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginbutton.click();
	}
	
}
