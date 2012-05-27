package test_util;

import java.text.DateFormat;
import java.util.Date;

public class Time {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = DateFormat.getDateTimeInstance().format(new Date());
		System.out.println(str);
	}

}
