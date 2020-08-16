package org.softlang.proxy;

import java.util.LinkedList;
import java.util.List;

import javax.security.auth.login.Configuration;

import org.softlang.company.Company;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;


/**
 * A proxy for companies to enforce access control policy for salaries.
 */
class ProxyCompany implements Company {

	private AccessControl context;
	private Company subject;
	private List<Department> depts;

	public ProxyCompany() {
		if (specifications.Configuration.GUI) {
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

	public List<Department> getDepts() {
		if (specifications.Configuration.GUI) {
			return depts;
		} 
		return null;
	}

	public void setDepts(List<Department> depts) {
		if (specifications.Configuration.GUI) {
			this.depts = depts;
		}
	}

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (specifications.Configuration.GUI) {
			return this.getName();
		} 
		return "";
	}

}
