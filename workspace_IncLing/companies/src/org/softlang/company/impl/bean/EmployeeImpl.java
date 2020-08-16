package org.softlang.company.impl.bean;

import org.softlang.company.Employee;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;

public class EmployeeImpl extends ComponentImpl implements Employee {

	private String name;
	private String address;
	private double salary;
	private boolean manager;

	private double oldSalary;

	public double getOldSalary() {
		if (Configuration.PRECEDENCE) {
			return oldSalary;
		}
		return -1;
	}

	public void setOldSalary(double oldSalary) {
		if (Configuration.PRECEDENCE) {
			this.oldSalary = oldSalary;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
		if (Configuration.PRECEDENCE)
			select = true;
		if (select) {
			setChanged();
			notifyObservers("name");
		}
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
		if (Configuration.PRECEDENCE)
			select = true;
		if (select) {
			setChanged();
			notifyObservers("address");
		}
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary != this.getSalary()) {
			if (Configuration.PRECEDENCE) {
				this.oldSalary = this.salary;
			}
			this.salary = salary;
			boolean select = false;
			if (Configuration.LOGGING)
				select = true;
			if (Configuration.PRECEDENCE)
				select = true;
			if (select) {
				setChanged();
				notifyObservers("salary");
			}
		}
	}

	//feature interaction
	public void setSalaryWithOldSalary() {
//		if (Configuration.PRECEDENCE) {
//			this.salary = this.oldSalary;
//		}
	}

	public boolean getManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
		if (Configuration.PRECEDENCE)
			select = true;
		if (select) {
			setChanged();
			notifyObservers("manager");
		}
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
