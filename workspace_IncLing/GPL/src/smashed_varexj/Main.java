package smashed_varexj;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void splStart___() {
	}

	public static long findsVertexCount;
	public static double findsVertexTime;

	 public static StringBuffer splBuffer = new StringBuffer();

	public static void splPrint___(String s) {
		 splBuffer.append(s + "\n");
		 System.out.println(s);
	}
	
	public static List<String> testOps = new ArrayList<String>();
	public static void testOp(String methodName, String message){
	  testOps.add(methodName + ", " + message);
	}

	/*
	 * public static void numberTest(String[] args) { Graph g =
	 * getInputGraph(args);
	 * 
	 * // Executes the selected features g.startProfile();
	 * 
	 * g.NumberVertices();
	 * 
	 * g.stopProfile(); customDisplay(g); g.resumeProfile();
	 * 
	 * // End profiling g.endProfile(); }
	 */

	public static void customDisplay(Graph g) {
		int s = g.vertices.size();
		int i;

		Main.splPrint___("Vertices ");
		for (i = 0; i < s; i++) {
			Vertex aVertex = (Vertex) g.vertices.get(i);
			Main.splPrint___("Printing vertex: ");
			Main.splPrint___(aVertex.name);
			Main.splPrint___(String.valueOf(aVertex.VertexNumber));

			Main.splPrint___("Connected to: ");
			for (int j = 0; j < aVertex.adjacentVertices.size(); j++)
				Main.splPrint___(((Vertex) aVertex.adjacentVertices.get(j)).name);
			Main.splPrint___("\n");
		}
	}

	public static void splEnd___() {
		// Actually print to console
		try {
			String userDir = System.getProperty("user.dir");
			JavaUtility.INSTANCE.writeToFile(userDir + File.separator
					+ "findsVertexCount.txt", findsVertexCount + "\n", true);
			JavaUtility.INSTANCE.writeToFile(userDir + File.separator
					+ "findsVertexTime.txt", findsVertexTime + "\n", true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.println("findsVertexTime: " + findsVertexTime);
	}

	public static Graph getInputGraph(String[] args) {
		// Step 1: create graph object
		Graph g = new Graph();

		try {
			splPrint___("[" + args[0] + "]");
			g.runBenchmark(args[0]);

			// Step 3: reads number of vertices, number of edges
			// and weights
			int num_vertices = 0;
			int num_edges = 0;
			int dummy = 0;

			num_vertices = g.readNumber();
			num_edges = g.readNumber();
			dummy = g.readNumber();
			dummy = g.readNumber();
			dummy = g.readNumber();

			// Step 4: reserves space for vertices, edges and weights
			Vertex V[] = new Vertex[num_vertices];
			int weights[] = new int[num_edges];
			int startVertices[] = new int[num_edges];
			int endVertices[] = new int[num_edges];

			// Step 5: creates the vertices objects
			int i = 0;
			for (i = 0; i < num_vertices; i++) {
				V[i] = new Vertex().assignName("v" + i);
				g.addVertex(V[i]);
			}

			// Step 6: reads the edges
			for (i = 0; i < num_edges; i++) {
				startVertices[i] = g.readNumber();
				endVertices[i] = g.readNumber();
			}

			// Step 7: reads the weights
			for (i = 0; i < num_edges; i++) {
				weights[i] = g.readNumber();
			}

			// Stops the benchmark reading
			g.stopBenchmark();

			// Step 8: Adds the edges
			for (i = 0; i < num_edges; i++) {
				g.addAnEdge(V[startVertices[i]], V[endVertices[i]], weights[i]);
			}

			// Executes the selected features
			Graph.startProfile();
			splPrint___("arg1: {" + args[1] + "}");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return g;
	}

	public static void mainBody___(String[] args) {
		Graph g = getInputGraph(args);
		Vertex rootVertex = g.findsVertex(args[1].trim());

		g.run(rootVertex);

		Graph.stopProfile();
		splPrint___("******************************************");
		splPrint___("<BASE___ graph>");
		g.display();
		Graph.resumeProfile();

		// End profiling
		Graph.endProfile();
	}

	public static void cycleTest(String[] args) {
		Graph g = getInputGraph(args);

		splPrint___("Cycle check result: " + g.CycleCheck());
	}

	public static void kruskalTest(String[] args) {
		Graph g = getInputGraph(args);

		Graph result = g.Kruskal();
		result.display();
	}
}
