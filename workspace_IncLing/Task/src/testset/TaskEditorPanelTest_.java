package testset;

import org.junit.After;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import specifications.Configuration;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import org.fest.swing.fixture.FrameFixture;
import tasks.Task;
import tasks.TaskEditorPanel;
import tasks.TaskManagerWindow;
import tasks.TaskSelectorPanel;
import java.util.Vector;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class TaskEditorPanelTest_ {

	private FrameFixture demo;
	
	public void setUp() {
//		Configuration.OBSERVER = true;

		TaskManagerWindow.getInstance().pack();
		TaskManagerWindow.getInstance().setVisible(true);
		demo = new FrameFixture(TaskManagerWindow.getInstance());
	}

	@After
	public void tearDown() {
		if(demo!=null)
		demo.cleanUp();

	}
	
	
	@Test
	public void addTaskTest() throws IllegalArgumentException, IllegalAccessException {
		if(Configuration.OBSERVER) {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(stream);
		PrintStream originalPrintStream = System.out;
		System.setOut(ps);

		setUp();
		
	
		demo.textBox("taskName").enterText("Task A");
		demo.textBox("taskNotes").enterText("Note A");
		demo.textBox("taskTime").enterText("50");
		demo.button("addTask").click();
		TaskEditorPanel taskEditorPanel = (TaskEditorPanel) MemberModifier.field(TaskManagerWindow.class, "editorPanel")
				.get(TaskManagerWindow.getInstance());
		Task task = (Task) MemberModifier.field(TaskEditorPanel.class, "task").get(taskEditorPanel);
		Vector observers = (Vector) MemberModifier.field(Task.class, "observers").get(task);

		assertEquals(observers.size(), 3);
		assertTrue(observers.toString().contains("tasks.LastTaskLabel"));
		assertTrue(observers.toString().contains("tasks.TaskHistoryPanel"));
		assertTrue(observers.toString().contains("tasks.TaskSelectorPanel"));

		assertEquals(demo.textBox("taskName").text().toString(), "");
		assertEquals(demo.textBox("taskTime").text().toString(), "");
		assertEquals(demo.textBox("taskTime").text().toString(), "");
		System.setOut(originalPrintStream);
		String output = new String(stream.toByteArray());
	
		
		assertTrue(output.toString().contains("Last change in task: Task A"));
		}
	}

//	@Test
	public void removeTaskTest() throws IllegalArgumentException, IllegalAccessException {
	
//		Configuration.REMOVER = true;
		if (Configuration.REMOVER) {

			setUp();

			demo.textBox("taskName").enterText("Task A");
			demo.textBox("taskNotes").enterText("Note A");
			demo.textBox("taskTime").enterText("50");
			demo.button("addTask").click();

			demo.textBox("taskName").enterText("Task B");
			demo.textBox("taskNotes").enterText("Note B");
			demo.textBox("taskTime").enterText("30");
			demo.button("addTask").click();

			demo.button("removeTask").click();

			TaskSelectorPanel selectorPanel = (TaskSelectorPanel) MemberModifier
					.field(TaskManagerWindow.class, "selectorPanel").get(TaskManagerWindow.getInstance());
			assertNotNull(selectorPanel.selector);
			assertTrue(selectorPanel.selector.getComponentCount() == 2);
		}
	}

}
