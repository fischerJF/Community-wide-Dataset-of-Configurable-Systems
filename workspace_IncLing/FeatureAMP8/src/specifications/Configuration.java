package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean volumecontrol;
	public static boolean skiptrack;
	public static boolean playengine;
	public static boolean removetrack;
	public static boolean wav;
	public static boolean reorderplaylist;
	public static boolean playlist;
	public static boolean control;
	public static boolean light;
	public static boolean saveandloadplaylist;
	public static boolean gui;
	public static boolean featureamp;
	public static boolean filesupport;
	public static boolean queuetrack;
	public static boolean progressbar;
	public static boolean mute;
	public static boolean showtime;
	public static boolean loadfolder;
	public static boolean tracktime;
	public static boolean shufflerepeat;
	public static boolean ogg;
	public static boolean mp3;
	public static boolean skins;
	public static boolean dark;
	public static boolean choosefile;
	public static boolean clearplaylist;
	public static boolean showcover;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setfeatureamp());
		t.add(setchoosefile());
		t.add(setplayengine());
		t.add(setgui());
		t.add(setvolumecontrol());
		t.add(setskiptrack());
		t.add(setremovetrack());
		t.add(setwav());
		t.add(setreorderplaylist());
		t.add(setplaylist());
		t.add(setcontrol());
		t.add(setlight());
		t.add(setsaveandloadplaylist());
		t.add(setfilesupport());
		t.add(setqueuetrack());
		t.add(setprogressbar());
		t.add(setmute());
		t.add(setshowtime());
		t.add(setloadfolder());
		t.add(settracktime());
		t.add(setshufflerepeat());
		t.add(setogg());
		t.add(setmp3());
		t.add(setskins());
		t.add(setdark());
		t.add(setclearplaylist());
		t.add(setshowcover());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setfeatureamp() {
		return (featureamp) ? "FEATUREAMP___" : "-FEATUREAMP___";
	}

	public static String setchoosefile() {
		return (choosefile) ? "CHOOSEFILE___" : "-CHOOSEFILE___";
	}

	public static String setplayengine() {
		return (playengine) ? "PLAYENGINE___" : "-PLAYENGINE___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
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

	public static String setwav() {
		return (wav) ? "WAV___" : "-WAV___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setcontrol() {
		return (control) ? "CONTROL___" : "-CONTROL___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setsaveandloadplaylist() {
		return (saveandloadplaylist) ? "SAVEANDLOADPLAYLIST___" : "-SAVEANDLOADPLAYLIST___";
	}

	public static String setfilesupport() {
		return (filesupport) ? "FILESUPPORT___" : "-FILESUPPORT___";
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

	public static String setloadfolder() {
		return (loadfolder) ? "LOADFOLDER___" : "-LOADFOLDER___";
	}

	public static String settracktime() {
		return (tracktime) ? "TRACKTIME___" : "-TRACKTIME___";
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

	public static String setshowcover() {
		return (showcover) ? "SHOWCOVER___" : "-SHOWCOVER___";
	}

	public static void init(String... args) {
		int index = 0;
		featureamp = Boolean.valueOf(args[index++]);
		choosefile = Boolean.valueOf(args[index++]);
		playengine = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		volumecontrol = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		wav = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		control = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		filesupport = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		tracktime = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("featureamp:" + Configuration.featureamp + "choosefile:" + Configuration.choosefile
				+ "playengine:" + Configuration.playengine + "gui:" + Configuration.gui + "volumecontrol:"
				+ Configuration.volumecontrol + "skiptrack:" + Configuration.skiptrack + "removetrack:"
				+ Configuration.removetrack + "wav:" + Configuration.wav + "reorderplaylist:"
				+ Configuration.reorderplaylist + "playlist:" + Configuration.playlist + "control:"
				+ Configuration.control + "light:" + Configuration.light + "saveandloadplaylist:"
				+ Configuration.saveandloadplaylist + "filesupport:" + Configuration.filesupport + "queuetrack:"
				+ Configuration.queuetrack + "progressbar:" + Configuration.progressbar + "mute:" + Configuration.mute
				+ "showtime:" + Configuration.showtime + "loadfolder:" + Configuration.loadfolder + "tracktime:"
				+ Configuration.tracktime + "shufflerepeat:" + Configuration.shufflerepeat + "ogg:" + Configuration.ogg
				+ "mp3:" + Configuration.mp3 + "skins:" + Configuration.skins + "dark:" + Configuration.dark
				+ "clearplaylist:" + Configuration.clearplaylist + "showcover:" + Configuration.showcover);
	}

	public static String returnProduct() {
		return "featureamp:" + Configuration.featureamp + "choosefile:" + Configuration.choosefile + "playengine:"
				+ Configuration.playengine + "gui:" + Configuration.gui + "volumecontrol:" + Configuration.volumecontrol
				+ "skiptrack:" + Configuration.skiptrack + "removetrack:" + Configuration.removetrack + "wav:"
				+ Configuration.wav + "reorderplaylist:" + Configuration.reorderplaylist + "playlist:"
				+ Configuration.playlist + "control:" + Configuration.control + "light:" + Configuration.light
				+ "saveandloadplaylist:" + Configuration.saveandloadplaylist + "filesupport:"
				+ Configuration.filesupport + "queuetrack:" + Configuration.queuetrack + "progressbar:"
				+ Configuration.progressbar + "mute:" + Configuration.mute + "showtime:" + Configuration.showtime
				+ "loadfolder:" + Configuration.loadfolder + "tracktime:" + Configuration.tracktime + "shufflerepeat:"
				+ Configuration.shufflerepeat + "ogg:" + Configuration.ogg + "mp3:" + Configuration.mp3 + "skins:"
				+ Configuration.skins + "dark:" + Configuration.dark + "clearplaylist:" + Configuration.clearplaylist
				+ "showcover:" + Configuration.showcover;
	}
}