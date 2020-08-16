package org.softlang.company.impl.pojo;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import splat.CompaniesVariables;

public class CompanyImpl extends ContainerImpl implements Company {

	private List<Department> depts;

	public CompanyImpl() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			depts = new LinkedList<Department>();
		}
	}

	public boolean add(Department department) {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return depts.add(department);
		} 
		return false;
	}

	public List<Department> getDepts() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return depts;
		} 
		return null;
	}

	public void setDepts(List<Department> depts) {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			this.depts = depts;
		}
	}

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			return this.getName();
		} 
		return "";
	}

	public void accept(VoidVisitor v) {
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

	/**
	 * Enforce the constraint a company can only aggregate departments
	 */
	public boolean add(Subunit u) {
		if (!(u instanceof Department)) {
			throw new IllegalArgumentException();
		}
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			depts.add((Department) u);
		}
		return super.add(u);
	}
}
