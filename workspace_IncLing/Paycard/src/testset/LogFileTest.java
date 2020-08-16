package testset;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import paycard.CardException;
import paycard.LogFile;
import paycard.LogRecord;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class LogFileTest {

	LogFile log;
	@Before
	public void setUp() {
	}

	
	@Test
	public void logTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.logging=true;
		if (Configuration.logging) {
			log= new  LogFile();
			
			LogRecord[] logArray = (LogRecord[]) MemberModifier.field(LogFile.class, "logArray").get(log);
			assertTrue(logArray.length==3);
			
			int currentRecord = (int) MemberModifier.field(LogFile.class, "currentRecord").get(log);
			assertTrue(currentRecord==0);
		}
	}
	@Test
	public void addRecordTest() throws IllegalArgumentException, IllegalAccessException, CardException {
//		Configuration.logging=true;
		if (Configuration.logging) {
		log= new  LogFile();
		log.addRecord(100);
		LogRecord[] logArray = (LogRecord[]) MemberModifier.field(LogFile.class, "logArray").get(log);
		assertTrue(logArray.length==3);

		int currentRecord = (int) MemberModifier.field(LogFile.class, "currentRecord").get(log);
        assertTrue(currentRecord==1);
		}
	}
	
	@Test
	public void getMaximumRecord() throws CardException, IllegalArgumentException, IllegalAccessException {
//		Configuration.logging=true;
		if (Configuration.logging) {
		log= new  LogFile();
		log.addRecord(100);
		log.addRecord(1000);
		LogRecord[] logArray = (LogRecord[]) MemberModifier.field(LogFile.class, "logArray").get(log);
		assertTrue(logArray.length==3);
        assertTrue(log.getMaximumRecord().getBalance()==1000);
		}
		
	}

}