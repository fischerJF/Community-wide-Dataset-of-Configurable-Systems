package atm;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atm.ATM;
import atm.Keypad;
import specifications.Configuration;

public class KeypadTest {

	private ATM atm;
	private Keypad keypad;

	@Before
	public void setUp() {

		
		keypad = new Keypad();

	}
	
	@Test
	public void testGetInput() throws Exception {
		
	}

	@After
	public void tearDown() {

	}

	
	

}
