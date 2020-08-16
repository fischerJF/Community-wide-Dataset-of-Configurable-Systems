package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import smashed.NumberWorkSpace;
import smashed.Vertex;
import splat.GPLVariables;


public class NumberTests_Caio extends GPLTest {

  @Test
  /*
   * This test includes the methods:
   *  -NumberWorkSpace()
   *  -NumberWorkSpace.preVisitAction()
   */
  public void NumberFeatureBasics() {
    //Setting Feature
//    GPLVariables.getSINGLETON().setNUMBER___(true);    

    //Allocating Variables
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    
    NumberWorkSpace n = new NumberWorkSpace();
    assertEquals(n.vertexCounter, 0);
    
    //The first vertex used in preVisitAction() has its VertexNumber value equals to 0 
    //just like a newly created vertex, so we use two vertexes to properly test this behavior 
    n.preVisitAction(v1);
    assertEquals(n.vertexCounter,1);
    n.preVisitAction(v2);
    assertEquals(v2.VertexNumber, 1);
    assertEquals(n.vertexCounter, 2);
    
    
  }

}
