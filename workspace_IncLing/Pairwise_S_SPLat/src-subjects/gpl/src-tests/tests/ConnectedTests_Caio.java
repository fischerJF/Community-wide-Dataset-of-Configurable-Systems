package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import smashed.FinishTimeWorkSpace;
import smashed.Main;
import smashed.RegionWorkSpace;
import smashed.Vertex;
import smashed.WorkSpaceTranspose;
import splat.GPLVariables;


public class ConnectedTests_Caio extends GPLTest{

  @Test
  /*
   * This test includes the methods:
   *  -RegionWorkSpace()
   *  -RegionWorkSpace.init_vertex
   *  -RegionWorkSpace.postVisitAction
   *  -Vertex.display
   */
  public void ConnectedRelated() {
    //Setting Features
//    GPLVariables.getSINGLETON().setCONNECTED___(true);
    
    //Allocating variables
    Vertex v1 = new Vertex();
    
    RegionWorkSpace r = new RegionWorkSpace();
    assertEquals(r.counter, 0);
    
    r.init_vertex(v1);
    assertEquals(v1.componentNumber, -1);
    r.postVisitAction(v1);
    assertEquals(v1.componentNumber, 0);
    
    /*Testing Display*/
    v1.display();
    assertTrue(Main.testOps.contains("Vertex.display, CONNECTED was displayed!"));
    
  }
  
  @Test
  /*
   * This test includes the methods:
   *  -Vertex.display()
   *  -FinishTimeWorkSpace()
   *  -FinishTimeWorkSpace.preVisitAction()
   *  -FinishTimeWorkSpace.postVisitAction()
   *  -WorkSpaceTranspose()
   *  -WorkSpaceTranspose.nextRegionAction()
   *  -WorkSpaceTranspose.preVisitAction()
   */
  public void StronglyConnected(){
    //Setting Features
//    GPLVariables.getSINGLETON().setSTRONGLYCONNECTED___(true);
    
    //Allocating variables
    Vertex v1 = new Vertex();
    Vertex v2 = new Vertex();
    
    v1.display();
    assertTrue(Main.testOps.contains("Vertex.display, STRONGLYCONNECTED was displayed!"));
    
    /*FinishTimeWorkSpace Tests*/
    FinishTimeWorkSpace f = new FinishTimeWorkSpace();
    assertEquals(f.FinishCounter, 1);
    f.preVisitAction(v1);
    assertEquals(f.FinishCounter, 2);
    f.postVisitAction(v1);
    assertNotSame(v1.finishTime, 0);
    
    /*WorkSpaceTranspose Tests*/
    WorkSpaceTranspose w = new WorkSpaceTranspose();
    assertEquals(w.SCCCounter, 0);
    w.nextRegionAction(v2);
    assertEquals(w.SCCCounter, 1);
    w.preVisitAction(v2);
    assertEquals(v2.strongComponentNumber, 1);
    
  }

}
