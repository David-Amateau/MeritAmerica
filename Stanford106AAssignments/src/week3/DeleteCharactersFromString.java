package week3;

import acm.program.ConsoleProgram;

public class DeleteCharactersFromString extends ConsoleProgram {
	
	public void run() {

		//String test = "This is a test";
		//int index = test.indexOf("test");
		//System.out.println(index);
		
		println(removeAllOccurrences("This is a test", 't'));
		println(removeAllOccurrences("Summmer is here!", 'e'));
		println(removeAllOccurrences("---o---", '-'));
	}
	
	public String removeAllOccurrences (String stringPassedIn, char charToBeRemoved) {
		String tempString = "";
		
		for (int i = 0; i < stringPassedIn.length(); i++) {
			if (stringPassedIn.charAt(i) != charToBeRemoved) {
				tempString += stringPassedIn.charAt(i);
			}
		}
		return tempString;
		/* the while loop below will execute until the char given and being
		 * removed can no longer be found in the String
		 */
		
		// int indexOfCharToBeRemoved = stringPassedIn.indexOf(charToBeRemoved);
		
		// System.out.println(indexOfCharToBeRemoved); // location of first occurrence is 10
		/* int index = 0;
		String tempString = "";
		
		while (stringPassedIn.indexOf(charToBeRemoved) != -1) {
			
			// I can compare two chars as they are primitives but could
			// not compare two strings using operators
			if (charToBeRemoved != stringPassedIn.charAt(index) ) {
				tempString += stringPassedIn.charAt(index); 
				
				
			}
			// System.out.println(tempString);
			index++;	
			
		
		}
		return tempString;
		
		*/
		
		
		
	}
	
}
