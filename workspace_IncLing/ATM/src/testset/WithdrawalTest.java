package testset;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import atm.ATM;
import atm.ATMUserInterface;
import atm.BankDatabase;
import atm.CashDispenser;
import atm.DepositSlot;
import atm.Keypad;
import atm.Screen;
import atm.Withdrawal;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import javax.swing.JFrame;

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

public class WithdrawalTest {

	private ATM atm;
	private Withdrawal withdrawal;
	private Screen screen;

	@Before
	public void setUp() {

//		Configuration.LOGGING = true;
//		Configuration.DEPOSITING = true;
//		Configuration.WITHDRAWING = true;
//		Configuration.BALANCE_INQUIRY = true;
//		Configuration.ADMIN_CONTROL = true;
//		Configuration.USER_INTERFACE = false;
//		Configuration.WITHDRAWING_ALL_VALUES = true;
		screen =new Screen(atm);
		withdrawal = new Withdrawal(12345, screen, new BankDatabase(), new Keypad(), new CashDispenser());

	}

//	@Test
	public void getDisplayMenuOfAmounts() throws Exception {
	
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);
		
		DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
		BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
		Keypad k = PowerMockito.mock(Keypad.class);
	


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
		
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());

		assertTrue(output.toString().contains("Withdrawal Menu:"));
		assertTrue(output.toString().contains("1 - $20"));
		assertTrue(output.toString().contains("2 - $40"));
		assertTrue(output.toString().contains("3 - $60"));
		assertTrue(output.toString().contains("4 - $100"));
		assertTrue(output.toString().contains("5 - $200"));
		assertTrue(output.toString().contains("6 - Cancel transaction"));
		assertTrue(output.toString().contains("\nChoose a withdrawal amount:"));

	}

	@Test
	public void testGetSetAmount() {
		withdrawal.setAmount(100);
		assertEquals(withdrawal.getAmount(), 100);
	}

	@Test
	public void executeInsufficientCashTest() throws Exception {
//		Configuration.USER_INTERFACE = false;
//		Configuration.WITHDRAWING=true;
		if (!Configuration.USER_INTERFACE && Configuration.WITHDRAWING) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);
			DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			Keypad k = PowerMockito.mock(Keypad.class);

			withdrawal.setAmount(20);
			int input = 2;
			PowerMockito.when(k.getInput()).thenReturn(input);
			assertEquals(k.getInput(), input);
			withdrawal = new Withdrawal(12345, screen, bankDatabase, k, new CashDispenser());
			int testPrivate = Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");
			
			
			withdrawal.execute();
			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());
					
			assertTrue(output.toString().contains("Withdrawal Menu:"));
			assertTrue(output.toString().contains("1 - $20"));
			assertTrue(output.toString().contains("2 - $40"));
			assertTrue(output.toString().contains("3 - $60"));
			assertTrue(output.toString().contains("4 - $100"));
			assertTrue(output.toString().contains("5 - $200"));
			assertTrue(output.toString().contains("6 - Cancel transaction"));
			assertTrue(output.toString().contains("\nChoose a withdrawal amount:"));
			
			assertTrue(output.toString().contains("\nInsufficient funds in your account."));
			assertTrue(output.toString().contains("\n\nPlease choose a smaller amount."));
		}
	}
	@Test
	public void testExecute() throws Exception {
//		Configuration.USER_INTERFACE = false;
		if (!Configuration.USER_INTERFACE && Configuration.WITHDRAWING) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);
			
			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 1;
			PowerMockito.when(k.getInput()).thenReturn(input);
			MemberModifier.field(Withdrawal.class, "keypad").set(withdrawal, k);
			Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");

			withdrawal.execute();

			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());

			assertTrue(output.toString().contains("Withdrawal Menu:"));
			assertTrue(output.toString().contains("1 - $20"));
			assertTrue(output.toString().contains("2 - $40"));
			assertTrue(output.toString().contains("3 - $60"));
			assertTrue(output.toString().contains("4 - $100"));
			assertTrue(output.toString().contains("5 - $200"));
			assertTrue(output.toString().contains("6 - Cancel transaction"));
			assertTrue(output.toString().contains("\nChoose a withdrawal amount:"));
		
			assertTrue(output.toString().contains("\nChoose a withdrawal amount:"));
			assertTrue(output.toString().contains("Your cash has been dispensed. Please take your cash now."));
		}
	}

	@Test
	public void displayMenuOfAmountsTest() throws Exception {
//		Configuration.USER_INTERFACE = false;
		if (!Configuration.USER_INTERFACE) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);

			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 1;
			PowerMockito.when(k.getInput()).thenReturn(input);
			MemberModifier.field(Withdrawal.class, "keypad").set(withdrawal, k);
			Whitebox.invokeMethod(withdrawal, "displayMenuOfAmounts");

			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());

			assertTrue(output.toString().contains("Withdrawal Menu:"));
			assertTrue(output.toString().contains("1 - $20"));
			assertTrue(output.toString().contains("2 - $40"));
			assertTrue(output.toString().contains("3 - $60"));
			assertTrue(output.toString().contains("4 - $100"));
			assertTrue(output.toString().contains("5 - $200"));
			assertTrue(output.toString().contains("6 - Cancel transaction"));
			assertTrue(output.toString().contains("\nChoose a withdrawal amount:"));
		}
	}

	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		ATMUserInterface gui=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(screen);
		
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.dispose();

	}

}
