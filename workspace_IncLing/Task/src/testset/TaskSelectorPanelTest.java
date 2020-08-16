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

import javax.swing.JButton;
import javax.swing.JComboBox;
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
import tasks.TaskSelectorPanel;

public class TaskSelectorPanelTest {

	private TaskSelectorPanel task;

	@Before
	public void setUp() {
		task = new TaskSelectorPanel();
	}

	@Test
	public void createButtonPanelTest() {
		assertNotNull(task.createButtonPanel());
		JButton button = task.createButtonPanel();
		assertEquals(button.getText(),"Remove Task");
		assertEquals(button.getName(),"removeTask");
		assertTrue(button.getComponentListeners()!=null);
	}
	
	@Test
	public void refreshTest() throws IllegalArgumentException, IllegalAccessException{
		Task t = new Task();
		task.refresh(t);
		JComboBox selector = (JComboBox)	MemberModifier.field(TaskSelectorPanel.class, "selector").get(task);
		assertEquals(task.selector.getItemCount(),1);
	}
	
	@Test
	public void createGuiTest() throws IllegalArgumentException, IllegalAccessException {
		JComboBox selector = (JComboBox)	MemberModifier.field(TaskSelectorPanel.class, "selector").get(task);
		assertNotNull(selector);
		assertTrue(selector.getComponentCount()>=1);
	}
//	@Test
	public void createGuiTest2() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.REMOVER=true;
		if(Configuration.REMOVER) {
			task.createGui();
			JComboBox selector = (JComboBox)	MemberModifier.field(TaskSelectorPanel.class, "selector").get(task);
			assertNotNull(selector);
			assertTrue(selector.getComponentCount()>=1);
			assertTrue(task.getComponent(2) instanceof JButton);
		}
	}
}
