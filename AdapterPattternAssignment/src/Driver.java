
public class Driver {
	
	static CoffeeMachineInterface target = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());


	public static void main(String[] args) {
		ChooseSelectionA();
		ChooseSelectionB();
	}
	
	public static void ChooseSelectionA() {
		target.chooseFirstSelection();
	}
	
	public static void ChooseSelectionB() {
		target.chooseSecondSelection();
	}
	
	

}
