package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.base.TestBase;

import io.appium.java_client.touch.offset.PointOption;

public class PaymentMethod extends TestBase{

	//Select paymentod and pay
	public void paymentMethod(String paymentmethodname)
	{
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+paymentmethodname+"\"))").click();		
		log.info("UPI Payment selected");
		
		//Hardcoding for UPI Payment
		driver.findElement(By.xpath(prop.getProperty("upi_payment_xpath"))).click();
		log.info("UPI Payment selected");
		driver.findElement(By.id(prop.getProperty("paymentbutton_id"))).click();
		log.info("UPI Payment clicked");
	}

	private PointOption point(int x, int y) {
		// TODO Auto-generated method stub
		return null;
	}
}
