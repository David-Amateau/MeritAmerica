/*
 * This program will draw a line on the canvas by starting a line when the user
 * clicks and then allowing them to drag the line until they release the mouse
 * at which point the line will be set in place. The operation will then repeat
 * and any number of additional lines every time the user clicks.
 */

package week2;

import acm.graphics.*;
import acm.program.GraphicsProgram;
import java.awt.event.*;

public class DrawingLines extends GraphicsProgram {
	
				/* Instance Variables */
	private GLine line;	// The object being dragged ????
	
	/*
	 *  The main method of the program. As this is an event driven program.
	 *  Our main method only makes a call to the method addMouseListeners 
	 *  which runs the program through its various methods that respond
	 *  to user input from the mouse. 
	 */
	public void run() {
		addMouseListeners(); // This Java method lets the the program respond to input

	}
	
	
	/*
	 * This method will respond to when the mouse is pressed and create a new
	 * line at its current position.
	 */
	
	public void mousePressed(MouseEvent e) {
		
		line = new GLine(e.getX(), e.getY(), e.getX(), e.getY());
		add(line);
		
	}
	
	/*
	 * This method will set the end point of the current line in place
	 */
	
	public void mouseDragged(MouseEvent e) {
		line.setEndPoint(e.getX(), e.getY());
		
	}

	
	// Do I need a mouseRealesed method?
	/*public void mouseReleased(MouseEvent e) {
		endX = e.getX();
		endY = e.getY();
		
	}
	*/
	
}