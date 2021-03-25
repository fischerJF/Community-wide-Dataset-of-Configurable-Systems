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
import tasks.LastTaskLabel;
import tasks.Task;

public class LastTaskLabelTest {

	private LastTaskLabel lastTask;
	
	@Before
	public void setUp() {
		lastTask= new LastTaskLabel();
	}
	
	@Test
	public void LastTaskLabelTest() {
		assertTrue(lastTask.getText().contains("Last change in task:"));
	}
	
	@Test
	public void refreshTest() {
		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);
		
		Configuration.OBSERVER=true;
		if(Configuration.OBSERVER) {
			Task task= new Task(); 
			task.createTask("name", "notes", "10");
			lastTask.refresh(task);
			assertTrue(os.toString().contains("Last change in task:"));
			assertEquals(lastTask.getText(),"Last change in task: name");
		}
	}

	

}
