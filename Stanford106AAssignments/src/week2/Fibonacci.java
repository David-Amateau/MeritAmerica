package week2;

import acm.program.*;

public class Fibonacci extends ConsoleProgram {
	
	// This is the constant final value that the Fibonacci sequence will compute up to.

	private final static int MAX_TERM_VALUE = 10000;
	
	// This is our main Program.
	
	public void run() {
		
		// These are the integer values will we need to store and manipulate.
	
		int fibResult = 0;  // The result of the current Fibonacci number
		int fibCount = 0;   // The Fibonacci number we are on
		int fib1 = 0;	    // The first Fibonacci term
		int fib2 = 1;	    // The second Fibonacci terrm
		
		// This is the while loop that will run and print our sequence numbers and their result
		
		while (fibResult < MAX_TERM_VALUE) {
			println("Fib(" + fibCount + ") =  " + fibResult);
			fibCount++;
			
			// This is the essence of our algorithm
			// fib2 is passed to fib1, the result of the two fib numbers are passed
			// to fib2
			fib1 = fib2;
			fib2 = fibResult;
			fibResult = fib1 + fib2;
			
			
		}	
	}
	
	
}
