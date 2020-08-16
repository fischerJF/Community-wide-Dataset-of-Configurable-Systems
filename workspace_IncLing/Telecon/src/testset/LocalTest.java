package testset;

import org.junit.Before;
import org.junit.Test;
import telecom.Call;
import telecom.Connection;
import telecom.Customer;
import telecom.Local;
import telecom.LongDistance;

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

public class LocalTest {

	private Local local;
	private Customer caller;
	private Customer receiver;

	@Before
	public void setUp() {
		caller = new Customer("Pedro", 11);
		receiver = new Customer("Maria", 22);
		local = new Local(caller, receiver);
	}

	@Test
	public void testLocal() {
		assertEquals(local.getCaller(), caller);
		assertEquals(local.getReceiver(), receiver);
	}
	
	@Test
	public void testGetCaller() {
		assertTrue(local.connectionTime()>=0);
	}
	
	@Test
	public void localTest() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);

		local = new Local(caller, receiver);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		assertTrue(output.toString().contains("[new local connection from Pedro(11) to Maria(22)]"));
	}

}
