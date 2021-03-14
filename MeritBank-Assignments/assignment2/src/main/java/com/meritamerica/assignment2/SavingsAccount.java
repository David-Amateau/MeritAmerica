/*
 * FileName: SavingsAccount.java
 * 
 * This class stores and creates Account Holders Savings Accounts
 * 
 * @author David Amateau & Ruby Garcia
 * 
 */

package com.meritamerica.assignment2;

import java.text.DecimalFormat;

public class SavingsAccount extends BankAccount {
	
	/*  		Instance Variables			*/
	//private double savingsAccBalance = 0;
	private static double savingsInterestRate = 0.01;
	//private double savingsAccFutureValue;
	
	/*  		Formatting Objects			*/
	DecimalFormat money = new DecimalFormat("0.00");
	
	// This constructor will set the opening balance of the Savings Account.
	public SavingsAccount(double openingBalance){
		super(openingBalance, savingsInterestRate);
		
	}
	
	/*
	 * 
	 * These methods can now be obtained using the super class BankAccount
	 * 
	// This method will return the Savings Account balance
	public double getBalance() {
		return savingsAccBalance;	
	}
	
	// This method will return the Checking Account balance
	public double getInterestRate() {
		return savingsInterestRate;
	}
	
	// This method will withdraw money and update the balance
	public boolean withdraw(double amount) {
		if (savingsAccBalance <= 0 || amount > savingsAccBalance) {
			System.out.println("Insufficient Funds\n");
			return false;
		} else {
			savingsAccBalance = savingsAccBalance - amount;
			System.out.println("Your New Savings Account Balance is: $" + money.format(savingsAccBalance) + "\n");
			return true;
		}
	}
	
	// This method will deposit money and update the balance
	public boolean deposit(double amount) {
		if(amount > 0) {
			savingsAccBalance = savingsAccBalance + amount;
			System.out.println("Your New Account Balance is: $" + money.format(savingsAccBalance) + "\n");
			return true;
		} else {
			System.out.println("System Error\n");
			return false;
		}
	}
	
	// This method will calculate the future value of the account in x years
	public double futureValue(int years) {
		savingsAccFutureValue = savingsAccBalance * 
				(Math.pow(1 + savingsInterestRate, years));
		return savingsAccFutureValue;	
	}
	*/
	@Override
	public String toString() {
		String savingsInfo = "\nSavings Account Balance: $" + money.format(getBalance()) + 
				"\nSavings Account Interest Rate: " + getInterestRate() +
				"\nSavings Account Balance in 3 years: $" + money.format(futureValue(3)) + "\n";
		return savingsInfo;
	}	
}