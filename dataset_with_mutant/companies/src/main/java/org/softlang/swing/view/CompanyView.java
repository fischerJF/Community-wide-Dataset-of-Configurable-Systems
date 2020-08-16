package org.softlang.swing.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.softlang.company.Company;
import org.softlang.swing.model.Model;

import specifications.Configuration;


/**
 * This class provides the gui for company information and company changes.
 * 
 * @author Tobias Zimmer, Eduard Ditler, Hanna-Marike Reger, Helena Swerdlow,
 *         Jan Ruether
 */
public class CompanyView extends AbstractView {

	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = 4713058639510381461L;

	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public CompanyView(Model model) {
		super(model);
		createView();
		this.setVisible(true);
	}

	/*
	 * create GUI components
	 */
	private void createView() {
		Company company = (Company) model.getCurrentValue();
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// name
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(10, 10, 0, 0);
		c.anchor = GridBagConstraints.WEST;
		this.add(new JLabel("Name: "), c);

		c.gridx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 1;
		name.setText(company.getName());
		this.add(name, c);

    // dealing with annotations
    boolean select1 = false;
    if (Configuration.TOTAL_REDUCER)
      select1 = true;
    else if (Configuration.TOTAL_WALKER)
      select1 = true;
    if (select1) {
      c.gridy = 1;
      c.gridx = 0;
      c.weightx = 0;
      c.fill = GridBagConstraints.NONE;
      this.add(new JLabel("Total: "), c);
    }

		c.gridx = 1;
		c.weightx = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
	// dealing with annotations
    boolean select2 = false;
    if (Configuration.TOTAL_REDUCER)
      select2 = true;
    else if (Configuration.TOTAL_WALKER)
      select2 = true;
    if (select2) {
				total.setText(model.getTotal());
				total.setEditable(false);
				this.add(total, c);
		}

    // dealing with annotations
    boolean select = false;
    if (Configuration.CUT_NO_DEPARTMENT)
      select = true;
    else if (Configuration.CUT_NO_MANAGER)
      select = true;
    else if (Configuration.CUT_WHATEVER)
      select = true;
    if (select) {
      // cut
      c.gridy = 2;
      c.gridx = 0;
      c.gridwidth = 2;
      c.weightx = 0;
      c.fill = GridBagConstraints.NONE;
      c.anchor = GridBagConstraints.CENTER;
      this.add(cut, c);
    }

		// filler
		c.gridy = 3;
		c.weighty = 1;
		c.fill = GridBagConstraints.VERTICAL;
		this.add(new JPanel(), c);
	}

}
