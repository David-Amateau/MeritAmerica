package week4;

import acm.program.*;

public class Problem2b extends ConsoleProgram {

	public void run() {
		int num1 = 2;
		int num2 = 13;
		println("run num1 before = " + num1);
		println("run num2 before = " + num2);
		println("The 1st number is: " + Mystery(num1, 6));
		println("run num1 the 1st number is = " + num1);
		println("run num2 the 1st number is = " + num2);
		println("The 2nd number is: " + Mystery(num2 % 5, 1 + num1 * 2));
		println("run num1 the 2nd number is = " + num1);
		println("run num2 the 2nd number is = " + num2);
	}
	
	private int Mystery(int num1, int num2) {
		println("Mystery");
		println("Mystery num1 before = " + num1);
		println("Mystery num2 before = " + num2);
		num1 = Unknown(num1, num2);
		println("Mystery num1 after num1 = " + num1);
		println("Mystery num2 after num1 = " + num2);
		num2 = Unknown(num2, num1);
		println("Mystery num1 after num2 = " + num1);
		println("Mystery num2 after num2 = " + num2);
		return(num2);
	}
	
	private int Unknown(int num1, int num2) {
		println("Unknown num1 before = " + num1);
		println("Unknown num2 before = " + num2);
		int num3 = num1 + num2;
		num2 += num3 * 2;
		println("Unknown num1 after = " + num1);
		println("Unknown num2 after = " + num2);
		println("Unknown num3 after = " + num3);
		return(num2);
	}
}
