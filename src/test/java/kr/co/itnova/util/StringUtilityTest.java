package kr.co.itnova.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringUtilityTest {

	@Test
	public void testIsContain() {
		String[] code = {"A", "B", "C"};
		assertEquals(false, StringUtility.isContains("D",code));
	}
	
	@Test
	public void hintListTest() {
		String[] hints = {"Anna", "Amanda", "Brittany" };
		
		assertEquals("Anna", StringUtility.hintList("An", hints));
		assertEquals("No suggestion!", StringUtility.hintList("cc", hints));
		assertEquals("No suggestion!", StringUtility.hintList("", hints));
	}
}
