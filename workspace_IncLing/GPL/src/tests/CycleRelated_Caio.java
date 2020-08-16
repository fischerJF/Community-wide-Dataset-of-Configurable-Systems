package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import smashed_varexj.CycleWorkSpace;
import smashed_varexj.Graph;
import smashed_varexj.Main;
import smashed_varexj.Vertex;
import specifications.Configuration;

public class CycleRelated_Caio   {

  @Before
  public void setup(){
    
  }

  @Test
  /*
   * This test includes the methods:
   *    -CycleWorkSpace.init_vertex(),
   *    -CycleWorkSpace.preVisitAction(),
   *    -CycleWorkSpace.postVisitAction(),
   *    -CycleWorkSpace.NeighborAction()
   */
  
  //Caso interessante 
  
  
  public void CycleSpaceRelated() {
    //Setting features
//    GPLVariables.getSINGLETON().setCYCLE___(true);
	//  Configuration.CYCLE=true;
//	  Configuration.CYCLE=true;
    if(Configuration.CYCLE) {
    /*Alocating Variables*/
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    CycleWorkSpace c = new CycleWorkSpace();

    /*Makes the vertexes white*/
    c.init_vertex(v1);
    c.init_vertex(v2);
    assertEquals(0, v1.VertexColor);
    
    /* Makes the vertexes gray */
    c.preVisitAction(v1);
    c.preVisitAction(v2);
    assertEquals(1, v1.VertexColor);
    
    /*Check Neighbor Action Method*/
    c.checkNeighborAction(v1, v2);  
    //assertTrue(c.AnyCycles);
    
    /* Makes the vertexes black*/
    c.postVisitAction(v1);
    c.postVisitAction(v2);
    assertEquals(2, v1.VertexColor);
    }

  }
  
 @Test
  /*
   * This test includes the methods:
   *  -Graph.addAnEdge
   *  -Graph.addEdge
   *  -Graph.adjustAdorns
   *  -Vertex.VertexConstructor
   *  -Vertex.display
   *  -Graph.display
   */
  public void WeightedGraphRelated(){
    //Setting features
//    GPLVariables.getSINGLETON().setWEIGHTED___(true);

//	 Configuration.WEIGHTED=true;
	 if(Configuration.WEIGHTED) {
    /*Alocating Variables*/
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    Graph g = new Graph();
    v2.addWeight(2);
    
    /*Creating the graph*/
    g.addVertex(v1);
    g.addVertex(v2);
    
    /*Linking v1->v2*/
    g.addAnEdge(v1, v2, 4); 
    assertTrue(v1.adjacentVertices.contains(v2));
    
    /*Testing display by Graph*/
   // g.display();
//    assertTrue(Main.testOps.contains("Vertex.display, WEIGHTED was displayed!"));//Tests Vertex.display  
//    assertTrue(Main.testOps.contains("Graph.display, WEIGHTED was displayed!"));  //Tests Vertex.Graph
    
    /*Test adjustAdorns*/
    v1.adjustAdorns(v2, 0);
    assertTrue(v1.weightsList.contains(2));
	 }
  }
  
  @Test
  /*
   * This test includes the methods:
   *  -Graph.addEdge (Vertex x, Vertex y, int weight)
   *  -Graph.addEdge (Vertex x, Vertex y)
   */
  public void undirectedAddEdge(){
    //Setting features
//    GPLVariables.getSINGLETON().setUNDIRECTED___(true);
//    GPLVariables.getSINGLETON().setWEIGHTED___(true);
//	  Configuration.UNDIRECTED=true;
//	  Configuration.WEIGHTED=true;
	  if(Configuration.UNDIRECTED && Configuration.WEIGHTED) {
    /*Alocating Variables*/
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    Vertex v3 = new Vertex();
    Graph g = new Graph();

    g.addVertex(v1);
    g.addVertex(v2);
    g.addVertex(v3);
    
    //Since the graph is UNDIRECTED, an edge will connect both ways
    g.addEdge(v1, v2);
    assertTrue(v2.adjacentVertices.contains(v1));
    //Same test using WEIGHTED edges
    g.addEdge(v1, v3, 5);
    assertTrue(v3.adjacentVertices.contains(v1));
	  }
  }


}
