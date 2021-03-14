package week4;

import java.util.ArrayList;
import acm.program.ConsoleProgram;

public class UniqueNames extends ConsoleProgram {
	
	ArrayList<String> names = new ArrayList<String>();
	
	public void run() {
		
		// This loop will allow a user to enter names
		// If the name already exists in the Array it will not be added
		// again. If the name does not appear in the Array, it will be
		// added to the Array
		while (true) {
			String name = readLine("Enter name: ");
			if (name.equals("")) break;
			
			if (names.contains(name)) {
				continue;
			} else {
				names.add(name);
			}
				
		}
		
		// This loop will print out each name entered by the user only once
		// no matter how many times the name is entered
		println("Unique name list contains: ");
		for (int i = 0; i < names.size(); i++) {
			println(names.get(i));
		}
	
	
	}
}