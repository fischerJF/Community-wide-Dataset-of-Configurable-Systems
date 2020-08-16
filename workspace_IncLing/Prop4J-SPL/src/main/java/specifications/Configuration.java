package specifications;

import guidsl.SATtest;
import guidsl.Tool;
import specifications.Configuration;

public class Configuration {

	public static boolean operators;
	public static boolean or;
	public static boolean negation;
	public static boolean atmost;
	public static boolean node_writer;
	public static boolean to_cnf;
	public static boolean prop4jspl;
	public static boolean extended;
	public static boolean tests;
	public static boolean equals;
	public static boolean node_reader;
	public static boolean implies;
	public static boolean atleast;
	public static boolean choose;
	public static boolean input_output;
	public static boolean and;
	public static boolean satsolver;

	public static Tool tool = new Tool("modified-model.m");
	public static boolean makeCnfFile = true;
	public static boolean compatSelections = true;

	

	public static boolean validProduct() {

		SATtest t = new SATtest("test1", compatSelections, compatSelections);

		t.add(setoperators());
		t.add(setor());
		t.add(setnegation());
		t.add(setatmost());
		t.add(setnode_writer());
		t.add(setto_cnf());
		t.add(setprop4jspl());
		t.add(setextended());
		t.add(settests());
		t.add(setequals());
		t.add(setnode_reader());
		t.add(setimplies());
		t.add(setatleast());
		t.add(setchoose());
		t.add(setinput_output());
		t.add(setand());
		t.add(setsatsolver());
		return runTest(t, makeCnfFile);
	}

	public static boolean runTest(SATtest t, boolean compat) {
		return (tool.modelDebug(t, makeCnfFile)) ? true : false;
	}

	public static String setoperators() {
		return (operators) ? "OPERATORS___" : "-OPERATORS___";
	}

	public static String setor() {
		return (or) ? "OR___" : "-OR___";
	}

	public static String setnegation() {
		return (negation) ? "NEGATION___" : "-NEGATION___";
	}

	public static String setatmost() {
		return (atmost) ? "ATMOST___" : "-ATMOST___";
	}

	public static String setnode_writer() {
		return (node_writer) ? "NODE_WRITER___" : "-NODE_WRITER___";
	}

	public static String setto_cnf() {
		return (to_cnf) ? "TO_CNF___" : "-TO_CNF___";
	}

	public static String setprop4jspl() {
		return (prop4jspl) ? "PROP4JSPL___" : "-PROP4JSPL___";
	}

	public static String setextended() {
		return (extended) ? "EXTENDED___" : "-EXTENDED___";
	}

	public static String settests() {
		return (tests) ? "TESTS___" : "-TESTS___";
	}

	public static String setequals() {
		return (equals) ? "EQUALS___" : "-EQUALS___";
	}

	public static String setnode_reader() {
		return (node_reader) ? "NODE_READER___" : "-NODE_READER___";
	}

	public static String setimplies() {
		return (implies) ? "IMPLIES___" : "-IMPLIES___";
	}

	public static String setatleast() {
		return (atleast) ? "ATLEAST___" : "-ATLEAST___";
	}

	public static String setchoose() {
		return (choose) ? "CHOOSE___" : "-CHOOSE___";
	}

	public static String setinput_output() {
		return (input_output) ? "INPUT_OUTPUT___" : "-INPUT_OUTPUT___";
	}

	public static String setand() {
		return (and) ? "AND___" : "-AND___";
	}

	public static String setsatsolver() {
		return (satsolver) ? "SATSOLVER___" : "-SATSOLVER___";
	}

	public static void init(String... args) {
		int index = 0;
		operators = Boolean.valueOf(args[index++]);
		or = Boolean.valueOf(args[index++]);
		negation = Boolean.valueOf(args[index++]);
		atmost = Boolean.valueOf(args[index++]);
		node_writer = Boolean.valueOf(args[index++]);
		to_cnf = Boolean.valueOf(args[index++]);
		prop4jspl = Boolean.valueOf(args[index++]);
		extended = Boolean.valueOf(args[index++]);
		tests = Boolean.valueOf(args[index++]);
		equals = Boolean.valueOf(args[index++]);
		node_reader = Boolean.valueOf(args[index++]);
		implies = Boolean.valueOf(args[index++]);
		atleast = Boolean.valueOf(args[index++]);
		choose = Boolean.valueOf(args[index++]);
		input_output = Boolean.valueOf(args[index++]);
		and = Boolean.valueOf(args[index++]);
		satsolver = Boolean.valueOf(args[index++]);
	}

	public static void productPrint() {
		System.out.println("operators:" + Configuration.operators + "or:" + Configuration.or + "negation:"
				+ Configuration.negation + "atmost:" + Configuration.atmost + "node_writer:" + Configuration.node_writer
				+ "to_cnf:" + Configuration.to_cnf + "prop4jspl:" + Configuration.prop4jspl + "extended:"
				+ Configuration.extended + "tests:" + Configuration.tests + "equals:" + Configuration.equals
				+ "node_reader:" + Configuration.node_reader + "implies:" + Configuration.implies + "atleast:"
				+ Configuration.atleast + "choose:" + Configuration.choose + "input_output:"
				+ Configuration.input_output + "and:" + Configuration.and + "satsolver:" + Configuration.satsolver);
	}

	public static String returnProduct() {
		return "OPERATORS:" + Configuration.operators + "OR:" + Configuration.or + "NEGATION:" + Configuration.negation
				+ "ATMOST:" + Configuration.atmost + "NODE_WRITER:" + Configuration.node_writer + "TO_CNF:"
				+ Configuration.to_cnf + "PROP4JSPL:" + Configuration.prop4jspl + "EXTENDED:" + Configuration.extended
				+ "TESTS:" + Configuration.tests + "EQUALS:" + Configuration.equals + "NODE_READER:"
				+ Configuration.node_reader + "IMPLIES:" + Configuration.implies + "ATLEAST:" + Configuration.atleast
				+ "CHOOSE:" + Configuration.choose + "INPUT_OUTPUT:" + Configuration.input_output + "AND:"
				+ Configuration.and + "SATSOLVER:" + Configuration.satsolver;
	}

}