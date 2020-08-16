package testset;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

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
import tasks.TaskHistoryPanel;

public class TaskHistoryPanelTest {

	private TaskHistoryPanel task;

	@Before
	public void setUp() {
		task = new TaskHistoryPanel();
	}

	@Test
	public void TaskHistoryPanelTest() throws IllegalArgumentException, IllegalAccessException {
		assertTrue(task instanceof JPanel);
		assertTrue(task.getComponent(0) instanceof JScrollPane);
		assertNotNull(task.getLayout()  instanceof BorderLayout);
		JTextArea testArea = (JTextArea) MemberModifier.field(TaskHistoryPanel.class, "displayRegion").get(task);
		assertFalse(testArea.isEditable());
		assertEquals(testArea.getRows(), 10);
		assertEquals(testArea.getColumns(), 40);
		
		assertNotNull(task.getLayout());
	}

	@Test
	public void refreshTest() throws IllegalArgumentException, IllegalAccessException {
		Task task2 = new Task();
		task.refresh(task2);
		JTextArea testArea = (JTextArea) MemberModifier.field(TaskHistoryPanel.class, "displayRegion").get(task);
		
		
		assertTrue(testArea.getText().length()>0);
		
	}
}
