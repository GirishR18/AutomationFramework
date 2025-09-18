package com.cast.crm.generic.webdriverutility;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {

	public void toMaximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}


	public void waitForElementPresentToLoad(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void switchToWindowOnURL(WebDriver driver, String partialURL) {
		Set<String> set = driver.getWindowHandles();
		 for (String windowId : set) {
			 driver.switchTo().window(windowId);

			 String actualURL = driver.getCurrentUrl();
			 if(actualURL.contains(partialURL)) {
				 break;
			 }
		 }

	}

	public void switchToWindowOnTitle(WebDriver driver, String partialTitle) {
		Set<String> set = driver.getWindowHandles();
		 for (String windowId : set) {
			 driver.switchTo().window(windowId);

			 String actualURL = driver.getTitle();
			 if(actualURL.contains(partialTitle)) {
				 break;
			 }
		 }

	}

	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}

	public void switchToFrame(WebDriver driver, String nameID) {
		driver.switchTo().frame(nameID);
	}
	public void switchToFrame(WebDriver driver, WebElement element) {
		driver.switchTo().frame(element);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void switchToAlertAndCancel(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void selectByWebElement(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	public void selectByIndex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}

	public void mouseMovementOnElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).perform();
	}

	public void doubleClickElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element).perform();
	}

}
