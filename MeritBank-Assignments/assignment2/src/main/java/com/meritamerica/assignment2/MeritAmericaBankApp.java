/*
 * FileName: MeritAmericaBankApp.java
 * 
 * This class will run the main method of Merit Bank and allow
 * information to be modified, stored and retrieved.
 * 
 * @author David Amateau & Ruby Garcia
 */

package com.meritamerica.assignment2;

public class MeritAmericaBankApp {
	private static final double NEW_ACCOUNT_MAX_BALANCE = 250000.00;

	public static void main(String[] args) {
		System.out.println("Hello Merit America!");

		// Adds 5 CDOfferings to MeritBank
		/* I think we could have done setCDOfferings here but I'm not sure
		 * how we would send the information.
		 * */
		MeritBank.getCDOfferings()[0] = new CDOffering(1, .018);
		MeritBank.getCDOfferings()[1] = new CDOffering(2, .019);
		MeritBank.getCDOfferings()[2] = new CDOffering(3, .02);
		MeritBank.getCDOfferings()[3] = new CDOffering(5, .025);
		MeritBank.getCDOfferings()[4] = new CDOffering(10, .022);
		System.out.println(MeritBank.getCDOfferings()[0].getInterestRate());
		System.out.println(MeritBank.getCDOfferings()[1].getTerm());

		// Instantiates a new account holder(ah1)
		AccountHolder accountHolder1 = new AccountHolder("John", "Adam", "Smith","111-11-1111");
		System.out.println(accountHolder1.toString());

		/*
		 * I think the Checking and Savings account aren't functioning properly 
		 * The toString from checkings and Savings aren't outputting
		 * How do we call just the checking account to string?
		 */

		// Adds a checking account with an opening balance of $1,000 as well 
		// as a savings account with an opening balance of $10,000 to ah1
		accountHolder1.addCheckingAccount(1000.00);
		accountHolder1.addSavingsAccount(10000.00);

		System.out.println(accountHolder1.getCheckingBalance());
		System.out.println(accountHolder1.getSavingsBalance());
		System.out.println(accountHolder1.getNumberOfCheckingAccounts());
		System.out.println(accountHolder1.getNumberOfSavingsAccounts());



		// Adds a checking account with an opening balance of $5,000 as well 
		// as a savings account with an opening balance of $50,000 to ah1
		accountHolder1.addCheckingAccount(5000.00);
		accountHolder1.addSavingsAccount(50000.00);

		// Adds a checking account with an opening balance of $50,000 as well 
		// as a savings account with an opening balance of $500,000 to ah1
		accountHolder1.addCheckingAccount(50000.00);
		accountHolder1.addSavingsAccount(500000.00);

		// Adds a checking account with an opening balance of $5,000 as well 
		// as a savings account with an opening balance of $50,000 to ah1
		accountHolder1.addCheckingAccount(5000.00);
		accountHolder1.addSavingsAccount(50000.00);

		// Confirms the last checking and savings accounts were not created
		if (accountHolder1.getCombinedBalance() > NEW_ACCOUNT_MAX_BALANCE) {
			System.out.println("Account was unable to be created.");
		}

		// Adds the best CD offering as a CD account to ah1
		accountHolder1.addCDAccount(MeritBank.getBestCDOffering(0), 0);

		// Adds ah1 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(accountHolder1);

		// Instantiates a new AccountHolder (ah2)
		AccountHolder ah2 = new AccountHolder ("Sam","Michael", "Adams", "222-22-2222");

		// Adds a checking account with an opening balance of $1,000 as well as 
		// a savings account with an opening balance of $10,000 to ah2
		ah2.addCheckingAccount(1000.00);
		ah2.addSavingsAccount(10000.00);

		// Adds the second best CD offering as a CD account to ah2
		ah2.addCDAccount(MeritBank.getSecondBestCDOffering(0), 0);

		// Adds ah2 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(ah2);

		// Clears the CDs being offered by MeritBank
		MeritBank.clearCDOfferings();

		// Instantiates a new AccountHolder (ah3)
		AccountHolder ah3 = new AccountHolder ("Sarah", "Jane", "Johnson", "333-33-3333");

		// Adds the second best CD offering as a CD account to ah3
		ah3.addCDAccount(MeritBank.getSecondBestCDOffering(0), 0);

		// Confirms a CD account was not created for ah3
		if (ah3.getNumberOfCDAccounts() == 0) {
			System.out.println("Account was unable to be created.");
		}

		// Adds a checking account with an opening balance of $1,000 as well as 
		// a savings account with an opening balance of $10,000 to ah3
		ah3.addCheckingAccount(1000.00);
		ah3.addSavingsAccount(10000.00);

		// Adds ah3 to Merit Bank’s list of account holders
		MeritBank.addAccountHolder(ah3);

		// Gets the total balance of all accounts held by Merit Bank’s account holders
		accountHolder1.getCombinedBalance();
		ah2.getCombinedBalance();
		ah3.getCombinedBalance();

	}
}