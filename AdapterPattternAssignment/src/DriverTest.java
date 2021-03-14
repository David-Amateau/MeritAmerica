import static org.junit.Assert.*;

import org.junit.Test;

public class DriverTest {

	@Test
	public void testChooseSelectionA() {
		CoffeeMachineInterface target = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());
		OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
		
		assertEquals(oldCoffeeMachine.selectA(), target.chooseFirstSelection());
		
	}
	
	@Test
	public void testChooseSelectionB() {
		CoffeeMachineInterface target = new CoffeeTouchscreenAdapter(new OldCoffeeMachine());
		OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
		
		assertEquals(oldCoffeeMachine.selectB(), target.chooseSecondSelection());
	}
}
