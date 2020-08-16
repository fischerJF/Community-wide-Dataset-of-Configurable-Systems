package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import specifications.Configuration;

public class BoardManager {

	protected Board board;
	protected List sudokuViews;
	protected Stack history;

	public BoardManager() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			sudokuViews = new LinkedList();
			if (Configuration.STATES) {
				history = new Stack();
			}
//		}
	}

	protected void updateSudokuViews() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			for (int i = 0; i < sudokuViews.size(); i++) {
			}
//		}
	}

	public void loadFile(File f) throws IOException {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			preLoadWrapper();
			board = new Board();
			BufferedReader fileReader = new BufferedReader(new FileReader(f));

			int digit = (Field.POSSIBILITIES / 10) + 1;

			int row = 0;
			while (row < Field.POSSIBILITIES) {
				String sudokuLine = fileReader.readLine();
				int value;
				char c;

				int extendedInt;
				char extendedC;

				if (digit == 1) {
					for (int i = 0; i < Field.POSSIBILITIES; i++) {
						c = sudokuLine.charAt(i);

						if (c != '.') {
							value = Integer.parseInt(Character.toString(c));
							setFieldPrivate(Structure.ROW, row, i, new Field(
									value, true));
						}
					}
				} else if (digit == 2) {
					for (int i = 0; i < Field.POSSIBILITIES * digit; i = i
							+ digit) {
						c = sudokuLine.charAt(i);
						extendedC = sudokuLine.charAt(i + 1);

						if (c != '.') {
							value = Integer.parseInt(Character.toString(c)) * 10;
							extendedInt = Integer.parseInt(Character
									.toString(extendedC));
							value += extendedInt;
							setFieldPrivate(Structure.ROW, row, (i / digit),
									new Field(value, true));
						}
					}
				}

				row++;
			}
			updateSudokuViews();
//		}
	}

	protected void setFieldPrivate(Structure structure, int structNr,
			int element, Field f) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			board.setField(structure, structNr, element, f);
//		}
	}

	protected void preSetFieldWrapper(Structure structure, int structNr,
			int element, Field f) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (Configuration.STATES) {
				try {
					history.push(board.clone());
				} catch (CloneNotSupportedException e) {
				}
			}
//		}
	}

	protected void preLoadWrapper() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (Configuration.STATES) {
				history.clear();
			}
//		}
	}

	public void setField(Structure structure, int structNr, int element, Field f) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			preSetFieldWrapper(structure, structNr, element, f);
			setFieldPrivate(structure, structNr, element, f);
			updateSudokuViews();
//		}
	}

	public Field getField(Structure structure, int structNr, int element) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			return getBoard().getField(structure, structNr, element);
//		}
//		return null;
	}

	public Board getBoard() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (board == null) {
				board = new Board();
			}
			return board;
//		}
//		return null;
	}

	public void setBoard(Board board) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			this.board = board;
//		}
	}

	public void setPossibilities(int possibilities) {
		if (Configuration.EXTENDEDSUDOKU) {
			Field.POSSIBILITIES = possibilities;
			this.board = null;
			updateSudokuViews();
		}
	}

	public void loadSudoku(Board board) {
		if (Configuration.GENERATOR) {
			preLoadWrapper();
			this.board = board;
			updateSudokuViews();
		}
	}

	public void setBusy(boolean busy) {
		if (Configuration.SOLVER) {
			for (int i = 0; i < sudokuViews.size(); i++) {
				// ((Gui) sudokuViews.get(i)).setBusy(busy);
			}
		}
	}

	protected boolean busy;

	protected boolean trySetFieldPrivate(Structure structure, int structNr,
			int element, Field f) {
		if (Configuration.SOLVER) {
			return board.trySetField(structure, structNr, element, f);
		}
		return false;
	}

	public boolean trySetField(Structure structure, int structNr, int element,
			Field f) {
		if (Configuration.SOLVER) {
			preSetFieldWrapper(structure, structNr, element, f);
			boolean set = trySetFieldPrivate(structure, structNr, element, f);
			if (set) {
				updateSudokuViews();
				return true;
			} else {
				undo();
				return false;
			}
		}
		return false;
	}

	public boolean tryLoadFile(File f) throws IOException {
		if (Configuration.SOLVER) {
			preLoadWrapper();
			board = new Board();
			BufferedReader fileReader = new BufferedReader(new FileReader(f));

			int digit = (Field.POSSIBILITIES / 10) + 1;

			int row = 0;
			while (row < Field.POSSIBILITIES) {
				String sudokuLine = fileReader.readLine();
				int value;
				char c;
				int extendedInt;
				char extendedC;

				if (digit == 1) {
					for (int i = 0; i < Field.POSSIBILITIES; i++) {
						c = sudokuLine.charAt(i);

						if (c != '.') {
							value = Integer.parseInt(Character.toString(c));
							if (!trySetFieldPrivate(Structure.ROW, row, i,
									new Field(value, true))) {
								board = null;
								updateSudokuViews();
								return false;
							}
						}
					}
				} else if (digit == 2) {
					for (int i = 0; i < Field.POSSIBILITIES * digit; i = i
							+ digit) {
						c = sudokuLine.charAt(i);
						extendedC = sudokuLine.charAt(i + 1);
						if (c != '.' && extendedC != '.') {
							value = Integer.parseInt(Character.toString(c)) * 10;
							extendedInt = Integer.parseInt(Character
									.toString(extendedC));
							value += extendedInt;
							if (!trySetFieldPrivate(Structure.ROW, row,
									(i / digit), new Field(value, true))) {
								board = null; //dangerous!
								updateSudokuViews();
								return false;
							}
						}
					}
				}
				row++;
			}
			updateSudokuViews();
			return true;
		}
		return false;
	}

	public boolean solutionHint() {
		if (Configuration.SOLVER) {
			if (board.isSolved())
				return true;
			try {
				setBusy(true);
				List solutions = solve((Board) board.clone());
				if (solutions.isEmpty()) {
					setBusy(false);
					return false;
				}
				for (int i = 0; i < Field.POSSIBILITIES; i++)
					for (int j = 0; j < Field.POSSIBILITIES; j++)
						if (!board.getField(Structure.ROW, i, j).isSet()
								&& ((Board) solutions.get(0)).getField(
										Structure.ROW, i, j).isSet()) {
							trySetField(Structure.ROW, i, j,
									((Board) solutions.get(0)).getField(
											Structure.ROW, i, j));
							updateSudokuViews();
							return true;
						}
				setBusy(false);
			} catch (CloneNotSupportedException e) {
			}
			return false;
		}
		return false;
	}

	protected List solve(Board board) {
		if (Configuration.SOLVER) {
			List solutions = new LinkedList();
			List solvers = new LinkedList();
			solvers.add(new ForcedField());
			solvers.add(new ForcedNumber());
			Guesser guesser = new Guesser();
			for (int i = 0; i < solvers.size(); i++)
				if (!((Solver) solvers.get(i)).trySolve(board))
					return solutions;
			if (!board.isSolved()) {
				List guessed = guesser.guess(board);
				for (int i = 0; i < guessed.size(); i++)
					solutions.addAll(solve(((Board) guessed.get(i))));
			} else {
				solutions.add(board);
			}
			return solutions;
		}
		return null;
	}

	public void loadState(File f) throws IOException, ClassNotFoundException {
		if (Configuration.STATES) {
			ObjectInput i = new ObjectInputStream(new FileInputStream(f));
			updateSudokuViews();
		}
	}

	public void saveState(File f) throws IOException {
		if (Configuration.STATES) {
			ObjectOutput o = new ObjectOutputStream(new FileOutputStream(f));
			o.writeObject(getBoard());
			o.writeObject(history);
			o.close();
		}
	}

	public void undo() {
		if (Configuration.UNDO) {
			if (!history.empty()) {
				board = (Board) history.pop();
				updateSudokuViews();
			}
		}
	}

}
