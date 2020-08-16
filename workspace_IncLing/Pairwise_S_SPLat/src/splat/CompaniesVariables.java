package splat;

import java.util.Map;

import entry.FeatureVar;

public class CompaniesVariables extends Variables {

	private static CompaniesVariables SINGLETON;

	public static CompaniesVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new CompaniesVariables();
		}
		return SINGLETON;
		
	}

	private CompaniesVariables() {
		this.TREE_STRUCTURE___ = new FeatureVar("TREE_STRUCTURE___");
		this.LOGGING___ = new FeatureVar("LOGGING___");
		this.CUT_WHATEVER___ = new FeatureVar("CUT_WHATEVER___");
		this.CUT_NO_DEPARTMENT___ = new FeatureVar("CUT_NO_DEPARTMENT___");
		this.CUT_NO_MANAGER___ = new FeatureVar("CUT_NO_MANAGER___");
		this.GUI___ = new FeatureVar("GUI___");
		this.PRECEDENCE___ = new FeatureVar("PRECEDENCE___");
		this.TOTAL_WALKER___ = new FeatureVar("TOTAL_WALKER___");
		this.TOTAL_REDUCER___ = new FeatureVar("TOTAL_REDUCER___");
		this.ACCESS_CONTROL___ = new FeatureVar("ACCESS_CONTROL___");
		restore();

		try {
			//guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		state.put(TREE_STRUCTURE___, "1");
		state.put(LOGGING___, "?");
		state.put(CUT_WHATEVER___, "?");
		state.put(CUT_NO_DEPARTMENT___, "?");
		state.put(CUT_NO_MANAGER___, "?");
		state.put(GUI___, "?");
		state.put(PRECEDENCE___, "?");
		state.put(TOTAL_WALKER___, "?");
		state.put(TOTAL_REDUCER___, "?");
		state.put(ACCESS_CONTROL___, "?");
	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar TREE_STRUCTURE___, LOGGING___, CUT_WHATEVER___,
			CUT_NO_DEPARTMENT___, CUT_NO_MANAGER___, GUI___, PRECEDENCE___,
			TOTAL_WALKER___, TOTAL_REDUCER___, ACCESS_CONTROL___;

	// public boolean isCUT_WHATEVER___() {
	// return get(VARS.CUT_WHATEVER___).equals("1");
	// }

	public void setCUT_WHATEVER___(boolean v) {
		state.put(CUT_WHATEVER___, (v ? "1" : "0"));
	}

	public void setTREE_STRUCTURE___(boolean v) {
		state.put(TREE_STRUCTURE___, (v ? "1" : "0"));
	}

	public void setLOGGING___(boolean v) {
		state.put(LOGGING___, (v ? "1" : "0"));
	}

	public void setCUT_NO_DEPARTMENT___(boolean v) {
		state.put(CUT_NO_DEPARTMENT___, (v ? "1" : "0"));
	}

	public void setCUT_NO_MANAGER___(boolean v) {
		state.put(CUT_NO_MANAGER___, (v ? "1" : "0"));
	}

	public void setGUI___(boolean v) {
		state.put(GUI___, (v ? "1" : "0"));
	}

	public void setPRECEDENCE___(boolean v) {
		state.put(PRECEDENCE___, (v ? "1" : "0"));
	}

	public void setTOTAL_WALKER___(boolean v) {
		state.put(TOTAL_WALKER___, (v ? "1" : "0"));
	}

	public void setTOTAL_REDUCER___(boolean v) {
		state.put(TOTAL_REDUCER___, (v ? "1" : "0"));
	}

	public void setACCESS_CONTROL___(boolean v) {
		state.put(ACCESS_CONTROL___, (v ? "1" : "0"));
	}

	public boolean isTREE_STRUCTURE___() {
		return notifyFeatureRead(TREE_STRUCTURE___).equals("1");
	}

	public boolean isLOGGING___() {

		return notifyFeatureRead(LOGGING___).equals("1");
	}

	public boolean isCUT_WHATEVER___() {
		return notifyFeatureRead(CUT_WHATEVER___).equals("1");
	}

	public boolean isCUT_NO_DEPARTMENT___() {
		return notifyFeatureRead(CUT_NO_DEPARTMENT___).equals("1");
	}

	public boolean isCUT_NO_MANAGER___() {
		return notifyFeatureRead(CUT_NO_MANAGER___).equals("1");
	}

	public boolean isGUI___() {
		return notifyFeatureRead(GUI___).equals("1");
	}

	public boolean isPRECEDENCE___() {
		return notifyFeatureRead(PRECEDENCE___).equals("1");
	}

	public boolean isTOTAL_WALKER___() {
		return notifyFeatureRead(TOTAL_WALKER___).equals("1");
	}

	public boolean isTOTAL_REDUCER___() {
		return notifyFeatureRead(TOTAL_REDUCER___).equals("1");
	}

	public boolean isACCESS_CONTROL___() {
		return notifyFeatureRead(ACCESS_CONTROL___).equals("1");
	}

	private String notifyFeatureRead(FeatureVar fvar) {
		String tmp = state.get(fvar);
		if (tmp == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
			//tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
			//state.put(fvar, tmp);
		}
		// System.out.println(fvar.getName() + " = " + state.get(fvar));//remove
		return tmp;
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "companies";
	}

}
