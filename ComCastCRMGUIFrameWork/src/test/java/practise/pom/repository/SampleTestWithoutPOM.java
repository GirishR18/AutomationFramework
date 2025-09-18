package practise.pom.repository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SampleTestWithoutPOM {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		WebElement element1 = driver.findElement(By.name("user_name"));
		WebElement element2 = driver.findElement(By.name("user_password"));
		WebElement element3 = driver.findElement(By.id("submitButton"));
		element1.sendKeys("admin");
		element2.sendKeys("password");

		driver.navigate().refresh();
		//StaleElementRefereceException
		element1.sendKeys("admin");
		element2.sendKeys("password");
		element3.click();
	}

}
