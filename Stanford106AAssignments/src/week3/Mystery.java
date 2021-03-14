/*
 * File: Mystery.java
 * 
 * This program doesn't do anything useful but is used to test
 * understanding of method calls and parameter passing.
 */

package week3;

import acm.program.*;

public class Mystery extends ConsoleProgram {

	public void run() {
		ghost(13);			// 13 is sent to ghost
	}
	
	private void ghost(int x) {		// int x is received as 13
		int y = 0;					// int y is 0
		for (int i = 1; i < x; i *= 2) { // i = 1, 2, 4, 8, breaks on 16 // x = 13
										 // run#1, 2, 3, 4, breaks on 4
			y = witch(y, skeleton(x, i));
			println("ghost y = " + y);
			println("ghost x = " + x);
			println("ghost i = " + i);
			
			// the first time skeleton is sent as x = 13, i = 1
			// the first time skeleton is returned as 1
			// the first time witch is sent as y = 0 and skeleton = 1
			// the first time witch is returned as 10 and assigned to y
			// y = 10
			
			// the second time i is multiplied by 2, x = 13, i = 2, y = 10
			// the second time skeleton is sent as x = 13, i = 2
			// the second time skeleton is returned as 0
			// the second time witch is sent y = 10 and skeleton = 0
			// the second time witch is returned as 100 and assigned to y
			// y = 100, x = 13, i = 4
			
			// the third time skeleton is sent as x = 13, i = 4
			// the third time skeleton is returned as 1
			
			// the third time witch is sent 100 and 1
			// the third time witch returns as 101 is assigned to y
			// x = 13, y = 101, i = 8

			// the fourth time skeleton is sent as x = 13 and i = 8
			// the fourth time skeleton is returned as 1
			// the fourth time witch is sent y = 101 and skeleton = 1
			// the fourth time witch returns 1011 and assigns it to y
			
			/*
			 *  y = 1011, x = 13, i = 8 and the Loop has ended
			 */
			
		}
		println("ghost: x = " + x + ", y = " + y);
	}
	
	private int witch(int x, int y) { 
		x = 10 * x + y;
		println("witch: x = " + x + ", y = " + y);
		return x;
	}
	
	private int skeleton(int x, int y) {
		println("skeleton x = " + x);
		println("skeleton y = " + y);
	
		return x / y % 2;
	}
}
