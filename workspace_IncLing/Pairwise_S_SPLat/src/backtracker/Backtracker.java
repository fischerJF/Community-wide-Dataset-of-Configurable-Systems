package backtracker;

import java.util.ArrayList;
import java.util.List;

import configuration.Configuration;
import entry.Entry;
import entry.FeatureVar;
//import sampling.Sampling;
import splat.SPLat;
import splat.Variables;
import trie.TrieST;

public class Backtracker {

	int nextChoice = 0;
	int numFVars = 0;
	int index = 0;
	int stsize = 0;
	int stNextChoice = 0;
	boolean forceChoose;
	boolean firstRun;
	TrieST<Boolean> generalTrie;
	public boolean pureSPLat;

	protected List<Entry> choices = new ArrayList<Entry>();

	// when running evosplat with 1 trie for all tests
	public Backtracker(boolean isPureSPLat, boolean frun, TrieST<Boolean> gTrie) {
//		this.firstRun = frun;
		this.firstRun = true;
		this.generalTrie = gTrie;
		this.counterSAT = 0;
		this.counterUNSAT = 0;
		this.csTime = 0;
		this.pureSPLat = isPureSPLat;
	}

	public void setFirstRun(boolean value){
		this.firstRun = value;
	}
	
	public TrieST<Boolean> getGeneralTrie() {
		return this.generalTrie;
	}

	public boolean isFirstRun() {
		return this.firstRun;
	}

	public List<Entry> getStack() {
		return this.choices;
	}

	public List<Entry> getStackClone() {
		List<Entry> choicesClone = new ArrayList<Entry>();
		Entry[] copy = choices.toArray(new Entry[choices.size()]);
		for (Entry entry : copy)
			choicesClone.add(((FeatureVar) entry).clone());
		return choicesClone;
	}

	public Backtracker clone() {
		Backtracker clone = new Backtracker(this.pureSPLat, this.firstRun, this.generalTrie);
		for (Entry entry : choices) {
			FeatureVar fvar = (FeatureVar) entry;
			clone.choices.add(fvar.clone());
		}
//		clone.choices.addAll(this.choices);
		return clone;
	}

	public int getNumFVars() {
		return this.numFVars;
	}

	public int getStNextChoiceClone() {
		int clone = stNextChoice;
		return clone;
	}

	public int getNextChoiceClone() {
		int clone = nextChoice;
		return clone;
	}

	public boolean hasMore() {
		// return !choices.isEmpty();
		boolean hasMore = false;
		if (stsize > 0)
			hasMore = !(choices.size() <= stsize);
		else
			hasMore = !choices.isEmpty();
		return hasMore;
	}

	public void backtrack() {
		if (nextChoice < numFVars) { // if (nextChoice < choices.size()) {
			// for (int i = nextChoice; i < limit; i++) {
			int i = nextChoice;
			while (nextChoice < choices.size()) {
				Entry e = choices.get(i);
				numFVars--;
				choices.remove(i);
				// index--;
			}
		}
		// the choices start after the subtree
		if (stsize > 0)
			nextChoice = stNextChoice;
		else
			nextChoice = 0;

		if ((choices.size() <= 0) || (choices.size() <= stsize)) {
			// System.err.println("no element on stack");
			return;
		}

		int i = choices.size() - 1;
		// remove all choices which have exhausted
		// leave the first non-exhausted choice unchanged
		for (; i >= 0; i--) {
			Entry e = choices.get(i);
			ChoiceGenerator choice = (IntervalChoiceGenerator) ((FeatureVar) e).getChoice();
			if (choice.hasNext()) {
				i--;
				break;
			}
			// remove all entries of the stack until this choice
			// choices.remove(i);
			int indexChoice = choices.size() - 1;
			for (; indexChoice >= i; indexChoice--) {
				Entry e1 = choices.get(indexChoice);
				numFVars--;
				choices.remove(indexChoice);
				if (choices.size() <= stsize)
					return;
			}
		}
		// backtrack all others
		for (; i >= 0; i--) {
			Entry e = choices.get(i);
			((FeatureVar) e).getChoice().backOne();
		}

		// the index start after the subtree
		if (stsize > 0)
			index = numFVars;
		else
			index = 0;

	}

	public int chooseAndPeek(int lo, int hi, FeatureVar fvar, Variables vars) {
		if (hi <= lo) {
			throw new IllegalArgumentException("invalid arguments to Backtrack.choose(int,int)");
		}
		IntervalChoiceGenerator choice = null;
		// recover an existing choice for a feature variable
		// that already is in the stack
		if (nextChoice < choices.size()) {
			Entry e = choices.get(index++);
			FeatureVar f = (FeatureVar) e;
			choice = (IntervalChoiceGenerator) f.getChoice();
		} else {
			// create a binary, non-deterministic, choice
			fvar.resetChoice();
			choices.add(index++, fvar);
			FeatureVar f = (FeatureVar) choices.get(choices.size() - 1);
			choice = (IntervalChoiceGenerator) f.getChoice();
			numFVars++;
			// also create a new element on the pc
			// note that these two go in lockstep
		}
		nextChoice++; // advance the choice
		if (!choice.hasNext())
			throw new RuntimeException();
		int result = choice.peek(); // mutate the choice
		// lastChoice = result;

		String value = (result == 0) ? "1" : "0";
		for (java.util.Map.Entry<FeatureVar, String> entry : vars.state.entrySet()) {
			if (entry.getKey().getName().equals(fvar.getName())) {
				vars.state.put(entry.getKey(), value);
				break;
			}
		}
		// vars.state.put(fvar, value);

		// index--;
		// numFVars--;
		return result;
	}
	
	public void nextConf(Variables vars){
		this.forceChoose = true;
		for (Entry entry : choices) {
			if (entry instanceof FeatureVar)
				chooseAndPeek((FeatureVar) entry, vars);
		}
		this.forceChoose = false;
		
//		int result;
//		vars.restore();
//		for (Entry e : choices) {
//			FeatureVar fvar = (FeatureVar) e;
//			result = fvar.getChoice().peek();
//			String value = (result == 0) ? "1" : "0";
//			for (java.util.Map.Entry<FeatureVar, String> entry : vars.state.entrySet()) {
//				if (entry.getKey().getName().equals(fvar.getName())) {
//					vars.state.put(entry.getKey(), value);
//					break;
//				}
//			}
//		}
	}
	
//	this.forceChoose = true;
//	for (Entry entry : choices) {
//		if (entry instanceof FeatureVar)
//			choose((FeatureVar) entry, vars);
//	}
//	this.forceChoose = false;

//	private int choose(int lo, int hi, FeatureVar fvar, Variables vars) {
//		if (hi <= lo) {
//			throw new IllegalArgumentException("invalid arguments to Backtrack.choose(int,int)");
//		}
//		IntervalChoiceGenerator choice = null;
//		// recover an existing choice for a feature variable
//		// that already is in the stack
//		if (nextChoice < choices.size()) {
//			Entry e = choices.get(index++);
//			FeatureVar f = (FeatureVar) e;
//			choice = (IntervalChoiceGenerator) f.getChoice();
//		} else {
//			// create a binary, non-deterministic, choice
//			fvar.resetChoice();
//			choices.add(index++, fvar);
//			FeatureVar f = (FeatureVar) choices.get(choices.size() - 1);
//			choice = (IntervalChoiceGenerator) f.getChoice();
//			numFVars++;
//			// also create a new element on the pc
//			// note that these two go in lockstep
//		}
//		nextChoice++; // advance the choice
//		try {
//			if (!choice.hasNext())
//				throw new RuntimeException();
//		} catch (Exception e) {
//			System.out.println("choice: " + choice);
//			e.printStackTrace();
//		}
//		int result = -1;
//
//		if (SPLat.validate && !SPLat.shouldSample) {
//			boolean isSAT;
//			// String pa = "";
//			do {
//				result = oneChoice(fvar, vars, choice);
//				isSAT = isSAT(vars);
//			} while (!isSAT && choice.hasNext());
//
//			if (!isSAT) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException();
//			}
//		}
//		if (SPLat.shouldSample) {
//			switch (Sampling.mode) {
//			case RANDOM:
//					result = random(fvar, vars, choice);
//				break;
//			case ONE_ENABLED:
//				result = oneEnabled(fvar, vars, choice);
//				break;
//			case ONE_DISABLED:
//				result = oneDisabled(fvar, vars, choice);
//				break;
//			case MOST_ENABLED_DISABLED:
//				result = mostEnabledDisabled(fvar, vars, choice);
//				break;
////			case COMBINATION:
////				result = combination(fvar, vars, choice);
////				break;
//			case PAIRWISE:
//				result = pairwise(fvar, vars, choice);
//				break;
//			// default :
//			// sample = false;
//
//			}
//		}
//
//		if (!SPLat.validate && !SPLat.shouldSample) {
//			result = choice.next();
//			String value = (result == 0) ? "1" : "0";
//			vars.state.put(fvar, value);
//		}
//
//		return result;
//	}
//
//	private int combination(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		boolean sample = false;
//		int result = -1;
//
//		if (!firstRun) {
//			if (SPLat.validate) {
//				boolean isSAT;
//				do {
//					result = oneChoice(fvar, vars, choice);
//					sample = Sampling.oneEnabled(vars) || Sampling.oneDisabled(vars);
//							//|| Sampling.mostEnabledDisabled(vars);
//					isSAT = isSAT(vars);
//				} while (!isSAT && choice.hasNext());
//				
//				if (!isSAT || !sample) {
//					// restore the state if the configuration is invalid
//					vars.restore();
//					if (!forceChoose)
//						throw new RuntimeException("NOT SAMPLE");
//				}
//			} else { //SPLat.validate
//				result = oneChoice(fvar, vars, choice);
//				sample = Sampling.oneEnabled(vars) || Sampling.oneDisabled(vars);
//						//|| Sampling.mostEnabledDisabled(vars);
//				
//				if (!sample) {
//					// restore the state if the configuration is invalid
//					vars.restore();
//					if (!forceChoose)
//						throw new RuntimeException("NOT SAMPLE");
//				}
//			}
//			
//		} else { //!firstRun
//			result = oneChoice(fvar, vars, choice);
//			sample = Sampling.mostEnabledDisabled(vars);
//		}
//
//		return result;
//	}
//
//	static int maxFeatures = 0;
//	private int mostEnabledDisabled(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		boolean sample = false;
//		int result = -1;
//
//		if (!firstRun) {
//			if (SPLat.validate) {
//				boolean isSAT;
//				// String pa = "";
//				do {
//					result = oneChoice(fvar, vars, choice);
//					sample = Sampling.mostEnabledDisabled(vars);
//					isSAT = isSAT(vars);
//				} while (!isSAT && choice.hasNext());
//
//				if (!isSAT || !sample) {
//					// restore the state if the configuration is invalid
//					vars.restore();
//					throw new RuntimeException("NOT SAMPLE");
//				}
//			} else {
//				result = oneChoice(fvar, vars, choice);
//				sample = Sampling.mostEnabledDisabled(vars);
//				
//				if (!sample) {
//					// restore the state if the configuration is invalid
//					vars.restore();
//					if (!forceChoose)
//						throw new RuntimeException("NOT SAMPLE");
//				}
//			}
//		} else {
//			result = oneChoice(fvar, vars, choice);
//			sample = Sampling.mostEnabledDisabled(vars);
//		}
//
//		return result;
//	}
//	
//	/**
//	 * Executes SPLat with the sampling algorithm: pairwise
//	 */
//	private int pairwise(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		int result = -1;
//		boolean sample;
//		
//		if (SPLat.validate) {
//			boolean isSAT;
//			// String pa = "";
//			do {
//				result = oneChoice(fvar, vars, choice);
//				isSAT = isSAT(vars);
//				sample = Sampling.pairwise(vars);
//			} while (!isSAT && !sample && choice.hasNext());
//
//			int currNumVars = vars.getNumDefinedVars();
//			int maxNumVars = vars.getMaxNumDefinedVars();
//			if (!isSAT || (!sample && currNumVars >= maxNumVars -1)) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException("NOT SAMPLE");
//			}
//		} else {
//			do {
//				result = oneChoice(fvar, vars, choice);
//				sample = Sampling.pairwise(vars);
//			} while (!sample && choice.hasNext());
//			
//			int currNumVars = vars.getNumDefinedVars();
//			int maxNumVars = vars.getMaxNumDefinedVars();
//			if (!sample && currNumVars >= maxNumVars -1) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException("NOT SAMPLE");
//			}
//		}
//		return result;
//	}
//
//	/**
//	 * Executes SPLat with the sampling algorithm: one-disabled
//	 */
//	private int oneDisabled(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		boolean sample = false;
//		int result = -1;
//		if (SPLat.validate) {
//			boolean isSAT;
//			// String pa = "";
//			do {
//				result = oneChoice(fvar, vars, choice);
//				sample = Sampling.oneDisabled(vars);
//				isSAT = isSAT(vars);
//			} while (!isSAT && choice.hasNext());
//			
//			if (!isSAT || !sample) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				throw new RuntimeException("NOT SAMPLE");
//			}
//		} else {
//			result = oneChoice(fvar, vars, choice);
//			sample = Sampling.oneDisabled(vars);
//
//			if (!sample) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				throw new RuntimeException("NOT SAMPLE");
//			}
//		}
//		
//		
//		return result;
//	}
//
//	private int random(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		int result = -1; 
//		
//		if (SPLat.validate) {
//			boolean isSAT;
//			// String pa = "";
//			do {
//				result = oneChoice(fvar, vars, choice);
//				isSAT = isSAT(vars);
//			} while (!isSAT && choice.hasNext());
//
//			if (!isSAT) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException();
//			}
//		} else result = oneChoice(fvar, vars, choice);
//		
//		return result;
//	}
//
//	private int oneChoice(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		int result = choice.next();
//		String value = (result == 0) ? "1" : "0";
//		vars.state.put(fvar, value);
//		return result;
//	}
//	
//	/**
//	 * Executes SPLat with the sampling algorithm: one-enabled
//	 */
//	private int oneEnabled(FeatureVar fvar, Variables vars, IntervalChoiceGenerator choice) {
//		// TODO: fix (maybe consider the first run)
//		int result;
//		boolean sample;
//		
//		if (SPLat.validate) {
//			boolean isSAT;
//			// String pa = "";
//			do {
//				result = oneChoice(fvar, vars, choice);
//				isSAT = isSAT(vars);
//				sample = Sampling.oneEnabled(vars);
//			} while (!isSAT && !sample && choice.hasNext());
//
//			int currNumVars = vars.getNumDefinedVars();
//			int maxNumVars = vars.getMaxNumDefinedVars();
//			if (!isSAT || (!sample && currNumVars >= maxNumVars -1)) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException("NOT SAMPLE");
//			}
//		} else {
//			do {
//				result = oneChoice(fvar, vars, choice);
//				sample = Sampling.oneEnabled(vars);
//			} while (!sample && choice.hasNext());
//			
//			int currNumVars = vars.getNumDefinedVars();
//			int maxNumVars = vars.getMaxNumDefinedVars();
//			if (!sample && currNumVars >= maxNumVars -1) {
//				// restore the state if the configuration is invalid
//				vars.restore();
//				if (!forceChoose)
//					throw new RuntimeException("NOT SAMPLE");
//			}
//		}
//		return result;
//	}

	/***** ACCESSING TRIES AND SAT SOLVER *****/

	int counterSAT;
	int counterUNSAT;

	public int getCounterSAT() {
		return counterSAT;
	}

	public int getCounterUNSAT() {
		return counterUNSAT;
	}

	TrieST<Boolean> trie;
	TrieST<Boolean> tempTrie;

	public TrieST getTrie() {
		return this.trie;
	}

	long timeWrite = 0;

	public void incrementTimeWrite(long time) {
		timeWrite += time;
	}

	public long getTimeWrite() {
		return timeWrite;
	}

	long timeLoad = 0;

	public long getTimeLoad() {
		return timeLoad;
	}

	long lookupTrieTime = 0;

	public long getTimeLookupTrie() {
		return lookupTrieTime;
	}

	long lookupTimeSolver = 0;

	public long getTimeLookupSolver() {
		return lookupTimeSolver;
	}

	long csTime;

	public long getCSTime() {
		return this.csTime;
	}

	private boolean isSAT(Variables vars) {
		boolean res = false;

		if (this.pureSPLat) {
			long ti = System.currentTimeMillis();
			Configuration conf = new Configuration(vars.getArrayFeatures());
			res = conf.isValid(vars.guidsl);
			csTime += System.currentTimeMillis() - ti;
//			System.err.println("CSTIME = " + csTime);

		} else {
			long ti = System.currentTimeMillis();
			String pa = vars.getPartialAssignment();
			/* use mapping if it exists */
			if (generalTrie.contains(pa)) {
				res = generalTrie.get(pa).booleanValue();
				csTime += System.currentTimeMillis() - ti;
//				System.err.println("CSTIME = " + csTime);
				return res;
			}

			/* new configuration => update trie */
			Configuration conf = new Configuration(vars.getArrayFeatures());
			res = conf.isValid(vars.guidsl);

			if (!generalTrie.contains(pa))
				generalTrie.put(pa, res);
			csTime += System.currentTimeMillis() - ti;
//			System.err.println("CSTIME = " + csTime);
		}

		// updating counters
		if (res)
			counterSAT++;
		else
			counterUNSAT++;

		return res;
	}

	/*******************************************************/

//	public boolean choose(FeatureVar fvar, Variables vars) {
//		return choose(0, 1, fvar, vars) == 0;
//	}

	public int chooseAndPeek(FeatureVar fvar, Variables vars) {
		return chooseAndPeek(0, 1, fvar, vars);
	}

	public String toString() {
		return choices.toString();
	}

//	public synchronized void forceChoose(Variables vars) {
//		this.forceChoose = true;
//		for (Entry entry : choices) {
//			if (entry instanceof FeatureVar)
//				choose((FeatureVar) entry, vars);
//		}
//		this.forceChoose = false;
//	}

	public void resetChoice() {
		nextChoice = 0;
	}

	public void reset() {
		this.choices = new ArrayList<Entry>();
		this.nextChoice = 0;
		this.numFVars = 0;
		this.index = 0;
		this.stsize = 0;
		this.stNextChoice = 0;

		this.timeWrite = 0;
		this.timeLoad = 0;
		this.counterSAT = 0;
		this.counterUNSAT = 0;
		this.lookupTrieTime = 0;
		this.lookupTimeSolver = 0;
	}

	public void addEntry(Entry entry) {
		choices.add(index++, (FeatureVar) entry);
		nextChoice++;
		numFVars++;
	}

	public void addAll(Backtracker st) {
		this.stsize = st.getStack().size();
		for (Entry entry : st.getStack()) {
			FeatureVar fvar = (FeatureVar) entry;
			choices.add(fvar);
			index++;
			nextChoice++;
			numFVars++;
			stNextChoice++;
		}
	}

}
