package UnionFind;

import specifications.Configuration;

public class UnionFind {

	private int[] id;
	private int count;

	// ht[i] = height of subtree rooted at i

	// Create an empty union find data structure with N isolated sets.
	public UnionFind(int N) {
		if (Configuration.unionfind) {
			count = N;
			id = new int[N];
			for (int i = 0; i < N; i++)
				id[i] = i;
		}

		if (Configuration.qu_weighted) {
			sz = new int[N];
			for (int i = 0; i < N; i++) {
				sz[i] = 1;
			}
		}

		if (Configuration.wqu_byheight) {
			count = N;
			id = new int[N];
			ht = new int[N];
			for (int i = 0; i < N; i++) {
				id[i] = i;
				ht[i] = 0;
			}
		}
	}

	// return number of connected components
	/*
	 * @ ensures \result == count;
	 */
	public int count() {
		return count;
	}

	// are elements p and q in the same component?
	/*
	 * @ ensures \original_clause; ensures \result == (id[p] == id[q]);
	 * 
	 * @
	 */
	private /* @pure@ */ boolean connected__wrappee__QuickFind(int p, int q) {
		// if (!Configuration.quickfind)
		// return connected__wrappee__UnionFind(p, q);
		return id[p] == id[q];
	}

	// are elements p and q in the same component?
	/*
	 * @ requires \original_clause; ensures \result == (find(p) == find(q));
	 * 
	 * @
	 */

	// are elements p and q in the same component?
	public boolean connected(int p, int q) {
		if (!Configuration.quickunion)
			return connected__wrappee__QuickFind(p, q);
		return find(p) == find(q);
	}

	// merge components containing p and q
	/*
	 * @ requires 0 <= p && p < id.length; requires 0 <= q && q < id.length; ensures
	 * connected(p,q); ensures \old(connected(p,q)) ==> (count == \old(count));
	 * ensures \old(!connected(p,q)) ==> (count == \old(count) -1);
	 */
	private void union__wrappee__UnionFind(int p, int q) {

	}

	/*
	 * @ \original_spec
	 * 
	 */
	private void union__wrappee__QuickFind(int p, int q) {
		if (!Configuration.quickfind) {
			union__wrappee__UnionFind(p, q);
			return;
		}
		if (connected(p, q))
			return;
		int pid = id[p];
		for (int i = 0; i < id.length; i++)
			if (id[i] == pid)
				id[i] = id[q];
		count--;
	}

	// merge components containing p and q
	private void union__wrappee__QuickUnion(int p, int q) {
		if (!Configuration.quickunion) {
			union__wrappee__QuickFind(p, q);
			return;
		}
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		id[i] = j;
		count--;
	}

	// Replace sets containing p and q with their union.
	private void union__wrappee__QU_Weighted(int p, int q) {
		if (!Configuration.qu_weighted) {
			union__wrappee__QuickUnion(p, q);
			return;
		}
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;

		// make smaller root point to larger one
		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
		count--;
	}

	// Replace sets containing p and q with their union.
	public void union(int p, int q) {
		if (!Configuration.wqu_byheight) {
			union__wrappee__QU_Weighted(p, q);
			return;
		}
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;

		// make smaller root point to larger one
		if (ht[i] < ht[j])
			id[i] = j;
		else if (ht[i] > ht[j])
			id[j] = i;
		else {
			id[j] = i;
			ht[i]++;
		}
		count--;
	}

//	public static void main(String[] args) {
//
//		In in = new In("TestData/mediumUF.txt");
//		int N = in.readInt();
//		Stopwatch s = new Stopwatch();
//		UnionFind uf = new UnionFind(N);
//
//		// read in a sequence of pairs of integers (each in the range 0 to N-1),
//		// calling find() for each pair: If the members of the pair are not already
//		// call union() and print the pair.
//		while (!in.isEmpty()) {
//			int p = in.readInt();
//			int q = in.readInt();
//			if (uf.connected(p, q))
//				continue;
//			uf.union(p, q);
//			// StdOut.println(p + " " + q);
//		}
//		StdOut.println(s.elapsedTime() + " time");
//		uf.count();
//		StdOut.println(uf.count() + " components");
//
//	}

	// return root of component corresponding to element p
	/*
	 * @ requires 0 <= p && p < id.length; ensures connected(\result, p);
	 */
	private /* @pure@ */ int find__wrappee__QuickUnion(int p) {
		while (p != id[p])
			p = id[p];
		return p;
	}

	// return component identifier for component containing p
	private int find__wrappee__WQU_Halfing(int p) {
		if (!Configuration.wqu_halfing)
			return find__wrappee__QuickUnion(p);
		while (p != id[p]) {
			id[p] = id[id[p]]; // path compression by halving
			p = id[p];
		}
		return p;
	}

	// Return component identifier for component containing p
	public int find(int p) {
		if (!Configuration.wqu_pathcompression)
			return find__wrappee__WQU_Halfing(p);
		int root = p;
		while (root != id[root])
			root = id[root];
		while (p != root) {
			int newp = id[p];
			id[p] = root;
			p = newp;
		}
		return root;
	}

	private int[] sz;

	private int[] ht;

	// return id[i]
	public int id(int i) {
		return id[i];
	}

}
