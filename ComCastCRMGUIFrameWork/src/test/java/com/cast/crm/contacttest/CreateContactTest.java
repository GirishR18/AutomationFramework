package com.cast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.ObjectRepositoryUtility.ContactInfromationPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateContactWithOrgPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

/**
 * @author Girish
 * 
 */

public class CreateContactTest extends BaseClass {

	// Tc 04 createContactTest
	@Test(groups = "smokeTest")
	public void createContactTest() throws Throwable {
		// System.out.println("🔥 Inside createContactTest method");
		String lastName = elib.getDataFromExcelFile("Contacts", 1, 2).toString() + jlib.getRandomNumber();
		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName);

		ContactInfromationPage cip = new ContactInfromationPage(driver);
		String actualHeader = cip.getHeaderMsg().getText();
		boolean statusHeader = actualHeader.contains(lastName);
		Assert.assertEquals(statusHeader, true);
		String actualLastName = cip.getLastname().getText();
		boolean statusOrgName = actualLastName.equals(lastName);
		Assert.assertEquals(statusOrgName, true);

	}

	// Tc 05 createContactTestWithSupportDate

	@Test(groups = "regressionTest")
	public void createContactTestWithDate() throws Throwable {

		String lastName = elib.getDataFromExcelFile("Contacts", 4, 2).toString() + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getContactsLink().click();

		ContactPage cp = new ContactPage(driver);
		cp.getCreateContactBtn().click();

		// Handle Support Dates
		String startdateRequired = jlib.getSystemDateYYYYMMDD();
		String endDateRequired = jlib.getRequiredDateYYYYMMDD(30);

		CreateNewContactPage cncp = new CreateNewContactPage(driver);
		cncp.createContact(lastName, startdateRequired, endDateRequired);

		ContactInfromationPage cip = new ContactInfromationPage(driver);

		SoftAssert soft = new SoftAssert();
		String actualStartDate = cip.getStartDate().getText();
		soft.assertEquals(actualStartDate, startdateRequired);
		String actualEndDate = cip.getEndDate().getText();

		soft.assertEquals(actualEndDate, endDateRequired);

		soft.assertAll();

	}

	// tc 06createContactTestWithOrg

	@Test(groups = "regressionTest")
	public void createContactTestWithOrg() throws Throwable {

		String lastName = elib.getDataFromExcelFile("Contacts", 7, 2).toString() + jlib.getRandomNumber();
		String orgName = elib.getDataFromExcelFile("Contacts", 7, 3).toString() + jlib.getRandomNumber();

		HomePage hp = new HomePage(driver);
		hp.getOrganizationLink().click();

		OrganizationPage op = new OrganizationPage(driver);
		op.getCreateOrganizationBtn().click();

		CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
		cnop.createOrganization(orgName);

		ContactPage cp = new ContactPage(driver);
		ContactInfromationPage cip = new ContactInfromationPage(driver);
		CreateNewContactPage cncp = new CreateNewContactPage(driver);

		// Go to Contacts (re-locate element freshly to avoid
		// StaleElementReferenceException)
		try {
			hp.getContactsLink().click();
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			// Retry once
			hp.getContactsLink().click();
		}

		//wlib.waitForElementPresentToLoad(driver, hp.getContactsLink());

		cp.getCreateContactBtn().click();
		cncp.getLastNameEdt().sendKeys(lastName);
		CreateContactWithOrgPage ccwop = new CreateContactWithOrgPage(driver);
		ccwop.getOrgIcon().click();
		// switching the winodw
		wlib.switchToWindowOnURL(driver, "module=Accounts");

		ccwop.getSearchEdt().sendKeys(orgName);
		ccwop.getSearchBtn().click();
		driver.findElement(By.xpath("//a[.='" + orgName + "']")).click();
		wlib.switchToWindowOnURL(driver, "Contacts&action");
		cncp.getSaveBtn().click();

		String actualLastName = cip.getLastname().getText();
		String actualOrgName = cip.getOrgName().getText();

		SoftAssert soft = new SoftAssert();
		soft.assertEquals(actualLastName, lastName);
		soft.assertEquals(actualOrgName, orgName);
		soft.assertAll();

	}

}
