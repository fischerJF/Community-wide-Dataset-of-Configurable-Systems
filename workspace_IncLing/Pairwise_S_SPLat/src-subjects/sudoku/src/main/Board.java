package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import splat.SudokuVariables;

/**
 * Implementation of a State
 * 
 */
public class Board implements Cloneable, Serializable {

	/**
	 * Number of elements of the Sudoku
	 */
	public static int ELEMENTS = Field.POSSIBILITIES * Field.POSSIBILITIES;

	protected Field[] board;

	/** 
	 * 
	 */
	public Board() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			this.board = new Field[ELEMENTS];
			for (int i = 0; i < ELEMENTS; i++) {
				this.board[i] = new Field();
			}
//		}
	}

	/**
	 * Resolves field addresses.
	 * 
	 * @param struct
	 * @param structNr
	 * @param element
	 * @return
	 */
	public Field getField(Structure struct, int structNr, int element) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			return board[getIndex(struct, structNr, element)];
//		}
//		return null;
	}

	protected int getIndex(Structure str, int nr, int ele) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));

			if (str.name().equals("COL"))
				return nr + (ele * Field.POSSIBILITIES);
			else if (str.name().equals("ROW"))
				return (nr * Field.POSSIBILITIES) + ele;
			else if (str.name().equals("BOX"))
				return Field.POSSIBILITIES * (nr / sqrt * sqrt + ele / sqrt)
						+ (nr % sqrt * sqrt + ele % sqrt);
			else
				return -1;
//		}
//		return -1;
	}

	public void setField(Structure structure, int structNr, int element, Field f) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			board[getIndex(structure, structNr, element)] = f;
//		}
	}

	public void removeRandomSetField() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getGENERATOR___()) {
				Random r = new Random(999);
				int size = Field.POSSIBILITIES * Field.POSSIBILITIES;
				int rIndex = r.nextInt(size);
				int counter = 0;
				while ((board[rIndex].value <= 0) && counter < size) {
					rIndex = ((rIndex + counter) % size);
					counter++;
				}
				Board output = new Board();
				for (int i = 0; i < Field.POSSIBILITIES; i++) {
					for (int j = 0; j < Field.POSSIBILITIES; j++) {
						if (getIndex(Structure.ROW, i, j) != rIndex) {
							Field f = getField(Structure.ROW, i, j);
							if (f.isSet())
								output.trySetField(Structure.ROW, i, j,
										new Field(f.getValue()));
						}
					}
				}
				board = output.board;
			}
//		}

	}

	public boolean isSolved() {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSOLVER___()) {
				for (int i = 0; i < board.length; i++)
					if (!board[i].isSet())
						return false;
				return true;
			}
//		}
		return false;
	}

	public boolean trySetField(Structure str, int strIndex, int element, Field f) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSOLVER___()) {
				boolean validRemoveAction = removeValueFromStructures(
						getIndex(str, strIndex, element), f.getValue());
				if (validRemoveAction
						&& getField(str, strIndex, element).getRemainingPos()
								.contains((Object) f.getValue())) {
					setField(str, strIndex, element, f);
					return true;
				} else
					return false;
			}
//		}
		return false;
	}

	protected boolean removeValueFromStructures(int index, int value) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSOLVER___()) {
				List relatedFieldIndices = getRelatedFieldIndices(index);
				for (int i = 0; i < relatedFieldIndices.size(); i++) {
					if (!board[(Integer) relatedFieldIndices.get(i)].isSet()) {
						List remainingPos = board[(Integer) relatedFieldIndices
								.get(i)].getRemainingPos();
						if (remainingPos.contains(value)
								&& remainingPos.size() <= 1)
							return false;
						remainingPos.remove((Object) value);
						board[(Integer) relatedFieldIndices.get(i)] = new Field(
								remainingPos);
					}
				}
				return true;
			}
//		}
		return false;
	}

	protected int getStructureIndex(int index, Structure str) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSOLVER___()) {
				int sqrt = (int) Math.round(Math.sqrt(Field.POSSIBILITIES));
				if (str.name().equals("ROW"))
					return index / Field.POSSIBILITIES;
				else if (str.name().equals("COL"))
					return index % Field.POSSIBILITIES;
				else if (str.name().equals("BOX"))
					return sqrt * (index / (sqrt * Field.POSSIBILITIES))
							+ (index % Field.POSSIBILITIES) / sqrt;
				else
					return -1;
			}
//		}
		return -1;
	}

	protected List getRelatedFieldIndices(int index) {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSOLVER___()) {
				List indices = new LinkedList();
				Structure str;
				int strIndex;
				int indexProcessing;
				for (int i = 0; i < Structure.values().length; i++) {
					str = Structure.values()[i];
					strIndex = getStructureIndex(index, str);
					for (int j = 0; j < Field.POSSIBILITIES; j++) {
						indexProcessing = getIndex(str, strIndex, j);
						if (!(indices.contains(indexProcessing) || indexProcessing == index)) {
							indices.add(indexProcessing);
						}
					}
				}
				return indices;
			}
//		}
		return null;
	}

	public Object clone() throws CloneNotSupportedException {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSTATES___()) {
				Board clone = new Board();
				for (int i = 0; i < board.length; i++) {
					clone.board[i] = (Field) board[i].clone();
				}
				return clone;
			}
//		}
		return null;
	}

	private void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSTATES___()) {
				aOutputStream.writeObject(board);
				aOutputStream.defaultWriteObject();
			}
//		}
	}

	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
//		if (SudokuTEST.getSingleton().get_BASE___()) {
			if (SudokuVariables.getSINGLETON().getSTATES___()) {
				aInputStream.defaultReadObject();
				board = (Field[]) aInputStream.readObject();
			}
//		}
	}

}
