package com.qa.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.ScreenRotate;

public class ScreenRotateTest extends TestBase{
	
	ScreenRotate rotate;
	
	@BeforeTest()
	public void setUp() {
		initialization();
		rotate = new ScreenRotate();
	}

	@Test(priority = 1, description = "To test screen rotation functionality")
	public void test2() {

		rotate.rotateScreen();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
