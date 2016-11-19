package edu.zxw.goods.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * @author		zxwtry
 * @email		zxwtry@qq.com
 * @file		CustomDateConverter.java
 * @date		2016年11月18日 下午4:10:01
 * @details		
 */
public class CustomDateConverter implements Converter<String, Date> {

	/**
	 * @method		convert (String s)
	 * @parameter	s：		字符串格式的日期  "yyyy-MM-dd HH:mm:ss"
	 * @return 		date:	返回 java.util.Date 格式的日期
	 * @details 	如果s格式不正确，返回null
	 */
	@Override
	public Date convert (String s) {
		Date date = null;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			date = simpleDateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
}
