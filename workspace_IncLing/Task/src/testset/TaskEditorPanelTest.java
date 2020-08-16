package testset;

import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

public class TaskEditorPanelTest {

	private TaskEditorPanel task;
	
	@Before
	public void setUp() {
		task= new TaskEditorPanel();
	}

	@Test
	public void createGridPanel() {
		assertNotNull(task.createGridPanel());
		JPanel pn=task.createGridPanel();
		assertTrue(pn.getComponent(0) instanceof JLabel);
		JLabel label1= (JLabel) pn.getComponent(0);
		assertEquals(label1.getText(),"Task Name");
		
		assertTrue(pn.getComponent(1) instanceof JTextField);
		assertEquals(pn.getComponent(1).getName(),"taskName");

		assertTrue(pn.getComponent(2) instanceof JLabel);
		JLabel label2= (JLabel) pn.getComponent(2);
		assertEquals(label2.getText(),"Task Notes");
		assertTrue(pn.getComponent(3) instanceof JTextField);
		assertEquals(pn.getComponent(3).getName(),"taskNotes");

		assertTrue(pn.getComponent(4) instanceof JLabel);
		JLabel label3= (JLabel) pn.getComponent(4);
		assertEquals(label3.getText(),"Time Required");
		
		assertTrue(pn.getComponent(5) instanceof JTextField);
		assertEquals(pn.getComponent(5).getName(),"taskTime");
		assertTrue(pn.getLayout() instanceof GridLayout);
	}
	
	@Test
	public void createButtonPanelTest() {
		assertNotNull(task.createButtonPanel());
		JButton button = task.createButtonPanel();
		assertEquals(button.getText(),"Add Task");
		assertEquals(button.getName(),"addTask");
		assertTrue(button.getComponentListeners()!=null);
	}
	
	
	@Test
	public void taskEditorPanelTest() {
		assertNotNull(task.getLayout()instanceof BorderLayout);
		BorderLayout b=(BorderLayout) task.getLayout();
		assertNotNull(b.getLayoutComponent(BorderLayout.NORTH));
		assertNotNull(b.getLayoutComponent(BorderLayout.SOUTH));
        assertNotNull(b.getLayoutComponent(BorderLayout.CENTER));
    }
}
