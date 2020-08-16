package testset;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import bankaccount.Account;
import bankaccount.Application;
import specifications.Configuration;

public class AccountTest {

	Application a;
	Account account;

	@Before
	public void setUp() {
		a = new Application();
		account = new Account();
		
	}

	@Test
	public void testUpdate() {
		a.account.update(100);
		assertTrue(a.account.balance == 100);
		a.account.DAILY_LIMIT = -1000;
		if (Configuration.logging && Configuration.dailylimit) {
			assertFalse((a.account.withdraw + 100) < a.account.DAILY_LIMIT);
		}
		
	}

	@Test
	public void testNextDay() {
//		Configuration.interest=true;
		if (Configuration.interest) {
			a.account.update(100000);
			a.nextDay();
			assertTrue(a.account.interest == 5);
			if (Configuration.dailylimit) {
				assertTrue(a.account.withdraw == 0);
			}
		}
	}

	@Test
	public void testUndoUpdate() {
//		Configuration.dailylimit = false;
//		Configuration.logging = true;
		if (Configuration.logging) {
			a.account.undoUpdate(100000);
			a.account.DAILY_LIMIT = -1000;
			if (Configuration.dailylimit) {
				assertFalse((a.account.withdraw - 100) < a.account.DAILY_LIMIT);
			} else {

				a.account.balance = 0;
				a.account.OVERDRAFT_LIMIT = 100001;
				assertFalse(a.account.undoUpdate(100000));
				a.account.OVERDRAFT_LIMIT = 10;
				a.account.balance = 100;
				a.account.undoUpdate(1);
				assertTrue(a.account.balance == 99);
			}
		}
	}

	@Test
	public void testCalculateInterest() {
		a.account.balance = 10000;
		assertTrue(a.account.calculateInterest() == 0);
	}

	@Test
	public void testEstimatedInterest() {
		a.account.balance = 1000000;
		assertTrue(a.account.estimatedInterest(100) == 5400);
	}

	@Test
	public void testCredit() {
//		Configuration.creditworthiness=true;
		if (Configuration.creditworthiness) {
			a.account.balance = 100;
			assertTrue(a.account.credit(10));
			assertFalse(a.account.credit(150));
		}
	}

	@Test
	public void testLock() {
		a.account.lock();
		assertTrue(a.account.lock);
	}

	@Test
	public void testUnLock() {
		a.account.unLock();
		assertFalse(a.account.lock);
	}

	@Test
	public void testIsLocked() {
		a.account.lock = true;
		assertTrue(a.account.isLocked());
		a.account.lock = false;
		assertFalse(a.account.isLocked());
	}

	@Test
	public void accountTest() {
		assertEquals(0, (new Account()).balance);

	}

	@Test
	public void updateTest() {
		account.update(100);
		assertEquals(100, account.balance);
	}

	@Test
	public void undoUpdateTest() {
		account.update(100);
		account.undoUpdate(100);
		assertEquals(0, account.balance);
	}

	@Test
	public void creditTest() {
		if (Configuration.creditworthiness) {
			account.update(100);
			assertTrue(account.credit(100));
			assertFalse(account.credit(101));
		}
	}

	@Test
	public void updateTest_2() {
		if (Configuration.dailylimit) {
			account.update(10000);
			assertFalse(account.update(-9000));
			assertFalse(account.update(-2000));
		}
	}

	@Test
	public void calculateInterestTest() {
		if (Configuration.interest) {
			if (account.balance >= 0) {
				assertTrue(account.calculateInterest() >= 0);
			} else {
				assertTrue(account.calculateInterest() <= 0);
			}
		}
	}

	@Test
	public void estimatedInterestTest() {
		if (Configuration.interestestimation) {
			account.interest = 100;
			assertTrue(account.estimatedInterest(100) >= 0);
		}
	}
	
	
	@Test
	public void newBalanceTest() {
		
		a.account.OVERDRAFT_LIMIT=100;
//		Configuration.logging=false;
//		Configuration.dailylimit=false;
		if(!Configuration.logging && !Configuration.dailylimit)
			assertFalse(account.update(-50000));
	}
	
	@Test
	public void creditTest_2() {
		if(!Configuration.creditworthiness) {
			assertFalse(account.credit(0));
		}else {
			account.update(10000);
			assertTrue(account.credit(10));
		}
	}
	
	@Test
	public void undoUpdateTest_2() {
		if(!Configuration.logging && Configuration.dailylimit) {
			Account a = new Account();
			a.DAILY_LIMIT=10;
			assertFalse(a.undoUpdate(-1));
		}
		
	}
	
	@Test
	public void  update__BankAccount() throws Exception  {
		if(Configuration.dailylimit) {
		Boolean	test= Whitebox.invokeMethod(account, "update__BankAccount", 100);
			assertTrue(test);
		}
	}
	
	@Test
	public void update__DailyLimit() throws Exception{
		if (Configuration.dailylimit) {
			account.DAILY_LIMIT=10;
			Boolean test=Whitebox.invokeMethod(account, "update__DailyLimit", -1);
			assertFalse(test);
			
//			Configuration.overdraft=false;
			account.OVERDRAFT_LIMIT=100;
			test=Whitebox.invokeMethod(account, "update__DailyLimit", -1);
			assertFalse(test);
		}
		
	}
	
	@Test
	public void updateTest_3()  {
		if (Configuration.dailylimit && Configuration.logging) {
			account.DAILY_LIMIT=10;
			assertFalse(account.update(-1));
		}
	}
	
	@Test
	public void undoUpdate__DailyLimit()throws Exception {
		
		if (Configuration.dailylimit) {
			Boolean test=Whitebox.invokeMethod(account, "update__DailyLimit", -3000);
			assertFalse(test);
		}
	}
	
	@Test
	public void OVERDRAFT_LIMIT_test() {
//		Configuration.overdraft=false;
		if(Configuration.overdraft) {
			account = new Account();
			assertTrue(account.OVERDRAFT_LIMIT==-5000);
		}else {  
			account = new Account();
			assertTrue(account.OVERDRAFT_LIMIT==0);
		}
	}
	@Test
	public void undoUpdate__DailyLimit_2() throws Exception{
		 if (Configuration.dailylimit) {
			 account.DAILY_LIMIT=3001;
			 Boolean test=Whitebox.invokeMethod(account, "undoUpdate__DailyLimit", -3000);
				assertFalse(test);
		 }
	}
	@Test
	public void undoUpdate__DailyLimit_3() throws Exception{
		 if (Configuration.dailylimit) {
			 account.balance=10;
			 account.OVERDRAFT_LIMIT=100;
			 Boolean test=Whitebox.invokeMethod(account, "undoUpdate__DailyLimit", 1);
				assertFalse(test);
		 }
	}
	
}
