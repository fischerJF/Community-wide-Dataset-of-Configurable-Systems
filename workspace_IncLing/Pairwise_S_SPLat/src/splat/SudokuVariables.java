package splat;

import java.util.Map;

import entry.FeatureVar;

public class SudokuVariables extends Variables {

	/**
	 * singleton implementation
	 */
	private static SudokuVariables singleton;

	public static SudokuVariables getSINGLETON() {
		if (singleton == null) {
			singleton = new SudokuVariables();
		}
		return singleton;
	}

	private FeatureVar BASE___, STATES___, UNDO___, COLOR___, SOLVER___,
			GENERATOR___, EXTENDEDSUDOKU___;

	private SudokuVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.STATES___ = new FeatureVar("STATES___");
		this.UNDO___ = new FeatureVar("UNDO___");
		this.COLOR___ = new FeatureVar("COLOR___");
		this.SOLVER___ = new FeatureVar("SOLVER___");
		this.GENERATOR___ = new FeatureVar("GENERATOR___");
		this.EXTENDEDSUDOKU___ = new FeatureVar("EXTENDEDSUDOKU___");
		restore();

		try {
		//	guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		state.put(BASE___, "1");
		state.put(STATES___, "?");
		state.put(UNDO___, "?");
		state.put(COLOR___, "?");
		state.put(SOLVER___, "?");
		state.put(GENERATOR___, "?");
		state.put(EXTENDEDSUDOKU___, "?");
	}

	/******************/

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setSTATES___(boolean v) {
		state.put(STATES___, (v ? "1" : "0"));
	}

	public void setUNDO___(boolean v) {
		state.put(UNDO___, (v ? "1" : "0"));
	}

	public void setCOLOR___(boolean v) {
		state.put(COLOR___, (v ? "1" : "0"));
	}

	public void setSOLVER___(boolean v) {
		state.put(SOLVER___, (v ? "1" : "0"));
	}

	public void setGENERATOR___(boolean v) {
		state.put(GENERATOR___, (v ? "1" : "0"));
	}

	public void setEXTENDEDSUDOKU___(boolean v) {
		state.put(EXTENDEDSUDOKU___, (v ? "1" : "0"));
	}

	/******************/

	public boolean getBASE___() {
		return notifyFeatureRead(BASE___).equals("1");
	}

	public boolean getSTATES___() {
		return notifyFeatureRead(STATES___).equals("1");
	}

	public boolean getUNDO___() {
		return notifyFeatureRead(UNDO___).equals("1");
	}

	public boolean getCOLOR___() {
		return notifyFeatureRead(COLOR___).equals("1");
	}

	public boolean getSOLVER___() {
		return notifyFeatureRead(SOLVER___).equals("1");
	}

	public boolean getGENERATOR___() {
		return notifyFeatureRead(GENERATOR___).equals("1");
	}

	public boolean getEXTENDEDSUDOKU___() {
		return notifyFeatureRead(EXTENDEDSUDOKU___).equals("1");
	}

	private String notifyFeatureRead(FeatureVar fvar) {
		String tmp = state.get(fvar);
		if (tmp == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
	//		tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
			//state.put(fvar, tmp);
		}
		return tmp;
	}

	/******************/
	@Override
	public void restore() {
		state.clear();
		init();
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "sudoku";
	}

}
