package com.comcast.crm.listenerutility;

/**
 * @author Gir
 * 
 */
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;

public class ListenerImpementation implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public static ExtentReports report;
	// public ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report Configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");

		// High level configartion of - spark report config
		spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10-Pro");
		report.setSystemInfo("BROSWER", "Chrome-18");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report Back-UP");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">===START====");

		ExtentTest test = report.createTest(result.getMethod().getMethodName());
		UtilityClassObject.setTest(test);

		test.log(Status.INFO, result.getMethod().getMethodName() + "==>STARTED<====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">===END====");
		UtilityClassObject.getTest().log(Status.PASS, result.getMethod().getMethodName() + "==>COMPLETED<====");

	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		TakesScreenshot ts = (TakesScreenshot) UtilityClassObject.getDriver();
		String filePath = ts.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// UtilityClassObject.setTest(UtilityClassObject.getTest());
		UtilityClassObject.getTest().addScreenCaptureFromBase64String(filePath, testName + "_" + time);
		UtilityClassObject.getTest().log(Status.FAIL, result.getMethod().getMethodName() + "==>FAILED<====");

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">===SKIPPED====");

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">===Within Sucess Percent====");

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("=====>" + result.getMethod().getMethodName() + ">===TimeOut====");

	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Context Start");

	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Context end");
	}

}
