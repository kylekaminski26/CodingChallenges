import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @author Kyle Kaminski
 * 
 * @date February 29th, 2020
 * 
 * @purpose Takes a user's number input and returns it as either a 
 * formatted phone number or formatted social security number.
 * 
 * @directions Write a program that will format phone numbers and social security numbers. Phone numbers should be
 * formatted as: (123)456-7890. Social security numbers should be formatted as: 123-45-6789. The program
 * should read in two values from the user. The first value should be 1 for phone number or 2 for social security
 * number. The second value is the input that will be formatted. The program should continue accepting input until
 * the user enters Q to quit. If the second value is not the correct length (phone numbers should be 10 digits, social
 * security numbers should be 9), print an error message to the user. 
 * 
 * All rights reserved by Kyle Kaminski.
 */

public class Challenge1 { // Written by: Kyle Kaminski
	private static boolean run = true; // Controls the program running.
	static boolean menu = true; // Controls if the menu selection was valid.
	private static String choice = ""; // Field for the user's menu choice.
	private static String num = ""; // Field for the user's number entry.
	private static Scanner sc = new Scanner(System.in); // Scanner for user input.

	public static void main(String args[]) { // Driver
		
		do { // Run the menu at least once.
			try { // Try this code and look for exceptions.
				menu = true; // Set menu selection to true every time the menu is rerun.
				choice = sc.next(); // Capture user input for the menu choice.
				if (choice.equals("Q")) { // If the user input "Q".
					run = false; // End the running of the program.
					return; // End this method (the driver).
				} // End if.
				// If the user choice was not "1" and not "2".
				if (!choice.equals("1") && !choice.equals("2"))
					// Throw an exception for the input being out of range.
					throw new IndexOutOfBoundsException(); 
			} catch (IndexOutOfBoundsException e) { // Catch if a menu entry is out of scope or not valid type.
				System.out.println("Error! Invalid menu choice."); // Error message.
				menu = false; // Set menu selection to false (skip the second input and repeat the menu input).
			} // End catch.
			
			if (menu) { // If menu selection was valid.
				try { // Try this code and look for exceptions.
					num = sc.next(); // Capture user input for number entry.
					// If menu choice is "1" and num is 10 chars long (a valid entry for phone numbers).
					if (choice.equals("1") && num.length() == 10)
						// Print the formatted phone number String.
						System.out.println(toStringPhone(num));
					// If menu choice is "2" and num is 9 chars long (a valid entry for social security numbers).
					else if (choice.equals("2") && num.length() == 9)
						// Print the formatted social security number String.
						System.out.println(toStringSSN(num));
					else // If the length of the string is not valid.
						throw new IndexOutOfBoundsException();
				} catch (IndexOutOfBoundsException e) { // Catch exception for invalid string length.
					if (choice.equals("1") && num.length() != 10) // If invalid string length for a phone number.
						System.out.println("Error! Phone numbers should be 10 digits long."); // Error message.
					else if (choice.equals("2") && num.length() != 9) // If invalid string length for a SSN.
						System.out.println("Error! Social security numbers should be 9 digits long."); // Error message.
					else // If none of these cases (Failsafe: Should never print)
						System.out.println("Error!"); // Failsafe error message
				} catch (InputMismatchException e) { // Catch exception for if an integer value was not entered.
					System.out.println("Error! Please enter an integer value."); // Error message.
				} // End catch.
			} // End if.

		} while (run); // While run is true.
	} // End driver.

	/*
	 * @purpose Print a formatted social security number.
	 * @param String for SSN.
	 * @return Formatted SSN.
	 */
	private static String toStringSSN(String num) {
		return num.charAt(0) + num.charAt(1) + num.charAt(2) + "-" + num.charAt(3) + num.charAt(4) + "-" + num.charAt(5)
				+ num.charAt(6) + num.charAt(7) + num.charAt(8);
	} // End toStringSSN().

	/*
	 * @purpose Print a formatted phone number.
	 * @param String for phone number.
	 * @return Formatted phone number.
	 */
	private static String toStringPhone(String num) {
		return "(" + num.charAt(0) + num.charAt(1) + num.charAt(2) + ")" + num.charAt(3) + num.charAt(4) + num.charAt(5)
				+ "-" + num.charAt(6) + num.charAt(7) + num.charAt(8) + num.charAt(9);
	} // End toStringPhone().
} // End class.
