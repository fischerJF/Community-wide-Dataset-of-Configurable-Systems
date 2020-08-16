package atm;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import specifications.Configuration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DepositTest {

	private ATM atm;
	private Deposit dep;

	@Before
	public void setUp() {
		atm = new ATM();

	}

	@After
	public void tearDown() {

	}

	@Test
	public void testPromptForDepositAmountWithValidInput() throws Exception {
		Configuration.DEPOSITING = true;
		if (Configuration.DEPOSITING) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			
			Keypad k = PowerMockito.mock(Keypad.class);
			dep = new Deposit(0, new Screen(atm), new BankDatabase(), k, new DepositSlot());
			int input = 300;
			PowerMockito.when(k.getInput()).thenReturn(input);
			assertEquals(k.getInput(), input);
			double testPrivate = Whitebox.invokeMethod(dep, "promptForDepositAmount");
			assertTrue(testPrivate == 3);
			assertTrue(os.toString().contains("\nPlease enter a deposit amount in "));
			
		}
	}

	@Test
	public void testPromptForDepositAmountWithInvalidInput() throws Exception {
		Configuration.DEPOSITING = true;
		if (Configuration.DEPOSITING) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			
			Keypad k = PowerMockito.mock(Keypad.class);
			dep = new Deposit(0, new Screen(atm), new BankDatabase(), k, new DepositSlot());
			int input = 0;
			PowerMockito.when(k.getInput()).thenReturn(input);
			assertEquals(k.getInput(), input);
			double testPrivate = Whitebox.invokeMethod(dep, "promptForDepositAmount");
			assertTrue(testPrivate == 0);
			assertTrue(os.toString().contains("\nPlease enter a deposit amount in "));

		}
	}

	@Test
	public void testExecute() throws Exception {
		Configuration.DEPOSITING = true;
		if (Configuration.DEPOSITING) {
			DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			Keypad k = PowerMockito.mock(Keypad.class);

			dep = new Deposit(12345, new Screen(atm), bankDatabase, k, depSlot);
			dep.setAmount(100);
			PowerMockito.when(depSlot.isEnvelopeReceived()).thenReturn(true);

			int input = 300;
			PowerMockito.when(k.getInput()).thenReturn(input);
			assertEquals(k.getInput(), input);
			double testPrivate = Whitebox.invokeMethod(dep, "promptForDepositAmount");

			dep.execute();

			assertTrue(bankDatabase.getTotalBalance(12345) == 0);
		}
	}

	@Test
	public void envelopeWasNotReceived() throws Exception {
		Configuration.DEPOSITING = true;
		if (Configuration.DEPOSITING) {
			DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			Keypad k = PowerMockito.mock(Keypad.class);
			Screen screen = PowerMockito.mock(Screen.class);

			dep = new Deposit(12345, screen, bankDatabase, k, depSlot);
			dep.setAmount(100);
			PowerMockito.when(depSlot.isEnvelopeReceived()).thenReturn(false);

			dep.execute();
			// PowerMockito.doAnswer(new Answer<Void>() {
			// public Void answer(InvocationOnMock invocation) {
			// Object[] args = invocation.getArguments();
			// System.out.println("called with arguments: " + Arrays.toString(args));
			// return null;
			// }
			// }).when(screen).displayMessageLine(
			// "\nYou did not insert an envelope, so the ATM has canceled your");

		}
	}

	@Test
	public void testsIfTheDepositHasBeenCanceled() throws Exception {
		Configuration.DEPOSITING = true;
		if (Configuration.DEPOSITING) {
			DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			Keypad k = PowerMockito.mock(Keypad.class);
			Screen screen = PowerMockito.mock(Screen.class);

			dep = new Deposit(12345, screen, bankDatabase, k, depSlot);
			dep.setAmount(0);

			//
			// PowerMockito.doAnswer(new Answer<Void>() {
			// public Void answer(InvocationOnMock invocation) {
			// Object[] args = invocation.getArguments();
			// return null;
			// }
			// }).when(screen).displayMessageLine("");
			//
		}
	}

	@Test
	public void testsTheInstanceOfScreen() throws Exception {
		Screen screen = new Screen(atm);
		dep = new Deposit(0, screen, new BankDatabase(), new Keypad(), new DepositSlot());

		assertEquals(dep.getScreen(), screen);
	}

	@Test
	public void getAmountTest() {
		double v = 100;
		dep = new Deposit(0, new Screen(atm), new BankDatabase(), new Keypad(), new DepositSlot());
		dep.setAmount(v);
		assertTrue(dep.getAmount() == v);
	}

	 @Test
	public void promptForDepositAmount() throws Exception {
//		OutputStream os = new ByteArrayOutputStream();
//		PrintStream ps = new PrintStream(os);
//		System.setOut(ps);
		dep = new Deposit(0, new Screen(atm), new BankDatabase(), new Keypad(), new DepositSlot());

		
	}

}
