package testset;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import bankaccount.Application;
import bankaccount.LogEntry;
import specifications.Configuration;

public class LogEntryTest {
	Application a;
	Application b;
	
	
	
	@Before
	public void setUp(){
		a= new Application();
		b= new Application();
	}
	@Test
	public void testGetSource() {
		if(Configuration.logging) {
			LogEntry log= new LogEntry(a.account, b.account,40);
		assertEquals(log.getSource(), a.account);
		}
	}

	@Test
	public void testGetDestination() {
		if(Configuration.logging) {
			
		LogEntry log= new LogEntry(a.account, b.account,40);
		assertTrue(log.getDestination()==b.account);
		}
	}

	@Test
	public void testGetAmount() {
		if(Configuration.logging) {
		LogEntry log= new LogEntry(a.account, b.account,40);
		assertTrue(log.getAmount()==40);
		}
	}

}
