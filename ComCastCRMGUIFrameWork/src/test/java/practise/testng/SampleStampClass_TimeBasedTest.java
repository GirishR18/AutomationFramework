package practise.testng;

import java.util.Date;

public class SampleStampClass_TimeBasedTest {
	public static void main(String[] args) {
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		System.out.println(time);

	}
	
}
