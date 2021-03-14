package week4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import acm.program.ConsoleProgram;
import acmx.export.java.io.FileReader;

public class Histograms extends ConsoleProgram {

	// Instance Array
	ArrayList<Integer> scoresArray;
	// Instance Variables
	String range00_09 = "";
	String range10_19 = "";
	String range20_29 = "";
	String range30_39 = "";
	String range40_49 = "";
	String range50_59 = "";
	String range60_69 = "";
	String range70_79 = "";
	String range80_89 = "";
	String range90_99 = "";
	String range100 = "";

	// This is our main method
	public void run() {
		String fileName = "/Users/davida/MidtermScores.txt";
		BufferedReader intReader;
		try {
			intReader = new BufferedReader(new FileReader(fileName));
			createIntArray(intReader);
			createHistogram();
			printHistogram();
			
		} catch (FileNotFoundException e) {
			println("Error");
		}
	}
		
	// This method will create an array of the test scores
	public void createIntArray(BufferedReader read) {
		scoresArray = new ArrayList<Integer>();
		String line;
		int index = 0;
		while (true) {
			try {
				line = read.readLine();
				if (line == null) {
					break;
				}
				// Spaces in the String will corrupt parse int so it must be trimmed
				scoresArray.add(index, Integer.parseInt(line.trim()));
				println(scoresArray.get(index));
				index++;
				} catch (IOException e) {
				println("Error in Method catch");
				e.printStackTrace();
			}
		}
	}
	
	// This method will create the Histogram
	public void createHistogram() {
		for (int i = 0; i < scoresArray.size(); i++) {
			if (scoresArray.get(i) == 100) {
				range100 += "*";
			} else if (scoresArray.get(i) >= 90) {
				range90_99 += "*";
			} else if (scoresArray.get(i) >= 80) {
				range80_89 += "*";
			} else if (scoresArray.get(i) >= 70) {
				range70_79 += "*";
			} else if (scoresArray.get(i) >= 60) {
				range60_69 += "*";
			} else if (scoresArray.get(i) >= 50) {
				range50_59 += "*";
			} else if (scoresArray.get(i) >= 40) {
				range40_49 += "*";
			} else if (scoresArray.get(i) >= 30) {
				range30_39 += "*";
			} else if (scoresArray.get(i) >= 20) {
				range20_29 += "*";
			} else if (scoresArray.get(i) >= 10) {
				range10_19 += "*";
			} else {
				range00_09 += "*";
			}
		}
	}
	
	// This method will print out the Histogram
	public void printHistogram() {
		println("00-09: " + range00_09);
		println("10-19: " + range10_19);
		println("20-29: " + range20_29);
		println("30-39: " + range30_39);
		println("40-49: " + range40_49);
		println("50-59: " + range50_59);
		println("60-69: " + range60_69);
		println("70-79: " + range70_79);
		println("80-89: " + range80_89);
		println("90-99: " + range90_99);
		println("  100: " + range100);
	}			
}