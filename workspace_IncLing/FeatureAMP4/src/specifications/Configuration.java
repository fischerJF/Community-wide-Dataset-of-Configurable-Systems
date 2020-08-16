package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean skins;
	public static boolean player_control;
	public static boolean reorder_playlist;
	public static boolean title_time;
	public static boolean skip_track;
	public static boolean progress;
	public static boolean clear_playlist;
	public static boolean progress_bar;
	public static boolean volume_control;
	public static boolean remove_track;
	public static boolean light;
	public static boolean dark;
	public static boolean shuffle_repeat;
	public static boolean show_cover;
	public static boolean ogg;
	public static boolean mp3;
	public static boolean save_load_playlist;
	public static boolean base_featureamp;
	public static boolean load_folder;
	public static boolean queue_track;
	public static boolean file_support;
	public static boolean player_bar;
	public static boolean mute;
	public static boolean id3_title;
	public static boolean playlist;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setbase_featureamp());
		t.add(setplayer_bar());
		t.add(setid3_title());
		t.add(setprogress());
		t.add(setskins());
		t.add(setfile_support());
		t.add(setplayer_control());
		t.add(setreorder_playlist());
		t.add(settitle_time());
		t.add(setskip_track());
		t.add(setclear_playlist());
		t.add(setprogress_bar());
		t.add(setvolume_control());
		t.add(setremove_track());
		t.add(setlight());
		t.add(setdark());
		t.add(setshuffle_repeat());
		t.add(setshow_cover());
		t.add(setogg());
		t.add(setmp3());
		t.add(setsave_load_playlist());
		t.add(setload_folder());
		t.add(setqueue_track());
		t.add(setmute());
		t.add(setplaylist());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setbase_featureamp() {
		return (base_featureamp) ? "BASE_FEATUREAMP___" : "-BASE_FEATUREAMP___";
	}

	public static String setplayer_bar() {
		return (player_bar) ? "PLAYER_BAR___" : "-PLAYER_BAR___";
	}

	public static String setid3_title() {
		return (id3_title) ? "ID3_TITLE___" : "-ID3_TITLE___";
	}

	public static String setprogress() {
		return (progress) ? "PROGRESS___" : "-PROGRESS___";
	}

	public static String setskins() {
		return (skins) ? "SKINS___" : "-SKINS___";
	}

	public static String setfile_support() {
		return (file_support) ? "FILE_SUPPORT___" : "-FILE_SUPPORT___";
	}

	public static String setplayer_control() {
		return (player_control) ? "PLAYER_CONTROL___" : "-PLAYER_CONTROL___";
	}

	public static String setreorder_playlist() {
		return (reorder_playlist) ? "REORDER_PLAYLIST___" : "-REORDER_PLAYLIST___";
	}

	public static String settitle_time() {
		return (title_time) ? "TITLE_TIME___" : "-TITLE_TIME___";
	}

	public static String setskip_track() {
		return (skip_track) ? "SKIP_TRACK___" : "-SKIP_TRACK___";
	}

	public static String setclear_playlist() {
		return (clear_playlist) ? "CLEAR_PLAYLIST___" : "-CLEAR_PLAYLIST___";
	}

	public static String setprogress_bar() {
		return (progress_bar) ? "PROGRESS_BAR___" : "-PROGRESS_BAR___";
	}

	public static String setvolume_control() {
		return (volume_control) ? "VOLUME_CONTROL___" : "-VOLUME_CONTROL___";
	}

	public static String setremove_track() {
		return (remove_track) ? "REMOVE_TRACK___" : "-REMOVE_TRACK___";
	}

	public static String setlight() {
		return (light) ? "LIGHT___" : "-LIGHT___";
	}

	public static String setdark() {
		return (dark) ? "DARK___" : "-DARK___";
	}

	public static String setshuffle_repeat() {
		return (shuffle_repeat) ? "SHUFFLE_REPEAT___" : "-SHUFFLE_REPEAT___";
	}

	public static String setshow_cover() {
		return (show_cover) ? "SHOW_COVER___" : "-SHOW_COVER___";
	}

	public static String setogg() {
		return (ogg) ? "OGG___" : "-OGG___";
	}

	public static String setmp3() {
		return (mp3) ? "MP3___" : "-MP3___";
	}

	public static String setsave_load_playlist() {
		return (save_load_playlist) ? "SAVE_LOAD_PLAYLIST___" : "-SAVE_LOAD_PLAYLIST___";
	}

	public static String setload_folder() {
		return (load_folder) ? "LOAD_FOLDER___" : "-LOAD_FOLDER___";
	}

	public static String setqueue_track() {
		return (queue_track) ? "QUEUE_TRACK___" : "-QUEUE_TRACK___";
	}

	public static String setmute() {
		return (mute) ? "MUTE___" : "-MUTE___";
	}

	public static String setplaylist() {
		return (playlist) ? "PLAYLIST___" : "-PLAYLIST___";
	}

	public static void init(String... args) {
		int index = 0;
		base_featureamp = Boolean.valueOf(args[index++]);
		player_bar = Boolean.valueOf(args[index++]);
		id3_title = Boolean.valueOf(args[index++]);
		progress = Boolean.valueOf(args[index++]);
		skins = Boolean.valueOf(args[index++]);
		file_support = Boolean.valueOf(args[index++]);
		player_control = Boolean.valueOf(args[index++]);
		reorder_playlist = Boolean.valueOf(args[index++]);
		title_time = Boolean.valueOf(args[index++]);
		skip_track = Boolean.valueOf(args[index++]);
//		clear_playlist = Boolean.valueOf(args[index++]);
		progress_bar = Boolean.valueOf(args[index++]);
		volume_control = Boolean.valueOf(args[index++]);
		remove_track = Boolean.valueOf(args[index++]);
		light = Boolean.valueOf(args[index++]);
		dark = Boolean.valueOf(args[index++]);
		shuffle_repeat = Boolean.valueOf(args[index++]);
		show_cover = Boolean.valueOf(args[index++]);
		ogg = Boolean.valueOf(args[index++]);
		mp3 = Boolean.valueOf(args[index++]);
		save_load_playlist = Boolean.valueOf(args[index++]);
		load_folder = Boolean.valueOf(args[index++]);
		queue_track = Boolean.valueOf(args[index++]);
		mute = Boolean.valueOf(args[index++]);
		playlist = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("base_featureamp:" + Configuration.base_featureamp + "player_bar:" + Configuration.player_bar
				+ "id3_title:" + Configuration.id3_title + "progress:" + Configuration.progress + "skins:"
				+ Configuration.skins + "file_support:" + Configuration.file_support + "player_control:"
				+ Configuration.player_control + "reorder_playlist:" + Configuration.reorder_playlist + "title_time:"
				+ Configuration.title_time + "skip_track:" + Configuration.skip_track + "clear_playlist:"
				+ Configuration.clear_playlist + "progress_bar:" + Configuration.progress_bar + "volume_control:"
				+ Configuration.volume_control + "remove_track:" + Configuration.remove_track + "light:"
				+ Configuration.light + "dark:" + Configuration.dark + "shuffle_repeat:" + Configuration.shuffle_repeat
				+ "show_cover:" + Configuration.show_cover + "ogg:" + Configuration.ogg + "mp3:" + Configuration.mp3
				+ "save_load_playlist:" + Configuration.save_load_playlist + "load_folder:" + Configuration.load_folder
				+ "queue_track:" + Configuration.queue_track + "mute:" + Configuration.mute + "playlist:"
				+ Configuration.playlist);
	}

	public static String returnProduct() {
		return "base_featureamp:" + Configuration.base_featureamp + "player_bar:" + Configuration.player_bar
				+ "id3_title:" + Configuration.id3_title + "progress:" + Configuration.progress + "skins:"
				+ Configuration.skins + "file_support:" + Configuration.file_support + "player_control:"
				+ Configuration.player_control + "reorder_playlist:" + Configuration.reorder_playlist + "title_time:"
				+ Configuration.title_time + "skip_track:" + Configuration.skip_track + "clear_playlist:"
				+ Configuration.clear_playlist + "progress_bar:" + Configuration.progress_bar + "volume_control:"
				+ Configuration.volume_control + "remove_track:" + Configuration.remove_track + "light:"
				+ Configuration.light + "dark:" + Configuration.dark + "shuffle_repeat:" + Configuration.shuffle_repeat
				+ "show_cover:" + Configuration.show_cover + "ogg:" + Configuration.ogg + "mp3:" + Configuration.mp3
				+ "save_load_playlist:" + Configuration.save_load_playlist + "load_folder:" + Configuration.load_folder
				+ "queue_track:" + Configuration.queue_track + "mute:" + Configuration.mute + "playlist:"
				+ Configuration.playlist;
	}

}