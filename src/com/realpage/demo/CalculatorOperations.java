package com.realpage.demo;

import java.util.Stack;

/**
 * This class encompasses the set of mathematical operations which the
 * calculator will be able to perform. All methods take a stack as a parameter
 * and each will check that the stack has the required number of entries before
 * performing its calculation. Certain methods have additional checks for
 * certain situations such as avoiding division by zero or imaginary numbers.
 * 
 * @author Nicolas Naranjo
 *
 */
public class CalculatorOperations {

	// --------------------------------------------------
	// Basic operations

	/**
	 * This method will remove the last two values pushed into a stack and add
	 * them together. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void add(Stack<Double> stack) {

		validateStackSize(stack, "addition", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 + d2);
	}

	/**
	 * This method will remove the last two values pushed into a stack and
	 * subtract the last from the second to last. The result will be returned to
	 * the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void subtract(Stack<Double> stack) {

		validateStackSize(stack, "subtraction", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 - d2);
	}

	/**
	 * This method will remove the last two values pushed into a stack and
	 * multiply them together. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void multiply(Stack<Double> stack) {

		validateStackSize(stack, "multiplication", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 * d2);
	}

	/**
	 * This method will remove the last two values pushed into a stack and divide
	 * the second to last by the last. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void divide(Stack<Double> stack) {

		validateStackSize(stack, "division", 2);

		Double d2 = stack.pop();

		if (d2 == 0) {
			stack.push(d2);
			throw new IllegalStateException("Please do not attempt to divide by zero");
		}

		Double d1 = stack.pop();

		stack.push(d1 / d2);
	}

	// --------------------------------------------------
	// Advanced Operations

	/**
	 * This method will remove the last two values pushed into a stack and
	 * perform a modulo operation. This will return the remainder of a
	 * hypothetical division of the second to last value by the last value in the
	 * stack. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void modulo(Stack<Double> stack) {

		validateStackSize(stack, "modulo", 2);

		Double d2 = stack.pop();

		if (d2 == 0) {
			stack.push(d2);
			throw new IllegalStateException("Please do not attempt to divide by zero");
		}

		Double d1 = stack.pop();

		stack.push(d1 % d2);
	}

	/**
	 * This method will remove the last value pushed into a stack and calculate
	 * its absolute value. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void abs(Stack<Double> stack) {

		validateStackSize(stack, "absolute value", 1);

		Double d1 = stack.pop();

		stack.push(Math.abs(d1));
	}

	/**
	 * This method will remove the last value pushed into a stack and calculate
	 * its square root. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void sqrt(Stack<Double> stack) {

		validateStackSize(stack, "square root", 1);

		if (stack.peek() < 0) {
			throw new IllegalStateException("Please do not attempt to take the root of a negative number");
		}

		Double d1 = stack.pop();

		stack.push(Math.sqrt(d1));
	}

	/**
	 * This method will remove the last value pushed into a stack and calculate
	 * its cube root. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void cbrt(Stack<Double> stack) {

		validateStackSize(stack, "cube root", 1);

		if (stack.peek() < 0) {
			throw new IllegalStateException("Please do not attempt to take the root of a negative number");
		}

		Double d1 = stack.pop();

		stack.push(Math.cbrt(d1));
	}

	/**
	 * This method will remove the last two values pushed into a stack and raise
	 * the second to last to the power of the last. The result will be returned
	 * to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void exp(Stack<Double> stack) {

		validateStackSize(stack, "exponent", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(Math.pow(d1, d2));
	}

	/**
	 * This method will remove the last two values pushed into a stack and
	 * multiply the second to last by ten raised to the power of the last. The
	 * result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least two entries.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void sci(Stack<Double> stack) {

		validateStackSize(stack, "scientific notation", 2);

		Double d2 = stack.pop();
		Double d1 = stack.pop();

		stack.push(d1 * Math.pow(10, d2));
	}

	// --------------------------------------------------
	// Rounding operations

	/**
	 * This method will remove the last value pushed into a stack and round it up
	 * to the nearest whole number. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void ceil(Stack<Double> stack) {

		validateStackSize(stack, "ceiling", 1);

		Double d1 = stack.pop();

		stack.push(Math.ceil(d1));
	}

	/**
	 * This method will remove the last value pushed into a stack and round it
	 * down to the nearest whole number. The result will be returned to the
	 * stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
	public static void floor(Stack<Double> stack) {

		validateStackSize(stack, "floor", 1);

		Double d1 = stack.pop();

		stack.push(Math.floor(d1));
	}

	// --------------------------------------------------
	// Operations that will use up the entire stack

	/**
	 * This method will tabulate and remove all entries in a stack and calculate
	 * their average. The result will be returned to the stack.
	 * 
	 * This method requires the stack to have at least one entry.
	 * 
	 * @param stack
	 *           The stack of values upon which the method will perform
	 *           operations
	 */
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

	/**
	 * This method is used to neatly perform the minimum stack size check that
	 * all calculator operations must perform before they can execute.
	 * 
	 * @param stack
	 *           The stack to be checked for length
	 * @param operation
	 *           The name of the operation for which the length of the stack is
	 *           being checked. This will be used in the exception message in the
	 *           event the check fails.
	 * @param requiredEntries
	 *           The number of entries the stack must contain in order to pass
	 *           the check.
	 */
	private static void validateStackSize(Stack<?> stack, String operation, int requiredEntries) {

		if (stack.size() < requiredEntries) {
			String message = "Unable to execute " + operation
					+ " operation due to insufficient parameters. This operation requires at least " + requiredEntries;

			if (requiredEntries == 1) {
				message = message + " parameter.";
			} else {
				message = message + " parameters.";
			}

			throw new IllegalArgumentException(message);
		}
	}

}
