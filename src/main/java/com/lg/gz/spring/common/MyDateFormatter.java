package com.lg.gz.spring.common;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by zzq_eason on 2016/6/19.
 */
public class MyDateFormatter implements Formatter<Date> {

	public Date parse(String s, Locale locale) throws ParseException {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		return simpleDateFormat.parse(s);
	}

	public String print(Date date, Locale locale) {
		return null;
	}
}
