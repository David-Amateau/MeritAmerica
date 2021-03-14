package week2;

import acm.graphics.GOval;
import acm.program.GraphicsProgram;
import acm.util.*;

public class RandomCircles extends GraphicsProgram {
	
	
	// These are my constant variables for the size of the circles
	private static final int MAX_RADIUS = 50;
	private static final int MIN_RADIUS = 5;
	
	
	public void run() {
		
		// The amount of random circles I want added to the screen
		int numOfCircles = 10;
		
		
		// A for loop which contains a random generator object that will 
		// generate random numbers and set those numbers as the values
		// for the circles radius, location of x & y and color
		// and then will add it to the screen and loop until the loop
		// has reached the number I have set as the number of circles
		// I want.
		for (int i = 0; i < numOfCircles; i++) {
			RandomGenerator rGen = RandomGenerator.getInstance();
			int circleRadius = rGen.nextInt(MIN_RADIUS, MAX_RADIUS);
			int x = rGen.nextInt(0, getWidth() -2 * circleRadius);
			int y = rGen.nextInt(0, getHeight() -2 * circleRadius);
			GOval circle = new GOval (x, y, circleRadius * 2, circleRadius * 2);
			circle.setFilled(true);
			circle.setColor(rGen.nextColor());
			
			
			
			add(circle);
			
		}
	
		
	}
	
	
	
	
		
	
	

}
