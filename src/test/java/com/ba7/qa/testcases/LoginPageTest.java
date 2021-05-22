package com.ba7.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ba7.qa.base.TestBase;
import com.ba7.qa.pages.HomePage;
import com.ba7.qa.pages.LoginPage;
import com.ba7.qa.util.TestUtil;

public class LoginPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	
	//declaring sheet name 
	static String sheetName = "Participant";

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}

	@Test(priority = 1) 
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTittle();
		Assert.assertEquals(title, "BenefitsConnection - Login");
	}

	@Test(priority = 2)
	public void loginPagelogoTest() {
		Boolean b = loginPage.validateLogoTest();
		Assert.assertTrue(b);
	}
	
	// added same as beneficiary one
	@DataProvider
	public Object[][] getBeneAddTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	}
		
	@Test(priority = 3, dataProvider = "getBeneAddTestData")
	public void loginTest(String ssn) {
		homePage = loginPage.login(ssn , prop.getProperty("password"));  //prop.getProperty("username")
	}

	@AfterMethod
	public void  tearDown() {  
		driver.quit();
	}

}
