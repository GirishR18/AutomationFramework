package com.comcast.crm.ObjectRepositoryUtility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewOrganizationPage {

	WebDriver driver;

	public CreateNewOrganizationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement orgNameEdt;

	@FindBy(name = "industry")
	private WebElement industryDropDown;

	@FindBy(name = "accounttype")
	private WebElement typeDropDown;

	@FindBy(id ="phone")
	private WebElement phoneNumberEdt;

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;


	public WebElement getPhoneNumber() {
		return phoneNumberEdt;
	}

	// Central method to click the "Save" button
	private void clickFreshSaveBtn() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement freshSaveBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@title='Save [Alt+S]']")));
		freshSaveBtn.click();
	}

	// Unified internal method to create organization with optional industry and type
	private void createOrganizationInternal(String orgName, String industry, String type) {
		orgNameEdt.sendKeys(orgName);

		if (industry != null) {
			new Select(industryDropDown).selectByVisibleText(industry);
		}

		if (type != null) {
			new Select(typeDropDown).selectByVisibleText(type);
		}

		clickFreshSaveBtn();
	}

	// ✅ Overloaded 1: Only org name
	public void createOrganization(String orgName) {
		createOrganizationInternal(orgName, null, null);
	}

	// ✅ Overloaded 2: org name + industry
	public void createOrganization(String orgName, String industry) {
		createOrganizationInternal(orgName, industry, null);
	}

	// ✅ Overloaded 3: org name + type
	public void createOrganizationWithType(String orgName, String type) {
		createOrganizationInternal(orgName, null, type);
	}

	// ✅ Overloaded 4: org name + industry + type
	public void createOrganization(String orgName, String industry, String type) {
		createOrganizationInternal(orgName, industry, type);
	}

	// ✅ Overloaded 5: org name + phone number
	public void createOrganizationWithPhone(String orgName, String phoneNumber) {
		orgNameEdt.sendKeys(orgName);
		phoneNumberEdt.sendKeys(phoneNumber);
		clickFreshSaveBtn();
	}
}