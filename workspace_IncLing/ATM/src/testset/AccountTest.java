package testset;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;

import atm.ATM;
import atm.ATMUserInterface;
import atm.Account;
import atm.Screen;
import specifications.Configuration;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.swing.JFrame;

public class AccountTest {

	private ATM atm;
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
		atm = new ATM();

	}

	@After
	public void tearDown() throws IllegalArgumentException, IllegalAccessException {
		Screen s=	(Screen) MemberModifier.field(ATM.class, "screen").get(atm);
		ATMUserInterface f=	(ATMUserInterface) MemberModifier.field(Screen.class, "frame").get(s);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.dispose();
	}

	@Test
	public void testValidPin() {
		atm.setCurrentAccountNumber(12345);
		Account  a= new Account(12345,54321,1000,1000);
		assertTrue(a.validatePIN(54321));
		assertFalse(a.validatePIN(22222));
		
	}
	
	@Test
	public void getTotalBalanceTest() {
		
		Account a= new Account(12345, 54321, 100, 200);
		double v=200.0;
		assertTrue(a.getTotalBalance()==v);
		
	}
	
	@Test
	public void creditTest() {
		Account a= new Account(12345, 54321, 100, 200);
		double v=400.0;
		a.credit(200);
		assertTrue(a.getTotalBalance()==v);
	}
	
	@Test 
	public void debitTest() throws IllegalArgumentException, IllegalAccessException {
		Account a= new Account(12345, 54321, 100, 200);
		double v=100.0;
		a.debit(100);
		assertTrue(a.getTotalBalance()==v);
		double  balance = (double ) MemberModifier.field(Account.class, "availableBalance").get(a);
		 v=0.0;
		 assertTrue(balance==v);
	}
	

}
