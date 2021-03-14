/*
 * FileName: BankAccount.java
 * 
 * This class stores information about Account Holders Bank Accounts.
 * 
 * @author David Amateau & Ruby Garcia
 * 
 */

package com.meritamerica.assignment2;

public class BankAccount {

	/*  		Instance Variables			*/
	private double balance;
	private double interestRate;
	private double futureValue;
	private long accountNumber;

	// This is a Super Constructor for the BankAccount class
	public BankAccount(double balance, double interestRate) {
		this.balance = balance;
		this.interestRate = interestRate;
		accountNumber = MeritBank.getNextAccountNumber();
	}

	// This is also a Super Constructor for the BankAccount class
	public BankAccount(long accountNumber, double balance, double interestRate) {
		this.accountNumber = accountNumber;
		this.balance = balance;
		this.interestRate = interestRate;
	}

	// This method will return the Bank Account Number
	public long getAccountNumber() {
		return accountNumber;
	}

	// This method will return the Bank Account Balance
	public double getBalance() {
		return balance;
	}

	// This method will return the Bank Account Interest Rate
	public double getInterestRate() {
		return interestRate;
	}

	// This method will withdraw money from the Bank Account if the amount
	// withdrawn is less then the balance of the account
	public boolean withdraw(double amount) {
		if (amount > balance) {
			System.out.println("Insufficent Funds");
			return false;
		} else {
			balance -= amount;
			System.out.println("Your new balance is $" + balance + "\n");
			return true;
		}
	}

	// This method will deposit money into the Bank Account if the amount
	// is a positive number
	public boolean deposit(double amount) {
		if (amount > 0) {
			balance += amount;
			System.out.println("Your new balance is $" + balance + "\n");
			return true;
		} else {
			System.out.println("Your deposit has failed. Please try again.\n");
			return false;
		}
	}

	// This method will determine the future value of the Bank Account
	public double futureValue(int years) {
		futureValue = balance * (Math.pow(1 + interestRate, years));
		return futureValue;
	}
}
