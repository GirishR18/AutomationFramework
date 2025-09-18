package com.cast.crm.orgtest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

/**
 * 
 *@author Girish
 *This class will Create Organization with Industry,Type 
 *
 */
public class CreateOrganizationWithIndustryAndTypeTest_TC_02 extends BaseClass {

	
	@Test
	public void createOrganizationWithIndustryType() throws Throwable {

		int randomInt = jlib.getRandomNumber();

		String orgName = elib.getDataFromExcelFile("Orgnization", 4, 2).toString() + randomInt;
		String industry = elib.getDataFromExcelFile("Orgnization", 4, 3).toString();
		String type = elib.getDataFromExcelFile("Orgnization", 4, 4).toString();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName, industry, type);

		String actualIndustry = driver.findElement(By.id("dtlview_Industry")).getText();

		if (actualIndustry.equals(industry)) {
			System.out.println(industry + " is Created ==> PASSED---");
		} else {
			System.out.println(industry + " is not Created ==> FAILED");
		}

		String actualType = driver.findElement(By.id("dtlview_Type")).getText();
		if (actualType.equals(type)) {
			System.out.println(type + " is Created ==> PASS");
		} else {
			System.out.println(type + " information is not Created ==> FAIL");
		}

	}

}
