package com.ba7.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ba7.qa.base.TestBase;
import com.ba7.qa.pages.BeneficiariesPage;
import com.ba7.qa.pages.HomePage;
import com.ba7.qa.pages.LoginPage;
import com.ba7.qa.pages.PensionPage;

public class PensionPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PensionPage pensionPage;
	BeneficiariesPage beneficiariesPage;

	public PensionPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pensionPage = homePage.clickOnPensionTab();

	}

	@Test(priority = 1)
	public void validatePensionPageTitleTest() {
		Assert.assertEquals(pensionPage.validatePensionPageTitle(),"DBChannel");
		
	}

	@Test(priority = 2)
	public void validateOverviewTest() {

		Assert.assertTrue(pensionPage.validateOverview());
	}
	@Test(priority = 3)
	public void clickBeneficiariesTabTest() {
		beneficiariesPage = pensionPage.beneficaryTabCLick();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
