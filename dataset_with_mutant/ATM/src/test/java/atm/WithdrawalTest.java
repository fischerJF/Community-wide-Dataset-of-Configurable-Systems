package atm;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;

import specifications.Configuration;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class WithdrawalTest {

	private ATM atm;
	private Withdrawal withdrawal;

	@Before
	public void setUp() {

		Configuration.LOGGING = true;
		Configuration.DEPOSITING = true;
		Configuration.WITHDRAWING = true;
		Configuration.BALANCE_INQUIRY = true;
		Configuration.ADMIN_CONTROL = true;
		Configuration.USER_INTERFACE = false;
		Configuration.WITHDRAWING_ALL_VALUES = true;
		withdrawal = new Withdrawal(12345, new Screen(atm), new BankDatabase(), new Keypad(), new CashDispenser());

	}

	@Test
	public void getDisplayMenuOfAmounts() throws Exception {
		DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
		BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
		Keypad k = PowerMockito.mock(Keypad.class);
		
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);


		int input = 1;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		int testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 20);

		input = 2;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 40);

		input = 3;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 60);

		input = 4;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 100);

		input = 5;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 200);

		input = 6;
		PowerMockito.when(k.getInput()).thenReturn(input);
		assertEquals(k.getInput(), input);
		withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
		testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
		assertEquals(testPrivate, 6);
		assertTrue(os.toString().contains("Withdrawal Menu:"));
		assertTrue(os.toString().contains("1 - $20"));
		assertTrue(os.toString().contains("2 - $40"));
		assertTrue(os.toString().contains("3 - $60"));
		assertTrue(os.toString().contains("4 - $100"));
		assertTrue(os.toString().contains("5 - $200"));
		assertTrue(os.toString().contains("6 - Cancel transaction"));
		assertTrue(os.toString().contains("\nChoose a withdrawal amount:"));

	}

	@Test
	public void testGetSetAmount() {
		withdrawal.setAmount(100);
		assertEquals(withdrawal.getAmount(), 100);
	}

	@Test
	public void executeInsufficientCashTest() throws Exception {
		Configuration.USER_INTERFACE = false;
		Configuration.WITHDRAWING=true;
		if (!Configuration.USER_INTERFACE && Configuration.WITHDRAWING) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);
			DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			Keypad k = PowerMockito.mock(Keypad.class);

			withdrawal.setAmount(20);
			int input = 2;
			PowerMockito.when(k.getInput()).thenReturn(input);
			assertEquals(k.getInput(), input);
			withdrawal = new Withdrawal(12345, new Screen(atm), bankDatabase, k, new CashDispenser());
			int testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
			
			
			withdrawal.execute();
			
					
			assertTrue(os.toString().contains("Withdrawal Menu:"));
			assertTrue(os.toString().contains("1 - $20"));
			assertTrue(os.toString().contains("2 - $40"));
			assertTrue(os.toString().contains("3 - $60"));
			assertTrue(os.toString().contains("4 - $100"));
			assertTrue(os.toString().contains("5 - $200"));
			assertTrue(os.toString().contains("6 - Cancel transaction"));
			assertTrue(os.toString().contains("\nChoose a withdrawal amount:"));
			
			assertTrue(os.toString().contains("\nInsufficient funds in your account."));
			assertTrue(os.toString().contains("\n\nPlease choose a smaller amount."));
		}
	}
	@Test
	public void testExecute() throws Exception {
		Configuration.USER_INTERFACE = false;
		if (!Configuration.USER_INTERFACE) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);

			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 1;
			PowerMockito.when(k.getInput()).thenReturn(input);
			MemberModifier.field(Withdrawal.class, "keypad").set(withdrawal, k);
			Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");

			withdrawal.execute();
			
			assertTrue(os.toString().contains("Withdrawal Menu:"));
			assertTrue(os.toString().contains("1 - $20"));
			assertTrue(os.toString().contains("2 - $40"));
			assertTrue(os.toString().contains("3 - $60"));
			assertTrue(os.toString().contains("4 - $100"));
			assertTrue(os.toString().contains("5 - $200"));
			assertTrue(os.toString().contains("6 - Cancel transaction"));
			assertTrue(os.toString().contains("\nChoose a withdrawal amount:"));
		
			assertTrue(os.toString().contains("\nChoose a withdrawal amount:"));
			assertTrue(os.toString().contains("Your cash has been dispensed. Please take your cash now."));
		}
	}

	@Test
	public void displayMenuOfAmountsTest() throws Exception {
		Configuration.USER_INTERFACE = false;
		if (!Configuration.USER_INTERFACE) {
			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);

			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 1;
			PowerMockito.when(k.getInput()).thenReturn(input);
			MemberModifier.field(Withdrawal.class, "keypad").set(withdrawal, k);
			Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");

			assertTrue(os.toString().contains("Withdrawal Menu:"));
			assertTrue(os.toString().contains("1 - $20"));
			assertTrue(os.toString().contains("2 - $40"));
			assertTrue(os.toString().contains("3 - $60"));
			assertTrue(os.toString().contains("4 - $100"));
			assertTrue(os.toString().contains("5 - $200"));
			assertTrue(os.toString().contains("6 - Cancel transaction"));
			assertTrue(os.toString().contains("\nChoose a withdrawal amount:"));
		}
	}

	@After
	public void tearDown() {

	}

}
