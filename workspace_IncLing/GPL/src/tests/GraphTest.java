package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import smashed_varexj.Main;
import smashed_varexj.Vertex;
import smashed_varexj.Graph;

import static org.mockito.Matchers.anyObject;
import specifications.Configuration;

public class GraphTest {

	private Graph g;

	@Before
	public void setUp() {
		g = new Graph();
	}

	@Test
	public void findsVertexTest() {
		Main main = new Main();
		String[] args = new String[2];
		args[0] = "files/random1-gpl-benchmark.txt";
		Graph graph = main.getInputGraph(args);

		assertEquals(graph.findsVertex("v51").name, "v51");

	}

	@Test
	public void findsVertexTest2() {
		Main main = new Main();
		String[] args = new String[2];
		args[0] = "files/random1-gpl-benchmark.txt";
		Graph graph = main.getInputGraph(args);
		
		double time1=Main.findsVertexTime;
		long vertex= Main.findsVertexCount;
		assertEquals(graph.findsVertex("v51").name, "v51");
		assertTrue(Main.findsVertexTime>time1);
		assertTrue(Main.findsVertexCount>vertex);
	}

	@Test
	public void findsVertexReturnNullTest() {

		Main main = new Main();
		String[] args = new String[2];
		args[0] = "files/random1-gpl-benchmark.txt";
		Graph graph = main.getInputGraph(args);
		assertEquals(graph.findsVertex("v51").name, "v51");

		Vertex aVertex = (Vertex) graph.vertices.get(0);
		aVertex.name = null;

		double time1=Main.findsVertexTime;
		long vertex= Main.findsVertexCount;
		assertNull(graph.findsVertex("v0"));
		assertTrue(Main.findsVertexTime>time1);
		assertTrue(Main.findsVertexCount>vertex);
	
	}

	@Test
	public void findsVertexReturnNullTest2() throws Exception {

		Main main = new Main();
		String[] args = new String[2];
		args[0] = "files/random1-gpl-benchmark.txt";
		Graph graph = main.getInputGraph(args);
		
		
		double time1=Main.findsVertexTime;
		long vertex= Main.findsVertexCount;
		long startTime = System.nanoTime();
		
		assertNull(graph.findsVertex(null));
		double input=System.nanoTime() - startTime;
		double d= (double)	Whitebox.invokeMethod(g, "getSeconds", input);
		
		assertFalse(Main.findsVertexTime<0);
		assertTrue(Main.findsVertexTime>time1);
		assertTrue(Main.findsVertexTime>time1);
		assertTrue(Main.findsVertexCount>vertex);
		
		Main.findsVertexTime=Double.MAX_VALUE; 
		time1=Main.findsVertexTime;
		assertNull(graph.findsVertex(null));
		assertFalse(Main.findsVertexTime>time1);
		assertFalse(Main.findsVertexTime<0);
		Main.findsVertexTime=0;
	}
	

	@Test
	public void addEdgeTest() {
//		Configuration.UNDIRECTED=false;
		if (!Configuration.UNDIRECTED) {
			Graph g = new Graph();
			Vertex v1 = new Vertex();
			v1.name = "v1";

			Vertex v2 = new Vertex();
			v2.name = "v2";

			Vertex v3 = new Vertex();
			v3.name = "v3";

			g.addVertex(v1);
			g.addVertex(v2);
			g.addVertex(v3);

			g.addEdge(v1, v2);
			g.addEdge(v2, v3);

			assertTrue(g.vertices.contains(v1));
			assertTrue(g.vertices.contains(v2));
			assertTrue(g.vertices.contains(v3));

			Vertex aVertex = (Vertex) g.vertices.get(0);
			assertEquals(aVertex.adjacentVertices.get(0), v2);

			aVertex = (Vertex) g.vertices.get(1);
			assertEquals(aVertex.adjacentVertices.get(0), v3);

			aVertex = (Vertex) g.vertices.get(2);
			assertEquals(aVertex.adjacentVertices.size(), 0);
		}
	}
	
	@Test
	public void getSecondsTest() throws Exception {
		double input=2000;
		double d= (double)	Whitebox.invokeMethod(g, "getSeconds", input);
	   assertEquals(d,2,0);
	}

    @Test
	public void displayTest() {
//		 Configuration.WEIGHTED=false;
		 
		 if(!Configuration.WEIGHTED){
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		        PrintStream ps = new PrintStream(stream);
		        PrintStream originalPrintStream = System.out;
		        System.setOut(ps);
		        System.setOut(originalPrintStream);
		        String output = new String(stream.toByteArray());
			 assertEquals(output.toString(),"");
		 }
	}
	@Test
	public void displayTest2() {
//		 Configuration.WEIGHTED=true;
		 
		 if(Configuration.WEIGHTED){
			 
			 Main main = new Main();
			 String[] args = new String[2];
			 args[0] = "files/random1-gpl-benchmark.txt";
			 Graph graph = main.getInputGraph(args);
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     PrintStream ps = new PrintStream(stream);
		     PrintStream originalPrintStream = System.out;
		     System.setOut(ps);
			 
		     graph.display();
			 assertTrue(main.splBuffer.length()!=0); 
			 assertTrue(main.testOps.size()!=0); 
			 
			 System.setOut(originalPrintStream);
		     String output = new String(stream.toByteArray());
		        
			 assertTrue(output.toString().contains("Vertices ")); 
			 assertTrue(output.toString().contains("Printing vertex: \r\n")); 
			 assertTrue(output.toString().contains("v100")); 
			 assertTrue(output.toString().contains("Weights:")); 
			 assertTrue(output.toString().contains("10")); 
			 assertTrue(output.toString().contains("Connected to:")); 
			 assertTrue(output.toString().contains("v90")); 
			 assertTrue(Main.testOps.toString().contains("Graph.display"));
			 assertTrue(Main.testOps.toString().contains("WEIGHTED was displayed!"));
		 }
	}
	
	@Test
	public void runSHORTEST_Test() {
//		 Configuration.SHORTEST=true;
		 
		 if (Configuration.SHORTEST) {
			 
			 Main main = new Main();
			 String[] args = new String[2];
			 args[0] = "files/random1-gpl-benchmark.txt";
			 Graph graph = main.getInputGraph(args);
			 
			 graph.vertices.get(0);
			 Vertex aVertex = (Vertex) graph.vertices.get(0); 		
			 
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     PrintStream ps = new PrintStream(stream);
		     PrintStream originalPrintStream = System.out;
		     System.setOut(ps);

			 
			 g.run(aVertex);
			 System.setOut(originalPrintStream);
		     String output = new String(stream.toByteArray());
			 assertTrue(output.toString().contains("<SHORTEST___ graph>")); 
			 assertTrue(output.toString().contains("******************************************")); 
			 assertTrue(Main.testOps.toString().contains("Graph.run"));
			 assertTrue(Main.testOps.toString().contains("WEIGHTED was displayed!"));
			 assertTrue(output.toString().contains("Vertices "));
		 }
	}
	
	@Test
	public void runMSTKRUSKAL_Test() {
//		 Configuration.MSTKRUSKAL=true;
//		 Configuration.WEIGHTED=true;
		 
		 if (Configuration.MSTKRUSKAL  && Configuration.WEIGHTED) {
			 
			 Main main = new Main();
			 String[] args = new String[2];
			 args[0] = "files/random1-gpl-benchmark.txt";
			 Graph graph = main.getInputGraph(args);
			 
			 graph.vertices.get(0);
			 Vertex aVertex = (Vertex) graph.vertices.get(0); 		
			 
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     PrintStream ps = new PrintStream(stream);
		     PrintStream originalPrintStream = System.out;
		     System.setOut(ps);
			 
			 g.run(aVertex);
			 System.setOut(originalPrintStream);
		     String output = new String(stream.toByteArray());
			 assertTrue(output.toString().contains("<MSTKRUSKAL___ graph>")); 
			 assertTrue(output.toString().contains("******************************************")); 
			 assertTrue(Main.testOps.toString().contains("Graph.run"));
			 assertTrue(Main.testOps.toString().contains("MSTKRUSKAL display"));
			 assertTrue(output.toString().contains("Vertices "));
		 }
	}
	@Test
	public void runMSTPRIM_Test() {
//		 Configuration.MSTPRIM=true;
//		 Configuration.WEIGHTED=true;
		 
		 if (Configuration.MSTPRIM  && Configuration.WEIGHTED) {
			 
			 Main main = new Main();
			 String[] args = new String[2];
			 args[0] = "files/random1-gpl-benchmark.txt";
			 Graph graph = main.getInputGraph(args);
			 
			 graph.vertices.get(0);
			 Vertex aVertex = (Vertex) graph.vertices.get(0); 		
			 
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     PrintStream ps = new PrintStream(stream);
		     PrintStream originalPrintStream = System.out;
		     System.setOut(ps);
			 
			 g.run(aVertex);
			
			 System.setOut(originalPrintStream);
		     String output = new String(stream.toByteArray());
		        
			 assertTrue(output.toString().contains("<MSTPRIM___ graph>")); 
			 assertTrue(output.toString().contains("******************************************")); 
			 assertTrue(Main.testOps.toString().contains("Graph.run"));
			 assertTrue(Main.testOps.toString().contains("MSTKRUSKAL display"));
			 assertTrue(output.toString().contains("Vertices "));
		 }
	}
	
	@Test
	public void runCYCLE_Test() {
//		Configuration.CYCLE=true;
//		Configuration.WEIGHTED=true;
		
		if (Configuration.CYCLE  && Configuration.WEIGHTED) {
			
			Main main = new Main();
			String[] args = new String[2];
			args[0] = "files/random1-gpl-benchmark.txt";
			Graph graph = main.getInputGraph(args);
			
			graph.vertices.get(0);
			Vertex aVertex = (Vertex) graph.vertices.get(0); 		
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);
			
			g.run(aVertex);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains("<CYCLE___>")); 
			assertTrue(output.toString().contains("******************************************")); 
			assertTrue(Main.testOps.toString().contains("Graph.run"));
			assertTrue(Main.testOps.toString().contains("Cycle display"));
			assertTrue(output.toString().contains("Vertices "));
		}
	}
	@Test
	public void run_STRONGLYCONNECTEDTest() {
//		 Configuration.STRONGLYCONNECTED=true;
//		 Configuration.WEIGHTED=true;
		 
		 if (Configuration.STRONGLYCONNECTED  ) {
			 
			 Main main = new Main();
			 String[] args = new String[2];
			 args[0] = "files/random1-gpl-benchmark.txt";
			 Graph graph = main.getInputGraph(args);
			 
			 graph.vertices.get(0);
			 Vertex aVertex = (Vertex) graph.vertices.get(0); 		
			 
			 ByteArrayOutputStream stream = new ByteArrayOutputStream();
		     PrintStream ps = new PrintStream(stream);
		     PrintStream originalPrintStream = System.out;
		     System.setOut(ps);
			 
			 g.run(aVertex);
			 System.setOut(originalPrintStream);
		     String output = new String(stream.toByteArray());
			 assertTrue(output.toString().contains("<STRONGLYCONNECTED___ graph>")); 
			 assertTrue(output.toString().contains("******************************************")); 
			 assertTrue(output.toString().contains("Vertices "));
		 }
	}
	
	@Test
	public void runBenchmarkTest() throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
		
		String args = "files/random1-gpl-benchmark.txt";
		g.runBenchmark(args);
		System.setOut(originalPrintStream);
        String output = new String(stream.toByteArray());
		assertTrue(output.toString().contains("creating inFile")); 
	}

	@Test
	public void runBenchmarkNoFileTest() throws IOException {
		ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(stream);
        PrintStream originalPrintStream = System.out;
        System.setOut(ps);
	
		 String args = "t";
		 g.runBenchmark(args);
		 System.setOut(originalPrintStream);
	     String output = new String(stream.toByteArray());
		 assertTrue(output.toString().contains("Your file")); 
		 assertTrue(output.toString().contains("cannot be read")); 
	}
	
	@Test (expected =  IOException.class)
	public void stopBenchmarkTest() throws IOException {
		String args = "files/random1-gpl-benchmark.txt";
		g.runBenchmark(args);
		g.stopBenchmark();
		assertFalse(g.inFile.ready());
	}
}
