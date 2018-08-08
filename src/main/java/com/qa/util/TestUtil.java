package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	static String TESTDATA_SHEET_PATH = "src\\main\\java\\com\\qa\\testdata\\eBayTestData.xlsx";
	static Workbook book;
	static Sheet sheet;

	public static Object[][] getTestData(String sheetName) {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);

		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {

				try {
					data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				} catch (Exception n) {
					data[i][k] = "";
				}
			}
		}

		return data;
	}

	public static void captureScreenshot(String testFunctionName) {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		String imagePath = currentDir + "/screenshots/" + testFunctionName + "_" + System.currentTimeMillis() + ".png";
		File fname = new File(imagePath);
		try {
			FileUtils.copyFile(scrFile, fname);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String filePath = fname.toString();
		String path = "<img src=\"file://" + filePath + "\" alt=\"\"/>";
		Reporter.log(path);

	}

	public static String findCurrentActivity() {
		String currentactivity = driver.currentActivity();

		return currentactivity;
	}

}