package com.cast.crm.contacttest;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.comcast.crm.ObjectRepositoryUtility.ContactInfromationPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateContactWithOrgPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateContactWithOrganizationTest_TC__006 extends BaseClass {
	@Test
	public void createContactTestWithOrg() throws Throwable {

		int randomInt = jlib.getRandomNumber();

		String lastName = elib.getDataFromExcelFile("Contacts", 7, 2).toString() + randomInt;
		String orgName = elib.getDataFromExcelFile("Contacts", 7, 3).toString() + randomInt;

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
		if (actualLastName.equals(lastName)) {
			System.out.println(lastName + " is created==> PASS");
		} else {
			System.out.println(lastName + " is not Created ==> FAIL");
		}

		String actualOrgName = cip.getOrgName().getText();
		if (actualOrgName.equals(orgName)) {
			System.out.println(orgName + " is Selected  ==> PASS");
		} else {
			System.out.println(orgName + " is  not Selected ==> FAIL");
		}

	}

}
