package smashed;

import java.util.LinkedList;

import splat.GPLVariables;

// Class to wrap global variables

public class GlobalVarsWrapper {
  /* @(BFS) */
  public static LinkedList Queue;

  static {
    if (GPLVariables.getSINGLETON().isBFS___()) {
      Queue = new LinkedList();
    }
  }
}
