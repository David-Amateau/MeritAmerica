package week4;

import acm.program.ConsoleProgram;

public class Problem2A extends ConsoleProgram {
	
	// Midterm Part 2a

	public void run() {
		
		println(5.0 / 4 - 4 / 5);
		// Output is 1.25
		
		println(7 < 9 - 5 && 3 % 0 == 3);
		// Output is false because the first half of the expression is false
		// and the rest is short circuited.
		
		println("B" + 8 + 4);
		// Output is B84
		
	}

}

