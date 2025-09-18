package practise.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CreateContactWithDataProviderTest {

	@Test(dataProvider = "getData1")
	public void createContactWithDataProviderTest(String firstName, String lastName, String role) {
		System.out.println("first Name:"+ firstName + ", last name "+ lastName+ "role is "+ role);
	}

	@Test(dataProvider = "getData")
	public void createContactWithDataProviderTest(String firstName, String lastName) {
		System.out.println("first Name:"+ firstName + ", last name "+ lastName);
	}

	@DataProvider
	public Object[] [] getData() {
		Object [] [] objArr = new Object[3][2];
		objArr[0][0] = "Ram";
		objArr[0][1] = "shetty";

		objArr[1][0] = "Laxman";
		objArr[1][1] = "Sharma";

		objArr[2][0] = "Janaki";
		objArr[2][1] = "patel";
		return objArr;
	}

	@DataProvider
	public Object[] [] getData1() {
		Object [] [] objArr = new Object[3][3];
		objArr[0][0] = "Ram";
		objArr[0][1] = "shetty";
		objArr[0][2] ="role1";

		objArr[1][0] = "Laxman";
		objArr[1][1] = "Sharma";
		objArr[1][2] ="role2";

		objArr[2][0] = "Janaki";
		objArr[2][1] = "patel";
		objArr[2][2] ="role3";


		return objArr;
	}

}
