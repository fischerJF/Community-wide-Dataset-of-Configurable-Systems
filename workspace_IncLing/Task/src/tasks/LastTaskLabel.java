package tasks;

import javax.swing.JLabel;

import specifications.Configuration;

public class LastTaskLabel extends JLabel implements Observer {
	
	public LastTaskLabel() {
		this.setText("Last change in task: ");
	}
	
	public void refresh(Subject s) {
		
		if(Configuration.OBSERVER) {
			System.out.println( "Last change in task: " + s);
			this.setText( "Last change in task: " + s);
		}
	}
}
