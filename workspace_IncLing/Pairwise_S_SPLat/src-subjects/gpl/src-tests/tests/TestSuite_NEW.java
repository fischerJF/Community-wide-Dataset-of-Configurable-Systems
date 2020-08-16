package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import smashed.Graph;
import smashed.Main;
import smashed.RegionWorkSpace;
import smashed.Vertex;
import smashed.WorkSpace;

public class TestSuite_NEW extends GPLTest {

  @Test
  public void test_addEdge_GraphSearch() {
    // System.out.println(">>>>>test_addEdge_GraphSearch<<<<<");
    // System.out.println(">>>>>FEATURES COVERED:<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=0,SEARCH=1,UNDIRECTED=0,DIRECTED=1,CYCLE=1,BFS=0<<<<<");
    // System.out.println(">>>>>METHODS COVERED:<<<<<");
    // System.out
    // .println(">>>>>Vertex.VertexConstructor(),Graph.CycleCheck,CycleWorkSpace(),CWS.init_vertex,postVisitAction,preVisitAction,Graph.GraphSearch,checkNeighborAction,nodeSearch<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setCYCLE___(true);
    // GPLVariables.getSINGLETON().setDIRECTED___(true);

    // GPLVariables.getSINGLETON().setBFS___(false);//sabrina

    Graph g = new Graph();
    Vertex v1 = new Vertex();
    v1.name = "v1";
    v1.addWeight(1); // WEIGHTED not set
    Vertex v2 = new Vertex();
    v2.name = "v2";
    v2.addWeight(1);
    Vertex v3 = new Vertex();
    v3.name = "v3";
    v3.addWeight(2);

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);

    g.addEdge(v1, v2);
    g.addEdge(v1, v3);
    g.addEdge(v3, v1);

    // WorkSpace w = new CycleWorkSpace();
    // g.GraphSearch(w);
    boolean isCycle = g.CycleCheck(); // ->GraphSearch

    assertTrue(v1.visited); // SEARCH
    // assertTrue(((CycleWorkSpace)w).AnyCycles); //DFS
    assertTrue(isCycle);
  }

  @Test
  public void test_run1() {
    // System.out.println(">>>>>test_run1<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=0,SEARCH=1,UNDIRECTED=0,STRONGLYCONNECTED=0,SHORTEST=0<<<<<");
    // System.out
    // .println(">>>>>MSTPRIM=0,MSTKRUSKAL=0,CYCLE=0,CONNECTED=1,NUMBER=1,BFS=0<<<<<");
    // System.out
    // .println(">>>>>METHODS COVERED- METHODS ACCESSING NUMBER FEATURE<<<<<");
    // System.out
    // .println(">>>>>Graph.run(),Graph.NumberVertices,NumberWorkSpace(),NWS.preVisitAction<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setNUMBER___(true);
    // GPLVariables.getSINGLETON().setCONNECTED___(true);

    // GPLVariables.getSINGLETON().setCYCLE___(false);//sabrina
    // GPLVariables.getSINGLETON().setBFS___(false);//sabrina
    // GPLVariables.getSINGLETON().setMSTKRUSKAL___(false);//sabrina
    // GPLVariables.getSINGLETON().setMSTPRIM___(false);//sabrina
    // GPLVariables.getSINGLETON().setWEIGHTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setUNDIRECTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setSHORTEST___(false);//sabrina

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

    g.run(v1); // ->NumberVertices->preVisitAction // NUMBER
               // ->ConnectedComponenets->postVisitiAction //CONNECTED

    assertTrue(v3.VertexNumber == 2);

    assertTrue(v1.componentNumber == 1);

  }

  @Test
  public void test_run2() {
    // System.out.println(">>>>>test_run2<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=1,SEARCH=1,UNDIRECTED=0,STRONGLYCONNECTED=0,SHORTEST=1<<<<<");
    // System.out
    // .println(">>>>>MSTPRIM=0,MSTKRUSKAL=0,CYCLE=0,CONNECTED=0,NUMBER=0,BFS=0<<<<<");
    // System.out
    // .println(">>>>>METHODS COVERED- METHODS ACCESSING SHORTEST-PATH FEATURE<<<<<");
    // System.out.println(">>>>>Graph.ShortestPath<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setWEIGHTED___(true);
    // GPLVariables.getSINGLETON().setSHORTEST___(true);

    // GPLVariables.getSINGLETON().setCYCLE___(false);//sabrina
    // GPLVariables.getSINGLETON().setBFS___(false);//sabrina
    // GPLVariables.getSINGLETON().setMSTKRUSKAL___(false);//sabrina
    // GPLVariables.getSINGLETON().setMSTPRIM___(false);//sabrina
    // GPLVariables.getSINGLETON().setCYCLE___(false);//sabrina
    // GPLVariables.getSINGLETON().setUNDIRECTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setSHORTEST___(true);//sabrina

    Graph g = new Graph();
    Vertex v1 = new Vertex();
    v1.name = "v1";
    v1.addWeight(1);

    Vertex v2 = new Vertex();
    v2.name = "v2";
    v2.addWeight(2);

    Vertex v3 = new Vertex();
    v3.name = "v3";
    v3.addWeight(3);

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);

    g.addEdge(v1, v2);
    g.addEdge(v2, v3);

    g.run(v1);

    assertTrue(Main.testOps.contains("Graph.run, Shortest Path display"));

  }

  @Test
  public void test_run3() {
    // System.out.println(">>>>>test_run3<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=1,SEARCH=1,UNDIRECTED=0,STRONGLYCONNECTED=0,SHORTEST=0<<<<<");
    // System.out
    // .println(">>>>>MSTPRIM=1,MSTKRUSKAL=1,CYCLE=0,CONNECTED=0,NUMBER=0,BFS=0<<<<<");
    // System.out
    // .println(">>>>>METHODS COVERED- METHODS ACCESSING MSTPRIM,KRUSKAL FEATURE<<<<<");
    // System.out.println(">>>>>Graph.Prim,KrusKal,Edge<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setWEIGHTED___(true);
    // GPLVariables.getSINGLETON().setMSTPRIM___(true);
    // GPLVariables.getSINGLETON().setMSTKRUSKAL___(true);

    Graph g = new Graph();
    Vertex v1 = new Vertex();
    v1.name = "v1";
    v1.addWeight(1);

    Vertex v2 = new Vertex();
    v2.name = "v2";
    v2.addWeight(2);

    Vertex v3 = new Vertex();
    v3.name = "v3";
    v3.addWeight(3);

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);

    g.run(v1);

    assertTrue(Main.testOps.contains("Graph.run, MSTPRIM display"));
    assertTrue(Main.testOps.contains("Graph.run, MSTKRUSKAL display"));

  }

  @Test
  public void test_StrongComps() {
    // System.out.println(">>>>>test_StrongComps<<<<<");
    // System.out.println(">>>>>FEATURES COVERED:<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=0,SEARCH=1,UNDIRECTED=0,STRONGLYCONNECTED=1,BFS=0<<<<<");
    // System.out
    // .println(">>>>>METHODS COVERED- METHODS ACCESSING STRONGCOMPONENTS FEATURE<<<<<");
    // System.out
    // .println(">>>>>FinishTimeWorkSpace(),FTWS.preVisitAction,FTWS.postVisitAction,Graph.StrongComponents,WorkSpaceTranspose(),WST.nextRegionAction,WST.preVisitAction<<<<<");
    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(true);

    // GPLVariables.getSINGLETON().setWEIGHTED___(false);//sabrina
    // GPLVariables.getSINGLETON().setBFS___(false);//sabrina
    // GPLVariables.getSINGLETON().setUNDIRECTED___(false);//sabrina

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

    Graph g1 = g.StrongComponents();

    Vertex v10 = (Vertex) g1.vertices.get(0);
    Vertex v11 = (Vertex) g1.vertices.get(1);
    Vertex v12 = (Vertex) g1.vertices.get(2);

    assertTrue((v1.finishTime > v2.finishTime)
        && (v2.finishTime > v3.finishTime));
    assertTrue((v10.strongComponentNumber < v11.strongComponentNumber)
        && (v11.strongComponentNumber < v12.strongComponentNumber));
    // THeSe ASSERTs WILL BE FALSE IF BFS IS SET TO TRUE.

  }

  @Test
  public void test_addEdgeWt() {
    // System.out.println(">>>>>test_addEdgeWt<<<<<");
    // System.out.println(">>>>>FEATURES COVERED:<<<<<");
    // System.out.println(">>>>>WEIGHTED=1,SEARCH=1,UNDIRECTED=0<<<<<");
    // System.out
    // .println(">>>>>METHODS COVERED- METHODS ACCESSING WEIGHTED FEATURE<<<<<");
    // System.out
    // .println(">>>>>Vertex.adjustadorns,addWeight,Graph.addAnEdge,addEdge<<<<<");
    //
    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setWEIGHTED___(true);

    Graph g = new Graph();
    Vertex v1 = new Vertex();
    v1.name = "v1";
    v1.addWeight(1);
    Vertex v2 = new Vertex();
    v2.name = "v2";
    v2.addWeight(2);
    Vertex v3 = new Vertex();
    v3.name = "v3";
    v3.addWeight(3);

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);

    v3.adjustAdorns(v1, 0); // WEIGHTED

    assertTrue(v3.weightsList.contains(1)); // WEIGHTED

    g.addAnEdge(v1, v2, 2);
    g.addAnEdge(v2, v3, 3);

    Vertex adjv = (Vertex) v1.adjacentVertices.getFirst();
    assertTrue(adjv.name.equals("v2"));

  }

  @Test
  public void test_display() {
    // System.out.println(">>>>>test_display<<<<<");
    // System.out.println(">>>>>FEATURES COVERED:<<<<<");
    // System.out
    // .println(">>>>>WEIGHTED=0,SEARCH=0,SHORTEST=0,MSTKRUSKAL=0,MSTPRIM=0,CYCLE=0,STRONGLYCONNECTED=0,CONNECTED=0,NUMBER=0<<<<<");
    // System.out.println(">>>>>METHODS COVERED-display<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(false);//sabrina

    Vertex v1 = new Vertex();
    v1.display();
    assertFalse(v1.visited);
    assertTrue(Main.testOps
        .contains("Vertex.display, Display method covered with SEARCH=false"));
     assertTrue(
     Main.testOps.contains("Vertex.display, SEARCH was displayed!"));

  }

  @Test
  public void test_bftNodeSearch() {
    // System.out.println(">>>>>test_bftNodeSearch<<<<<");
    // System.out.println(">>>>>WEIGHTED=0,SEARCH=1,CONNECTED=0,BFS=1<<<<<");
    // System.out.println(">>>>>METHODS COVERED- bftNodeSearch<<<<<");

    // GPLVariables.getSINGLETON().setSEARCH___(true);
    // GPLVariables.getSINGLETON().setBFS___(true);
    Vertex v1 = new Vertex();
    WorkSpace w = new RegionWorkSpace();
    v1.bftNodeSearch(w);
    assertTrue(v1.visited);
  }

}
