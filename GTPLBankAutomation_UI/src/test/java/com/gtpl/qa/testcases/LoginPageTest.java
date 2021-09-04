package com.gtpl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gtpl.qa.base.GTPLBase;
import com.gtpl.qa.pages.LoginPage;

public class LoginPageTest extends GTPLBase{
	
	LoginPage loginPage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void validateTitle() {
		
		String title=loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "GTPL Bank Home Page");
		
	}
	
	@Test(priority = 2)
	public void validateBankLogo() {
		boolean logoIsthere=loginPage.validateBankLogo();
		Assert.assertEquals(true, logoIsthere);
	}
	
	@Test(priority=3)
	public void checkingLoginPageWithValidCredentials() throws InterruptedException {
		System.out.println(prop.getProperty("username"));
		loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	
	@AfterMethod
	public void close() {
		tearDown();
	}
	

}
