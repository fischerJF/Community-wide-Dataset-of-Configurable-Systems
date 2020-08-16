package splat;

import java.util.Map;

import entry.FeatureVar;

public class GPLVariables extends Variables {

	private static GPLVariables SINGLETON;

	public static GPLVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new GPLVariables();
		}
		return SINGLETON;
	}

	private FeatureVar BASE___, DIRECTED___, UNDIRECTED___, WEIGHTED___,
			SEARCH___, BFS___, NUMBER___, CONNECTED___, STRONGLYCONNECTED___,
			CYCLE___, MSTPRIM___, MSTKRUSKAL___, SHORTEST___;

	private GPLVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.DIRECTED___ = new FeatureVar("DIRECTED___");
		this.UNDIRECTED___ = new FeatureVar("UNDIRECTED___");
		this.WEIGHTED___ = new FeatureVar("WEIGHTED___");
		this.SEARCH___ = new FeatureVar("SEARCH___");
		this.BFS___ = new FeatureVar("BFS___");
		this.NUMBER___ = new FeatureVar("NUMBER___");
		this.CONNECTED___ = new FeatureVar("CONNECTED___");
		this.STRONGLYCONNECTED___ = new FeatureVar("STRONGLYCONNECTED___");
		this.CYCLE___ = new FeatureVar("CYCLE___");
		this.MSTPRIM___ = new FeatureVar("MSTPRIM___");
		this.MSTKRUSKAL___ = new FeatureVar("MSTKRUSKAL___");
		this.SHORTEST___ = new FeatureVar("SHORTEST___");
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
		state.put(DIRECTED___, "?");
		state.put(UNDIRECTED___, "?");
		state.put(WEIGHTED___, "?");
		state.put(SEARCH___, "?");
		state.put(BFS___, "?");
		state.put(NUMBER___, "?");
		state.put(CONNECTED___, "?");
		state.put(STRONGLYCONNECTED___, "?");
		state.put(CYCLE___, "?");
		state.put(MSTPRIM___, "?");
		state.put(MSTKRUSKAL___, "?");
		state.put(SHORTEST___, "?");
	}

	public Map<FeatureVar, String> getState() {
		return state;
	}

	private String notifyFeatureRead(FeatureVar fvar) {
		String value = state.get(fvar);
		if (value == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
			////value = SPLat.bt.choose(fvar, this) ? "1" : "0";		
		}
		return value;
	}

//	public void setBASE___(boolean v) {
//		state.put(BASE___, (v ? "1" : "0"));
//	}

	public boolean isWEIGHTED___() {
		return (notifyFeatureRead(WEIGHTED___).equals("1"));
	}

	public void setWEIGHTED___(boolean v) {
		state.put(WEIGHTED___, (v ? "1" : "0"));
	}

	public boolean isDIRECTED___() {
		return (notifyFeatureRead(DIRECTED___).equals("1"));
	}

	public void setDIRECTED___(boolean v) {
		state.put(DIRECTED___, (v ? "1" : "0"));
	}

	public boolean isUNDIRECTED___() {
		return (notifyFeatureRead(UNDIRECTED___).equals("1"));
	}

	public void setUNDIRECTED___(boolean v) {
		state.put(UNDIRECTED___, (v ? "1" : "0"));
	}

	public boolean isSEARCH___() {
		return (notifyFeatureRead(SEARCH___).equals("1"));
	}

	public void setSEARCH___(boolean v) {
		state.put(SEARCH___, (v ? "1" : "0"));
	}

	public boolean isBFS___() {
		return (notifyFeatureRead(BFS___).equals("1"));
	}

	public void setBFS___(boolean v) {
		state.put(BFS___, (v ? "1" : "0"));
	}

	public boolean isNUMBER___() {
		return (notifyFeatureRead(NUMBER___).equals("1"));
	}

	public void setNUMBER___(boolean v) {
		state.put(NUMBER___, (v ? "1" : "0"));
	}

	public boolean isCONNECTED___() {
		return (notifyFeatureRead(CONNECTED___).equals("1"));
	}

	public void setCONNECTED___(boolean v) {
		state.put(CONNECTED___, (v ? "1" : "0"));
	}

	public boolean isSTRONGLYCONNECTED___() {
		return (notifyFeatureRead(STRONGLYCONNECTED___).equals("1"));
	}

	public void setSTRONGLYCONNECTED___(boolean v) {
		state.put(STRONGLYCONNECTED___, (v ? "1" : "0"));
	}

	public boolean isCYCLE___() {
		return (notifyFeatureRead(CYCLE___).equals("1"));
	}

	public void setCYCLE___(boolean v) {
		state.put(CYCLE___, (v ? "1" : "0"));

	}

	public boolean isMSTPRIM___() {
		return (notifyFeatureRead(MSTPRIM___).equals("1"));
	}

	public void setMSTPRIM___(boolean v) {
		state.put(MSTPRIM___, (v ? "1" : "0"));
	}

	public boolean isMSTKRUSKAL___() {
		return (notifyFeatureRead(MSTKRUSKAL___).equals("1"));
	}

	public void setMSTKRUSKAL___(boolean v) {
		state.put(MSTKRUSKAL___, (v ? "1" : "0"));
	}

	public boolean isSHORTEST___() {
		return (notifyFeatureRead(SHORTEST___).equals("1"));
	}

	public void setSHORTEST___(boolean v) {
		state.put(SHORTEST___, (v ? "1" : "0"));
	}

	/******************/
	@Override
	public void restore() {
		state.clear();
		init();
	}

	@Override
	public String getSPLName() {
		return "gpl";
	}

}


