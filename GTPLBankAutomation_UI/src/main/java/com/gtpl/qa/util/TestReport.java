package com.gtpl.qa.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestReport {
		
		public static ExtentSparkReporter reporter;
		public static ExtentReports extent;
		public static ExtentTest test;
		
		public static ExtentReports getReport() {
			
			if(extent==null) {
				 extent=new ExtentReports();
			}
			else {
				
				return extent;
			}
			String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
			String repName = "test-report" + timestamp + ".html";
			reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\"+repName);
			reporter.config().setReportName("Automation test results");
			reporter.config().setDocumentTitle("Report");
			
			extent.setSystemInfo("Build", "124");
			extent.setSystemInfo("Tester", "Krishna");
			extent.setSystemInfo("Position", "TL");
			extent.attachReporter(reporter);
		return extent;		
			
	}
}
