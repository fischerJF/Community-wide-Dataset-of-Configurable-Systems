package metricasFeatures;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SplatOutput.ReadFile;
import SplatOutput.TargetSystem;
import metricasFeatures.Feature;
import report.Record;
import report.RunReport;

public class variabilityCount {
	static int cont = 0;
	static String nomeClasse = "";
	public static ArrayList<Feature> features = new ArrayList<Feature>();
	public static ArrayList<Feature> featuresAux = new ArrayList<Feature>();
	public static ArrayList<Feature> espalhamento = new ArrayList<Feature>();

	public static ArrayList<M_Classes> metricas = new ArrayList<M_Classes>();
	static Record record = new Record();

	public static void inicialization(TargetSystem t) {

		// ATM
		if (t == TargetSystem.ATM) {
			features.add(new Feature("ADMIN_CONTROL", 1, 0, 1, 54, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("BALANCE_INQUIRY", 3, 1, 20, 243, 7, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DEPOSITING", 3, 1, 17, 264, 7, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("LOGGING", 1, 0, 2, 71, 8, 4, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("USER_INTERFACE", 3, 3, 24, 237, 12, 4, 3, 1, 0, 0, 1, 0, 1));
			features.add(new Feature("WITHDRAWING", 1, 0, 4, 89, 7, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("WITHDRAWING_ALL_VALUES", 1, 0, 1, 123, 2, 1, 2, 0, 0, 0, 1, 0, 1));
		}

		// BANKACCOUNT
		else if (t == TargetSystem.BANKACCOUNT) {
			features.add(new Feature("bankaccount", 4, 2, 21, 210, 2, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("creditworthiness", 1, 0, 2, 16, 2, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("dailylimit", 2, 0, 4, 57, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("interest", 2, 0, 3, 38, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("interestestimation", 1, 0, 1, 11, 0, 0, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("lock", 1, 0, 3, 26, 0, 0, 2, 0, 0, 0, 1, 0, 1));
			// features.add(new Feature("logging", 1, 1, 0, 3, 1, 1, 0, 0, 0));
			features.add(new Feature("overdraft", 1, 0, 0, 6, 0, 0, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("transaction", 1, 0, 2, 41, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("transactionlog", 1, 0, 1, 4, 1, 1, 2, 0, 0, 0, 1, 0, 1));

		}
		// companies
		else if (t == TargetSystem.COMPANIES) {
			features.add(new Feature("CUT_NO_DEPARTMENT", 29, 11, 59, 1527, 31, 17, 3, 3, 0, 0, 1, 0, 1));
			features.add(new Feature("CUT_NO_MANAGER", 29, 8, 46, 1345, 31, 17, 3, 3, 0, 0, 1, 0, 1));
			features.add(new Feature("CUT_WHATEVER", 29, 9, 49, 1399, 31, 17, 3, 3, 0, 0, 1, 0, 1));
			features.add(new Feature("GUI", 7, 5, 33, 492, 48, 9, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("LOGGING", 4, 1, 8, 187, 9, 4, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("PRECEDENCE", 4, 1, 9, 186, 13, 4, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("TOTAL_REDUCER", 16, 5, 23, 1000, 31, 17, 3, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("TOTAL_WALKER", 16, 5, 32, 1119, 31, 17, 3, 2, 0, 0, 1, 0, 1));

		}

		// chess
		else if (t == TargetSystem.CHESS) {
			features.add(new Feature("AI_PLAYER", 4, 4, 38, 690, 10, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("ONLINE_PLAYER", 3, 3, 38, 663, 5, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("OFFLINE_PLAYER", 3, 3, 38, 665, 5, 2, 2, 0, 0, 0, 1, 0, 1));
		}

		// FeatureAMP1
		else if (t == TargetSystem.FeatureAMP1) {

			features.add(new Feature("clearplaylist", 1, 0, 2, 28, 1, 1, 7, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("dark", 1, 0, 1, 14, 1, 1, 5, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("light", 1, 0, 1, 12, 1, 1, 5, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("loadfolder", 1, 0, 2, 53, 1, 1, 5, 0, 0, 0, 0, 0, 1));
			features.add(new Feature("mp3", 3, 1, 9, 126, 3, 3, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("mute", 1, 0, 2, 30, 1, 1, 5, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("playlist", 3, 1, 13, 163, 4, 2, 4, 0, 0, 3, 1, 1, 0));
			features.add(new Feature("progressbar", 1, 0, 2, 24, 2, 1, 5, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("queuetrack", 2, 0, 5, 89, 4, 2, 5, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("removetrack", 1, 0, 2, 36, 1, 1, 6, 0, 4, 1, 1, 1, 0));
			features.add(new Feature("reorderplaylist", 1, 0, 2, 51, 1, 1, 6, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("resizable", 1, 0, 1, 8, 1, 1, 4, 0, 0, 0, 0, 0, 1));
			features.add(new Feature("saveandloadplaylist", 1, 0, 2, 115, 1, 1, 5, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("showcover", 1, 0, 3, 39, 2, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("showtime", 1, 0, 2, 22, 2, 1, 5, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("shufflerepeat", 3, 1, 5, 132, 3, 3, 6, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("skiptrack", 1, 0, 2, 26, 1, 1, 6, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("volumecontrol", 2, 1, 6, 70, 3, 2, 4, 0, 0, 1, 1, 1, 0));
			features.add(new Feature("wav", 4, 1, 10, 112, 4, 4, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("control", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("featureamp", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("gui", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("id3information", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("openfile", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("skins", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("supportedformats", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
			features.add(new Feature("time", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));

		}

		// mine
		else if (t == TargetSystem.MINE) {

			features.add(new Feature("highWaterSensor", 2, 0, 3, 27, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("lowWaterSensor", 2, 0, 3, 26, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("methaneQuery", 1, 0, 1, 13, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("methaneAlarm", 1, 0, 1, 13, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("stopCommand", 2, 0, 2, 21, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("startCommand", 2, 2, 2, 2, 0, 2, 12, 0, 2, 0, 1, 0, 1));
		}

		// GPL
		else if (t == TargetSystem.GPL) {
			features.add(new Feature("BFS", 2, 0, 1, 6, 2, 0, 6, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("CONNECTED", 3, 1, 5, 18, 6, 0, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("CYCLE", 3, 1, 7, 56, 8, 1, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("DIRECTED", 1, 0, 1, 5, 1, 1, 4, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("MSTKRUSKAL", 3, 1, 3, 198, 4, 1, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("MSTPRIM", 2, 0, 3, 200, 3, 1, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("NUMBER", 3, 1, 4, 19, 5, 0, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("SEARCH", 2, 0, 6, 77, 6, 1, 5, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("SHORTEST", 2, 0, 3, 183, 3, 0, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("STRONGLYCONNECTED", 4, 2, 7, 66, 9, 0, 4, 0, 7, 0, 1, 0, 1));
			features.add(new Feature("UNDIRECTED", 2, 0, 3, 11, 3, 0, 4, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("WEIGHTED", 2, 0, 8, 54, 9, 1, 3, 0, 0, 0, 1, 0, 1));
		}

		// sudoku
		else if (t == TargetSystem.SUDOKU) {

			features.add(new Feature("BASE", 12, 11, 73, 933, 2, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("STATES", 1, 3, 0, 48, 3, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("UNDO", 2, 0, 2, 45, 2, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("COLOR", 5, 1, 7, 195, 8, 5, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("SOLVER", 7, 4, 19, 467, 23, 7, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("GENERATOR", 4, 1, 13, 236, 13, 4, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("EXTENDEDSUDOKU", 2, 0, 2, 44, 2, 2, 2, 0, 0, 0, 1, 0, 1));

		}
		// PAYCARD
		else if (t == TargetSystem.PAYCARD) {
			ArrayList<CMF> cmf = new ArrayList<CMF>();
			cmf.add(new CMF("Paycard/LogRecord.java", 1, 6, 1, 0, 0, 2, 4, 4, 0, 4, 0, 1, 0, 37));
			cmf.add(new CMF("Paycard/LogFile.java", 1, 5, 1, 0, 1, 0, 2, 2, 0, 3, 0, 1, 0, 28));
			cmf.add(new CMF("Paycard/PayCard.java", 1, 5, 1, 0, 1, 0, 2, 2, 0, 3, 0, 1, 0, 28));
			features.add(new Feature("logging", cmf, 3, 2, 5, 94, 3, 3, 2, 2, 33.33));

			ArrayList<CMF> cmf1 = new ArrayList<CMF>();
			cmf1.add(new CMF("Paycard/IssueCardUI.java", 2, 16, 1, 0, 28, 21, 5, 5, 0, 17, 0, 3, 3, 114));
			cmf1.add(new CMF("Paycard/CardException.java", 0, 1, 3, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 5));
			cmf1.add(new CMF("Paycard/ChargeUI.java", 1, 18, 1, 0, 31, 28, 5, 4, 0, 13, 0, 0, 5, 103));
			cmf1.add(new CMF("Paycard/PayCard.java", 1, 11, 1, 0, 2, 9, 7, 7, 1, 3, 0, 0, 0, 74));
			cmf1.add(new CMF("Paycard/Start.java", 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 10));
			features.add(new Feature("paycard", cmf1, 6, 5, 16, 339, 5, 4, 1, 3, 50.00));

			ArrayList<CMF> cmf2 = new ArrayList<CMF>();
			cmf2.add(new CMF("Paycard/LogFile.java", 1, 4, 1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 24));
			features.add(new Feature("maximumrecord", cmf2, 1, 0, 1, 8, 1, 1, 3, 1, 16.66));

			ArrayList<CMF> cmf3 = new ArrayList<CMF>();
			cmf3.add(new CMF("Paycard/PayCard.java", 0, 6, 1, 0, 1, 0, 2, 2, 0, 1, 0, 0, 0, 28));
			features.add(new Feature("lockout", cmf3, 1, 0, 2, 33, 2, 1, 2, 3, 50.00));
		}
		/* Jtopas */
		if (t == TargetSystem.jTOPAS) {
			features.add(new Feature("BLOCKCOMMENTS", 1, 0, 1, 337, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("COUNTLINES", 1, 0, 5, 396, 4, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("IMAGEPARTS", 2, 0, 4, 530, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("LINECOMMENTS", 4, 4, 13, 714, 2, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("TOKENPOSONLY", 4, 4, 13, 714, 2, 1, 2, 0, 0, 0, 1, 0, 1));
		}
		// NOTEPAD
		else if (t == TargetSystem.NOTEPAD) {
			features.add(new Feature("BASEMENUBAR", 1, 0, 1, 37, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("BASETOOLBAR", 1, 0, 1, 39, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("EDITMENUBAR", 1, 0, 2, 104, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("EDITTOOLBAR", 1, 0, 2, 78, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("FORMATMENUBAR", 1, 0, 2, 103, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("FORMATTOOLBAR", 1, 0, 2, 79, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("PERSISTENCEMENUBAR", 2, 0, 4, 285, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("PERSISTENCETOOLBAR", 2, 0, 4, 265, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("PRINTMENUBAR", 1, 0, 2, 105, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("PRINTTOOLBAR", 1, 0, 2, 80, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("SEARCHMENUBAR", 1, 0, 2, 108, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("SEARCHTOOLBAR", 1, 0, 2, 80, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("UNDOREDOMENUBAR", 1, 0, 3, 99, 3, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("UNDOREDOTOOLBAR", 1, 0, 3, 82, 3, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("WORDCOUNTMENUBAR", 1, 0, 2, 104, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("WORDCOUNTTOOLBAR", 1, 0, 2, 77, 1, 1, 2, 0, 0, 0, 1, 0, 1));
		}
		// Prop4j
		else if (t == TargetSystem.PROP4J) {
			features.add(new Feature("and", 1, 2, 4, 58, 2, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("atleast", 1, 2, 2, 38, 2, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("atmost", 1, 2, 2, 38, 2, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("choose", 1, 2, 2, 37, 2, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("equals", 1, 1, 2, 28, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("implies", 1, 1, 3, 36, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("negation", 1, 1, 2, 61, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("node_reader", 1, 1, 14, 401, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("operators", 2, 2, 22, 240, 2, 1, 2, 0, 0, 5, 1, 1, 0));
			features.add(new Feature("or", 1, 2, 9, 161, 2, 1, 3, 0, 0, 0, 1, 1, 0));
			features.add(new Feature("satsolver", 1, 1, 13, 305, 1, 1, 2, 0, 0, 0, 1, 0, 1));
		}

		// set
		else if (t == TargetSystem.SET) {
			features.add(new Feature("tree"));
			features.add(new Feature("integerset"));
			features.add(new Feature("hashset"));
		}

		// TASK
		else if (t == TargetSystem.TASK) {
			features.add(new Feature("OBSERVER", 10, 6, 26, 347, 8, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("REMOVER", 1, 0, 1, 25, 1, 1, 2, 0, 0, 0, 1, 0, 1));
		}

		// Telecon
		else if (t == TargetSystem.TELECOM) {
			features.add(new Feature("HISTORIC", 9, 5, 36, 466, 6, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("TIMING"));
		}

		// Union
		else if (t == TargetSystem.UNIONFIND) {
			features.add(new Feature("qu_weighted", 1, 1, 1, 32, 2, 1, 4, 0, 0, 4, 1, 1, 0));
			features.add(new Feature("quickfind", 1, 0, 2, 34, 2, 1, 3, 0, 0, 7, 1, 1, 0));
			features.add(new Feature("quickunion", 1, 0, 3, 39, 2, 1, 3, 2, 0, 6, 1, 1, 0));
			features.add(new Feature("tests", 3, 1, 11, 114, 1, 1, 2, 0, 0, 0, 0, 0, 1));
			features.add(new Feature("unionfind", 1, 1, 4, 72, 1, 1, 2, 0, 0, 8, 0, 1, 0));
			features.add(new Feature("wqu_byheight", 1, 1, 2, 44, 2, 1, 6, 3, 0, 0, 1, 0, 1));
			features.add(new Feature("wqu_halfing", 1, 0, 1, 17, 1, 1, 6, 3, 0, 0, 1, 0, 1));
			features.add(new Feature("wqu_pathcompression", 1, 0, 1, 26, 1, 1, 6, 3, 0, 0, 1, 0, 1));
		}

		// vending
		else if (t == TargetSystem.VENDING) {
			features.add(new Feature("coinValidation", 1, 0, 1, 15, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("flexiblequantity", 1, 1, 0, 21, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("keyboard", 1, 0, 1, 20, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("showStock", 2, 1, 7, 130, 1, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("terminal", 1, 0, 1, 23, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("totalValueCollected", 1, 0, 1, 71, 2, 1, 3, 0, 0, 0, 1, 0, 1));
		}
		/* Zipme */
		else if (t == TargetSystem.ZIPME) {
			features.add(new Feature("ADLER32CHECKSUM", 2, 1, 11, 279, 12, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("ARCHIVECHECK", 1, 0, 2, 58, 2, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("BASE", 32, 42, 244, 4612, 187, 20, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("COMPRESS", 5, 3, 54, 1456, 65, 5, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("CRC", 1, 0, 6, 99, 6, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_COMPRESS_ADLER32CHECKSUM", 3, 0, 9, 82, 9, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_COMPRESS_CRC", 1, 0, 3, 47, 3, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_COMPRESS_GZIP", 2, 2, 3, 92, 10, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_COMPRESS_GZIPCRC", 2, 0, 3, 61, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_EXTRACT_CRC", 1, 0, 7, 81, 7, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DERIVATIVE_GZIPCRC", 1, 0, 6, 58, 6, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("EXTRACT", 2, 0, 15, 373, 21, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("GZIP", 1, 1, 3, 223, 12, 1, 2, 0, 0, 0, 1, 0, 1));
		}
		// elevator
		else if (t == TargetSystem.ELEVATOR) {
			features.add(new Feature("empty", 4, 1, 8, 111, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("executivefloor", 1, 0, 5, 46, 2, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("overloaded", 1, 0, 2, 37, 2, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("twothirdsfull", 1, 0, 4, 52, 2, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("weight", 1, 0, 2, 22, 2, 1, 2, 0, 0, 0, 1, 0, 1));
		}

		// email
		else if (t == TargetSystem.EMAIL) {
			features.add(new Feature("ADDRESSBOOK", 2, 1, 6, 82, 3, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("AUTORESPONDER", 1, 0, 4, 31, 3, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("DECRYPT", 1, 0, 1, 29, 1, 1, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("ENCRYPT", 2, 0, 9, 97, 4, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("FORWARD", 1, 0, 4, 29, 2, 2, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("SIGN", 2, 0, 9, 71, 3, 3, 2, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("VERIFY", 2, 0, 6, 45, 3, 3, 2, 0, 0, 0, 1, 0, 1));
		}

		// FeatureAMP2
		else if (t == TargetSystem.FeatureAMP2) {
			features.add(new Feature("clearplaylist", 1, 0, 3, 38, 2, 1, 6, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("darkskin", 1, 0, 1, 16, 1, 1, 4, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("gui", 12, 13, 63, 1206, 13, 7, 2, 0, 0, 19, 0, 1, 0));
			features.add(new Feature("lightskin", 1, 0, 1, 16, 1, 1, 4, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("loadfolder", 1, 0, 3, 69, 1, 1, 4, 0, 0, 0, 0, 0, 1));
			features.add(new Feature("mp3", 2, 2, 15, 249, 3, 2, 3, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("mute", 1, 0, 3, 40, 2, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("ogg", 2, 2, 15, 234, 3, 2, 3, 2, 0, 0, 1, 0, 1));
			features.add(new Feature("playlist", 3, 1, 24, 321, 5, 2, 3, 0, 0, 1, 1, 1, 0));
			features.add(new Feature("progressbar", 1, 0, 4, 37, 4, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("queuetrack", 2, 0, 10, 168, 5, 2, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("removetrack", 1, 0, 3, 49, 2, 1, 5, 0, 4, 1, 1, 1, 0));
			features.add(new Feature("reorderplaylist", 1, 0, 3, 66, 2, 1, 5, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("saveandloadplaylist", 1, 0, 5, 121, 1, 1, 4, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("showcover", 1, 0, 3, 30, 3, 1, 3, 0, 0, 0, 1, 0, 1));
			features.add(new Feature("showtime", 1, 0, 1, 16, 1, 1, 4, 0, 2, 0, 1, 0, 1));
			features.add(new Feature("shufflerepeat", 1, 0, 4, 56, 2, 1, 5, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("skiptrack", 1, 0, 3, 51, 2, 1, 5, 0, 4, 0, 1, 0, 1));
			features.add(new Feature("volumecontrol", 1, 0, 5, 43, 2, 1, 3, 0, 0, 1, 1, 0, 1));
		}

		// FeatureAMP3
		else if (t == TargetSystem.FeatureAMP3) {
			features.add(new Feature("base",7,2,41,534,2,2,2,0,0,0,0,0,1));
			features.add(new Feature("changelistener",1,0,1,11,0,0,3,0,0,0,1,0,1));
			features.add(new Feature("clearplaylist",1,1,2,30,3,1,6,0,0,0,1,0,1));
			features.add(new Feature("dark",1,1,0,13,1,1,4,0,2,0,1,0,1));
			features.add(new Feature("gui",6,9,30,595,10,5,2,0,0,26,0,1,0));
			features.add(new Feature("light",1,1,1,19,2,1,4,0,2,0,1,0,1));
			features.add(new Feature("loadfolder",1,1,2,42,3,1,4,0,0,0,1,0,1));
			features.add(new Feature("mp3",3,1,14,208,3,3,3,0,4,0,1,0,1));
			features.add(new Feature("multipleplaylists",1,1,2,40,3,1,4,0,0,0,1,0,1));
			features.add(new Feature("mute",1,1,4,72,5,1,4,0,0,0,1,0,1));
			features.add(new Feature("ogg",3,1,14,199,3,3,3,0,4,0,1,0,1));
			features.add(new Feature("playlist",2,2,28,282,8,2,3,0,0,14,1,1,0));
			features.add(new Feature("playlistcontextmenu",1,1,2,41,2,1,4,0,0,0,1,0,1));
			features.add(new Feature("playlistmenu",1,0,2,18,1,1,3,0,0,0,1,0,1));
			features.add(new Feature("playlisttabs",1,1,4,60,3,1,4,0,0,0,1,0,1));
			features.add(new Feature("progressbar",1,0,6,74,6,1,4,0,2,0,1,0,1));
			features.add(new Feature("queuetrack",1,1,5,116,5,1,4,0,0,0,1,0,1));
			features.add(new Feature("removetrack",1,1,4,54,4,1,5,0,4,0,1,1,0));
			features.add(new Feature("reorderplaylist",3,1,7,121,2,2,5,0,4,0,1,0,1));
			features.add(new Feature("saveandloadplaylist",1,1,5,123,3,1,4,0,0,0,1,0,1));
			features.add(new Feature("showcover",1,1,2,66,3,1,3,0,0,0,1,0,1));
			features.add(new Feature("showtime",1,0,1,13,1,1,4,0,2,0,1,0,1));
			features.add(new Feature("shufflerepeat",2,1,6,141,5,1,5,0,4,0,1,0,1));
			features.add(new Feature("skiptrack",1,1,2,38,3,1,5,0,4,0,1,0,1));
			features.add(new Feature("tageditor",1,1,1,51,2,1,4,0,0,0,0,0,1));
			features.add(new Feature("volumecontrol",1,1,4,55,4,1,3,0,0,1,1,1,0));
			features.add(new Feature("wav",3,1,14,190,3,3,3,0,4,0,1,0,1));
		}
		//FeatureAMP4
		else if (t == TargetSystem.FeatureAMP4) {
			features.add(new Feature("base_featureamp",11,4,55,549,4,4,1,0,0,24,1,1,0));
			features.add(new Feature("clear_playlist",2,0,2,39,1,1,5,0,0,0,1,0,1));
			features.add(new Feature("dark",1,0,1,17,1,1,3,2,0,0,1,0,1));
			features.add(new Feature("id3_title",2,0,2,26,1,1,2,0,0,0,0,0,1));
			features.add(new Feature("light",1,0,1,17,1,1,3,2,0,0,1,0,1));
			features.add(new Feature("load_folder",2,0,2,73,1,1,3,0,0,0,0,0,1));
			features.add(new Feature("mp3",3,2,16,234,5,3,3,0,2,0,1,0,1));
			features.add(new Feature("mute",2,0,3,47,2,1,3,0,0,0,1,0,1));
			features.add(new Feature("ogg",3,2,16,234,5,3,3,0,2,0,1,0,1));
			features.add(new Feature("player_bar",9,1,11,154,3,2,2,0,0,0,0,0,1));
			features.add(new Feature("player_control",2,1,5,47,3,2,3,0,0,5,0,1,0));
			features.add(new Feature("playlist",2,1,5,47,3,2,3,0,0,5,0,1,0));
			features.add(new Feature("progress",9,2,29,315,6,4,2,0,0,9,0,1,0));
			features.add(new Feature("progress_bar",4,1,5,59,3,2,3,0,2,0,1,0,1));
			features.add(new Feature("queue_track",7,1,16,206,9,4,3,0,0,0,1,0,1));
			features.add(new Feature("remove_track",2,0,3,73,1,1,4,0,4,1,1,1,0));
			features.add(new Feature("reorder_playlist",3,0,4,90,1,1,4,0,4,0,1,0,1));
			features.add(new Feature("save_load_playlist",3,0,3,120,1,1,3,0,0,0,1,0,1));
			features.add(new Feature("show_cover",3,1,4,80,3,2,2,0,0,0,1,0,1));
			features.add(new Feature("shuffle_repeat",5,0,8,121,1,1,2,0,4,0,1,0,1));
			features.add(new Feature("skip_track",2,0,2,47,1,1,4,0,4,0,1,0,1));
			features.add(new Feature("title_time",3,0,3,37,1,1,3,0,2,0,1,0,1));
			features.add(new Feature("volume_control",5,1,9,127,3,2,2,0,0,1,0,0,1));	
		}
		//FeatureAMP5
		else if (t == TargetSystem.FeatureAMP5) {
			features.add(new Feature("base",6,5,33,443,1,1,2,0,0,24,1,1,0));
			features.add(new Feature("clearplaylist",1,0,3,28,1,1,7,0,0,0,1,0,0));
			features.add(new Feature("dark",1,0,1,8,1,1,5,2,0,0,1,0,1));
			features.add(new Feature("light",1,0,1,8,1,1,5,2,0,0,1,0,1));
			features.add(new Feature("mp3",2,0,2,64,1,1,4,0,2,1,0,0,1));
			features.add(new Feature("mute",2,1,6,66,3,2,5,0,0,0,1,0,1));
			features.add(new Feature("playlist",4,1,25,259,6,1,4,0,0,11,1,1,0));
			features.add(new Feature("progressbar",1,0,2,23,2,1,5,2,0,0,1,0,1));
			features.add(new Feature("queueremove",1,0,1,8,1,1,6,0,0,0,1,0,1));
			features.add(new Feature("queuetrack",3,0,8,88,3,3,5,0,0,1,1,0,1));
			features.add(new Feature("removetrack",2,0,5,57,1,1,6,0,4,0,1,0,1));
			features.add(new Feature("reorderplaylist",2,0,5,72,1,1,6,0,4,0,1,0,1));
			features.add(new Feature("saveandloadplaylist",2,0,4,107,1,1,5,0,0,0,1,0,1));
			features.add(new Feature("showcover",3,0,6,98,3,2,5,0,0,0,1,0,1));
			features.add(new Feature("showtime",1,0,2,17,1,1,5,2,0,0,1,0,1));
			features.add(new Feature("shufflerepeat",3,0,8,128,3,2,6,0,4,0,1,0,1));
			features.add(new Feature("skiprepeat",1,0,1,8,1,1,7,0,0,0,1,0,1));
			features.add(new Feature("skiptrack",1,0,3,23,1,1,6,0,4,0,1,0,1));
			features.add(new Feature("volumecontrol",2,1,8,101,3,2,4,0,0,1,1,1,0));
			features.add(new Feature("wave",2,0,1,46,1,1,4,0,2,1,0,0,1));
		}
		//FeatureAMP6
		
		else if (t == TargetSystem.FeatureAMP6) {
			features.add(new Feature("aac",2,1,2,69,3,2,3,0,5,0,1,0,1));
			features.add(new Feature("album",4,0,6,70,4,2,4,0,3,0,1,0,1));
			features.add(new Feature("base",19,14,76,1286,14,12,2,0,0,0,0,0,1));
			features.add(new Feature("clearplaylist",2,0,3,61,1,1,5,0,0,0,1,0,1));
			features.add(new Feature("cover",3,0,3,46,2,1,4,0,3,0,1,0,1));
			features.add(new Feature("jumpposition",3,0,6,74,1,1,5,0,0,0,1,0,1));
			features.add(new Feature("mp3",2,1,3,80,3,2,3,0,5,0,1,0,1));
			features.add(new Feature("mute",1,0,2,48,1,1,4,0,0,0,1,0,1));
			features.add(new Feature("ogg",2,1,2,69,3,2,3,0,5,0,1,0,1));
			features.add(new Feature("openfolder",2,0,6,85,1,1,3,0,0,0,0,0,1));
			features.add(new Feature("playlist",7,3,31,451,8,5,2,0,0,12,0,1,0));
			features.add(new Feature("progressbar",2,1,4,86,3,1,4,0,2,1,1,1,0));
			features.add(new Feature("queuetrack",3,0,14,195,5,2,3,0,0,0,1,0,1));
			features.add(new Feature("removetrack",5,0,5,113,1,1,4,0,4,1,1,1,0));
			features.add(new Feature("reorder",3,1,7,124,2,2,4,0,4,0,1,0,1));
			features.add(new Feature("saveandload",5,0,12,217,1,1,3,0,0,0,1,0,1));
			features.add(new Feature("shufflerepeat",2,0,6,141,4,2,4,0,4,0,1,0,1));
			features.add(new Feature("skiptrack",5,0,13,162,9,3,4,0,4,0,1,0,1));
			features.add(new Feature("titlebar",2,0,4,70,2,1,4,0,2,0,1,0,1));
			features.add(new Feature("tracknumber",4,0,6,69,4,2,4,0,3,0,1,0,1));
			features.add(new Feature("volume",3,0,11,142,1,1,3,0,0,1,1,1,0));
			features.add(new Feature("wav",2,1,2,45,3,2,3,0,5,0,1,0,1));
		}
		
		//FeatureAMP7
		else if (t == TargetSystem.FeatureAMP7) {
			features.add(new Feature("clearplaylist",1,0,2,31,1,1,6,0,0,0,1,0,1));
			features.add(new Feature("gui",5,2,46,467,2,2,2,0,0,20,0,1,0));
			features.add(new Feature("loadfolder",3,1,6,114,2,2,4,0,0,0,0,0,1));
			features.add(new Feature("mp3player",16,11,97,4256,11,8,3,0,2,3,1,1,0));
			features.add(new Feature("mute",2,1,3,77,2,2,4,0,0,0,1,0,1));
			features.add(new Feature("openfile",2,1,16,140,1,1,3,0,0,0,0,0,1));
			features.add(new Feature("openmp3file",1,1,5,268,4,1,4,0,0,0,0,0,1));
			features.add(new Feature("openwavfile",1,1,4,166,4,1,4,0,0,0,0,0,1));
			features.add(new Feature("playlist",7,3,30,370,4,4,3,0,0,9,1,1,0));
			features.add(new Feature("progressbar",4,2,8,129,3,3,4,0,2,0,1,0,1));
			features.add(new Feature("queuetrack",4,2,9,190,4,4,4,0,0,0,1,0,1));
			features.add(new Feature("removetrack",1,0,2,44,1,1,5,0,4,1,1,1,0));
			features.add(new Feature("reorderplaylist",1,0,3,94,1,1,5,0,4,0,1,0,1));
			features.add(new Feature("saveandloadplaylist",3,2,3,158,3,3,4,0,0,0,1,0,1));
			features.add(new Feature("showcover",3,2,6,129,3,3,4,0,0,0,1,0,1));
			features.add(new Feature("showtime",2,0,2,27,1,1,4,0,2,0,1,0,1));
			features.add(new Feature("showtitle",2,0,2,27,1,1,4,0,0,0,1,0,1));
			features.add(new Feature("shufflerepeat",2,1,4,121,2,1,5,0,4,0,1,0,1));
			features.add(new Feature("skiptrack",1,0,2,20,1,1,5,0,4,0,1,0,1));
			features.add(new Feature("time",2,2,5,102,2,2,3,0,0,2,0,1,0));
			features.add(new Feature("volumecontrol",3,2,10,218,3,3,3,0,0,1,0,1,0));
			features.add(new Feature("wavplayer",1,1,8,190,1,1,3,0,2,1,1,1,0));
		}
		
		//FeatureAMP8
		else if (t == TargetSystem.FeatureAMP8) {
			features.add(new Feature("choosefile",1,0,3,124,1,1,2,0,0,4,1,1,0));
			features.add(new Feature("clearplaylist",1,0,2,37,1,1,6,0,0,0,1,0,1));
			features.add(new Feature("dark",1,0,1,13,1,1,4,2,0,0,1,0,1));
			features.add(new Feature("featureamp",4,4,50,480,4,4,1,0,0,26,0,1,0));
			features.add(new Feature("gui",1,0,1,13,1,1,2,0,0,19,0,1,0));
			features.add(new Feature("light",1,0,1,13,1,1,4,2,0,0,1,0,1));
			features.add(new Feature("loadfolder",1,0,3,119,1,1,4,0,0,0,1,0,1));
			features.add(new Feature("mp3",1,0,1,13,1,1,4,0,3,0,1,0,1));
			features.add(new Feature("mute",1,0,2,48,1,1,4,0,0,0,1,0,1));
			features.add(new Feature("ogg",1,0,1,13,1,1,4,0,3,0,1,0,1));
			features.add(new Feature("playengine",2,0,11,288,5,1,2,0,0,0,0,0,1));
			features.add(new Feature("playlist",1,0,14,274,4,1,3,0,0,9,1,1,0));
			features.add(new Feature("progressbar",1,0,2,29,2,1,4,0,2,0,1,0,1));
			features.add(new Feature("queuetrack",1,0,8,292,6,1,4,0,0,0,1,0,1));
			features.add(new Feature("removetrack",1,0,2,29,1,1,5,0,4,1,1,1,0));
			features.add(new Feature("reorderplaylist",1,0,2,38,1,1,5,0,4,0,1,0,1));
			features.add(new Feature("saveandloadplaylist",1,0,5,136,1,1,4,0,0,0,1,0,1));
			features.add(new Feature("showcover",1,0,2,29,2,1,3,0,0,0,1,0,1));
			features.add(new Feature("showtime",1,0,1,16,1,1,4,0,2,0,1,0,1));
			features.add(new Feature("shufflerepeat",1,0,4,115,2,1,5,0,4,0,1,0,1));
			features.add(new Feature("skiptrack",1,0,2,29,1,1,5,0,4,0,1,0,1));
			features.add(new Feature("volumecontrol",1,0,4,48,1,1,3,0,0,0,1,0,1));
			features.add(new Feature("wav",1,0,1,13,1,1,4,0,3,0,1,0,1));
		
		}
		//FeatureAMP9
		else if (t == TargetSystem.FeatureAMP9) {
			features.add(new Feature("clearplaylist",1,0,3,58,2,1,6,0,0,0,1,0,1));
			features.add(new Feature("dark",1,0,1,10,1,1,4,2,0,0,1,0,1));
			features.add(new Feature("gui",6,6,37,586,6,2,2,0,0,19,1,1,0));
			features.add(new Feature("light",1,0,1,10,1,1,4,2,0,0,1,0,1));
			features.add(new Feature("loadfolder",1,0,5,91,3,1,4,0,0,0,0,0,1));
			features.add(new Feature("mp3",2,2,14,258,3,2,3,0,2,0,1,0,1));
			features.add(new Feature("mute",1,0,3,73,3,1,4,0,0,0,1,0,1));
			features.add(new Feature("ogg",2,2,14,235,3,2,3,0,2,0,1,0,1));
			features.add(new Feature("playlist",2,1,20,244,6,2,3,0,0,9,1,1,0));
			features.add(new Feature("progressbar",1,0,3,48,3,1,4,0,2,0,1,0,1));
			features.add(new Feature("queuetrack",3,0,7,136,4,3,4,0,0,0,1,0,1));
			features.add(new Feature("removetrack",1,0,3,67,2,1,5,0,4,1,1,1,0));
			features.add(new Feature("reorderplaylist",2,0,5,108,2,1,5,0,4,0,1,0,1));
			features.add(new Feature("saveandloadplaylist",1,0,3,148,2,1,4,0,0,0,0,1,0));
			features.add(new Feature("showcover",1,0,3,48,3,1,3,0,0,0,1,0,1));
			features.add(new Feature("showtime",1,0,1,22,1,1,4,0,2,0,1,0,1));
			features.add(new Feature("shufflerepeat",3,0,6,132,3,2,5,0,4,0,1,0,1));
			features.add(new Feature("skiptrack",1,0,3,52,2,1,5,0,4,0,1,0,1));
			features.add(new Feature("volumecontrol",1,0,6,59,3,1,3,0,0,0,1,0,1));
		}

		else if(t == TargetSystem.ARGOUML) {
			features.add(new Feature("LOGGING",199,69,418,2912,730,0,2,0,0,0,1,0,1));
			features.add(new Feature("COGNITIVE",12,1,26,399,31,4,2,0,0,0,1,0,1));
			features.add(new Feature("ACTIVITYDIAGRAM",34,3,41,538,61,38,3,0,0,0,1,0,1));
			features.add(new Feature("COLLABORATIONDIAGRAM",19,2,21,187,25,18,3,0,0,0,1,0,1));
			features.add(new Feature("DEPLOYMENTDIAGRAM",40,2,40,363,51,36,3,0,0,0,1,0,1));
			features.add(new Feature("SEQUENCEDIAGRAM",8,2,13,152,26,3,3,0,0,0,1,0,1));
			features.add(new Feature("STATEDIAGRAM",18,0,22,118,22,19,3,0,0,0,1,0,1));
			features.add(new Feature("USECASEDIAGRAM",7,1,6,106,13,6,3,0,0,0,1,0,1));
		}
	}

	public void leitor(String arquivo) {

		File dir = new File(arquivo);
		// computa as metricas de classe
		M_Classes met_Classes = new M_Classes();
		// nome da classe
		met_Classes.nomeClasse = arquivo;

		String featureAtual = "";

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		int cont2 = 0;
		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains("if(Configuration.") || listas.get(i).contains("if (Configuration.")
					|| listas.get(i).contains("if(specifications.Configuration")
					|| listas.get(i).contains("if (specifications.Configuration")
					|| listas.get(i).contains("if(!Configuration.") || listas.get(i).contains("if (!Configuration.")
					|| listas.get(i).contains("if(!specifications.Configuration")
					|| listas.get(i).contains("if (!specifications.Configuration")) {
				System.out.println("Linha: " + (i + 1) + " " + listas.get(i));
				cont++;
				cont2++;

				if (!listas.get(i).equals(featureAtual)) {
					// quantidade de entrelacamento na classe
					met_Classes.entrelacamento++;
					featureAtual = listas.get(i);

				}

				for (int x = 0; x < features.size(); x++) {
					if (listas.get(i).contains("Configuration." + features.get(x).nome + " ")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "&")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + "|")
							|| listas.get(i).contains("Configuration." + features.get(x).nome + ")")) {
						features.get(x).quantidade++;
						featuresAux.get(x).quantidade++;
					}
				}
			}

		}
		System.out.println("\n\t\tSomatorio local:" + cont2 + "  Somatorio total:" + cont + "\n\n");
		// pontos variablidade total da classe
		met_Classes.pontosVariabilidade = cont2;
		int total = 0;
		for (int x = 0; x < featuresAux.size(); x++) {
			if (featuresAux.get(x).quantidade != 0) {
				System.out.println("\t\t\t\t{\"name\": \"" + featuresAux.get(x).nome + "\", \"value\":"
						+ featuresAux.get(x).quantidade + ", \"fail\": 0},");
				espalhamento.get(x).quantidade++;

				// quantidade de features diferentes manipuladas na classe
				met_Classes.featManipuladas++;
				// aglutina os nomes das features que manipuladas na classe
				met_Classes.nomeFeatures += " ; " + featuresAux.get(x).nome;
				computarMetricasFeature(met_Classes, features.get(x), arquivo);
			}
			total += featuresAux.get(x).quantidade;
		}
		for (int x = 0; x < featuresAux.size(); x++) {
			featuresAux.get(x).quantidade = 0;
		}

		System.err.println("nomeClasse: \t" + met_Classes.nomeClasse);
		System.err.println("featManipuladas: \t" + met_Classes.featManipuladas);
		System.err.println("pontosVariabilidade: \t" + met_Classes.pontosVariabilidade);
		System.err.println("entrelacamento: \t" + met_Classes.entrelacamento);
		System.err.println("classes: " + met_Classes.Scattering);
		System.err.println("constructors: " + met_Classes.constructors);
		System.err.println("methods: " + met_Classes.methods);
		System.err.println("LOCs: " + met_Classes.LOCs);
		System.err.println("occurrences: " + met_Classes.VP);
		System.err.println("FDT: " + met_Classes.DT_Max);
		System.err.println("quantFailures: " + met_Classes.quantFailures);
		System.err.println("porcfeature: " + met_Classes.porcfeature);

		RunReport runReport = new RunReport(met_Classes, record);
		runReport.runReport();

	}

	private void computarMetricasFeature(M_Classes met_Classes, Feature feature, String nomeClasse) {

		met_Classes.Scattering += feature.classes;
		met_Classes.constructors += feature.constructors;
		met_Classes.methods += feature.methods;
		met_Classes.LOCs += feature.LOCs;
		met_Classes.VP += feature.occurrences;
		met_Classes.Tangling += feature.otherFeatures;

		if (feature.DT_Max > met_Classes.DT_Max)
			met_Classes.DT_Max = feature.DT_Max;

		if (feature.DT_Max < met_Classes.DT_Min)
			met_Classes.DT_Min = feature.DT_Max;

		if (feature.NGOr_Max > met_Classes.NGOr_Max)
			met_Classes.NGOr_Max = feature.NGOr_Max;

		if (feature.NGXOr_Max > met_Classes.NGXOr_Max)
			met_Classes.NGXOr_Max = feature.NGXOr_Max;

		if (feature.BF_Max_Branching > met_Classes.BF_Max_Branching)
			met_Classes.BF_Max_Branching = feature.BF_Max_Branching;

		met_Classes.NO += feature.NO;
		met_Classes.NTop += feature.NTop;
		met_Classes.NLeaf += feature.NLeaf;

		met_Classes.quantFailures += feature.quantFailures;

		if (feature.porcfeature > met_Classes.porcfeature)
			met_Classes.porcfeature = feature.porcfeature;

		for (CMF cmf : feature.classManiFeat) {

			if (cmf.nomeClasse.equals(nomeClasse)) {
				met_Classes.cmf_Final.cbo += cmf.cbo;
				met_Classes.cmf_Final.wmc += cmf.wmc;
				met_Classes.cmf_Final.dit += cmf.dit;
				met_Classes.cmf_Final.noc += cmf.noc;
				met_Classes.cmf_Final.rfc += cmf.rfc;
				met_Classes.cmf_Final.lcom += cmf.lcom;
				met_Classes.cmf_Final.nom += cmf.nom;
				met_Classes.cmf_Final.nopm += cmf.nopm;
				met_Classes.cmf_Final.nosm += cmf.nosm;
				met_Classes.cmf_Final.nof += cmf.nof;
				met_Classes.cmf_Final.nopf += cmf.nopf;
				met_Classes.cmf_Final.nosf += cmf.nosf;
				met_Classes.cmf_Final.nosi += cmf.nosi;
				met_Classes.cmf_Final.loc += cmf.loc;

			}
		}
	}

	public static void main(String[] args) {

		String path = "ArgoUML/";
		inicialization(TargetSystem.ARGOUML);

		for (int x = 0; x < features.size(); x++) {
			featuresAux.add(new Feature(features.get(x).nome));
			espalhamento.add(new Feature(features.get(x).nome));
		}

		String fileName;
		String fileNameAndPath = null;
		File folder = new File(path);
		File[] listOfFiles = folder.listFiles();

		variabilityCount ler = new variabilityCount();

		for (int i = 0; i < listOfFiles.length; i++) {

			if (listOfFiles[i].isFile()) {
				fileName = listOfFiles[i].getName();
				try {
					fileNameAndPath = path + fileName;
					System.err.println(fileNameAndPath);
					nomeClasse = fileNameAndPath;
					ler.leitor(fileNameAndPath);
				} catch (Exception e) {
					System.out.println(
							"Erro ao processar o arquivo %s com a mensagem: %s" + fileNameAndPath + e.getMessage());
				}
			}
		}
		System.out.print("\n somatório total de variabilidade: ");
		System.err.println(cont + "\n\n");
		System.out.println("\n\n\n somatório da variabilidade das features");

		Comparator crescente = new ComparadorDeFeature();
		Comparator decrescente = Collections.reverseOrder(crescente);
		Collections.sort(features, crescente);

		int total = 0;
		for (int x = 0; x < features.size(); x++) {
			System.out.println(features.get(x).nome + "\t" + features.get(x).quantidade);
			total += features.get(x).quantidade;
		}
		System.out.println("Total: \t" + total);

		System.out.println("\n\nEspalhamento de features.");

		Collections.sort(espalhamento, crescente);

		for (int x = 0; x < espalhamento.size(); x++) {
			System.out.println(espalhamento.get(x).nome + "\t" + espalhamento.get(x).quantidade);
		}

		System.out.println("\n\n\nnome  \t\t Occurrences \t Other Features");
		for (int x = 0; x < features.size(); x++) {
			if (features.get(x).quantidade != 0)
				System.out.println(features.get(x).nome + "\t\t" + features.get(x).quantidade + "\t"
						+ espalhamento.get(x).quantidade);

		}

		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}

		System.out.println("\n\nTodos os arquivos foram processados.");
	}

}