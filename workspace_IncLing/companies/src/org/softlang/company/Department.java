package org.softlang.company;






import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * A department has a name, employees, and sub-departments. One of the employees
 * is supposed to be the manager. We add a getter for the manager for
 * convenience's sake.
 */
public interface Department extends Subunit, Container {
	Employee getManager();

	public String getName();

	public List<Department> getSubdepts();

	public List<Employee> getEmployees();

	public DefaultMutableTreeNode getTreeNode();

	public void setTreeNode(DefaultMutableTreeNode treeNode);
}
