package com.ba7.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.ba7.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_SHEET_PATH = "D:\\workspace 11\\BA7WebPortalTest\\"
			+ "src\\main\\java\\com\\ba7\\qa\\testdata\\BeneDesignationAddition.xlsx";
	static Workbook book;
	static Sheet sheet;

	public void switchToFrame() {
		driver.switchTo().frame("mainpanal");
	}

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
		// System.out.println(sheet.getLastRowNum() + "............" +
		// sheet.getRow(0).getLastCellNum());
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
				// System.out.println(data[i][k]);
			}
		}
		return data;
	}

	// it can used as TestUtil.takeScreenshotAtEndOfTest whenever required
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");

		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));

	}

	public static void ByVisibleElement(WebElement web) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", web);
	}

	public static void selectDropownOption(WebElement webElement, String type, String option) {

		Select sel = new Select(webElement);
		switch (type) {
		case "index":

			sel.selectByIndex(Integer.parseInt(option));
			break;

		case "value":

			sel.selectByValue(option);
			break;
			
			
		case "text":

			sel.selectByVisibleText(option);
			break;
			
		default:
			System.out.println("Please pass correct select criteria...");
			break;
		}
	}
}
