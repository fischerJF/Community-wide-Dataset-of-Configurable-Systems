package testset;

import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.Locale;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.OutputStream;
import java.io.PrintStream;
import UnionFind.In;
import UnionFind.Stopwatch;
import UnionFind.UnionFind;
import specifications.Configuration;

public class UnionFindTest {

	UnionFind uf;

	@Before
	public void setUp() {
		if (Configuration.unionfind) {
		uf = new UnionFind(2);
		}

	}

	@Test
	public void countTest() {
//		Configuration.unionfind = true;
		if (Configuration.unionfind) {
			uf = new UnionFind(20);
			assertEquals(uf.count(), 20);
		}
	}

	@Test
	public void connected_quickunionTest() {
//		Configuration.unionfind = true;
		if (Configuration.unionfind) {
			In in = new In("TestData/test.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);
			int p = in.readInt();
			int q = in.readInt();
			
			assertFalse(uf.connected(p, q));
		}
	}
	public void connectedTest() {
//		Configuration.unionfind = true;
		Configuration.quickunion=true;
		if (Configuration.unionfind && Configuration.quickunion) {
			In in = new In("TestData/test.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);
			int p = in.readInt();
	
			assertTrue(uf.connected(p, p));
		}
	}

	@Test
	public void unionWqu_byheightTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_byheight = true;
//		Configuration.qu_weighted = true;
		if (Configuration.unionfind && Configuration.wqu_byheight && Configuration.qu_weighted) {
			In in = new In("TestData/mediumUF.txt");
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
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);

		}
	}

	@Test
	public void union__wrappee__QuickFindTest() throws Exception {
		
//		Configuration.quickfind = true;
		if (Configuration.quickfind) {
			In in = new In("TestData/mediumUF.txt");
			int N = in.readInt();
			Stopwatch s = new Stopwatch();
			UnionFind uf = new UnionFind(N);
			
			while (!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				if (uf.connected(p, q))
					continue;
				Whitebox.invokeMethod(uf, "union__wrappee__QuickFind", p,q);
			}
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);
			
		}
	}
	@Test
	public void union__wrappee__QU_WeightedTest() throws Exception {
		
//		Configuration.qu_weighted = true;
		if (Configuration.qu_weighted ) {
			In in = new In("TestData/mediumUF.txt");
			int N = in.readInt();
			Stopwatch s = new Stopwatch();
			UnionFind uf = new UnionFind(N);

			while (!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				if (uf.connected(p, q))
					continue;
				Whitebox.invokeMethod(uf, "union__wrappee__QU_Weighted", p,q);
			}
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);

		}
	}

	@Test
	public void union__wrappee__QuickUnionTest() throws Exception {
		
//		Configuration.quickunion = true;
		if ( Configuration.quickunion) {
			In in = new In("TestData/mediumUF.txt");
			int N = in.readInt();
			Stopwatch s = new Stopwatch();
			UnionFind uf = new UnionFind(N);

			while (!in.isEmpty()) {
				int p = in.readInt();
				int q = in.readInt();
				if (uf.connected(p, q))
					continue;
				Whitebox.invokeMethod(uf, "union__wrappee__QuickUnion", p,q);
			}
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);

		}
	}

	@Test
	public void unionTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_byheight = true;
		if (Configuration.unionfind && Configuration.wqu_byheight) {
			In in = new In("TestData/mediumUF.txt");
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
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);

		}
	}

	@Test
	public void union_qu_weightedTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_byheight = true;
//		Configuration.qu_weighted = true;
		if (Configuration.unionfind && Configuration.wqu_byheight && Configuration.qu_weighted) {
			In in = new In("TestData/mediumUF.txt");
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
			assertTrue(s.elapsedTime() > 0);
			assertEquals(uf.count(), 3);
		}
	}

	@Test
	public void idTest() {
//		Configuration.unionfind = true;
		if (Configuration.unionfind) {
			uf = new UnionFind(10);
			assertTrue(uf.id(9) == 9);
		}
	}

	@Test
	public void findTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_pathcompression = true;
		if (Configuration.unionfind && Configuration.wqu_pathcompression) {
			In in = new In("TestData/test.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);
			int p = in.readInt();

			assertEquals(uf.find(p), 4);
		}
	}

	@Test
	public void find__wrappee__WQU_HalfingTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_pathcompression = false;
//		Configuration.wqu_halfing = true;
		if (Configuration.unionfind && !Configuration.wqu_pathcompression && Configuration.wqu_halfing) {
			In in = new In("TestData/test.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);
			int p = in.readInt();

			assertEquals(uf.find(p), 4);
		}
	}

	@Test
	public void find__wrappee__QuickUnionTest() {
//		Configuration.unionfind = true;
//		Configuration.wqu_pathcompression = false;
//		Configuration.wqu_halfing = false;
		if (Configuration.unionfind && !Configuration.wqu_pathcompression && !Configuration.wqu_halfing) {
			In in = new In("TestData/test.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);
			int p = in.readInt();

			assertEquals(uf.find(p), 4);
		}
	}

	@Test
	public void connected__wrappee__QuickFindTest() throws Exception {
//		Configuration.unionfind = true;
		if (Configuration.unionfind) {
			In in = new In("TestData/mediumUF.txt");
			int N = in.readInt();
			UnionFind uf = new UnionFind(N);

			int p = in.readInt();

			boolean b = (boolean) Whitebox.invokeMethod(uf, "connected__wrappee__QuickFind", p, p);

			assertTrue(b);
		}
	}
	
	
}
