/*
 * File: Hogwarts.java
 *
 * This program was written for me to trace the path and values of the variables
 * as they are sent as parameters to different methods and then returned.
 * 
 * 
 */

package week2;

import acm.program.*;

public class Hogwarts extends ConsoleProgram {
	
	public void run() {
		bludger(2001);				// nothing is returned from bludger
									// 2001 is passed to bludger as int y
	}
	
	private void bludger(int y) {	// y is passed 2001
		int x = y / 1000;			// 2001 / 1000 means x is 2
		int z = (x + y);			// 2001 + 2, z is 2003
		x = quaffle(z, y);			// z is returned and set to x = 1001
		println("bludger: x = " + x + ", y = " + y + ", z = " + z);
									// final: x = 1001, y = 2001, z = 2003
	}
	
	private int quaffle(int x, int y) {	// z becomes x = 2003, y is new y = 2001
		int z = snitch(x + y, y);		// x is sent as 4004, y as 2001
										// y is returned and = z
										// y is returned as 1001
										// z = 1001
		y  /= z;						// y = 2001
										// y = 2001 / 1001 = 1 because remainder
										// is thrown away no matter how large
										// final: y = 1, x = 2003, z = 1001
		println("quaffle: x = " + x + ", y  = " + y + ", z = " + z);
		return z;						// z is returned as 1001
	}
	
	private int snitch(int x, int y) {	// x is received as 4004, y as 2001
		y = x / (x % 10);				// 4004 / 4 means y = 1001
		println("snitch x = " + x + ", y = " + y);
		return y;						// y is returned as 1001
										// final: x = 4004, y = 1001
	}

}
