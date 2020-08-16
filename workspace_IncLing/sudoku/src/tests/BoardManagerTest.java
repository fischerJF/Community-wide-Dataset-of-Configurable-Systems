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

public class BoardManagerTest {

	private BoardManager board;

	@Before
	public void setup() {
		board = new BoardManager();
	}

	@Test
	public void boardManagerTest() throws IllegalArgumentException, IllegalAccessException {

//		Configuration.STATES = true;
		if (Configuration.STATES) {
			board = new BoardManager();
			List list = (List) MemberModifier.field(BoardManager.class, "sudokuViews").get(board);
			assertNotEquals(list, null);
			assertTrue(list instanceof List);
			Stack stack = (Stack) MemberModifier.field(BoardManager.class, "history").get(board);
			assertNotEquals(stack, null);
			assertTrue(stack instanceof Stack);
		}
	}

	@Test
	public void getBoardTest() throws IllegalArgumentException, IllegalAccessException {
		assertTrue(board.getBoard() instanceof Board);
		Board b = (Board) MemberModifier.field(BoardManager.class, "board").get(board);

		assertNotEquals(b, null);
	}

	@Test
	public void setBoardTest() throws IllegalArgumentException, IllegalAccessException {
		Board b = new Board();
		board.setBoard(b);
		Board b2 = (Board) MemberModifier.field(BoardManager.class, "board").get(board);
		assertEquals(b2, b);
	}

	@Test
	public void undoTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.UNDO = true;
		if (Configuration.UNDO) {
			Stack stack = (Stack) MemberModifier.field(BoardManager.class, "history").get(board);

			Board b1 = new Board();
			Board b2 = new Board();
			stack.push(b1);
			stack.push(b2);
			board.undo();
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(board);

			assertEquals(boardReturn, b2);
		}
	}

	@Test
	public void preLoadWrapper() throws Exception {
//		Configuration.STATES = true;
		if (Configuration.STATES) {
			Stack stack = (Stack) MemberModifier.field(BoardManager.class, "history").get(board);
			Board b1 = new Board();
			Board b2 = new Board();
			stack.push(b1);
			stack.push(b2);
			Whitebox.invokeMethod(board, "preLoadWrapper");
			assertTrue(stack.empty());
		}
	}

	@Test
	public void setPossibilitiesTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.EXTENDEDSUDOKU = true;
		if (Configuration.EXTENDEDSUDOKU) {
			board.setPossibilities(5);
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(board);
			assertEquals(boardReturn, null);
			assertEquals(Field.POSSIBILITIES, 5);
		}
	}

	@Test
	public void loadSudokuTest() throws IllegalArgumentException, IllegalAccessException {
//		Configuration.GENERATOR = true;
		if (Configuration.GENERATOR) {
			Board b1 = new Board();
			board.loadSudoku(b1);
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(board);
			assertEquals(boardReturn, b1);
		}
	}

	@Test
	public void loadFileTest() throws Exception {

		board.loadFile(new File("inputTest.txt"));

	}

	@Test
	public void saveLoadStateTest() throws Exception {
//		Configuration.STATES = true;
		if (Configuration.STATES) {

			board.saveState(new File("state2.txt"));
			File f = new File("state2.txt");
			assertTrue(f.length() != 0);
			board.loadState(new File("state2.txt"));
		}
	}

	@Test
	public void tryLoadFileTest() throws Exception {
		
		 

//		Configuration.SOLVER = true;
		if (Configuration.SOLVER) {
			board = new BoardManager();
			assertTrue(board.tryLoadFile(new File("inputTest4.txt")));
		}
//		Configuration.SOLVER = false;
		if (!Configuration.SOLVER) {
			board = new BoardManager();
			assertFalse(board.tryLoadFile(new File("inputTest4.txt")));
		}
	}

	@Test
	public void trySetFieldTest() throws IOException {
//		Configuration.SOLVER = false;
		if (!Configuration.SOLVER) {
			board = new BoardManager();
			assertFalse(board.trySetField(null, 0, 0, null));
		}
//		Configuration.SOLVER = true;
//		if (Configuration.SOLVER) {
//			board = new BoardManager();
//			board.tryLoadFile(new File("inputTest1.txt"));
//			board.trySetField(Structure.ROW, 1, 1, new Field(4, true));
//
//		}
	}

	@Test
	public void trySetFieldPrivateTest() throws Exception {
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			board = new BoardManager();
			boolean b = (boolean) Whitebox.invokeMethod(board, "trySetFieldPrivate",Structure.ROW, 1, 1, new Field(4, true));
			assertEquals(b, false);
		}
	}
	
	//@Test
	public void solveTest() throws Exception {
		
//		Configuration.SOLVER=true;
		if (Configuration.SOLVER) {
			board = new BoardManager();
			board.tryLoadFile(new File("inputTest4.txt"));
			Board boardReturn = (Board) MemberModifier.field(BoardManager.class, "board").get(board);
			
			List list = (List)  Whitebox.invokeMethod(board, "solve", boardReturn);
		    assertFalse(list.isEmpty());
		}
//		Configuration.SOLVER=false;
		if (!Configuration.SOLVER) {
			board = new BoardManager();
			Board boardTest = new Board();
           	List list = (List) Whitebox.invokeMethod(board, "solve", boardTest);
		    assertEquals(list, null);
		}
	}
}
