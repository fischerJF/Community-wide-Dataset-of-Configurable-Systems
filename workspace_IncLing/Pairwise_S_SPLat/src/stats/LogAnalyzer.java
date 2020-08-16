package stats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import configuration.Configuration;
import javafx.util.Pair;

public class LogAnalyzer implements Serializable {
	
	String technique;
	String logPath;

	public LogAnalyzer(String fname) throws IOException {
		this.logPath = (new java.io.File(".")).getCanonicalPath().toString() + "/data/" + fname;
		this.logPath = "/Users/sabrinasouto/workspace/splat-sampling/spl-sampling/data/" + fname;
		this.technique = fname.substring(0, fname.length()-4);
	}
	
	static List<String> tnames = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		logResults("companies");
		logResults("desktop");
		logResults("email");
		logResults("gpl");
		logResults("jtopas");
		logResults("notepad");
		logResults("sudoku");
		logResults("zipme");
	}

	private static void logResults(String subject) throws IOException, Exception, FileNotFoundException {
		StringBuffer sb = new StringBuffer();
		System.out.println(subject);
		sb.append("AVG_NUM_FAILURES AVG_SAMPLE TECHNIQUE\n");
		boolean validate = false;
		processResulst(sb, validate, subject);
		/** print **/
		System.out.println(sb);
		PrintStream log = new PrintStream(
				new File((new java.io.File(".")).getCanonicalPath().toString() + 
						"/plots-figs/samplesize-versus-numfailures/" + subject + ".txt"));
		log.print(sb);
	}

	private static void processResulst(StringBuffer sb, boolean validate, String subject) throws IOException, Exception {
		
		Pair avgSPLat = null;
		double failuresSplat = 0.0;
		if(!subject.equals("desktop") && !subject.equals("notepad")){
			LogAnalyzer la = new LogAnalyzer(subject+"_splat.txt");
			Map<String, List<String>> mapTestBlocks = la.read();
			Map<String,TestInfo> tests_splat = la.analyze(mapTestBlocks, validate, true);
//			la.genStats(tests_splat, sb);
			avgSPLat = la.calculateAverage(tests_splat, sb, "splat");
			failuresSplat = (double)avgSPLat.getKey();
			
			LogAnalyzer la4 = new LogAnalyzer(subject+"_random1.txt");
			Map<String, List<String>> mapTestBlocks4= la4.read();
			Map<String,TestInfo> tests_ran = la4.analyze(mapTestBlocks4, validate, true);
//			la4.genStats(tests_ran, sb);
			la4.calculateAverage(tests_ran, sb, "random");
		}
		
		LogAnalyzer la0 = new LogAnalyzer(subject+"_most_enabled_disabled.txt");
		Map<String, List<String>> mapTestBlocks0 = la0.read();
		Map<String,TestInfo> tests_med = la0.analyze(mapTestBlocks0, validate, true);
//		la0.genStats(tests_med, sb);
		Pair avgMed = la0.calculateAverage(tests_med, sb, "med");
		
		LogAnalyzer la1 = new LogAnalyzer(subject+"_one_enabled.txt");
		Map<String, List<String>> mapTestBlocks1 = la1.read();
		Map<String,TestInfo> tests_oe = la1.analyze(mapTestBlocks1, validate, true);
//		la1.genStats(tests_oe, sb);
		Pair avgOe = la1.calculateAverage(tests_oe, sb, "oe");
		
		LogAnalyzer la2 = new LogAnalyzer(subject+"_one_disabled.txt");
		Map<String, List<String>> mapTestBlocks2 = la2.read();
		Map<String,TestInfo> tests_od = la2.analyze(mapTestBlocks2, validate, true);
//		la2.genStats(tests_od, sb);
		Pair avgOd = la2.calculateAverage(tests_od, sb, "od");
		
		LogAnalyzer la3 = new LogAnalyzer(subject+"_pairwise.txt");
		Map<String, List<String>> mapTestBlocks3= la3.read();
		Map<String,TestInfo> tests_pw = la3.analyze(mapTestBlocks3, validate, true);
//		la3.genStats(tests_pw, sb);
		Pair avgPw = la3.calculateAverage(tests_pw, sb, "pw");
		
		
//		/**CALCULATE COMBINATIONS**/
//		/**c1: [one-enabled, one-disabled]**/
//		calculateCombination2(subject, tests_oe, tests_od, "c1", sb, avgOe, avgOd, failuresSplat);
//		
//		/**c2: [one-enabled, most-enabled-disabled]**/
//		calculateCombination2(subject, tests_oe, tests_med, "c2", sb, avgOe, avgMed, failuresSplat);
//		
//		/**c3: [one-enabled, pairwise]**/
//		calculateCombination2(subject, tests_oe, tests_pw, "c3", sb, avgOe, avgPw, failuresSplat);
//		
//		/**c4: [one-disabled, most-enabled-disabled]**/
//		calculateCombination2(subject, tests_od, tests_med, "c4", sb, avgOd, avgMed, failuresSplat);
//		
//		/**c5: [one-disabled, pairwise]**/
//		calculateCombination2(subject, tests_od, tests_pw, "c5", sb, avgOd, avgPw, failuresSplat);
//		
//		/**c6: [most-enabled-disabled, pairwise]**/
//		calculateCombination2(subject, tests_med, tests_pw, "c6", sb, avgMed, avgPw, failuresSplat);
//		
//		/**c7: [one-enabled, one-disabled, most-enabled-disabled]**/
//		calculateCombination3(subject, tests_oe, tests_od, tests_med, "c7", sb, avgOe, avgOd, avgMed, failuresSplat);
//		
//		/**c8: [one-enabled, most-enabled-disabled, pairwise]**/
//		calculateCombination3(subject, tests_oe, tests_med, tests_pw, "c8", sb, avgOe, avgMed, avgPw, failuresSplat);
//		
//		/**c9: [one-disabled, most-enabled-disabled, pairwise]**/
//		calculateCombination3(subject, tests_od, tests_med, tests_pw, "c9", sb, avgOd, avgMed, avgPw, failuresSplat);
//		
//		/**c10: [one-enabled, one-disabled, pairwise]**/
//		calculateCombination3(subject, tests_oe, tests_od, tests_pw, "c10", sb, avgOe, avgOd, avgPw, failuresSplat);
//		
//		/**c11: [one-enabled, one-disabled, most-enabled-disabled, pairwise]**/
//		calculateCombination4(subject, tests_oe, tests_od, tests_med, tests_pw, "c11", sb, avgOe, avgOd, avgMed, avgPw, failuresSplat);
	}
	
	private static void calculateCombination2(String subject, Map<String, TestInfo> tests1, Map<String, TestInfo> tests2, String combName, StringBuffer sb, Pair avg1, Pair avg2, double failuresSplat){
		int ntDistinctFailures = 0;
		int totalPairs = 0;
		int totalTests = 0;
		
		Map<String, TestInfo> tis1, tis2;
		if(tests1.size() > tests2.size()){
			tis1 = tests1; tis2 = tests2;
		} else {
			tis1 = tests2; tis2 = tests1;
		}
		
		for(String tname : tis1.keySet()){
			if(tis2.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti2);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}
			} else {
				TestInfo ti = tis1.get(tname);
				if(ti.getFailures().size() > 0){
					ntDistinctFailures += ti.getDistinctFailures().size();
					totalPairs += ti.getDistinctConfsStr().size();
					totalTests++;	
				}
			}
		}
		double nfailures = (double)ntDistinctFailures/totalTests;
		double nsamples = (double)totalPairs/totalTests;
		if(!subject.equals("desktop") && !subject.equals("notepad"))
			if(nfailures > failuresSplat) nfailures = failuresSplat;
		sb.append(String.format(Locale.US, "%.2f %.2f %s\n", nfailures, nsamples, combName));
//		double minFailures = Math.max((double)avg1.getKey(), (double)avg2.getKey());
//		double maxFailures = (double)avg1.getKey() + (double)avg2.getKey();
//		double minPairs = Math.max((double)avg1.getValue(), (double)avg2.getValue());
//		double maxPairs = (double)avg1.getValue() + (double)avg2.getValue();
//		sb.append(String.format("%.2f %.2f %s failures(%.2f,%.2f) samplesize(%.2f,%.2f)\n", 
//				(double)ntDistinctFailures/totalTests, 
//				(double)totalPairs/totalTests, combName,
//				minFailures, maxFailures, minPairs, maxPairs));
	}
	
	
	private static void calculateCombination3(String subject, Map<String, TestInfo> tests1, Map<String, TestInfo> tests2, Map<String, TestInfo> tests3, 
			String combName, StringBuffer sb, Pair avg1, Pair avg2, Pair avg3, double failuresSplat){ //TODO: quick an dirty implementation, refactor this code
		int ntDistinctFailures = 0;
		int totalPairs = 0;
		int totalTests = 0;
		
		List<Map<String, TestInfo>> maps = new ArrayList<Map<String, TestInfo>>();
		maps.add(tests1); maps.add(tests2); maps.add(tests3);
		
		maps.sort(new Comparator<Map<String, TestInfo>>() {
			@Override
			public int compare(Map<String, TestInfo> o1, Map<String, TestInfo> o2) {
				return o1.size() - o2.size();
			}
		});	
		
		Map<String, TestInfo> tis1 = maps.get(0);
		Map<String, TestInfo> tis2 = maps.get(1);
		Map<String, TestInfo> tis3 = maps.get(2);
	
		for(String tname : tis1.keySet()){
			if(tis2.containsKey(tname) && tis3.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				TestInfo ti3 = tis3.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)
						|| (ti3.getFailures().size() > 0)){
					TestInfo c0 = TestInfo.combineTestResults(ti1, ti2);
					TestInfo c = TestInfo.combineTestResults(c0, ti3);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;		
				}
			} else if(tis2.containsKey(tname) && !tis3.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti2);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}	
			} else if(!tis2.containsKey(tname) && tis3.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti3 = tis3.get(tname);
				if((ti1.getFailures().size() > 0) || (ti3.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti3);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}
			} else {
				TestInfo ti1 = tis1.get(tname);
				if(ti1.getFailures().size() > 0){
					ntDistinctFailures += ti1.getDistinctFailures().size();
					totalPairs += ti1.getDistinctConfsStr().size();
					totalTests++;		
				}
			}
		}
		double nfailures = (double)ntDistinctFailures/totalTests;
		double nsamples = (double)totalPairs/totalTests;
		if(!subject.equals("desktop") && !subject.equals("notepad"))
			if(nfailures > failuresSplat) nfailures = failuresSplat;
		sb.append(String.format(Locale.US, "%.2f %.2f %s\n", nfailures, nsamples, combName));
//		double minFailures = Math.max(Math.max((double)avg1.getKey(), (double)avg2.getKey()), (double)avg3.getKey());;
//		double maxFailures = (double)avg1.getKey() + (double)avg2.getKey() + (double)avg3.getKey();
//		double minPairs = Math.max(Math.max((double)avg1.getValue(), (double)avg2.getValue()), (double)avg3.getValue());
//		double maxPairs = (double)avg1.getValue() + (double)avg2.getValue() + (double)avg3.getValue();
//		sb.append(String.format("%.2f %.2f %s failures(%.2f,%.2f) samplesize(%.2f,%.2f)\n", 
//				(double)ntDistinctFailures/totalTests, 
//				(double)totalPairs/totalTests, combName,
//				minFailures, maxFailures, minPairs, maxPairs));
	}
	
	private static void calculateCombination4(String subject, Map<String, TestInfo> tests1, Map<String, TestInfo> tests2, Map<String, TestInfo> tests3, Map<String, TestInfo> tests4,
			String combName, StringBuffer sb, Pair avg1, Pair avg2, Pair avg3, Pair avg4, double failuresSplat){ //TODO: quick an dirty implementation, refactor this code
		int ntDistinctFailures = 0;
		int totalPairs = 0;
		int totalTests = 0;
		
		List<Map<String, TestInfo>> maps = new ArrayList<Map<String, TestInfo>>();
		maps.add(tests1); maps.add(tests2); maps.add(tests3); maps.add(tests4);
		
		maps.sort(new Comparator<Map<String, TestInfo>>() {
			@Override
			public int compare(Map<String, TestInfo> o1, Map<String, TestInfo> o2) {
				return o1.size() - o2.size();
			}
		});	
		
		Map<String, TestInfo> tis1 = maps.get(0);
		Map<String, TestInfo> tis2 = maps.get(1);
		Map<String, TestInfo> tis3 = maps.get(2);
		Map<String, TestInfo> tis4 = maps.get(3);
		
		for(String tname : tis1.keySet()){
			if(tis2.containsKey(tname) && tis3.containsKey(tname) && tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				TestInfo ti3 = tis3.get(tname);
				TestInfo ti4 = tis4.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)
						|| (ti3.getFailures().size() > 0) || (ti4.getFailures().size() > 0)){
					TestInfo c0 = TestInfo.combineTestResults(ti1, ti2);
					TestInfo c1 = TestInfo.combineTestResults(c0, ti3);
					TestInfo c = TestInfo.combineTestResults(c1, ti4);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;		
				}
			} else if(tis2.containsKey(tname) && tis3.containsKey(tname) && !tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				TestInfo ti3 = tis3.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)
						|| (ti3.getFailures().size() > 0)){
					TestInfo c0 = TestInfo.combineTestResults(ti1, ti2);
					TestInfo c = TestInfo.combineTestResults(c0, ti3);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;		
				}
			} else if(tis2.containsKey(tname) && !tis3.containsKey(tname) && tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				TestInfo ti4 = tis4.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)
						|| (ti4.getFailures().size() > 0)){
					TestInfo c0 = TestInfo.combineTestResults(ti1, ti2);
					TestInfo c = TestInfo.combineTestResults(c0, ti4);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;		
				}
			} else if(!tis2.containsKey(tname) && tis3.containsKey(tname) && tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti3 = tis3.get(tname);
				TestInfo ti4 = tis4.get(tname);
				if((ti1.getFailures().size() > 0) || (ti3.getFailures().size() > 0)
						|| (ti4.getFailures().size() > 0)){
					TestInfo c0 = TestInfo.combineTestResults(ti1, ti3);
					TestInfo c = TestInfo.combineTestResults(c0, ti4);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;		
				}
			} else if(tis2.containsKey(tname) && !tis3.containsKey(tname) && !tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti2 = tis2.get(tname);
				if((ti1.getFailures().size() > 0) || (ti2.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti2);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}
			} else if(!tis2.containsKey(tname) && tis3.containsKey(tname) && !tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti3 = tis3.get(tname);
				if((ti1.getFailures().size() > 0) || (ti3.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti3);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}
			} else if(!tis2.containsKey(tname) && !tis3.containsKey(tname) && tis4.containsKey(tname)){
				TestInfo ti1 = tis1.get(tname);
				TestInfo ti4 = tis4.get(tname);
				if((ti1.getFailures().size() > 0) || (ti4.getFailures().size() > 0)){
					TestInfo c = TestInfo.combineTestResults(ti1, ti4);
					ntDistinctFailures += c.getDistinctFailures().size();
					totalPairs += c.getDistinctConfsStr().size();
					totalTests++;	
				}
			} else {
				TestInfo ti1 = tis1.get(tname);
				if(ti1.getFailures().size() > 0){
					ntDistinctFailures += ti1.getDistinctFailures().size();
					totalPairs += ti1.getDistinctConfsStr().size();
					totalTests++;		
				}
			}
		}
		double nfailures = (double)ntDistinctFailures/totalTests;
		double nsamples = (double)totalPairs/totalTests;
		if(!subject.equals("desktop") && !subject.equals("notepad"))
			if(nfailures > failuresSplat) nfailures = failuresSplat;
		sb.append(String.format(Locale.US, "%.2f %.2f %s\n", nfailures, nsamples, combName));
//		double minFailures = Math.max(Math.max((double)avg1.getKey(), (double)avg2.getKey()), Math.max((double)avg3.getKey(), (double)avg4.getKey()));
//		double maxFailures = (double)avg1.getKey() + (double)avg2.getKey() + (double)avg3.getKey() + (double)avg4.getKey();
//		double minPairs = Math.max(Math.max((double)avg1.getValue(), (double)avg2.getValue()), Math.max((double)avg3.getValue(), (double)avg4.getValue()));
//		double maxPairs = (double)avg1.getValue() + (double)avg2.getValue() + (double)avg3.getValue() + (double)avg4.getValue();
//		sb.append(String.format("%.2f %.2f %s failures(%.2f,%.2f) samplesize(%.2f,%.2f)\n", 
//				(double)ntDistinctFailures/totalTests, 
//				(double)totalPairs/totalTests, combName,
//				minFailures, maxFailures, minPairs, maxPairs));
	}
	
	private void genStats(Map<String,TestInfo> tests, StringBuffer sb) {
		int ntDistinctFailures = 0;
		int execs = 0;
		int failingExecs = 0;
		int etff = 0;
		int totalTests = 0;
		for (TestInfo ti : tests.values()) {
			if(ti.getAllConfs().size() > 0){
				execs += ti.getDistinctConfsStr().size();
				failingExecs += ti.getFailures().size();
				ntDistinctFailures += ti.getDistinctFailures().size();
				etff += ti.getCTFF();
				totalTests++;
			}
		}
		sb.append(execs + " & " + failingExecs + " & " + ntDistinctFailures + " & " + etff + "\n");
//		sb.append(" TOTAL TESTS: " + totalTests + "\n");
	}
	
	private void processResults(String technique, boolean checkFailures) throws Exception {
		Map<String, List<String>> mapTestBlocks = this.read();
		boolean validate = false;
		Map<String,TestInfo> tests = this.analyze(mapTestBlocks, validate, checkFailures);
		StringBuffer sb = new StringBuffer();
		calculateAverage(tests, sb, technique);
		// some statistics for the paper
//		 calculateStats(tests, sb);
//		 summarizeStats(tests, sb);
		/** print **/
		System.out.println(sb);
	}
	
	private Pair calculateAverage(Map<String, TestInfo> tests, StringBuffer sb, String technique) {
		int[] totals = calculateTotals(tests.values());
		int ntDistinctFailures = totals[0];
		int totalPairs = totals[1];
		int totalTests = totals[2];
		sb.append(String.format(Locale.US, "%.2f %.2f %s\n", 
				(double)ntDistinctFailures/totalTests, 
				technique.equals("med") ? 2.00 : (double)totalPairs/totalTests, technique));	
		return new Pair((double)ntDistinctFailures/totalTests, (double)totalPairs/totalTests);
	}
	
	private static int[] calculateTotals(Collection<TestInfo> collection){
		int ntDistinctFailures = 0;
		int totalPairs = 0;
		int totalTests = 0;
		for (TestInfo ti : collection) {
			if(ti.getAllConfs().size() > 0){
				ntDistinctFailures += ti.getDistinctFailures().size();
//				totalPairs += ti.getAllConfs().size();
				totalPairs += ti.getDistinctConfsStr().size();
				totalTests++;
			}
		}
		return new int[]{ntDistinctFailures,totalPairs,totalTests};
	}

	private void calculateStats(Map<String, TestInfo> tests, StringBuffer sb) {
		int ntDistinctFailures = 0;
		int ntconfsFailed = 0;
		int ntconfsPassed = 0;
		int totalPairs = 0;
		int totalTests = 0;
		long totalTime = 0;
		for (TestInfo ti : tests.values()) {
			if(ti.getAllConfs().size() > 0){
				ntDistinctFailures += ti.getDistinctFailures().size();
				ntconfsFailed += ti.getFailures().size();
				ntconfsPassed += ti.getPasses().size();
				totalPairs += ti.getAllConfs().size();
				totalTests++;
				totalTime += ti.getTime();
			}
		}
		sb.append("TECHNIQUE: " + this.technique + "\n");
		sb.append("#Tests: " + totalTests + "\n");
		sb.append("#Confs(pairs): " + totalPairs + "\n");
		sb.append("#PassingConfs: " + ntconfsPassed + "\n");
		sb.append("#FailingConfs: " + ntconfsFailed + "\n");
		sb.append("#DistinctFailures: " + ntDistinctFailures + "\n");
		sb.append("#TotalTime: " + totalTime/1000 + "\n");
	}
	
	/**
	 * Shows stats about the tests
	 * 
	 * @param tests
	 * @param sb
	 */
	public void summarizeStats(Map<String, TestInfo> tests, StringBuffer sb) {
		sb.append("-------------Statistics-------------\n");
		sb.append("Suite:Test #Total #P #F #DF #TotalTime\n");
		for (TestInfo ti : tests.values()) {
			getTestInfo(sb, ti);
		}
	}

	private void getTestInfo(StringBuffer sb, TestInfo ti) {
		int ntotal;
		ntotal = ti.getConfigurations().size();
		double ttime = ti.getTime();
		if(ti.getAllConfs().size() > 0){
			sb.append(ti.testName + " " + ntotal + " " + ti.getPasses().size() + " "
					+ ti.getFailures().size() + " " + ti.getDistinctFailures().size() + " "
					+ String.format("%.2f", ttime/1000) + "\n");
		}
	}

	
	/**
	 * Reads the log file and divide it into blocks corresponding to each
	 * execution of SPLat.
	 * 
	 * @throws Exception
	 **/
	public Map<String, List<String>> read() throws Exception {
		Map<String, List<String>> mapTestBlocks = new LinkedHashMap<String, List<String>>();
		File f = new File(logPath);
		if (!f.exists()) {
			System.err.printf("Could not find file: %s\n", logPath);
			System.exit(-1);
		}

		/** reading input file **/
		Reader r = new FileReader(f);
		@SuppressWarnings("resource")
		BufferedReader br = new BufferedReader(r);
		String line = br.readLine();
		while (line != null) {
			/** dividing the blocks **/
			while ((line != null) && line.contains("testname")) {
				List<String> blocks = new LinkedList<String>();
				String[] tokens = line.split(" ");
				String testName = tokens[1];
				line = br.readLine();
				do {
					String block = "";
					//while ((line != null) && (!line.startsWith("--->"))) {
					while (line != null) {
						block += line + "\n";
						line = br.readLine();
						if (((line != null)) && (line.contains("testname")))
							break;
					}
//					while ((line != null) && (!line.startsWith("**"))) {
//						block += line + "\n";
//						line = br.readLine();
//						if (((line != null)) && (line.contains("testname")))
//							break;
//					}
					blocks.add(block);
				} while ((line != null) && (!line.contains("testname")));
				mapTestBlocks.put(testName, blocks);
			}
			line = br.readLine();
		}
		return mapTestBlocks;
	}
	
	
	
	
	/**
	 * Analyzes each block in order to extract information about tests and
	 * configurations.
	 * @param checkFailures 
	 **/
	public Map<String,TestInfo> analyze(Map<String, List<String>> mapTestBlocks,
			boolean validate, boolean checkFailures) throws Exception {
//		List<TestInfo> testsinfo = new LinkedList<TestInfo>();
		Map<String,TestInfo> testsinfo = new LinkedHashMap<String,TestInfo>(); 
		Set<String> tests = mapTestBlocks.keySet();

		/** Analyzing each test **/
		for (String testName : tests) {
			TestInfo ti = new TestInfo(testName);
			long totalTime = 0;

			/** Analyzing each block **/
			List<String> blocks = mapTestBlocks.get(testName);
			for (String block : blocks) {
				totalTime = analyzeConf(ti, block, totalTime, validate);
			}
			/** block **/

			ti.setTime(totalTime);
			
			if(checkFailures){
				if(ti.getFailures().size() > 0) //enable
					testsinfo.put(ti.getTestName(), ti);
			} else testsinfo.put(ti.getTestName(), ti);
		}
		/** test **/
		return testsinfo;
	}

	/**
	 * @param status2
	 * @param conf
	 * 
	 */
	private long analyzeConf(TestInfo ti, String block, long totalTime, boolean validate) throws IOException {
		int ctff = 0;
		boolean firstFailure = true;
		BufferedReader br = new BufferedReader(new StringReader(block));
		String line = br.readLine();
		List<String> allStatus = new ArrayList<String>();
		Configuration configuration = null;
		do {
			/** Analyzing each configuration **/
			if (line.startsWith("**")) {
				line = line.substring(2).trim();
				StringTokenizer st = new StringTokenizer(line, ",");
				String token = "";
				STATUS status = null;
				List<String> cov = new ArrayList<String>();
				// processing tokens on one line
				while (st.hasMoreTokens()) {
					token = st.nextToken().trim();
					if (token.equals("F")) {
						status = STATUS.Fail;
						allStatus.add(token);
						configuration = new Configuration(cov.toArray(new String[0]));
						ti.addFailingConf(configuration, validate);
						if (firstFailure){
							ctff++;
							firstFailure = false;
						}
						/** update trace signature mapping **/
						line = br.readLine();
						// first line of stack trace
						String exception = br.readLine().trim();
//						if(configuration.isValid())
						ti.addDistictFailure(exception);
						break;
					} else if (token.equals("P")) {
						status = STATUS.Pass;
						allStatus.add(token);
						configuration = new Configuration(cov.toArray(new String[0]));
						ti.addPassingConf(configuration, validate);
						if (firstFailure){
							ctff++;
							firstFailure = false;
						}
						break;
					} else {
						cov.add(token);
					}
				} /* end switch */
				if (status == null) {
					throw new RuntimeException(
							" could not find status for the following line:\n "
									+ line);
				}
			}
			/** configuration **/
			if (line != null && line.startsWith("--->")) {
				String timeStr = "";
				if (line.contains("msec"))
					timeStr = line.substring(4, line.length() - 4);
				else
					timeStr = line.substring(4, line.length() - 3);
				long time = Long.parseLong(timeStr);
				totalTime += time;
			}
			line = br.readLine();
		} while (line != null);
		ti.setCTFF(ctff);

//		if (allStatus.contains("F"))
//			ti.addFailingConf(configuration, validate);
//		else if (allStatus.contains("P"))
//			ti.addPassingConf(configuration, validate);

		return totalTime;
	}
	

}