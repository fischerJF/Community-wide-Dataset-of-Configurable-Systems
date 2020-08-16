package smashed_varexj;

import specifications.Configuration;

// of vertex

// ************************************************************************

public class Edge {
  /* @(MSTKruskal) */

  public Vertex start;
  /* @(MSTKruskal) */

  public Vertex end;
  /* @(MSTKruskal) */

  public int weight = 0;

  /* @(MSTKruskal) */

  public Edge(Vertex the_start, Vertex the_end, int the_weight) {
    if (Configuration.MSTKRUSKAL) {
      start = the_start;
      end = the_end;
      weight = the_weight;
    }
  } // Edge constructor

}
