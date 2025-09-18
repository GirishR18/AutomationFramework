package com.cast.crm.orgtest;

import org.testng.annotations.Test;

import com.cast.crm.generic.fileutility.ExcelUtility;
import com.comcast.crm.ObjectRepositoryUtility.CreateNewOrganizationPage;
import com.comcast.crm.ObjectRepositoryUtility.HomePage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationInformationPage;
import com.comcast.crm.ObjectRepositoryUtility.OrganizationPage;
import com.crm.generic.baseutility.BaseClass;

public class CreateOrganizationWithPhoneNumberTest_TC__03 extends BaseClass {

		@Test
		public void createOrganizationWithPhoneNumber() throws Throwable {

			int randomInt = jlib.getRandomNumber();

			ExcelUtility elib = new ExcelUtility();
			String orgName = elib.getDataFromExcelFile("Orgnization",7,2).toString()+randomInt;
			String phoneNum = elib.getDataFromExcelFile("Orgnization",7,3).toString();

			HomePage hp = new HomePage(driver);
			hp.getOrganizationLink().click();

			OrganizationPage op = new OrganizationPage(driver);
			op.getCreateOrganizationBtn().click();

			CreateNewOrganizationPage cnop = new CreateNewOrganizationPage(driver);
			cnop.createOrganizationWithPhone(orgName, phoneNum);

			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String actualphoneNumber = oip.getPhoneNumber().getText();

			if (actualphoneNumber.equals(phoneNum)) {
				System.out.println(phoneNum +" is Added ==> PASSED---");
			} else {
				System.out.println(phoneNum +" is not Added ==> FAILED");
			}

		}

	}





