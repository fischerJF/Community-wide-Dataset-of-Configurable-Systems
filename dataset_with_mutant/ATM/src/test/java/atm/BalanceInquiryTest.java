package atm;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;


import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class BalanceInquiryTest {

	private BalanceInquiry bi;
	@Before
	public void setUp() {
		
	}


	@Test
	public void BalanceInquiryTest() {
		
	}

	
	@Test
	public void printBalanceTest() {
		Configuration.BALANCE_INQUIRY=true;
		Configuration.LOGGING=true;
		 if(Configuration.BALANCE_INQUIRY) {
			 OutputStream os = new ByteArrayOutputStream();
			 PrintStream ps = new PrintStream(os);
			 System.setOut(ps);
			 DepositSlot depSlot = PowerMockito.mock(DepositSlot.class);
			 BankDatabase bankDatabase = PowerMockito.mock(BankDatabase.class);
			
             ATM atm = new ATM();
				
			bi= new BalanceInquiry(12345, new Screen(atm), bankDatabase);
			bi.execute();	
			assertTrue(os.toString().contains("Balance Information:"));		
			assertTrue(os.toString().contains("Available balance:"));		
	        assertTrue(os.toString().contains("Total balance:"));		
	        
	        if(Configuration.LOGGING) {
	        	assertTrue(Logger.returnLogs().contains("User balance:"));
	        }
		 }
	}
	
	@Test
	public void test() {
		
	}
}
