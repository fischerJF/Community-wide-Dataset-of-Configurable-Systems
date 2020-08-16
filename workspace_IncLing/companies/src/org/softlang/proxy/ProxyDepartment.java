package org.softlang.proxy;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;


/**
 * A proxy for departments to enforce access control policy for salaries.
 */
class ProxyDepartment implements Department {

	private AccessControl context;
	private Department subject;
	private List<Department> subdepts;
	private List<Employee> employees;
	private DefaultMutableTreeNode treeNode;

	ProxyDepartment(AccessControl context, Department subject) {
		this.context = context;
		this.subject = subject;
		if (specifications.Configuration.GUI) {
			subdepts = new LinkedList<Department>();
			employees = new LinkedList<Employee>();
		}
	}

	public String getName() {
		return subject.getName();
	}

	public void setName(String name) {
		subject.setName(name);
	}

	public Iterable<? extends Subunit> subunits() {
		return subject.subunits();
	}

	public boolean add(Subunit u) {
		if (specifications.Configuration.GUI) {
			if (u instanceof Department) {
				this.subdepts.add((Department) u);
			} else if (u instanceof Employee) {
				this.employees.add((Employee) u);
			}
		}
		u = context.deploy(u);
		return subject.add(u);
	}

	/*
	 * public boolean add(Subunit u) { u = context.deploy(u); return
	 * subject.add(u); }
	 */

	public boolean remove(Subunit u) {
		return subject.remove(u);
	}

	public Employee getManager() {
		return subject.getManager();
	}

	// Delegation is NOT appropriate here.
	public void accept(VoidVisitor v) {
	  
	// dealing with annotations
		boolean select = false;
		
		if (specifications.Configuration.CUT_NO_DEPARTMENT)
			select = true;
		else if (specifications.Configuration.CUT_NO_MANAGER)
			select = true;
		else if (specifications.Configuration.CUT_WHATEVER)
			select = true;
		
		if (specifications.Configuration.TOTAL_REDUCER)
			select = true;
		else if (specifications.Configuration.TOTAL_WALKER)
			select = true;
		
		if (select) {
			v.visit(this);
		}
	}

	// Delegation is NOT appropriate here.
	public <R> R accept(ReturningVisitor<R> v) {
	  
	// dealing with annotations
		boolean select = false;
		if (specifications.Configuration.CUT_NO_DEPARTMENT)
			select = true;
		else if (specifications.Configuration.CUT_NO_MANAGER)
			select = true;
		else if (specifications.Configuration.CUT_WHATEVER)
			select = true;
		if (specifications.Configuration.TOTAL_REDUCER)
			select = true;
		else if (specifications.Configuration.TOTAL_WALKER)
			select = true;
		
		if (select) {
			return v.visit(this);
		} 
		return null;
	}

	public void setSubdepts(List<Department> subdepts) {
		if (specifications.Configuration.GUI) {
			this.subdepts = subdepts;
		}
	}

	public void setEmployees(List<Employee> employees) {
		if (specifications.Configuration.GUI) {
			this.employees = employees;
		}
	}

	public List<Department> getSubdepts() {
		if (specifications.Configuration.GUI) {
			return subdepts;
		} 
		return null;
	}

	public List<Employee> getEmployees() {
		if (specifications.Configuration.GUI) {
			return employees;
		} 
		return null;
	}

	public void setTreeNode(DefaultMutableTreeNode treeNode) {
		if (specifications.Configuration.GUI) {
			this.treeNode = treeNode;
		}
	}

	public DefaultMutableTreeNode getTreeNode() {
		if (specifications.Configuration.GUI) {
			return treeNode;
		} 
		return null;
	}

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (specifications.Configuration.GUI) {
			String treeName = this.getName();
			return treeName;
		} 
		return "";
	}

}
