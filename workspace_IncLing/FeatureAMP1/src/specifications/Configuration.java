package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean volumecontrol;
	public static boolean skiptrack;
	public static boolean removetrack;
	public static boolean time;
	public static boolean resizable;
	public static boolean wav;
	public static boolean supportedformats;
	public static boolean reorderplaylist;
	public static boolean playlist;
	public static boolean control;
	public static boolean light;
	public static boolean saveandloadplaylist;
	public static boolean gui;
	public static boolean featureamp;
	public static boolean queuetrack;
	public static boolean mute;
	public static boolean progressbar;
	public static boolean showtime;
	public static boolean id3information;
	public static boolean showcover;
	public static boolean loadfolder;
	public static boolean shufflerepeat;
	public static boolean base;
	public static boolean mp3;
	public static boolean skins;
	public static boolean dark;
	public static boolean openfile;
	public static boolean clearplaylist;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setvolumecontrol());
		t.add(setskiptrack());
		t.add(setremovetrack());
		t.add(settime());
		t.add(setresizable());
		t.add(setwav());
		t.add(setsupportedformats());
		t.add(setreorderplaylist());
		t.add(setplaylist());
		t.add(setcontrol());
		t.add(setlight());
		t.add(setsaveandloadplaylist());
		t.add(setgui());
		t.add(setfeatureamp());
		t.add(setqueuetrack());
		t.add(setmute());
		t.add(setprogressbar());
		t.add(setshowtime());
		t.add(setid3information());
		t.add(setshowcover());
		t.add(setloadfolder());
		t.add(setshufflerepeat());
		t.add(setbase());
		t.add(setmp3());
		t.add(setskins());
		t.add(setdark());
		t.add(setopenfile());
//		t.add(setclearplaylist());
		return runTest(t, makeCnfFile);
		
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
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

	public static String settime() {
		return (time) ? "TIME___" : "-TIME___";
	}

	public static String setresizable() {
		return (resizable) ? "RESIZABLE___" : "-RESIZABLE___";
	}

	public static String setwav() {
		return (wav) ? "WAV___" : "-WAV___";
	}

	public static String setsupportedformats() {
		return (supportedformats) ? "SUPPORTEDFORMATS___" : "-SUPPORTEDFORMATS___";
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

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setfeatureamp() {
		return (featureamp) ? "FEATUREAMP___" : "-FEATUREAMP___";
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

	public static String setid3information() {
		return (id3information) ? "ID3INFORMATION___" : "-ID3INFORMATION___";
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

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
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

	public static String setopenfile() {
		return (openfile) ? "OPENFILE___" : "-OPENFILE___";
	}

	public static String setclearplaylist() {
		return (clearplaylist) ? "CLEARPLAYLIST___" : "-CLEARPLAYLIST___";
	}

	public static void init(String... args) {
		int index = 0;
		volumecontrol = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		time = Boolean.valueOf(args[index++]);
		resizable = Boolean.valueOf(args[index++]);
		wav = Boolean.valueOf(args[index++]);
		supportedformats = Boolean.valueOf(args[index++]);
		reorderplaylist = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		control = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		saveandloadplaylist = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		featureamp = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		showtime = Boolean.valueOf(args[index++]);
		id3information = Boolean.valueOf(args[index++]);
		showcover = Boolean.valueOf(args[index++]);
		loadfolder = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		base = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		openfile = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println(
				"volumecontrol:" + Configuration.volumecontrol + 
				" skiptrack:" + Configuration.skiptrack
				+ " removetrack:" + Configuration.removetrack 
				+ " time:" + Configuration.time 
				+ " resizable:" + Configuration.resizable 
				+ " wav:" + Configuration.wav 
				+ " supportedformats:" + Configuration.supportedformats  
				+ " reorderplaylist:" + Configuration.reorderplaylist 
				+ " playlist:" 	+ Configuration.playlist 
				+ " control:" + Configuration.control 
				+ " light:" + Configuration.light
				+ " saveandloadplaylist:" + Configuration.saveandloadplaylist 
				+ " gui:" + Configuration.gui
				+ " featureamp:" + Configuration.featureamp 
				+ " queuetrack:" + Configuration.queuetrack 
				+ " mute:"+ Configuration.mute  
				+ " progressbar:" + Configuration.progressbar 
				+ " showtime:" + Configuration.showtime
				+ " id3information:" + Configuration.id3information 
				+ " showcover:" + Configuration.showcover
				+ " loadfolder:" + Configuration.loadfolder 
				+ " shufflerepeat:" + Configuration.shufflerepeat 
				+ " base:"+ Configuration.base 
				+ " mp3:" + Configuration.mp3 
				+ " skins:" + Configuration.skins 
				+ " dark:"+ Configuration.dark 
				+ " openfile:" + Configuration.openfile 
				+ " clearplaylist:"	+ Configuration.clearplaylist);
	}

	public static String returnProduct() {
		return "volumecontrol:" + Configuration.volumecontrol + "skiptrack:" + Configuration.skiptrack + "removetrack:"
				+ Configuration.removetrack + "time:" + Configuration.time + "resizable:" + Configuration.resizable
				+ "wav:" + Configuration.wav + "supportedformats:" + Configuration.supportedformats + "reorderplaylist:"
				+ Configuration.reorderplaylist + "playlist:" + Configuration.playlist + "control:"
				+ Configuration.control + "light:" + Configuration.light + "saveandloadplaylist:"
				+ Configuration.saveandloadplaylist + "gui:" + Configuration.gui + "featureamp:"
				+ Configuration.featureamp + "queuetrack:" + Configuration.queuetrack + "mute:" + Configuration.mute
				+ "progressbar:" + Configuration.progressbar + "showtime:" + Configuration.showtime + "id3information:"
				+ Configuration.id3information + "showcover:" + Configuration.showcover + "loadfolder:"
				+ Configuration.loadfolder + "shufflerepeat:" + Configuration.shufflerepeat + "base:"
				+ Configuration.base + "mp3:" + Configuration.mp3 + "skins:" + Configuration.skins + "dark:"
				+ Configuration.dark + "openfile:" + Configuration.openfile + "clearplaylist:"
				+ Configuration.clearplaylist;
	}

}