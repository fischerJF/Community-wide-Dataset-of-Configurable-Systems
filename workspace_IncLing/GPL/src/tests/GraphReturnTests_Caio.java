package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import smashed_varexj.Edge;
import smashed_varexj.Graph;
import smashed_varexj.Vertex;
import specifications.Configuration;

public class GraphReturnTests_Caio  {

	@Test
	public void EdgeConstructorTest() {
		// Setting Feature
		// GPLVariables.getSINGLETON().setMSTKRUSKAL___(true);
//		Configuration.MSTKRUSKAL=true;
		
		if (Configuration.MSTKRUSKAL) {
			// Preparing Variables
			Vertex v1 = new Vertex();
			Vertex v2 = new Vertex();

			// Testing constructor
			Edge myEdge = new Edge(v1, v2, 0);
			assertEquals(myEdge.start, v1);
			assertEquals(myEdge.end, v2);
			assertEquals(myEdge.weight, 0);
		}
	}

	@Test
	public void PrimTest() {
		// Setting Features
		// GPLVariables.getSINGLETON().setMSTPRIM___(true);
		// GPLVariables.getSINGLETON().setUNDIRECTED___(true);
		// GPLVariables.getSINGLETON().setWEIGHTED___(true);
//		Configuration.MSTPRIM=true;
//		Configuration.UNDIRECTED=true;
//		Configuration.WEIGHTED=true;
//		
		if (Configuration.MSTPRIM && Configuration.UNDIRECTED && Configuration.WEIGHTED) {

			// Preparing Variables
			Vertex v1 = new Vertex();
			Vertex v2 = new Vertex();
			Vertex v3 = new Vertex();
			Graph g = new Graph();
			g.addVertex(v1);
			g.addVertex(v2);
			g.addVertex(v3);
			g.addEdge(v1, v2, 3);
			g.addEdge(v1, v3, 2);
			g.addEdge(v2, v3, 1);

			Graph testman = g.Prim(v1);
			assertNotSame(testman, g);
		}
	}

}
