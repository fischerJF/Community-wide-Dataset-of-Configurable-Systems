package testset;

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
import telecom.Timer;

public class TimerTest {

	private Timer timer;
	@Before
	public void setUp() {
		timer= new Timer();
	}

	@Test
	public void getTimeTest() {
		
		timer.start();
		timer.stop();
		long start=timer.startTime;
		long stop= timer.stopTime;
		
		assertEquals(timer.getTime(), (stop-start) );
		
		
	}

}

