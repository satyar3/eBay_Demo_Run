package com.qa.pages;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import com.qa.base.TestBase;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidElement;

public class QuantityPage extends TestBase {

	//Swipe for exact quantity
	public void swipeToSelectQty(String qty) {

		AndroidElement startpos = (AndroidElement) driver.findElement(By.xpath(prop.getProperty("qty_start_pos_xpath")));
		AndroidElement endpos = (AndroidElement) driver.findElement(By.id(prop.getProperty("qty_end_pos_id")));

		int startX = startpos.getLocation().getX() + (startpos.getSize().getWidth() / 2);
		int startY = startpos.getLocation().getY() + (startpos.getSize().getHeight() / 2);

		int endX = endpos.getLocation().getX() + (endpos.getSize().getWidth());
		int endY = endpos.getLocation().getY() + (endpos.getSize().getHeight());
		
		try 
		{
			while (!(driver.findElement(By.id(prop.getProperty("number_picker_id"))).getText().equals(qty))) {
				new TouchAction(driver).press(point(startX, startY)).waitAction(waitOptions(ofSeconds(2)))
						.moveTo(point(endX, endY)).release().perform();
				log.info("Qunaity swiped");

			}
			driver.findElement(By.id(prop.getProperty("reviewaction_id"))).click();
			log.info("Item reviewed");
		}
		catch(NoSuchElementException e)
		{
			log.error("Desired Product Quantity not available");
		}
	}

}
