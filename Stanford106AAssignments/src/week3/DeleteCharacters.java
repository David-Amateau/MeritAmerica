package folder;

public class DeleteCharacters {

	public static void main(String[] args) {
		
		System.out.println(removeAllOccurrences("This is a test", 't'));
		System.out.println(removeAllOccurrences("Summmer is here!", 'e'));
		System.out.println(removeAllOccurrences("---o---", '-'));

	}
	
	public static String removeAllOccurrences (String stringPassedIn, char charToBeRemoved) {
		String tempString = "";
		
		for (int i = 0; i < stringPassedIn.length(); i++) {
			if (stringPassedIn.charAt(i) != charToBeRemoved) {
				tempString += stringPassedIn.charAt(i);
			}
		}
		return tempString;
	}
}
