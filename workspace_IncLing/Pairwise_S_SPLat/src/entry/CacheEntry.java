package entry;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class CacheEntry {

	List<Entry> stack;
	Map<FeatureVar, String> state;

	/**
	 * Characterization of one test run.
	 */
	public CacheEntry(List<Entry> stack, Map<FeatureVar, String> state) {
		this.stack = stack;
		this.state = state;
	}

	public List<Entry> getStack() {
		return stack;
	}

	public void setStack(List<Entry> stack) {
		this.stack = stack;
	}

	public Map<FeatureVar, String> getState() {
		return state;
	}

	public String getStateString() {
		Collection<String> values = this.state.values();
		String result = "";
		for (String v : values) {
			result += v + ",";
		}
		return result;
	}

	public int getNumFVars() {
		int num = 0;
		Collection<String> values = this.state.values();
		for (String v : values) {
			if (!v.equals("?"))
				num++;
		}
		return num;
	}

	public void setState(Map<FeatureVar, String> state) {
		this.state = state;
	}

}
