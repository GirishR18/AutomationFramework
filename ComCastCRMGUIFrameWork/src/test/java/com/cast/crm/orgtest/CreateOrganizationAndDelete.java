package com.cast.crm.orgtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.fileutility.FileUtility;
import com.cast.crm.generic.webdriverutility.JavaUtility;
import com.cast.crm.generic.webdriverutility.WebDriverUtility;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.LoginPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;

public class CreateOrganizationAndDelete {
	@Test
	public void createOrg() throws Throwable {

		FileUtility flib = new FileUtility();
		JavaUtility jlib = new JavaUtility();
		WebDriverUtility wlib = new WebDriverUtility();

		String BROWSER = flib.getDataFromPropertiesFile("browser");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("username");
		String PASSWORD = flib.getDataFromPropertiesFile("password");

		int randomInt = jlib.getRandomNumber();

		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelFile("Orgnization", 1, 2) + randomInt;

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		wlib.toMaximize(driver);
		wlib.waitForPageLoad(driver);
		driver.get(URL);
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		String headerEle = oip.getHeaderMsg().getText();
		if (headerEle.contains(orgName)) {
			System.out.println(orgName +" is Created ==> PASSED---");
		} else {
			System.out.println(orgName +" is not Created ==> FAILED");
		}

		String actualOrgName = oip.getOrgname().getText();
		if (actualOrgName.equals(orgName)) {
			System.out.println(orgName +" is Created ==> PASSED---");
		} else {
			System.out.println(orgName +" is not Created ==> FAILED");
		}

		hp.clickOnOrganizations();
		op.getSearchEdt().sendKeys(orgName);
		wlib.selectByWebElement(op.getSearchDD(), "Organization Name");
		op.getSearchBtn().click();
		driver.findElement(By.xpath("//a[.='" + orgName + "']/../../td[8]//a[.='del']")).click();

		wlib.switchToAlertAndAccept(driver);
		System.out.println("Organization deleted SuccessFully ----PASS");
		hp.logout();
		driver.quit();

	}

}
