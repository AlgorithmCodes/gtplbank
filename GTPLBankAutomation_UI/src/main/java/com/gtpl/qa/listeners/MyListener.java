package com.gtpl.qa.listeners;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.gtpl.qa.base.GTPLBase;
import com.gtpl.qa.util.TestReport;


public class MyListener extends TestReport implements ITestListener {
	
	
public void onTestStart(ITestResult result) {
		
		getReport();
		test = extent.createTest(result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		
		test.pass(MarkupHelper.createLabel(result.getName() + " Test is passed", ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		GTPLBase.getScreenCapture(result.getName());
		
		test.addScreenCaptureFromPath("B:\\project\\GTPLBankAutomation_UI\\screenshots" + result.getName()+".png");
		test.fail(MarkupHelper.createLabel(result.getName() + " Test is failed", ExtentColor.RED));
	}

	public void onTestSkipped(ITestResult result) {
		test.skip(MarkupHelper.createLabel(result.getName() + " Test is skipped", ExtentColor.YELLOW));
	}
	
	public void onFinish(ITestContext context) {
		
		extent.flush();
	}
	
	
	

}
