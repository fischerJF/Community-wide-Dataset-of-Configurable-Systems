package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean skiptrack;
	public static boolean volumecontrol;
	public static boolean lightskin;
	public static boolean removetrack;
	public static boolean time;
	public static boolean reorderplaylist;
	public static boolean playlist;
	public static boolean darkskin;
	public static boolean saveandloadplaylist;
	public static boolean gui;
	public static boolean featureamp;
	public static boolean queuetrack;
	public static boolean progressbar;
	public static boolean mute;
	public static boolean showtime;
	public static boolean player;
	public static boolean controlplayist;
	public static boolean showcover;
	public static boolean loadfolder;
	public static boolean shufflerepeat;
	public static boolean ogg;
	public static boolean mp3;
	public static boolean skins;
	public static boolean clearplaylist;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setfeatureamp());
		t.add(setgui());
		t.add(setplayer());
		t.add(setskiptrack());
		t.add(setvolumecontrol());
		t.add(setlightskin());
		t.add(setremovetrack());
		t.add(settime());
		t.add(setreorderplaylist());
		t.add(setplaylist());
		t.add(setdarkskin());
		t.add(setsaveandloadplaylist());
		t.add(setqueuetrack());
		t.add(setprogressbar());
		t.add(setmute());
		t.add(setshowtime());
		t.add(setcontrolplayist());
		t.add(setshowcover());
		t.add(setloadfolder());
		t.add(setshufflerepeat());
		t.add(setogg());
		t.add(setmp3());
		t.add(setskins());
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

	public static String setplayer() {
		return (player) ? "PLAYER___" : "-PLAYER___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setvolumecontrol() {
		return (volumecontrol) ? "VOLUMECONTROL___" : "-VOLUMECONTROL___";
	}

	public static String setlightskin() {
		return (lightskin) ? "LIGHTSKIN___" : "-LIGHTSKIN___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String settime() {
		return (time) ? "TIME___" : "-TIME___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setdarkskin() {
		return (darkskin) ? "DARKSKIN___" : "-DARKSKIN___";
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

	public static String setcontrolplayist() {
		return (controlplayist) ? "CONTROLPLAYIST___" : "-CONTROLPLAYIST___";
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

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
	}

	public static void init(String... args) {
		int index = 0;
		featureamp = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		player = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		volumecontrol = Boolean.valueOf(args[index++]);
		lightskin = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		time = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		darkskin = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		controlplayist = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "player:"
				+ Configuration.player + "skiptrack:" + Configuration.skiptrack + "volumecontrol:"
				+ Configuration.volumecontrol + "lightskin:" + Configuration.lightskin + "removetrack:"
				+ Configuration.removetrack + "time:" + Configuration.time + "reorderplaylist:"
				+ Configuration.reorderplaylist + "playlist:" + Configuration.playlist + "darkskin:"
				+ Configuration.darkskin + "saveandloadplaylist:" + Configuration.saveandloadplaylist + "queuetrack:"
				+ Configuration.queuetrack + "progressbar:" + Configuration.progressbar + "mute:" + Configuration.mute
				+ "showtime:" + Configuration.showtime + "controlplayist:" + Configuration.controlplayist + "showcover:"
				+ Configuration.showcover + "loadfolder:" + Configuration.loadfolder + "shufflerepeat:"
				+ Configuration.shufflerepeat + "ogg:" + Configuration.ogg + "mp3:" + Configuration.mp3 + "skins:"
				+ Configuration.skins + "clearplaylist:" + Configuration.clearplaylist);
	}

	public static String returnProduct() {
		return "featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "player:" + Configuration.player
				+ "skiptrack:" + Configuration.skiptrack + "volumecontrol:" + Configuration.volumecontrol + "lightskin:"
				+ Configuration.lightskin + "removetrack:" + Configuration.removetrack + "time:" + Configuration.time
				+ "reorderplaylist:" + Configuration.reorderplaylist + "playlist:" + Configuration.playlist
				+ "darkskin:" + Configuration.darkskin + "saveandloadplaylist:" + Configuration.saveandloadplaylist
				+ "queuetrack:" + Configuration.queuetrack + "progressbar:" + Configuration.progressbar + "mute:"
				+ Configuration.mute + "showtime:" + Configuration.showtime + "controlplayist:"
				+ Configuration.controlplayist + "showcover:" + Configuration.showcover + "loadfolder:"
				+ Configuration.loadfolder + "shufflerepeat:" + Configuration.shufflerepeat + "ogg:" + Configuration.ogg
				+ "mp3:" + Configuration.mp3 + "skins:" + Configuration.skins + "clearplaylist:"
				+ Configuration.clearplaylist;
	}

}