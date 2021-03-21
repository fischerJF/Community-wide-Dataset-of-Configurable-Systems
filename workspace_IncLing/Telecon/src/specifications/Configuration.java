package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean Telecon;
	public static boolean HISTORIC;
	public static boolean TIMING;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(settiming());
		t.add(sethistoric());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String settiming() {
		return (TIMING) ? "TIMING___" : "-TIMING___";
	}

	public static String sethistoric() {
		return (HISTORIC) ? "HISTORIC___" : "-HISTORIC___";
	}

	public static void init(String... args) {
		int index = 0;
		TIMING = Boolean.valueOf(args[index++]);
		HISTORIC = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("timing:" + Configuration.TIMING + "historic:" + Configuration.HISTORIC);
	}

	public static String returnProduct() {
		return "timing:" + Configuration.TIMING + "historic:" + Configuration.HISTORIC;
	}

}