package com.ba7.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ba7.qa.base.TestBase;

public class PensionPage extends TestBase {

	@FindBy(xpath = "//ul[@class='nav nav-tabs DBchannel-tabs hidden-sm hidden-xs']//a[text()='Overview']") 
	WebElement overview;

	@FindBy(xpath = "//ul[@class='nav nav-tabs DBchannel-tabs hidden-sm hidden-xs']//a[text()='Beneficiaries']")
	WebElement beneficiariesTab;

	// Initializing the Page Objects

	public PensionPage() {
		PageFactory.initElements(driver, this);
	}

	public Boolean validateOverview() {
		return overview.isDisplayed();

	}

	public String validatePensionPageTitle() {
		return driver.getTitle();
	}

	public BeneficiariesPage beneficaryTabCLick() {
		beneficiariesTab.click();
		return new BeneficiariesPage();
	}

}
