package org.softlang.swing.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.swing.model.Model;

import specifications.Configuration;


/**
 * This class manages the main GUI components.
 * 
 * @author Tobias Zimmer, Eduard Ditler, Hanna-Marike Reger, Helena Swerdlow,
 *         Jan Ruether
 */
public class MainView extends JFrame {

	/** automatically generated serialVersionUID */
	private static final long serialVersionUID = 4876244087473632120L;

	private Model model;
	private JPanel currentView;
	private JTree tree;
	private JPanel inner;

	/**
	 * Constructor.
	 * 
	 * @param model
	 */
	public MainView(Model model) {
		this.model = model;
		this.currentView = new JPanel();

		createView();
	}

	/*
	 * This method creates the initial view for the application.
	 */
	private void createView() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.weighty = 1;
		c.insets = new Insets(5, 5, 5, 5);

		GridLayout layout = new GridLayout(1, 2);
		this.inner = new JPanel(layout);
		this.add(inner, c);

		this.inner.add(createTree());
		this.inner.add(currentView);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(new Dimension(800, 600));
		this.setLocation(0, 25);
		this.setResizable(true);
		this.setTitle("101implementation:Swing");
		this.setVisible(true);
	}

	/*
	 * This method initializes the tree-view.
	 */
	private Component createTree() {
		Company company = null;
		if (model.getCompany() instanceof org.softlang.company.impl.bean.CompanyImpl) {
			company = (org.softlang.company.impl.bean.CompanyImpl) model
					.getCompany();
		} else if (model.getCompany() instanceof org.softlang.company.impl.pojo.CompanyImpl) {
			company = (org.softlang.company.impl.pojo.CompanyImpl) model
					.getCompany();
		}

		// create Tree for company
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(company);

		for (Department d : company.getDepts()) {
			root.add(addDepartmentNode(d));
		}

		tree = new JTree(root);

		return new JScrollPane(tree);
	}

	/*
	 * This method adds the department nodes to the tree view.
	 */
	private MutableTreeNode addDepartmentNode(Department dep) {
		DefaultMutableTreeNode root = new DefaultMutableTreeNode(dep);
		dep.setTreeNode(root);
		root.add(addManagerNode(dep.getManager()));
		for (Department d : dep.getSubdepts()) {
			root.add(addDepartmentNode(d));
		}
		for (Employee e : dep.getEmployees()) {
			root.add(addEmployeeNode(e));
		}
		return root;
	}

	/*
	 * This method adds the employee node to the tree view.
	 */
	private MutableTreeNode addEmployeeNode(Employee e) {
		DefaultMutableTreeNode employee = new DefaultMutableTreeNode(e);
		return employee;
	}

	/*
	 * This method adds the manager node to the tree view and marks it as a
	 * manager.
	 */
	private MutableTreeNode addManagerNode(Employee m) {
		m.setManager(true);
		DefaultMutableTreeNode manager = new DefaultMutableTreeNode(m);
		return manager;
	}

	/**
	 * This method adds a specific tree listener to the tree-view.
	 * 
	 * @param listener
	 *            tree listener
	 */
	public void addTreeListener(TreeSelectionListener listener) {
		tree.addTreeSelectionListener(listener);
	}

	/**
	 * init GUI
	 */
	public void initGui(JPanel view) {
		this.inner.remove(currentView);
		currentView = view;
		this.inner.add(currentView);

		// is needed for repainting
		this.setVisible(true);
	}

	public void refresh() {
	  
	  // dealing with annotations
    boolean select = false;
    if (Configuration.CUT_NO_DEPARTMENT)
      select = true;
    else if (Configuration.CUT_NO_MANAGER)
      select = true;
    else if (Configuration.CUT_WHATEVER)
      select = true;
    if (Configuration.TOTAL_REDUCER)
      select = true;
    else if (Configuration.TOTAL_WALKER)
      select = true;
    
    if (select) {
      ((AbstractView) currentView).refresh();
    }
	}

	public void refreshTree() {
		tree.repaint();
	}
}
