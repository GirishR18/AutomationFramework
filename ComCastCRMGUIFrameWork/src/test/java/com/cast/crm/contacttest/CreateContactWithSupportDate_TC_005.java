package com.cast.crm.contacttest;

import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.ObjectRepositoryUtility.ContactInfromationPage;
import com.comcast.crm.ObjectRepositoryUtility.ContactPage;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewContactPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.crm.generic.baseutility.BaseClass;

public class CreateContactWithSupportDate_TC_005 extends BaseClass {
	@Test
	public void createContactTest() throws Throwable {

		int randomInt = jlib.getRandomNumber();

		ExcelUtility elib = new ExcelUtility();
		String lastName = elib.getDataFromExcelFile("Contacts", 4, 2).toString() + randomInt;

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

		String actualStartDate = cip.getStartDate().getText();
		if (actualStartDate.equals(startdateRequired)) {
			System.out.println(startdateRequired + " is ==> PASS");
		} else {
			System.out.println(startdateRequired + " is ==> FAIL");
		}

		String actualEndDate = cip.getEndDate().getText();
		if (actualEndDate.equals(endDateRequired)) {
			System.out.println(endDateRequired + " is ==> PASS");
		} else {
			System.out.println(startdateRequired + " is ==> FAIL");
		}
	}

}
