/*
 * FileName: MeritBank.java
 * 
 * This class stores information about Merit Bank and serves as an administrative class.
 * 
 * @author David Amateau & Ruby Garcia
 * 
 */

package com.meritamerica.assignment2;

import java.util.Random; // for account numbers

public class MeritBank {

	/*  		Instance Variables			*/
	private static int numOfAccountHolders = 0;

	/* 			Instance Objects			*/
	private static Random randomNumber = new Random();

	/* 			Instance Arrays				*/
	private static AccountHolder[] accountHoldersArray = new AccountHolder[100];
	private static CDOffering[] cdOfferingsArray = new CDOffering[5];


	// This method will add account holders to the Account Holders array
	public static void addAccountHolder(AccountHolder accountHolder) {
		accountHoldersArray[numOfAccountHolders] = accountHolder;
		numOfAccountHolders++;
	}

	// This method will return an array of all Account Holders of Merit Bank
	public static AccountHolder[] getAccountHolders() {
		return accountHoldersArray;
	}

	// This method will return an array of all CD Offerings offered by Merit Bank
	public static CDOffering[] getCDOfferings() {
		return cdOfferingsArray;
	}

	// This method will return the CD Offering with the highest calculated
	// future value offered by Merit Bank
	public static CDOffering getBestCDOffering(double depositAmount) {
		double currentOfferingFutureValue = 0;
		double largestFutureValue = 0;
		int indexOfLargestFutureValue = 0;
		for (int i = 0; i < cdOfferingsArray.length; i++) {
			currentOfferingFutureValue = futureValue(depositAmount, cdOfferingsArray[i].getInterestRate(),
					cdOfferingsArray[i].getTerm());

			if (currentOfferingFutureValue > largestFutureValue) {
				largestFutureValue = currentOfferingFutureValue;
				indexOfLargestFutureValue = i;
			}
		}
		return cdOfferingsArray[indexOfLargestFutureValue];
	}

	// This method will return the CD Offering with the second highest calculated
	// future value offered by Merit Bank
	public static CDOffering getSecondBestCDOffering(double depositAmount) {
		double currentOfferingFutureValue = 0;
		double largestFutureValue = 0;
		double secondLargestFutureValue = 0;
		int indexOfLargestFutureValue = 0;
		int indexOfSecondLargestFutureValue = 0;
		for (int i = 0; i < cdOfferingsArray.length; i++) {
			currentOfferingFutureValue = futureValue(depositAmount, cdOfferingsArray[i].getInterestRate(),
					cdOfferingsArray[i].getTerm());

			if (currentOfferingFutureValue > largestFutureValue) {
				largestFutureValue = currentOfferingFutureValue;
				indexOfLargestFutureValue = i;
			} 
			if (currentOfferingFutureValue < largestFutureValue && 
					currentOfferingFutureValue > secondLargestFutureValue) {
				secondLargestFutureValue = currentOfferingFutureValue;
				indexOfSecondLargestFutureValue = i;
			}
		}
		return cdOfferingsArray[indexOfSecondLargestFutureValue];

	}

	// This method will clear all CD Offerings currently offered by Merit Bank
	public static void clearCDOfferings() {
		cdOfferingsArray = null;
	}

	// This method sets the CDOfferings it receives from MeritBank
	public static void setCDOfferings(CDOffering[] offerings) {
		cdOfferingsArray = offerings; 
	}

	// This method will give random numbers of type long that will be used to set account numbers
	public static long getNextAccountNumber() {
		return randomNumber.nextLong();
	}

	// This method will return the total balances of all Account Holders of Merit Bank
	public static double totalBalances() {
		double totalBalance = 0;
		for (AccountHolder account : accountHoldersArray) {
			totalBalance += account.getCombinedBalance();
		}
		return totalBalance;
	}

	// This method will return the future value of Merit Bank
	public static double futureValue(double presentValue, double interestRate, int term) {
		double futureValueOfMeritBank = 0;
		futureValueOfMeritBank = presentValue * (Math.pow(1 + interestRate, term));
		return futureValueOfMeritBank;
	}
}
