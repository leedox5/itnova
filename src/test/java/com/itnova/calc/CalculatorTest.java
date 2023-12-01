package com.itnova.calc;

import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
	
	private Calculator calc;

	@Test
	public void test_add() {
		calc = new CalculatorImpl();
		assertThat(calc).isNotNull();
		assertThat(calc.add(23, 78)).as("���� 100�̾�� �Ѵ�.").isEqualTo(101);
	}
}
