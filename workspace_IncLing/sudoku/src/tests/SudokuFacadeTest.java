package tests;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Stack;

import org.junit.Test;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import main.Board;
import main.BoardManager;
import main.Field;
import main.Structure;
import main.SudokuFacade;
import main.SudokuGenerator;

import org.junit.After;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import specifications.Configuration;

public class SudokuFacadeTest {

 
   private  SudokuFacade sf;

  @Before
  public void setup() {
	  Configuration.BASE=true;
	  sf = new SudokuFacade();
	  
  }
  
  @Test
  public void getBoardTest() {
	// sf.loadFile(new File("inputTest4.txt"));
	 sf.setField(Structure.ROW, 1, 1, 1);
	 assertTrue(sf.getBoard() instanceof Board);
  }
  
  @Test
  public void getsGenTest() {
//	  Configuration.BASE=true;
//	  Configuration.GENERATOR=true;
//	  
	  if (Configuration.BASE && Configuration.GENERATOR) {
		  sf = new SudokuFacade();
		  assertTrue(sf.getsGen() instanceof SudokuGenerator);
	  }
  }
  
  @Test
  public void undoTestTest() throws Exception {
//	  Configuration.UNDO=true;
//	  
	  if (Configuration.UNDO) {
		  Stack stack = (Stack) MemberModifier.field(BoardManager.class, "history").get(sf.getBm());
			Board b1 = new Board();
			Board b2 = new Board();
			stack.push(b1);
			stack.push(b2);
		    assertEquals(stack.size(),2);
			sf.undo();
		    assertEquals(stack.size(),1);
	  }
  }
  //@Test
  public void solutionHintTest() throws IllegalArgumentException, IllegalAccessException {
//	  Configuration.SOLVER=true;
//	  Configuration.STATES=true;
	  if (Configuration.SOLVER && Configuration.STATES) {
		  SudokuFacade sf = new SudokuFacade();
		  sf.loadFile(new File("inputTest1.txt"));
		   sf.solutionHint();	  
	  }
//	  Configuration.SOLVER=false;
	  if(!Configuration.SOLVER) {
		  assertFalse(sf.solutionHint());
	  }
  }
  
  @Test
  public void loadStateTest() throws ClassNotFoundException {
//	  Configuration.STATES=true;
	  if (Configuration.STATES) {
		  File f = new File("state2.txt");
		  sf.LoadState(f);
	  }
  }
  @Test
  public void saveStateTest() throws ClassNotFoundException {
//	  Configuration.STATES=true;
	  if (Configuration.STATES) {
		 File f = new File("state1.txt");
		  sf.SaveState(f);
	  }
  }
  
  @After
  public void tearDown() throws FileNotFoundException{
//    SudokuVariables.getSingleton().restore();
    File f = new File("state1.txt");
    PrintWriter writer = new PrintWriter(f);
    writer.print("");
    writer.close();
  }

}