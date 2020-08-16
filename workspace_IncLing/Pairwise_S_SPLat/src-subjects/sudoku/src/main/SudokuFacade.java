package main;

import java.io.File;
import java.io.IOException;

import splat.SudokuVariables;

public class SudokuFacade {

    private Board board;
    private BoardManager bm;
    private SudokuGenerator sGen;

    public SudokuFacade() {
        if (SudokuVariables.getSINGLETON().getBASE___()) {
            this.bm = new BoardManager();
            if (SudokuVariables.getSINGLETON().getGENERATOR___()) {
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
            if (SudokuVariables.getSINGLETON().getSOLVER___()) {
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
        if (SudokuVariables.getSINGLETON().getGENERATOR___()) {
            Board b = sGen.generate();
        }
    }

    /**
     * Executes LoadSatate without GUI.
     */
    public void LoadState(File f) {
        if (SudokuVariables.getSINGLETON().getSTATES___()) {
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
        if (SudokuVariables.getSINGLETON().getSTATES___()) {
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
        if (SudokuVariables.getSINGLETON().getEXTENDEDSUDOKU___()) {
            bm.setPossibilities(numberOfPossibilities);
        }
    }

    /**
     * Executes SolutionHint without GUI.
     */

    public boolean solutionHint() {
        if (SudokuVariables.getSINGLETON().getSOLVER___()) {
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
        if (SudokuVariables.getSINGLETON().getUNDO___()) {
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
