package smashed;

import splat.GPLVariables;

// *****************************************************************

public class RegionWorkSpace implements WorkSpace {
  /* @(Connected) */

  public int counter;

  /* @(Connected) */

  public RegionWorkSpace() {
    if (GPLVariables.getSINGLETON().isCONNECTED___())
      counter = 0;
  }

  /* @(Connected) */

  public void init_vertex(Vertex v) {
    if (GPLVariables.getSINGLETON().isCONNECTED___())
      v.componentNumber = -1;
  }

  /* @(Connected) */

  public void postVisitAction(Vertex v) {
    if (GPLVariables.getSINGLETON().isCONNECTED___())
      v.componentNumber = counter;
  }

  /* @(Connected) */

  public void nextRegionAction(Vertex v) {
    counter++;
  }

  // @Override
  public void checkNeighborAction(Vertex vsource, Vertex vtarget) {
    // TODO Auto-generated method stub

  }

  // @Override
  public void preVisitAction(Vertex v) {
    // TODO Auto-generated method stub

  }
}
