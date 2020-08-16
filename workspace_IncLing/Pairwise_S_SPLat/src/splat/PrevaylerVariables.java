package splat;

import java.util.Map;

import entry.FeatureVar;



public class PrevaylerVariables extends Variables{

	private static PrevaylerVariables SINGLETON;

	public static PrevaylerVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new PrevaylerVariables();
		}
		return SINGLETON;
	}
	
	private PrevaylerVariables() {
		this.USE_LOG4J_MONITOR___ = new FeatureVar("USE_LOG4J_MONITOR___");
		this.USE_NULL_MONITOR___ = new FeatureVar("USE_NULL_MONITOR___");
		this.USE_BROKEN_CLOCK___ = new FeatureVar("USE_BROKEN_CLOCK___");
		this.USE_PAUSABLE_CLOCK___ = new FeatureVar("USE_PAUSABLE_CLOCK___");
		this.USE_XSTREAM___ = new FeatureVar("USE_XSTREAM___");
	  	this.USE_TRANSIENT_MODE___ = new FeatureVar("USE_TRANSIENT_MODE___");
        this.USE_JOURNAL_DISK_SYNC___ = new FeatureVar("USE_JOURNAL_DISK_SYNC___");
		this.FILE_AGE_THREASHOLD___ = new FeatureVar("FILE_AGE_THREASHOLD___");
		this.FILE_SIZE_THREASHOLD___ = new FeatureVar("FILE_SIZE_THREASHOLD___");
		this.USE_XSTREAM_JOURNAL___ = new FeatureVar("USE_XSTREAM_JOURNAL___");
		this.USE_FILTERING___ = new FeatureVar("USE_FILTERING___");

	  
	  
	  
	  restore();

		try {
	//		guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }

	/******************/
  @Override
  public void restore() {
    state.clear();
    init();
  }

  private FeatureVar 
    USE_LOG4J_MONITOR___, 
    USE_NULL_MONITOR___, 
    USE_BROKEN_CLOCK___, 
    USE_PAUSABLE_CLOCK___,
    USE_XSTREAM___, 
    USE_TRANSIENT_MODE___,
    USE_JOURNAL_DISK_SYNC___,
    FILE_AGE_THREASHOLD___,
    FILE_SIZE_THREASHOLD___,
    USE_XSTREAM_JOURNAL___,
    USE_FILTERING___;
  
  
  
  private void init() {
    state.put(USE_LOG4J_MONITOR___, "?");
    state.put(USE_NULL_MONITOR___, "?");
    state.put(USE_BROKEN_CLOCK___, "?");
    state.put(USE_XSTREAM___, "?");
    state.put(USE_TRANSIENT_MODE___, "?");
    state.put(USE_JOURNAL_DISK_SYNC___, "?");
    state.put(FILE_AGE_THREASHOLD___, "?");
    state.put(FILE_SIZE_THREASHOLD___, "?");
    state.put(USE_XSTREAM_JOURNAL___, "?");
    state.put(USE_FILTERING___, "?");
  }
  
  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
   //   tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }

	public boolean isUSE_LOG4J_MONITOR___() {
	  return notifyFeatureRead(USE_LOG4J_MONITOR___).equals("1");
	}

	public boolean isUSE_NULL_MONITOR___() {
	  return notifyFeatureRead(USE_NULL_MONITOR___).equals("1");
	}

	public boolean isUSE_BROKEN_CLOCK___() {
	  return notifyFeatureRead(USE_BROKEN_CLOCK___).equals("1");
	}

	public boolean isUSE_PAUSABLE_CLOCK___() {
	  return notifyFeatureRead(USE_PAUSABLE_CLOCK___).equals("1");
	}

	public boolean isUSE_XSTREAM___() {
	  return notifyFeatureRead(USE_XSTREAM___).equals("1");
	}

	public void setUSE_TRANSIENT_MODE___(boolean v) {
		state.put(USE_TRANSIENT_MODE___, (v ? "1" : "0"));
	}

	public void setUSE_JOURNAL_DISK_SYNC___(boolean v) {
		state.put(USE_JOURNAL_DISK_SYNC___, (v ? "1" : "0"));
	}

	public void setFILE_AGE_THREASHOLD___(boolean v) {
		state.put(FILE_AGE_THREASHOLD___, (v ? "1" : "0"));
	}

	public void setFILE_SIZE_THREASHOLD___(boolean v) {
		state.put(FILE_SIZE_THREASHOLD___, (v ? "1" : "0"));
	}

	public void setUSE_XSTREAM_JOURNAL___(boolean v) {
		state.put(USE_XSTREAM_JOURNAL___, (v ? "1" : "0"));
	}
	public void setUSE_FILTERING___(boolean v) {
		state.put(USE_FILTERING___, (v ? "1" : "0"));
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "prevayler";
	}

}
