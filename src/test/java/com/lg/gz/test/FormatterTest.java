package com.lg.gz.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.format.Formatter;
import org.springframework.format.number.CurrencyFormatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.util.Locale;

/**
 * Created by zzq_eason on 2016/6/18.
 */
public class FormatterTest {

	@Test
	public void test01() throws ParseException {
		/*
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2);//保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING);//舍入模式（ceilling表示四舍五入）
		//1、将带货币符号的字符串“$123.125”转换为BigDecimal("123.00")
		Assert.assertEquals(new BigDecimal("123.13"), currencyFormatter.parse("$123.125", Locale.US));
		Formatter
		*/

		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2); // 保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING); // 含入模式（ceiling表示四舍五入）
		// 将2356.255与"$2356.2689"进行断语比较，将"$2356.2689"转换成2356.255
		Assert.assertEquals(new BigDecimal("2356.255"), currencyFormatter.parse("$2356.26", Locale.US));
	}

	@Test
	public void test02() throws ParseException {
		CurrencyFormatter currencyFormatter = new CurrencyFormatter();
		currencyFormatter.setFractionDigits(2); // 保留小数点后几位
		currencyFormatter.setRoundingMode(RoundingMode.CEILING); // 含入模式（ceiling表示四舍五入）
		// 将2356.255与"$235.2689"进行断语比较，将2356.255转换成"$235.2689"
		Assert.assertEquals("$235.00", currencyFormatter.print(new BigDecimal("235"), Locale.US));
		/*Assert.assertEquals("$123.00", currencyFormatter.print(new BigDecimal("123"), Locale.US));*/
	}

}
