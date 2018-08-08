package com.qa.pages;

import com.qa.base.TestBase;

public class BuyPage extends TestBase {

	// proceed to pay
	public void buyNow() {

		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Proceed to Pay\"))").click();
		log.info("Proceeding to pay");
	}

}
