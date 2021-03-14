/*
 * This program will read in a file using a Buffered Reader
 * and then use methods to count the number of lines it contains,
 * the number of words it contains and the number of chars it contains.
 */

package week4;

import acm.program.ConsoleProgram;
import java.io.*;
import java.util.StringTokenizer;

public class WordCount extends ConsoleProgram {
	
	/* Instance Variables */
	int linesCount = 0;
	int wordsCount = 0;
	int charsCount = 0;
	BufferedReader readerLines;
	BufferedReader readerWords;
	BufferedReader readerChars;
	
	// Main Method
	public void run() {
 
		String fileName = "/Users/davida/lear.txt";
		try {
			readerLines = new BufferedReader(new FileReader(fileName));
			linesCount = countLines(readerLines);
			readerWords = new BufferedReader(new FileReader(fileName));
			wordsCount = countWords(readerWords);
			readerChars = new BufferedReader(new FileReader(fileName));
			charsCount = countChars(readerChars);
			println("File: " + fileName);
			println("Lines = " + linesCount);
			println("Words = " + wordsCount);
			println("Chars = " + charsCount);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	// Method to count the number of lines in the file
	public int countLines(BufferedReader read) {
		int count = 0;
		while (true) {
			String line;
			try {
				line = read.readLine();
				if (line == null) break;
				if (line != null) {
				count++;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	// Method to count the number of words in the file
	// Lines will need to be broken up into tokens or split into an array
	public int countWords(BufferedReader read) {
		int count = 0;
		while (true) {
			String line;
			try {
				line = read.readLine();
				if (line == null) break;
				if (line != null) {
					StringTokenizer tokens = new StringTokenizer(line);
					while (tokens.hasMoreTokens()) {
						tokens.nextToken();
						count++;
					}
				}	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
	
	// Method to count the number of chars in the file
	public int countChars(BufferedReader read) {
		int count = 0;
		while (true) {
			String line;
			try {
				line = read.readLine();
				if (line == null) break;
				if (line != null) {
					count += line.length() - 1;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return count;
	}
}