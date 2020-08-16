package specifications;

import guidsl.SATtest;
import guidsl.Tool;
import specifications.Configuration;

public class Configuration {

	public static boolean tree;
	public static boolean integerset;
	public static boolean hashset;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(settree());
		t.add(setintegerset());
		t.add(sethashset());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String settree() {
		return (tree) ? "TREE___" : "-TREE___";
	}

	public static String setintegerset() {
		return (integerset) ? "INTEGERSET___" : "-INTEGERSET___";
	}

	public static String sethashset() {
		return (hashset) ? "HASHSET___" : "-HASHSET___";
	}

	public static void init(String... args) {
		int index = 0;
		tree = Boolean.valueOf(args[index++]);
		integerset = Boolean.valueOf(args[index++]);
		hashset = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("tree:" + Configuration.tree + "integerset:" + Configuration.integerset + "hashset:"
				+ Configuration.hashset);
	}

	public static String returnProduct() {
		return "tree:" + Configuration.tree + "integerset:" + Configuration.integerset + "hashset:"
				+ Configuration.hashset;
	}

}