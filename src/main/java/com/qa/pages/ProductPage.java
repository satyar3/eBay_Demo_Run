package com.qa.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;

import com.qa.base.TestBase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class ProductPage extends TestBase {

	//Buy it Now
	public void productDetailsAndBuy() {
		
		String msg = "Item description";
		AndroidElement scrollToElement1 = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+msg+"\"))");
		scrollToElement1.click();
		//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+msg+"\"))").click();
		driver.navigate().back();
		AndroidElement scrollToElement = (AndroidElement) driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+msg+"\"))");
		//MobileElement scrollToElement = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Buy It Now\"));"));
		//scrollToElement.click();
		
		int startX = scrollToElement.getLocation().getX() + (scrollToElement.getSize().getWidth() / 2);
		int startY = scrollToElement.getLocation().getY() + (scrollToElement.getSize().getHeight() / 2);
		boolean flag;
		do
		{
			new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(0, 959)).release().perform();
			
			
			try
			{
				flag = driver.findElement(By.xpath(prop.getProperty("buyitnow_xpath"))).isDisplayed();
				
				if(flag == true)
				{
					break;
				}
			}
			catch(NoSuchElementException e)
			{
				flag = false;
				continue;
			}
			
		}	
		while(flag == false);
			
		//	new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(0, 959)).release().perform();
		//	new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(0, 959)).release().perform();
		//	new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(0, 959)).release().perform();
		//	new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2))).moveTo(point(0, 959)).release().perform();
			//MobileElement scrollToElement2 = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().description(\"Buy It Now\"));"));
			//scrollToElement2.click();

		//}
		//while(driver.findElement(By.xpath(prop.getProperty("buyitnow_xpath"))).isDisplayed());
		
		driver.findElement(By.xpath(prop.getProperty("buyitnow_xpath"))).click();
		log.info("Buy it now clicked");
	}
	
	public boolean swipeFromUpToBottom() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			HashMap<String, String> scrollObject = new HashMap<String, String>();
			scrollObject.put("direction", "up");
			js.executeScript("mobile: scroll", scrollObject);
			System.out.println("Swipe up was Successfully done.");
		} catch (Exception e) {
			System.out.println("swipe up was not successfull");
		}
		return false;
	}
}
