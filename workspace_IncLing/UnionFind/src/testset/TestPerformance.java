package testset;

import static org.junit.Assert.*;

import org.junit.*;

import UnionFind.In;
import UnionFind.Stopwatch;
import UnionFind.UnionFind;
import specifications.Configuration;

import static org.junit.Assert.*;

import org.junit.*;

public class TestPerformance {

	private static final String TEST_DATA_LOCATION = "TestData";

	@Before
	public void setUp() {
		// Configuration.unionfind=true;
	}

	@Test
	public void testSmallData() {
		if (Configuration.unionfind)
			testData(TEST_DATA_LOCATION + "/tinyUF.txt");
	}

	@Test
	public void testMediumData() {
		if (Configuration.unionfind)
			testData(TEST_DATA_LOCATION + "/mediumUF.txt");
	}

	//@Test
	public void testLargeData() {
		if (Configuration.unionfind)
			testData(TEST_DATA_LOCATION + "/largeUF.txt");
	}

	private void testData(String filename) {
	
			In in = new In(filename);
			int N = in.readInt();
			Stopwatch s = new Stopwatch();
			UnionFind uf = new UnionFind(N);

			while (!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				if (uf.connected(p, q))
					continue;
				uf.union(p, q);

			}
		
	}
}
