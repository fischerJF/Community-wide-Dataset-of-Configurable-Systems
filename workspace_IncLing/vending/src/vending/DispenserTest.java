package vending;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class DispenserTest {

	protected Dispenser d;

	@Before
	public void setup() {
		d = new Dispenser();
	}

	@Test
	public void testDispenseCreditNoCoinsInserted() {
		int expense = d.dispense(0, 1);
		assertEquals(-1, expense);

	}

	@Test
	public void testDispenseCreditItemSelectedOutOfRange() {
		
		if(!Configuration.flexiblequantity) {
		int expense = d.dispense(25, 21);
		assertEquals(-3, expense);
		expense = d.dispense(25, 0);
		assertEquals(-3, expense);
		}
	}

	@Test
	public void testDispenseCreditItemSoldOut() {

		// for(int x=0; x<20; x++) {
		d.removeItem(1);
		// }
		// int expense = d.dispense( 25, 2 );
		// assertEquals( -4, expense );
		//
	}

	@Test
	public void checkAvailableTest()  {
		    assertFalse(d.checkAvailable(3));	
	}

	@Test
	public void testDispenseCredit() {
		int expense = d.dispense(50, 1);
		assertEquals(50, expense);

		expense = d.dispense(51, 1);
		assertEquals(50, expense);

		expense = d.dispense(100, 19);
		assertTrue(expense == 50);
	}
	@Test
	public void dispenseNotEnoughCreditToPurchaseItem() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(Dispenser.class, "VAL").set(d , 10);
		int expense = d.dispense(10, 2);
		assertEquals(-2, expense);
	}
	
	@Test
	public void dispenseVal() throws IllegalArgumentException, IllegalAccessException {
		int expense = d.dispense(50, 2);
		assertEquals(50, expense);
	}
	
	@Test
	public void availableTest() throws Exception {
		if(!Configuration.flexiblequantity) {
			Boolean test=Whitebox.invokeMethod(d, "available", 22);
			assertFalse(test);
		}
	}
	@Test
	public void dispenseItemSoldOutTest() throws IllegalArgumentException, IllegalAccessException {
		
		int [] values= { 1 };
		MemberModifier.field(Dispenser.class, "availSelectionVals").set(d , values);
		int expense = d.dispense(50, 2);
		assertEquals(-4, expense);
	}
	@Test
	public void removeItemTest() throws IllegalArgumentException, IllegalAccessException {
		int[] stock= (int []) MemberModifier.field(Dispenser.class, "stock").get(d);
		d.removeItem(21);
		int[] stock2= (int []) MemberModifier.field(Dispenser.class, "stock").get(d);
	
		boolean different=false;
		for (int i = 0; i < stock.length; i++) {
			if(stock[i]!=stock2[i]) {
				different=true;
			}
		}
		assertFalse(different);
	}
	
	/**@Test**/
	public void printItemTest() {
		assertTrue(d.printItem().contains("Item: 2	 Stock: 20"));
		assertTrue(d.printItem().contains("Item: 4	 Stock: 0"));
	}

}
