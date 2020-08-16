package smashed_varexj;

import specifications.Configuration;

// *****************************************************************

public class RegionWorkSpace implements WorkSpace {
  /* @(Connected) */

  public int counter;

  /* @(Connected) */

  public RegionWorkSpace() {
    if (Configuration.CONNECTED)
      counter = 0;
  }

  /* @(Connected) */

  public void init_vertex(Vertex v) {
    if (Configuration.CONNECTED)
      v.componentNumber = -1;
  }

  /* @(Connected) */

  public void postVisitAction(Vertex v) {
    if (Configuration.CONNECTED)
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
