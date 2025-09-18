package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewContactPage {

	WebDriver driver;

	public CreateNewContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	@FindBy(name = "support_start_date")
	private WebElement startDateEdt;

	@FindBy(name = "support_end_date")
	private WebElement endDateEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getStartDateEdt() {
		return startDateEdt;
	}

	public WebElement getEndDateEdt() {
		return endDateEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}


	public void createContact(String lastName) {
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	public void createContact(String lastName, String startDate, String endDate) {
		lastNameEdt.sendKeys(lastName);
		startDateEdt.clear();
		startDateEdt.sendKeys(startDate);
		endDateEdt.clear();
		endDateEdt.sendKeys(endDate);
		saveBtn.click();
	}


//	public void createContact(String lastName, String OrgName) {
//		lastNameEdt.sendKeys(lastName);
//
//		saveBtn.click();
//	}

}
