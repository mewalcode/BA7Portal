package com.ba7.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.ba7.qa.base.TestBase;
import com.ba7.qa.pages.BeneficiariesPage;
import com.ba7.qa.pages.HomePage;
import com.ba7.qa.pages.LoginPage;
import com.ba7.qa.pages.PensionPage;
import com.ba7.qa.util.TestUtil;

public class BeneficiaryPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	PensionPage pensionPage;
	BeneficiariesPage beneficiariesPage;
	
	static String sheetName = "BeneDesignationAdd";

	public BeneficiaryPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		pensionPage = homePage.clickOnPensionTab();
		beneficiariesPage = pensionPage.beneficaryTabCLick();

	}
	
	@DataProvider
	public static Object[][] getBeneAddTestData() {
		Object data[][] = TestUtil.getTestData(sheetName);
		return data;
	} 
	
	@Test (priority = 1, dataProvider = "getBeneAddTestData")
	public void addBeneTest(String addDD, String fName, String lName, String sn, String birth, String genderDD,
			String countryDD, String add, String c, String stDD, String zip) {
		beneficiariesPage.addBeneficiary(addDD,fName,lName,sn,birth,genderDD,countryDD,add,c,stDD,zip);
		
	}
	
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}
//	
	
	

}
