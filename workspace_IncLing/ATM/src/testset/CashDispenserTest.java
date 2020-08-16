package testset;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atm.ATM;
import atm.CashDispenser;
import specifications.Configuration;

public class CashDispenserTest {

	private ATM atm;
	private CashDispenser cashDisp;

	@Before
	public void setUp() {
		cashDisp = new CashDispenser();
	}

	@Test
	public void testIsSufficientCashAvailable() {
		assertTrue(cashDisp.isSufficientCashAvailable(200));
		assertFalse(cashDisp.isSufficientCashAvailable(20000));
	}
	
	
	@After
	public void tearDown() {
		
	}

}
