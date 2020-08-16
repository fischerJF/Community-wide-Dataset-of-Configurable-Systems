package tests;

import java.io.File;

import main.Structure;
import main.SudokuFacade;

import org.junit.Test;

import specifications.Configuration;

public class TestMain extends SudokuTest {

//  @Override
//  protected void configure() {
//    // set mandatory features
//    super.configure();
//    if (testName == null) {
//      throw new RuntimeException();
//    }
//    String strTestName = testName.getMethodName();
//    if (strTestName.equals("testBestScenario")) {
//      // Variables.getSingleton().setGENERATOR___(true);
//      // Variables.getSingleton().setSOLVER___(true);
//    } else if (strTestName.equals("testAverageScenario")) {
//      SudokuVariables.getSingleton().setSTATES___(true);
//      SudokuVariables.getSingleton().setSOLVER___(true);
//    } else if (strTestName.equals("testWorstScenario")) {
//      SudokuVariables.getSingleton().setSTATES___(true);
//      SudokuVariables.getSingleton().setEXTENDEDSUDOKU___(true);
//      SudokuVariables.getSingleton().setUNDO___(true);
//      SudokuVariables.getSingleton().setSOLVER___(true);
//    } else {
//      System.err.printf("%s did not set default configuration", strTestName);
//    }
//  }

//  @Test
//  public void testBestScenario() {
//    SudokuFacade sf = new SudokuFacade();
//    sf.GenerateSudoku();
//  }

	//@Test
	public void testAverageScenario() {
		
//    if(Configuration.STATES &&
//       Configuration.SOLVER ) {
		SudokuFacade sf = new SudokuFacade();
		sf.loadFile(new File("inputTest.txt"));
		sf.solutionHint();
		sf.SaveState(new File("state1.txt"));
		sf.LoadState(new File("state1.txt"));
		sf.setField(Structure.BOX, 1, 2, 4);
		sf.undo();
//    }
	}
 // @Test
  public void testAverageScenario_() {
   
//    if(Configuration.STATES &&
//       Configuration.SOLVER ) {
    SudokuFacade sf = new SudokuFacade();
    sf.loadFile(new File("inputTest2.txt"));
    sf.solutionHint();
    sf.SaveState(new File("state1.txt"));
    sf.LoadState(new File("state1.txt"));
    sf.setField(Structure.BOX, 1, 2, 4);
    sf.undo();
//    }
  }

@Test
  public void testWorstScenario() {
    if(Configuration.STATES &&
        Configuration.SOLVER ) {
    SudokuFacade sf = new SudokuFacade();
    sf.setPossibilities(16);
    sf.setField(Structure.BOX, 2, 4, 1);
    sf.setField(Structure.BOX, 1, 2, 4);
    sf.setField(Structure.BOX, 0, 0, 1);
    sf.SaveState(new File("state1.txt"));
    sf.undo();
    sf.setField(Structure.BOX, 3, 3, 3);
    sf.setField(Structure.BOX, 2, 4, 1);
    sf.SaveState(new File("state1.txt"));
    sf.undo();
    sf.setField(Structure.BOX, 1, 2, 4);
    sf.setField(Structure.BOX, 0, 0, 1);
    sf.SaveState(new File("state1.txt"));
    sf.undo();
    sf.setField(Structure.BOX, 3, 3, 3);
    sf.setField(Structure.BOX, 2, 4, 1);
    sf.setField(Structure.BOX, 1, 2, 4);
    sf.setField(Structure.BOX, 0, 0, 1);
    sf.setPossibilities(9);
    sf.setField(Structure.BOX, 3, 3, 9);
    sf.setField(Structure.BOX, 2, 4, 2);
    sf.SaveState(new File("state1.txt"));
    sf.undo();
    sf.setField(Structure.BOX, 1, 2, 7);
    sf.setField(Structure.BOX, 0, 0, 3);
    sf.setPossibilities(4);
    sf.setField(Structure.BOX, 0, 0, 0);
    sf.setField(Structure.BOX, 2, 2, 2);
    sf.SaveState(new File("state1.txt"));
    }
  }

}
