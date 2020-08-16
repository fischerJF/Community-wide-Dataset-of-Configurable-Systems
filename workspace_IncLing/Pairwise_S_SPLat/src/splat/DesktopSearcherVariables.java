package splat;

import java.util.Map;

import entry.FeatureVar;

public class DesktopSearcherVariables extends Variables {

  private static DesktopSearcherVariables SINGLETON;

  public static DesktopSearcherVariables getSINGLETON() {
    if (SINGLETON == null) {
      SINGLETON = new DesktopSearcherVariables();
    }
    return SINGLETON;
  }
  
  private FeatureVar BASE___, HTML___, TXT___, LATEX___, USER_INTERFACE___, COMMAND_LINE___,
	GUI___, GUI_PREFERENCES___, QUERY_HISTORY___, INDEX_HISTORY___,
	SINGLE_DIRECTORY___, MULTI_DIRECTORY___, NORMAL_VIEW___, TREE_VIEW___, WINDOWS___,
	LINUX___;

	private DesktopSearcherVariables() {
		this.BASE___ = new FeatureVar("BASE___");
		this.HTML___ = new FeatureVar("HTML___");
		this.TXT___ = new FeatureVar("TXT___");
		this.LATEX___ = new FeatureVar("LATEX___");
		this.USER_INTERFACE___ = new FeatureVar("USER_INTERFACE___");
		this.COMMAND_LINE___ = new FeatureVar("COMMAND_LINE___");
		this.GUI___ = new FeatureVar("GUI___");
		this.GUI_PREFERENCES___ = new FeatureVar("GUI_PREFERENCES___");
		this.QUERY_HISTORY___ = new FeatureVar("QUERY_HISTORY___");
		this.INDEX_HISTORY___ = new FeatureVar("INDEX_HISTORY___");
		this.SINGLE_DIRECTORY___ = new FeatureVar("SINGLE_DIRECTORY___");
		this.MULTI_DIRECTORY___ = new FeatureVar("MULTI_DIRECTORY___");
		this.NORMAL_VIEW___ = new FeatureVar("NORMAL_VIEW___");
		this.TREE_VIEW___ = new FeatureVar("TREE_VIEW___");
		this.WINDOWS___ = new FeatureVar("WINDOWS___");
		this.LINUX___ = new FeatureVar("LINUX___");
		restore();
		

		try {
		//	guidsl = loadGUIDSL(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

  /**
   * Defines default values for the feature variables.
   */
  private void init() {
    state.put(BASE___, "1");
    state.put(HTML___, "?");
    state.put(TXT___, "?");
    state.put(LATEX___, "?");
    state.put(USER_INTERFACE___, "?");
    state.put(COMMAND_LINE___, "?");
    state.put(GUI___, "?");
    state.put(GUI_PREFERENCES___, "?");
    state.put(QUERY_HISTORY___, "?");
    state.put(INDEX_HISTORY___, "?");
    state.put(SINGLE_DIRECTORY___, "?");
    state.put(MULTI_DIRECTORY___, "?");
    state.put(NORMAL_VIEW___, "?");
    state.put(TREE_VIEW___, "?");
    state.put(WINDOWS___, "?");
    state.put(LINUX___, "?");
  }

  private String notifyFeatureRead(FeatureVar fvar) {
    String tmp = state.get(fvar);
    if (tmp == "?") {
      /**
       * only makes a choice if it is not already present in the map
       */
   //   tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
     // state.put(fvar, tmp);
    }
    // System.out.println(fvar + " = " + map.get(fvar));//remove
    return tmp;
  }

  public boolean isBASE___() {
    return (notifyFeatureRead(BASE___).equals("1"));
  }

  public boolean isCOMMAND_LINE___() {
    return (notifyFeatureRead(COMMAND_LINE___).equals("1"));
  }

  public boolean isGUI___() {
    return (notifyFeatureRead(GUI___).equals("1"));
  }

  public boolean isGUI_PREFERENCES___() {
    return (notifyFeatureRead(GUI_PREFERENCES___).equals("1"));
  }

  public boolean isHTML___() {
    return (notifyFeatureRead(HTML___).equals("1"));
  }

  public boolean isINDEX_HISTORY___() {
    return (notifyFeatureRead(INDEX_HISTORY___).equals("1"));
  }

  public boolean isLATEX___() {
    return (notifyFeatureRead(LATEX___).equals("1"));
  }

  public boolean isLINUX___() {
    return (notifyFeatureRead(LINUX___).equals("1"));
  }

  public boolean isMULTI_DIRECTORY___() {
    return (notifyFeatureRead(MULTI_DIRECTORY___).equals("1"));
  }

  public boolean isNORMAL_VIEW___() {
    return (notifyFeatureRead(NORMAL_VIEW___).equals("1"));
  }

  public boolean isQUERY_HISTORY___() {
    return (notifyFeatureRead(QUERY_HISTORY___).equals("1"));
  }

  public boolean isSINGLE_DIRECTORY___() {
    return (notifyFeatureRead(SINGLE_DIRECTORY___).equals("1"));
  }

  public boolean isTREE_VIEW___() {
    return (notifyFeatureRead(TREE_VIEW___).equals("1"));
  }

  public boolean isTXT___() {
    return (notifyFeatureRead(TXT___).equals("1"));
  }

  public boolean isUSER_INTERFACE___() {
    return (notifyFeatureRead(USER_INTERFACE___).equals("1"));
  }

  public boolean isWINDOWS___() {
    return (notifyFeatureRead(WINDOWS___).equals("1"));
  }

  public void setCOMMAND_LINE___(boolean v) {
    state.put(COMMAND_LINE___, (v ? "1" : "0"));
  }

  public void setGUI___(boolean v) {
    state.put(GUI___, (v ? "1" : "0"));
  }

  public void setGUI_PREFERENCES___(boolean v) {
    state.put(GUI_PREFERENCES___, (v ? "1" : "0"));
  }

  public void setHTML___(boolean v) {
    state.put(HTML___, (v ? "1" : "0"));
  }

  public void setINDEX_HISTORY___(boolean v) {
    state.put(INDEX_HISTORY___, (v ? "1" : "0"));
  }

  public void setLATEX___(boolean v) {
    state.put(LATEX___, (v ? "1" : "0"));
  }

  public void setLINUX___(boolean v) {
    state.put(LINUX___, (v ? "1" : "0"));
  }

  public void setMULTI_DIRECTORY___(boolean v) {
    state.put(MULTI_DIRECTORY___, (v ? "1" : "0"));
  }

  public void setNORMAL_VIEW___(boolean v) {
    state.put(NORMAL_VIEW___, (v ? "1" : "0"));
  }

  public void setQUERY_HISTORY___(boolean v) {
    state.put(QUERY_HISTORY___, (v ? "1" : "0"));
  }

  public void setSINGLE_DIRECTORY___(boolean v) {
    state.put(SINGLE_DIRECTORY___, (v ? "1" : "0"));
  }

  public void setTREE_VIEW___(boolean v) {
    state.put(TREE_VIEW___, (v ? "1" : "0"));
  }

  public void setTXT___(boolean v) {
    state.put(TXT___, (v ? "1" : "0"));
  }

  public void setUSER_INTERFACE___(boolean v) {
    state.put(USER_INTERFACE___, (v ? "1" : "0"));
  }

  public void setWINDOWS___(boolean v) {
    state.put(WINDOWS___, (v ? "1" : "0"));
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
		return "desktopsearcher";
	}

}
