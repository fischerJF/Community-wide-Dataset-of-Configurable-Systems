package vending;

import org.junit.Test;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;

import static org.junit.Assert.assertFalse;

/**
 * A sample test case, testing <code>vending.Dispenser</code>.
 */
public class VendingMachineTestCase {
	protected VendingMachine mac;

	

	/**
	 * SPECIAL METHOD
	 * 
	 * This method is called BEFORE the execution of each test case (methods
	 * begining with "test").
	 */
    @Before
	public void setUp() {
		mac = new VendingMachine();
//		Configuration.base = true;
//		Configuration.coinValidation  = true;
//		Configuration.availability  = true;
//		Configuration.terminal  = true;
//		Configuration.keyboard  = true;
//		Configuration.showStock  = true;
//		Configuration.flexiblequantity  = true;
//		Configuration.totalValueCollected  = true;
	}

	

	/**
	 * Test Case 1: check the behaviour of the return coin operation
	 */
    @Test
	public void testReturnCoin() {
		// When no coin inserted, result should be 0
		int result = mac.returnCoin();
		assertTrue(result == 0);

		for (int i = 1; i <= 10; i++) {
			for (int j = 25; j <= 25 * i; j += 25) {
				mac.insertCoin(25);
			}
			// return all coins
			result = mac.returnCoin();
			assertEquals(25 * i, result);

			// no coins should be returned
			result = mac.returnCoin();
			assertTrue(result == 0);
		}
	}

	/**
	 * Test Case 2: check the behaviour of the insert coin operation
	 */
    @Test
	public void testInsertCoin() {
		for (int i = 1; i <= 1000; i++) {
			int result = mac.insertCoin(25);
			assertEquals(25 * i, result);
		}
	}

	/**
	 * Test Case 3: check the behaviour of the vend item operation
	 */
    @Test
	public void testVendItem() {
		// Check is all valid and available item can be bought by 50
		mac.insertCoin(25);
		mac.insertCoin(25);

		int result = mac.vendItem(1);
		assertEquals(0, result);
	}

	/**
	 * Test Case 8: checks the behaviour of the vend item when a valid and
	 * available item is being sold and there is enouth credit.
	 */
    @Test
	public void testRemainCredit() {
		for (int i = 1; i <= 100; i++) {
			mac.returnCoin(); // return all coins
			for (int j = 1; j <= i; j++) { // inserting 50 i times
				mac.insertCoin(25);
				mac.insertCoin(25);
			}
			int value = mac.vendItem(10); // valid and available item
			assertEquals((i * 50) - 50, value); // checking the charge
		}
	}
    @Test
    public void showItemTest() {
//    	Configuration.showStock=false;
    	if(!Configuration.showStock) {
    		assertEquals(mac.showItem(), "");
    	}
    }

    @Test
    public void totalValueCollectedTest() {
//    	Configuration.totalValueCollected=false;
    	if(!Configuration.totalValueCollected) {
    		assertEquals(mac.totalValueCollected(),0);
    	}
    }
	public void tearDown() {
	}
}
