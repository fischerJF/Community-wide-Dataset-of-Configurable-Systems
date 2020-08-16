package splat;

import java.util.Map;

import entry.FeatureVar;


public class EmailVariables extends Variables{

	private static EmailVariables SINGLETON;

	public static EmailVariables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new EmailVariables();
		}
		return SINGLETON;
	}

	private EmailVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.KEYS___ = new FeatureVar("KEYS___");
		this.ENCRYPT___ = new FeatureVar("ENCRYPT___");
		this.AUTORESPONDER___ = new FeatureVar("AUTORESPONDER___");
		this.ADDRESSBOOK___ = new FeatureVar("ADDRESSBOOK___");
		this.SIGN___ = new FeatureVar("SIGN___");
		this.FORWARD___ = new FeatureVar("FORWARD___");
		this.VERIFY___ = new FeatureVar("VERIFY___");
		this.DECRYPT___ = new FeatureVar("DECRYPT___");
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
    state.put(KEYS___, "?");
    state.put(ENCRYPT___, "?");
    state.put(AUTORESPONDER___, "?");
    state.put(ADDRESSBOOK___, "?");
    state.put(SIGN___, "?");
    state.put(FORWARD___, "?");
    state.put(VERIFY___, "?");
    state.put(DECRYPT___, "?");
  }
	
	@Override
  public void restore() {
    state.clear();
    init();
  }
  
	private FeatureVar BASE___, KEYS___, ENCRYPT___, AUTORESPONDER___, ADDRESSBOOK___, SIGN___, FORWARD___, VERIFY___, DECRYPT___;
	
  
  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
      //tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
      //state.put(fvar, tmp);
    }
    return tmp;
  }

	public boolean isBASE___() {
	  return notifyFeatureRead(BASE___).equals("1");
	}

	public boolean isKEYS___() {
	  return notifyFeatureRead(KEYS___).equals("1");
	}

	public boolean isENCRYPT___() {
	  return notifyFeatureRead(ENCRYPT___).equals("1");
	}

	public boolean isAUTORESPONDER___() {
	  return notifyFeatureRead(AUTORESPONDER___).equals("1");
	}

	public boolean isADDRESSBOOK___() {
	  return notifyFeatureRead(ADDRESSBOOK___).equals("1");
	}

	public boolean isSIGN___() {
	  return notifyFeatureRead(SIGN___).equals("1");
	}

	public boolean isFORWARD___() {
	  return notifyFeatureRead(FORWARD___).equals("1");
	}

	public boolean isVERIFY___() {
	  return notifyFeatureRead(VERIFY___).equals("1");
	}

	public boolean isDECRYPT___() {
	  return notifyFeatureRead(DECRYPT___).equals("1");
	}

	public void setBASE___(boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
	}

	public void setKEYS___(boolean v) {
		state.put(KEYS___, (v ? "1" : "0"));
	}

	public void setENCRYPT___(boolean v) {
		state.put(ENCRYPT___, (v ? "1" : "0"));
	}

	public void setAUTORESPONDER___(boolean v) {
		state.put(AUTORESPONDER___, (v ? "1" : "0"));
	}

	public void setADDRESSBOOK___(boolean v) {
		state.put(ADDRESSBOOK___, (v ? "1" : "0"));
	}

	public void setSIGN___(boolean v) {
		state.put(SIGN___, (v ? "1" : "0"));
	}

	public void setFORWARD___(boolean v) {
		state.put(FORWARD___, (v ? "1" : "0"));
	}

	public void setVERIFY___(boolean v) {
		state.put(VERIFY___, (v ? "1" : "0"));
	}

	public void setDECRYPT___(boolean v) {
		state.put(DECRYPT___, (v ? "1" : "0"));
	}

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "email";
	}
}
