package smashed_varexj;

import specifications.Configuration;

// ***********************************************************************

public class FinishTimeWorkSpace implements WorkSpace {
  /* @(StronglyConnected) */

  public int FinishCounter;

  /* @(StronglyConnected) */

  public FinishTimeWorkSpace() {
    if (Configuration.STRONGLYCONNECTED) {
      FinishCounter = 1;
      }
  }

  /* @(StronglyConnected) */

  public void preVisitAction(Vertex v) {
    if (Configuration.STRONGLYCONNECTED) {
      if (v.visited != true)
        FinishCounter++;
    }
  }

  /* @(StronglyConnected) */

  public void postVisitAction(Vertex v) {
    if (Configuration.STRONGLYCONNECTED) {
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
