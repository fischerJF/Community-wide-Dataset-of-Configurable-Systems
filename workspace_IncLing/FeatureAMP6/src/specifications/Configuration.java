package specifications;

import guidsl.SATtest;
import guidsl.Tool;
public class Configuration {

	public static boolean skiptrack;
	public static boolean metadata;
	public static boolean removetrack;
	public static boolean album;
	public static boolean wav;
	public static boolean nicetohave;
	public static boolean playlist;
	public static boolean jumpposition;
	public static boolean light;
	public static boolean openfolder;
	public static boolean gui;
	public static boolean featureamp;
	public static boolean queuetrack;
	public static boolean mute;
	public static boolean tageditor;
	public static boolean tracknumber;
	public static boolean codecs;
	public static boolean progress;
	public static boolean aac;
	public static boolean playlistcontrols;
	public static boolean multipleplaylists;
	public static boolean randomcolor;
	public static boolean saveandload;
	public static boolean shufflerepeat;
	public static boolean base;
	public static boolean ogg;
	public static boolean youtube;
	public static boolean mp3;
	public static boolean oscolors;
	public static boolean reorder;
	public static boolean cover;
	public static boolean volume;
	public static boolean skins;
	public static boolean dark;
	public static boolean clearplaylist;
	public static boolean remeberstatus;
	public static boolean progressbar;
	public static boolean titlebar;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setfeatureamp());
		t.add(setbase());
		t.add(setcodecs());
		t.add(setgui());
		t.add(setskiptrack());
		t.add(setmetadata());
		t.add(setremovetrack());
		t.add(setalbum());
		t.add(setwav());
		t.add(setnicetohave());
		t.add(setplaylist());
		t.add(setjumpposition());
		t.add(setlight());
		t.add(setopenfolder());
		t.add(setqueuetrack());
		t.add(setmute());
		t.add(settageditor());
		t.add(settracknumber());
		t.add(setprogress());
		t.add(setaac());
		t.add(setplaylistcontrols());
		t.add(setmultipleplaylists());
		t.add(setrandomcolor());
		t.add(setsaveandload());
		t.add(setshufflerepeat());
		t.add(setogg());
		t.add(setyoutube());
		t.add(setmp3());
		t.add(setoscolors());
		t.add(setreorder());
		t.add(setcover());
		t.add(setvolume());
		t.add(setskins());
		t.add(setdark());
		t.add(setclearplaylist());
		t.add(setremeberstatus());
		t.add(setprogressbar());
		t.add(settitlebar());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setfeatureamp() {
		return (featureamp) ? "FEATUREAMP___" : "-FEATUREAMP___";
	}

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
	}

	public static String setcodecs() {
		return (codecs) ? "CODECS___" : "-CODECS___";
	}

	public static String setgui() {
		return (gui) ? "GUI___" : "-GUI___";
	}

	public static String setskiptrack() {
		return (skiptrack) ? "SKIPTRACK___" : "-SKIPTRACK___";
	}

	public static String setmetadata() {
		return (metadata) ? "METADATA___" : "-METADATA___";
	}

	public static String setremovetrack() {
		return (removetrack) ? "REMOVETRACK___" : "-REMOVETRACK___";
	}

	public static String setalbum() {
		return (album) ? "ALBUM___" : "-ALBUM___";
	}

	public static String setwav() {
		return (wav) ? "WAV___" : "-WAV___";
	}

	public static String setnicetohave() {
		return (nicetohave) ? "NICETOHAVE___" : "-NICETOHAVE___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static String setjumpposition() {
		return (jumpposition) ? "JUMPPOSITION___" : "-JUMPPOSITION___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setopenfolder() {
		return (openfolder) ? "OPENFOLDER___" : "-OPENFOLDER___";
	}

	public static String setqueuetrack() {
		return (queuetrack) ? "QUEUETRACK___" : "-QUEUETRACK___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String settageditor() {
		return (tageditor) ? "TAGEDITOR___" : "-TAGEDITOR___";
	}

	public static String settracknumber() {
		return (tracknumber) ? "TRACKNUMBER___" : "-TRACKNUMBER___";
	}

	public static String setprogress() {
		return (progress) ? "PROGRESS___" : "-PROGRESS___";
	}

	public static String setaac() {
		return (aac) ? "AAC___" : "-AAC___";
	}

	public static String setplaylistcontrols() {
		return (playlistcontrols) ? "PLAYLISTCONTROLS___" : "-PLAYLISTCONTROLS___";
	}

	public static String setmultipleplaylists() {
		return (multipleplaylists) ? "MULTIPLEPLAYLISTS___" : "-MULTIPLEPLAYLISTS___";
	}

	public static String setrandomcolor() {
		return (randomcolor) ? "RANDOMCOLOR___" : "-RANDOMCOLOR___";
	}

	public static String setsaveandload() {
		return (saveandload) ? "SAVEANDLOAD___" : "-SAVEANDLOAD___";
	}

	public static String setshufflerepeat() {
		return (shufflerepeat) ? "SHUFFLEREPEAT___" : "-SHUFFLEREPEAT___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setyoutube() {
		return (youtube) ? "YOUTUBE___" : "-YOUTUBE___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
	}

	public static String setoscolors() {
		return (oscolors) ? "OSCOLORS___" : "-OSCOLORS___";
	}

	public static String setreorder() {
		return (reorder) ? "REORDER___" : "-REORDER___";
	}

	public static String setcover() {
		return (cover) ? "COVER___" : "-COVER___";
	}

	public static String setvolume() {
		return (volume) ? "VOLUME___" : "-VOLUME___";
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

	public static String setremeberstatus() {
		return (remeberstatus) ? "REMEBERSTATUS___" : "-REMEBERSTATUS___";
	}

	public static String setprogressbar() {
		return (progressbar) ? "PROGRESSBAR___" : "-PROGRESSBAR___";
	}

	public static String settitlebar() {
		return (titlebar) ? "TITLEBAR___" : "-TITLEBAR___";
	}

	public static void init(String... args) {
		int index = 0;
		featureamp = Boolean.valueOf(args[index++]);
		base = Boolean.valueOf(args[index++]);
		codecs = Boolean.valueOf(args[index++]);
		gui = Boolean.valueOf(args[index++]);
		skiptrack = Boolean.valueOf(args[index++]);
		metadata = Boolean.valueOf(args[index++]);
		removetrack = Boolean.valueOf(args[index++]);
		album = Boolean.valueOf(args[index++]);
		wav = Boolean.valueOf(args[index++]);
		nicetohave = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
		jumpposition = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		openfolder = Boolean.valueOf(args[index++]);
		queuetrack = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		tageditor = Boolean.valueOf(args[index++]);
		tracknumber = Boolean.valueOf(args[index++]);
		progress = Boolean.valueOf(args[index++]);
		aac = Boolean.valueOf(args[index++]);
		playlistcontrols = Boolean.valueOf(args[index++]);
		multipleplaylists = Boolean.valueOf(args[index++]);
		randomcolor = Boolean.valueOf(args[index++]);
		saveandload = Boolean.valueOf(args[index++]);
		shufflerepeat = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		youtube = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		oscolors = Boolean.valueOf(args[index++]);
		reorder = Boolean.valueOf(args[index++]);
		cover = Boolean.valueOf(args[index++]);
		volume = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		clearplaylist = Boolean.valueOf(args[index++]);
		remeberstatus = Boolean.valueOf(args[index++]);
		progressbar = Boolean.valueOf(args[index++]);
		titlebar = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("featureamp:" + Configuration.featureamp + "base:" + Configuration.base + "codecs:"
				+ Configuration.codecs + "gui:" + Configuration.gui + "skiptrack:" + Configuration.skiptrack
				+ "metadata:" + Configuration.metadata + "removetrack:" + Configuration.removetrack + "album:"
				+ Configuration.album + "wav:" + Configuration.wav + "nicetohave:" + Configuration.nicetohave
				+ "playlist:" + Configuration.playlist + "jumpposition:" + Configuration.jumpposition + "light:"
				+ Configuration.light + "openfolder:" + Configuration.openfolder + "queuetrack:"
				+ Configuration.queuetrack + "nmute:" + Configuration.mute + "tageditor:" + Configuration.tageditor
				+ "tracknumber:" + Configuration.tracknumber + "progress:" + Configuration.progress + "aac:"
				+ Configuration.aac + "playlistcontrols:" + Configuration.playlistcontrols + "multipleplaylists:"
				+ Configuration.multipleplaylists + "randomcolor:" + Configuration.randomcolor + "saveandload:"
				+ Configuration.saveandload + "shufflerepeat:" + Configuration.shufflerepeat + "ogg:"
				+ Configuration.ogg + "youtube:" + Configuration.youtube + "mp3:" + Configuration.mp3 + "oscolors:"
				+ Configuration.oscolors + "reorder:" + Configuration.reorder + "cover:" + Configuration.cover
				+ "volume:" + Configuration.volume + "skins:" + Configuration.skins + "dark:" + Configuration.dark
				+ "clearplaylist:" + Configuration.clearplaylist + "remeberstatus:" + Configuration.remeberstatus
				+ "progressbar:" + Configuration.progressbar + "titlebar:" + Configuration.titlebar);
	}

	public static String returnProduct() {
		return "featureamp:" + Configuration.featureamp + "base:" + Configuration.base + "codecs:"
				+ Configuration.codecs + "gui:" + Configuration.gui + "skiptrack:" + Configuration.skiptrack
				+ "metadata:" + Configuration.metadata + "removetrack:" + Configuration.removetrack + "album:"
				+ Configuration.album + "wav:" + Configuration.wav + "nicetohave:" + Configuration.nicetohave
				+ "playlist:" + Configuration.playlist + "jumpposition:" + Configuration.jumpposition + "light:"
				+ Configuration.light + "openfolder:" + Configuration.openfolder + "queuetrack:"
				+ Configuration.queuetrack + "mute:" + Configuration.mute + "tageditor:" + Configuration.tageditor
				+ "tracknumber:" + Configuration.tracknumber + "progress:" + Configuration.progress + "aac:"
				+ Configuration.aac + "playlistcontrols:" + Configuration.playlistcontrols + "multipleplaylists:"
				+ Configuration.multipleplaylists + "randomcolor:" + Configuration.randomcolor + "saveandload:"
				+ Configuration.saveandload + "shufflerepeat:" + Configuration.shufflerepeat + "ogg:"
				+ Configuration.ogg + "youtube:" + Configuration.youtube + "mp3:" + Configuration.mp3 + "oscolors:"
				+ Configuration.oscolors + "reorder:" + Configuration.reorder + "cover:" + Configuration.cover
				+ "volume:" + Configuration.volume + "skins:" + Configuration.skins + "dark:" + Configuration.dark
				+ "clearplaylist:" + Configuration.clearplaylist + "remeberstatus:" + Configuration.remeberstatus
				+ "progressbar:" + Configuration.progressbar + "titlebar:" + Configuration.titlebar;
	}

}