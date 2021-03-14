/*
 * FileName: CDAccount.java
 * 
 * This class stores information about Account Holders CD Accounts.
 * 
 * @author David Amateau & Ruby Garcia
 * 
 */

package com.meritamerica.assignment2;

import java.util.Date;

public class CDAccount extends BankAccount {
	
	/*  		Instance Variables			*/
	private double cdAccountBalance;
	private double cdAccountInterestRate;
	private int cdAccountTerm;
	private long cdAccountNumber;
	private double cdAccountFutureValue;
	
	
	/*			Instance Objects			*/
	CDOffering cdOffering;
	private Date date;
	
	// This is the constructor for CDAccount
	public CDAccount(CDOffering offering, double balance) {
		super(balance, offering.getInterestRate());
		cdOffering = offering; // This contains the term and interest rate
		cdAccountBalance = balance;
	}
	
	// This method will return the balance
	public double getBalance() {
		return cdAccountBalance;
	}
	
	// This method will return the Interest Rate
	public double getInterestRate() {
		cdAccountInterestRate = cdOffering.getInterestRate();
		return cdAccountInterestRate;
	}
	
	// This method will return the term
	public int getTerm() {
		cdAccountTerm = cdOffering.getTerm();
		return cdAccountTerm;
	}
	
	// This method will return the date the CD Account was created
	java.util.Date getStartDate() {
		// this currently returns null
		return this.date;
	}
	
	// This method will return the account number by getting it from its
	// super class which is BankAccount
	public long getAccountNumber() {
		cdAccountNumber = super.getAccountNumber();
		return cdAccountNumber;
	}
	
	// This method will calculate and return the Future Value of the CD
	public double futureValue() {
		cdAccountFutureValue = cdAccountBalance *
				(Math.pow(1 + cdAccountInterestRate, this.cdOffering.getTerm()));
		return cdAccountFutureValue;
	}
}
