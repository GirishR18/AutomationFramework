package practise.testng;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class SampleReportTest {

	ExtentReports report;

	@BeforeSuite
	public void configBS() {
		// High level configartion of - spark report config
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Result");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);

		// add Env information and create test

		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-10-Pro");
		report.setSystemInfo("BROSWER", "Chrome-18");
	}

	@AfterSuite
	public void configAS() {
		report.flush();

	}

	@Test
	public void createContactTest() {

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888");
		TakesScreenshot edriver = (TakesScreenshot) driver;
		String filePath = edriver.getScreenshotAs(OutputType.BASE64);
		
		ExtentTest test = report.createTest("createContact");

		test.log(Status.INFO, "Login To app");
		test.log(Status.INFO, "navigate to contact page");
		test.log(Status.INFO, "create contact");
		if ("HDFC".equals("HFC")) {
			test.log(Status.PASS, "Contact is Created PASS");
		} else {
			test.addScreenCaptureFromBase64String(filePath,"ErrorFile");
		}
		driver.close();
		
	}
	
//	@Test
//	public void createContactWithOrgTest() {
//
//		ExtentTest test = report.createTest("createContactWithOrgTest");
//
//		test.log(Status.INFO, "Login To app");
//		test.log(Status.INFO, "navigate to contact page");
//		test.log(Status.INFO, "create contact");
//		if ("HDFC".equals("HDFC")) {
//			test.log(Status.PASS, "Contact is Created PASS");
//		} else {
//			test.log(Status.FAIL, "contact not created ");
//		}
//		
//	}
//	
//	@Test
//	public void createContactWithPhoneNumTest() {
//
//		ExtentTest test = report.createTest("createContactWithPhoneNumTest");
//
//		test.log(Status.INFO, "Login To app");
//		test.log(Status.INFO, "navigate to contact page");
//		test.log(Status.INFO, "create contact");
//		if ("HDFC".equals("HDFC")) {
//			test.log(Status.PASS, "Contact is Created PASS");
//		} else {
//			test.log(Status.FAIL, "contact not created ");
//		}
//		
//	}
}
