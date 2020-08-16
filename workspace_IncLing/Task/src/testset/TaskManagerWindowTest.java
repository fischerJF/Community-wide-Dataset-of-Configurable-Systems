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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;
import tasks.TaskEditorPanel;
import tasks.TaskHistoryPanel;
import tasks.TaskManagerWindow;
import tasks.TaskSelectorPanel;

public class TaskManagerWindowTest {

	private TaskManagerWindow tmw;

	@Before
	public void setUp() {
		tmw=TaskManagerWindow.getInstance();
	}
	
	@Test
	public void getInstance() {
		assertEquals(TaskManagerWindow.getInstance(),tmw);
		
	}

	

	@Test
	public void getHistoryPanelTest() throws IllegalArgumentException, IllegalAccessException {
		assertNotNull(tmw.getHistoryPanel());
		assertTrue(tmw.getHistoryPanel() instanceof TaskHistoryPanel);
	}

	@Test
	public void getSelectorPanelTest() {
		assertNotNull(tmw.getSelectorPanel());

		assertTrue(tmw.getSelectorPanel() instanceof TaskSelectorPanel);

	}

	@Test
	public void TaskEditorPanelTest() {
		assertNotNull(tmw.getEditorPanel());

		assertTrue(tmw.getEditorPanel() instanceof TaskEditorPanel);
	}

	@Test
	public void TaskManagerWindowTest() {
		assertNotNull(tmw.getLayout()instanceof BorderLayout);
	}
}
