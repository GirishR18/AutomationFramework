package com.cast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random random = new Random();
		int randomNumber = random.nextInt(3000);
		return randomNumber;
	}

	public String getSystemDateYYYYMMDD() {
		Date dateObj = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String date = sdf.format(dateObj);
		return date;

	}

	public String getRequiredDateYYYYMMDD(int days) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requireddate = sdf.format(cal.getTime());
		return requireddate;

	}

}
