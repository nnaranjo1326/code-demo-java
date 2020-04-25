package com.realpage.demo;

import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

public class CalculatorCli {

	/**
	 * This decimal format is used to round all operation results to a certain
	 * number of decimal points so the results look clean. Each '#' after the
	 * decimal point in the parameter represents a decimal place that will be
	 * present in the final result.
	 */
	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#.###");

	private static String getStackStateString(Stack<Double> stack) {

		StringBuilder builder = new StringBuilder("[");

		Iterator<Double> iterator = stack.iterator();

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

	// --------------------------------------------------

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		Stack<Double> stack = new Stack<>();

		while (keyboard.hasNext()) {

			String input = keyboard.nextLine();

			try {

				switch (input.toUpperCase()) {

					case "+":
					case "ADD":
						CalculatorOperations.add(stack);
						break;

					case "-":
					case "SUB":
					case "SUBTRACT":
						CalculatorOperations.subtract(stack);
						break;

					case "/":
					case "DIV":
					case "DIVIDE":
						CalculatorOperations.divide(stack);
						break;

					case "*":
					case "X":
					case "MULT":
					case "MULTIPLY":
						CalculatorOperations.multiply(stack);
						break;

					// -------------------------
					// Advanced Operations

					case "POW":
					case "EXP":
					case "EXPONENT":
						CalculatorOperations.exp(stack);
						break;

					case "E":
					case "SCI":
						CalculatorOperations.sci(stack);
						break;

					case "%":
					case "MOD":
					case "MODULO":
						CalculatorOperations.modulo(stack);
						break;

					// -------------------------
					// Single parameter operations

					case "ABS":
					case "ABSOLUTE VALUE":
						CalculatorOperations.abs(stack);
						break;

					case "SQRT":
					case "SQUARE ROOT":
						CalculatorOperations.sqrt(stack);
						break;

					case "CBRT":
					case "CUBE ROOT":
						CalculatorOperations.cbrt(stack);
						break;

					case "CEIL":
					case "CEILING":
						CalculatorOperations.ceil(stack);
						break;

					case "FLOOR":
						CalculatorOperations.floor(stack);
						break;

					// -------------------------
					// "Full Stack" operations

					case "AVG":
					case "AVERAGE":
					case "MEAN":
						CalculatorOperations.average(stack);
						break;

					// -------------------------
					// Utility operators

					case "C":
					case "CLR":
					case "CLEAR":
						stack.clear();
						break;

					case "Q":
						System.out.println("Goodbye");
						keyboard.close();
						System.exit(0);
						break;

					case "":
						break;

					// -------------------------
					// Numeric entry or bad input

					default:

						try {

							double number = Double.parseDouble(input);
							stack.push(number);

						} catch (Exception ex) {
							System.err.println(
									"Unknown command \"" + input + "\". Please refer to the documentation for a list of accepted inputs.");
						}

						break;
				}

			} catch (Exception ex) {
				System.err.println("Invalid command \"" + input + "\" - " + ex.getMessage());
			}

			System.out.println(getStackStateString(stack));
		}
	}
}
