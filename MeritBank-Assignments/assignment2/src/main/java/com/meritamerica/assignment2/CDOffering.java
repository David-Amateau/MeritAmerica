/*
 * FileName: CDOffering.java
 *
 * This class can return the term and interest rate being offered for CD Accounts.
 * 
 * @author David Amateau & Ruby Garcia
 * 
 */


package com.meritamerica.assignment2;
public class CDOffering {
	
	/*  		Instance Variables			*/
	private int cdOfferingTerm;
	private double cdOfferingInterestRate;
	
	
	// This is the constructor for CDOffering
	public CDOffering(int term, double interestRate) {
		cdOfferingTerm = term;
		cdOfferingInterestRate = interestRate;
	}
	
	// This method will return the Term of the CDOffering
	public int getTerm() {
		return cdOfferingTerm;
	}
	
	// This method will return the Interest Rate of the CDOffering
	double getInterestRate() {
		return cdOfferingInterestRate;
	}

}
