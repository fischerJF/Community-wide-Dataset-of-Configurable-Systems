package org.softlang.company.impl.bean;

import org.softlang.company.Company;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;

public class CompanyImpl extends ContainerImpl implements Company {

	public void accept(VoidVisitor v) {
	  
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
			v.visit(this);
		}
	}

	public <R> R accept(ReturningVisitor<R> v) {
	  
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
			return v.visit(this);
		}
		return null;
	}

	public CompanyImpl() {
		super();
	}
}
