package com.qa.pages;

import org.openqa.selenium.By;

import com.qa.base.TestBase;

public class ProductPage extends TestBase {

	//Buy it Now
	public void productDetailsAndBuy() {
		driver.findElement(By.xpath(prop.getProperty("buyitnow_xpath"))).click();
		log.info("Buy it now clicked");
	}
}
