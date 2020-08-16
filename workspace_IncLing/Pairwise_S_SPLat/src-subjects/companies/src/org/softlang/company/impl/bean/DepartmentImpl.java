package org.softlang.company.impl.bean;

import java.util.LinkedList;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

import org.softlang.company.Department;
import org.softlang.company.Employee;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import splat.CompaniesVariables;

public class DepartmentImpl extends ContainerImpl implements Department {

	private List<Department> subdepts;
	private List<Employee> employees;
	private DefaultMutableTreeNode treeNode;

	public DepartmentImpl() {
		super();
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			subdepts = new LinkedList<Department>();
			employees = new LinkedList<Employee>();
		}
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

	public boolean add(Subunit u) {
		super.add(u);
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			if (u instanceof Department) {
				return this.subdepts.add((Department) u);
			} else if (u instanceof Employee) {
				return this.employees.add((Employee) u);
			}
			return false;
		} 
		return false;
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

	public Employee getManager() {
		for (Subunit u : subunits())
			if (u instanceof Employee) {
				Employee e = (Employee) u;
				if (e.getManager())
					if (CompaniesVariables.getSINGLETON().isGUI___()) {
						employees.remove(e);
					}
				return e;
			}
		return null;
	}

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

}
