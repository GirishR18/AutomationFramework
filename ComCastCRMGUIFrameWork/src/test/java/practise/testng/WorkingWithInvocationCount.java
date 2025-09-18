package practise.testng;

import org.testng.annotations.Test;

public class WorkingWithInvocationCount {


	@Test(invocationCount =  10)
	public void createOrderInCRM() {
		System.out.println("Order is being created ===> 123");
	}
}
