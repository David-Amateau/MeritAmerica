package com.meritamerica.assignment1;

import java.text.DecimalFormat;

public class CheckingAccount {


	/* Instance Variables */

	private double checkingAccountBalance = 0;
	private double checkingAccountInterestRate = 0.0001;
	private double checkingAccountFutureValue;

	DecimalFormat money = new DecimalFormat("0.00");
	DecimalFormat percentage = new DecimalFormat("0.0000");

	// This constructor will set the opening balance of the Checking Account
	public CheckingAccount(double openingBalance) {
		checkingAccountBalance = openingBalance;
	}

	// This method will return the Checking Account Balance
	public double getBalance() {
		return checkingAccountBalance;
	}

	// This method will return the Checking Account Interest Rate
	public double getInterestRate() {
		return checkingAccountInterestRate;
	}

	// This method will withdraw money and update the balance
	public boolean withdraw(double amount) {
		if (checkingAccountBalance <= 0 || amount > checkingAccountBalance) {
			System.out.println("Insufficient Funds\n");
			return false; 
		} else {
			checkingAccountBalance = checkingAccountBalance - amount;
			System.out.println("Your New Account Balance is: $" + checkingAccountBalance + "\n");
			return true;
	  }
	}

	// This method will deposit money and update the balance
	public boolean deposit(double amount) {
		if (amount > 0) {
			checkingAccountBalance = checkingAccountBalance + amount;
			System.out.println("Your New Checking Account Balance is: $" + money.format(checkingAccountBalance) + "\n");
			return true;
		} else {
			System.out.println("System Error\n");
			return false;
		}
	}

	// This method will calculate the future value of the account in x years
	public double futureValue(int years) {
		checkingAccountFutureValue = checkingAccountBalance * 
				(Math.pow(1 + checkingAccountInterestRate, years));
		return checkingAccountFutureValue;
	}

	@Override
	public String toString() {
		String checkingInfo = "\nChecking Account Balance: $" + money.format(getBalance()) + 
				"\nChecking Account Interest Rate: " + percentage.format(getInterestRate()) +
				"\nChecking Account Balance in 3 years: $" + money.format(futureValue(3));
		return checkingInfo;
	}
}