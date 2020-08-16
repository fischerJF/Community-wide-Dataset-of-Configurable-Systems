package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean AI_PLAYER;
	public static boolean ONLINE_PLAYER;
	public static boolean OFFLINE_PLAYER;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setai_player());
		t.add(setonline_player());
		t.add(setoffline_player());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setai_player() {
		return (AI_PLAYER) ? "AI_PLAYER___" : "-AI_PLAYER___";
	}

	public static String setonline_player() {
		return (ONLINE_PLAYER) ? "ONLINE_PLAYER___" : "-ONLINE_PLAYER___";
	}

	public static String setoffline_player() {
		return (OFFLINE_PLAYER) ? "OFFLINE_PLAYER___" : "-OFFLINE_PLAYER___";
	}

	public static void init(String... args) {
		int index = 0;
		AI_PLAYER = Boolean.valueOf(args[index++]);
		ONLINE_PLAYER = Boolean.valueOf(args[index++]);
		OFFLINE_PLAYER = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("ai_player:" + Configuration.AI_PLAYER + "online_player:" + Configuration.ONLINE_PLAYER
				+ "offline_player:" + Configuration.OFFLINE_PLAYER);
	}

	public static String returnProduct() {
		return "ai_player:" + Configuration.AI_PLAYER + "online_player:" + Configuration.ONLINE_PLAYER
				+ "offline_player:" + Configuration.OFFLINE_PLAYER;
	}

}