package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {


	WebDriver driver;
	public OrganizationInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);

	}



	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Organization Name")
	private WebElement orgname;


	@FindBy(id = "dtlview_Phone")
	private WebElement phoneNumber;


	public WebElement getPhoneNumber() {
		return phoneNumber;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getOrgname() {
		return orgname;
	}



}
