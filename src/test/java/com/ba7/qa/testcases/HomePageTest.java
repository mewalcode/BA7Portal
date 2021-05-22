package com.ba7.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ba7.qa.base.TestBase;
import com.ba7.qa.pages.HomePage;
import com.ba7.qa.pages.LoginPage;
import com.ba7.qa.pages.PensionPage;

public class HomePageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PensionPage pensionPage;

	public HomePageTest() {
		super();
	} 

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void validateHomePageTitleTest() {
		Assert.assertEquals(homePage.validateHomePageTitle(),"Home","Incorrect Home Page Title");
		
	}
	
	@Test
	public void validatePensionTabTest() {
		Assert.assertTrue(homePage.validatePensionTab());
	}
	
	@Test
	public void validatePenisonSnapshotTest() {
		Assert.assertTrue(homePage.validatePensionSnapshot());
	}
	
	@Test
	public void cickPensionTabTest() {
		pensionPage = homePage.clickOnPensionTab();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
}
