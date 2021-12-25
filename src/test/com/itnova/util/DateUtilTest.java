package com.itnova.util;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateUtilTest {

	@Test
	public void getTimeTest() throws ParseException {
		SimpleDateFormat f = new SimpleDateFormat("HHmmss");
		Date t = f.parse("161250");
		assertEquals("161250", DateUtil.getTime(t));
	}
	
	@Test
	public void getTodayTest() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		assertEquals(f.format(new Date()), DateUtil.getToday());
	}
	
	@Test
	public void getMonthTest() {
		SimpleDateFormat f = new SimpleDateFormat("yyyyMM");
		assertEquals(f.format(new Date()), DateUtil.getMonth());
	}
}
