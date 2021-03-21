package tasks;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaskEditorPanel extends JPanel {

	private LastTaskLabel lastTaskLabel;
	private JLabel taskNameLabel, taskNotesLabel, taskTimeLabel;
	protected JTextField taskName, taskNotes, taskTime;
	protected Task task;
	

	public TaskEditorPanel() {
		setLayout(new BorderLayout());
		lastTaskLabel = new LastTaskLabel();
		JPanel editPanel = createGridPanel();
		JButton addButton = createButtonPanel();
		this.add(lastTaskLabel, BorderLayout.NORTH);
		this.add(editPanel, BorderLayout.CENTER);
		this.add(addButton, BorderLayout.SOUTH);
	}

	public JPanel createGridPanel() {
		JPanel editPanel = new JPanel();
		editPanel.setLayout(new GridLayout(3, 2));
		taskNameLabel = new JLabel("Task Name");
		taskNotesLabel = new JLabel("Task Notes");
		taskTimeLabel = new JLabel("Time Required");
		taskName = new JTextField(20);
		taskName.setName("taskName");
		taskNotes = new JTextField(20);
		taskNotes.setName("taskNotes");
		taskTime = new JTextField(20);
		taskTime.setName("taskTime");
		editPanel.add(taskNameLabel);
		editPanel.add(taskName);
		editPanel.add(taskNotesLabel);
		editPanel.add(taskNotes);
		editPanel.add(taskTimeLabel);
		editPanel.add(taskTime);
		return editPanel;
	}

	public JButton createButtonPanel() {
		JButton addButton = new JButton("Add Task");
		addButton.addActionListener(new AddTaskListener(this));
		addButton.setName("addTask");
		return addButton;
	}

	private class AddTaskListener implements ActionListener {

		private TaskEditorPanel windows;

		public AddTaskListener(TaskEditorPanel taskEditorPanel) {
			this.windows = taskEditorPanel;
		}

		public void actionPerformed(ActionEvent event) {
			Object source = event.getSource();
			task = new Task();

			if (source instanceof JButton) {

				task.addObserver(lastTaskLabel);
				task.addObserver(TaskManagerWindow.getInstance().getHistoryPanel());
				task.addObserver(TaskManagerWindow.getInstance().getSelectorPanel());
				task.createTask(taskName.getText(), taskNotes.getText(), taskTime.getText());
				taskName.setText("");
				taskNotes.setText("");
				taskTime.setText("");
			}

		}
	}
}
