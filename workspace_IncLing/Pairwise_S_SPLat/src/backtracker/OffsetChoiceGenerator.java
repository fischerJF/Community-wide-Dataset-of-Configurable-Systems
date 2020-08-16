package backtracker;

public class OffsetChoiceGenerator implements ChoiceGenerator {

	int[] stack;
	int lo;
	int hi;
	int next;
	int offset;

	public OffsetChoiceGenerator(int lo, int hi, int offset, String[] stack_str) {
		this.lo = lo;
		this.hi = hi;
		this.next = lo;
		// this.offset = Math.abs(offset);
		this.offset = offset;
		// this.stack = getStack();
		this.stack = parseStack(stack_str);
	}

	private int[] parseStack(String[] stack_str) {
		int[] circularArray = new int[stack_str.length];
		for (int i = 0; i < stack_str.length; i++) {
			int element = Integer.parseInt(stack_str[i]);
			circularArray[i] = element;
		}
		return circularArray;
	}

	// /**
	// * Behaves like a circular array, given an interval (lo, hi) and an
	// offset,
	// * it'll return the correspondent array. For example: given lo=0, hi=4 and
	// * offset=2, the result'll be [2,3,4,0,1].
	// */
	// private int[] getStack() {
	// int[] circularArray = new int[(hi - lo) + 1];
	// if ((offset < 0) || (offset > (hi - lo))) // sanity test
	// throw new RuntimeException("[OffsetChoiceGenerator] Unsupported offset");
	// int counter = 0;
	// for (int i = 0; i < (hi - lo) + 1; i++) {
	// circularArray[i] = i;
	// }
	// for (int i = offset; i <= hi; i++) {
	// circularArray[counter++] = i;
	// }
	// for (int j = lo; j < (offset); j++) {
	// circularArray[counter++] = j;
	// }
	// return circularArray;
	// }

	// this is an iterator! make it implement int iterator
	public boolean hasNext() {
		return next <= hi;
	}

	public int next() {
		// System.out.println(next);
		return stack[next++];
	}

	public void backOne() {
		next--;
	}

	public int peek() {
		// return stack[next];
		return next;
	}

	public String toString() {
		return lo + "-" + hi + "-(" + next + ")";
	}

	public OffsetChoiceGenerator clone() {
		throw new RuntimeException("Unsupported operation!");
	}

	@Override
	public int getState() {
		// TODO Auto-generated method stub
		return 0;
	}

	// public static void main(String[] args) {
	// OffsetChoiceGenerator ocg = new OffsetChoiceGenerator(-1, 1, 0);
	// for (Integer x : ocg.getStack()) {
	// System.out.println(x);
	// }
	// }

}