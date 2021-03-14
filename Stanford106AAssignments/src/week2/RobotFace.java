package week2;

import java.awt.Color;
import acm.graphics.*;
import acm.program.GraphicsProgram;

public class RobotFace extends GraphicsProgram {

	// These are constant values for the size of the GObjects
	private static final int HEAD_WIDTH = 200;
	private static final int HEAD_HEIGHT = 300;
	private static final int EYE_RADIUS = 25;
	private static final int MOUTH_WIDTH = 100;
	private static final int MOUTH_HEIGHT = 50;
	
	// This is our main method
	public void run() {
		
		addHeadToCanvas(getWidth() / 2, getHeight() / 2);
		addEyesToCanvas(getWidth() / 2, getHeight() / 2);
		addMouthToCanvas(getWidth() / 2, getHeight() / 2);
		
		
	}
	
	// This method creates and adds a Head to the canvas
	private void addHeadToCanvas (double cx, double cy) {
		double x = cx - HEAD_WIDTH / 2;
		double y = cy - HEAD_HEIGHT / 2;
		GRect head = new GRect (x, y, HEAD_WIDTH, HEAD_HEIGHT);
		head.setColor(Color.BLACK);
		head.setFillColor(Color.GRAY);
		head.setFilled(true);
		
		
		add(head);
	}
	
	// This method creates and adds the eyes to the canvas
	private void addEyesToCanvas(double cx, double cy) {
		double x = cx - EYE_RADIUS / 2;
		double y = cy - EYE_RADIUS / 2;
		double leftEyeX = x - HEAD_WIDTH / 4;
		double leftEyeY = y - HEAD_HEIGHT / 4;
		double rightEyeX = x + HEAD_WIDTH / 8;
		double rightEyeY = y - HEAD_HEIGHT / 4;
		double eyeDiameter = EYE_RADIUS * 2;
		GOval leftEye = new GOval (leftEyeX, leftEyeY, eyeDiameter, eyeDiameter);
		GOval rightEye = new GOval (rightEyeX, rightEyeY, eyeDiameter, eyeDiameter);
		leftEye.setFilled(true);
		leftEye.setColor(Color.YELLOW);
		rightEye.setFilled(true);
		rightEye.setColor(Color.YELLOW);
		
		
		add(leftEye);
		add(rightEye);
	}
	
	// This method creates and adds the mouth to the canvas
	private void addMouthToCanvas(double cx, double cy) {
		double x = cx - MOUTH_WIDTH / 2;
		double y = (cy - MOUTH_HEIGHT / 2) + (HEAD_HEIGHT / 4);
		GRect mouth = new GRect (x, y, MOUTH_WIDTH, MOUTH_HEIGHT);
		mouth.setFilled(true);
		mouth.setColor(Color.WHITE);
		add(mouth);
	}

}
