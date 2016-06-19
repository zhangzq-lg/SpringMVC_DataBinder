package com.lg.gz.spring.common;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zzq_eason on 2016/6/19.
 */
public class MyDateConverter implements Converter<String, Date> {

	public Date convert(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return simpleDateFormat.parse(s);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

}
