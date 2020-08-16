package org.softlang.swing.view;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.softlang.swing.model.Model;

import specifications.Configuration;


/**
 * This abstract class provides the main components for all possible views:
 * name, total and cut.
 * 
 * @author Tobias Zimmer
 */
public abstract class AbstractView extends JPanel {

	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = -3528714296290843302L;

	protected Model model;
	protected JTextField name;
	protected JTextField total;
	protected JButton cut;

	/**
	 * Constructor
	 * 
	 * @param model
	 */
	public AbstractView(Model model) {
		this.model = model;
		name = new JTextField();
		
		// dealing with annotations
    boolean select1 = false;
    if (Configuration.TOTAL_REDUCER)
      select1 = true;
    else if (Configuration.TOTAL_WALKER)
      select1 = true;
    if (select1) {
      total = new JTextField();
    }
		
    // dealing with annotations
    boolean select2 = false;
    if (Configuration.CUT_NO_DEPARTMENT)
      select2 = true;
    else if (Configuration.CUT_NO_MANAGER)
      select2 = true;
    else if (Configuration.CUT_WHATEVER)
      select2 = true;
    if (Configuration.TOTAL_REDUCER)
      select2 = true;
    else if (Configuration.TOTAL_WALKER)
      select2 = true;
    
    if (select2) {
      cut = new JButton("cut");
    }
				
	}

	/**
	 * This method adds the listener for the cut button of the current view.
	 * 
	 * @param cut
	 *            listener
	 */
	public void addCutListener(ActionListener listener) {
	  // dealing with annotations
		boolean select = false;
		if (Configuration.CUT_NO_DEPARTMENT)
			select = true;
		else if (Configuration.CUT_NO_MANAGER)
			select = true;
		else if (Configuration.CUT_WHATEVER)
			select = true;
		if (select) {

			cut.addActionListener(listener);
		}
	}

	public void refresh() {
	  
	  // dealing with annotations
	  boolean select2 = false;
    if (Configuration.CUT_NO_DEPARTMENT)
      select2 = true;
    else if (Configuration.CUT_NO_MANAGER)
      select2 = true;
    else if (Configuration.CUT_WHATEVER)
      select2 = true;
    if (Configuration.TOTAL_REDUCER)
      select2 = true;
    else if (Configuration.TOTAL_WALKER)
      select2 = true;
    
    if (select2) {
      // This method refreshs the total value after a cut.
      total.setText(model.getTotal());
    }
  }

	/**
	 * This method adds the listener for the name field of the current view.
	 * 
	 * @param name
	 *            change listener
	 */
	public void addNameListener(KeyListener listener) {
		name.addKeyListener(listener);
	}
}
