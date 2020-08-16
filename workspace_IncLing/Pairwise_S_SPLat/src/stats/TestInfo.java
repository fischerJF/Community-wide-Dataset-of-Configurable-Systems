package stats;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import configuration.Configuration;

public class TestInfo {
	String testName;
	List<Configuration> passes, passesValid, failures, failuresValid, configurations;
	Set<String> distinctFailures;
	int id, ctff;
	long time;

	public TestInfo(String s) {
		this.testName = s;
		this.passes = new ArrayList<Configuration>();
		this.passesValid = new ArrayList<Configuration>();
		this.failures = new ArrayList<Configuration>();
		this.failuresValid = new ArrayList<Configuration>();
		this.configurations = new ArrayList<Configuration>();
		this.distinctFailures = new TreeSet<String>();
		this.ctff = 0;
	}
	
	public void setCTFF(int newctff){
		this.ctff = newctff;
	}
	
	public int getCTFF(){
		return this.ctff;
	}
	
	public String toString(){
		String print = testName + "\n";
//		print += "CONFIGURATIONS\n";
//		for (Configuration c : configurations) {
//			print += c.toString() + "\n";
//		}
//		print += "FAILING CONFIGURATIONS\n";
//		for (Configuration cf : failures) {
//			print += cf.toString() + "\n";
//		}
//		print += "FAILURES\n";
//		for (String df : distinctFailures) {
//			print += df + "\n";
//		}
//		print += "-------------------------------------------------------------------\n";
		return print;
	}
	
	public static TestInfo combineTestResults(TestInfo ti1, TestInfo ti2){
		TestInfo c = new TestInfo(ti1.getTestName());
		c.configurations.addAll(ti1.getAllConfs());
		c.configurations.addAll(ti2.getAllConfs());
		c.passes.addAll(ti1.getPasses());
		c.passes.addAll(ti2.getPasses());
		c.failures.addAll(ti1.getFailures());
		c.failures.addAll(ti2.getFailures());
		c.distinctFailures.addAll(ti1.getDistinctFailures());
		c.distinctFailures.addAll(ti2.getDistinctFailures());
		return c;
	}

	public void setTestId(int id) {
		this.id = id;
	}
	
	public List<Configuration> getAllDistingctConfs() {
		List<Configuration> distinctConfs = new ArrayList<Configuration>();
		List<Configuration> allConfs = getAllConfs();
		for (Configuration c : allConfs) {
			if(!distinctConfs.contains(c))
				distinctConfs.add(c);
		}
		return distinctConfs;
	}
	

	//not distinct
	public List<Configuration> getAllConfs() {
		List<Configuration> confs = new ArrayList<Configuration>();
		confs.addAll(passes);
		confs.addAll(failures);
		return confs;
	}
	
	public Set<String> getDistinctConfsStr(){
		Set<String> dconfs = new TreeSet<String>();
		List<Configuration> all = getAllConfs();
		for (Configuration c : all)
			dconfs.add(c.toString());
		return dconfs;
	}

	public List<Configuration> getAllConfsValid() {
		List<Configuration> confs = new ArrayList<Configuration>();
		confs.addAll(passesValid);
		confs.addAll(failuresValid);
		return confs;
	}

	public void addConf(Configuration conf) {
		// if(!configurations.contains(conf))
		configurations.add(conf);
	}

	public List<Configuration> getConfigurations() {
		return this.configurations;
	}

	public void addPassingConf(Configuration conf, boolean validate) {
		addConf(conf);
		// if(!passes.contains(conf)){
		passes.add(conf);
		if (validate) {
			if (conf.isValid() /* && !passesValid.contains(conf) */)
				passesValid.add(conf);
		}
		// }
	}

	public void addFailingConf(Configuration conf, boolean validate) {
		addConf(conf);
		// if (!failures.contains(conf)) {
		failures.add(conf);
		if (validate) {
			if (conf.isValid() /* && !failuresValid.contains(conf) */)
				failuresValid.add(conf);
		}
		// }
	}
	
	public void addDistictFailure(String dfailure){
		this.distinctFailures.add(dfailure);
	}
	
	public Set<String> getDistinctFailures(){
		return this.distinctFailures;
	}

	public String getTestName() {
		return this.testName;
	}

	public List<Configuration> getPasses() {
		return this.passes;
	}

	public List<Configuration> getPassesValid() {
		return this.passesValid;
	}

	public List<Configuration> getFailures() {
		return this.failures;
	}

	public List<Configuration> getFailuresValid() {
		return this.failuresValid;
	}

	public void setTime(long execTime) {
		this.time = execTime;
	}

	public long getTime() {
		return this.time;
	}

	@Override
	public TestInfo clone() {
		TestInfo result = new TestInfo(testName);
		result.id = id;
		result.time = time;
		result.configurations = new ArrayList<Configuration>(configurations);
		result.passes = new ArrayList<Configuration>(passes);
		result.passesValid = new ArrayList<Configuration>(passesValid);
		result.failures = new ArrayList<Configuration>(failures);
		result.failuresValid = new ArrayList<Configuration>(failuresValid);
		this.distinctFailures = new TreeSet<String>(distinctFailures);
		return result;
	}

}
