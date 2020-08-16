package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;

import org.junit.Test;

import smashed.Edge;
import smashed.Graph;
import smashed.Vertex;
import splat.GPLVariables;

public class GraphReturnTests_Caio extends GPLTest{

  @Test
  public void EdgeConstructorTest(){
    //Setting Feature
//    GPLVariables.getSINGLETON().setMSTKRUSKAL___(true);
    
    //Preparing Variables
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    
    //Testing constructor
    Edge myEdge = new Edge(v1, v2, 0);
    assertEquals(myEdge.start, v1);
    assertEquals(myEdge.end, v2);
    assertEquals(myEdge.weight, 0);
  }
  
  @Test
  public void PrimTest() {
    //Setting Features
//    GPLVariables.getSINGLETON().setMSTPRIM___(true);
//    GPLVariables.getSINGLETON().setUNDIRECTED___(true);
//    GPLVariables.getSINGLETON().setWEIGHTED___(true);
    
    //Preparing Variables
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    Vertex v3 = new Vertex();
    Graph g = new Graph();
    g.addVertex(v1); g.addVertex(v2); g.addVertex(v3);
    g.addEdge(v1, v2, 3); g.addEdge(v1, v3, 2); g.addEdge(v2, v3, 1); 
    
    Graph testman = g.Prim(v1);
    assertNotSame(testman, g);
    
  }

}
