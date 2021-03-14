package week5;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class BoxDiagram extends GraphicsProgram {

	// NEED TO FIGURE OUT HOW TO CENTER THE LABEL INSIDE THE BOX


	/* 				Constants					*/
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;

	/*				Instance Variables			*/
	private int xCoordinate;
	private int yCoordinate;

	/*				Instance Objects 			*/
	JTextField textFieldName;
	JLabel labelName;
	JButton buttonAdd;
	JButton buttonRemove;
	JButton buttonClear;
	GObject boxObject;

	/*				Instance Map				*/
	HashMap<String, GObject> objectsMap;


	// This is the main method that sets up our program.
	public void init () {
		objectsMap = new HashMap<String, GObject>();

		createSouthernControlBar();
		addMouseListeners();
		addActionListeners();
	}

	// This method creates the Southern Control bar that will have
	// three buttons, a label and a text field
	public void createSouthernControlBar() {
		labelName = new JLabel("Name");
		add(labelName, SOUTH);
		textFieldName = new JTextField(20);
		textFieldName.addActionListener(this);
		add(textFieldName, SOUTH);
		buttonAdd = new JButton("Add");
		add(buttonAdd, SOUTH);
		buttonRemove = new JButton("Remove");
		add(buttonRemove, SOUTH);
		buttonClear = new JButton("Clear");
		add(buttonClear, SOUTH);
	}


	public void mousePressed(MouseEvent e) {
		// Add if statement if no objects was clicked on?????
		xCoordinate = e.getX();
		yCoordinate = e.getY();
		boxObject = getElementAt(xCoordinate, yCoordinate);

	}

	public void mouseDragged(MouseEvent e) {
		int xDifference = e.getX() - xCoordinate;
		int yDifference = e.getY() - yCoordinate;
		boxObject.move(xDifference, yDifference);
		xCoordinate = e.getX();
		yCoordinate = e.getY();
	}


	// This method lets the program know what button was pressed
	// or if the user hit the return button
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == textFieldName) {
			addBox(textFieldName.getText());
		} else if (e.getSource() == buttonAdd) {
			addBox(textFieldName.getText());
		} else if (e.getSource() == buttonRemove) {
			removeBox(textFieldName.getText());
		} else if (e.getSource() == buttonClear) {
			clearCanvas();
		}
	}

	// This probably needs more work to dynamically adjust
	// This method adds a box to the canvas that can respond
	// dynamically to adjustments in size and adds the box to
	// the HashMap
	public void addBox(String boxName) {
		GCompound boxCompound = new GCompound();
		GRect box = new GRect(BOX_WIDTH, BOX_HEIGHT);
		boxCompound.add(box, BOX_WIDTH, BOX_HEIGHT);
		GLabel boxLabel = new GLabel(boxName);
		int labelWidth = boxName.length();
		// Below coordinates are not correcto mundo
		boxCompound.add(boxLabel, (BOX_WIDTH - (BOX_WIDTH / 2) + (labelWidth + (labelWidth / 2))), BOX_HEIGHT + (BOX_HEIGHT / 2));
		//boxCompound.add(boxLabel, BOX_WIDTH / 4, BOX_HEIGHT / 4);


		add(boxCompound, (getWidth() / 2), (getHeight() / 2 ));
		addBoxToHashMap(boxName, boxCompound);
	}

	// This method removes the box whose name we send it
	// if it exists in the HashMap
	public void removeBox(String boxName) {
		if (objectsMap.containsKey(boxName)) {
			remove(objectsMap.get(boxName));
		}
	}

	// This method clears all boxes from the canvas and then clears
	// the HashMap
	public void clearCanvas() {
		// loop through and delete all boxes in the hashMap
		// from the canvas and then clear the HashMap
		// This doesn't feel quite right //////////////////////////////

		for (String key : objectsMap.keySet()) {
			removeBox(key);
		}
		objectsMap.clear();
	}

	// This method adds boxes after they are created to the HashMap 
	// and is called when a new box is added
	public void addBoxToHashMap(String boxName, GCompound boxCompound) {
		objectsMap.put(boxName, boxCompound);
	}






}
