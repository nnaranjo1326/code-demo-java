package com.realpage.demo;

import java.util.Stack;

public class CalculatorOperations {

	// --------------------------------------------------
	// Basic operations

	/**
	 * This method performs an addition operation using a stack of parameters.
	 * The last two parameters in the stack will be added together and the result
	 * will be returned to the stack.
	 * 
	 * @param stack
	 *           Stack of currently loaded parameters
	 */
	public static void add(Stack<Double> stack) {

		validateStackSize(stack, "addition", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 + d2);
	}

	public static void subtract(Stack<Double> stack) {

		validateStackSize(stack, "subtraction", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 - d2);
	}

	public static void multiply(Stack<Double> stack) {

		validateStackSize(stack, "multiplication", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 * d2);
	}

	public static void divide(Stack<Double> stack) {

		validateStackSize(stack, "division", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 / d2);
	}

	// --------------------------------------------------
	// Advanced Operations

	public static void modulo(Stack<Double> stack) {

		validateStackSize(stack, "modulo", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 % d2);
	}

	public static void abs(Stack<Double> stack) {

		validateStackSize(stack, "absolute value", 1);

		Double d1 = stack.pop();

		stack.push(Math.abs(d1));
	}

	public static void sqrt(Stack<Double> stack) {

		validateStackSize(stack, "square root", 1);

		Double d1 = stack.pop();

		stack.push(Math.sqrt(d1));
	}

	public static void cbrt(Stack<Double> stack) {

		validateStackSize(stack, "cube root", 1);

		Double d1 = stack.pop();

		stack.push(Math.cbrt(d1));
	}

	public static void exp(Stack<Double> stack) {

		validateStackSize(stack, "exponent", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(Math.pow(d1, d2));
	}

	public static void sci(Stack<Double> stack) {

		validateStackSize(stack, "scientific notation", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 * Math.pow(10, d2));
	}

	// --------------------------------------------------
	// Rounding operations

	public static void ceil(Stack<Double> stack) {

		validateStackSize(stack, "ceiling", 1);

		Double d1 = stack.pop();

		stack.push(Math.ceil(d1));
	}

	public static void floor(Stack<Double> stack) {

		validateStackSize(stack, "floor", 1);

		Double d1 = stack.pop();

		stack.push(Math.floor(d1));
	}

	// --------------------------------------------------
	// Operations that will use up the entire stack

	public static void average(Stack<Double> stack) {

		validateStackSize(stack, "average", 1);

		double sum = 0;
		int count = 0;

		for (Double entry : stack) {
			sum += entry;
			count++;
		}

		double result = sum / count;

		stack.clear();
		stack.push(result);
	}

	// --------------------------------------------------

	private static void validateStackSize(Stack<Double> stack, String operation, int requiredOperators) {

		if (stack.size() < requiredOperators) {
			throw new IllegalArgumentException(
					"Unable to execute " + operation + " operation due to insufficient parameters. This operation requires at least "
							+ requiredOperators + " parameters.");
		}
	}

}
