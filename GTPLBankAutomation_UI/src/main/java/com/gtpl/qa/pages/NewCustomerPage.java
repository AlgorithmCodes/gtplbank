package com.gtpl.qa.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gtpl.qa.base.GTPLBase;

public class NewCustomerPage extends GTPLBase {

	@FindBy(name = "name")
	private WebElement txtNewCustomerName;

	@FindBy(xpath = "//td/input[@type='radio']")
	private List<WebElement> radioNewCustomerGender;

	@FindBy(id = "dob")
	private WebElement txtNewCustomerDOBDay;
	@FindBy(id = "dob")
	private WebElement txtNewCustomerDOBMonth;
	@FindBy(id = "dob")
	private WebElement txtNewCustomerDOBYear;

	@FindBy(name = "addr")
	private WebElement txtNewCustomerAddress;

	@FindBy(name = "city")
	private WebElement txtNewCustomerCity;

	@FindBy(name = "state")
	private WebElement txtNewCustomerState;

	@FindBy(name = "pinno")
	private WebElement txtNewCustomerPinCode;

	@FindBy(name = "telephoneno")
	private WebElement txtNewCustomerPhone;

	@FindBy(name = "emailid")
	private WebElement txtNewCustomerEmail;
	@FindBy(name = "password")
	private WebElement txtNewCustomerPassword;

	@FindBy(name = "sub")
	private WebElement txtNewCustomerSubmit;
	@FindBy(name = "res")
	private WebElement txtNewCustomerReset;

	@FindBy(xpath = "//h2[text()='Gtpl Bank']")
	private WebElement newCustomerPageBankLogo;

	@FindBy(xpath = "//td/p[text()='Add New Customer']")
	private WebElement addNewCustomerPage;

	public NewCustomerPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateNewCustomerPageTitle() {
		return driver.getTitle();
	}

	public boolean validateNewCustomerPageBankLogo() {
		return newCustomerPageBankLogo.isDisplayed();
	}

	public boolean validateNewCustomerPage() {
		return addNewCustomerPage.isDisplayed();
	}

	public void createNewCustomer(String custName, String custGender, String custDOBDay, String custDOBMonth,
			String custDOBYear, String custAddress, String custCity, String custState, String custPin, String custPhone,
			String custEmail, String custPass) {

		txtNewCustomerName.sendKeys(custName);

		for (int i = 0; i < radioNewCustomerGender.size(); i++) {
			if (custGender.equals("male")) {
				radioNewCustomerGender.get(i).click();

			} else {
				radioNewCustomerGender.get(i).click();

			}

		}

		txtNewCustomerDOBDay.sendKeys(custDOBDay);
		txtNewCustomerDOBMonth.sendKeys(custDOBMonth);
		txtNewCustomerDOBYear.sendKeys(custDOBYear);
		txtNewCustomerAddress.sendKeys(custAddress);
		txtNewCustomerCity.sendKeys(custCity);
		txtNewCustomerState.sendKeys(custState);
		txtNewCustomerPinCode.sendKeys(custPin);
		txtNewCustomerPhone.sendKeys(custPhone);
		txtNewCustomerEmail.sendKeys(custEmail);
		txtNewCustomerPassword.sendKeys(custPass);
		txtNewCustomerSubmit.click();

	}

}
