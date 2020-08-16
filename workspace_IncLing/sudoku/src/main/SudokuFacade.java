package main;

import java.io.File;
import java.io.IOException;

import specifications.Configuration;

public class SudokuFacade {

    private Board board;
    private BoardManager bm;
    private SudokuGenerator sGen;

    public SudokuFacade() {
        if (Configuration.BASE) {
            this.bm = new BoardManager();
            if (Configuration.GENERATOR) {
                this.sGen = new SudokuGenerator();
            }
        }
    }

    public void setField(Structure structure, int structNr, int element,
            int field) {
        this.board = bm.getBoard();
        Field f = new Field(field);
//      System.out.println(f.toString());
        board.setField(structure, structNr, element, f);
    }

    /**
     * Executes Load without GUI.
     */
    public void loadFile(File f) {
//      if (SudokuTEST.getSINGLETON().get_BASE___()) {
            if (f != null) {
                try {
                    bm.loadFile(f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (Configuration.SOLVER) {
                if (f != null) {
                    try {
                        if (!bm.tryLoadFile(f))
                            System.out
                                    .println("Invalid sudoku! File was not loaded.");
                    } catch (IOException ex) {
                        System.out
                                .println("Invalid sudoku! File was not loaded.");
                    }
                }
            }
//      }
    }

    /**
     * Executes GenerateSudoku without GUI.
     */
    public void GenerateSudoku() {
        if (Configuration.GENERATOR) {
            Board b = sGen.generate();
        }
    }

    /**
     * Executes LoadSatate without GUI.
     */
    public void LoadState(File f) {
        if (Configuration.STATES) {
            if (f != null) {
                try {
                    bm.loadState(f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (ClassNotFoundException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Executes SaveSatate without GUI.
     */
    public void SaveState(File f) {
        if (Configuration.STATES) {
            if (f != null) {
                try {
                    bm.saveState(f);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /**
     * Executes SetPossibilities without GUI.
     */
    public void setPossibilities(int numberOfPossibilities) {
        if (Configuration.EXTENDEDSUDOKU) {
            bm.setPossibilities(numberOfPossibilities);
        }
    }

    /**
     * Executes SolutionHint without GUI.
     */

    public boolean solutionHint() {
        if (Configuration.SOLVER) {
            if (!bm.solutionHint()) {
              System.out.println("Sudoku not solvable!");
              return false;
            }
            return true;
        }
        return false;
    }

    /**
     * Executes Undo without GUI.
     */
    public void undo() {
        if (Configuration.UNDO) {
            bm.undo();
        }
    }

  public Board getBoard() {
    return board;
  }

  public BoardManager getBm() {
    return bm;
  }

  public SudokuGenerator getsGen() {
    return sGen;
  }

}
