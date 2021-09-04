package com.gtpl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.gtpl.qa.base.GTPLBase;
import com.gtpl.qa.pages.HomePage;
import com.gtpl.qa.pages.LoginPage;

public class HomePageTest extends GTPLBase {
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority = 1)
	public void validateHomePageTitle() {
		
		String homePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, "GTPL Bank Manager HomePage");
		
	}
	
	@Test(priority = 2)
	public void validateHomePageBankLogo() {
		boolean homePageLogo=homePage.validateBankLogo();
		Assert.assertEquals(true, homePageLogo);
	}
	
	@Test(priority = 3)
	public void verifyHomePage() {
	Assert.assertEquals(true, homePage.validateManagerHomePage());
	}
	
	@Test(priority = 4)
	public void verifyHomePageLinks() {
		homePage.verifyAllLinksOnHomePage();
	}
	
	@AfterMethod
	public void close() {
		tearDown();
	}

}
