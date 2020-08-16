package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean openwavfile;
	public static boolean volumecontrol;
	public static boolean skiptrack;
	public static boolean mp3player;
	public static boolean removetrack;
	public static boolean time;
	public static boolean changeplaylist;
	public static boolean openmp3file;
	public static boolean reorderplaylist;
	public static boolean playlist;
	public static boolean light;
	public static boolean saveandloadplaylist;
	public static boolean gui;
	public static boolean audioformats;
	public static boolean featureamp;
	public static boolean queuetrack;
	public static boolean mute;
	public static boolean progressbar;
	public static boolean showtime;
	public static boolean showtitle;
	public static boolean wavplayer;
	public static boolean loadfolder;
	public static boolean showcover;
	public static boolean shufflerepeat;
	public static boolean skins;
	public static boolean orangebluest;
	public static boolean dark;
	public static boolean openfile;
	public static boolean clearplaylist;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setfeatureamp());
		t.add(setgui());
		t.add(setaudioformats());
		t.add(setopenwavfile());
		t.add(setvolumecontrol());
		t.add(setskiptrack());
		t.add(setmp3player());
		t.add(setremovetrack());
		t.add(settime());
		t.add(setchangeplaylist());
		t.add(setopenmp3file());
		t.add(setreorderplaylist());
		t.add(setplaylist());
		t.add(setlight());
		t.add(setsaveandloadplaylist());
		t.add(setqueuetrack());
		t.add(setmute());
		t.add(setprogressbar());
		t.add(setshowtime());
		t.add(setshowtitle());
		t.add(setwavplayer());
		t.add(setloadfolder());
		t.add(setshowcover());
		t.add(setshufflerepeat());
		t.add(setskins());
		t.add(setorangebluest());
		t.add(setdark());
		t.add(setopenfile());
		t.add(setclearplaylist());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setfeatureamp() {
		return (featureamp) ? "FEATUREAMP___" : "-FEATUREAMP___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setaudioformats() {
		return (audioformats) ? "AUDIOFORMATS___" : "-AUDIOFORMATS___";
	}

	public static String setopenwavfile() {
		return (openwavfile) ? "OPENWAVFILE___" : "-OPENWAVFILE___";
	}

	public static String setvolumecontrol() {
		return (volumecontrol) ? "VOLUMECONTROL___" : "-VOLUMECONTROL___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setmp3player() {
		return (mp3player) ? "MP3PLAYER___" : "-MP3PLAYER___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String settime() {
		return (time) ? "TIME___" : "-TIME___";
	}

	public static String setchangeplaylist() {
		return (changeplaylist) ? "CHANGEPLAYLIST___" : "-CHANGEPLAYLIST___";
	}

	public static String setopenmp3file() {
		return (openmp3file) ? "OPENMP3FILE___" : "-OPENMP3FILE___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setsaveandloadplaylist() {
		return (saveandloadplaylist) ? "SAVEANDLOADPLAYLIST___" : "-SAVEANDLOADPLAYLIST___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String setshowtime() {
		return (showtime) ? "SHOWTIME___" : "-SHOWTIME___";
	}

	public static String setshowtitle() {
		return (showtitle) ? "SHOWTITLE___" : "-SHOWTITLE___";
	}

	public static String setwavplayer() {
		return (wavplayer) ? "WAVPLAYER___" : "-WAVPLAYER___";
	}

	public static String setloadfolder() {
		return (loadfolder) ? "LOADFOLDER___" : "-LOADFOLDER___";
	}

	public static String setshowcover() {
		return (showcover) ? "SHOWCOVER___" : "-SHOWCOVER___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setskins() {
		return (skins) ? "SKINS___" : "-SKINS___";
	}

	public static String setorangebluest() {
		return (orangebluest) ? "ORANGEBLUEST___" : "-ORANGEBLUEST___";
	}

	public static String setdark() {
		return (dark) ? "DARK___" : "-DARK___";
	}

	public static String setopenfile() {
		return (openfile) ? "OPENFILE___" : "-OPENFILE___";
	}

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
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

	public static void productPrint() {
		System.out.println("featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "audioformats:"
				+ Configuration.audioformats + "openwavfile:" + Configuration.openwavfile + "volumecontrol:"
				+ Configuration.volumecontrol + "skiptrack:" + Configuration.skiptrack + "mp3player:"
				+ Configuration.mp3player + "removetrack:" + Configuration.removetrack + "time:" + Configuration.time
				+ "changeplaylist:" + Configuration.changeplaylist + "openmp3file:" + Configuration.openmp3file
				+ "reorderplaylist:" + Configuration.reorderplaylist + "playlist:" + Configuration.playlist + "light:"
				+ Configuration.light + "saveandloadplaylist:" + Configuration.saveandloadplaylist + "queuetrack:"
				+ Configuration.queuetrack + "mute:" + Configuration.mute + "progressbar:" + Configuration.progressbar
				+ "showtime:" + Configuration.showtime + "showtitle:" + Configuration.showtitle + "wavplayer:"
				+ Configuration.wavplayer + "loadfolder:" + Configuration.loadfolder + "showcover:"
				+ Configuration.showcover + "shufflerepeat:" + Configuration.shufflerepeat + "skins:"
				+ Configuration.skins + "orangebluest:" + Configuration.orangebluest + "dark:" + Configuration.dark
				+ "openfile:" + Configuration.openfile + "clearplaylist:" + Configuration.clearplaylist);
	}

	public static String returnProduct() {
		return "featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "audioformats:"
				+ Configuration.audioformats + "openwavfile:" + Configuration.openwavfile + "volumecontrol:"
				+ Configuration.volumecontrol + "skiptrack:" + Configuration.skiptrack + "mp3player:"
				+ Configuration.mp3player + "removetrack:" + Configuration.removetrack + "time:" + Configuration.time
				+ "changeplaylist:" + Configuration.changeplaylist + "openmp3file:" + Configuration.openmp3file
				+ "reorderplaylist:" + Configuration.reorderplaylist + "playlist:" + Configuration.playlist + "light:"
				+ Configuration.light + "saveandloadplaylist:" + Configuration.saveandloadplaylist + "queuetrack:"
				+ Configuration.queuetrack + "mute:" + Configuration.mute + "progressbar:" + Configuration.progressbar
				+ "showtime:" + Configuration.showtime + "showtitle:" + Configuration.showtitle + "wavplayer:"
				+ Configuration.wavplayer + "loadfolder:" + Configuration.loadfolder + "showcover:"
				+ Configuration.showcover + "shufflerepeat:" + Configuration.shufflerepeat + "skins:"
				+ Configuration.skins + "orangebluest:" + Configuration.orangebluest + "dark:" + Configuration.dark
				+ "openfile:" + Configuration.openfile + "clearplaylist:" + Configuration.clearplaylist;
	}

}