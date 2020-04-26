package com.realpage.demo;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.Stack;

/**
 * This class provides a runnable CLI interface that makes use of the
 * {@link Calculator} class. This class handles the reading of commands from the
 * provided streams as well as handling the tokenizing of multiple inline
 * commands. The program will terminate on receiving a Q command or when the
 * stream reaches an EOF.
 * 
 * @author Nicolas Naranjo
 */
public class CalculatorCli {

	public static void execCalculator(InputStream in, PrintStream out, PrintStream err) {

		Calculator calculator = new Calculator();
		Scanner keyboard = new Scanner(in);

		out.println("====================================");
		out.println("| RealPage Demo Calculator Mk 0.75 |");
		out.println("====================================");

		out.println("Ready for user input");

		while (keyboard.hasNext()) {

			String input = keyboard.nextLine().trim();

			// Split the line into tokens separated by any number of spaces
			String[] tokens = input.split(" +");
			Stack<Double> backup = calculator.getStackBackupCopy();

			for (String command : tokens) {

				// Skip anything blank that may have gotten through
				if (command.trim().equals("")) {
					continue;
				}

				// Exit command
				if (command.trim().toUpperCase().equals("Q")) {
					out.println("Goodbye");
					keyboard.close();
					return;
				}

				try {

					calculator.processCommand(command);

				} catch (Exception ex) {
					err.println("Invalid command \"" + command + "\" - " + ex.getMessage());

					if (tokens.length > 1) {
						err.println("Command execution interrupted - Stack restored to prior state.");
						calculator.restoreStackFromBackup(backup);
					}

					break;
				}
			}

			out.println(calculator.getStackStateString());
		}

		keyboard.close();
	}

	public static void main(String[] args) {
		execCalculator(System.in, System.out, System.err);
	}
}
