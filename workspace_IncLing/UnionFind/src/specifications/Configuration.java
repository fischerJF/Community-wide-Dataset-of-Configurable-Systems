package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean wqu_byheight;
	public static boolean quickfind;
	public static boolean qu_weighted_modifications;
	public static boolean unionfind;
	public static boolean qu_weighted;
	public static boolean unionfindspl;
	public static boolean quickunion;
	public static boolean wqu_halfing;
	public static boolean wqu_pathcompression;
	public static boolean tests;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(settests());
		t.add(setunionfind());
		t.add(setwqu_byheight());
		t.add(setquickfind());
		t.add(setqu_weighted_modifications());
		t.add(setqu_weighted());
		t.add(setunionfindspl());
		t.add(setquickunion());
		t.add(setwqu_halfing());
		t.add(setwqu_pathcompression());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String settests() {
		return (tests) ? "TESTS___" : "-TESTS___";
	}

	public static String setunionfind() {
		return (unionfind) ? "UNIONFIND___" : "-UNIONFIND___";
	}

	public static String setwqu_byheight() {
		return (wqu_byheight) ? "WQU_BYHEIGHT___" : "-WQU_BYHEIGHT___";
	}

	public static String setquickfind() {
		return (quickfind) ? "QUICKFIND___" : "-QUICKFIND___";
	}

	public static String setqu_weighted_modifications() {
		return (qu_weighted_modifications) ? "QU_WEIGHTED_MODIFICATIONS___" : "-QU_WEIGHTED_MODIFICATIONS___";
	}

	public static String setqu_weighted() {
		return (qu_weighted) ? "QU_WEIGHTED___" : "-QU_WEIGHTED___";
	}

	public static String setunionfindspl() {
		return (unionfindspl) ? "UNIONFINDSPL___" : "-UNIONFINDSPL___";
	}

	public static String setquickunion() {
		return (quickunion) ? "QUICKUNION___" : "-QUICKUNION___";
	}

	public static String setwqu_halfing() {
		return (wqu_halfing) ? "WQU_HALFING___" : "-WQU_HALFING___";
	}

	public static String setwqu_pathcompression() {
		return (wqu_pathcompression) ? "WQU_PATHCOMPRESSION___" : "-WQU_PATHCOMPRESSION___";
	}

	public static void init(String... args) {
		int index = 0;
		tests = Boolean.valueOf(args[index++]);
		unionfind = Boolean.valueOf(args[index++]);
		wqu_byheight = Boolean.valueOf(args[index++]);
		quickfind = Boolean.valueOf(args[index++]);
		qu_weighted_modifications = Boolean.valueOf(args[index++]);
		qu_weighted = Boolean.valueOf(args[index++]);
		unionfindspl = Boolean.valueOf(args[index++]);
		quickunion = Boolean.valueOf(args[index++]);
		wqu_halfing = Boolean.valueOf(args[index++]);
		wqu_pathcompression = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("tests:" + Configuration.tests + "unionfind:" + Configuration.unionfind + "wqu_byheight:"
				+ Configuration.wqu_byheight + "quickfind:" + Configuration.quickfind + "qu_weighted_modifications:"
				+ Configuration.qu_weighted_modifications + "qu_weighted:" + Configuration.qu_weighted + "unionfindspl:"
				+ Configuration.unionfindspl + "quickunion:" + Configuration.quickunion + "wqu_halfing:"
				+ Configuration.wqu_halfing + "wqu_pathcompression:" + Configuration.wqu_pathcompression);
	}

	public static String returnProduct() {
		return "tests:" + Configuration.tests + "unionfind:" + Configuration.unionfind + "wqu_byheight:"
				+ Configuration.wqu_byheight + "quickfind:" + Configuration.quickfind + "qu_weighted_modifications:"
				+ Configuration.qu_weighted_modifications + "qu_weighted:" + Configuration.qu_weighted + "unionfindspl:"
				+ Configuration.unionfindspl + "quickunion:" + Configuration.quickunion + "wqu_halfing:"
				+ Configuration.wqu_halfing + "wqu_pathcompression:" + Configuration.wqu_pathcompression;
	}

}