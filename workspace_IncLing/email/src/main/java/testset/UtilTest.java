package testset;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import EmailSystem.Client;
import EmailSystem.Email;
import EmailSystem.Util;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;


public class UtilTest {

	
	private Util util;

	@Before
	public void setup() {
		util= new Util();
	}

	@Test
	public void promptTest() {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);

		util.prompt(100);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());

		assertEquals(output.toString(),"100\r\n");
	}
	
	
}