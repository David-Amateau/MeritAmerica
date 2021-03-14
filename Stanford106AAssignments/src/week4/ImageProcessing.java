package week4;

import acm.graphics.GImage;
import acm.program.GraphicsProgram;

public class ImageProcessing extends GraphicsProgram {

	// I looked at some code that manipulates images and figured this out
	// but i need to continue to work on
	// understanding more in depth how the arrays are being extracted
	// from the image, stored and reconfigured. I get the principles behind
	// it all but do not have a firm enough grasp of the actual implementation
	// and rebuilding of the arrays to feel confident manipulating images out in the real world

	GImage image = new GImage("/Users/davida/cat.jpg");

	public void run() {
		// image = flipVertical(image);
		// add(image);
		image = flipHorizontal(image);
		add(image);
		// image = flipHorizontalAndVertical(image);
		// add(image);
	}
	
	private GImage flipHorizontalAndVertical (GImage image) {
		image = flipHorizontal(image);
		image = flipVertical(image);
		return image;
	}

	private GImage flipVertical (GImage image) {
		int[][] array = image.getPixelArray();
		int height = array.length;
		for (int p1 = 0; p1 < height / 2; p1++) {
			int p2 = height - p1 -1;
			int[] temp = array[p1];
			array[p1] = array[p2];
			array[p2] = temp;
		}
		return new GImage(array);
	}

	private GImage flipHorizontal (GImage image) {
		int[][] array = image.getPixelArray();
		int width = array[0].length;
		int height = array.length;
		for (int row = 0; row < height; row++) {
			for (int column = 0; column < width / 2; column++) {
				int column2 = width - column -1;
				int temp = array[row][column];
				array[row][column] = array[row][column2];
				array[row][column2] = temp;
			}

		}
		return new GImage(array);
	}
}
