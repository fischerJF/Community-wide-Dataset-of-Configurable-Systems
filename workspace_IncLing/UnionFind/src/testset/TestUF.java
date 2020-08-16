package testset;
import static org.junit.Assert.*; 

import org.junit.*;

import UnionFind.UnionFind;
import specifications.Configuration;

import static org.junit.Assert.*; 

import org.junit.*; 

public  class  TestUF {
	
	UnionFind qf;

	
	protected static final int SIZE = 10;

	

	@Before
	public void init(){
//		Configuration.unionfind=true;
		if(Configuration.unionfind)
		qf = new UnionFind(SIZE);
	}

	
	@Test
	public void testNoConnectionsAfterInit() {
		if(Configuration.unionfind) {
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i != j)
					assertFalse(qf.connected(i, j));
			}
		}
		}
	}

	

	@Test
	public void testReflexivity() {
		if(Configuration.unionfind) {

		for (int i = 0; i < SIZE; i++) {
			assertTrue(qf.connected(i, i));
		}
		}
	}

	

//	@Test
	public void testUnion1() {
		qf.union(1, 3);
		assertTrue(qf.connected(1,3));
	}

	
//	@Test
	public void testCommutativity() {
		qf.union(1, 3);
		assertTrue(qf.connected(1,3));
		assertTrue(qf.connected(3,1));
	}

	
	
//	@Test
	public void testTransitivity(){
		qf.union(1, 3);
		qf.union(3, 5);
		assertTrue(qf.connected(1,5));
	}


}
