package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactWithOrgPage {

	WebDriver driver;

	public CreateContactWithOrgPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search")
	private WebElement searchBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgIcon;


	@FindBy(id = "search_txt")
	private WebElement searchEdt;


	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getOrgIcon() {
		return orgIcon;
	}

	public WebElement getSearchEdt() {
		return searchEdt;
	}


}
