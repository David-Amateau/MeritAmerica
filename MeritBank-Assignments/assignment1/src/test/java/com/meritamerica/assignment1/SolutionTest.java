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
 * 4. Move the "assignment1" folder to your coding projects folder (e.g. Eclipse workspace)
 *
 * 5. Open Eclipse
 *
 * 6. Click File -> Import
 *
 * 7. Select "Maven -> Existing Maven Projects" and press Next
 *
 * 8. Click Browse and find the assignment1 folder, select the assignment1 folder
 *
 * 9. Ensure the pom.xml Project is selected and click Finish
 *
 * 10. Implement your solution in src/main/java
 *
 * 11. Right-click on the "assignment1" project in Eclipse, select "Run As" and "Java Application" and
 *     select the MeritAmericaBankApp to run your main() method
 *
 * 12. Right-click on the "assignment1" project in Eclipse, select "Run As" and "JUnit Test" to run our tests to verify your solution
 *
 * 13. Once complete, zip your "assignment1" folder, and upload it to HackerRank by clicking on "Upload code as Zip"
 *
 * 14. You can click on the "Run Unit Tests" button to confirm it is working.
 */
package com.meritamerica.assignment1;

import org.junit.Test;
import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void testCreateAccountHolder(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	1000.0);
        
        assertEquals(100.0, accountHolder.getCheckingAccount().getBalance(), 0);
        assertEquals(0.0001, accountHolder.getCheckingAccount().getInterestRate(), 0);
        assertEquals(1000.0, accountHolder.getSavingsAccount().getBalance(), 0);
        assertEquals(0.01, accountHolder.getSavingsAccount().getInterestRate(), 0);
    }

    @Test
    public void testDepositPositiveAmountInCheckingAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	1000.0);
        
        assertEquals(true, accountHolder.getCheckingAccount().deposit(500.0));
    }

    @Test
    public void testDepositNegativeAmountInCheckingAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	1000.0);
        
        assertEquals(false, accountHolder.getCheckingAccount().deposit(-500.0));
    }

    @Test
    public void testDepositPositiveAmountInSavingsAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	1000.0);
        
        assertEquals(true, accountHolder.getSavingsAccount().deposit(500.0));
    }

    @Test
    public void testDepositNegativeAmountInSavingsAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	1000.0);
        
        assertEquals(false, accountHolder.getSavingsAccount().deposit(-500.0));
    }

    @Test
    public void testWithdrawAmountExceedingBalanceInCheckingAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	100.0);
        
        assertEquals(false, accountHolder.getCheckingAccount().withdraw(500.0));
    }

    @Test
    public void testWithdrawAmountExceedingBalanceInSavingsAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	100.0);
        
        assertEquals(false, accountHolder.getSavingsAccount().withdraw(500.0));
    }

    @Test
    public void testFutureValueInSavingsAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	100.0);

        double fv = 100.0 * Math.pow(1 + 0.01, 3);
        
        assertEquals(fv, accountHolder.getSavingsAccount().futureValue(3), 0);
    }

    @Test
    public void testFutureValueInCheckingAccount(){
        AccountHolder accountHolder = new AccountHolder(
        	"Sadiq",
        	"",
        	"Manji",
        	"123456789",
        	100.0,
        	100.0);

        double fv = 100.0 * Math.pow(1 + 0.0001, 3);
        
        assertEquals(fv, accountHolder.getCheckingAccount().futureValue(3), 0);
    }
}