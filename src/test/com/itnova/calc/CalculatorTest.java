package com.itnova.calc;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {
	
	private Calculator calc;

	@Test
	public void test_add() {
		calc = new CalculatorImpl();
		assertNotNull("calc should be not null", calc);
		assertEquals(101, calc.add(23,78));
	}
}
