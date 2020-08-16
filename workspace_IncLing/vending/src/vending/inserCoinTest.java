package vending;

import java.util.*;
import specifications.Configuration;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class inserCoinTest {
	protected VendingMachine mac;

	

	
	@Before
	public void setUp() {
		mac = new VendingMachine();
//		Configuration.base = true;
//		Configuration.coinValidation  = true;
//		Configuration.availability  = true;
//		Configuration.terminal  = false;
//		Configuration.keyboard  = true;
//		Configuration.showStock  = true;
//		Configuration.flexiblequantity  = true;
//		Configuration.totalValueCollected  = true;
	}

    @Test
	public void testCase1() {
		int value = mac.returnCoin();
		assertTrue(value == 0);
	}

    @Test
	public void testCase3() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(25, mac.returnCoin());
	}

    @Test
	public void testCase5() {
		assertEquals(25, mac.insertCoin(25));
		int value = mac.insertCoin(25);
		assertTrue(value == mac.returnCoin());
	}
    
    @Test
	public void testCase6() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		int charge = mac.vendItem(3);
		assertTrue(charge == 0);
	}

    @Test
	public void testCase7() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		assertEquals(75, mac.insertCoin(25));
		int value = mac.returnCoin();
		assertEquals(75, value);
	}

    @Test
	public void testCase8() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		assertEquals(75, mac.insertCoin(25));
		int charge = mac.vendItem(3);
		assertEquals(25, charge);
	}

    @Test
	public void testCase9() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		assertEquals(75, mac.insertCoin(25));
		assertEquals(100, mac.insertCoin(25));
		int value = mac.returnCoin();
		assertEquals(100, value);
	}
    
    @Test
	public void testCase10() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		assertEquals(75, mac.insertCoin(25));
		assertEquals(100, mac.insertCoin(25));
		int charge = mac.vendItem(3);
		assertEquals(50, charge);
	}


    @Test
	public void testCase16() {
		assertEquals(25, mac.insertCoin(25));
		assertEquals(50, mac.insertCoin(25));
		assertEquals(75, mac.insertCoin(25));
		assertEquals(100, mac.insertCoin(25));
		assertEquals(50, mac.vendItem(3));
		assertEquals(0, mac.vendItem(3));
	}


	public void tearDown() {
	}
}
