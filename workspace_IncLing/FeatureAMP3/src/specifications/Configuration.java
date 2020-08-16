package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean skiptrack;
	public static boolean volumecontrol;
	public static boolean playlistcontrol;
	public static boolean removetrack;
	public static boolean time;
	public static boolean wav;
	public static boolean reorderplaylist;
	public static boolean mp3;
	public static boolean playlist;
	public static boolean light;
	public static boolean saveandloadplaylist;
	public static boolean changelistener;
	public static boolean gui;
	public static boolean featureamp;
	public static boolean queuetrack;
	public static boolean filesupport;
	public static boolean playlistcontextmenu;
	public static boolean mute;
	public static boolean progressbar;
	public static boolean tageditor;
	public static boolean showtime;
	public static boolean aac;
	public static boolean loadfolder;
	public static boolean multipleplaylists;
	public static boolean showcover;
	public static boolean playlistmenu;
	public static boolean shufflerepeat;
	public static boolean base;
	public static boolean ogg;
	public static boolean playlisttabs;
	public static boolean addplaylistwrapper;
	public static boolean skins;
	public static boolean dark;
	public static boolean clearplaylist;
	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setfeatureamp());
		t.add(setgui());
		t.add(setfilesupport());
		t.add(setbase());
		t.add(setskiptrack());
		t.add(setvolumecontrol());
		t.add(setplaylistcontrol());
		t.add(setremovetrack());
		t.add(settime());
		t.add(setwav());
		t.add(setreorderplaylist());
		t.add(setmp3());
		t.add(setplaylist());
		t.add(setlight());
		t.add(setsaveandloadplaylist());
		t.add(setchangelistener());
		t.add(setqueuetrack());
		t.add(setplaylistcontextmenu());
		t.add(setmute());
		t.add(setprogressbar());
		t.add(settageditor());
		t.add(setshowtime());
		t.add(setaac());
		t.add(setloadfolder());
		t.add(setmultipleplaylists());
		t.add(setshowcover());
		t.add(setplaylistmenu());
		t.add(setshufflerepeat());
		t.add(setogg());
		t.add(setplaylisttabs());
		t.add(setaddplaylistwrapper());
		t.add(setskins());
		t.add(setdark());
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

	public static String setfilesupport() {
		return (filesupport) ? "FILESUPPORT___" : "-FILESUPPORT___";
	}

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setvolumecontrol() {
		return (volumecontrol) ? "VOLUMECONTROL___" : "-VOLUMECONTROL___";
	}

	public static String setplaylistcontrol() {
		return (playlistcontrol) ? "PLAYLISTCONTROL___" : "-PLAYLISTCONTROL___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String settime() {
		return (time) ? "TIME___" : "-TIME___";
	}

	public static String setwav() {
		return (wav) ? "WAV___" : "-WAV___";
	}

	public static String setreorderplaylist() {
		return (reorderplaylist) ? "REORDERPLAYLIST___" : "-REORDERPLAYLIST___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
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

	public static String setchangelistener() {
		return (changelistener) ? "CHANGELISTENER___" : "-CHANGELISTENER___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setplaylistcontextmenu() {
		return (playlistcontextmenu) ? "PLAYLISTCONTEXTMENU___" : "-PLAYLISTCONTEXTMENU___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String settageditor() {
		return (tageditor) ? "TAGEDITOR___" : "-TAGEDITOR___";
	}

	public static String setshowtime() {
		return (showtime) ? "SHOWTIME___" : "-SHOWTIME___";
	}

	public static String setaac() {
		return (aac) ? "AAC___" : "-AAC___";
	}

	public static String setloadfolder() {
		return (loadfolder) ? "LOADFOLDER___" : "-LOADFOLDER___";
	}

	public static String setmultipleplaylists() {
		return (multipleplaylists) ? "MULTIPLEPLAYLISTS___" : "-MULTIPLEPLAYLISTS___";
	}

	public static String setshowcover() {
		return (showcover) ? "SHOWCOVER___" : "-SHOWCOVER___";
	}

	public static String setplaylistmenu() {
		return (playlistmenu) ? "PLAYLISTMENU___" : "-PLAYLISTMENU___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setplaylisttabs() {
		return (playlisttabs) ? "PLAYLISTTABS___" : "-PLAYLISTTABS___";
	}

	public static String setaddplaylistwrapper() {
		return (addplaylistwrapper) ? "ADDPLAYLISTWRAPPER___" : "-ADDPLAYLISTWRAPPER___";
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

	public static void init(String... args) {
		int index = 0;
		featureamp = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		filesupport = Boolean.valueOf(args[index++]);
		base = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		volumecontrol = Boolean.valueOf(args[index++]);
		playlistcontrol = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		time = Boolean.valueOf(args[index++]);
		wav = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		changelistener = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		playlistcontextmenu = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		tageditor = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		aac = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		multipleplaylists = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
		playlistmenu = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		playlisttabs = Boolean.valueOf(args[index++]);
		addplaylistwrapper = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "filesupport:"
				+ Configuration.filesupport + "base:" + Configuration.base + "skiptrack:" + Configuration.skiptrack
				+ "volumecontrol:" + Configuration.volumecontrol + "playlistcontrol:" + Configuration.playlistcontrol
				+ "removetrack:" + Configuration.removetrack + "time:" + Configuration.time + "wav:" + Configuration.wav
				+ "reorderplaylist:" + Configuration.reorderplaylist + "mp3:" + Configuration.mp3 + "playlist:"
				+ Configuration.playlist + "light:" + Configuration.light + "saveandloadplaylist:"
				+ Configuration.saveandloadplaylist + "changelistener:" + Configuration.changelistener + "queuetrack:"
				+ Configuration.queuetrack + "playlistcontextmenu:" + Configuration.playlistcontextmenu + "mute:"
				+ Configuration.mute + "progressbar:" + Configuration.progressbar + "tageditor:"
				+ Configuration.tageditor + "showtime:" + Configuration.showtime + "aac:" + Configuration.aac
				+ "loadfolder:" + Configuration.loadfolder + "multipleplaylists:" + Configuration.multipleplaylists
				+ "showcover:" + Configuration.showcover + "playlistmenu:" + Configuration.playlistmenu
				+ "shufflerepeat:" + Configuration.shufflerepeat + "ogg:" + Configuration.ogg + "playlisttabs:"
				+ Configuration.playlisttabs + "addplaylistwrapper:" + Configuration.addplaylistwrapper + "skins:"
				+ Configuration.skins + "dark:" + Configuration.dark + "clearplaylist:" + Configuration.clearplaylist);
	}

	public static String returnProduct() {
		return "featureamp:" + Configuration.featureamp + "gui:" + Configuration.gui + "filesupport:"
				+ Configuration.filesupport + "base:" + Configuration.base + "skiptrack:" + Configuration.skiptrack
				+ "volumecontrol:" + Configuration.volumecontrol + "playlistcontrol:" + Configuration.playlistcontrol
				+ "removetrack:" + Configuration.removetrack + "time:" + Configuration.time + "wav:" + Configuration.wav
				+ "reorderplaylist:" + Configuration.reorderplaylist + "mp3:" + Configuration.mp3 + "playlist:"
				+ Configuration.playlist + "light:" + Configuration.light + "saveandloadplaylist:"
				+ Configuration.saveandloadplaylist + "changelistener:" + Configuration.changelistener + "queuetrack:"
				+ Configuration.queuetrack + "playlistcontextmenu:" + Configuration.playlistcontextmenu + "mute:"
				+ Configuration.mute + "progressbar:" + Configuration.progressbar + "tageditor:"
				+ Configuration.tageditor + "showtime:" + Configuration.showtime + "aac:" + Configuration.aac
				+ "loadfolder:" + Configuration.loadfolder + "multipleplaylists:" + Configuration.multipleplaylists
				+ "showcover:" + Configuration.showcover + "playlistmenu:" + Configuration.playlistmenu
				+ "shufflerepeat:" + Configuration.shufflerepeat + "ogg:" + Configuration.ogg + "playlisttabs:"
				+ Configuration.playlisttabs + "addplaylistwrapper:" + Configuration.addplaylistwrapper + "skins:"
				+ Configuration.skins + "dark:" + Configuration.dark + "clearplaylist:" + Configuration.clearplaylist;
	}

}