package com.meritamerica.assignment1;

public class MeritAmericaBankApp {
	
	public static void main(String[]args) {
		
		//Instantiates an account holder object with a checking balance of $100 and a savings balance of $1000 
		AccountHolder customer1 = new AccountHolder("David", "Michael", "Amateau", "333-33-3333", 100.00, 1000.00);
				
		//displays the account holder’s toString() output
		System.out.println(customer1.toString());
				
		//Deposits $500 into the checking account
		customer1.getCheckingAccount().deposit(500);
							
		//withdraws $800 from the savings account
		customer1.getSavingsAccount().withdraw(800);
		
		//display the checking account toString
		System.out.println(customer1.getCheckingAccount().toString());
		
		//display the savings account toString
		System.out.println(customer1.getSavingsAccount().toString() + "\n");
		
		//Instantiates another account holder with a checking balance of $200 and a savings balance of $500 
		AccountHolder customer2 = new AccountHolder("Ruby", "Sam", "Garcia", "888-88-8888", 200.00, 500.00);
				
		//Deposits $500 into the checking account of customer2
		customer2.getCheckingAccount().deposit(-500);
				
		//Withdraws $600 from the savings account of customer2
		customer2.getSavingsAccount().withdraw(600);
				
		//Displays the second account holder's toString() output
		System.out.println(customer2.toString());
				
				
	}	
}
			