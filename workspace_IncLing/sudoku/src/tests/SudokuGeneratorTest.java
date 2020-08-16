package tests;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import main.Board;
import main.BoardManager;
import main.SudokuFacade;
import main.SudokuGenerator;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

public class SudokuGeneratorTest {

	private SudokuGenerator sudoku;

	@Before
	public void setup() {
		sudoku = new SudokuGenerator();
	}

	@Test
	public void generateTest() {
//		Configuration.GENERATOR = true;
//		Configuration.SOLVER = true;
		if (Configuration.GENERATOR) {
			sudoku.generate();
//			assertTrue(board instanceof Board);
		} 
//		Configuration.GENERATOR = false;
		if(!Configuration.GENERATOR) {
			assertEquals(sudoku.generate(), null);
		}
	}

	@Test
	public void fillBoardTest()throws Exception {
//		Configuration.GENERATOR = true;
//		Configuration.SOLVER = true;
//
		if (Configuration.GENERATOR && Configuration.SOLVER) {
			SudokuFacade sf = new SudokuFacade();
			sf.loadFile(new File("inputTest4.txt"));
			Board boardReturn = (Board) MemberModifier.field(SudokuFacade.class, "board").get(sf);
			sudoku.fillBoard(boardReturn);
		}
	}

//	@Test
	public void makeSolvableTest() throws Exception {
//		Configuration.GENERATOR = true;
//		Configuration.SOLVER = true;
//
//		if (Configuration.GENERATOR && Configuration.SOLVER) {
			BoardManager board= new BoardManager();
			board.tryLoadFile(new File("inputTest4.txt"));
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(board);
			boolean test= (boolean) Whitebox.invokeMethod(sudoku, "makeSolvable", boardReturn, 1);
			assertTrue(test);
//		}
		
		
//		Configuration.GENERATOR=false;
//		if(!Configuration.GENERATOR){
			 test= (boolean) Whitebox.invokeMethod(sudoku, "makeSolvable", new Board(), 1);
			assertFalse(test);
//		}
	}
	
	
	
}
