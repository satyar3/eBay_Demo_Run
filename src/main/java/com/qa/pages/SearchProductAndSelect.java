package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.qa.base.TestBase;

import io.appium.java_client.MobileBy;

public class SearchProductAndSelect extends TestBase {

	public void prodcutSearchAndSelect(String procutname, String itemname) {

		// Enter a keyword to search
		driver.findElement(By.id(prop.getProperty("searchbox_id"))).click();
		driver.findElement(By.id(prop.getProperty("searchbox_text_id"))).sendKeys(procutname);
		log.info("User Entered Product Name as : " + procutname);
		driver.hideKeyboard();

		// fetching the product list from suggestion
		List<WebElement> elements = driver.findElements(By.id(prop.getProperty("searchresult_list_id")));

		for (int i = 0; i < elements.size(); i++) {
			String productname = elements.get(i).getText();

			if (productname.equals(itemname)) {
				try {
					elements.get(i).click();
					log.info("Item Name Selected is : " + itemname);
					break;
				} catch (NoSuchElementException e) {
					log.error("No Such Product found");
				}

			}
		}

	}

	public void scrollToItem(String modelnum) {
		// Scrolling and selecting exact product
		try {
			driver.findElement(MobileBy.AndroidUIAutomator(
					"new UiScrollable(new UiSelector()).scrollIntoView(new UiSelector().textContains(\"" + modelnum
							+ "\"))"))
					.click();
		} catch (NoSuchElementException e) {
			log.error("Model Number Not found");
		}
	}
}