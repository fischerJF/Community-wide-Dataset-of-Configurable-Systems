package org.softlang.company.impl.bean;

import java.util.LinkedList;
import java.util.List;
import java.util.Observer;

import org.softlang.company.Container;
import org.softlang.company.Department;
import org.softlang.company.Subunit;
import org.softlang.util.ObservableSimpleList;
import org.softlang.util.SimpleLinkedList;

import specifications.Configuration;

public abstract class ContainerImpl extends ComponentImpl implements Container {

	private ObservableSimpleList<Subunit> subunits = new ObservableSimpleList<Subunit>(
			new SimpleLinkedList<Subunit>());

	public Iterable<? extends Subunit> subunits() {
		return subunits;
	}

	public boolean add(Subunit u) {
		ComponentImpl i = (ComponentImpl) u;
		if (i.getParent() != null)
			throw new IllegalArgumentException("Attemped re-parenting.");
		i.setParent(this);
		if (Configuration.GUI) {
			if (u instanceof Department) {
				this.depts.add((Department) u);
			}
			return subunits.add(u);
		} 
		return false;
	}

	public boolean remove(Subunit u) {
		ComponentImpl i = (ComponentImpl) u;
		i.setParent(null);
		return subunits.remove(u);
	}

	public void addObserver(Observer o) {
		super.addObserver(o);
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
//		if (Configuration.PRECEDENCE)
//			select = true;
		if (select) {
			subunits.addObserver(o);
		}
	}

	public void deleteObserver(Observer o) {
		super.deleteObserver(o);
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
//		if (Configuration.PRECEDENCE)
//			select = true;
		if (select) {
			subunits.deleteObserver(o);
		}
	}

	public void deleteObservers() {
		super.deleteObservers();
		boolean select = false;
		if (Configuration.LOGGING)
			select = true;
		if (Configuration.PRECEDENCE)
			select = true;
		if (select) {
			subunits.deleteObservers();
		}
	}

	private List<Department> depts;

	public ContainerImpl() {
		if (Configuration.GUI) {
			this.depts = new LinkedList<Department>();
		}
	}

	public void setDepts(LinkedList<Department> departments) {
		if (Configuration.GUI) {
			this.depts = departments;
		}
	}

	public void add(Department department) {
		if (Configuration.GUI) {
			depts.add(department);
		}
	}

	public List<Department> getDepts() {
		if (Configuration.GUI) {
			return depts;
		} 
		return null;
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

}
