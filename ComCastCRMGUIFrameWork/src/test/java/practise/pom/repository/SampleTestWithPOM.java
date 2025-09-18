package practise.pom.repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class SampleTestWithPOM {

	@FindBy(name="user_name")
	WebElement elemenet1;

	@FindBy(name="user_password")
	WebElement elemenet2;


	//Auto Healing process @FindAll uses OR
	@FindAll({@FindBy (id="submitButton"), @FindBy(xpath = "//input[@type='submit']")})
	WebElement elemenet3;


	//@findbys uses And and it has to specify all conditions given findybys using @find by
//	@FindBys({@FindBy (id="submitButton"), @FindBy(xpath = "//input[@type='submit']")})
//	WebElement elemenet3;


	@Test
	public void sampleTest() {
		WebDriver driver =  new ChromeDriver();
		driver.get("http://localhost:8888/");

		SampleTestWithPOM s = PageFactory.initElements(driver, SampleTestWithPOM.class);
		s.elemenet1.sendKeys("admin");
		s.elemenet2.sendKeys("password");

		driver.navigate().refresh();
		s.elemenet1.sendKeys("admin");
		s.elemenet2.sendKeys("password");
		s.elemenet3.click();

	}


}
