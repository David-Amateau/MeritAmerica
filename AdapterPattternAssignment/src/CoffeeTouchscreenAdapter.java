/*
 * FileName: CoffeeTouchscreenAdapter.java
 */

// This is our Adapter and it is wrapping the OldCofeeMachine
public class CoffeeTouchscreenAdapter implements CoffeeMachineInterface {


	// Instance of its adaptee that contains all the information that needs to be translated
	private OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();


	// We use the constructor to initialize an object of the adaptee so the adapter can access
	// and translate it
	CoffeeTouchscreenAdapter (OldCoffeeMachine oldCoffeeMachine) {
		this.oldCoffeeMachine = oldCoffeeMachine;
	}


	// Grabbing the information from the Old Coffee Machine through its methods and translating
	// them to the methods the client (TouchScreen) expects to receive.
	public String chooseFirstSelection() {
		return this.oldCoffeeMachine.selectA();
	}

	public String chooseSecondSelection() {
		return this.oldCoffeeMachine.selectB();
	}
	

}