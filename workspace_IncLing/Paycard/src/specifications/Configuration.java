package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean logging;
	public static boolean paycard;
	public static boolean maximumrecord;
	public static boolean lockout;
	
	
	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setpaycard());
		t.add(setlogging());
		t.add(setmaximumrecord());
		t.add(setlockout());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setpaycard() {
		return (paycard) ? "PAYCARD___" : "-PAYCARD___";
	}

	public static String setlogging() {
		return (logging) ? "LOGGING___" : "-LOGGING___";
	}

	public static String setmaximumrecord() {
		return (maximumrecord) ? "MAXIMUMRECORD___" : "-MAXIMUMRECORD___";
	}

	public static String setlockout() {
		return (lockout) ? "LOCKOUT___" : "-LOCKOUT___";
	}

	public static void init(String... args) {
		int index = 0;
		paycard = Boolean.valueOf(args[index++]);
		logging = Boolean.valueOf(args[index++]);
		maximumrecord = Boolean.valueOf(args[index++]);
		lockout = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("paycard:" + Configuration.paycard + "logging:" + Configuration.logging + "maximumrecord:"
				+ Configuration.maximumrecord + "lockout:" + Configuration.lockout);
	}

	public static String returnProduct() {
		return "paycard:" + Configuration.paycard + "logging:" + Configuration.logging + "maximumrecord:"
				+ Configuration.maximumrecord + "lockout:" + Configuration.lockout;
	}

}