package com.realpage.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Stack;

import org.junit.jupiter.api.Test;

class TestCalculatorOperations {

	private static Stack<Double> getExampleStack() {

		Stack<Double> stack = new Stack<>();

		stack.push(-22.44);
		stack.push(1.0);
		stack.push(5.55555);
		stack.push(0.0);
		stack.push(-3.33333);

		return stack;
	}

	// --------------------------------------------------
	// Addition

	@Test
	void testAddParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.add(stack);
			fail("Cannot add with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.add(stack);
			fail("Cannot add with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.add(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testAdd() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.add(stack);
		assertEquals(-3.33333, (double) stack.peek());

		CalculatorOperations.add(stack);
		assertEquals(2.22222, (double) stack.peek());

		CalculatorOperations.add(stack);
		assertEquals(3.22222, (double) stack.peek());

		CalculatorOperations.add(stack);
		assertEquals(-19.21778, (double) stack.peek());

	}

	// --------------------------------------------------
	// Subtraction

	@Test
	void testSubtractParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.subtract(stack);
			fail("Cannot subtract with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.subtract(stack);
			fail("Cannot subtract with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.subtract(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testSubtract() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.subtract(stack);
		assertEquals(3.33333, (double) stack.peek());

		CalculatorOperations.subtract(stack);
		assertEquals(2.22222, (double) stack.peek());

		CalculatorOperations.subtract(stack);
		assertEquals(-1.22222, (double) stack.peek());

		CalculatorOperations.subtract(stack);
		assertEquals(-21.21778, (double) stack.peek());

	}

	// --------------------------------------------------
	// Multiplication

	@Test
	void testMultiplyParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.multiply(stack);
			fail("Cannot multiply with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.multiply(stack);
			fail("Cannot multiply with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.multiply(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testMultiply() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.multiply(stack);
		assertEquals(0.0, Math.abs(stack.peek()));

		stack.pop();

		CalculatorOperations.multiply(stack);
		assertEquals(5.55555, (double) stack.peek());

		CalculatorOperations.multiply(stack);
		assertEquals(-124.666542, (double) stack.peek());
	}

	// --------------------------------------------------
	// Division

	@Test
	void testDivideParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.divide(stack);
			fail("Cannot divide with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.divide(stack);
			fail("Cannot divide with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.divide(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testDivideByZero() {

		Stack<Double> stack = getExampleStack();

		stack.push(Double.valueOf(0));

		try {
			CalculatorOperations.divide(stack);
			fail("Exception should be thrown on division by zero.");
		} catch (Exception ex) {
			// This is our success case
		}
	}

	@Test
	void testDivide() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.divide(stack);
		assertEquals(0.0, Math.abs(stack.peek()));

		try {
			CalculatorOperations.divide(stack);
			fail("Do not divide by zero");
		} catch (Exception ex) {
			stack.pop();
		}

		CalculatorOperations.divide(stack);
		assertEquals(0.18000018000018, (double) stack.peek());

		CalculatorOperations.divide(stack);
		assertEquals(-124.666542, (double) stack.peek());
	}

	// --------------------------------------------------
	// Modulo

	@Test
	void testModuloParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.modulo(stack);
			fail("Cannot divide with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.modulo(stack);
			fail("Cannot divide with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.modulo(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testModulo() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.modulo(stack);
		assertEquals(0.0, Math.abs(stack.peek()));

		try {
			CalculatorOperations.modulo(stack);
			fail("Do not divide by zero");
		} catch (Exception ex) {
			stack.pop();
		}

		CalculatorOperations.modulo(stack);
		assertEquals(1.0, (double) stack.peek());

		CalculatorOperations.modulo(stack);
		assertEquals(-0.4400000000000013, (double) stack.peek());
	}

	// --------------------------------------------------
	// Absolute Value

	@Test
	void testAbsParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.abs(stack);
			fail("Cannot get an absolute value with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.abs(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testAbs() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.abs(stack);
		assertEquals(3.33333, (double) stack.peek());
		stack.pop();

		CalculatorOperations.abs(stack);
		assertEquals(0.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.abs(stack);
		assertEquals(5.55555, (double) stack.peek());
		stack.pop();

		CalculatorOperations.abs(stack);
		assertEquals(1.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.abs(stack);
		assertEquals(22.44, (double) stack.peek());
		stack.pop();
	}

	// --------------------------------------------------
	// Square Root

	@Test
	void testSqrtParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.sqrt(stack);
			fail("Cannot get a square root with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.sqrt(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testSqrt() {

		Stack<Double> stack = getExampleStack();

		try {
			CalculatorOperations.sqrt(stack);
		} catch (Exception ex) {}
		stack.pop();

		CalculatorOperations.sqrt(stack);
		assertEquals(0.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.sqrt(stack);
		assertEquals(2.3570214254435617, (double) stack.peek());
		stack.pop();

		CalculatorOperations.sqrt(stack);
		assertEquals(1.0, (double) stack.peek());
		stack.pop();

		try {
			CalculatorOperations.sqrt(stack);
		} catch (Exception ex) {}
		stack.pop();
	}

	// --------------------------------------------------
	// Cube Root

	@Test
	void testCbrtParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.cbrt(stack);
			fail("Cannot get a cube root with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.cbrt(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testCbrt() {

		Stack<Double> stack = getExampleStack();

		try {
			CalculatorOperations.cbrt(stack);
		} catch (Exception ex) {}
		stack.pop();

		CalculatorOperations.cbrt(stack);
		assertEquals(0.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.cbrt(stack);
		assertEquals(1.7710970249382834, (double) stack.peek());
		stack.pop();

		CalculatorOperations.cbrt(stack);
		assertEquals(1.0, (double) stack.peek());
		stack.pop();

		try {
			CalculatorOperations.cbrt(stack);
		} catch (Exception ex) {}
		stack.pop();
	}

	// --------------------------------------------------
	// Exponent (x^y)

	@Test
	void testExpParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.exp(stack);
			fail("Cannot calculate exponent with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.exp(stack);
			fail("Cannot calculate exponent with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.exp(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testExp() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.exp(stack);
		assertEquals(Double.POSITIVE_INFINITY, (double) stack.peek());
		stack.pop();

		CalculatorOperations.exp(stack);
		assertEquals(1.0, (double) stack.peek());

		CalculatorOperations.exp(stack);
		assertEquals(-22.44, (double) stack.peek());
	}

	// --------------------------------------------------
	// Scientific Notation (xEy)

	@Test
	void testSciParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.sci(stack);
			fail("Cannot calculate exponent with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.sci(stack);
			fail("Cannot calculate exponent with one parm.");
		} catch (IllegalArgumentException ex) {}

		stack.push(2.0);

		try {
			CalculatorOperations.sci(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testSci() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.sci(stack);
		assertEquals(0.0, (double) stack.peek());

		CalculatorOperations.sci(stack);
		assertEquals(5.55555, (double) stack.peek());

		CalculatorOperations.sci(stack);
		assertEquals(359376.76915332867, (double) stack.peek());
	}

	// --------------------------------------------------
	// Ceiling

	@Test
	void testCeilParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.ceil(stack);
			fail("Cannot get a ceiling value with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.ceil(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testCeil() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.ceil(stack);
		assertEquals(-3.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.ceil(stack);
		assertEquals(0.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.ceil(stack);
		assertEquals(6.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.ceil(stack);
		assertEquals(1.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.ceil(stack);
		assertEquals(-22.0, (double) stack.peek());
		stack.pop();
	}

	// --------------------------------------------------
	// Floor

	@Test
	void testFloorParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.floor(stack);
			fail("Cannot get a floor value with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.floor(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testFloor() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.floor(stack);
		assertEquals(-4.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.floor(stack);
		assertEquals(0.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.floor(stack);
		assertEquals(5.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.floor(stack);
		assertEquals(1.0, (double) stack.peek());
		stack.pop();

		CalculatorOperations.floor(stack);
		assertEquals(-23.0, (double) stack.peek());
		stack.pop();
	}

	// --------------------------------------------------
	// Average

	@Test
	void testAvgParmCount() {

		Stack<Double> stack = new Stack<>();

		try {
			CalculatorOperations.average(stack);
			fail("Cannot get a average value with zero parms.");
		} catch (IllegalArgumentException ex) {}

		stack.push(3.0);

		try {
			CalculatorOperations.average(stack);
		} catch (IllegalArgumentException ex) {
			fail("This should work.");
		}
	}

	@Test
	void testAverage() {

		Stack<Double> stack = getExampleStack();

		CalculatorOperations.average(stack);
		assertEquals(-3.8435560000000004, (double) stack.peek());
	}

}
