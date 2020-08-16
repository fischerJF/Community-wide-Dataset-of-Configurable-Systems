package splat.stats;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import splat.solver.SATAnalysis;
import splat.util.Configuration;
import util.FileUtils;

public class LogAnalyzer implements Serializable {

	String logPath;
	static String localPath = "/Users/sabrinasouto/workspace/splat-sampling/splatgcc/";

	// /**Initializing Sat Solver**/
	// static{
	// try {
	// localPath = (new java.io.File(".")).getCanonicalPath().toString() + "/";
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	// static String modelPath = localPath + "m1m2.smt2";
//	static String modelPath = "/Users/sabrinasouto/workspace/splat-sampling/splatgcc/splat/m1m2.smt2";

//	/** Sat Solver **/
//	private static final SATAnalysis saInstance = new SATAnalysis(181,
//			"/usr/bin/z3", modelPath);

	public LogAnalyzer(String fname) {
//		this.logPath = localPath + "data/" + fname;
		this.logPath = localPath + "results/" + fname;
	}

//	static List<String> tnames = FileUtils.readLinesFrom("/Users/sabrinasouto/workspace/evo-splat/splatgcc/data/gcc_testpool_newdg.txt");
	static List<String> tnames = new ArrayList<String>();
	public static void main(String[] args) throws Exception {
		LogAnalyzer la = new LogAnalyzer("gcc.one.disabled.txt");
//		LogAnalyzer la = new LogAnalyzer("gcc-r227244.txt");
		Map<String, List<String>> mapTestBlocks = la.read();
		boolean validate = false;
		List<TestInfo> tests = la.analyze(mapTestBlocks, validate);
		StringBuffer sb = new StringBuffer();

		//some statistics for the paper
		int ntconfsFailed = 0;
		int ntconfsPassed = 0;
		int totalPairs = 0;
		int totalTests = 0;
		long totalTime = 0;
		for (TestInfo ti : tests) {
//			if(ti.getAllConfs().size() > 0 && ti.getAllConfs().size() <= 100 && (totalTime/1000) <= 1800){
//			if(ti.getAllConfs().size() > 0 && ti.getAllConfs().size() < 100){
//			if(ti.getFailures().size() > 0 && ti.getAllConfs().size() < 100){
//			if(ti.getFailures().size() > 0){
//			String tname = ti.getTestName().substring(3, ti.getTestName().length()-2);
//			if(!tnames.contains(tname)){//dg:pr35746.c
			if(ti.getAllConfs().size() > 0){
				ntconfsFailed += ti.getFailures().size();
				ntconfsPassed += ti.getPasses().size();
				totalPairs += ti.getAllConfs().size();
				totalTests++;
				totalTime += ti.getTime();
//				System.out.println("dg " + ti.testName.substring(3));
//				tnames.add(tname);
			}
			}
//		}
		
		sb.append("#Tests: " + totalTests + "\n");
		sb.append("#Confs(pairs): " + totalPairs + "\n");
		sb.append("#PassingConfs: " + ntconfsPassed + "\n");
		sb.append("#FailingConfs: " + ntconfsFailed + "\n");
		sb.append("#TotalTime: " + totalTime/1000 + "\n");
		
		int crashingPairs = 0;
		for (TestInfo topt : tests) 
			crashingPairs += topt.getCrashes().size();
		
		sb.append("#CrashingConfs: " + crashingPairs + "\n");
		
		la.summarizeStats(tests, sb);
		
		/** print **/
		System.out.println(sb);
		
//		System.out.println("----------------------------------------------------------\n" + tnames.size() + "\n");
//		for (String tname : tnames)
//			System.out.println("dg " + tname + ".c");
	}
	
	public void getCommonConfsPerTest(StringBuffer sb, List<TestInfo> tests, List<Configuration> distinctConfs){
		Map<Configuration,Integer> confTest = new LinkedHashMap<Configuration,Integer>();
		for (TestInfo ti : tests) {
			for (Configuration c : distinctConfs) {
				if(ti.getCrashesValid().contains(c)){
					int counts = (confTest.get(c) == null) ? 0 : confTest.get(c);
					confTest.put(c, ++counts);
				}
			}
		}
		for (java.util.Map.Entry<Configuration, Integer> e : confTest.entrySet()) {
			sb.append(String.format("Conf: %s\tNumTests: %d\n", e.getKey().toString(), e.getValue()));
		}
	}
//	Set<String> commonTests = new TreeSet<String>();
//	for (Entry<Configuration, Set<String>> e : confTest.entrySet()) {
//		if(e.getValue().size() >=2 ){
//			commonTests.addAll(e.getValue());
//		}
//	}
//	int counter = 0;
//	for (String t : commonTests) {
//		sb.append(String.format(" %d: %s\n", ++counter, t));
//	}
	
	public List<Configuration> getDistinctConfs(List<TestInfo> tests){
		List<Configuration> distinctConfs = new ArrayList<Configuration>();
		int numConfs =  0;
		for (TestInfo ti : tests) {
			numConfs += ti.getCrashesValid().size();
			for (Configuration c : ti.getCrashesValid()) {
				if(!distinctConfs.contains(c))
					distinctConfs.add(c);
			}
		}
		System.out.println("TOTAL: " + numConfs);
		return distinctConfs;
	}

	/**
	 * Shows stats about the tests
	 * 
	 * @param TestList
	 * @param sb
	 */
	public void summarizeStats(List<TestInfo> TestList, StringBuffer sb) {
		sb.append("-------------Statistics-------------\n");
		sb.append("Suite:Test #Total #P #F #C #TotalTime\n");
		for (TestInfo ti : TestList) {
			getTestInfo(sb, ti);
		}
	}

	private void getTestInfo(StringBuffer sb, TestInfo ti) {
		int numCrashes;
		int ntotal;
		numCrashes = ti.getCrashes().size();
		ntotal = ti.getConfigurations().size();
		double ttime = ti.getTime();
//		double avgTime = (ttime / 1000) / ntotal;
//		if(ti.getAllConfs().size() > 0 && ti.getAllConfs().size() <= 100 && (ttime/1000) <= 1800)
//		if(ti.getFailures().size() > 0 && ti.getAllConfs().size() < 500)
//		if(ti.getAllConfs().size() > 0 && ti.getAllConfs().size() < 100){
//		if(ti.getFailures().size() > 0){
		if(ti.getAllConfs().size() > 0){
//		String tname = ti.getTestName().substring(3, ti.getTestName().length()-2);
//			if(ti.getAllConfs().size() > 0 && ti.getAllConfs().size() < 100){
			sb.append(ti.testName + " " + ntotal + " " + ti.getPasses().size() + " "
					+ ti.getFailures().size() + " " + numCrashes + " " 
					+ String.format("%.2f", ttime/1000) + "\n");
//			for (Configuration c : ti.getAllConfs()) {
//				sb.append(c.toString() + "\n");
//			}
//		tnames.remove(tname);
		}
		String suiteTest = ti.testName.replace(":", " ");
//		for (int i = 0; i < ti.getCrashesValid().size(); i++) {
//			Configuration conf = ti.getCrashesValid().get(i);
		for (int i = 0; i < ti.getCrashes().size(); i++) {
			Configuration conf = ti.getCrashes().get(i);
			sb.append(String.format("%s %s %s %s\n", "./runtest_opt.sh",
					suiteTest, conf.value2Option(), i + 1));
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
			while ((line != null) && line.contains("testfile")) {
				List<String> blocks = new LinkedList<String>();
				String[] tokens = line.split(" ");
				String testName = tokens[1];
				line = br.readLine();
				do {
					String block = "";
					while ((line != null) && (!line.startsWith("--->"))) {
						block += line + "\n";
						line = br.readLine();
						if (((line != null)) && (line.contains("testfile")))
							break;
					}
					while ((line != null) && (!line.startsWith("**"))) {
						block += line + "\n";
						line = br.readLine();
						if (((line != null)) && (line.contains("testfile")))
							break;
					}
					blocks.add(block);
				} while ((line != null) && (!line.contains("testfile")));
				mapTestBlocks.put(testName, blocks);
			}
			line = br.readLine();
		}
		return mapTestBlocks;
	}

	/**
	 * Analyzes each block in order to extract information about tests and
	 * configurations.
	 **/
	public List<TestInfo> analyze(Map<String, List<String>> mapTestBlocks,
			boolean validate) throws Exception {
		List<TestInfo> testsinfo = new LinkedList<TestInfo>();
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
			testsinfo.add(ti);
		}
		/** test **/
		return testsinfo;
	}

	/**
	 * @param status2
	 * @param conf
	 * 
	 */
	private long analyzeConf(TestInfo ti, String block, long totalTime,
			boolean validate) throws IOException {
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
						configuration = new Configuration(cov);
						/** update trace signature mapping **/
						line = br.readLine();
						// first line of stack trace
						String exception = br.readLine().trim();
						if (exception.contains("(internal compiler error)")) {// CRASH
							allStatus.add("C");
							configuration = new Configuration(cov);
						}
						break;
					} else if (token.equals("P")) {
						status = STATUS.Pass;
						allStatus.add(token);
						configuration = new Configuration(cov);
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

		/**
		 * Classifying configurations according to its status: - if there is, at
		 * least, one configuration with "C" crashing status, it is classified
		 * as F and C, - if there is, at least, one configuration with "F"
		 * failing status, it is classified as F, - if all the configurations
		 * have "P" passing status, it is classified as P.
		 * **/
		if (allStatus.contains("C")) {
			ti.addFailingConf(configuration, validate);
			ti.addCrashingConf(configuration, validate);
		} else if (allStatus.contains("F"))
			ti.addFailingConf(configuration, validate);
		else if (allStatus.contains("P"))
			ti.addPassingConf(configuration, validate);

		return totalTime;
	}

}
