package week1;
/*
 * File: KarelMidterm.java
 * 
 * This program will have Karel place a border of beepers inside her world
 * leaving one space of emptiness between the border and the edge of the world.
 */

import stanford.karel.*;

public class KarelMidterm extends SuperKarel {
	
	// This is our main method
	public void run() {
		moveToPosition();
		placeBorder();
	}
	
	// This method gets Karel into her starting position
	public void moveToPosition() {
		move();
		turnLeft();
		move();
	}
	
	// This method places the border on all sides of the window
	public void placeBorder() {
		placeLine();
		reposition();
		placeLine();
		reposition();
		placeLine();
		reposition();
		placeLine();
	}
	
	// This method places a line of Beepers until one space before the edge 
	// of the world
	public void placeLine() {
		while (frontIsClear()) {
			if (beepersPresent()) {
				move();
			} else {
				putBeeper();
				move();
			}
		}
	}
	
	// This method repositions Karel to place the next line of Beepers
	public void reposition() {
		turnAround();
		move();
		turnLeft();
		move();
	}

}
