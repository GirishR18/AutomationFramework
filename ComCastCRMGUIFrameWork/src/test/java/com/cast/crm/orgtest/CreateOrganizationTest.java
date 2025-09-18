package com.cast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.cast.crm.generic.fileutility.ExcelUtility;
import com.cast.crm.generic.webdriverutility.UtilityClassObject;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImpementation.class)
public class CreateOrganizationTest extends BaseClass {

	// Tc _01 CreateOrganizationTest_TC__01
	@Test(groups = "smokeTest")
	public void createOrgTest() throws Throwable {
		
		//UtilityClassObject.getTest().log(Status.INFO,"read Data from Excel");
		//read test script data from excel file
		String orgName = elib.getDataFromExcelFile("Orgnization", 1, 2) + jlib.getRandomNumber();
		
		//step 2: navigate to org module
		UtilityClassObject.getTest().log(Status.INFO,"Navigate to Org Page");
		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		//step 3 click create new org button
		UtilityClassObject.getTest().log(Status.INFO,"Navigate create new Org Page");
		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();
		
		//step 4 enter all the details & create new  org
		UtilityClassObject.getTest().log(Status.INFO,"create  new  Org ");
		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);
		
		UtilityClassObject.getTest().log(Status.INFO,orgName+" Is created");

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);

		//verify header msg and expected result
		String headerEle = oip.getHeaderMsg().getText();
		boolean status = headerEle.contains(orgName);
		Assert.assertEquals(status, true);

		String actualOrgName = oip.getOrgname().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualOrgName, orgName);
		soft.assertAll();
	}

	// Tc _02 CreateOrganizationWithIndustryAndTypeTest_TC_02
	@Test(groups = "regressionTest")
	public void createOrganizationWithIndustryType() throws Throwable {
		String orgName = elib.getDataFromExcelFile("Orgnization", 4, 2).toString() + jlib.getRandomNumber();
		String industry = elib.getDataFromExcelFile("Orgnization", 4, 3).toString();
		String type = elib.getDataFromExcelFile("Orgnization", 4, 4).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, industry, type);

		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualIndustry, industry);
		soft.assertAll();

		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		// SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualType, type);
		soft.assertAll();

	}

	// Tc 03 CreateOrganizationWithIndustryAndTypeTest_TC_02

	@Test(groups = "regressionTest")
	public void createOrganizationWithPhoneNumber() throws Throwable {

		ExcelUtility elib = new ExcelUtility();
		String orgName = elib.getDataFromExcelFile("Orgnization", 7, 2).toString() + jlib.getRandomNumber();
		String phoneNum = elib.getDataFromExcelFile("Orgnization", 7, 3).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganizationWithPhone(orgName, phoneNum);

		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String actualphoneNumber = oip.getPhoneNumber().getText();
		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualphoneNumber, phoneNum);
		soft.assertAll();

	}

}
