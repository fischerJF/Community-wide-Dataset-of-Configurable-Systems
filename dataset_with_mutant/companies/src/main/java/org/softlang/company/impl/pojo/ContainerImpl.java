package org.softlang.company.impl.pojo;








import java.util.LinkedList;
import java.util.List;

import org.softlang.company.Container;
import org.softlang.company.Subunit;

public abstract class ContainerImpl extends ComponentImpl implements Container {

	private List<Subunit> subunits = new LinkedList<Subunit>();

	public Iterable<? extends Subunit> subunits() {
		return subunits;
	}

	public boolean add(Subunit u) {
		return subunits.add(u);
	}

	public boolean remove(Subunit u) {
		return subunits.remove(u);
	}
}
