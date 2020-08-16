package testset;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;


import static org.mockito.Matchers.anyObject;
import specifications.Configuration;
import telecom.Customer;
import telecom.LongDistance;
import telecom.Timer;

public class LongDistanceTest {

	private LongDistance ld;
	private Customer customerA;
	private Customer customerB;
	
	@Before
	public void setUp() {
		customerA = new Customer("Pedro", 12);
    	customerB = new Customer("Bob", 15);
		  
	}

	@Test
	public void longDistanceTest() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);

		ld= new LongDistance(customerA, customerB);
		
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());		
		
		assertTrue(output.toString().contains("[new long distance connection from Pedro(12) to Bob(15)]"));
			
	}

}

