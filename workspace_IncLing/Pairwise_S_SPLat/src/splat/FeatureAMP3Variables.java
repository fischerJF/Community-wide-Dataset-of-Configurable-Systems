package splat;

import java.util.Map;

import entry.FeatureVar;

public class FeatureAMP3Variables extends Variables {

	private static FeatureAMP3Variables SINGLETON;

	public static FeatureAMP3Variables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new FeatureAMP3Variables();
		}
		return SINGLETON;
	}

	private FeatureAMP3Variables() {
		this.SKIPTRACK___ = new FeatureVar("SKIPTRACK___");
		this.VOLUMECONTROL___ = new FeatureVar("VOLUMECONTROL___");
		this.PLAYLISTCONTROL___ = new FeatureVar("PLAYLISTCONTROL___");
		this.REMOVETRACK___ = new FeatureVar("REMOVETRACK___");
		this.TIME___ = new FeatureVar("TIME___");
		this.WAV___ = new FeatureVar("WAV___");
		this.REORDERPLAYLIST___ = new FeatureVar("REORDERPLAYLIST___");
		this.MP3___ = new FeatureVar("MP3___");
		this.PLAYLIST___ = new FeatureVar("PLAYLIST___");
		this.LIGHT___ = new FeatureVar("LIGHT___");
		this.SAVEANDLOADPLAYLIST___ = new FeatureVar("SAVEANDLOADPLAYLIST___");
		this.CHANGELISTENER___ = new FeatureVar("CHANGELISTENER___");
		this.GUI___ = new FeatureVar("GUI___");
		this.FEATUREAMP___ = new FeatureVar("FEATUREAMP___");
		this.QUEUETRACK___ = new FeatureVar("QUEUETRACK___");
		this.FILESUPPORT___ = new FeatureVar("FILESUPPORT___");
		this.PLAYLISTCONTEXTMENU___ = new FeatureVar("PLAYLISTCONTEXTMENU___");
		this.MUTE___ = new FeatureVar("MUTE___");
		this.PROGRESSBAR___ = new FeatureVar("PROGRESSBAR___");
		this.TAGEDITOR___ = new FeatureVar("TAGEDITOR___");
		this.SHOWTIME___ = new FeatureVar("SHOWTIME___");
		this.AAC___ = new FeatureVar("AAC___");
		this.LOADFOLDER___ = new FeatureVar("LOADFOLDER___");
		this.MULTIPLEPLAYLISTS___ = new FeatureVar("MULTIPLEPLAYLISTS___");
		this.SHOWCOVER___ = new FeatureVar("SHOWCOVER___");
		this.PLAYLISTMENU___ = new FeatureVar("PLAYLISTMENU___");
		this.SHUFFLEREPEAT___ = new FeatureVar("SHUFFLEREPEAT___");
		this.BASE___ = new FeatureVar("BASE___");
		this.OGG___ = new FeatureVar("OGG___");
		this.PLAYLISTTABS___ = new FeatureVar("PLAYLISTTABS___");
		this.ADDPLAYLISTWRAPPER___ = new FeatureVar("ADDPLAYLISTWRAPPER___");
		this.SKINS___ = new FeatureVar("SKINS___");
		this.DARK___ = new FeatureVar("DARK___");
		this.CLEARPLAYLIST___ = new FeatureVar("CLEARPLAYLIST___");
		restore();

	}

	private void init() {
		state.put(SKIPTRACK___, "?");
		state.put(VOLUMECONTROL___, "?");
		state.put(PLAYLISTCONTROL___, "?");
		state.put(REMOVETRACK___, "?");
		state.put(TIME___, "?");
		state.put(WAV___, "?");
		state.put(REORDERPLAYLIST___, "?");
		state.put(MP3___, "?");
		state.put(PLAYLIST___, "?");
		state.put(LIGHT___, "?");
		state.put(SAVEANDLOADPLAYLIST___, "?");
		state.put(CHANGELISTENER___, "?");
		state.put(GUI___, "?");
		state.put(FEATUREAMP___, "?");
		state.put(QUEUETRACK___, "?");
		state.put(FILESUPPORT___, "?");
		state.put(PLAYLISTCONTEXTMENU___, "?");
		state.put(MUTE___, "?");
		state.put(PROGRESSBAR___, "?");
		state.put(TAGEDITOR___, "?");
		state.put(SHOWTIME___, "?");
		state.put(AAC___, "?");
		state.put(LOADFOLDER___, "?");
		state.put(MULTIPLEPLAYLISTS___, "?");
		state.put(SHOWCOVER___, "?");
		state.put(PLAYLISTMENU___, "?");
		state.put(SHUFFLEREPEAT___, "?");
		state.put(BASE___, "?");
		state.put(OGG___, "?");
		state.put(PLAYLISTTABS___, "?");
		state.put(ADDPLAYLISTWRAPPER___, "?");
		state.put(SKINS___, "?");
		state.put(DARK___, "?");
		state.put(CLEARPLAYLIST___, "?");
		;

	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar 
	SKIPTRACK___,
	VOLUMECONTROL___,
	PLAYLISTCONTROL___,
	REMOVETRACK___,
	TIME___,
	WAV___,
	REORDERPLAYLIST___,
	MP3___,
	PLAYLIST___,
	LIGHT___,
	SAVEANDLOADPLAYLIST___,
	CHANGELISTENER___,
	GUI___,
	FEATUREAMP___,
	QUEUETRACK___,
	FILESUPPORT___,
	PLAYLISTCONTEXTMENU___,
	MUTE___,
	PROGRESSBAR___,
	TAGEDITOR___,
	SHOWTIME___,
	AAC___,
	LOADFOLDER___,
	MULTIPLEPLAYLISTS___,
	SHOWCOVER___,
	PLAYLISTMENU___,
	SHUFFLEREPEAT___,
	BASE___,
	OGG___,
	PLAYLISTTABS___,
	ADDPLAYLISTWRAPPER___,
	SKINS___,
	DARK___,
	CLEARPLAYLIST___;


	// public boolean isDAILYLIMIT___() {
	// return get(VARS.DAILYLIMIT___).equals("1");
	// }

	public void setSKIPTRACK___ (boolean v) {
		state.put(SKIPTRACK___, (v ? "1" : "0"));
		}
		public void setVOLUMECONTROL___ (boolean v) {
		state.put(VOLUMECONTROL___, (v ? "1" : "0"));
		}
		public void setPLAYLISTCONTROL___ (boolean v) {
		state.put(PLAYLISTCONTROL___, (v ? "1" : "0"));
		}
		public void setREMOVETRACK___ (boolean v) {
		state.put(REMOVETRACK___, (v ? "1" : "0"));
		}
		public void setTIME___ (boolean v) {
		state.put(TIME___, (v ? "1" : "0"));
		}
		public void setWAV___ (boolean v) {
		state.put(WAV___, (v ? "1" : "0"));
		}
		public void setREORDERPLAYLIST___ (boolean v) {
		state.put(REORDERPLAYLIST___, (v ? "1" : "0"));
		}
		public void setMP3___ (boolean v) {
		state.put(MP3___, (v ? "1" : "0"));
		}
		public void setPLAYLIST___ (boolean v) {
		state.put(PLAYLIST___, (v ? "1" : "0"));
		}
		public void setLIGHT___ (boolean v) {
		state.put(LIGHT___, (v ? "1" : "0"));
		}
		public void setSAVEANDLOADPLAYLIST___ (boolean v) {
		state.put(SAVEANDLOADPLAYLIST___, (v ? "1" : "0"));
		}
		public void setCHANGELISTENER___ (boolean v) {
		state.put(CHANGELISTENER___, (v ? "1" : "0"));
		}
		public void setGUI___ (boolean v) {
		state.put(GUI___, (v ? "1" : "0"));
		}
		public void setFEATUREAMP___ (boolean v) {
		state.put(FEATUREAMP___, (v ? "1" : "0"));
		}
		public void setQUEUETRACK___ (boolean v) {
		state.put(QUEUETRACK___, (v ? "1" : "0"));
		}
		public void setFILESUPPORT___ (boolean v) {
		state.put(FILESUPPORT___, (v ? "1" : "0"));
		}
		public void setPLAYLISTCONTEXTMENU___ (boolean v) {
		state.put(PLAYLISTCONTEXTMENU___, (v ? "1" : "0"));
		}
		public void setMUTE___ (boolean v) {
		state.put(MUTE___, (v ? "1" : "0"));
		}
		public void setPROGRESSBAR___ (boolean v) {
		state.put(PROGRESSBAR___, (v ? "1" : "0"));
		}
		public void setTAGEDITOR___ (boolean v) {
		state.put(TAGEDITOR___, (v ? "1" : "0"));
		}
		public void setSHOWTIME___ (boolean v) {
		state.put(SHOWTIME___, (v ? "1" : "0"));
		}
		public void setAAC___ (boolean v) {
		state.put(AAC___, (v ? "1" : "0"));
		}
		public void setLOADFOLDER___ (boolean v) {
		state.put(LOADFOLDER___, (v ? "1" : "0"));
		}
		public void setMULTIPLEPLAYLISTS___ (boolean v) {
		state.put(MULTIPLEPLAYLISTS___, (v ? "1" : "0"));
		}
		public void setSHOWCOVER___ (boolean v) {
		state.put(SHOWCOVER___, (v ? "1" : "0"));
		}
		public void setPLAYLISTMENU___ (boolean v) {
		state.put(PLAYLISTMENU___, (v ? "1" : "0"));
		}
		public void setSHUFFLEREPEAT___ (boolean v) {
		state.put(SHUFFLEREPEAT___, (v ? "1" : "0"));
		}
		public void setBASE___ (boolean v) {
		state.put(BASE___, (v ? "1" : "0"));
		}
		public void setOGG___ (boolean v) {
		state.put(OGG___, (v ? "1" : "0"));
		}
		public void setPLAYLISTTABS___ (boolean v) {
		state.put(PLAYLISTTABS___, (v ? "1" : "0"));
		}
		public void setADDPLAYLISTWRAPPER___ (boolean v) {
		state.put(ADDPLAYLISTWRAPPER___, (v ? "1" : "0"));
		}
		public void setSKINS___ (boolean v) {
		state.put(SKINS___, (v ? "1" : "0"));
		}
		public void setDARK___ (boolean v) {
		state.put(DARK___, (v ? "1" : "0"));
		}
		public void setCLEARPLAYLIST___ (boolean v) {
		state.put(CLEARPLAYLIST___, (v ? "1" : "0"));
		}



		public boolean isSKIPTRACK___ () {
		return notifyFeatureRead(SKIPTRACK___).equals("1");
		}
		public boolean isVOLUMECONTROL___ () {
		return notifyFeatureRead(VOLUMECONTROL___).equals("1");
		}
		public boolean isPLAYLISTCONTROL___ () {
		return notifyFeatureRead(PLAYLISTCONTROL___).equals("1");
		}
		public boolean isREMOVETRACK___ () {
		return notifyFeatureRead(REMOVETRACK___).equals("1");
		}
		public boolean isTIME___ () {
		return notifyFeatureRead(TIME___).equals("1");
		}
		public boolean isWAV___ () {
		return notifyFeatureRead(WAV___).equals("1");
		}
		public boolean isREORDERPLAYLIST___ () {
		return notifyFeatureRead(REORDERPLAYLIST___).equals("1");
		}
		public boolean isMP3___ () {
		return notifyFeatureRead(MP3___).equals("1");
		}
		public boolean isPLAYLIST___ () {
		return notifyFeatureRead(PLAYLIST___).equals("1");
		}
		public boolean isLIGHT___ () {
		return notifyFeatureRead(LIGHT___).equals("1");
		}
		public boolean isSAVEANDLOADPLAYLIST___ () {
		return notifyFeatureRead(SAVEANDLOADPLAYLIST___).equals("1");
		}
		public boolean isCHANGELISTENER___ () {
		return notifyFeatureRead(CHANGELISTENER___).equals("1");
		}
		public boolean isGUI___ () {
		return notifyFeatureRead(GUI___).equals("1");
		}
		public boolean isFEATUREAMP___ () {
		return notifyFeatureRead(FEATUREAMP___).equals("1");
		}
		public boolean isQUEUETRACK___ () {
		return notifyFeatureRead(QUEUETRACK___).equals("1");
		}
		public boolean isFILESUPPORT___ () {
		return notifyFeatureRead(FILESUPPORT___).equals("1");
		}
		public boolean isPLAYLISTCONTEXTMENU___ () {
		return notifyFeatureRead(PLAYLISTCONTEXTMENU___).equals("1");
		}
		public boolean isMUTE___ () {
		return notifyFeatureRead(MUTE___).equals("1");
		}
		public boolean isPROGRESSBAR___ () {
		return notifyFeatureRead(PROGRESSBAR___).equals("1");
		}
		public boolean isTAGEDITOR___ () {
		return notifyFeatureRead(TAGEDITOR___).equals("1");
		}
		public boolean isSHOWTIME___ () {
		return notifyFeatureRead(SHOWTIME___).equals("1");
		}
		public boolean isAAC___ () {
		return notifyFeatureRead(AAC___).equals("1");
		}
		public boolean isLOADFOLDER___ () {
		return notifyFeatureRead(LOADFOLDER___).equals("1");
		}
		public boolean isMULTIPLEPLAYLISTS___ () {
		return notifyFeatureRead(MULTIPLEPLAYLISTS___).equals("1");
		}
		public boolean isSHOWCOVER___ () {
		return notifyFeatureRead(SHOWCOVER___).equals("1");
		}
		public boolean isPLAYLISTMENU___ () {
		return notifyFeatureRead(PLAYLISTMENU___).equals("1");
		}
		public boolean isSHUFFLEREPEAT___ () {
		return notifyFeatureRead(SHUFFLEREPEAT___).equals("1");
		}
		public boolean isBASE___ () {
		return notifyFeatureRead(BASE___).equals("1");
		}
		public boolean isOGG___ () {
		return notifyFeatureRead(OGG___).equals("1");
		}
		public boolean isPLAYLISTTABS___ () {
		return notifyFeatureRead(PLAYLISTTABS___).equals("1");
		}
		public boolean isADDPLAYLISTWRAPPER___ () {
		return notifyFeatureRead(ADDPLAYLISTWRAPPER___).equals("1");
		}
		public boolean isSKINS___ () {
		return notifyFeatureRead(SKINS___).equals("1");
		}
		public boolean isDARK___ () {
		return notifyFeatureRead(DARK___).equals("1");
		}
		public boolean isCLEARPLAYLIST___ () {
		return notifyFeatureRead(CLEARPLAYLIST___).equals("1");
		}


	private String notifyFeatureRead(FeatureVar fvar) {
		String tmp = state.get(fvar);
		if (tmp == "?") {
			/**
			 * only makes a choice if it is not already present in the map
			 */
			// tmp = SPLat.bt.choose(fvar, this) ? "1" : "0";
			// state.put(fvar, tmp);
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
