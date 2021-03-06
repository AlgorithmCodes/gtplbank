package com.gtpl.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.gtpl.qa.base.GTPLBase;
import com.gtpl.qa.pages.HomePage;
import com.gtpl.qa.pages.LoginPage;
import com.gtpl.qa.pages.NewCustomerPage;
import com.gtpl.qa.util.ReadExcel;

public class NewCustomerPageTest extends GTPLBase{
	LoginPage loginPage;
	HomePage homePage;
	NewCustomerPage newCustomerPage;
	
	public NewCustomerPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setup() {
		initialization();
		loginPage=new LoginPage();
		
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		newCustomerPage=homePage.createNewCustomer();
	}
	
	@Test(priority = 1)
	public void validateNewCustomerPageTitle() {
	String newCustomerPageTitle=	newCustomerPage.validateNewCustomerPageTitle();
	Assert.assertEquals("Gtpl Bank New Customer Entry Page", newCustomerPageTitle.trim());
		}
	
	@Test(priority=2)
	public void valiadateBankLogo() {
		boolean bankLogo=newCustomerPage.validateNewCustomerPageBankLogo();
		Assert.assertEquals(true, bankLogo);
	}
	
	@Test(priority = 3)
	public void validateNewCustomerPage() {
	Assert.assertEquals(true, newCustomerPage.validateNewCustomerPage());
	}
	
	
	@Test(dataProvider = "customerData",priority = 4)
	public void enterCustomerData(String custName,String custGender,String custDOB,String custAddress,
			String custCity,String custState,String custPin,String custPhone,String custEmail,String custPass) {
		
		String custDoBDay=custDOB.substring(0,2);
		String custDoBMonth=custDOB.substring(2,4);
		String custDoBYear=custDOB.substring(4);
		
		
		newCustomerPage.createNewCustomer(custName, custGender, custDoBDay, custDoBMonth, custDoBYear,
				custAddress, custCity, custState, custPin, custPhone, custEmail, custPass);
		
		
		
		
		
		
	}
	
	@AfterMethod
	public void close() {
		tearDown();
	}
	
	@DataProvider
	public String[][] customerData() {
		
		
		ReadExcel readExcel=new ReadExcel("B:\\project\\GTPLBankAutomation_UI\\src\\main\\java\\com\\gtpl\\qa\\testdata\\NewCustomerTestData.xlsx", "customerdata");
		int rowCount=readExcel.getRowCount();
		int colCount=readExcel.getColumnCount();
		
		String[][] data=new String[rowCount][colCount];
		
		for (int i =1; i <=rowCount; i++) {
			
			for (int j = 0; j <colCount ; j++) {
				
				
				data[i-1][j]=readExcel.getCellData(i, j);
				
			}
			
		}
		return data;
	}

}
