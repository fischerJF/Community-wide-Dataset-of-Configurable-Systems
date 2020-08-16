package specifications;

import guidsl.Tool;
import guidsl.SATtest;

public class Configuration {

	public static boolean base = true;
	public static boolean coinValidation = false;
	public static boolean availability = false;
	public static boolean terminal = false;
	public static boolean keyboard = false;
	public static boolean showStock = false;
	public static boolean flexiblequantity = false;
	public static boolean totalValueCollected = false;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setbase());
		t.add(setcoinvalidation());
		t.add(setavailability());
		t.add(setterminal());
		t.add(setkeyboard());
		t.add(setshowstock());
		t.add(setflexiblequantity());
		t.add(settotalvaluecollected());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
	}

	public static String setcoinvalidation() {
		return (coinValidation) ? "COINVALIDATION___" : "-COINVALIDATION___";
	}

	public static String setavailability() {
		return (availability) ? "AVAILABILITY___" : "-AVAILABILITY___";
	}

	public static String setterminal() {
		return (terminal) ? "TERMINAL___" : "-TERMINAL___";
	}

	public static String setkeyboard() {
		return (keyboard) ? "KEYBOARD___" : "-KEYBOARD___";
	}

	public static String setshowstock() {
		return (showStock) ? "SHOWSTOCK___" : "-SHOWSTOCK___";
	}

	public static String setflexiblequantity() {
		return (flexiblequantity) ? "FLEXIBLEQUANTITY___" : "-FLEXIBLEQUANTITY___";
	}

	public static String settotalvaluecollected() {
		return (totalValueCollected) ? "TOTALVALUECOLLECTED___" : "-TOTALVALUECOLLECTED___";
	}

	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);
		coinValidation = Boolean.valueOf(args[index++]);
		availability = Boolean.valueOf(args[index++]);
		terminal = Boolean.valueOf(args[index++]);
		keyboard = Boolean.valueOf(args[index++]);
		showStock = Boolean.valueOf(args[index++]);
		flexiblequantity = Boolean.valueOf(args[index++]);
		totalValueCollected = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("base:" + Configuration.base + "coinvalidation:" + Configuration.coinValidation
				+ "availability:" + Configuration.availability + "terminal:" + Configuration.terminal + "keyboard:"
				+ Configuration.keyboard + "showstock:" + Configuration.showStock + "flexiblequantity:"
				+ Configuration.flexiblequantity + "totalvaluecollected:" + Configuration.totalValueCollected);
	}

	public static String returnProduct() {
		return "base:" + Configuration.base + "coinvalidation:" + Configuration.coinValidation + "availability:"
				+ Configuration.availability + "terminal:" + Configuration.terminal + "keyboard:"
				+ Configuration.keyboard + "showstock:" + Configuration.showStock + "flexiblequantity:"
				+ Configuration.flexiblequantity + "totalvaluecollected:" + Configuration.totalValueCollected;
	}

}