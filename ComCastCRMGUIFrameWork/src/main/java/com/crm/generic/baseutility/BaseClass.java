package com.crm.generic.baseutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cast.crm.generic.databaseutility.DatabaseUtility;
import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.cast.crm.generic.webdriverutility.JavaUtility;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;
import com.cast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;

public class BaseClass {

	public WebDriver driver = null;
	public DatabaseUtility dlib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public JavaUtility jlib = new JavaUtility();
	public ExcelUtility elib = new ExcelUtility();
	public WebDriverUtility wlib = new WebDriverUtility();
	//public static WebDriver sdriver;
	
	@BeforeSuite(alwaysRun = true)
	public void configBS() {
		System.out.println(" BS ");
		dlib.getDatabaseConnection();

	}

	// @Parameters("BROWSER")
	@BeforeClass(alwaysRun = true)
	public void configBC() throws Throwable {
		String BROWSER = flib.getDataFromPropertiesFile("browser");

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		//sdriver = driver;
		UtilityClassObject .setDriver(driver);

		System.out.println("DEBUG: driver after init = " + driver);
		System.out.println("Browser got Launched");
		wlib.toMaximize(driver); // webDriverUtility
		System.out.println("Browser got maximized");
		wlib.waitForPageLoad(driver); // webDriverUtility

	}

	@BeforeMethod(alwaysRun = true)
	public void configBM() throws Throwable {
		System.out.println("BM is execueted");
		System.out.println("DEBUG: Driver in configBM = " + driver); // 👈 Add this
		String URL = flib.getDataFromPropertiesFile("url");
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		// String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");
		lp.loginToApp(USERNAME, PASSWORD);
	}

	@AfterMethod(alwaysRun = true)
	public void configAM() {
		System.out.println("AM is execueted  ");
		HomePage hp = new HomePage(driver);
		hp.logout();
	}

	@AfterClass(alwaysRun = true)
	public void configAC() {
		System.out.println("Ac is execueted ");
		driver.quit();
	}

	@AfterSuite(alwaysRun = true)
	public void configAS() {
		System.out.println("AS is execueted ");
		dlib.closeDatabaseConnection();

	}

}
