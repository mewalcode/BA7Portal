package com.ba7.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.ba7.qa.base.TestBase;
import com.ba7.qa.util.TestUtil;

public class BeneficiariesPage extends TestBase {

	@FindBy(xpath = "//input[@type='button' and @value='Make changes']")
	WebElement makeChanges;

	@FindBy(xpath = "//button[@class='btn btn-primary btn-xs']")
	WebElement makeAnotherBene;

	// if there are more "" than xpath ="//div[@span=\"abc\"]"
	@FindBy(xpath = "//select[@data-bind=\"options: Decode, optionsText: 'Value', optionsValue: 'Key', optionsCaption: 'Please select', value: Value, hasFocus: IsSelected\"]")
	WebElement addDropDown;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[1]")
	WebElement firstName;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[3]")
	WebElement lastName;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[4]")
	WebElement ssn;

	@FindBy(xpath = "//div[@data-bind=\"dateTimePicker: Value, dateTimePickerOptions: widgetOptions(), attr: { type: inputType(), placeholder: placeholder() }\"]//input[@class]")
	WebElement birthDate;

	@FindBy(xpath = "(//select[@data-bind=\"options: Decode, optionsText: 'Value', optionsValue: 'Key', optionsCaption: 'Please select', value: Value, hasFocus: IsSelected\"])[2]")
	WebElement genderDropDown;

	@FindBy(xpath = "(//select[@data-bind=\"options: Decode, optionsText: 'Value', optionsValue: 'Key', optionsCaption: 'Please select', value: Value, hasFocus: IsSelected\"])[3]")
	WebElement countryDropdown;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[5]")
	WebElement address;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[8]")
	WebElement city;

	@FindBy(xpath = "(//select[@data-bind=\"options: Decode, optionsText: 'Value', optionsValue: 'Key', optionsCaption: 'Please select', value: Value, hasFocus: IsSelected\"])[4]")
	WebElement stateDropdown;

	@FindBy(xpath = "(//input[@data-bind=\"attr: { type: inputType(), placeholder: placeholder(), autocomplete: inputAutoComplete() }, textInput: Value, hasFocus: IsSelected\"])[9]")
	WebElement zipCode;

	@FindBy(xpath = "//button[@data-bind=\"visible: bene.UpdateAllowed, click: function () { save(); }, disable: saveDisabled()\"]")
	WebElement continueButton;

	@FindBy(xpath = "/html/body/div[5]/div/div/div[3]/div/div[1]/button")
	WebElement useSuggBun;

	@FindBy(xpath = "//button[@class=\"btn btn-primary\"]")
	WebElement save;
	
	@FindBy(xpath = "(//button[@data-bind=\"click: function () { $parent.selectOption($parent.getButtonValue($data)); }, text: $parent.getButtonText($data), css: $parent.getButtonClass($index)\"])[1]")
	WebElement yes;
	
	
	// Initializing the Page objects

	public BeneficiariesPage() {
		PageFactory.initElements(driver, this);
	}

	public void addBeneficiary(String addDD, String fName, String lName, String sn, String birth, String genderDD,
			String countryDD, String add, String c, String stDD, String zip) {

		makeChanges.click();
		makeAnotherBene.click();
		Select sta = new Select(addDropDown);
		sta.selectByVisibleText(addDD);
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		ssn.sendKeys(sn);
		birthDate.sendKeys(birth);
		Select ge = new Select(genderDropDown);
		ge.selectByVisibleText(genderDD);
		Select con = new Select(countryDropdown);
		con.selectByVisibleText(countryDD);
		address.sendKeys(add);
		city.sendKeys(c);
		Select st = new Select(stateDropdown);
		st.selectByValue(stDD);
		zipCode.sendKeys(zip);
		continueButton.click();
		useSuggBun.click();
		TestUtil.ByVisibleElement(save);
		save.click();
//		yes.click();

	}

}
