package splat;

import java.util.Map;

import entry.FeatureVar;


public class JTopasVariables extends Variables{

	private static JTopasVariables SINGLETON;

	public static JTopasVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new JTopasVariables();
		}
		return SINGLETON;
	}
	
	 private JTopasVariables() {
		 this.BASE___ = new FeatureVar("BASE___");
		 this.TOKENPOSONLY___ = new FeatureVar("TOKENPOSONLY___");
		 this.COUNTLINES___ = new FeatureVar("COUNTLINES___");
		 this.IMAGEPARTS___ = new FeatureVar("IMAGEPARTS___");
		 this.BLOCKCOMMENTS___ = new FeatureVar("BLOCKCOMMENTS___");
		 this.LINECOMMENTS___ = new FeatureVar("LINECOMMENTS___");
	   restore();

		try {
		//	guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }

	public static String INPUT_PIECE;
	public static int SMALL_LOOPS = 40;
	
	private void init() {
    state.put(BASE___, "1");
    state.put(TOKENPOSONLY___, "?");
    state.put(COUNTLINES___, "?");
    state.put(IMAGEPARTS___, "?");
    state.put(BLOCKCOMMENTS___, "?");
    state.put(LINECOMMENTS___, "?");
	}
	
	@Override
  public void restore() {
    state.clear();
    init();
  }
  
	private FeatureVar 
    BASE___, TOKENPOSONLY___, COUNTLINES___, IMAGEPARTS___, BLOCKCOMMENTS___, LINECOMMENTS___;
	

  public String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
    //  tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }
	
	public boolean isBASE___() {
	  return notifyFeatureRead(BASE___).equals("1") ? true : false;
	}

	public boolean isBLOCKCOMMENTS___() {
	  return notifyFeatureRead(BLOCKCOMMENTS___).equals("1") ? true : false;
	}

	public boolean isLINECOMMENTS___() {
	  return notifyFeatureRead(LINECOMMENTS___).equals("1") ? true : false;
	}

	public boolean isCOUNTLINES___() {
	  return notifyFeatureRead(COUNTLINES___).equals("1") ? true : false;
	}

	public boolean isIMAGEPARTS___() {
	  return notifyFeatureRead(IMAGEPARTS___).equals("1") ? true : false;
	}

	public boolean isTOKENPOSONLY___() {
	  return notifyFeatureRead(TOKENPOSONLY___).equals("1") ? true : false;
	}

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setTOKENPOSONLY___(boolean v) {
		state.put(TOKENPOSONLY___, (v ? "1" : "0"));
	}

	public void setCOUNTLINES___(boolean v) {
		state.put(COUNTLINES___, (v ? "1" : "0"));
	}

	public void setIMAGEPARTS___(boolean v) {
		state.put(IMAGEPARTS___, (v ? "1" : "0"));
	}

	public void setBLOCKCOMMENTS___(boolean v) {
		state.put(BLOCKCOMMENTS___, (v ? "1" : "0"));
	}

	public void setLINECOMMENTS___(boolean v) {
		state.put(LINECOMMENTS___, (v ? "1" : "0"));
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "jtopas";
	}

}
