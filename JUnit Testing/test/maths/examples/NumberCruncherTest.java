package maths.examples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumberCruncherTest {
	
	//test data
	int num1, num2, num3;
	NumberCruncher numberCruncher;

	@BeforeEach
	void setUp() throws Exception {
		num1 = 4;
		num2 = 6;
		num3 = -3;
		numberCruncher = new NumberCruncher();
	}

	@Test
	void testAddNumberIntInt() {
		int expected = 10;
		int actual = numberCruncher.addNumber(num1, num2);
		assertEquals(expected, actual);
	}

	@Test
	void testAddNumberIntIntInt() {
		int expected = 7;
		int actual = numberCruncher.addNumber(num1, num2, num3);
		assertEquals(expected, actual);
	}
	
	@Test
	void testMultiply() {
		int expected = 24;
		int actual = numberCruncher.multiplyNumbers(num1, num2);
		assertEquals(expected, actual);
	}
	
	@Test
	void testDivNumbers() {
		double expected = 5;
		double actual = numberCruncher.divNumbers(10, 2);
		assertEquals(expected, actual,0.0001);
	}
	
	@Test
	void testDivByZeroExp() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
		numberCruncher.divNumbers(10, 0);
		});
		
		String expectedMessage = "Cant divide by zero";
		assertEquals(expectedMessage, exp.getMessage());
	}

}
