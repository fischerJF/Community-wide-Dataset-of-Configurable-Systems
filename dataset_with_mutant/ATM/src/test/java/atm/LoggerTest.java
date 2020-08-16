package atm;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

public class LoggerTest {

	private Logger logger;
	@Before
	public void setUp() {
		logger=new Logger();
	}

	@Test
	public void printLogTest() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		ATM atm = new ATM();
		Screen screen = new Screen(atm);
		Logger.log("test");
		logger.printLog(screen);
		assertTrue(os.toString().contains("test"));
	}
	
	@Test
	public void returnLogsTest() {
		Logger.log("test");
		String output= logger.returnLogs();
		assertTrue(output.contains("test"));
	}
	@Test
	public void resetLogTest() {
		Logger.log("test");
		logger.resetLog();
		String output= logger.returnLogs();
		assertEquals(output, "");
	}
	
}
