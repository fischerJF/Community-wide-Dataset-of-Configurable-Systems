package tasks;

import java.awt.BorderLayout;
import java.util.GregorianCalendar;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TaskHistoryPanel extends JPanel implements Observer {

	private JTextArea displayRegion;

	public TaskHistoryPanel() {
		setLayout(new BorderLayout());
		displayRegion = new JTextArea(10, 40);
		displayRegion.setEditable(false);
		add(new JScrollPane(displayRegion));
	}

	public void refresh(Subject s) {
		String time = (new GregorianCalendar()).getTime().toString();
		Task task = (Task)s;
		String taskInfo = task.getName() + " " + task.getNotes() + " " + task.getTimeRequired();
		displayRegion.append( time + ": " + taskInfo + "\n" );
		
	}
}
