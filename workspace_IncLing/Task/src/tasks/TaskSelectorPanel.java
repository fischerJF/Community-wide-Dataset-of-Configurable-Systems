package tasks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import specifications.Configuration;

public class TaskSelectorPanel extends JPanel implements Observer, ActionListener {

	public JComboBox selector = new JComboBox();

	public TaskSelectorPanel() {
		createGui();
	}

	public void createGui() {
		selector = new JComboBox();
		add(selector);
		if(Configuration.REMOVER) {
			add(createButtonPanel());
		}
		
	}
	
	public void refresh(Subject s) {
		selector.addItem(s);
	}

	public JButton createButtonPanel() {
		JButton addButton = new JButton("Remove Task");
		addButton.setName("removeTask");
		addButton.addActionListener(this);
		return addButton;
	}
	public void actionPerformed(ActionEvent event) {
		int index = selector.getSelectedIndex();
		selector.removeItemAt(index);
	}
	
	
	
}
