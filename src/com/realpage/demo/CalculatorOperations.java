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

	private static void validateStackSize(Stack<Double> stack, String operation, int requiredOperators) {

		if (stack.size() < requiredOperators) {
			throw new IllegalArgumentException(
					"Unable to execute " + operation + " operation due to insufficient parameters. This operation requires at least "
							+ requiredOperators + " parameters.");
		}
	}

}
