package splat;

import java.util.Map;

import entry.FeatureVar;


public class MinePumpVariables extends Variables{

	private static MinePumpVariables SINGLETON;

	public static MinePumpVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new MinePumpVariables();
		}
		return SINGLETON;
	}
	
	private MinePumpVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.STARTCOMMAND___ = new FeatureVar("STARTCOMMAND___");
		this.STOPCOMMAND___ = new FeatureVar("STOPCOMMAND___");
		this.METHANEALARM___ = new FeatureVar("METHANEALARM___");
		this.METHANEQUERY___ = new FeatureVar("METHANEQUERY___");
		this.LOWWATERSENSOR___ = new FeatureVar("LOWWATERSENSOR___");
		this.HIGHWATERSENSOR___ = new FeatureVar("HIGHWATERSENSOR___");
	  restore();

		try {
			guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
	
	private FeatureVar 
    BASE___, 
  	STARTCOMMAND___,
  	STOPCOMMAND___,
  	METHANEALARM___,
  	METHANEQUERY___,
  	LOWWATERSENSOR___,
  	HIGHWATERSENSOR___;
	
	
  private void init() {
    state.put(BASE___, "1");
    state.put(STARTCOMMAND___, "?");
    state.put(STOPCOMMAND___, "?");
    state.put(METHANEALARM___, "?");
    state.put(METHANEQUERY___, "?");
    state.put(LOWWATERSENSOR___, "?");
    state.put(HIGHWATERSENSOR___, "?");
  }

  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
      //tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
      
      //System.out.println(fvar.getName() + " = " + state.get(fvar));// remove
    }
    return tmp;
  }
  
	public boolean isBASE___() {
	  return notifyFeatureRead(BASE___).equals("1");
	}

	public boolean isSTARTCOMMAND___() {
	  return notifyFeatureRead(STARTCOMMAND___).equals("1");
	}

	public boolean get_STOPCOMMAND___() {
	  return notifyFeatureRead(STOPCOMMAND___).equals("1");
	}

	public boolean isMETHANEALARM___() {
	  return notifyFeatureRead(METHANEALARM___).equals("1");
	}

	public boolean isMETHANEQUERY___() {
	  return notifyFeatureRead(METHANEQUERY___).equals("1");
	}

	public boolean isLOWWATERSENSOR___() {
	  return notifyFeatureRead(LOWWATERSENSOR___).equals("1");
	}

	public boolean isHIGHWATERSENSOR___() {
	  return notifyFeatureRead(HIGHWATERSENSOR___).equals("1");
	}

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setSTARTCOMMAND___(boolean v) {
		state.put(STARTCOMMAND___, (v ? "1" : "0"));
	}

	public void setSTOPCOMMAND___(boolean v) {
		state.put(STOPCOMMAND___, (v ? "1" : "0"));
	}

	public void setMETHANEALARM___(boolean v) {
		state.put(METHANEALARM___, (v ? "1" : "0"));
	}
	
	public void setMETHANEQUERY___(boolean v) {
		state.put(METHANEQUERY___, (v ? "1" : "0"));
	}

	public void setLOWWATERSENSOR___(boolean v) {
		state.put(LOWWATERSENSOR___, (v ? "1" : "0"));
	}

	public void setHIGHWATERSENSOR___(boolean v) {
		state.put(HIGHWATERSENSOR___, (v ? "1" : "0"));
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
		return "minepump";
	}
}