package configuration;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import model.GUIDSL_Interface;
import stats.LogAnalyzer;

/**
 * Implements the concept of configuration: a list of features. Represents a
 * configuration through: a list of features, an array of features, or a logical
 * formula (conjunction of features).
 */
public class Configuration {

	private List<COV> configuration;

	/**
	 * Build a configuration through a given list of features.
	 */
	public Configuration(List<COV> conf) {
		this.configuration = conf;
	}
	
	public Configuration(String conf) {
		String f = "";
		this.configuration = new LinkedList<COV>();
		for (int i = 0; i < conf.length(); i++) {
			f = conf.charAt(i) + "";
			if (f.equals("0"))
				configuration.add(COV.Disabled0);
			else if (f.equals("-1"))
				configuration.add(COV.Disabled1);
			else if (f.equals("1"))
				configuration.add(COV.Enabled1);
			else if (f.equals("2"))
				configuration.add(COV.Enabled2);
			else if (f.equals("3"))
				configuration.add(COV.Enabled3);
			else
				configuration.add(COV.Untouched);
		}
	}

	public Configuration() {
		this.configuration = new LinkedList<COV>();
	}

	// Configuration c = new Configuration(new String[]{"?", "0", "?", "1"});
	public Configuration(String[] features) {
		this.configuration = new LinkedList<COV>();
		for (String f : features) {
			if (f.equals("0"))
				configuration.add(COV.Disabled0);
			else if (f.equals("-1"))
				configuration.add(COV.Disabled1);
			else if (f.equals("1"))
				configuration.add(COV.Enabled1);
			else if (f.equals("2"))
				configuration.add(COV.Enabled2);
			else if (f.equals("3"))
				configuration.add(COV.Enabled3);
			else
				configuration.add(COV.Untouched);
		}
	}

//	public Configuration(List<String> cov) {
//		this.configuration = new LinkedList<COV>();
//		for (String f: cov) {
//			if (f.equals("0"))
//				configuration.add(COV.Disabled0);
//			else if (f.equals("-1"))
//				configuration.add(COV.Disabled1);
//			else if (f.equals("1"))
//				configuration.add(COV.Enabled1);
//			else if (f.equals("2"))
//				configuration.add(COV.Enabled2);
//			else if (f.equals("3"))
//				configuration.add(COV.Enabled3);
//			else
//				configuration.add(COV.Untouched);
//		}
//	}

	/**
	 * Checks if this configuration is valid according to 
	 * the model specified in the solver in use.
	 */
	public boolean isValid(GUIDSL_Interface guidsl) {
		String[] conf = getConfArray();
		return guidsl.check(conf);
	}

	public void addFeature(COV status) {
		this.configuration.add(status);
	}

	/**
	 * @return a configuration represented by a list of features.
	 */
	public List<COV> getConf() {
		return this.configuration;

	}

	public boolean equals(Object o) {
		if (o instanceof Configuration) {
			if (((Configuration) o).getFc().equals(this.getFc())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return a configuration represented by an array of features.
	 */
	public String[] getConfArray() {
		String[] res = new String[configuration.size()];
		for (int i = 0; i < configuration.size(); i++) {
			res[i] = configuration.get(i).toString();
		}
		return res;
	}

	/**
	 * @return a configuration represented by a logical formula: a conjunction
	 *         of literals.
	 */
	public String getFc() {
		List<String> fcLiteral = getFcLiteral();
		String fc = "";

		if (fcLiteral.size() == 1)
			fc += fcLiteral.get(0);
		else {
			fc += "(and ";
			for (int i = 0; i < fcLiteral.size(); i++) {
				String literal = fcLiteral.get(i);
				fc += literal + " ";
			}
			fc += ")";
		}
		return fc;
	}

	/**
	 * Print a configuration represented by literals
	 */
	public String fcLiteralToString() {
		String fc = "";
		for (String f : getFcLiteral()) {
			fc += f + " ";
		}
		return fc;
	}

	/**
	 * @return a configuration represented by literals in z3 format.
	 */
	public List<String> getFcLiteral() {
		List<String> expression = new LinkedList<String>();
		for (int i = 0; i < configuration.size(); i++) {
			String feature = configuration.get(i).toString();
			if (!feature.equals("?")) {
				int index = i + 1;
				expression.add(feature.equals("1") ? ("f" + index) : ("(not f"
						+ index + ")"));
			}
		}
		return expression;
	}

//	public String getFcond() {
//		List<String> fcLiteral = value2OptionList();
//		String fc = "";
//		if (!fcLiteral.isEmpty()) {
//			if (fcLiteral.size() == 1)
//				fc += fcLiteral.get(0);
//			else {
//				fc += "(and ";
//				for (int i = 0; i < fcLiteral.size(); i++) {
//					String literal = fcLiteral.get(i);
//					fc += literal + " ";
//				}
//				fc += ")";
//			}
//		}
//		return fc;
//	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		String out = "";
		for (COV c : this.configuration) {
			out += c;
		}
		return out;
	}


	// for (Enum e : map.keySet()) {
	public List<String> getFormula() {
		List<String> expression = new LinkedList<String>();
		for (int i = 0; i < configuration.size(); i++) {
			String feature = configuration.get(i).toString();
			if (!feature.equals("?")) {
				int index = i + 1;
				expression.add(feature.equals("1") ? ("f" + index) : ("(not f"
						+ index + ")"));
			}
		}
		return expression;
	}



	/**
	 * Create random configurations to be used in tests
	 * 
	 * @param numVars
	 *            - number of feature variables
	 * @return - a new random configuration
	 */
	public static Configuration generateRandomConf(int numVars) {
		Configuration conf = new Configuration();
		Random r = new Random();
		int randomFeatureValue = r.nextInt(2);
		for (int i = 0; i < numVars; i++) {
			if (randomFeatureValue == 0)
				conf.addFeature(COV.Disabled0);
			else if (randomFeatureValue == 1)
				conf.addFeature(COV.Enabled1);
			else
				conf.addFeature(COV.Untouched);
		}
		return conf;
	}

	public boolean isValid() {
//		return isValid(LogAnalyzer.vars.guidsl);
		return false; //TODO to do
	}

}
