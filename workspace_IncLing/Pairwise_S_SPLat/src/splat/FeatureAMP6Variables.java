package splat;

import java.util.Map;

import entry.FeatureVar;

public class FeatureAMP6Variables extends Variables {

	private static FeatureAMP6Variables SINGLETON;

	public static FeatureAMP6Variables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new FeatureAMP6Variables();
		}
		return SINGLETON;
	}

	private FeatureAMP6Variables() {
		this.SKIPTRACK___ = new FeatureVar("SKIPTRACK___");
		this.METADATA___ = new FeatureVar("METADATA___");
		this.REMOVETRACK___ = new FeatureVar("REMOVETRACK___");
		this.ALBUM___ = new FeatureVar("ALBUM___");
		this.WAV___ = new FeatureVar("WAV___");
		this.NICETOHAVE___ = new FeatureVar("NICETOHAVE___");
		this.PLAYLIST___ = new FeatureVar("PLAYLIST___");
		this.JUMPPOSITION___ = new FeatureVar("JUMPPOSITION___");
		this.LIGHT___ = new FeatureVar("LIGHT___");
		this.OPENFOLDER___ = new FeatureVar("OPENFOLDER___");
		this.GUI___ = new FeatureVar("GUI___");
		this.FEATUREAMP___ = new FeatureVar("FEATUREAMP___");
		this.QUEUETRACK___ = new FeatureVar("QUEUETRACK___");
		this.MUTE___ = new FeatureVar("MUTE___");
		this.TAGEDITOR___ = new FeatureVar("TAGEDITOR___");
		this.TRACKNUMBER___ = new FeatureVar("TRACKNUMBER___");
		this.CODECS___ = new FeatureVar("CODECS___");
		this.PROGRESS___ = new FeatureVar("PROGRESS___");
		this.AAC___ = new FeatureVar("AAC___");
		this.PLAYLISTCONTROLS___ = new FeatureVar("PLAYLISTCONTROLS___");
		this.MULTIPLEPLAYLISTS___ = new FeatureVar("MULTIPLEPLAYLISTS___");
		this.RANDOMCOLOR___ = new FeatureVar("RANDOMCOLOR___");
		this.SAVEANDLOAD___ = new FeatureVar("SAVEANDLOAD___");
		this.SHUFFLEREPEAT___ = new FeatureVar("SHUFFLEREPEAT___");
		this.BASE___ = new FeatureVar("BASE___");
		this.OGG___ = new FeatureVar("OGG___");
		this.YOUTUBE___ = new FeatureVar("YOUTUBE___");
		this.MP3___ = new FeatureVar("MP3___");
		this.OSCOLORS___ = new FeatureVar("OSCOLORS___");
		this.REORDER___ = new FeatureVar("REORDER___");
		this.COVER___ = new FeatureVar("COVER___");
		this.VOLUME___ = new FeatureVar("VOLUME___");
		this.SKINS___ = new FeatureVar("SKINS___");
		this.DARK___ = new FeatureVar("DARK___");
		this.CLEARPLAYLIST___ = new FeatureVar("CLEARPLAYLIST___");
		this.REMEBERSTATUS___ = new FeatureVar("REMEBERSTATUS___");
		this.PROGRESSBAR___ = new FeatureVar("PROGRESSBAR___");
		this.TITLEBAR___ = new FeatureVar("TITLEBAR___");
		restore();

	}

	private void init() {
		state.put(SKIPTRACK___, "?");
		state.put(METADATA___, "?");
		state.put(REMOVETRACK___, "?");
		state.put(ALBUM___, "?");
		state.put(WAV___, "?");
		state.put(NICETOHAVE___, "?");
		state.put(PLAYLIST___, "?");
		state.put(JUMPPOSITION___, "?");
		state.put(LIGHT___, "?");
		state.put(OPENFOLDER___, "?");
		state.put(GUI___, "?");
		state.put(FEATUREAMP___, "?");
		state.put(QUEUETRACK___, "?");
		state.put(MUTE___, "?");
		state.put(TAGEDITOR___, "?");
		state.put(TRACKNUMBER___, "?");
		state.put(CODECS___, "?");
		state.put(PROGRESS___, "?");
		state.put(AAC___, "?");
		state.put(PLAYLISTCONTROLS___, "?");
		state.put(MULTIPLEPLAYLISTS___, "?");
		state.put(RANDOMCOLOR___, "?");
		state.put(SAVEANDLOAD___, "?");
		state.put(SHUFFLEREPEAT___, "?");
		state.put(BASE___, "1");
		state.put(OGG___, "?");
		state.put(YOUTUBE___, "?");
		state.put(MP3___, "?");
		state.put(OSCOLORS___, "?");
		state.put(REORDER___, "?");
		state.put(COVER___, "?");
		state.put(VOLUME___, "?");
		state.put(SKINS___, "?");
		state.put(DARK___, "?");
		state.put(CLEARPLAYLIST___, "?");
		state.put(REMEBERSTATUS___, "?");
		state.put(PROGRESSBAR___, "?");
		state.put(TITLEBAR___, "?");
;
		

	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar 
	SKIPTRACK___,
	METADATA___,
	REMOVETRACK___,
	ALBUM___,
	WAV___,
	NICETOHAVE___,
	PLAYLIST___,
	JUMPPOSITION___,
	LIGHT___,
	OPENFOLDER___,
	GUI___,
	FEATUREAMP___,
	QUEUETRACK___,
	MUTE___,
	TAGEDITOR___,
	TRACKNUMBER___,
	CODECS___,
	PROGRESS___,
	AAC___,
	PLAYLISTCONTROLS___,
	MULTIPLEPLAYLISTS___,
	RANDOMCOLOR___,
	SAVEANDLOAD___,
	SHUFFLEREPEAT___,
	BASE___,
	OGG___,
	YOUTUBE___,
	MP3___,
	OSCOLORS___,
	REORDER___,
	COVER___,
	VOLUME___,
	SKINS___,
	DARK___,
	CLEARPLAYLIST___,
	REMEBERSTATUS___,
	PROGRESSBAR___,
	TITLEBAR___;


	// public boolean isDAILYLIMIT___() {
	// return get(VARS.DAILYLIMIT___).equals("1");
	// }

	public void setSKIPTRACK___ (boolean v) {
		state.put(SKIPTRACK___, (v ? "1" : "0"));
		}
		public void setMETADATA___ (boolean v) {
		state.put(METADATA___, (v ? "1" : "0"));
		}
		public void setREMOVETRACK___ (boolean v) {
		state.put(REMOVETRACK___, (v ? "1" : "0"));
		}
		public void setALBUM___ (boolean v) {
		state.put(ALBUM___, (v ? "1" : "0"));
		}
		public void setWAV___ (boolean v) {
		state.put(WAV___, (v ? "1" : "0"));
		}
		public void setNICETOHAVE___ (boolean v) {
		state.put(NICETOHAVE___, (v ? "1" : "0"));
		}
		public void setPLAYLIST___ (boolean v) {
		state.put(PLAYLIST___, (v ? "1" : "0"));
		}
		public void setJUMPPOSITION___ (boolean v) {
		state.put(JUMPPOSITION___, (v ? "1" : "0"));
		}
		public void setLIGHT___ (boolean v) {
		state.put(LIGHT___, (v ? "1" : "0"));
		}
		public void setOPENFOLDER___ (boolean v) {
		state.put(OPENFOLDER___, (v ? "1" : "0"));
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
		public void setMUTE___ (boolean v) {
		state.put(MUTE___, (v ? "1" : "0"));
		}
		public void setTAGEDITOR___ (boolean v) {
		state.put(TAGEDITOR___, (v ? "1" : "0"));
		}
		public void setTRACKNUMBER___ (boolean v) {
		state.put(TRACKNUMBER___, (v ? "1" : "0"));
		}
		public void setCODECS___ (boolean v) {
		state.put(CODECS___, (v ? "1" : "0"));
		}
		public void setPROGRESS___ (boolean v) {
		state.put(PROGRESS___, (v ? "1" : "0"));
		}
		public void setAAC___ (boolean v) {
		state.put(AAC___, (v ? "1" : "0"));
		}
		public void setPLAYLISTCONTROLS___ (boolean v) {
		state.put(PLAYLISTCONTROLS___, (v ? "1" : "0"));
		}
		public void setMULTIPLEPLAYLISTS___ (boolean v) {
		state.put(MULTIPLEPLAYLISTS___, (v ? "1" : "0"));
		}
		public void setRANDOMCOLOR___ (boolean v) {
		state.put(RANDOMCOLOR___, (v ? "1" : "0"));
		}
		public void setSAVEANDLOAD___ (boolean v) {
		state.put(SAVEANDLOAD___, (v ? "1" : "0"));
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
		public void setYOUTUBE___ (boolean v) {
		state.put(YOUTUBE___, (v ? "1" : "0"));
		}
		public void setMP3___ (boolean v) {
		state.put(MP3___, (v ? "1" : "0"));
		}
		public void setOSCOLORS___ (boolean v) {
		state.put(OSCOLORS___, (v ? "1" : "0"));
		}
		public void setREORDER___ (boolean v) {
		state.put(REORDER___, (v ? "1" : "0"));
		}
		public void setCOVER___ (boolean v) {
		state.put(COVER___, (v ? "1" : "0"));
		}
		public void setVOLUME___ (boolean v) {
		state.put(VOLUME___, (v ? "1" : "0"));
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
		public void setREMEBERSTATUS___ (boolean v) {
		state.put(REMEBERSTATUS___, (v ? "1" : "0"));
		}
		public void setPROGRESSBAR___ (boolean v) {
		state.put(PROGRESSBAR___, (v ? "1" : "0"));
		}
		public void setTITLEBAR___ (boolean v) {
		state.put(TITLEBAR___, (v ? "1" : "0"));
		}



		public boolean isSKIPTRACK___ () {
		return notifyFeatureRead(SKIPTRACK___).equals("1");
		}
		public boolean isMETADATA___ () {
		return notifyFeatureRead(METADATA___).equals("1");
		}
		public boolean isREMOVETRACK___ () {
		return notifyFeatureRead(REMOVETRACK___).equals("1");
		}
		public boolean isALBUM___ () {
		return notifyFeatureRead(ALBUM___).equals("1");
		}
		public boolean isWAV___ () {
		return notifyFeatureRead(WAV___).equals("1");
		}
		public boolean isNICETOHAVE___ () {
		return notifyFeatureRead(NICETOHAVE___).equals("1");
		}
		public boolean isPLAYLIST___ () {
		return notifyFeatureRead(PLAYLIST___).equals("1");
		}
		public boolean isJUMPPOSITION___ () {
		return notifyFeatureRead(JUMPPOSITION___).equals("1");
		}
		public boolean isLIGHT___ () {
		return notifyFeatureRead(LIGHT___).equals("1");
		}
		public boolean isOPENFOLDER___ () {
		return notifyFeatureRead(OPENFOLDER___).equals("1");
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
		public boolean isMUTE___ () {
		return notifyFeatureRead(MUTE___).equals("1");
		}
		public boolean isTAGEDITOR___ () {
		return notifyFeatureRead(TAGEDITOR___).equals("1");
		}
		public boolean isTRACKNUMBER___ () {
		return notifyFeatureRead(TRACKNUMBER___).equals("1");
		}
		public boolean isCODECS___ () {
		return notifyFeatureRead(CODECS___).equals("1");
		}
		public boolean isPROGRESS___ () {
		return notifyFeatureRead(PROGRESS___).equals("1");
		}
		public boolean isAAC___ () {
		return notifyFeatureRead(AAC___).equals("1");
		}
		public boolean isPLAYLISTCONTROLS___ () {
		return notifyFeatureRead(PLAYLISTCONTROLS___).equals("1");
		}
		public boolean isMULTIPLEPLAYLISTS___ () {
		return notifyFeatureRead(MULTIPLEPLAYLISTS___).equals("1");
		}
		public boolean isRANDOMCOLOR___ () {
		return notifyFeatureRead(RANDOMCOLOR___).equals("1");
		}
		public boolean isSAVEANDLOAD___ () {
		return notifyFeatureRead(SAVEANDLOAD___).equals("1");
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
		public boolean isYOUTUBE___ () {
		return notifyFeatureRead(YOUTUBE___).equals("1");
		}
		public boolean isMP3___ () {
		return notifyFeatureRead(MP3___).equals("1");
		}
		public boolean isOSCOLORS___ () {
		return notifyFeatureRead(OSCOLORS___).equals("1");
		}
		public boolean isREORDER___ () {
		return notifyFeatureRead(REORDER___).equals("1");
		}
		public boolean isCOVER___ () {
		return notifyFeatureRead(COVER___).equals("1");
		}
		public boolean isVOLUME___ () {
		return notifyFeatureRead(VOLUME___).equals("1");
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
		public boolean isREMEBERSTATUS___ () {
		return notifyFeatureRead(REMEBERSTATUS___).equals("1");
		}
		public boolean isPROGRESSBAR___ () {
		return notifyFeatureRead(PROGRESSBAR___).equals("1");
		}
		public boolean isTITLEBAR___ () {
		return notifyFeatureRead(TITLEBAR___).equals("1");
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
