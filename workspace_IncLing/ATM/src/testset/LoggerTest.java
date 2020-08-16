package testset;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import atm.ATM;
import atm.Logger;
import atm.Screen;
import specifications.Configuration;

public class LoggerTest {

	private Logger logger;

	@Before
	public void setUp() {
		logger = new Logger();
	}

	@Test
	public void printLogTest() {
		if (Configuration.LOGGING) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);
			ATM atm = new ATM();
			Screen screen = new Screen(atm);
			Logger.log("test");
			logger.printLog(screen);

			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());
			//assertTrue(output.toString().contains("test"));
		}
	}

	@Test
	public void returnLogsTest() {
		Logger.log("test");
		String output = logger.returnLogs();
		assertTrue(output.contains("test"));
	}

	@Test
	public void resetLogTest() {
		Logger.log("test");
		logger.resetLog();
		String output = logger.returnLogs();
		assertEquals(output, "");
	}

}
