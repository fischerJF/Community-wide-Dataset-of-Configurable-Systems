package org.softlang.company.impl.pojo;

import org.softlang.company.Employee;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;

public class EmployeeImpl extends ComponentImpl implements Employee {

	private String address;
	private double salary;
	private boolean manager = false;

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean getManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
	}

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

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (Configuration.GUI) {
			String treeName = this.getName();
			if (manager) {
				return treeName + " (Manager)";
			}
			return treeName;
		} 
		return "";
	}

}
