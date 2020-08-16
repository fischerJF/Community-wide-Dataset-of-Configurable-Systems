package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Test;

import smashed_varexj.CycleWorkSpace;
import smashed_varexj.FinishTimeWorkSpace;
import smashed_varexj.Graph;
import smashed_varexj.Main;
import smashed_varexj.Vertex;
import smashed_varexj.WorkSpace;
import specifications.Configuration;

public class MultiFeatureTest_Caio  {

	
	//@Test
	/* * This test includes all display methods which involves feature variables
	 */
	public void displayTest() {
		// Testing display on WEIGTHED being true
		// GPLVariables.getSINGLETON().setWEIGHTED___(true);
		
//		Configuration.WEIGHTED=true;
//		Configuration.CONNECTED=false;
//		Configuration.STRONGLYCONNECTED=false;
		
		
		if (Configuration.WEIGHTED) {
			Vertex v1 = new Vertex();
			//v1.display();

			assertFalse(Main.testOps.contains("Vertex.display, CONNECTED was displayed!"));
//			assertTrue(Main.testOps.contains("Vertex.display, STRONGLYCONNECTED was displayed!"));
//			assertTrue(Main.testOps.contains("Vertex.display, CYCLE was displayed!"));
//			assertTrue(Main.testOps.contains("Vertex.display, NUMBER was displayed!"));
//			assertTrue(Main.testOps.contains("Vertex.display, WEIGHTED was displayed!")); // Works as expected
//			assertFalse(Main.testOps.contains("Vertex.display, MSTPRIM was displayed!"));
//			assertFalse(Main.testOps.contains("Vertex.display, MSTKRUSKAL was displayed!"));
//			assertFalse(Main.testOps.contains("Vertex.display, SHORTEST was displayed!"));
//    		assertTrue(Main.testOps.contains("Vertex.display, SEARCH was displayed!"));
		}
	}

	//@Test
	/*
	 * This test includes all runs displays
	 */
	public void runTest() {
		// Testing when SHORTEST is true
		// GPLVariables.getSINGLETON().setSHORTEST___(true);
//		Configuration.SHORTEST=true;
		
		
		if (Configuration.SHORTEST) {

			Vertex v1 = new Vertex();
			Graph g = new Graph();
			g.run(v1);
			assertFalse(Main.testOps.contains("Graph.run, CONNECTED display"));
			assertFalse(Main.testOps.contains("Graph.run, STRONGLYCONNECTED display"));
			assertFalse(Main.testOps.contains("Graph.run, CYCLE display"));
			assertFalse(Main.testOps.contains("Graph.run, NUMBER display"));
			assertFalse(Main.testOps.contains("Graph.run, MSTPRIM display"));
			assertFalse(Main.testOps.contains("Graph.run, MSTKRUSKAL display"));
			assertTrue(Main.testOps.contains("Graph.run, Shortest Path display")); // Works as expected
		}
	}

	@Test
	public void GraphSearchCycle() {
		// Setting Feature Variables
		// GPLVariables.getSINGLETON().setCYCLE___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		// GPLVariables.getSINGLETON().setDIRECTED___(true);
		
//		Configuration.CYCLE=true;
//		Configuration.SEARCH=true; 
//		Configuration.DIRECTED=true;
		
		if (Configuration.CYCLE && Configuration.SEARCH && Configuration.DIRECTED) {

			// Allocating variables
			Vertex v1 = new Vertex();
			Vertex v2 = new Vertex();
			Graph g = new Graph();

			// Preparing variable values
			g.addVertex(v1);
			g.addVertex(v2);
			g.addEdge(v1, v2);
			g.addEdge(v2, v1);

			// Testing Methods
			assertTrue(g.CycleCheck());
		}
	}

	@Test
	public void GraphSearchNumber() {
		// Setting feature variables
		// GPLVariables.getSINGLETON().setNUMBER___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		
//		Configuration.NUMBER=true;
//		Configuration.SEARCH=true;
		
		if (Configuration.NUMBER &&
		    Configuration.SEARCH	) {

		// Allocating variables
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Graph g = new Graph();
		g.addVertex(v1);

		// Testing graph search
		assertFalse(v1.visited);
		g.NumberVertices();
		assertTrue(v1.visited);
		}
	}

	@Test
	public void GraphSearchConnected() {
		// Setting feature variables
		// GPLVariables.getSINGLETON().setCONNECTED___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		
//		Configuration.CONNECTED=true;
//	    Configuration.SEARCH=true;
		
		if (Configuration.CONNECTED &&
			    Configuration.SEARCH	) {
		// Allocating variables
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Graph g = new Graph();
		g.addVertex(v1);

		// Testing graph search
		assertFalse(v1.visited);
		g.ConnectedComponents();
		assertTrue(v1.visited);
		}
	}

	@Test
	public void GraphSearchSTRConnected() {
		// Setting feature variables
		// GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		
//		Configuration.STRONGLYCONNECTED=true;
//	    Configuration.SEARCH=true;
		
		if (Configuration.STRONGLYCONNECTED &&
			    Configuration.SEARCH	) {
		
		// Allocating variables
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Graph g = new Graph();
		g.addVertex(v1);

		// Testing graph search
		assertFalse(v1.visited);
		g.StrongComponents();
		assertTrue(v1.visited);
		}
	}

	@Test
	public void NodeSearchBFS() {
		// Setting feature variables
		// GPLVariables.getSINGLETON().setBFS___(true);
		// GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		if (Configuration.BFS &&
				Configuration.STRONGLYCONNECTED &&
			    Configuration.SEARCH	) {
		
		// Allocating variables
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		Graph g = new Graph();
		g.addVertex(v1);
		WorkSpace w = new FinishTimeWorkSpace();

		// Testing node search
		assertFalse(v1.visited);
		g.nodeSearch(v1, w);
		assertTrue(v1.visited);
		}
	}

	@Test
	public void CheckNeighborT() {
		// Setting Features
		// GPLVariables.getSINGLETON().setCYCLE___(true);
		// GPLVariables.getSINGLETON().setDIRECTED___(true);
		// Preparing Variables
		if (Configuration.CYCLE &&
				Configuration.DIRECTED ) {
		
		Vertex v1 = new Vertex();
		Vertex v2 = new Vertex();
		CycleWorkSpace c = new CycleWorkSpace();
		// Testing
		c.checkNeighborAction(v1, v2);
		assertFalse(c.AnyCycles);
		v1.VertexColor = 1;
		v2.VertexColor = 1;
		c.checkNeighborAction(v1, v2);
		assertTrue(c.AnyCycles);
		}
	}

	@Test
	public void bftSearch() {
		// Setting Features
		// GPLVariables.getSINGLETON().setBFS___(true);
		// GPLVariables.getSINGLETON().setSEARCH___(true);
		// Allocating Variables
		if (Configuration.BFS &&
				Configuration.SEARCH ) {
		
		Vertex v1 = new Vertex();
		WorkSpace w = new CycleWorkSpace();
		// Testing
		v1.bftNodeSearch(w);
		assertTrue(v1.visited);
		}
	}

}
