package com.qa.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.BuyPage;
import com.qa.pages.PaymentMethod;
import com.qa.pages.ProductPage;
import com.qa.pages.QuantityPage;
import com.qa.pages.ScreenRotate;
import com.qa.pages.SearchProductAndSelect;
import com.qa.util.TestUtil;

public class woFwork extends TestBase {

	SearchProductAndSelect selproduct;
	ProductPage prodpage;
	QuantityPage qtyselect;
	BuyPage buy;
	PaymentMethod paymentmethod;
	ScreenRotate rotate;
	String produtsheet_name = "TestDataSheet";

	public woFwork() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		selproduct = new SearchProductAndSelect();
		prodpage = new ProductPage();
		qtyselect = new QuantityPage();
		buy = new BuyPage();
		paymentmethod = new PaymentMethod();
		rotate = new ScreenRotate();
	}

	@DataProvider
	public Object[][] getTestData() {
		Object ob[][] = TestUtil.getTestData(produtsheet_name);
		return ob;
	}
	
	//Verifying buying functionality
	@Test(priority = 1, dataProvider = "getTestData", description = "Test the product selection and buy functionality")
	public void productSelction(String tcnum, String productname, String itemname, String modelnum, String qty,
			String paymentmethodname) throws InterruptedException {
		
		selproduct.prodcutSearchAndSelect(productname, itemname);
		selproduct.scrollToItem(modelnum);
		prodpage.productDetailsAndBuy();
		qtyselect.swipeToSelectQty(qty);
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(textContains(\"Proceed to Pay\"))").click();
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+"2"+"\"))").click();
		paymentmethod.paymentMethod(paymentmethodname);
		log.info(tcnum + " execution has been completed");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
