package smashed;

import java.util.LinkedList;

import splat.GPLVariables;

// ************************************************************

public class Vertex {
  /* @(Base) */

  public LinkedList adjacentVertices;
  /* @(Base) */

  public String name;

  /* @(Base) */

  public Vertex() {
    VertexConstructor();
  }

  /* @(Base) */

  public Vertex assignName(String name) {
    this.name = name;
    return (Vertex) this;
  }

  /* @(Base) */

  public void addAdjacent(Vertex n) {
    adjacentVertices.add(n);
  }

  /* @(Base) */

  public LinkedList weightsList;

  /* @(Weighted) */

  public void addWeight(int weight) {
    if (GPLVariables.getSINGLETON().isWEIGHTED___())
      weightsList.add(new Integer(weight));
  }

  /* @(Weighted) */

  public void adjustAdorns(Vertex the_vertex, int index) {
    if (GPLVariables.getSINGLETON().isWEIGHTED___()) {
      int the_weight = ((Integer) the_vertex.weightsList.get(index)).intValue();
      weightsList.add(new Integer(the_weight));
    }
  }

  /* @(Weighted) */

  public boolean visited;

  /* @(Search) */

  public void VertexConstructor() {
    name = null;
    adjacentVertices = new LinkedList();
    if (GPLVariables.getSINGLETON().isWEIGHTED___())
      weightsList = new LinkedList();
    if (GPLVariables.getSINGLETON().isSEARCH___())
      visited = false;
  }

  /* @(Search) */

  public void init_vertex(WorkSpace w) {
    if (GPLVariables.getSINGLETON().isSEARCH___()) {
      visited = false;
      w.init_vertex((Vertex) this);
    }
  }

  /* @(Search) */

  public void bftNodeSearch(WorkSpace w) {
    if (GPLVariables.getSINGLETON().isSEARCH___()) {
      int s, c;
      Vertex v;
      Vertex header;
      // Step 1: if preVisitAction is true or if we've already
      // visited this node
      w.preVisitAction((Vertex) this);
      if (visited)
        return;
      // Step 2: Mark as visited, put the unvisited adjacentVertices in the
      // queue
      // and make the recursive call on the first element of the queue
      // if there is such if not you are done
      visited = true;
      // Step 3: do postVisitAction now, you are no longer going through the
      // node again, mark it as black
      w.postVisitAction((Vertex) this);
      s = adjacentVertices.size();

      // enqueues the vertices not visited
      for (c = 0; c < s; c++) {
        v = (Vertex) adjacentVertices.get(c);
        // if your neighbor has not been visited then enqueue
        if (!v.visited) {
          GlobalVarsWrapper.Queue.add(v);
        }
      } // end of for
      // while there is something in the queue
      while (GlobalVarsWrapper.Queue.size() != 0) {
        header = (Vertex) GlobalVarsWrapper.Queue.get(0);
        GlobalVarsWrapper.Queue.remove(0);
        header.bftNodeSearch(w);
      }
    }
  }

  /* @(DFS) */

  public void dftNodeSearch(WorkSpace w) {
    int s, c;
    Vertex v;

    // Step 1: Do preVisitAction.
    // If we've already visited this node return

    w.preVisitAction((Vertex) this);

    if (visited)
      return;

    // Step 2: else remember that we've visited and
    // visit all adjacentVertices

    visited = true;

    s = adjacentVertices.size();
    for (c = 0; c < s; c++) {
      v = (Vertex) adjacentVertices.get(c);
      w.checkNeighborAction((Vertex) this, v);
      v.dftNodeSearch(w);
    }
    ;

    // Step 3: do postVisitAction now
    w.postVisitAction((Vertex) this);
  }

  /* @(Number) */

  public int VertexNumber;
  /* @(Number) */

  public int componentNumber;
  /* @(Connected) */

  public int finishTime;
  /* @(StronglyConnected) */

  public int strongComponentNumber;
  /* @(StronglyConnected) */

  public int VertexCycle;
  /* @(Cycle) */

  public int VertexColor;
  /* @(Cycle) */
  // white ->0, gray ->1, black->2

  public String pred;
  /* @(MSTPrim) */
  // the name of the predecessor if any
  public int key;
  /* @(MSTPrim) */
  // weight so far from s to it

  public Vertex representative;
  /* @(MSTKruskal) */

  public LinkedList members;
  /* @(MSTKruskal) */

  public String predecessor;
  /* @(Shortest) */
  // the name of the predecessor if any
  public int dweight;

  /* @(Shortest) */
  // weight so far from s to it

  public void display() {
    Main.splPrint___("Printing vertex: ");
    Main.splPrint___(name);

    if (GPLVariables.getSINGLETON().isSHORTEST___()) {
      Main.splPrint___("ShortestPred: " + predecessor);
      Main.splPrint___("DWeight: " + dweight);
    }
    if (GPLVariables.getSINGLETON().isMSTKRUSKAL___()) {
      if (representative == null)
        Main.splPrint___("Rep: null ");
      else {
        Main.splPrint___("Rep: " + representative.name);
      }
    }
    if (GPLVariables.getSINGLETON().isMSTPRIM___()) {
      Main.splPrint___("MSTPrimPred: " + pred);
      Main.splPrint___("Key: " + key);
    }
    if (GPLVariables.getSINGLETON().isCYCLE___()) {
      Main.splPrint___("VertexCycle: " + VertexCycle);
      //DG added testOp      
        Main.testOp("Vertex.display", "CYCLE was displayed!");
    }
    if (GPLVariables.getSINGLETON().isSTRONGLYCONNECTED___()) {
      Main.splPrint___("FinishTime: " + finishTime);
      Main.splPrint___("SCCNo: " + strongComponentNumber);
    //DG added testOp      
      Main.testOp("Vertex.display", "STRONGLYCONNECTED was displayed!");
    }
    if (GPLVariables.getSINGLETON().isCONNECTED___()) {
      Main.splPrint___("comp: " + componentNumber);
      //DG added testOp      
        Main.testOp("Vertex.display", "CONNECTED was displayed!");
    }
    if (GPLVariables.getSINGLETON().isNUMBER___()) {
      Main.splPrint___("VertexNumber: " + VertexNumber);
      //DG added testOp      
        Main.testOp("Vertex.display", "NUMBER was displayed!");
    }
    if (GPLVariables.getSINGLETON().isSEARCH___()) {
      Main.splPrint___("visited: " + visited);
      Main.testOp("Vertex.display", "SEARCH was displayed!");
    }
    if (GPLVariables.getSINGLETON().isWEIGHTED___()) {
      int s = weightsList.size();
      int i;
      Main.splPrint___("Weights: ");
      for (i = 0; i < s; i++) {
        Main.splPrint___(String.valueOf(((Integer) weightsList.get(i))
            .intValue()));
      }
      //DG added testOp      
        Main.testOp("Vertex.display", "WEIGHTED was displayed!");
    }
    int s = adjacentVertices.size();
    int i;

    Main.splPrint___("Connected to: ");
    for (i = 0; i < s; i++)
      Main.splPrint___(((Vertex) adjacentVertices.get(i)).name);
    Main.splPrint___("\n");
    Main.testOp("Vertex.display","Display method covered with SEARCH=" + GPLVariables.getSINGLETON().isSEARCH___());
  }
}
