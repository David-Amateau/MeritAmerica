/**
 * DO NOT MODIFY THIS FILE
 *
 * INSTEAD:
 *
 * 1. Scroll down on this page within HackerRank
 *
 * 2. Click "Download code as Zip"
 *
 * 3. Find the zip file (e.g. in your Downloads folder) and unzip it
 *
 * 4. Move the "assignment2" folder to your coding projects folder (e.g. Eclipse workspace)
 *
 * 5. Open Eclipse
 *
 * 6. Click File -> Import
 *
 * 7. Select "Maven -> Existing Maven Projects" and press Next
 *
 * 8. Click Browse and find the assignment2 folder, select the assignment2 folder
 *
 * 9. Ensure the pom.xml Project is selected and click Finish
 *
 * 10. Implement your solution in src/main/java
 *
 * 11. Right-click on the "assignment2" project in Eclipse, select "Run As" and "Java Application" and
 *     select the MeritAmericaBankApp to run your main() method
 *
 * 12. Right-click on the "assignment2" project in Eclipse, select "Run As" and "JUnit Test" to run our tests to verify your solution
 *
 * 13. Once complete, zip your "assignment2" folder, and upload it to HackerRank by clicking on "Upload code as Zip"
 *
 * 14. You can click on the "Run Unit Tests" button to confirm it is working.
 */
package com.meritamerica.assignment2;

import static org.hamcrest.CoreMatchers.hasItem;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.junit.Test;

public class SolutionTest {

    @Test
    public void testAdd5CDOfferingsToMeritBank(){
    	
    	CDOffering[] CDOfferings = new CDOffering[5];
    	
    	CDOfferings[0] = new CDOffering(1,1.8/100);
    	CDOfferings[1] = new CDOffering(2,1.9/100);
    	CDOfferings[2] = new CDOffering(3,2.0/100);
    	CDOfferings[3] = new CDOffering(5,2.5/100);
    	CDOfferings[4] = new CDOffering(10,2.2/100);
    	
    	MeritBank.setCDOfferings(CDOfferings);
    	
    	CDOffering[] fromMeritBankCDOfferings = MeritBank.getCDOfferings();

        assertEquals(1, fromMeritBankCDOfferings[0].getTerm());
        assertEquals(1.8/100, fromMeritBankCDOfferings[0].getInterestRate(),0);        
        assertEquals(2, fromMeritBankCDOfferings[1].getTerm(),0);
        assertEquals(1.9/100, fromMeritBankCDOfferings[1].getInterestRate(),0);  
        assertEquals(3, fromMeritBankCDOfferings[2].getTerm());
        assertEquals(2.0/100, fromMeritBankCDOfferings[2].getInterestRate(),0);  
        assertEquals(5, fromMeritBankCDOfferings[3].getTerm());
        assertEquals(2.5/100, fromMeritBankCDOfferings[3].getInterestRate(),0);  
        assertEquals(10, fromMeritBankCDOfferings[4].getTerm());
        assertEquals(2.2/100, fromMeritBankCDOfferings[4].getInterestRate(),0);         

    }
    
    @Test    
    public void testAccountHolder() {
    	
    	AccountHolder accountHolder = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	accountHolder.addCheckingAccount(1000);
    	accountHolder.addSavingsAccount(10000);
    	
        assertEquals("Sam", accountHolder.getFirstName());    	
        assertEquals("John", accountHolder.getMiddleName());       
        assertEquals("Houston", accountHolder.getLastName());  
        assertEquals("633378899", accountHolder.getSSN());       
        assertEquals(1000, accountHolder.getCheckingBalance(),0);    
        assertEquals(10000, accountHolder.getSavingsBalance(),0);         
    }
    
    @Test    
    public void testAccountHolderBalanceNoMoreThan25000() {

    	
    	AccountHolder accountHolder = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	CheckingAccount checkingAccount1 =new CheckingAccount(1000);
    	SavingsAccount savingsAccount1 = new SavingsAccount(10000);
    	
    	CheckingAccount checkingAccount2 =new CheckingAccount(5000);
    	SavingsAccount savingsAccount2 = new SavingsAccount(50000);
    	
    	CheckingAccount checkingAccount3 =new CheckingAccount(50000);
    	SavingsAccount savingsAccount3 = new SavingsAccount(130000);
    	
       	CheckingAccount checkingAccount4 =new CheckingAccount(5000);
    	SavingsAccount savingsAccount4 = new SavingsAccount(50000);    	

    	accountHolder.addCheckingAccount(checkingAccount1);
    	accountHolder.addSavingsAccount(savingsAccount1);
    	
    	accountHolder.addCheckingAccount(checkingAccount2);
    	accountHolder.addSavingsAccount(savingsAccount2);    	
    	
    	accountHolder.addCheckingAccount(checkingAccount3);
    	accountHolder.addSavingsAccount(savingsAccount3);    	    
    	
    	accountHolder.addCheckingAccount(checkingAccount4);
    	accountHolder.addSavingsAccount(savingsAccount4);   
    	
    	assertThat(Arrays.asList(accountHolder.getCheckingAccounts()), not(hasItem(checkingAccount4)));
    	assertThat(Arrays.asList(accountHolder.getSavingsAccounts()), not(hasItem(savingsAccount4)));    	
    	
    }
    
    @Test    
    public void testAdCDAccountToAccountHolder() {
    	CDOffering cdOffering = new CDOffering(1,1.8/100);
    	CDAccount cdAccount = new CDAccount(cdOffering, 5000);
    	
    	
    	AccountHolder accountHolder = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	accountHolder.addCDAccount(cdAccount);
    	
        assertEquals(1, accountHolder.getCDAccounts()[0].getTerm());    	
        assertEquals(1.8/100, accountHolder.getCDAccounts()[0].getInterestRate(),0); 
        assertEquals(5000, accountHolder.getCDAccounts()[0].getBalance(),0);    	
    	
    }
    
    @Test    
    public void tesAddAccountHolderToMeritBank() {
    	
    	AccountHolder accountHolder = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	accountHolder.addCheckingAccount(1000);
    	accountHolder.addSavingsAccount(10000);
    	MeritBank.addAccountHolder(accountHolder);
    	
        assertEquals("Sam", MeritBank.getAccountHolders()[0].getFirstName());    	
        assertEquals("John", MeritBank.getAccountHolders()[0].getMiddleName());       
        assertEquals("Houston", MeritBank.getAccountHolders()[0].getLastName());  
        assertEquals("633378899", MeritBank.getAccountHolders()[0].getSSN());       
        assertEquals(1000, MeritBank.getAccountHolders()[0].getCheckingBalance(),0);    
        assertEquals(10000, MeritBank.getAccountHolders()[0].getSavingsBalance(),0);     	  	
    }
    
    @Test    
    public void tesCDClearingByMeritBank() {
    	
    	//    Clear the CDs being offered by MeritBank
    	MeritBank.clearCDOfferings();
    	AccountHolder accountHolder = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	accountHolder.addCheckingAccount(1000);
    	accountHolder.addSavingsAccount(10000);
    	MeritBank.addAccountHolder(accountHolder);
    	
    	assertNull(MeritBank.getCDOfferings());
     }    

    @Test    
    public void tesMeritBankAccountHoldersTotalBalance() {
    	
    	AccountHolder accountHolder1 = new AccountHolder("Sam", "John", "Houston","633378899");
    	
    	accountHolder1.addCheckingAccount(1000);
    	accountHolder1.addCheckingAccount(5000);
    	accountHolder1.addCheckingAccount(50000);    	
    	
    	accountHolder1.addSavingsAccount(10000);
    	accountHolder1.addSavingsAccount(50000);
    	accountHolder1.addSavingsAccount(130000);
    	
    	accountHolder1.addCDAccount(new CDOffering(1, 1.8/100),5000);
    	
        assertEquals(251000, accountHolder1.getCombinedBalance(),0); 
    	
    	MeritBank.addAccountHolder(accountHolder1);
    	
    	AccountHolder accountHolder2 = new AccountHolder("Jack", "John", "Houston","633378898"); 
    	
    	accountHolder2.addCheckingAccount(1000);
    	accountHolder2.addSavingsAccount(10000);    	
    	
    	accountHolder2.addCDAccount(new CDOffering(2, 1.9/100),5000);
    	MeritBank.addAccountHolder(accountHolder2);
    	
        assertEquals(16000, accountHolder2.getCombinedBalance(),0);     	
    	
    	AccountHolder accountHolder3 = new AccountHolder("Shiva", "John", "Houston","633378898"); 
    	
    	accountHolder3.addCheckingAccount(1000);
    	accountHolder3.addSavingsAccount(10000);    	
    	
    	MeritBank.addAccountHolder(accountHolder3);
    	
        assertEquals(11000, accountHolder3.getCombinedBalance(),0);         	    	    	
    	
     }    

    
}
