package com.gtpl.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.gtpl.qa.util.TimeOuts;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GTPLBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public GTPLBase() {
		
		
		try {
			prop=new Properties();
			FileInputStream fis=new FileInputStream("B:\\project\\GTPLBankAutomation_UI\\src\\main\\java\\com\\gtpl\\qa\\config\\config.properties");
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void initialization() {
		
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}else {
			System.out.println("Bowser name is invalid");
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TimeOuts.PAGE_LOADOUT_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TimeOuts.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}
	
	
	
	public static void tearDown() {
		if(driver!=null) {
			driver.close();
			driver.quit();
		}
	}
	
	public static void getScreenCapture(String testName) {
		
		File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("B:\\project\\GTPLBankAutomation_UI\\screenshots\\"+testName+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
