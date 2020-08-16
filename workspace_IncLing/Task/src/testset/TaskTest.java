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
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;
import tasks.LastTaskLabel;
import tasks.Task;

public class TaskTest {

	private Task t;

	@Before
	public void setUp() {
		t = new Task();
	}

	@Test
	public void creatTaskTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.OBSERVER = false;
		if (!Configuration.OBSERVER) {
			t.createTask("name", "notes", "10");
			assertEquals(t.getName(), "name");
			assertEquals(t.getNotes(), "notes");
			assertTrue(t.getTimeRequired() == 10.0);
			Vector v = (Vector) MemberModifier.field(Task.class, "observers").get(t);
			assertTrue(v.size() == 0);
		}

	}

	@Test
	public void creatTaskObserverTest() {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			t.createTask("name", "notes", "10");
			assertEquals(t.getName(), "name");
			assertEquals(t.getNotes(), "notes");
			assertTrue(t.getTimeRequired() == 10.0);
			observer();
		}
	}

	@Test
	public void setNameObserverTest() {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			t.setName("name");
			assertEquals(t.getName(), "name");
			observer();
		}

	}

	@Test
	public void setTimeRequiredObserverTest() {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			t.setTimeRequired("10");
			assertTrue(t.getTimeRequired() == 10.0);
			observer();

		}
	}

	@Test
	public void setNotesTest() {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			t.setNotes("notes");
			assertEquals(t.getNotes(), "notes");
			observer();
		}
	}

	@Test
	public void toStringTest() {
		t.createTask("name", "notes", "10");
		assertEquals(t.toString(), "name");
	}

	@Test
	public void removeObserverTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			LastTaskLabel ltk = new LastTaskLabel();
			t.addObserver(ltk);
			t.removeObserver(ltk);
			Vector v = (Vector) MemberModifier.field(Task.class, "observers").get(t);
			assertTrue(v.size() == 0);
		}
	}

	@Test
	public void notifyObservers() {
//		Configuration.OBSERVER = true;
		if (Configuration.OBSERVER) {
			
			LastTaskLabel ltk = new LastTaskLabel();
			ltk.setName("test1");
			t.addObserver(ltk);
			
			assertTrue(ltk.getText().toString().contains("Last change in task:"));
			
		}
	}

	private void observer() {
		try {
			LastTaskLabel ltk = new LastTaskLabel();
			t.addObserver(ltk);
			Vector v = (Vector) MemberModifier.field(Task.class, "observers").get(t);
			assertTrue(v.size() == 1);
			assertTrue(ltk.getText().contains("Last change in task:"));
		} catch (IllegalArgumentException e) {

		} catch (IllegalAccessException e) {

		}
	}
}