/*
 * FileName: AccountHolder.java
 * 
 * This class constructs new Account Holders and stores their personal
 * information.
 * 
 * @author David Amateau & Ruby Garcia
 */

package com.meritamerica.assignment2;

public class AccountHolder {

	/* 			Constants					*/
	private static final double NEW_ACCOUNT_MAX_BALANCE = 250000.00;

	/*  		Instance Variables			*/
	private String firstName;
	private String middleName;
	private String lastName;
	private String ssn;
	private int numOfCheckingAccounts = 0;
	private int numOfSavingsAccounts = 0;
	private int numOfCDAccounts = 0;

	/*  		Instance Objects			*/
	private CheckingAccount checkingAccount;
	private SavingsAccount savingsAccount;
	private CDAccount cdAccount;

	/*			Instance Arrays				*/
	private CheckingAccount[] checkingAccountsArray = new CheckingAccount[7];
	private SavingsAccount[] savingsAccountsArray = new SavingsAccount[7];
	private CDAccount[] cdAccountsArray = new CDAccount[50];


	// This is an empty constructor
	public AccountHolder() {
		// This constructor will create an AccountHolder
	}


	// This constructor will be called if all parameters are sent in their
	// correct order when a new Account Holder is created.
	public AccountHolder(String firstName, String middleName, String lastName, String ssn) {

		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.ssn = ssn;

	}

	// This method will return the Account Holder's First Name
	public String getFirstName() {
		return firstName;
	}

	// This method will set the Account Holder's First Name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// This method will return the Account Holder's Middle Name
	public String getMiddleName() {
		return middleName;
	}

	// This method will set the Account Holder's Middle Name
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	// This method will return the Account Holder's Last Name
	public String getLastName() {
		return lastName;
	}

	// This method will set the Account Holder's Last Name
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// This method will return the Account Holder's SSN
	public String getSSN() {
		return ssn;
	}

	// This method will set the Account Holder's SSN
	public void setSSN(String ssn) {
		this.ssn = ssn;
	}

	// This method will check to see if the account Holders combined balance of
	// checking and savings is less than 250,000. If the total balance is less then 250,000
	// then this method creates and sets the opening balance of a new checking account and
	// then passes the new checking account to the method below this one
	public CheckingAccount addCheckingAccount(double openingBalance) {
		checkingAccount = new CheckingAccount(openingBalance);
		addCheckingAccount(checkingAccount);
		return checkingAccount;
	}

	// This method adds the new checking account to the checking accounts array
	// and then increases the int that stores the number of checking accounts 
	// associated with an individual account holder.
	public CheckingAccount addCheckingAccount(CheckingAccount checkingAccount) {
		double totalCheckingsAndSavingsBalance = 0;
		totalCheckingsAndSavingsBalance = getSavingsBalance() + getCheckingBalance() + checkingAccount.getBalance();
		if (totalCheckingsAndSavingsBalance > NEW_ACCOUNT_MAX_BALANCE) {
			System.out.println("Your total Account Balance exceeds $250,000. Please try again "
					+ "when your balance does not exceed the max account balance allowed to open"
					+ "a new checking account. ");
			return null;
		} else {
			checkingAccountsArray[numOfCheckingAccounts] = checkingAccount;
			numOfCheckingAccounts++;
		}
		return checkingAccount;

	}

	// This method will return an array of the checking accounts of a an Account Holder
	public CheckingAccount[] getCheckingAccounts() {
		return checkingAccountsArray;
	}

	// This method will return the number of checking accounts an Account Holder has
	public int getNumberOfCheckingAccounts() {
		return numOfCheckingAccounts;
	}

	// This method will return the balance of an Account Holder's Checking Accounts
	public double getCheckingBalance() {
		double checkingAccountBalance = 0;

		for (int i = 0; i < getNumberOfCheckingAccounts(); i++) {
			checkingAccountBalance += checkingAccountsArray[i].getBalance();
		}
		/*
		for (CheckingAccount account : checkingAccountsArray) {
			checkingAccountBalance += account.getBalance();
		}
		 */
		return checkingAccountBalance;
	}


	// This method will check to see if the account Holders combined balance of
	// checking and savings is less than 250,000. If the total balance is less then 250,000
	// then this method creates and sets the opening balance of a new savings account and
	// then passes the new savings account to the method below this one
	public SavingsAccount addSavingsAccount(double openingBalance) {
		savingsAccount = new SavingsAccount(openingBalance);
		addSavingsAccount(savingsAccount);
		return savingsAccount;
	}

	// This method adds the new savings account to the savings accounts array
	// and then increases the int that stores the number of savings accounts.
	public SavingsAccount addSavingsAccount(SavingsAccount savingsAccount) {
		double totalCheckingsAndSavingsBalance = 0;
		totalCheckingsAndSavingsBalance = getSavingsBalance() + getCheckingBalance() + savingsAccount.getBalance();
		if (totalCheckingsAndSavingsBalance > NEW_ACCOUNT_MAX_BALANCE) {
			System.out.println("Your total Account Balance exceeds $250,000. Please try again "
					+ "when your balance does not exceed the max account balance allowed to open"
					+ "a new savings account. ");

			return null;
		} else {
			savingsAccountsArray[numOfSavingsAccounts] = savingsAccount;
			numOfSavingsAccounts++;
		}
		return savingsAccount;
	}

	// This method will return an array of an Account Holder's Savings Accounts
	public SavingsAccount[] getSavingsAccounts() {
		return savingsAccountsArray;
	}

	// This method will return the number of Savings Accounts an Account Holder has
	public int getNumberOfSavingsAccounts() {
		return numOfSavingsAccounts;
	}

	// This method will return the balance of an Account Holder's Savings Accounts
	public double getSavingsBalance() {
		double savingsAccountBalance = 0;
		for (int i = 0; i < getNumberOfSavingsAccounts(); i++) {
			savingsAccountBalance += savingsAccountsArray[i].getBalance();
		}
		/*
		for (SavingsAccount account : savingsAccountsArray) {
			savingsAccountBalance += account.getBalance();
		}
		 */
		return savingsAccountBalance;
	}


	// 
	public CDAccount addCDAccount(CDOffering offering, double openingBalance) {
		cdAccount = new CDAccount(offering, openingBalance);
		addCDAccount(cdAccount);
		return cdAccount;

	}

	public CDAccount addCDAccount(CDAccount cdAccount) {
		cdAccountsArray[numOfCDAccounts] = cdAccount;
		numOfCDAccounts++;
		return cdAccount;
	}

	// This method will return an array of an Account Holder's CD Accounts
	public CDAccount[] getCDAccounts() {
		return cdAccountsArray;
	}

	// This method will return the number of CD Accounts an Account Holder has
	public int getNumberOfCDAccounts() {
		return numOfCDAccounts;
	}

	// This method will return the balance of an Account Holder's CD Accounts
	public double getCDBalance() {
		double cdsAccountBalance = 0;
		for (int i = 0; i < getNumberOfCDAccounts(); i++) {
			cdsAccountBalance += cdAccountsArray[i].getBalance();
		}

		/*
		for (CDAccount account : cdAccountsArray) {
			cdsAccountBalance += account.getBalance();
		}
		 */
		return cdsAccountBalance;
	}

	// This method will return the combined balance of all accounts of an Account Holder??
	public double getCombinedBalance() {
		double totalAccountsBalance = 0;
		totalAccountsBalance = getCheckingBalance() + getSavingsBalance() + getCDBalance();
		return totalAccountsBalance;
	}

	// This method will print out all the information of an Account Holder
	@Override
	public String toString() {
		String accountHolderInfo = "Name: " + getFirstName() + " " + getMiddleName()
		+ " " + getLastName() +
		"\nSSN: " + getSSN() + "\n";

		/*
				+
				checkingAccount.toString() + "\n" +
				savingsAccount.toString();
		 */
		return accountHolderInfo;
	}
}