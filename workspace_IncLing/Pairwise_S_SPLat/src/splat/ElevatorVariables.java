package splat;

import java.util.Map;

import entry.FeatureVar;


public class ElevatorVariables extends Variables{

	private static ElevatorVariables SINGLETON;

	public static ElevatorVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new ElevatorVariables();
		}
		return SINGLETON;
	}
	
	private ElevatorVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.WEIGHT___ = new FeatureVar("WEIGHT___");
		this.EMPTY___ = new FeatureVar("EMPTY___");
		this.TWOTHIRDSFULL___ = new FeatureVar("TWOTHIRDSFULL___");
		this.EXECUTIVEFLOOR___ = new FeatureVar("EXECUTIVEFLOOR___");
		this.OVERLOADED___ = new FeatureVar("OVERLOADED___");
    restore();
    

	try {
		//guidsl = loadGUIDSL(this);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
	
  private void init() {
    state.put(BASE___, "1");
    state.put(WEIGHT___, "?");
    state.put(EMPTY___, "?");
    state.put(TWOTHIRDSFULL___, "?");
    state.put(EXECUTIVEFLOOR___, "?");
    state.put(OVERLOADED___, "?");
  }
  
	@Override
  public void restore() {
    state.clear();
    init();
  }
  
	public static int FLOORS = 100;

	private FeatureVar BASE___, WEIGHT___, EMPTY___, TWOTHIRDSFULL___, EXECUTIVEFLOOR___, OVERLOADED___;
  
  
  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
  //    tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }

	public boolean isBASE___() {
	  return notifyFeatureRead(BASE___).equals("1");
	}

	public boolean isWEIGHT___() {
	  return notifyFeatureRead(WEIGHT___).equals("1");
	}

	public boolean isEMPTY___() {
	  return notifyFeatureRead(EMPTY___).equals("1");
	}

	public boolean isTWOTHIRDSFULL___() {
	  return notifyFeatureRead(TWOTHIRDSFULL___).equals("1");
	}

	public boolean isEXECUTIVEFLOOR___() {
	  return notifyFeatureRead(EXECUTIVEFLOOR___).equals("1");
	}

	public boolean isOVERLOADED___() {
	  return notifyFeatureRead(OVERLOADED___).equals("1");
	}

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setWEIGHT___(boolean v) {
		state.put(WEIGHT___, (v ? "1" : "0"));
	}

	public void setEMPTY___(boolean v) {
		state.put(EMPTY___, (v ? "1" : "0"));
	}

	public void setTWOTHIRDSFULL___(boolean v) {
		state.put(TWOTHIRDSFULL___, (v ? "1" : "0"));
	}

	public void setEXECUTIVEFLOOR___(boolean v) {
		state.put(EXECUTIVEFLOOR___, (v ? "1" : "0"));
	}

	public void setOVERLOADED___(boolean v) {
		state.put(OVERLOADED___, (v ? "1" : "0"));
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "elevator";
	}

}
