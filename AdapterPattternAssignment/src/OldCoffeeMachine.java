/*
 * FileName: OldCoffeeMachine.java
 */

// This is our adaptee. If this were a real world situation, no changes would be made
// to this class. The functionality would be added through the adapter and interface.

public class OldCoffeeMachine {

	// This class has two possible selections

	public String selectA() {
		System.out.println("Old Coffee Machine is brewing Selection A");
		return "Old Coffee Machine is brewing Selection A";
		// Code that makes A coffee
	}

	public String selectB() {
		System.out.println("Old Coffee Machine is brewing Selction B");
		return "Old Coffee Machine is brewing Selection B";
		// Code that makes B coffee
	}

}