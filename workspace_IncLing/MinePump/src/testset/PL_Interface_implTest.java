package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import MinePumpSystem.Actions;
import MinePumpSystem.Environment;
import MinePumpSystem.MinePump;
import MinePumpSystem.PL_Interface_impl;
import MinePumpSystem.Environment.WaterLevelEnum;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Constructor;

public class PL_Interface_implTest {

	PL_Interface_impl pl ;
	
	@Before
	public void setup() {
		pl= new PL_Interface_impl();
    }

	
	@Test
	public void attributeInitializationTest() throws Exception {
	
		//	assertEquals(MemberModifier.field(PL_Interface_impl.class, "executedUnimplementedAction").get(pl),false);
		assertEquals(MemberModifier.field(PL_Interface_impl.class, "cleanupTimeShifts").get(pl),4);
//		assertEquals(MemberModifier.field(PL_Interface_impl.class, "verbose").get(pl),false);
	}
	
	@Test
	public void getBoolean() {
		assertTrue(pl.getBoolean());
	}
	@Test
	public void getIntegerMinMaxTest() {
		assertEquals(pl.getIntegerMinMax(0, 0), 1);
	}
	
	@Test 
	public void  getExecutedActionsTest() {
		pl= new PL_Interface_impl();
		pl.getExecutedActions();
		
		assertTrue(pl.actionHistory != null);
	}

	@Test 
	public void isAbortedRunTest() {
		assertFalse(pl.isAbortedRun());
	}
	@Test 
	public void listToStringTest() throws Exception {
		ArrayList<String> list= new ArrayList<String>();
		list.add("test1");
		list.add("test2");
		String e= Whitebox.invokeMethod(pl, "listToString", list);
		System.out.println(e);
		assertEquals(e, " test1 test2");
		
	}
	//**@Test**/
	public void mainPL_Interface_implTest() {
		try {
			PL_Interface_impl impl = new PL_Interface_impl();
			MemberModifier.field(PL_Interface_impl.class, "verbose").set(pl, true);
			impl.start(1, 4);
			System.out.println("no Exception");
		} catch (Throwable e) {
			System.out.println("Caught Exception: " + e.getClass() + " "
					+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	


	@Test 
	public void mainTest() throws Throwable {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
		MemberModifier.field(PL_Interface_impl.class, "verbose").set(pl, true);
		
		impl.start(1, 4);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		assertTrue(output.toString().contains("Started MinePump PL with Specification 1, Variation: 4"));
	}
	
	//**@Test**/
	public void randomSequenceOfActionTest() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();

		impl.randomSequenceOfActions(3);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		
		assertTrue(output.toString().contains("rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		
	}
	@Test 
	public void startTest() throws Throwable {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
		MemberModifier.field(PL_Interface_impl.class, "verbose").set(pl, true);

		impl.start(4, 3);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		
		assertTrue(output.toString().contains("Started MinePump PL with Specification 4, Variation: 3 rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
	}
	
//	@Test 
	public void test_1() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		
		impl.test(1, 4);
		assertTrue(output.toString().contains("rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));

	}
//	@Test 
	public void test_2() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		impl.test(-1, 1);
		assertTrue(output.toString().contains("rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		
	}
	@Test 
	public void test_3() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
		
		impl.test(-1, 1);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		assertTrue(output.toString().contains("rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		
	}
	@Test 
	public void test_4() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		PL_Interface_impl impl = new PL_Interface_impl();
	
		impl.test(-1, 4);
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
		
		assertTrue(output.toString().contains("rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:CRIT)"));
		assertTrue(output.toString().contains("rise methChange start  rise methChange start  rise methChange start  rise methChange start"));
		assertTrue(output.toString().contains("Pump(System:On,Pump:Off) Env(Water:high,Meth:OK)"));

	}
	
}
