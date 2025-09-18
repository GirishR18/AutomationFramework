package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfromationPage {

	WebDriver driver;
	public ContactInfromationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);

	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement headerMsg;

	@FindBy(id = "dtlview_Last Name")
	private WebElement lastName;


	@FindBy(id = "dtlview_Support Start Date")
	private WebElement startDate;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement endDate;

	@FindBy(xpath = "//td[@id='mouseArea_Organization Name']//a")
	private WebElement OrgName;

	public WebElement getOrgName() {
		return OrgName;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getLastname() {
		return lastName;
	}

	public WebElement getStartDate() {
		return startDate;
	}

	public WebElement getEndDate() {
		return endDate;
	}

}
