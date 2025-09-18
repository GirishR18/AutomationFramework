package practise.testng;

import org.testng.annotations.Test;

public class CreateOrderTest {

	@Test
	public void createOrderInCRM() {
		System.out.println("Order is being billed ===> 123");
		String str = null;

		System.out.println(str.equals("123"));
	}

	@Test(dependsOnMethods = "createOrderInCRM")
	public void billingOrderInCRM() {
		System.out.println("Order is being billed ===> 123");
	}

}
