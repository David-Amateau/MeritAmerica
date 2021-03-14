/*
 * File: AddCommasToNumberStrings.java
 * 
 * In this program we want to add commas to a string that contains only
 * numbers at the correct location for any size string.
 * 
 * To do so we will first reverse the string so we may insert commas 
 * consistently after every 3 digits.
 * 
 * We will then add the commas and reverse the string again to get back
 * it's original order with the commas now correctly inserted.
 * 
 */
package week3;

import acm.program.ConsoleProgram;

public class AddCommasToNumberStrings extends ConsoleProgram {
	
	public void run() {
		while (true) {
		
		// Receiving a user inputed string of digits
			String numericString = readLine("Enter a numeric string: ");
		// Creating a String to store the return
			String numericStringWithCommas;
		// Running the method that will add commas to the string and store the return
			numericStringWithCommas = AddCommasToNumericString(numericString);
		// Printing the String with commas
			println(numericStringWithCommas);
		// If the user does not enter anything before pressing enter the program will terminate
			if (numericString.length() ==  0) break;
		}		
	}
	
		// The method that will return our String with commas
	public String AddCommasToNumericString(String str) {
		String tempString = str;
		tempString = reverseString(tempString);
		tempString = insertCommas(tempString);
		tempString = reverseString(tempString);
		return tempString;
	}

		// The method that will first reverse our String to make it easier to insert commas
		// After the commas are inserted, we will run this method again to receive our string
		// back in it's original order with commas
	public String reverseString(String str) {
		String result = "";
		for (int i = 0; i < str.length(); i++) {
			result = str.charAt(i) + result;
		}
		return result;
	}
	
		// The method that will actually insert the commas into the String
	public String insertCommas(String str) {
		String tempString = "";
		for (int index = 0; index < str.length(); index++) {
			if (index % 3 == 0  && index > 2) {
				tempString = tempString + ",";
			}
			tempString = tempString + str.charAt(index);
		}
		return tempString;
	}
}