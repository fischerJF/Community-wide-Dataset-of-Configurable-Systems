package backtracker;

public class IntervalChoiceGenerator implements ChoiceGenerator {

	// make this generic to other domains...
	int lo;
	int hi;
	int next;

	/**********************************
	 * default constructor behaves like a boolean choice
	 **********************************/
	public IntervalChoiceGenerator() {
		lo = 0;
		hi = 1;
		next = lo;
	}

	public IntervalChoiceGenerator(int lo, int hi) {
		this.lo = lo;
		this.hi = hi;
		this.next = lo;
	}

	// this is an iterator! make it implement int iterator
	public boolean hasNext() {
		return next <= hi;
	}

	public int next() {
		return next++;
	}

	public void backOne() {
		// next--;
		if (next <= lo)
			next = hi;
		else
			next--;
	}

	public int peek() {
		return next;
	}

	public String toString() {
		return lo + "-" + hi + "-(" + next + ")";
	}

	public IntervalChoiceGenerator clone() {
		IntervalChoiceGenerator clone = new IntervalChoiceGenerator(lo, hi);
		clone.lo = lo;
		clone.hi = hi;
		clone.next = next;
		return clone;
	}

	public int getState() {
		if (next == 2)
			return 0;
		else
			return 1;
	}

}
