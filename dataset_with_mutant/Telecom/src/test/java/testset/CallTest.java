package testset;

import org.junit.Before;
import org.junit.Test;
import telecom.Call;
import telecom.Customer;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class CallTest {

	private Call call;
	private Customer caller;
	private Customer receiver;

	@Before
	public void setUp() {
		caller = new Customer("Pedro", 11);
		receiver = new Customer("Maria", 22);
		call = new Call(caller, receiver);
	}

	@Test
	public void testCall() {
		assertEquals(call.getCaller(), caller);
		assertEquals(call.getReceiver(), receiver);
	}
	@Test
	public void testIsConnected() {
		call.pickup();
		assertTrue(call.isConnected());
	}
	@Test
	public void testIncludes() {
		
		assertTrue(call.includes(receiver));
		assertTrue(call.includes(caller));
		assertFalse(call.includes(new Customer("Maria", 33)));
		
		
	}
	

}
