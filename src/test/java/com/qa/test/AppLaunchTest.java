package com.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.util.TestUtil;

public class AppLaunchTest extends TestBase {

	public AppLaunchTest() {
		super();
	}

	@BeforeTest()
	public void setUp() {
		initialization();
	}

	@Test(priority = 1, description = "To test if the app is getting launched successfully or not")
	public void test1() {
		// Verifying current app activity
		Assert.assertEquals(TestUtil.findCurrentActivity(), ".activities.MainActivity");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
