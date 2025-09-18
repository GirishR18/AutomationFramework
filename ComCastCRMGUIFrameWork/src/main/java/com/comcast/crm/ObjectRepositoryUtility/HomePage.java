package com.comcast.crm.ObjectRepositoryUtility;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cast.crm.generic.webdriverutility.WebDriverUtility;

public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements( driver, this);

	}

	@FindBy(linkText = "Organizations")
	private WebElement organizationLink;

	@FindBy(linkText = "Contacts")
	private WebElement contactsLink;

	@FindBy(linkText = "Products")
	private WebElement productsLink;

	@FindBy(linkText = "More")
	private WebElement moreLink;

	@FindBy(linkText = "Campaigns")
	private WebElement campaignsLink;

	@FindBy(linkText = "Services")
	private WebElement servicesLink;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminImg;

	@FindBy(linkText = "Sign Out")
	private WebElement signoutLink;

	public WebElement getAdminImg() {
		return adminImg;
	}

	public WebElement getSignoutLink() {
		return signoutLink;
	}

	public WebElement getServicesLink() {
		return servicesLink;
	}

	public WebElement getOrganizationLink() {
		return organizationLink;
	}

	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getMoreLink() {
		return moreLink;
	}

	public WebElement getCampaignsLink() {
		return campaignsLink;
	}



	public void navigateTocampaignPage() {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.mouseMovementOnElement(driver, moreLink);
		campaignsLink.click();
	}

	public void navigateToServicesPage() {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.mouseMovementOnElement(driver, moreLink);
		servicesLink.click();
	}

	public void logout() {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.mouseMovementOnElement(driver, adminImg);
		signoutLink.click();
	}

	public void clickOnOrganizations() {
	    for (int i = 0; i < 2; i++) {
	        try {
	            driver.findElement(By.linkText("Organizations")).click();
	            break;
	        } catch (StaleElementReferenceException e) {
	            // retry
	        }
	    }
	}


}
