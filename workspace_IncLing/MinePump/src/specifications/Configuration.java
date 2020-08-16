package specifications;
import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean base = true;
	public static boolean highWaterSensor = false;
	public static boolean lowWaterSensor = false;
	public static boolean methaneQuery = false;
	public static boolean methaneAlarm = false;
	public static boolean stopCommand = false;
	public static boolean startCommand = false;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setbase());
		t.add(sethighwatersensor());
		t.add(setlowwatersensor());
		t.add(setmethanequery());
		t.add(setmethanealarm());
		t.add(setstopcommand());
		t.add(setstartcommand());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setbase() {
		return (base) ? "BASE___" : "-BASE___";
	}

	public static String sethighwatersensor() {
		return (highWaterSensor) ? "HIGHWATERSENSOR___" : "-HIGHWATERSENSOR___";
	}

	public static String setlowwatersensor() {
		return (lowWaterSensor) ? "LOWWATERSENSOR___" : "-LOWWATERSENSOR___";
	}

	public static String setmethanequery() {
		return (methaneQuery) ? "METHANEQUERY___" : "-METHANEQUERY___";
	}

	public static String setmethanealarm() {
		return (methaneAlarm) ? "METHANEALARM___" : "-METHANEALARM___";
	}

	public static String setstopcommand() {
		return (stopCommand) ? "STOPCOMMAND___" : "-STOPCOMMAND___";
	}

	public static String setstartcommand() {
		return (startCommand) ? "STARTCOMMAND___" : "-STARTCOMMAND___";
	}

	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);
		highWaterSensor = Boolean.valueOf(args[index++]);
		lowWaterSensor = Boolean.valueOf(args[index++]);
		methaneQuery = Boolean.valueOf(args[index++]);
		methaneAlarm = Boolean.valueOf(args[index++]);
		stopCommand = Boolean.valueOf(args[index++]);
		startCommand = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("base:" + Configuration.base 
				+ " \t highwatersensor:" + Configuration.highWaterSensor
				+ "\t lowwatersensor:" + Configuration.lowWaterSensor 
				+ "\t methanequery:" + Configuration.methaneQuery
				+ "\t methanealarm:" + Configuration.methaneAlarm 
				+ "\t stopcommand:" + Configuration.stopCommand
				+ "\t startcommand:" + Configuration.startCommand);
	}

	public static String returnProduct() {
		return "base:" + Configuration.base + "highwatersensor:" + Configuration.highWaterSensor + "lowwatersensor:"
				+ Configuration.lowWaterSensor + "methanequery:" + Configuration.methaneQuery + "methanealarm:"
				+ Configuration.methaneAlarm + "stopcommand:" + Configuration.stopCommand + "startcommand:"
				+ Configuration.startCommand;
	}

}
