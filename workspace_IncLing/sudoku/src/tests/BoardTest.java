package tests;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.api.support.membermodification.MemberModifier;
import org.powermock.reflect.Whitebox;

import main.Board;
import main.BoardManager;
import main.Field;
import main.Structure;
import main.SudokuGenerator;
import specifications.Configuration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class BoardTest {

	private Board board;

	@Before
	public void setup() {
		board = new Board();
	}

	@Test
	public void isSolvedTest() throws IllegalArgumentException, IllegalAccessException, IOException {
//		Configuration.SOLVER=true;
		if (Configuration.SOLVER) {
			board = new Board();
			BoardManager boardManager= new BoardManager();
			boardManager.loadFile(new File("inputTest4.txt"));
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(boardManager);
//			assertFalse(boardReturn.isSolved());
			
			//colocar um sudoku completo
		}
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			board = new Board();
			assertFalse(board.isSolved());		
		}
	}
	
	@Test
	public void trySetFieldTest() {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			board = new Board();
			assertFalse(board.trySetField(Structure.ROW, 1, 1, new Field(4, true)));
		}
	}
	
	@Test
	public void removeValueFromStructuresTest() throws Exception {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			boolean test= (boolean) Whitebox.invokeMethod(board, "removeValueFromStructures", 1, 1);

			assertFalse(test);
		}
	}
	
	@Test 
	public void getRelatedFieldIndicesTest() throws Exception {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			List list= (List) Whitebox.invokeMethod(board, "getRelatedFieldIndices", 1);

			assertNull(list);
		}
	}
	@Test
	public void cloneTest() throws CloneNotSupportedException {
//		Configuration.STATES=false;
		if (!Configuration.STATES) {
			board = new Board();
			assertNull(board.clone());
		}
	}
	
	@Test
	public void getStructureIndexTest() throws Exception {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			int test= (int) Whitebox.invokeMethod(board, "getStructureIndex", 1, Structure.ROW);

		}
	}
}
