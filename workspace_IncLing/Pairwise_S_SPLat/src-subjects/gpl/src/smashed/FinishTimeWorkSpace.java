package smashed;

import splat.GPLVariables;

// ***********************************************************************

public class FinishTimeWorkSpace implements WorkSpace {
  /* @(StronglyConnected) */

  public int FinishCounter;

  /* @(StronglyConnected) */

  public FinishTimeWorkSpace() {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___()) {
      FinishCounter = 1;
    }
  }

  /* @(StronglyConnected) */

  public void preVisitAction(Vertex v) {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___()) {
      if (v.visited != true)
        FinishCounter++;
    }
  }

  /* @(StronglyConnected) */

  public void postVisitAction(Vertex v) {
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___()) {
      v.finishTime = FinishCounter++;
    }
  } // of postVisit

  // @Override
  public void checkNeighborAction(Vertex vsource, Vertex vtarget) {
    // TODO Auto-generated method stub

  }

  // @Override
  public void init_vertex(Vertex v) {
    // TODO Auto-generated method stub

  }

  // @Override
  public void nextRegionAction(Vertex v) {
    // TODO Auto-generated method stub

  }
}
