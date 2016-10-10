package edu.zxw.grid.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringHelper {
	/**
	 * 将字符串形式的日期转换为java.util.Date类型
	 * @param textDate
	 * @return date
	 */
	public static Date stringConvertDate(String textDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = format.parse(textDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
}
