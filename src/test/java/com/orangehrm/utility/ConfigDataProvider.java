
package com.orangehrm.utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author pallavi
 *
 */
public class ConfigDataProvider 
{
	Properties pro;
	public ConfigDataProvider() 
	{
		File src=new File("./config/config.properties");
		try 
		{
		FileInputStream fis=new FileInputStream(src);
		pro=new Properties();
		pro.load(fis);
		}
		catch(Exception e) 
		{
			System.out.println("Not able to load configfile>>"+e.getMessage());
		}
	}
	
	public String getDataFromConfig(String keyToSearch) 
	{
		return pro.getProperty(keyToSearch);
	}
	public String getBrowser() 
	{
		return pro.getProperty("Browser");
	}
	public String getStagingURL() 
	{
		return pro.getProperty("qaUrl");
	}
}
