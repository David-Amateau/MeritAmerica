import static org.junit.Assert.*;

import org.junit.Test;

public class CoffeeTouchscreenAdapterTest {


	@Test
	public void testChooseFirstSelection() {
		OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
		assertEquals("Old Coffee Machine is brewing Selection A" , oldCoffeeMachine.selectA());
	}

	@Test
	public void testChooseSecondSelection() {
		OldCoffeeMachine oldCoffeeMachine = new OldCoffeeMachine();
		assertEquals("Old Coffee Machine is brewing Selection B" , oldCoffeeMachine.selectB());
	}

}
