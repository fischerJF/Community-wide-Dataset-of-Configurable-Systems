package splat;

import java.util.Map;

import entry.FeatureVar;

public class FeatureAMP4Variables extends Variables {

	private static FeatureAMP4Variables SINGLETON;

	public static FeatureAMP4Variables getSINGLETON() {
		if (SINGLETON == null) {
			SINGLETON = new FeatureAMP4Variables();
		}
		return SINGLETON;
	}

	private FeatureAMP4Variables() {
		this.SKINS___ = new FeatureVar("SKINS___");
		this.PLAYER_CONTROL___ = new FeatureVar("PLAYER_CONTROL___");
		this.REORDER_PLAYLIST___ = new FeatureVar("REORDER_PLAYLIST___");
		this.TITLE_TIME___ = new FeatureVar("TITLE_TIME___");
		this.SKIP_TRACK___ = new FeatureVar("SKIP_TRACK___");
		this.PROGRESS___ = new FeatureVar("PROGRESS___");
		this.CLEAR_PLAYLIST___ = new FeatureVar("CLEAR_PLAYLIST___");
		this.PROGRESS_BAR___ = new FeatureVar("PROGRESS_BAR___");
		this.VOLUME_CONTROL___ = new FeatureVar("VOLUME_CONTROL___");
		this.REMOVE_TRACK___ = new FeatureVar("REMOVE_TRACK___");
		this.LIGHT___ = new FeatureVar("LIGHT___");
		this.DARK___ = new FeatureVar("DARK___");
		this.SHUFFLE_REPEAT___ = new FeatureVar("SHUFFLE_REPEAT___");
		this.SHOW_COVER___ = new FeatureVar("SHOW_COVER___");
		this.OGG___ = new FeatureVar("OGG___");
		this.MP3___ = new FeatureVar("MP3___");
		this.SAVE_LOAD_PLAYLIST___ = new FeatureVar("SAVE_LOAD_PLAYLIST___");
		this.BASE_FEATUREAMP___ = new FeatureVar("BASE_FEATUREAMP___");
		this.LOAD_FOLDER___ = new FeatureVar("LOAD_FOLDER___");
		this.QUEUE_TRACK___ = new FeatureVar("QUEUE_TRACK___");
		this.FILE_SUPPORT___ = new FeatureVar("FILE_SUPPORT___");
		this.PLAYER_BAR___ = new FeatureVar("PLAYER_BAR___");
		this.MUTE___ = new FeatureVar("MUTE___");
		this.ID3_TITLE___ = new FeatureVar("ID3_TITLE___");
		this.PLAYLIST___ = new FeatureVar("PLAYLIST___");

		restore();

	}

	private void init() {
		state.put(SKINS___, "?");
		state.put(PLAYER_CONTROL___, "?");
		state.put(REORDER_PLAYLIST___, "?");
		state.put(TITLE_TIME___, "?");
		state.put(SKIP_TRACK___, "?");
		state.put(PROGRESS___, "?");
		state.put(CLEAR_PLAYLIST___, "?");
		state.put(PROGRESS_BAR___, "1");
		state.put(VOLUME_CONTROL___, "?");
		state.put(REMOVE_TRACK___, "?");
		state.put(LIGHT___, "?");
		state.put(DARK___, "?");
		state.put(SHUFFLE_REPEAT___, "?");
		state.put(SHOW_COVER___, "?");
		state.put(OGG___, "?");
		state.put(MP3___, "?");
		state.put(SAVE_LOAD_PLAYLIST___, "?");
		state.put(BASE_FEATUREAMP___, "1");
		state.put(LOAD_FOLDER___, "?");
		state.put(QUEUE_TRACK___, "?");
		state.put(FILE_SUPPORT___, "?");
		state.put(PLAYER_BAR___, "1");
		state.put(MUTE___, "?");
		state.put(ID3_TITLE___, "1");
		state.put(PLAYLIST___, "?");
		

	}

	@Override
	public void restore() {
		state.clear();
		init();
	}

	private FeatureVar 
	SKINS___,
	PLAYER_CONTROL___,
	REORDER_PLAYLIST___,
	TITLE_TIME___,
	SKIP_TRACK___,
	PROGRESS___,
	CLEAR_PLAYLIST___,
	PROGRESS_BAR___,
	VOLUME_CONTROL___,
	REMOVE_TRACK___,
	LIGHT___,
	DARK___,
	SHUFFLE_REPEAT___,
	SHOW_COVER___,
	OGG___,
	MP3___,
	SAVE_LOAD_PLAYLIST___,
	BASE_FEATUREAMP___,
	LOAD_FOLDER___,
	QUEUE_TRACK___,
	FILE_SUPPORT___,
	PLAYER_BAR___,
	MUTE___,
	ID3_TITLE___,
	PLAYLIST___;


	// public boolean isDAILYLIMIT___() {
	// return get(VARS.DAILYLIMIT___).equals("1");
	// }

	public void setSKINS___ (boolean v) {
		state.put(SKINS___, (v ? "1" : "0"));
		}
		public void setPLAYER_CONTROL___ (boolean v) {
		state.put(PLAYER_CONTROL___, (v ? "1" : "0"));
		}
		public void setREORDER_PLAYLIST___ (boolean v) {
		state.put(REORDER_PLAYLIST___, (v ? "1" : "0"));
		}
		public void setTITLE_TIME___ (boolean v) {
		state.put(TITLE_TIME___, (v ? "1" : "0"));
		}
		public void setSKIP_TRACK___ (boolean v) {
		state.put(SKIP_TRACK___, (v ? "1" : "0"));
		}
		public void setPROGRESS___ (boolean v) {
		state.put(PROGRESS___, (v ? "1" : "0"));
		}
		public void setCLEAR_PLAYLIST___ (boolean v) {
		state.put(CLEAR_PLAYLIST___, (v ? "1" : "0"));
		}
		public void setPROGRESS_BAR___ (boolean v) {
		state.put(PROGRESS_BAR___, (v ? "1" : "0"));
		}
		public void setVOLUME_CONTROL___ (boolean v) {
		state.put(VOLUME_CONTROL___, (v ? "1" : "0"));
		}
		public void setREMOVE_TRACK___ (boolean v) {
		state.put(REMOVE_TRACK___, (v ? "1" : "0"));
		}
		public void setLIGHT___ (boolean v) {
		state.put(LIGHT___, (v ? "1" : "0"));
		}
		public void setDARK___ (boolean v) {
		state.put(DARK___, (v ? "1" : "0"));
		}
		public void setSHUFFLE_REPEAT___ (boolean v) {
		state.put(SHUFFLE_REPEAT___, (v ? "1" : "0"));
		}
		public void setSHOW_COVER___ (boolean v) {
		state.put(SHOW_COVER___, (v ? "1" : "0"));
		}
		public void setOGG___ (boolean v) {
		state.put(OGG___, (v ? "1" : "0"));
		}
		public void setMP3___ (boolean v) {
		state.put(MP3___, (v ? "1" : "0"));
		}
		public void setSAVE_LOAD_PLAYLIST___ (boolean v) {
		state.put(SAVE_LOAD_PLAYLIST___, (v ? "1" : "0"));
		}
		public void setBASE_FEATUREAMP___ (boolean v) {
		state.put(BASE_FEATUREAMP___, (v ? "1" : "0"));
		}
		public void setLOAD_FOLDER___ (boolean v) {
		state.put(LOAD_FOLDER___, (v ? "1" : "0"));
		}
		public void setQUEUE_TRACK___ (boolean v) {
		state.put(QUEUE_TRACK___, (v ? "1" : "0"));
		}
		public void setFILE_SUPPORT___ (boolean v) {
		state.put(FILE_SUPPORT___, (v ? "1" : "0"));
		}
		public void setPLAYER_BAR___ (boolean v) {
		state.put(PLAYER_BAR___, (v ? "1" : "0"));
		}
		public void setMUTE___ (boolean v) {
		state.put(MUTE___, (v ? "1" : "0"));
		}
		public void setID3_TITLE___ (boolean v) {
		state.put(ID3_TITLE___, (v ? "1" : "0"));
		}
		public void setPLAYLIST___ (boolean v) {
		state.put(PLAYLIST___, (v ? "1" : "0"));
		}



		public boolean isSKINS___ () {
		return notifyFeatureRead(SKINS___).equals("1");
		}
		public boolean isPLAYER_CONTROL___ () {
		return notifyFeatureRead(PLAYER_CONTROL___).equals("1");
		}
		public boolean isREORDER_PLAYLIST___ () {
		return notifyFeatureRead(REORDER_PLAYLIST___).equals("1");
		}
		public boolean isTITLE_TIME___ () {
		return notifyFeatureRead(TITLE_TIME___).equals("1");
		}
		public boolean isSKIP_TRACK___ () {
		return notifyFeatureRead(SKIP_TRACK___).equals("1");
		}
		public boolean isPROGRESS___ () {
		return notifyFeatureRead(PROGRESS___).equals("1");
		}
		public boolean isCLEAR_PLAYLIST___ () {
		return notifyFeatureRead(CLEAR_PLAYLIST___).equals("1");
		}
		public boolean isPROGRESS_BAR___ () {
		return notifyFeatureRead(PROGRESS_BAR___).equals("1");
		}
		public boolean isVOLUME_CONTROL___ () {
		return notifyFeatureRead(VOLUME_CONTROL___).equals("1");
		}
		public boolean isREMOVE_TRACK___ () {
		return notifyFeatureRead(REMOVE_TRACK___).equals("1");
		}
		public boolean isLIGHT___ () {
		return notifyFeatureRead(LIGHT___).equals("1");
		}
		public boolean isDARK___ () {
		return notifyFeatureRead(DARK___).equals("1");
		}
		public boolean isSHUFFLE_REPEAT___ () {
		return notifyFeatureRead(SHUFFLE_REPEAT___).equals("1");
		}
		public boolean isSHOW_COVER___ () {
		return notifyFeatureRead(SHOW_COVER___).equals("1");
		}
		public boolean isOGG___ () {
		return notifyFeatureRead(OGG___).equals("1");
		}
		public boolean isMP3___ () {
		return notifyFeatureRead(MP3___).equals("1");
		}
		public boolean isSAVE_LOAD_PLAYLIST___ () {
		return notifyFeatureRead(SAVE_LOAD_PLAYLIST___).equals("1");
		}
		public boolean isBASE_FEATUREAMP___ () {
		return notifyFeatureRead(BASE_FEATUREAMP___).equals("1");
		}
		public boolean isLOAD_FOLDER___ () {
		return notifyFeatureRead(LOAD_FOLDER___).equals("1");
		}
		public boolean isQUEUE_TRACK___ () {
		return notifyFeatureRead(QUEUE_TRACK___).equals("1");
		}
		public boolean isFILE_SUPPORT___ () {
		return notifyFeatureRead(FILE_SUPPORT___).equals("1");
		}
		public boolean isPLAYER_BAR___ () {
		return notifyFeatureRead(PLAYER_BAR___).equals("1");
		}
		public boolean isMUTE___ () {
		return notifyFeatureRead(MUTE___).equals("1");
		}
		public boolean isID3_TITLE___ () {
		return notifyFeatureRead(ID3_TITLE___).equals("1");
		}
		public boolean isPLAYLIST___ () {
		return notifyFeatureRead(PLAYLIST___).equals("1");
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
