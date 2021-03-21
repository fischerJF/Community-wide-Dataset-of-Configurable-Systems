package testset;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;

import atm.ATM;
import atm.ATMUserInterface;
import atm.Logger;
import atm.Screen;
import specifications.Configuration;

public class LoggerTest {

	private Logger logger;
	private Screen screen;
	@Before
	public void setUp() {
		logger = new Logger();
	}

	/*@Test*/
	public void printLogTest() {
		if (Configuration.LOGGING) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);
			ATM atm = new ATM();
			screen = new Screen(atm);
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
	
	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		ATMUserInterface gui=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(screen);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.dispose();

	}
}
