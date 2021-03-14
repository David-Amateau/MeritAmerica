/* This program uses Karel to check for and remove chads or errors in 
 * a punch card ballot. If Karel confirms the center has been punched out
 * Karel will not check for chads as it is a valid vote. However, if the
 * center is not punched out, Karel will check the rest of the ballot for
 * any hanging chads and remove them before moving on to the next ballot.
 */



package week1;
import stanford.karel.*;

public class KarelDefendsDemocracy extends SuperKarel {

	// This is the main method of the program.
	
	public void run() {
		
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				move();
			} else {
				checkForChads();
				move();
				
			}
		}
		
	}
	
	// This class will check for Chads and pick them up
	// if they are present
	
	private void checkForChads() {
		turnLeft();
		while (frontIsClear()) {
			move();
		}
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		while (frontIsClear()) {
			move();
		}
		while (beepersPresent()) {
			pickBeeper();
		}
		turnAround();
		move();
		turnRight();
	}
	
		
}
