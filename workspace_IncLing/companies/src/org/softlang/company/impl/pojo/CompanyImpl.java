package org.softlang.company.impl.pojo;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;

public class CompanyImpl extends ContainerImpl implements Company {

	private List<Department> depts;

	public CompanyImpl() {
		if (Configuration.GUI) {
			depts = new LinkedList<Department>();
		}
	}

	public boolean add(Department department) {
		if (Configuration.GUI) {
			return depts.add(department);
		} 
		return false;
	}

	public List<Department> getDepts() {
		if (Configuration.GUI) {
			return depts;
		} 
		return null;
	}

	public void setDepts(List<Department> depts) {
		if (Configuration.GUI) {
			this.depts = depts;
		}
	}

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (Configuration.GUI) {
			return this.getName();
		} 
		return "";
	}

	public void accept(VoidVisitor v) {
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
			v.visit(this);
		}
	}

	public <R> R accept(ReturningVisitor<R> v) {
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
			return v.visit(this);
		} 
		return null;
	}

	/**
	 * Enforce the constraint a company can only aggregate departments
	 */
	public boolean add(Subunit u) {
		if (!(u instanceof Department)) {
			throw new IllegalArgumentException();
		}
		if (Configuration.GUI) {
			depts.add((Department) u);
		}
		return super.add(u);
	}
}
