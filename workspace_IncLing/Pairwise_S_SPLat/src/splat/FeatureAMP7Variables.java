package splat;

import java.util.Map;

import entry.FeatureVar;

public class FeatureAMP7Variables extends Variables {

	private static FeatureAMP7Variables SINGLETON;

	public static FeatureAMP7Variables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new FeatureAMP7Variables();
		}
		return SINGLETON;
	}

	private FeatureAMP7Variables() {
		this.OPENWAVFILE___ = new FeatureVar("OPENWAVFILE___");
		this.VOLUMECONTROL___ = new FeatureVar("VOLUMECONTROL___");
		this.SKIPTRACK___ = new FeatureVar("SKIPTRACK___");
		this.MP3PLAYER___ = new FeatureVar("MP3PLAYER___");
		this.REMOVETRACK___ = new FeatureVar("REMOVETRACK___");
		this.TIME___ = new FeatureVar("TIME___");
		this.CHANGEPLAYLIST___ = new FeatureVar("CHANGEPLAYLIST___");
		this.OPENMP3FILE___ = new FeatureVar("OPENMP3FILE___");
		this.REORDERPLAYLIST___ = new FeatureVar("REORDERPLAYLIST___");
		this.PLAYLIST___ = new FeatureVar("PLAYLIST___");
		this.LIGHT___ = new FeatureVar("LIGHT___");
		this.SAVEANDLOADPLAYLIST___ = new FeatureVar("SAVEANDLOADPLAYLIST___");
		this.GUI___ = new FeatureVar("GUI___");
		this.AUDIOFORMATS___ = new FeatureVar("AUDIOFORMATS___");
		this.FEATUREAMP___ = new FeatureVar("FEATUREAMP___");
		this.QUEUETRACK___ = new FeatureVar("QUEUETRACK___");
		this.MUTE___ = new FeatureVar("MUTE___");
		this.PROGRESSBAR___ = new FeatureVar("PROGRESSBAR___");
		this.SHOWTIME___ = new FeatureVar("SHOWTIME___");
		this.SHOWTITLE___ = new FeatureVar("SHOWTITLE___");
		this.WAVPLAYER___ = new FeatureVar("WAVPLAYER___");
		this.LOADFOLDER___ = new FeatureVar("LOADFOLDER___");
		this.SHOWCOVER___ = new FeatureVar("SHOWCOVER___");
		this.SHUFFLEREPEAT___ = new FeatureVar("SHUFFLEREPEAT___");
		this.SKINS___ = new FeatureVar("SKINS___");
		this.ORANGEBLUEST___ = new FeatureVar("ORANGEBLUEST___");
		this.DARK___ = new FeatureVar("DARK___");
		this.OPENFILE___ = new FeatureVar("OPENFILE___");
		this.CLEARPLAYLIST___ = new FeatureVar("CLEARPLAYLIST___");
		restore();

	}

	private void init() {
		state.put(OPENWAVFILE___, "?");
		state.put(VOLUMECONTROL___, "?");
		state.put(SKIPTRACK___, "?");
		state.put(MP3PLAYER___, "?");
		state.put(REMOVETRACK___, "?");
		state.put(TIME___, "?");
		state.put(CHANGEPLAYLIST___, "?");
		state.put(OPENMP3FILE___, "?");
		state.put(REORDERPLAYLIST___, "?");
		state.put(PLAYLIST___, "?");
		state.put(LIGHT___, "?");
		state.put(SAVEANDLOADPLAYLIST___, "?");
		state.put(GUI___, "?");
		state.put(AUDIOFORMATS___, "?");
		state.put(FEATUREAMP___, "?");
		state.put(QUEUETRACK___, "?");
		state.put(MUTE___, "?");
		state.put(PROGRESSBAR___, "?");
		state.put(SHOWTIME___, "?");
		state.put(SHOWTITLE___, "?");
		state.put(WAVPLAYER___, "?");
		state.put(LOADFOLDER___, "?");
		state.put(SHOWCOVER___, "?");
		state.put(SHUFFLEREPEAT___, "?");
		state.put(SKINS___, "?");
		state.put(ORANGEBLUEST___, "?");
		state.put(DARK___, "?");
		state.put(OPENFILE___, "?");
		state.put(CLEARPLAYLIST___, "?");
		

	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar 
	OPENWAVFILE___,
	VOLUMECONTROL___,
	SKIPTRACK___,
	MP3PLAYER___,
	REMOVETRACK___,
	TIME___,
	CHANGEPLAYLIST___,
	OPENMP3FILE___,
	REORDERPLAYLIST___,
	PLAYLIST___,
	LIGHT___,
	SAVEANDLOADPLAYLIST___,
	GUI___,
	AUDIOFORMATS___,
	FEATUREAMP___,
	QUEUETRACK___,
	MUTE___,
	PROGRESSBAR___,
	SHOWTIME___,
	SHOWTITLE___,
	WAVPLAYER___,
	LOADFOLDER___,
	SHOWCOVER___,
	SHUFFLEREPEAT___,
	SKINS___,
	ORANGEBLUEST___,
	DARK___,
	OPENFILE___,
	CLEARPLAYLIST___;


	// public boolean isDAILYLIMIT___() {
	// return get(VARS.DAILYLIMIT___).equals("1");
	// }

	public void setOPENWAVFILE___ (boolean v) {
		state.put(OPENWAVFILE___, (v ? "1" : "0"));
		}
		public void setVOLUMECONTROL___ (boolean v) {
		state.put(VOLUMECONTROL___, (v ? "1" : "0"));
		}
		public void setSKIPTRACK___ (boolean v) {
		state.put(SKIPTRACK___, (v ? "1" : "0"));
		}
		public void setMP3PLAYER___ (boolean v) {
		state.put(MP3PLAYER___, (v ? "1" : "0"));
		}
		public void setREMOVETRACK___ (boolean v) {
		state.put(REMOVETRACK___, (v ? "1" : "0"));
		}
		public void setTIME___ (boolean v) {
		state.put(TIME___, (v ? "1" : "0"));
		}
		public void setCHANGEPLAYLIST___ (boolean v) {
		state.put(CHANGEPLAYLIST___, (v ? "1" : "0"));
		}
		public void setOPENMP3FILE___ (boolean v) {
		state.put(OPENMP3FILE___, (v ? "1" : "0"));
		}
		public void setREORDERPLAYLIST___ (boolean v) {
		state.put(REORDERPLAYLIST___, (v ? "1" : "0"));
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
		public void setGUI___ (boolean v) {
		state.put(GUI___, (v ? "1" : "0"));
		}
		public void setAUDIOFORMATS___ (boolean v) {
		state.put(AUDIOFORMATS___, (v ? "1" : "0"));
		}
		public void setFEATUREAMP___ (boolean v) {
		state.put(FEATUREAMP___, (v ? "1" : "0"));
		}
		public void setQUEUETRACK___ (boolean v) {
		state.put(QUEUETRACK___, (v ? "1" : "0"));
		}
		public void setMUTE___ (boolean v) {
		state.put(MUTE___, (v ? "1" : "0"));
		}
		public void setPROGRESSBAR___ (boolean v) {
		state.put(PROGRESSBAR___, (v ? "1" : "0"));
		}
		public void setSHOWTIME___ (boolean v) {
		state.put(SHOWTIME___, (v ? "1" : "0"));
		}
		public void setSHOWTITLE___ (boolean v) {
		state.put(SHOWTITLE___, (v ? "1" : "0"));
		}
		public void setWAVPLAYER___ (boolean v) {
		state.put(WAVPLAYER___, (v ? "1" : "0"));
		}
		public void setLOADFOLDER___ (boolean v) {
		state.put(LOADFOLDER___, (v ? "1" : "0"));
		}
		public void setSHOWCOVER___ (boolean v) {
		state.put(SHOWCOVER___, (v ? "1" : "0"));
		}
		public void setSHUFFLEREPEAT___ (boolean v) {
		state.put(SHUFFLEREPEAT___, (v ? "1" : "0"));
		}
		public void setSKINS___ (boolean v) {
		state.put(SKINS___, (v ? "1" : "0"));
		}
		public void setORANGEBLUEST___ (boolean v) {
		state.put(ORANGEBLUEST___, (v ? "1" : "0"));
		}
		public void setDARK___ (boolean v) {
		state.put(DARK___, (v ? "1" : "0"));
		}
		public void setOPENFILE___ (boolean v) {
		state.put(OPENFILE___, (v ? "1" : "0"));
		}
		public void setCLEARPLAYLIST___ (boolean v) {
		state.put(CLEARPLAYLIST___, (v ? "1" : "0"));
		}



		public boolean isOPENWAVFILE___ () {
		return notifyFeatureRead(OPENWAVFILE___).equals("1");
		}
		public boolean isVOLUMECONTROL___ () {
		return notifyFeatureRead(VOLUMECONTROL___).equals("1");
		}
		public boolean isSKIPTRACK___ () {
		return notifyFeatureRead(SKIPTRACK___).equals("1");
		}
		public boolean isMP3PLAYER___ () {
		return notifyFeatureRead(MP3PLAYER___).equals("1");
		}
		public boolean isREMOVETRACK___ () {
		return notifyFeatureRead(REMOVETRACK___).equals("1");
		}
		public boolean isTIME___ () {
		return notifyFeatureRead(TIME___).equals("1");
		}
		public boolean isCHANGEPLAYLIST___ () {
		return notifyFeatureRead(CHANGEPLAYLIST___).equals("1");
		}
		public boolean isOPENMP3FILE___ () {
		return notifyFeatureRead(OPENMP3FILE___).equals("1");
		}
		public boolean isREORDERPLAYLIST___ () {
		return notifyFeatureRead(REORDERPLAYLIST___).equals("1");
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
		public boolean isGUI___ () {
		return notifyFeatureRead(GUI___).equals("1");
		}
		public boolean isAUDIOFORMATS___ () {
		return notifyFeatureRead(AUDIOFORMATS___).equals("1");
		}
		public boolean isFEATUREAMP___ () {
		return notifyFeatureRead(FEATUREAMP___).equals("1");
		}
		public boolean isQUEUETRACK___ () {
		return notifyFeatureRead(QUEUETRACK___).equals("1");
		}
		public boolean isMUTE___ () {
		return notifyFeatureRead(MUTE___).equals("1");
		}
		public boolean isPROGRESSBAR___ () {
		return notifyFeatureRead(PROGRESSBAR___).equals("1");
		}
		public boolean isSHOWTIME___ () {
		return notifyFeatureRead(SHOWTIME___).equals("1");
		}
		public boolean isSHOWTITLE___ () {
		return notifyFeatureRead(SHOWTITLE___).equals("1");
		}
		public boolean isWAVPLAYER___ () {
		return notifyFeatureRead(WAVPLAYER___).equals("1");
		}
		public boolean isLOADFOLDER___ () {
		return notifyFeatureRead(LOADFOLDER___).equals("1");
		}
		public boolean isSHOWCOVER___ () {
		return notifyFeatureRead(SHOWCOVER___).equals("1");
		}
		public boolean isSHUFFLEREPEAT___ () {
		return notifyFeatureRead(SHUFFLEREPEAT___).equals("1");
		}
		public boolean isSKINS___ () {
		return notifyFeatureRead(SKINS___).equals("1");
		}
		public boolean isORANGEBLUEST___ () {
		return notifyFeatureRead(ORANGEBLUEST___).equals("1");
		}
		public boolean isDARK___ () {
		return notifyFeatureRead(DARK___).equals("1");
		}
		public boolean isOPENFILE___ () {
		return notifyFeatureRead(OPENFILE___).equals("1");
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
