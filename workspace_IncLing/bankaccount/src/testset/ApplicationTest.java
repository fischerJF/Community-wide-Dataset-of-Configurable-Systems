package testset;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.Whitebox;

import bankaccount.Account;
import bankaccount.Application;
import bankaccount.Transaction;
import specifications.Configuration;

public class ApplicationTest {

	Application application;
	@Before
	public void setUp() { 
		application= new Application();
	}
	
	
	@Test
	public void testNextDay() {
		Application a= new Application();
		if(Configuration.interest) {
			a.account.update(100000);
			a.nextDay();
			a.account.update(100000);
			a.nextDay();
			a.account.calculateInterest();
			assertTrue(a.account.interest==15);
		}else if(Configuration.dailylimit) {
			a.nextDay();
			assertTrue(a.account.withdraw==0);
		}
	}

	@Test
	public void testNextYear() {
		Application a= new Application();
		
		if(Configuration.interest) {
			a.account.update(100);
			a.account.update(500);
			a.account.update(120);
			a.account.update(30);
		    assertTrue(a.account.balance==750);
		    a.account.balance=0;
			assertTrue(a.account.balance==0);
			a.account.update(100);
			a.account.update(200);
			a.account.interest=2;
			
			a.nextYear();
			assertTrue(a.account.balance==302);
			assertTrue(a.account.interest==0);
			//a.account.update(100);
		}
	}
	
	@Test
	public void testNextDay_2() {
//		Configuration.interest=false;
//		Configuration.dailylimit=true;
		 if (!Configuration.interest && Configuration.dailylimit) {
			 Application a= new Application();
			 a.nextDay();
			 assertTrue(a.account.withdraw==0);
		 }
		
	}
	
	@Test
    public void nextDay__DailyLimit_2()throws Exception {
    	
		 if (Configuration.dailylimit) {
			 Whitebox.invokeMethod(application, "nextDay__DailyLimit");
				assertTrue(application.account.withdraw==0);
		 }
	}
	
	@Test
	public void nextDay() {
		application.nextDay();
		assertTrue(application.account.withdraw==0);
	}

}
