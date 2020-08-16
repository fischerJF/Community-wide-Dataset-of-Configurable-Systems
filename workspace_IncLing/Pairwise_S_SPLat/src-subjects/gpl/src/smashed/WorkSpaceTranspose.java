package smashed;

import splat.GPLVariables;

// of FinishTimeWorkSpace

// DFS Transpose traversal
// ***********************************************************************

public class WorkSpaceTranspose implements WorkSpace {
  /* @(StronglyConnected) */

  // Strongly Connected Component Counter
  public int SCCCounter;

  /* @(StronglyConnected) */

  public WorkSpaceTranspose() {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___())
      SCCCounter = 0;
  }

  /* @(StronglyConnected) */

  public void preVisitAction(Vertex v) {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___()) {
      if (v.visited != true) {
        v.strongComponentNumber = SCCCounter;
      }
    }
  }

  /* @(StronglyConnected) */

  public void nextRegionAction(Vertex v) {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___())
      SCCCounter++;
  }

  // @Override
  public void checkNeighborAction(Vertex vsource, Vertex vtarget) {
    // TODO Auto-generated method stub

  }

  // @Override
  public void init_vertex(Vertex v) {
    // TODO Auto-generated method stub

  }

  // @Override
  public void postVisitAction(Vertex v) {
    // TODO Auto-generated method stub

  }

}
