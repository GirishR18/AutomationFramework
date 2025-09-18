package practise.testng;

import org.testng.annotations.Test;

public class ContactTest {

	@Test
	private void CreateContactTest() {
		System.out.println("Contact has been Created with HDFC");
	}

	@Test
	public void modifyContactTest() {
		System.out.println("Create Contact Icici");
		System.out.println("modifyContactTest has been done to ICICI");
	}
	@Test
	public void deleteContactTest() {
		System.out.println("Create Contact Icici");
		System.out.println("deleteContactTest has been Created with ICICI");
	}
}
