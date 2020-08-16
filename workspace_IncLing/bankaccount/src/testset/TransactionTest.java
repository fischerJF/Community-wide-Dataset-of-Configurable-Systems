package testset;


import static org.junit.Assert.*;

import org.junit.Test;
import org.powermock.reflect.Whitebox;
import org.junit.Before;

import bankaccount.Account;
import bankaccount.Application;
import bankaccount.Transaction;
import specifications.Configuration;

public class TransactionTest {
	Application a;
    Application b;
	
	@Before
	public void setUp(){
		
		
//		 Configuration.transactionlog=false; //sim
//		 Configuration. transaction=false; // nao  
//		 Configuration. overdraft=true; 
//		 Configuration. logging=false; 
//		 Configuration. lock=true; 
//		 Configuration. interestestimation=false; 
//		 Configuration. interest=false; 
//		 Configuration. dailylimit=true; 
//		 Configuration. creditworthiness=true; 
//		 Configuration. bankaccount=true; 
		a= new Application();
		b= new Application();
		
	}
	@Test
	public void testTransfer() {
//		Configuration.transaction=true;
		a= new Application();
		b= new Application();
	    if (Configuration.bankaccount) {
            getA().account.update(100);
            getB().account.update(200);
            getA().nextDay();
            getB().nextYear();
        }

        if (Configuration.creditworthiness) {
            getA().account.credit(10);
            getB().account.credit(20);
        }
        
         if (Configuration.transaction &&!Configuration.transactionlog) {
        	Account accountA = new Account();
     		Account accountB = new Account();
     		accountA.update(100);
     		accountB.update(200);
            new Transaction().transfer(accountA, accountB, 30);
            assertTrue(accountA.balance==70);
            assertTrue(accountB.balance==230);
            
        }
	}
	private Application getA() {
        return a;
    }

    private Application getB() {
        return b;
    }
    @Test
	public void testTransactionJPF() {
		if (Configuration.transaction) {
			testTransaction();
		}
	}
    public void testTransaction() {
		Account[] accounts = new Account[]{new Account(),new Account(),new Account()};
		for (Account a : accounts) {
			a.balance = 1000;
		}
		
		/* serially transactions */
		new Transaction().transfer(accounts[0], accounts[1], 100);
		new Transaction().transfer(accounts[1], accounts[2], 150);
		new Transaction().transfer(accounts[2], accounts[1], 250);
		
		
		int i = 0;
		int counter = 0;
		for (Account a : accounts) {
			System.out.println("A" + counter++ + " : " + a.balance);
			i+=a.balance;
		}
		assertEquals(i, 1000 * accounts.length);
	}
    
    @Test
	public void testTransfer_2() {
    	Transaction t= new Transaction();
//    	Configuration.transactionlog=false;
//    	Configuration.logging=false;
//    	Configuration.overdraft=true;
    	
    	if (!Configuration.transactionlog && !Configuration.logging && Configuration.overdraft && Configuration.dailylimit) {
    		assertFalse(t.transfer(new Account(), new Account(), 0));
    		Transaction t2= new Transaction(); 
    		
    		Account a=new Account();
    		Account b=new Account();
    		assertTrue(t2.transfer(a, b, 200));
    		assertTrue(b.balance==200);
    		Transaction t3= new Transaction();    
    		Account a2=new Account();
    		Account b2=new Account();
    		a2.DAILY_LIMIT=10;
    		assertFalse(t3.transfer(a2, b2, 1));
    		
    		Transaction t4= new Transaction();    
    		Account a3=new Account();
    		Account b3=new Account();
    		b3.DAILY_LIMIT=10;
    		assertFalse(t4.transfer(a3, b3, 100));
    	}
    }
    @Test
	public void undoUpdate__DailyLimit_1()throws Exception {
    	getA().account.update(100);
        getB().account.update(200);
        Transaction transation=new Transaction();
		Boolean test=Whitebox.invokeMethod(transation, "transfer__Transaction", getA().account, getB().account, -20);
		assertFalse(test);
	}
//    @Test
	public void undoUpdate__DailyLimit_2()throws Exception {
    	Account accountA= new Account(); 
    	accountA.update(1000);
    	Account accountB= new Account(); 
    	accountB.update(100);
    	Transaction transation=new Transaction();
		Boolean test=Whitebox.invokeMethod(transation, "transfer__Transaction", accountA, accountB, 10);
		assertTrue(test);
	}
    @Test
	public void undoUpdate__DailyLimit_3()throws Exception {
    	getA().account.update(100);
        getB().account.update(200);
        Transaction transation=new Transaction();
        getA().account.OVERDRAFT_LIMIT=100;
		Boolean test=Whitebox.invokeMethod(transation, "transfer__Transaction", getA().account, getB().account, 20);
		assertFalse(test);
	}
    @Test
	public void undoUpdate__DailyLimit_4()throws Exception {
    	getA().account.update(100);
        getB().account.update(200);
        Transaction transation=new Transaction();
        getB().account.OVERDRAFT_LIMIT=500;
		Boolean test=Whitebox.invokeMethod(transation, "transfer__Transaction", getA().account, getB().account, 20);
		assertFalse(test);
	}
    @Test
    public void lockTest()throws Exception {
    	Account a= new Account();
    	a.lock();
    	Account b= new Account();
    	Transaction transation=new Transaction();
    	Boolean test=Whitebox.invokeMethod(transation, "lock", a, b);
		assertFalse(test);
		a.unLock();
		b.lock();
		test=Whitebox.invokeMethod(transation, "lock", a, b);
		assertFalse(test);
    	
    }
    @Test
    public void lockTest_2()throws Exception {
    	Account a= new Account();
    	Account b= new Account();
    	Transaction transation=new Transaction();
    	Boolean test=Whitebox.invokeMethod(transation, "lock", a, b);
	
    	assertTrue(a.isLocked());
    	assertTrue(b.isLocked());
    	assertTrue(test);
    }
}
