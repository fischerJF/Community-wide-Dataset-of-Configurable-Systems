package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import specifications.Configuration;

/**
 * Stores all possible numbers that can still be set on a sudoku field. A Field
 * can be set to final, only one possibility is left after that.
 * 
 * Attention! There is no 0 in sudoku. All values are stored n-1, that means the
 * possibility 1 is stored as 0 in a Bitset. getFinal() can return 0 if no
 * possibility is left, but if that happens the sudoku cannot be solved.
 * getValue(0) is invalid!
 * 
 */
public class Field implements Cloneable, Serializable {

	/**
	 * Numbers of sudoku
	 */
	public static int POSSIBILITIES = 9;
	protected boolean set;
	protected boolean initialSet;
	protected int value;
	protected List remainingPos;
	protected String color;

	/**
	 * 
	 * Fill the remainingPos list.
	 */
	public Field() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			this.initialSet = false;
			this.set = false;

			if (Configuration.COLOR) {
				this.color = "";
			}

			if (Configuration.SOLVER) {
				remainingPos = new LinkedList();
				for (int i = 1; i <= POSSIBILITIES; i++) {
					remainingPos.add((Object) i);
				}
			}
//		}
	}

	/**
     * 
     *  
     */
	public Field(int value, boolean initialSet) {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			this.value = value;
			this.set = true;
			this.initialSet = initialSet;

			if (Configuration.COLOR) {
				this.color = "";
			}

			if (Configuration.SOLVER) {
				remainingPos = new LinkedList();
			}
//		}
	}

	public Field(int value) {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			this.value = value;
			this.set = true;
			this.initialSet = false;

			if (Configuration.COLOR) {
				this.color = "";
			}

			if (Configuration.SOLVER) {
				remainingPos = new LinkedList();
			}
//		}
	}

	/**
	 * 
	 * @return
	 */
	public int getValue() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			return value;
//		}
//		return -1;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isInitialSet() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			return initialSet;
//		}
//		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean isSet() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			return set;
//		}
//		return false;
	}

	public void setInitial(boolean flag) {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.GENERATOR) {
				initialSet = flag;
			}
//		}
	}

	public Field(List remainingPos) {
		this();
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.SOLVER) {
				this.remainingPos = remainingPos;
			}
//		}
	}

	/**
	 * 
	 * @return
	 */
	public List getRemainingPos() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.SOLVER) {
				return remainingPos;
			}
//		}
		return null;
	}

	// f������rs Testen
	public String toString() {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.SOLVER) {
				String output = "";
				if (remainingPos.isEmpty()) {
					output = "[" + value + "]";
				} else {
					output = "{";
					for (int i = 0; i < remainingPos.size(); i++) {
						output += remainingPos.get(i).toString();
					}
					output += "}";
				}
				return output;
			}
//		}
		return null;
	}

	public Object clone() throws CloneNotSupportedException {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.SOLVER) {
				Field clone = (Field) stateClone(); // watch out, i can't find
													// the
													// clone method in base
													// fetaure
				LinkedList remainingPosClone = new LinkedList();
				for (int i = 0; i < remainingPos.size(); i++) {
					remainingPosClone.add(new Integer(((Integer) remainingPos
							.get(i)).intValue()));
				}
				clone.remainingPos = remainingPosClone;
				return clone;
			}
//		}
		return null;
	}

	public Object stateClone() throws CloneNotSupportedException {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.STATES) {
				Field clone = new Field();
				clone.initialSet = initialSet;
				clone.set = set;
				clone.value = value;
				return clone;
			}
//		}
		return null;
	}

	private void writeObject(ObjectOutputStream aOutputStream)
			throws IOException {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.STATES) {
				aOutputStream.writeBoolean(set);
				aOutputStream.writeBoolean(initialSet);
				aOutputStream.writeInt(value);
				aOutputStream.defaultWriteObject();
			}
//		}
	}

	private void readObject(ObjectInputStream aInputStream)
			throws ClassNotFoundException, IOException {
//		if (SudokuTEST.getSINGLETON().get_BASE___()) {
			if (Configuration.STATES) {
				aInputStream.defaultReadObject();
				set = aInputStream.readBoolean();
				initialSet = aInputStream.readBoolean();
				value = aInputStream.readInt();
			}
//		}
	}

}
