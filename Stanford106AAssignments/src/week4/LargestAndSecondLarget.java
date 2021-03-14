package week4;

import acm.program.ConsoleProgram;

public class LargestAndSecondLarget extends ConsoleProgram {

	final int SENTINEL = 0;
	int currentNumber = 0;
	int largestNumber = 0;
	int secondLargestNumber = 0;
	
	public void run() {
		
		while (true) {
			currentNumber = readInt("Enter Value: ");
			if (currentNumber == SENTINEL)  break;
			if (currentNumber > largestNumber) {
				secondLargestNumber = largestNumber;
				largestNumber = currentNumber;
			} else if (currentNumber > secondLargestNumber) {
				secondLargestNumber = currentNumber;
			}
		}
		println("The largest value is " + largestNumber);
		println("The second largest values is " + secondLargestNumber);
		
	}
}
