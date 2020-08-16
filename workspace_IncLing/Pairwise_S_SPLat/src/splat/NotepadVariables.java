package splat;

import java.util.Map;

import entry.FeatureVar;



public class NotepadVariables extends Variables {

  private static NotepadVariables SINGLETON;

  public static NotepadVariables getSINGLETON() {
    if (SINGLETON == null) {
      SINGLETON = new NotepadVariables();
    }
    return SINGLETON;
  }

  private NotepadVariables() {
	  this.BASE___ = new FeatureVar("BASE___");
	  this.BASEMENUBAR___ = new FeatureVar("BASEMENUBAR___");
	  this.BASETOOLBAR___ = new FeatureVar("BASETOOLBAR___");
	  this.EDITMENUBAR___ = new FeatureVar("EDITMENUBAR___");
	  this.EDITTOOLBAR___ = new FeatureVar("EDITTOOLBAR___");
	  this.FORMATMENUBAR___ = new FeatureVar("FORMATMENUBAR___");
	  this.FORMATTOOLBAR___ = new FeatureVar("FORMATTOOLBAR___");
	  this.PERSISTENCEMENUBAR___ = new FeatureVar("PERSISTENCEMENUBAR___");
	  this.PERSISTENCETOOLBAR___ = new FeatureVar("PERSISTENCETOOLBAR___");
	  this.PRINTMENUBAR___ = new FeatureVar("PRINTMENUBAR___");
	  this.PRINTTOOLBAR___ = new FeatureVar("PRINTTOOLBAR___");
	  this.SEARCHMENUBAR___ = new FeatureVar("SEARCHMENUBAR___");
	  this.SEARCHTOOLBAR___ = new FeatureVar("SEARCHTOOLBAR___");
	  this.UNDOREDOMENUBAR___ = new FeatureVar("UNDOREDOMENUBAR___");
	  this.UNDOREDOTOOLBAR___ = new FeatureVar("UNDOREDOTOOLBAR___");
	  this.WORDCOUNTMENUBAR___ = new FeatureVar("WORDCOUNTMENUBAR___");
	  this.WORDCOUNTTOOLBAR___ = new FeatureVar("WORDCOUNTTOOLBAR___");
    restore();

	try {
	//	guidsl = loadGUIDSL(this);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  private void init(){
    state.put(BASE___, "1");
    state.put(BASEMENUBAR___, "?");
    state.put(BASETOOLBAR___, "?");
    state.put(EDITMENUBAR___, "?");
    state.put(EDITTOOLBAR___, "?");
    state.put(FORMATMENUBAR___, "?");
    state.put(FORMATTOOLBAR___, "?");
    state.put(PERSISTENCEMENUBAR___, "?");
    state.put(PERSISTENCETOOLBAR___, "?");
    state.put(PRINTMENUBAR___, "?");
    state.put(PRINTTOOLBAR___, "?");
    state.put(SEARCHMENUBAR___, "?");
    state.put(SEARCHTOOLBAR___, "?");
    state.put(UNDOREDOMENUBAR___, "?");
    state.put(UNDOREDOTOOLBAR___, "?");
    state.put(WORDCOUNTMENUBAR___, "?");
    state.put(WORDCOUNTTOOLBAR___, "?");
  }

  @Override
  public void restore() {
    state.clear();
    init();
  }

  private FeatureVar 
    BASE___,
    BASEMENUBAR___, 
    BASETOOLBAR___,
    EDITMENUBAR___, 
    EDITTOOLBAR___,
    FORMATMENUBAR___, 
    FORMATTOOLBAR___,
    PERSISTENCEMENUBAR___, 
    PERSISTENCETOOLBAR___,
    PRINTMENUBAR___, 
    PRINTTOOLBAR___,
    SEARCHMENUBAR___, 
    SEARCHTOOLBAR___,
    UNDOREDOMENUBAR___, 
    UNDOREDOTOOLBAR___,
    WORDCOUNTMENUBAR___, 
    WORDCOUNTTOOLBAR___;

  public void setBASE___(boolean v) {
    if (v) {
      state.put(BASE___, "1");
    } else {
      state.put(BASE___, "0");
    }
  }

  public boolean isBASE___() {
    return notifyFeatureRead(BASE___).equals("1");
  }

  public void setBASEMENUBAR___(boolean v) {
	  state.put(BASEMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isBASEMENUBAR___() {
    return notifyFeatureRead(BASEMENUBAR___).equals("1");
  }

  public void setBASETOOLBAR___(boolean v) {
	  state.put(BASETOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isBASETOOLBAR___() {
    return notifyFeatureRead(BASETOOLBAR___).equals("1");
  }

  public void setEDITMENUBAR___(boolean v) {
	  state.put(EDITMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isEDITMENUBAR___() {
    return notifyFeatureRead(EDITMENUBAR___).equals("1");
  }

  public void setEDITTOOLBAR___(boolean v) {
	  state.put(EDITTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isEDITTOOLBAR___() {
    return notifyFeatureRead(EDITTOOLBAR___).equals("1");
  }

  public void setFORMATMENUBAR___(boolean v) {
	  state.put(FORMATMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isFORMATMENUBAR___() {
    return notifyFeatureRead(FORMATMENUBAR___).equals("1");
  }

  public void setFORMATTOOLBAR___(boolean v) {
	  state.put(FORMATTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isFORMATTOOLBAR___() {
    return notifyFeatureRead(FORMATTOOLBAR___).equals("1");
  }

//  public void setPERSISTENCE___(boolean v) {
//    if (v) {
//      map.put(PERSISTENCE___, "1");
//    } else {
//      map.put(PERSISTENCE___, "0");
//    }
//  }

  public boolean isPERSISTENCE___() {
//    return get(PERSISTENCE___).equals("1");
    return isPERSISTENCEMENUBAR___() || isPERSISTENCETOOLBAR___();
  }

  public void setPERSISTENCEMENUBAR___(boolean v) {
	  state.put(PERSISTENCEMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isPERSISTENCEMENUBAR___() {
    return notifyFeatureRead(PERSISTENCEMENUBAR___).equals("1");
  }

  public void setPERSISTENCETOOLBAR___(boolean v) {
	  state.put(PERSISTENCETOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isPERSISTENCETOOLBAR___() {
    return notifyFeatureRead(PERSISTENCETOOLBAR___).equals("1");
  }

  public void setPRINTMENUBAR___(boolean v) {
	  state.put(PRINTMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isPRINTMENUBAR___() {
    return notifyFeatureRead(PRINTMENUBAR___).equals("1");
  }

  public void setPRINTTOOLBAR___(boolean v) {
	  state.put(PRINTTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isPRINTTOOLBAR___() {
    return notifyFeatureRead(PRINTTOOLBAR___).equals("1");
  }

  public void setSEARCHMENUBAR___(boolean v) {
	  state.put(SEARCHMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isSEARCHMENUBAR___() {
    return notifyFeatureRead(SEARCHMENUBAR___).equals("1");
  }

  public void setSEARCHTOOLBAR___(boolean v) {
	  state.put(SEARCHTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isSEARCHTOOLBAR___() {
    return notifyFeatureRead(SEARCHTOOLBAR___).equals("1");
  }

//  public void setUNDOREDO___(boolean v) {
//    if (v) {
//      map.put(UNDOREDO___, "1");
//    } else {
//      map.put(UNDOREDO___, "0");
//    }
//  }

  public boolean isUNDOREDO___() {
//    return get(UNDOREDO___).equals("1");
    return isUNDOREDOMENUBAR___() || isUNDOREDOTOOLBAR___();
  }

  public void setUNDOREDOMENUBAR___(boolean v) {
	  state.put(UNDOREDOMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isUNDOREDOMENUBAR___() {
    return notifyFeatureRead(UNDOREDOMENUBAR___).equals("1");
  }

  public void setUNDOREDOTOOLBAR___(boolean v) {
	  state.put(UNDOREDOTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isUNDOREDOTOOLBAR___() {
    return notifyFeatureRead(UNDOREDOTOOLBAR___).equals("1");
  }

  public void setWORDCOUNTMENUBAR___(boolean v) {
	  state.put(BASEMENUBAR___, (v ? "1" : "0"));
  }

  public boolean isWORDCOUNTMENUBAR___() {
    return notifyFeatureRead(WORDCOUNTMENUBAR___).equals("1");
  }

  public void setWORDCOUNTTOOLBAR___(boolean v) {
	  state.put(WORDCOUNTTOOLBAR___, (v ? "1" : "0"));
  }

  public boolean isWORDCOUNTTOOLBAR___() {
    return notifyFeatureRead(WORDCOUNTTOOLBAR___).equals("1");
  }

  private String notifyFeatureRead(FeatureVar fvar) {
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

	@Override
	public Map<FeatureVar, String> getState() {
		return state;
	}

	@Override
	public String getSPLName() {
		return "notepad";
	}

}
