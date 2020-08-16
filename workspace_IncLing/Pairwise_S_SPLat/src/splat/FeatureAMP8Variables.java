package splat;

import java.util.Map;

import entry.FeatureVar;

public class FeatureAMP8Variables extends Variables {

	private static FeatureAMP8Variables SINGLETON;

	public static FeatureAMP8Variables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new FeatureAMP8Variables();
		}
		return SINGLETON;
	}

	private FeatureAMP8Variables() {
		this.VOLUMECONTROL___ = new FeatureVar("VOLUMECONTROL___");
		this.SKIPTRACK___ = new FeatureVar("SKIPTRACK___");
		this.PLAYENGINE___ = new FeatureVar("PLAYENGINE___");
		this.REMOVETRACK___ = new FeatureVar("REMOVETRACK___");
		this.WAV___ = new FeatureVar("WAV___");
		this.REORDERPLAYLIST___ = new FeatureVar("REORDERPLAYLIST___");
		this.PLAYLIST___ = new FeatureVar("PLAYLIST___");
		this.CONTROL___ = new FeatureVar("CONTROL___");
		this.LIGHT___ = new FeatureVar("LIGHT___");
		this.SAVEANDLOADPLAYLIST___ = new FeatureVar("SAVEANDLOADPLAYLIST___");
		this.GUI___ = new FeatureVar("GUI___");
		this.FEATUREAMP___ = new FeatureVar("FEATUREAMP___");
		this.FILESUPPORT___ = new FeatureVar("FILESUPPORT___");
		this.QUEUETRACK___ = new FeatureVar("QUEUETRACK___");
		this.PROGRESSBAR___ = new FeatureVar("PROGRESSBAR___");
		this.MUTE___ = new FeatureVar("MUTE___");
		this.SHOWTIME___ = new FeatureVar("SHOWTIME___");
		this.LOADFOLDER___ = new FeatureVar("LOADFOLDER___");
		this.TRACKTIME___ = new FeatureVar("TRACKTIME___");
		this.SHUFFLEREPEAT___ = new FeatureVar("SHUFFLEREPEAT___");
		this.OGG___ = new FeatureVar("OGG___");
		this.MP3___ = new FeatureVar("MP3___");
		this.SKINS___ = new FeatureVar("SKINS___");
		this.DARK___ = new FeatureVar("DARK___");
		this.CHOOSEFILE___ = new FeatureVar("CHOOSEFILE___");
		this.CLEARPLAYLIST___ = new FeatureVar("CLEARPLAYLIST___");
		this.SHOWCOVER___ = new FeatureVar("SHOWCOVER___");

		restore();

	}

	private void init() {
		state.put(VOLUMECONTROL___, "?");
		state.put(SKIPTRACK___, "?");
		state.put(PLAYENGINE___, "?");
		state.put(REMOVETRACK___, "?");
		state.put(WAV___, "?");
		state.put(REORDERPLAYLIST___, "?");
		state.put(PLAYLIST___, "?");
		state.put(CONTROL___, "?");
		state.put(LIGHT___, "?");
		state.put(SAVEANDLOADPLAYLIST___, "?");
		state.put(GUI___, "?");
		state.put(FEATUREAMP___, "?");
		state.put(FILESUPPORT___, "?");
		state.put(QUEUETRACK___, "?");
		state.put(PROGRESSBAR___, "?");
		state.put(MUTE___, "?");
		state.put(SHOWTIME___, "?");
		state.put(LOADFOLDER___, "?");
		state.put(TRACKTIME___, "?");
		state.put(SHUFFLEREPEAT___, "?");
		state.put(OGG___, "?");
		state.put(MP3___, "?");
		state.put(SKINS___, "?");
		state.put(DARK___, "?");
		state.put(CHOOSEFILE___, "?");
		state.put(CLEARPLAYLIST___, "?");
		state.put(SHOWCOVER___, "?");		

	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar 
	VOLUMECONTROL___,
	SKIPTRACK___,
	PLAYENGINE___,
	REMOVETRACK___,
	WAV___,
	REORDERPLAYLIST___,
	PLAYLIST___,
	CONTROL___,
	LIGHT___,
	SAVEANDLOADPLAYLIST___,
	GUI___,
	FEATUREAMP___,
	FILESUPPORT___,
	QUEUETRACK___,
	PROGRESSBAR___,
	MUTE___,
	SHOWTIME___,
	LOADFOLDER___,
	TRACKTIME___,
	SHUFFLEREPEAT___,
	OGG___,
	MP3___,
	SKINS___,
	DARK___,
	CHOOSEFILE___,
	CLEARPLAYLIST___,
	SHOWCOVER___;


	public void setVOLUMECONTROL___ (boolean v) {
		state.put(VOLUMECONTROL___, (v ? "1" : "0"));
		}
		public void setSKIPTRACK___ (boolean v) {
		state.put(SKIPTRACK___, (v ? "1" : "0"));
		}
		public void setPLAYENGINE___ (boolean v) {
		state.put(PLAYENGINE___, (v ? "1" : "0"));
		}
		public void setREMOVETRACK___ (boolean v) {
		state.put(REMOVETRACK___, (v ? "1" : "0"));
		}
		public void setWAV___ (boolean v) {
		state.put(WAV___, (v ? "1" : "0"));
		}
		public void setREORDERPLAYLIST___ (boolean v) {
		state.put(REORDERPLAYLIST___, (v ? "1" : "0"));
		}
		public void setPLAYLIST___ (boolean v) {
		state.put(PLAYLIST___, (v ? "1" : "0"));
		}
		public void setCONTROL___ (boolean v) {
		state.put(CONTROL___, (v ? "1" : "0"));
		}
		public void setLIGHT___ (boolean v) {
		state.put(LIGHT___, (v ? "1" : "0"));
		}
		public void setSAVEANDLOADPLAYLIST___ (boolean v) {
		state.put(SAVEANDLOADPLAYLIST___, (v ? "1" : "0"));
		}
		public void setGUI___ (boolean v) {
		state.put(GUI___, (v ? "1" : "0"));
		}
		public void setFEATUREAMP___ (boolean v) {
		state.put(FEATUREAMP___, (v ? "1" : "0"));
		}
		public void setFILESUPPORT___ (boolean v) {
		state.put(FILESUPPORT___, (v ? "1" : "0"));
		}
		public void setQUEUETRACK___ (boolean v) {
		state.put(QUEUETRACK___, (v ? "1" : "0"));
		}
		public void setPROGRESSBAR___ (boolean v) {
		state.put(PROGRESSBAR___, (v ? "1" : "0"));
		}
		public void setMUTE___ (boolean v) {
		state.put(MUTE___, (v ? "1" : "0"));
		}
		public void setSHOWTIME___ (boolean v) {
		state.put(SHOWTIME___, (v ? "1" : "0"));
		}
		public void setLOADFOLDER___ (boolean v) {
		state.put(LOADFOLDER___, (v ? "1" : "0"));
		}
		public void setTRACKTIME___ (boolean v) {
		state.put(TRACKTIME___, (v ? "1" : "0"));
		}
		public void setSHUFFLEREPEAT___ (boolean v) {
		state.put(SHUFFLEREPEAT___, (v ? "1" : "0"));
		}
		public void setOGG___ (boolean v) {
		state.put(OGG___, (v ? "1" : "0"));
		}
		public void setMP3___ (boolean v) {
		state.put(MP3___, (v ? "1" : "0"));
		}
		public void setSKINS___ (boolean v) {
		state.put(SKINS___, (v ? "1" : "0"));
		}
		public void setDARK___ (boolean v) {
		state.put(DARK___, (v ? "1" : "0"));
		}
		public void setCHOOSEFILE___ (boolean v) {
		state.put(CHOOSEFILE___, (v ? "1" : "0"));
		}
		public void setCLEARPLAYLIST___ (boolean v) {
		state.put(CLEARPLAYLIST___, (v ? "1" : "0"));
		}
		public void setSHOWCOVER___ (boolean v) {
		state.put(SHOWCOVER___, (v ? "1" : "0"));
		}



		public boolean isVOLUMECONTROL___ () {
		return notifyFeatureRead(VOLUMECONTROL___).equals("1");
		}
		public boolean isSKIPTRACK___ () {
		return notifyFeatureRead(SKIPTRACK___).equals("1");
		}
		public boolean isPLAYENGINE___ () {
		return notifyFeatureRead(PLAYENGINE___).equals("1");
		}
		public boolean isREMOVETRACK___ () {
		return notifyFeatureRead(REMOVETRACK___).equals("1");
		}
		public boolean isWAV___ () {
		return notifyFeatureRead(WAV___).equals("1");
		}
		public boolean isREORDERPLAYLIST___ () {
		return notifyFeatureRead(REORDERPLAYLIST___).equals("1");
		}
		public boolean isPLAYLIST___ () {
		return notifyFeatureRead(PLAYLIST___).equals("1");
		}
		public boolean isCONTROL___ () {
		return notifyFeatureRead(CONTROL___).equals("1");
		}
		public boolean isLIGHT___ () {
		return notifyFeatureRead(LIGHT___).equals("1");
		}
		public boolean isSAVEANDLOADPLAYLIST___ () {
		return notifyFeatureRead(SAVEANDLOADPLAYLIST___).equals("1");
		}
		public boolean isGUI___ () {
		return notifyFeatureRead(GUI___).equals("1");
		}
		public boolean isFEATUREAMP___ () {
		return notifyFeatureRead(FEATUREAMP___).equals("1");
		}
		public boolean isFILESUPPORT___ () {
		return notifyFeatureRead(FILESUPPORT___).equals("1");
		}
		public boolean isQUEUETRACK___ () {
		return notifyFeatureRead(QUEUETRACK___).equals("1");
		}
		public boolean isPROGRESSBAR___ () {
		return notifyFeatureRead(PROGRESSBAR___).equals("1");
		}
		public boolean isMUTE___ () {
		return notifyFeatureRead(MUTE___).equals("1");
		}
		public boolean isSHOWTIME___ () {
		return notifyFeatureRead(SHOWTIME___).equals("1");
		}
		public boolean isLOADFOLDER___ () {
		return notifyFeatureRead(LOADFOLDER___).equals("1");
		}
		public boolean isTRACKTIME___ () {
		return notifyFeatureRead(TRACKTIME___).equals("1");
		}
		public boolean isSHUFFLEREPEAT___ () {
		return notifyFeatureRead(SHUFFLEREPEAT___).equals("1");
		}
		public boolean isOGG___ () {
		return notifyFeatureRead(OGG___).equals("1");
		}
		public boolean isMP3___ () {
		return notifyFeatureRead(MP3___).equals("1");
		}
		public boolean isSKINS___ () {
		return notifyFeatureRead(SKINS___).equals("1");
		}
		public boolean isDARK___ () {
		return notifyFeatureRead(DARK___).equals("1");
		}
		public boolean isCHOOSEFILE___ () {
		return notifyFeatureRead(CHOOSEFILE___).equals("1");
		}
		public boolean isCLEARPLAYLIST___ () {
		return notifyFeatureRead(CLEARPLAYLIST___).equals("1");
		}
		public boolean isSHOWCOVER___ () {
		return notifyFeatureRead(SHOWCOVER___).equals("1");
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
