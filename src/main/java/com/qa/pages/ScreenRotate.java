package com.qa.pages;

import org.openqa.selenium.ScreenOrientation;

import com.qa.base.TestBase;

public class ScreenRotate extends TestBase {

	public void rotateScreen() {
		driver.rotate(ScreenOrientation.LANDSCAPE);
		driver.rotate(ScreenOrientation.PORTRAIT);
	}
}
