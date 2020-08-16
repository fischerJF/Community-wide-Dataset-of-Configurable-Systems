package Prop4J;
import specifications.Configuration;

import java.util.List; 

/**
 * A constraint that is true iff at most a specified number of children is
 * true.
 * 
 * @author Thomas Thüm
 */
public  class  AtMost  extends Node {
	
	
	public int max;

	

	public AtMost(int max, Object ...children) {
		if (Configuration.atmost) {
			this.max = max;
			setChildren(children);
				}
	}

	

	public AtMost(int max, Node[] children) {
		if (Configuration.atmost) {
			this.max = max;
			setChildren(children);
				}
	}

	

	@Override
	protected Node eliminate(List<Class<? extends Node>> list) {
		super.eliminate(list);
		if (!list.contains(getClass()))
			return this;
		
		Node[] newNodes = chooseKofN(children, max + 1, true);
		return new And(newNodes);
	}

	

	@Override
	public Node clone() {
		return new AtMost(max, clone(children));
	}


}
