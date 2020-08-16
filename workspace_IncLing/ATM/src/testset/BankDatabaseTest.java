package testset;

import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import atm.ATM;
import atm.Account;
import atm.BankDatabase;
import atm.Logger;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
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
//import static org.hamcrest.MatcherAssert.assertThat;

public class BankDatabaseTest {

	private ATM atm;
	private BankDatabase bdb;

	@Before
	public void setUp() {
		bdb = new BankDatabase();

	}

	@Test
	public void authenticateUserTest() {
//		Configuration.LOGGING=true;
		assertTrue(bdb.authenticateUser(12345, 54321));
		 if(Configuration.LOGGING) {
			 assertTrue(Logger.returnLogs().contains("User: 12345"));
		 }
		 assertFalse(bdb.authenticateUser(55555, 55555));
	}
	
	@Test
	public void debitTest() {
//		Configuration.LOGGING=true;
		bdb.debit(12345, 100);
		 if(Configuration.LOGGING) {
			 assertTrue(Logger.returnLogs().contains("12345 withdrew 100.0"));
		 }
	}
	
	@Test 
	public void creditTest() {
//		Configuration.LOGGING=true;
		
		bdb.credit(12345, 10);
		
		if(Configuration.LOGGING) {
			 assertTrue(Logger.returnLogs().contains("12345 made a deposit of 10.0"));
		 }
	}
	
	@Test
	public void getTotalBalance() {
		
		double v=1200.0;
		assertTrue(bdb.getTotalBalance(12345)==v);
	}
	
	@Test
	public void getAccount() throws Exception {
		Account [] acount = (Account[]) MemberModifier.field(BankDatabase.class, "accounts").get(bdb);
		Account a = Whitebox.invokeMethod(bdb, "getAccount", 12345);
		assertEquals(acount[0], a);
		a = Whitebox.invokeMethod(bdb, "getAccount", 55555);
		assertNotEquals(acount[0], a);
	  
	}
}
