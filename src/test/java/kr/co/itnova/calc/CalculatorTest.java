package kr.co.itnova.calc;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.*;

@RunWith(JUnitParamsRunner.class)
public class CalculatorTest {

	private Calculator calc;
	@Before
    public void beforeTest() {
		calc = new CalculatorImpl();
	}

	private static Object[] setParams() {
		return new Object[] {
			new Object[] { 100, 100, 200},
			new Object[] {  23,  78, 101}
		};
	}
	@Test
	@Parameters( method = "setParams")
	public void addTest(int a, int b, int expected) {
		assertThat(calc.add(a, b)).as("합은 %d 이어야 한다.", expected).isEqualTo(expected);
	}
}
