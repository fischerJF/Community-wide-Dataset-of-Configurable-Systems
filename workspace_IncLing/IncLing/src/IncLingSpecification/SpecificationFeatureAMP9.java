package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationFeatureAMP9 extends Specification {

	public static boolean volumecontrol=false;
	public static boolean skiptrack=false;
	public static boolean removetrack=false;
	public static boolean weichbrodt_featureamp=true;
	public static boolean reorderplaylist=false;
	public static boolean playlist=false;
	public static boolean timedisplay=false;
	public static boolean light=false;
	public static boolean shuffleskipremove=false;
	public static boolean saveandloadplaylist=false;
	public static boolean gui=true;
	public static boolean queuetrack=false;
	public static boolean filesupport=true;
	public static boolean progressbar=false;
	public static boolean mute=false;
	public static boolean showtime=false;
	public static boolean showcover=false;
	public static boolean loadfolder=false;
	public static boolean shufflerepeat=false;
	public static boolean ogg=false;
	public static boolean mp3=false;
	public static boolean skins=false;
	public static boolean dark=false;
	public static boolean clearplaylist=false;


	private static SpecificationFeatureAMP9 SINGLETON;

	public static SpecificationFeatureAMP9 getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationFeatureAMP9();
		}
		tool = t;
		return SINGLETON;
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setweichbrodt_featureamp() {
		return (weichbrodt_featureamp) ? "WEICHBRODT_FEATUREAMP___" : "-WEICHBRODT_FEATUREAMP___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setfilesupport() {
		return (filesupport) ? "FILESUPPORT___" : "-FILESUPPORT___";
	}

	public static String setvolumecontrol() {
		return (volumecontrol) ? "VOLUMECONTROL___" : "-VOLUMECONTROL___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String settimedisplay() {
		return (timedisplay) ? "TIMEDISPLAY___" : "-TIMEDISPLAY___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setshuffleskipremove() {
		return (shuffleskipremove) ? "SHUFFLESKIPREMOVE___" : "-SHUFFLESKIPREMOVE___";
	}

	public static String setsaveandloadplaylist() {
		return (saveandloadplaylist) ? "SAVEANDLOADPLAYLIST___" : "-SAVEANDLOADPLAYLIST___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String setshowtime() {
		return (showtime) ? "SHOWTIME___" : "-SHOWTIME___";
	}

	public static String setshowcover() {
		return (showcover) ? "SHOWCOVER___" : "-SHOWCOVER___";
	}

	public static String setloadfolder() {
		return (loadfolder) ? "LOADFOLDER___" : "-LOADFOLDER___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
	}

	public static String setskins() {
		return (skins) ? "SKINS___" : "-SKINS___";
	}

	public static String setdark() {
		return (dark) ? "DARK___" : "-DARK___";
	}

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
	}

	public boolean thereIsBase() {
		return false;
	}

	public static void init(String... args) {
		int index = 0;
		weichbrodt_featureamp = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		filesupport = Boolean.valueOf(args[index++]);
		volumecontrol = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		timedisplay = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		shuffleskipremove = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
		}

}
