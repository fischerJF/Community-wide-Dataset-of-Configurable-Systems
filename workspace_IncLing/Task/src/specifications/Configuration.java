package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean OBSERVER;
	public static boolean REMOVER;
	public static boolean LOGGIN;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setobserver());
		t.add(setremover());
		t.add(setloggin());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setobserver() {
		return (OBSERVER) ? "OBSERVER___" : "-OBSERVER___";
	}

	public static String setremover() {
		return (REMOVER) ? "REMOVER___" : "-REMOVER___";
	}

	public static String setloggin() {
		return (LOGGIN) ? "LOGGIN___" : "-LOGGIN___";
	}

	public static void init(String... args) {
		int index = 0;
		OBSERVER = Boolean.valueOf(args[index++]);
		REMOVER = Boolean.valueOf(args[index++]);
		LOGGIN = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("observer:" + Configuration.OBSERVER + "remover:" + Configuration.REMOVER + "loggin:"
				+ Configuration.LOGGIN);
	}

	public static String returnProduct() {
		return "observer:" + Configuration.OBSERVER + "remover:" + Configuration.REMOVER + "loggin:"
				+ Configuration.LOGGIN;
	}
}