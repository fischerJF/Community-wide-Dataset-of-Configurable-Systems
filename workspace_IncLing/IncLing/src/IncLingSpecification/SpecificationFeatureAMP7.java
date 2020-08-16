package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationFeatureAMP7 extends Specification {

	public static boolean openwavfile = false;
	public static boolean volumecontrol = false;
	public static boolean skiptrack = false;
	public static boolean mp3player = false;
	public static boolean removetrack = false;
	public static boolean time = false;
	public static boolean changeplaylist = false;
	public static boolean openmp3file = false;
	public static boolean reorderplaylist = false;
	public static boolean playlist = false;
	public static boolean light = false;
	public static boolean saveandloadplaylist = false;
	public static boolean gui = true;
	public static boolean audioformats = true;
	public static boolean featureamp = true;
	public static boolean queuetrack = false;
	public static boolean mute = false;
	public static boolean progressbar = false;
	public static boolean showtime = false;
	public static boolean showtitle = false;
	public static boolean wavplayer = false;
	public static boolean loadfolder = false;
	public static boolean showcover = false;
	public static boolean shufflerepeat = false;
	public static boolean skins = false;
	public static boolean orangebluest = false;
	public static boolean dark = false;
	public static boolean openfile = false;
	public static boolean clearplaylist = false;

	private static SpecificationFeatureAMP7 SINGLETON;

	public static SpecificationFeatureAMP7 getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationFeatureAMP7();
		}
		tool = t;
		return SINGLETON;
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setOPENWAVFILE() {
		return (openwavfile) ? "openwavfile___" : "-openwavfile___";
	}

	public static String setVOLUMECONTROL() {
		return (volumecontrol) ? "volumecontrol___" : "-volumecontrol___";
	}

	public static String setSKIPTRACK() {
		return (skiptrack) ? "skiptrack___" : "-skiptrack___";
	}

	public static String setMP3PLAYER() {
		return (mp3player) ? "mp3player___" : "-mp3player___";
	}

	public static String setREMOVETRACK() {
		return (removetrack) ? "removetrack___" : "-removetrack___";
	}

	public static String setTIME() {
		return (time) ? "time___" : "-time___";
	}

	public static String setCHANGEPLAYLIST() {
		return (changeplaylist) ? "changeplaylist___" : "-changeplaylist___";
	}

	public static String setOPENMP3FILE() {
		return (openmp3file) ? "openmp3file___" : "-openmp3file___";
	}

	public static String setREORDERPLAYLIST() {
		return (reorderplaylist) ? "reorderplaylist___" : "-reorderplaylist___";
	}

	public static String setPLAYLIST() {
		return (playlist) ? "playlist___" : "-playlist___";
	}

	public static String setLIGHT() {
		return (light) ? "light___" : "-light___";
	}

	public static String setSAVEANDLOADPLAYLIST() {
		return (saveandloadplaylist) ? "saveandloadplaylist___" : "-saveandloadplaylist___";
	}

	public static String setGUI() {
		return (gui) ? "gui___" : "-gui___";
	}

	public static String setAUDIOFORMATS() {
		return (audioformats) ? "audioformats___" : "-audioformats___";
	}

	public static String setFEATUREAMP() {
		return (featureamp) ? "featureamp___" : "-featureamp___";
	}

	public static String setQUEUETRACK() {
		return (queuetrack) ? "queuetrack___" : "-queuetrack___";
	}

	public static String setMUTE() {
		return (mute) ? "mute___" : "-mute___";
	}

	public static String setPROGRESSBAR() {
		return (progressbar) ? "progressbar___" : "-progressbar___";
	}

	public static String setSHOWTIME() {
		return (showtime) ? "showtime___" : "-showtime___";
	}

	public static String setSHOWTITLE() {
		return (showtitle) ? "showtitle___" : "-showtitle___";
	}

	public static String setWAVPLAYER() {
		return (wavplayer) ? "wavplayer___" : "-wavplayer___";
	}

	public static String setLOADFOLDER() {
		return (loadfolder) ? "loadfolder___" : "-loadfolder___";
	}

	public static String setSHOWCOVER() {
		return (showcover) ? "showcover___" : "-showcover___";
	}

	public static String setSHUFFLEREPEAT() {
		return (shufflerepeat) ? "shufflerepeat___" : "-shufflerepeat___";
	}

	public static String setSKINS() {
		return (skins) ? "skins___" : "-skins___";
	}

	public static String setORANGEBLUEST() {
		return (orangebluest) ? "orangebluest___" : "-orangebluest___";
	}

	public static String setDARK() {
		return (dark) ? "dark___" : "-dark___";
	}

	public static String setOPENFILE() {
		return (openfile) ? "openfile___" : "-openfile___";
	}

	public static String setCLEARPLAYLIST() {
		return (clearplaylist) ? "clearplaylist___" : "-clearplaylist___";
	}

	public boolean thereIsBase() {
		return false;
	}

	public static void init(String... args) {
		int index = 0;
		featureamp = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		audioformats = Boolean.valueOf(args[index++]);
		openwavfile = Boolean.valueOf(args[index++]);
		volumecontrol = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		mp3player = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		time = Boolean.valueOf(args[index++]);
		changeplaylist = Boolean.valueOf(args[index++]);
		openmp3file = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		showtitle = Boolean.valueOf(args[index++]);
		wavplayer = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		orangebluest = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		openfile = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
	}

}
