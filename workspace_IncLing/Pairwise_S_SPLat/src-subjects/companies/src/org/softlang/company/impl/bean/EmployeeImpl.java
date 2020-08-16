package org.softlang.company.impl.bean;

import org.softlang.company.Employee;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import splat.CompaniesVariables;

public class EmployeeImpl extends ComponentImpl implements Employee {

	private String name;
	private String address;
	private double salary;
	private boolean manager;

	private double oldSalary;

	public double getOldSalary() {
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___()) {
			return oldSalary;
		}
		return -1;
	}

	public void setOldSalary(double oldSalary) {
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___()) {
			this.oldSalary = oldSalary;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		boolean select = false;
		if (CompaniesVariables.getSINGLETON().isLOGGING___())
			select = true;
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___())
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
		if (CompaniesVariables.getSINGLETON().isLOGGING___())
			select = true;
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___())
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
			if (CompaniesVariables.getSINGLETON().isPRECEDENCE___()) {
				this.oldSalary = this.salary;
			}
			this.salary = salary;
			boolean select = false;
			if (CompaniesVariables.getSINGLETON().isLOGGING___())
				select = true;
			if (CompaniesVariables.getSINGLETON().isPRECEDENCE___())
				select = true;
			if (select) {
				setChanged();
				notifyObservers("salary");
			}
		}
	}

	public void setSalaryWithOldSalary() {
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___()) {
			this.salary = this.oldSalary;
		}
	}

	public boolean getManager() {
		return manager;
	}

	public void setManager(boolean manager) {
		this.manager = manager;
		boolean select = false;
		if (CompaniesVariables.getSINGLETON().isLOGGING___())
			select = true;
		if (CompaniesVariables.getSINGLETON().isPRECEDENCE___())
			select = true;
		if (select) {
			setChanged();
			notifyObservers("manager");
		}
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

	/**
	 * This method returns the name for the tree-view.
	 */
	@Override
	public String toString() {
		if (CompaniesVariables.getSINGLETON().isGUI___()) {
			String treeName = this.getName();
			if (manager) {
				return treeName + " (Manager)";
			}
			return treeName;
		}
		return "";
	}

}
