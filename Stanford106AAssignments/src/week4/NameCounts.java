
package week4;

import java.util.HashMap;

import acm.program.ConsoleProgram;

public class NameCounts extends ConsoleProgram {
	
	public void run() {
	 
		// Create a HashMap to store names as keys and use the value of those keys
		// to keep track of how many times each name appears
		HashMap<String, Integer> namesMap = new HashMap<String, Integer>();
		String name;
		
		// This loop will read in names entered by the user. If the name already exists
		// it will modify the keys value by adding 1. If it does not exist, it will add
		// the key to the HashMap with a starting value of 1.
		while (true) {
			name = readLine("Enter name: "); // Read names user puts in
			if (name.equals("")) break; // Break if the user doesn't enter a name
			if (namesMap.containsKey(name) == false) {
				namesMap.put(name, 1);
			} else if (namesMap.containsKey(name) == true) {
				namesMap.put(name, namesMap.get(name) + 1);
			}
			
		}
		
		// Iterate through the HashMap and print keys and their values
		for (String key : namesMap.keySet()) {
			println("Entry " + key + " has count " + namesMap.get(key));

		}
	}
	
}
