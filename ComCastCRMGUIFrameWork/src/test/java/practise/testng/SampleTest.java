package practise.testng;

import org.testng.annotations.Test;

public class SampleTest {


	@Test
	private void CreateContactTest() {
		System.out.println("Contact has been Created");
	}

	@Test
	public void modifyContactTest() {
		System.out.println("modifyContactTest has been done");
	}
	@Test
	public void CreateContactWithMobileNumberTest() {
		System.out.println("CreateContactWithMobileNumberTest has been Created");
	}
}
