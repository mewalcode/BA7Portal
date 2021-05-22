package com.ba7.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ba7.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(id = "USERNAME")
	// CacheLookup will store the userlabel name in cache mem
	@CacheLookup
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(name = "log")
	WebElement loginBtn;

	@FindBy(xpath = "//h3[@class='top-heading']")
	WebElement logo;

	// likewise we can add other webelement

	// Initializing the Page Objects

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Actions:
	public String validateLoginPageTittle() {
		return driver.getTitle();
	}

	public boolean validateLogoTest() {
		return logo.isDisplayed();
	}

	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();

		return new HomePage();

	}

}
