package org.softlang.proxy;

import java.util.LinkedList;
import java.util.List;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import splat.CompaniesVariables;

/**
 * A proxy for companies to enforce access control policy for salaries.
 */
class ProxyCompany implements Company {

	private AccessControl context;
	private Company subject;
	private List<Department> depts;

	public ProxyCompany() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			setDepts(new LinkedList<Department>());
		}
	}

	ProxyCompany(AccessControl context, Company subject) {
		this.context = context;
		this.subject = subject;
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
		u = context.deploy(u);
		return subject.add(u);
	}

	public boolean remove(Subunit u) {
		return subject.remove(u);
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

}
