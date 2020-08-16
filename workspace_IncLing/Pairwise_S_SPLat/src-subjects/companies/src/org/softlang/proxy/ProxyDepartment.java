package org.softlang.proxy;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import splat.CompaniesVariables;

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
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
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
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
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
		
		if (CompaniesVariables.getSINGLETON().isCUT_NO_DEPARTMENT___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_WHATEVER___())
			select = true;
		
		if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isTOTAL_WALKER___())
			select = true;
		
		if (select) {
			v.visit(this);
		}
	}

	// Delegation is NOT appropriate here.
	public <R> R accept(ReturningVisitor<R> v) {
	  
	// dealing with annotations
		boolean select = false;
		if (CompaniesVariables.getSINGLETON().isCUT_NO_DEPARTMENT___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_NO_MANAGER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isCUT_WHATEVER___())
			select = true;
		if (CompaniesVariables.getSINGLETON().isTOTAL_REDUCER___())
			select = true;
		else if (CompaniesVariables.getSINGLETON().isTOTAL_WALKER___())
			select = true;
		
		if (select) {
			return v.visit(this);
		} 
		return null;
	}

	public void setSubdepts(List<Department> subdepts) {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			this.subdepts = subdepts;
		}
	}

	public void setEmployees(List<Employee> employees) {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			this.employees = employees;
		}
	}

	public List<Department> getSubdepts() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return subdepts;
		} 
		return null;
	}

	public List<Employee> getEmployees() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return employees;
		} 
		return null;
	}

	public void setTreeNode(DefaultMutableTreeNode treeNode) {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			this.treeNode = treeNode;
		}
	}

	public DefaultMutableTreeNode getTreeNode() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return treeNode;
		} 
		return null;
	}

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			String treeName = this.getName();
			return treeName;
		} 
		return "";
	}

}
