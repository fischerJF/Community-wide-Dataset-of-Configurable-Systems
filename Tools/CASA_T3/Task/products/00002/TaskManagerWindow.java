package tasks;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class TaskManagerWindow extends JFrame {

	protected TaskHistoryPanel historyPanel;
	protected TaskSelectorPanel selectorPanel;
	protected TaskEditorPanel editorPanel;
	private static TaskManagerWindow instance;

	private TaskManagerWindow() {
		super("Task Manager");
		setLayout( new BorderLayout() );
		historyPanel = new TaskHistoryPanel();
		selectorPanel = new TaskSelectorPanel();
		editorPanel = new TaskEditorPanel();
		add(selectorPanel, BorderLayout.NORTH);
		add(historyPanel, BorderLayout.CENTER);
		add(editorPanel, BorderLayout.SOUTH);
		addWindowListener(new WindowCloseManager());
	}
	
	public static TaskManagerWindow getInstance() {
		if (instance == null) instance = new TaskManagerWindow();
		return instance;
	}
	
	public TaskHistoryPanel getHistoryPanel() {
		return historyPanel;
	}

	public TaskSelectorPanel getSelectorPanel() {
		return selectorPanel;
	}

	public TaskEditorPanel getEditorPanel() {
		return editorPanel;
	}

	private class WindowCloseManager extends WindowAdapter {
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}
	}
}
