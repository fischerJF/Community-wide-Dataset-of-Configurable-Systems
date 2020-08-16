package org.softlang.company.impl.bean;

import java.util.Observable;

import org.softlang.company.Component;
import org.softlang.visitor.ReturningVisitor;
import org.softlang.visitor.VoidVisitor;

import specifications.Configuration;





/**
 * Observability and a parent axis are added on top of the Component interface.
 */
public abstract class ComponentImpl extends Observable implements Component {

	private ComponentImpl parent;
	private String name;
	//DG
    public String str = "";//TEST

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

	public ComponentImpl getParent() {
		return parent;
	}

	void setParent(ComponentImpl parent) {
		this.parent = parent;
	}

	public abstract void accept(VoidVisitor v);

	public abstract <R> R accept(ReturningVisitor<R> v);
	
	public void testOp(String methodName, int Lineno)
	  {
	     this.str = "LINE NO:" + Lineno + " at method:"+ methodName; 
	  }
}
