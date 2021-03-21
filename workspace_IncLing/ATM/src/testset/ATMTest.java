package testset;


import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import atm.ATM;
import atm.ATMUserInterface;
import atm.BalanceInquiry;
import atm.BankDatabase;
import atm.CashDispenser;
import atm.Deposit;
import atm.DepositSlot;
import atm.Keypad;
import atm.Screen;
import atm.Transaction;
import atm.Withdrawal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import specifications.Configuration;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;

import javax.swing.JFrame;

public class ATMTest {

	private ATM atm;
	private Transaction trans;
	private Screen screen;

	@Before
	public void setUp() {

//		Configuration.LOGGING = true;
//		Configuration.DEPOSITING = true;
//		Configuration.WITHDRAWING = true;
//		Configuration.BALANCE_INQUIRY = true;
//		Configuration.ADMIN_CONTROL = true;
//		Configuration.USER_INTERFACE = true;
//		Configuration.WITHDRAWING_ALL_VALUES = true;
//		
		atm = new ATM();
		screen = new Screen(atm);
		
	}

	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		Screen s=	(Screen) MemberModifier.field(ATM.class, "screen").get(atm);
		ATMUserInterface f=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
		
		ATMUserInterface frame=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(screen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.dispose();
	}

	@Test
	public void testsCurrentTransactionIsScreenInstance() throws Exception {
		trans = new Deposit(0, screen, new BankDatabase(), new Keypad(), new DepositSlot());
		assertEquals(trans.getScreen(), screen);
	}

	@Test
	public void testsCurrentTransactionIsWithdrawalInstance() throws Exception {
//		Configuration.WITHDRAWING =true;
//		Configuration.USER_INTERFACE=true;
		if (Configuration.WITHDRAWING && Configuration.USER_INTERFACE) {
			atm.setCurrentAccountNumber(12345);
			atm.Withdrawal(100);
			assertTrue(atm.getCurrentTransaction() instanceof Withdrawal);
		}
	}

	@Test
	public void testCurrentTransactionIsBalanceInstance() {
//		Configuration.BALANCE_INQUIRY=true;
		if (Configuration.BALANCE_INQUIRY) {
			atm.setCurrentAccountNumber(12345);
			atm.balance();
			assertTrue(atm.getCurrentTransaction() instanceof BalanceInquiry);
		}
	}

	@Test
	public void testGetTotalDeposit() {
//		Configuration.DEPOSITING=true;
//		Configuration.USER_INTERFACE=true;
		if (Configuration.DEPOSITING && Configuration.USER_INTERFACE) {
			atm.setCurrentAccountNumber(12345);
			atm.deposit(100);
	//		assertEquals(atm.getTotalDeposit(), 100);
		}
	}

	@Test
	public void testSetCurrentTransaction() {
//		Configuration.DEPOSITING=true;
//		Configuration.USER_INTERFACE=true;
//		Configuration.BALANCE_INQUIRY=true;
//		Configuration.WITHDRAWING=true;
		if (Configuration.DEPOSITING && Configuration.USER_INTERFACE) {
			trans = new Deposit(0, screen, new BankDatabase(), new Keypad(), new DepositSlot());
			atm.setCurrentTransaction(trans);
			assertTrue(atm.getCurrentTransaction() instanceof Deposit);
		}
		if (Configuration.BALANCE_INQUIRY && Configuration.USER_INTERFACE) {
			trans = new BalanceInquiry(0, screen, new BankDatabase());
			atm.setCurrentTransaction(trans);
			assertTrue(atm.getCurrentTransaction() instanceof BalanceInquiry);
		}
		if (Configuration.WITHDRAWING && Configuration.USER_INTERFACE) {
			trans = new Withdrawal(0, screen, new BankDatabase(), new Keypad(), new CashDispenser());
			atm.setCurrentTransaction(trans);
			assertTrue(atm.getCurrentTransaction() instanceof Withdrawal);
		}
	}

	@Test
	public void testGetDepositSlot() {
//		Configuration.DEPOSITING=true;
//		Configuration.USER_INTERFACE=true;
		if (Configuration.DEPOSITING && Configuration.USER_INTERFACE) {
			atm.setCurrentAccountNumber(12345);
			atm.deposit(100);
			Deposit d = (Deposit) atm.getCurrentTransaction();
			assertEquals(atm.getDepositSlot(), d.getDepositSlot());
		}
	}
	
	@Test
	public void testCreateTransaction() throws Exception {
		
		if(!Configuration.USER_INTERFACE && Configuration.BALANCE_INQUIRY && Configuration.DEPOSITING && Configuration.WITHDRAWING) {
			ATM a = PowerMockito.mock(ATM.class);
			Transaction trans = Whitebox.invokeMethod(a, "createTransaction",1);
			assertTrue(trans instanceof BalanceInquiry);
			trans = Whitebox.invokeMethod(a, "createTransaction",2);
			assertTrue(trans instanceof Withdrawal);
			trans = Whitebox.invokeMethod(a, "createTransaction",3);
			assertTrue(trans instanceof Deposit);
		}
	}
	@Test
	public void testDisplayMainMenu() throws Exception {
//		Configuration.USER_INTERFACE=false;
//		Configuration.BALANCE_INQUIRY=true;
//		Configuration.WITHDRAWING=true;
//		Configuration.DEPOSITING=true;
//		Configuration.LOGGING=true;
		
		if(!Configuration.USER_INTERFACE) {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);
			
			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 1;
			
			PowerMockito.when(k.getInput()).thenReturn(input);
			
			MemberModifier.field(ATM.class, "keypad").set(atm , k);
		    
			int option= Whitebox.invokeMethod(atm, "displayMainMenu");
		    assertEquals(option,input);		
		    System.setOut(originalPrintStream);
		    String output = new String(stream.toByteArray());		    
		    if(Configuration.BALANCE_INQUIRY) {
		    	assertTrue(output.toString().contains("1 - View my balance"));
		    }
		    if (Configuration.WITHDRAWING) {
		      	assertTrue(output.toString().contains("2 - Withdraw cash"));
		    }
		    if (Configuration.DEPOSITING) {
		    	assertTrue(output.toString().contains("3 - Deposit funds"));
		    }
		}
	}
	@Test
	public void testAuthenticateUser() throws Exception {
//		Configuration.USER_INTERFACE=false;
		if (!Configuration.USER_INTERFACE) {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);

			
			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 12345;
			int input2 = 54321;
			PowerMockito.when(k.getInput()).thenReturn(input);
			PowerMockito.when(k.getInput()).thenReturn(input2);
			MemberModifier.field(ATM.class, "keypad").set(atm , k);
			MemberModifier.field(ATM.class, "accountNumber").set(atm , 12345);
			MemberModifier.field(ATM.class, "pin").set(atm , 54321);
			Whitebox.invokeMethod(atm, "authenticateUser");
			assertEquals(MemberModifier.field(ATM.class, "pin").get(atm),54321);
			
			System.setOut(originalPrintStream);
			String output = new String(stream.toByteArray());
			
			assertTrue(output.toString().contains("\nPlease enter your account number: "));
			assertTrue(output.toString().contains("\nEnter your PIN: "));
			
		}
	}
	@Test
	public void authenticateUserTest() throws Exception {
//		Configuration.USER_INTERFACE=false;
		if (!Configuration.USER_INTERFACE) {

			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(stream);
			PrintStream originalPrintStream = System.out;
			System.setOut(ps);

			
			Keypad k = PowerMockito.mock(Keypad.class);
			int input = 66645;
			int input2 = 66321;
			PowerMockito.when(k.getInput()).thenReturn(input);
			PowerMockito.when(k.getInput()).thenReturn(input2);
			MemberModifier.field(ATM.class, "keypad").set(atm , k);
		    MemberModifier.field(ATM.class, "accountNumber").set(atm , 12345);
		    MemberModifier.field(ATM.class, "pin").set(atm , 54321);
			Whitebox.invokeMethod(atm, "authenticateUser");
		    assertEquals(MemberModifier.field(ATM.class, "pin").get(atm), 66321);
		    
		    System.setOut(originalPrintStream);
		    String output = new String(stream.toByteArray());
		    
		    assertTrue(output.toString().contains("\nPlease enter your account number: "));
		    assertTrue(output.toString().contains("\nEnter your PIN: "));
			assertTrue(output.toString().contains("Invalid account number or PIN. Please try again."));

		}
	}
	@Test
	public void testDisplayMainMenuDisableUSER_INTERFACE() throws Exception {
//		Configuration.USER_INTERFACE=true;
		if(Configuration.USER_INTERFACE) {
			int option= Whitebox.invokeMethod(atm, "displayMainMenu");
		    assertEquals(option,0);		
		}
	}
//	@Test
    public void runTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.USER_INTERFACE=false;
		if(!Configuration.USER_INTERFACE) {
//			OutputStream os = new ByteArrayOutputStream();
//			PrintStream ps = new PrintStream(os);
//			System.setOut(ps);
			 MemberModifier.field(ATM.class,"userAuthenticated" ).set(atm,true);
			atm.run();
//			assertTrue(os.toString().contains("\nWelcome!"));
			
		}
	}
	
	@Test
	public void isUserExitedTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(ATM.class, "userExited").set(atm, true);
		assertTrue(atm.isUserExited());
	}
	
	@Test
	public void setUserExitedTest() throws IllegalArgumentException, IllegalAccessException {
		atm.setUserExited(true);
		boolean b= (boolean) MemberModifier.field(ATM.class, "userExited").get(atm);
		assertTrue(atm.isUserExited());
	}
	
	@Test
	public void isUserAuthenticatedTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(ATM.class, "userAuthenticated").set(atm, true);
		assertTrue(atm.isUserAuthenticated());
	}
	
	@Test
	public void setUserAuthenticatedTest() throws IllegalArgumentException, IllegalAccessException {
		atm.setUserAuthenticated(true);
		boolean b= (boolean) MemberModifier.field(ATM.class, "userAuthenticated").get(atm);
		assertTrue(atm.isUserAuthenticated());
	}
	
	@Test
	public void getScreenTest() {
		assertTrue(atm.getScreen()!= null);
		assertTrue(atm.getScreen() instanceof Screen);
	}
	
	@Test
	public void getTotalDepositTest() throws IllegalArgumentException, IllegalAccessException {
		double v=2;
		MemberModifier.field(ATM.class, "totalDeposit").set(atm, v);
		assertEquals(atm.getTotalDeposit(), 2,0);
	}
	
	@Test
	public void getDepositSlot() {
		assertTrue(atm.getDepositSlot()!= null);
		assertTrue(atm.getDepositSlot() instanceof DepositSlot);
	}
	
	@Test
	public void getCurrentAccountNumbeTest() throws IllegalArgumentException, IllegalAccessException {
		MemberModifier.field(ATM.class, "currentAccountNumber").set(atm, 12345);
		assertEquals(atm.getCurrentAccountNumber(), 12345);
	}
	
	@Test
	public void setCurrentAccountNumberTest() throws IllegalArgumentException, IllegalAccessException {
		int v=54321;
		MemberModifier.field(ATM.class, "currentAccountNumber").set(atm, v);
		assertEquals(atm.getCurrentAccountNumber(), v);
	}
	
	@Test
	public void depositTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.DEPOSITING=true;
		if (Configuration.DEPOSITING) {
			double v=100;
			MemberModifier.field(ATM.class, "totalDeposit").set(atm, v);
			assertEquals(atm.getTotalDeposit(), 100,0);
		}
	}
	
	
}
