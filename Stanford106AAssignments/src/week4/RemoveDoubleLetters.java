package week4;

import acm.program.ConsoleProgram;

public class RemoveDoubleLetters extends ConsoleProgram {

	public void run() {
		
		String userWord = readLine("Enter a word with doubled letters: ");
		String singleLetteredWord = "";
	

		for (int i = 0; i < userWord.length(); i++) {
			char currentLetter = userWord.charAt(i);
			
			if (i == 0 || currentLetter != userWord.charAt(i - 1)) {
				singleLetteredWord += currentLetter;
			}
		}
		
		println("Your word with all doubled letters removed = " + singleLetteredWord);
	}
}
