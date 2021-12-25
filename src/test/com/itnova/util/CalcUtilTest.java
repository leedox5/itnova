package com.itnova.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalcUtilTest {

	@Test
	public void test_getCompleteRate() {
		assertEquals(97.3, CalcUtil.getCompleteRate(4144,4879,619),0.01);
		assertEquals("97.3", CalcUtil.getCompleteRateStr(4144, 4879, 619));
	}
}
