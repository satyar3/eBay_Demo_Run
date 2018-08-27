package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.base.TestBase;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;

public class BuyPage extends TestBase {

	// proceed to pay
	public void buyNow() {
				
		String msg = "Proceed to Pay";
		
		MobileElement scrollToText = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().text(\"" + msg + "\"));"));
		scrollToText.click();
		
		/*try
		{
			driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+msg+"\"))").click();
		}
		catch (Exception e) {
			driver.findElement(By.id("proceedToPay")).click();
		}*/

		log.info("Proceeding to pay");
	}

}
