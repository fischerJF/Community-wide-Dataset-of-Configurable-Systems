package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean LOGGING;
	public static boolean DEPOSITING;
	public static boolean WITHDRAWING;
	public static boolean BALANCE_INQUIRY;
	public static boolean ADMIN_CONTROL;
	public static boolean USER_INTERFACE;
	public static boolean WITHDRAWING_ALL_VALUES;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setlogging());
		t.add(setdepositing());
		t.add(setwithdrawing());
		t.add(setbalance_inquiry());
		t.add(setadmin_control());
		t.add(setuser_interface());
		t.add(setwithdrawing_all_values());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setlogging() {
		return (LOGGING) ? "LOGGING___" : "-LOGGING___";
	}

	public static String setdepositing() {
		return (DEPOSITING) ? "DEPOSITING___" : "-DEPOSITING___";
	}

	public static String setwithdrawing() {
		return (WITHDRAWING) ? "WITHDRAWING___" : "-WITHDRAWING___";
	}

	public static String setbalance_inquiry() {
		return (BALANCE_INQUIRY) ? "BALANCE_INQUIRY___" : "-BALANCE_INQUIRY___";
	}

	public static String setadmin_control() {
		return (ADMIN_CONTROL) ? "ADMIN_CONTROL___" : "-ADMIN_CONTROL___";
	}

	public static String setuser_interface() {
		return (USER_INTERFACE) ? "USER_INTERFACE___" : "-USER_INTERFACE___";
	}

	public static String setwithdrawing_all_values() {
		return (WITHDRAWING_ALL_VALUES) ? "WITHDRAWING_ALL_VALUES___" : "-WITHDRAWING_ALL_VALUES___";
	}

	public static void init(String... args) {
		int index = 0;
		LOGGING = Boolean.valueOf(args[index++]);
		DEPOSITING = Boolean.valueOf(args[index++]);
		WITHDRAWING = Boolean.valueOf(args[index++]);
		BALANCE_INQUIRY = Boolean.valueOf(args[index++]);
		ADMIN_CONTROL = Boolean.valueOf(args[index++]);
		USER_INTERFACE = Boolean.valueOf(args[index++]);
		WITHDRAWING_ALL_VALUES = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("LOGGING:" + Configuration.LOGGING + "DEPOSITING:" + Configuration.DEPOSITING
				+ "WITHDRAWING:" + Configuration.WITHDRAWING + "BALANCE_INQUIRY:" + Configuration.BALANCE_INQUIRY
				+ "ADMIN_CONTROL:" + Configuration.ADMIN_CONTROL + "USER_INTERFACE:" + Configuration.USER_INTERFACE
				+ "WITHDRAWING_ALL_VALUES:" + Configuration.WITHDRAWING_ALL_VALUES);
	}

	public static String returnProduct() {
		return "LOGGING:" + Configuration.LOGGING + "DEPOSITING:" + Configuration.DEPOSITING + "WITHDRAWING:"
				+ Configuration.WITHDRAWING + "BALANCE_INQUIRY:" + Configuration.BALANCE_INQUIRY + "ADMIN_CONTROL:"
				+ Configuration.ADMIN_CONTROL + "USER_INTERFACE:" + Configuration.USER_INTERFACE
				+ "WITHDRAWING_ALL_VALUES:" + Configuration.WITHDRAWING_ALL_VALUES;
	}


}