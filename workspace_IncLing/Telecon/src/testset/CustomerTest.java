package testset;


import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import telecom.Call;
import telecom.Customer;
import telecom.Historic;

public class CustomerTest {

	private Customer customer;
	
	@Before
	public void setUp() {
	   customer = new Customer("Pedro", 11);
	}
	@Test
	public void testAddCall() throws Exception {
		Call call_1 = new Call(new Customer("Pedro", 11), new Customer("Maria", 22));
		Whitebox.invokeMethod(customer, "addCall", call_1);
		Call call_2 = new Call(new Customer("Pedro", 11), new Customer("Marcos", 33));
		Whitebox.invokeMethod(customer, "addCall", call_2);
		assertEquals(customer.getCall().get(0), call_1);
		assertEquals(customer.getCall().get(1), call_2);
		
	}
	
	@Test
	public void testRemoveCall() throws Exception {
		Call call_1 = new Call(new Customer("Pedro", 11), new Customer("Maria", 22));
		Whitebox.invokeMethod(customer, "addCall", call_1);
		assertEquals(customer.getCall().size(),1);
		Whitebox.invokeMethod(customer, "removeCall", call_1);
		assertEquals(customer.getCall().size(),0);
	}
	
	@Test
	public void testToString() {
		assertEquals(customer.toString(), "Pedro(11)");
	}
	@Test
	public void testGetAreacode() {
		assertEquals(customer.getAreacode(), 11);
	}
	@Test
	public void testIncreaseTotalConnectTime() {
		customer.increaseTotalConnectTime(100);
		assertEquals(customer.getTotalConnectTime(),100);
	}

	@Test
	public void testMerge() throws Exception {
		Call call_1 = new Call(new Customer("Pedro", 11), new Customer("Maria", 22));
		Whitebox.invokeMethod(customer, "addCall", call_1);
		Call call_2 = new Call(new Customer("Pedro", 11), new Customer("Marcos", 33));
		Whitebox.invokeMethod(customer, "addCall", call_2);
		customer.merge(call_1, call_2);
		assertEquals(customer.getCall().size(),1);
	}
	@Test
	public void testPickup() throws Exception {
		Call call_1 = new Call(new Customer("Pedro", 11), new Customer("Maria", 22));
		customer.pickup(call_1);
		assertEquals(customer.getCall().size(),1);
	}
	@Test
	public void testHangup() throws Exception {
		Call call_1 = new Call(new Customer("Pedro", 11), new Customer("Maria", 22));
		Whitebox.invokeMethod(customer, "addCall", call_1);
		customer.hangup(call_1);
		assertEquals(customer.getCall().size(),0);
	}
	@Test
	public void testLocalTo() throws Exception {
		Customer c1= new Customer("Maria", 11);
		assertTrue(customer.localTo(c1));
		Customer c2= new Customer("Maria", 12);		
		assertFalse(customer.localTo(c2));
	}
	@Test
	public void testCall() throws Exception {
		Customer c1= new Customer("Maria", 11);
		assertTrue(customer.call(c1) instanceof Call);
		assertEquals(customer.getCall().size(),1);
		
	}
}
