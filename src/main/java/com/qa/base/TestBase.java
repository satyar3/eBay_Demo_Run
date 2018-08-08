package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	
	public static Logger log = Logger.getLogger(TestBase.class);
	
	protected static AndroidDriver driver;
	protected static Properties prop;
	protected static FileInputStream fs;
	protected static DesiredCapabilities capabilities;
	
	//Defining config file
	public TestBase() 
	{
		try
		{
			fs = new FileInputStream("src\\main\\java\\com\\qa\\config\\config.properties");
			prop = new Properties();
			prop.load(fs);
			
		}
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	//Defining desired capabilities
	public void initialization()
	{
		capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, prop.getProperty("platformName"));
		capabilities.setCapability(CapabilityType.VERSION, prop.getProperty("PlatformVersion"));
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true); 
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, prop.getProperty("DeviceName"));		
		capabilities.setCapability("appPackage", prop.getProperty("appPackage"));
		capabilities.setCapability("appActivity", prop.getProperty("appActivity"));
		
		try 
		{
			driver = new AndroidDriver(new URL(prop.getProperty("url")), capabilities);
		} 
		catch (MalformedURLException e) 
		{
			e.printStackTrace();
		}
		
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(prop.getProperty("implicitlyWait")), TimeUnit.SECONDS);
	}
}