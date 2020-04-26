package com.realpage.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.jupiter.api.Test;

class TestCalculatorObject {

	private static Stack<Double> getTestStack() {

		// Generate backup stack

		Double d1 = Math.random() * 100;
		Double d2 = Math.random() * 100;

		Stack<Double> backupStack = new Stack<>();

		backupStack.push(d1);
		backupStack.push(d2);

		return backupStack;
	}

	@Test
	void testProcessCommandAdd() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 + d2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "+", "ADD" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandSub() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 - d2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "-", "SUB", "SUBTRACT" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandMult() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 * d2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "*", "X", "MULT", "MULTIPLY" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandDiv() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 / d2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "/", "DIV", "DIVIDE" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandExp() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = Math.pow(d1, d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "POW", "POWER", "EXP", "EXPONENT" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandSci() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 * Math.pow(10, d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "E", "SCI" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandMod() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = d1 % d2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "%", "MOD", "MODULO" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandAbs() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		testStack.push(testStack.pop() * -1);
		Double d2 = testStack.get(1);

		Double result = Math.abs(d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "ABS", "ABSOLUTE_VALUE" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandSqrt() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d2 = testStack.get(1);
		Double result = Math.sqrt(d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "SQRT", "SQUARE_ROOT" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandCbrt() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d2 = testStack.get(1);
		Double result = Math.cbrt(d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "CBRT", "CUBE_ROOT" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandCeil() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d2 = testStack.get(1);
		Double result = Math.ceil(d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "CEIL", "CEILING" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandFloor() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d2 = testStack.get(1);
		Double result = Math.floor(d2);

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "FLOOR" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandAvg() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		Double d1 = testStack.get(0);
		Double d2 = testStack.get(1);
		Double result = (d1 + d2) / 2;

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "AVG", "AVERAGE", "MEAN" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().peek(), result);
		}
	}

	@Test
	void testProcessCommandRejection() {

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "Junk", "More Junk", "Garbage" });

		calc.restoreStackFromBackup(getTestStack());

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			try {
				calc.processCommand(command);
				fail("This command should not have been accepted.");
			} catch (Exception ex) {}
		}
	}

	@Test
	void testProcessCommandClear() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		List<String> aliases = Arrays.asList(new String[] { "C", "CLR", "CLEAR" });

		// Perform test operation for every alias on a fresh copy of the test
		// stack
		for (String command : aliases) {
			calc.restoreStackFromBackup(testStack);
			calc.processCommand(command);
			assertEquals(calc.getStackBackupCopy().size(), 0);
		}
	}

	@Test
	void testProcessCommandSpace() {

		Stack<Double> testStack = getTestStack();

		// Create calculator and load stack
		Calculator calc = new Calculator();
		calc.restoreStackFromBackup(testStack);

		// Differentiate the data from the list
		calc.processCommand("");

		// Ensure the new backup matches the list
		Stack<Double> backupStack = calc.getStackBackupCopy();

		assertEquals(testStack.size(), backupStack.size());

		for (int i = 0; i < testStack.size(); i++) {
			assertEquals(testStack.get(i), backupStack.get(i));
		}

	}

	@Test
	void testGetStackBackupCopy() {

		List<Double> list = new ArrayList<Double>();

		for (int i = 0; i < (Math.random() * 100) + 3; i++) {
			list.add(Math.random() * 100);
		}

		Calculator calc = new Calculator();

		for (Double entry : list) {
			calc.processCommand(Double.toString(entry));
		}

		Stack<Double> backupStack = calc.getStackBackupCopy();

		assertEquals(list.size(), backupStack.size());

		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), backupStack.get(i));
		}

	}

	@Test
	void testRestoreStackFromBackup() {

		// Generate random set of numbers to be tested against
		List<Double> list = new ArrayList<Double>();

		for (int i = 0; i < (Math.random() * 100) + 3; i++) {
			list.add(Math.random() * 100);
		}

		// Create calculator and load stack
		Calculator calc = new Calculator();

		for (Double entry : list) {
			calc.processCommand(Double.toString(entry));
		}

		// Differentiate the data from the list
		calc.processCommand("CLR");

		// Restore from original list
		Stack<Double> restoreCopy = new Stack<>();
		restoreCopy.addAll(list);

		calc.restoreStackFromBackup(restoreCopy);

		// Ensure the new backup matches the list
		Stack<Double> backupStack = calc.getStackBackupCopy();

		assertEquals(list.size(), backupStack.size());

		for (int i = 0; i < list.size(); i++) {
			assertEquals(list.get(i), backupStack.get(i));
		}

	}

	@Test
	void testGetStackStateString() {

		// Retrieve test stack and generate expected result
		Stack<Double> testStack = getTestStack();

		String comparisonString = "[" + Calculator.DECIMAL_FORMAT.format(testStack.get(0)) + "|"
				+ Calculator.DECIMAL_FORMAT.format(testStack.get(1)) + "]";

		// Create calculator and list of command aliases
		Calculator calc = new Calculator();
		calc.restoreStackFromBackup(testStack);

		assertEquals(comparisonString, calc.getStackStateString());
	}

}
