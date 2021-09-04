package com.gtpl.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.gtpl.qa.base.GTPLBase;

public class HomePage extends GTPLBase {
	
	@FindBy(xpath="//marquee[contains(text(),'Welcome To Manager')]")
	private WebElement managerPage;
	
	@FindBy(xpath="//li/a[text()='Manager']")
	private WebElement managerLink;
	
	@FindBy(xpath="//li/a[text()='New Customer']")
	private WebElement newCustomerLink;
	
	@FindBy(xpath="//li/a[text()='Edit Customer']")
	private WebElement editCustomerLink;
	
	@FindBy(xpath="//li/a[text()='Delete Customer']")
	private WebElement deleteCustomerLink;
	
	@FindBy(xpath="//li/a[text()='New Account']")
	private WebElement newAccountLink;
	
	@FindBy(xpath="//li/a[text()='Edit Account']")
	private WebElement editAccountLink;
	
	@FindBy(xpath="//li/a[text()='Delete Account']")
	private WebElement deleteAccountLink;
	
	@FindBy(xpath="//li/a[text()='Mini Statement']")
	private WebElement miniStatementLink;
	
	@FindBy(xpath="//li/a[text()='Customised Statement']")
	private WebElement customisedStatementLink;
	
	@FindBy(xpath="//li/a[text()='Log out']")
	private WebElement logoutLink;
	
	@FindBy(xpath="//h2[text()='Gtpl Bank']")
	private WebElement bankLogo;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	
	}
	
	public boolean validateManagerHomePage() {
		
		return managerPage.isDisplayed();
		
	}
	
	public boolean validateBankLogo() {
		return bankLogo.isDisplayed();
		
	}
	
	
	public NewCustomerPage createNewCustomer() {
		newCustomerLink.click();
		return new  NewCustomerPage();
	}
	/*
	 * public EditCustomerPage editExistingCustomer() { editCustomerLink.click();
	 * return new EditCustomerPage(); }
	 */
	
	/*
	 * public DeleteCustomerPage deleteExistingCustomer() {
	 * deleteCustomerLink.click(); return new DeleteCustomerPage(); }
	 * 
	 * public NewAccountPage createNewAccount() { newAccountLink.click(); return new
	 * NewAccountPage(); }
	 * 
	 * public EditAccountPage editExistingAccount() { editAccountLink.click();
	 * return new EditAccountPage(); }
	 * 
	 * 
	 * public DeleteAccountPage deleteExistingAccount() { deleteAccountLink.click();
	 * return new DeleteAccountPage(); }
	 * 
	 * public MiniStatementPage getMiniStatement() { miniStatementLink.click();
	 * return new MiniStatementPage(); }
	 */
	
	
	/*
	 * public CustomizedStatementPage getCustomizedStatement() {
	 * customisedStatementLink.click(); return new CustomizedStatementPage(); }
	 * 
	 * 
	 * public LoginPage logout() { logoutLink.click(); return new LoginPage(); }
	 */
	
	public void verifyAllLinksOnHomePage() {
		newCustomerLink.isDisplayed();
		editCustomerLink.isDisplayed();
		deleteCustomerLink.isDisplayed();
		newAccountLink.isDisplayed();
		editAccountLink.isDisplayed();
		deleteAccountLink.isDisplayed();
		miniStatementLink.isDisplayed();
		customisedStatementLink.isDisplayed();
		logoutLink.isDisplayed();
		
		
	}
	

}
