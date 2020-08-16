package testset;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;

import specifications.Configuration;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import telecom.AbstractSimulation;
import telecom.BasicSimulation;
import telecom.Call;
import telecom.Customer;
import telecom.Historic;

public class BasicSimulationTest {

	@Before
	public void setUp() {
		Configuration.HISTORIC = true;
	}

	//@Test
	public void testAddCall() throws Exception {
//		Configuration.HISTORIC = true;
		if (Configuration.HISTORIC) {
			Historic.resetRecords();
			BasicSimulation cls = Mockito.mock(BasicSimulation.class);
			double v = 2.0;
			Whitebox.invokeMethod(cls, "wait", v);
			assertEquals(Historic.returnRecords(),"\nwait: 2.0" );
		}
	}
	
	//@Test 
	public void sayTest() throws Exception {
//		Configuration.HISTORIC = true;
		if (Configuration.HISTORIC) {
			Historic.resetRecords();
			AbstractSimulation cls = Mockito.mock(BasicSimulation.class);
			
			Whitebox.invokeMethod(cls, "say", "Test");
			assertEquals(Historic.returnRecords(),"\nTest" );
		}
	}
	
	@Test
	public void runTest() {
		
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		BasicSimulation bs= new BasicSimulation();
        bs.run();
        
        System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
        
        assertTrue(output.toString().contains("jim calls mik..."));
        assertTrue(output.toString().contains("[new local connection from Jim(650) to Mik(650)]"));
        assertTrue(output.toString().contains("mik accepts..."));
        assertTrue(output.toString().contains("connection completed"));
        assertTrue(output.toString().contains("crista accepts..."));
        assertTrue(output.toString().contains("crista hangs up..."));
          
	}
	
	@Test
	public void reportTest() throws Exception {
		Customer jim = new Customer("Jim", 650);
		BasicSimulation bs= new BasicSimulation();
		Whitebox.invokeMethod(bs, "report", jim);
	}

}
