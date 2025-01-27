package com.realpage.demo;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Stack;

public class Calculator {

	/**
	 * This decimal format is used to round all operation results to a certain
	 * number of decimal points so the results look clean. Each '#' after the
	 * decimal point in the parameter represents a decimal place that will be
	 * present in the final result.
	 */
	public static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");

	/**
	 * The stack containing all current entries in the calculator
	 */
	private final Stack<Double> stack = new Stack<>();

	/**
	 * This method accepts a single command and takes the appropriate action on
	 * the stack. It takes either a valid alias for a calculator operation or a
	 * numeric value. Any other input will be rejected and an exception will be
	 * thrown.
	 * 
	 * @param input
	 *           The alias for the operation to be executed by the calculator or
	 *           a number to be loaded on the stack.
	 */
	public void processCommand(String input) {

		switch (input.toUpperCase()) {

			case "+":
			case "ADD":
				CalculatorOperations.add(this.stack);
				break;

			case "-":
			case "SUB":
			case "SUBTRACT":
				CalculatorOperations.subtract(this.stack);
				break;

			case "*":
			case "X":
			case "MULT":
			case "MULTIPLY":
				CalculatorOperations.multiply(this.stack);
				break;

			case "/":
			case "DIV":
			case "DIVIDE":
				CalculatorOperations.divide(this.stack);
				break;

			// -------------------------
			// Advanced Operations

			case "POW":
			case "POWER":
			case "EXP":
			case "EXPONENT":
				CalculatorOperations.exp(this.stack);
				break;

			case "E":
			case "SCI":
				CalculatorOperations.sci(this.stack);
				break;

			case "%":
			case "MOD":
			case "MODULO":
				CalculatorOperations.modulo(this.stack);
				break;

			// -------------------------
			// Single parameter operations

			case "ABS":
			case "ABSOLUTE_VALUE":
				CalculatorOperations.abs(this.stack);
				break;

			case "SQRT":
			case "SQUARE_ROOT":
				CalculatorOperations.sqrt(this.stack);
				break;

			case "CBRT":
			case "CUBE_ROOT":
				CalculatorOperations.cbrt(this.stack);
				break;

			case "CEIL":
			case "CEILING":
				CalculatorOperations.ceil(this.stack);
				break;

			case "FLOOR":
				CalculatorOperations.floor(this.stack);
				break;

			// -------------------------
			// "Full Stack" operations

			case "AVG":
			case "AVERAGE":
			case "MEAN":
				CalculatorOperations.average(this.stack);
				break;

			// -------------------------
			// Utility operators

			case "C":
			case "CLR":
			case "CLEAR":
				this.stack.clear();
				break;

			case "":
				break;

			// -------------------------
			// Numeric entry or bad input

			default:

				try {

					double number = Double.parseDouble(input);
					this.stack.push(number);

				} catch (Exception ex) {
					throw new IllegalArgumentException("Please refer to the documentation for a list of accepted inputs.");
				}

				break;
		}

	}

	/**
	 * This method is used to get a copy of the calculator's stack at any point
	 * in time. The developer may then make use of the
	 * {@link #restoreStackFromBackup(Stack)} method to restore the calculator to
	 * a previous state to roll back undesired changes.
	 * 
	 * @return A shallow copy of the stack.
	 */
	public Stack<Double> getStackBackupCopy() {
		Stack<Double> backup = new Stack<>();
		backup.addAll(stack);
		return backup;
	}

	/**
	 * In the event of an error in the midst of executing a set of commands, it
	 * may become necessary to perform a rollback in the event of an exception.
	 * This method allows for the stack to be restored from a backup created by
	 * the {@link #getStackBackupCopy()} method.
	 * 
	 * @param backup
	 *           The backup copy used to restore the stack.
	 */
	public void restoreStackFromBackup(Stack<Double> backup) {
		this.stack.clear();
		this.stack.addAll(backup);
	}

	/**
	 * Provides a string representation of the current contents of the stack with
	 * the elements arrayed left to right in order from deepest to most shallow.
	 * The elements are separated by a '|' character and the entire string is
	 * bracketed with '[]'.
	 * 
	 * @return The string representation of the stack.
	 */
	public String getStackStateString() {

		StringBuilder builder = new StringBuilder("[");

		Iterator<Double> iterator = this.stack.iterator();

		while (iterator.hasNext()) {

			Double entry = iterator.next();
			builder.append(DECIMAL_FORMAT.format(entry));

			if (iterator.hasNext()) {
				builder.append("|");
			}
		}

		builder.append("]");
		return builder.toString();
	}
}
