package practise.testng;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.generic.baseutility.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImpementation.class)
public class InvoiceTestListener extends BaseClass {
	
	@Test
	public void creatInvoiceTest() {
		System.out.println("Execute creatInvoiceTest ");
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	
	public void creatInvoiceTestWithContact() {
		System.out.println("Execute creatInvoiceTestWithContact ");
		String actTitle = driver.getTitle();
		
		Assert.assertEquals(actTitle, "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
//	public void onTestFailure(ITestResult result) {
//		String testName = result.getMethod().getMethodName();
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File src = ts.getScreenshotAs(OutputType.FILE);
//		
//		try {
//			FileHandler.copy(src, new File("./screenshot/"+testName+""+".png"));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
