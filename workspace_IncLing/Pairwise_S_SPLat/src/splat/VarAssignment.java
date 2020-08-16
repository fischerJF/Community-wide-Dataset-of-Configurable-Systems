package splat;

/**
 * This class denotes a particular assignment of variable to value. An
 * assignment of x to 1 is modeled with VarAssignment(0,1).
 */
public class VarAssignment {
	String var;

	public String getVar() {
		return var;
	}

	public void setVar(String var) {
		this.var = var;
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	String val;

	public VarAssignment(String var, String value) {
		this.var = var;
		this.val = value;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other instanceof VarAssignment) {
			VarAssignment that = (VarAssignment) other;
			result = that.var.equals(this.var) && that.val.equals(this.val);
		}
		return result;
	}
	//
	// public String toString(){
	// return this.var + "=" + this.value;
	// }

	@Override
	public String toString() {
		return String.format("(%s,%s)", var, val);
	}
}
