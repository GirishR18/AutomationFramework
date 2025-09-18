package practise.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ActivateSimRetryAnalyzerTest {

	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryAnalyzerImp.class)
	public void activateSim() {
		System.out.println("Execeute activateSim ");
		Assert.assertEquals("", "Login");
		System.out.println("Step1");
		System.out.println("Step2");
		System.out.println("Step3");
		System.out.println("Step4");
	}
}
