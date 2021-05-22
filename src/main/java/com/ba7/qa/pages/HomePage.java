package com.ba7.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ba7.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//a[@href='SW/DBChannel' and contains(text(),'Pension')]")
	WebElement pensionTab;
	
	@FindBy(xpath ="//div[@class='panel-heading' and contains(text(),'Pension')]")
	WebElement pensionSnapshot;
	
	// Initializing the Page Objects

		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String validateHomePageTitle() {
			return driver.getTitle();
		}
		
		public boolean validatePensionTab() {
			return pensionTab.isDisplayed();
		}
		
		public boolean validatePensionSnapshot() {
			return pensionSnapshot.isDisplayed();
		}
		
		public PensionPage clickOnPensionTab() {
			pensionTab.click();
			return new PensionPage();
		}

}
