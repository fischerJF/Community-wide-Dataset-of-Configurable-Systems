package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.FileReader;
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

public class MainTest {

	private Main main;

	@Before
	public void setUp() {
		main = new Main();
	}

	@Test
	public void customDisplayTest() {
//		Configuration.UNDIRECTED = false;
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
			
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
	        PrintStream ps = new PrintStream(stream);
	        PrintStream originalPrintStream = System.out;
	        System.setOut(ps);

			main.customDisplay(g);
			System.setOut(originalPrintStream);
	        String output = new String(stream.toByteArray());
			assertTrue(output.toString().contains(
					"Vertices \r\n" + "Printing vertex: \r\n" + "v1\r\n" + "0\r\n" + "Connected to: \r\n" + "v2"));

			assertTrue(
					output.toString().contains("Printing vertex: \r\n" + "v2\r\n" + "0\r\n" + "Connected to: \r\n" + "v3"));
		}
	}

	@Test
	public void getInputGraphTest() {
		String[] args = new String[2];
		args[0] = "files/random1-gpl-benchmark.txt";
		Graph g = main.getInputGraph(args);

		assertNotNull(g);
		assertEquals(g.vertices.size(), 101);
		System.out.println();
	}

//	 @Test
	public void mainBodyTest() {
//		Configuration.WEIGHTED = true;
//		Configuration.base = true;

		
		if (Configuration.WEIGHTED) {
			String[] args = new String[3];
			args[0] = "files/random1-gpl-benchmark.txt";
			args[1] = "files/random1-gpl-benchmark.txt";

			OutputStream os = new ByteArrayOutputStream();
			PrintStream ps = new PrintStream(os);
			System.setOut(ps);

			main.mainBody___(args);

			assertTrue(os.toString().contains("Printing vertex:"));
			assertTrue(os.toString().contains("v98"));
			assertTrue(os.toString().contains( "Weights:"));
			assertTrue(os.toString().contains("10"));
			assertTrue(os.toString().contains("Connected to:"));
		}
	}

	// @Test
	public void cycleTest_test() {
		String[] args = new String[3];
		args[0] = "files/random1-gpl-benchmark.txt";

		OutputStream os = new ByteArrayOutputStream();
		PrintStream ps = new PrintStream(os);
		System.setOut(ps);

		main.cycleTest(args);

		assertTrue(os.toString().contains("Cycle check result: false"));
	}

	@Test
	public void kruskalTest_test() {
//		Configuration.CYCLE = true;
		if (Configuration.CYCLE) {
			String[] args = new String[3];
			args[0] = "files/random1-gpl-benchmark.txt";
			main.kruskalTest(args);
		}
	}

}
