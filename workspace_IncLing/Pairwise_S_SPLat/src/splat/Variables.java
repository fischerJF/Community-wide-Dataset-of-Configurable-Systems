package splat;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import entry.FeatureVar;
import model.GUIDSL_Interface;

/**
 * @author sabrinasouto
 *
 */
/**
 * @author sabrinasouto
 *
 */
public abstract class Variables {
  
  @SuppressWarnings("rawtypes")
//  public Map<Enum, String> state = new LinkedHashMap<Enum, String>();
  public Map<FeatureVar, String> state = new LinkedHashMap<FeatureVar, String>();
  public Map<Enum, String> mapValues = new LinkedHashMap<Enum, String>();
  
  public boolean validate;
  
  public void setValidate(boolean checkValidate){
	  this.validate = checkValidate;
  }
  
  public abstract Map<FeatureVar, String> getState();
  
  public abstract String getSPLName();
  
	public String getPartialAssignment() {
		String pa = "";
		int index = 0;
		for (java.util.Map.Entry<FeatureVar, String> entry : state.entrySet()) {
			if (!entry.getValue().equals("?"))
				pa += index + (entry.getValue().equals("1") ? "T" : "F");
			index++;
		}
		return pa;
	}
	
	/**
	 * Compute all possible variable assignments.
	 */
	public List<VarAssignment> getAllVarValues() {
		List<VarAssignment> allVarValues = new ArrayList<VarAssignment>();
		for (java.util.Map.Entry<FeatureVar, String> entry : state.entrySet()) {
			String var = entry.getKey().getName();
			allVarValues.add(new VarAssignment(var, "0"));
			allVarValues.add(new VarAssignment(var, "1"));
		}
		return allVarValues;
	}
	
	/**
	 * Compute the variable assignments in state.
	 */
	public List<VarAssignment> getVarsAccessed(){
		List<VarAssignment> varValues = new ArrayList<VarAssignment>();
		for (java.util.Map.Entry<FeatureVar, String> entry : state.entrySet()) {
			if(!entry.getValue().equals("?"))
				varValues.add(new VarAssignment(entry.getKey().getName(), entry.getValue()));
		}
		return varValues;
	}
	
	/**
	 * Sets all state with a given value.
	 */
	public void setAll(String value) {
		for (java.util.Map.Entry<FeatureVar, String> entry : state.entrySet()) {
			FeatureVar key = entry.getKey();
			state.put(key, value);
		}
	}

  
  public GUIDSL_Interface guidsl;
  
	protected GUIDSL_Interface loadGUIDSL(Variables vars)
			throws ClassNotFoundException, IllegalArgumentException,
			SecurityException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException, IOException {
		String homeDir = (new File(".")).getCanonicalPath();
		String oracleModelPath = homeDir + "/modified-model.m";
		return new GUIDSL_Interface(oracleModelPath, vars);
	}
	

	/**
	 * Update the global state with a feature variable state in a subtree 
	 */
	public void updateState(Map<FeatureVar, String> stateSubtree, FeatureVar fvar) {
		String value = "";
		//look for the state of fvar in stateSubtree
		for (java.util.Map.Entry<FeatureVar, String> e : stateSubtree.entrySet()) {
			if(e.getKey().getName().equals(fvar.getName())){
				value = e.getValue();//pick the state value in stateSubtree
				break;
			}
		}
		// update the global state with the state value of fvar in stateSubtree
		for (java.util.Map.Entry<FeatureVar, String> e : state.entrySet()) {
			if(e.getKey().getName().equals(fvar.getName())){
				state.put(e.getKey(), value);
				break;
			}
		}
	}
	
	/**
	 * Update the global state according to a given initial state 
	 */
	public void updateState(Map<FeatureVar, String> initialState) {
		Iterator<java.util.Map.Entry<FeatureVar, String>> itState = state.entrySet().iterator();
		Iterator<java.util.Map.Entry<FeatureVar, String>> itInitialState = initialState.entrySet().iterator();
		while(itState.hasNext() && itInitialState.hasNext()){
			java.util.Map.Entry<FeatureVar, String> entryState = itState.next();
			java.util.Map.Entry<FeatureVar, String> entryInitialState = itInitialState.next();
			state.put(entryState.getKey(), entryInitialState.getValue());
		}
	}

  public static enum VARS {};
  
  public abstract void restore();
  
	public Map<FeatureVar, String> getStateClone() {
		// LinkedHashMap<FeatureVar, String> stateClone =
		// (LinkedHashMap<FeatureVar, String>) state.clone();
		Map<FeatureVar, String> stateClone = new LinkedHashMap<FeatureVar, String>();
		for (java.util.Map.Entry<FeatureVar, String> e : state.entrySet()) {
			FeatureVar fvar = ((FeatureVar) e.getKey()).clone();
			String value = e.getValue();
			stateClone.put(fvar, value);
		}
		return stateClone;
	}
  
  public int numVarsRead(){
    int num = 0;
    for (@SuppressWarnings("rawtypes") Map.Entry<FeatureVar, String> entry : state.entrySet()) {
      if (!entry.getValue().equals("?")) {
        num++;
      }
    }
    return num;
  }
  
  public synchronized String toString() {
    Collection<String> values = this.state.values();
    //Collection<String> values = this.mapValues.values();
    String result = "";
    for (String v : values) {
        result += v + ",";
    }
    return result;
  }
  
  public int getNumFVarsTouched() {
	int num = 0;
    Collection<String> values = this.state.values();
    for (String v : values) {
        if(!v.equals("?"))
        	num++;
    }
    return num;
  }
  
  public int getNumVarsDisabled(){
	  int num = 0;
	    Collection<String> values = this.state.values();
	    for (String v : values) {
	        if(v.equals("0"))
	        	num++;
	    }
	    return num;
  }
  
  public int getNumVarsEnabled(){
	  int num = 0;
	    Collection<String> values = this.state.values();
	    for (String v : values) {
	        if(v.equals("1"))
	        	num++;
	    }
	    return num;
  }
  
  public String[] getArrayFeatures() {
	    Collection<String> values = this.state.values();
	    String[] features = new String[values.size()];
	    String result = "";
	    int i = 0;
	    for (String v : values) {
	    	features[i++] = v;
	    }
	    return features;
	  }
  
  public int getNumDefinedVars() {
	    Collection<String> values = this.state.values();
	    int numDefinedVars = 0;
	    String result = "";
	    for (String v : values) {
	    	if(!v.equals("?"))
	    		numDefinedVars++;
	    }
	    return numDefinedVars;
	  }
  
	public List<FeatureVar> getAccessedVars() {
		List<FeatureVar> varAccesses = new ArrayList<FeatureVar>();
		for (Entry<FeatureVar, String> entry : state.entrySet()) {
			FeatureVar var = entry.getKey();
			String value = entry.getValue();
			if (!value.equals("?")){
				if ((!(this instanceof PrevaylerVariables)) && (!var.getName().contains("BASE")))
					varAccesses.add(var);
				else if(this instanceof PrevaylerVariables) 
					varAccesses.add(var);
			}
		}
		return varAccesses;
	}
  
  public static int maxNumVars = 0;
  public int getMaxNumDefinedVars(){
	  int currentNumVars = getNumDefinedVars();
	  if(maxNumVars < currentNumVars)
		  maxNumVars = currentNumVars;
	  return maxNumVars;
  }
  
  // only works for weka
  public synchronized String getOptions() {
    Collection<String> opts = this.mapValues.values();
    String result = "";
    int counter = 0;
    for (String v : opts) {
      counter++;
      if (counter == 3)
        result += "-C " + v + " ";
      else if (counter == 4)
        result += "-M " + v + " ";
      if (counter == 6)
        result += "-N " + v + " ";
      if (counter == 12)
        result += "-Q " + v + " ";
      else
        result += "-" + v + " ";
    }
    return result;
  }
  
  @SuppressWarnings("rawtypes")
  public Map<String, String> load(String[] args) {
    int i = 0;
    Map<String, String> res = new LinkedHashMap<String, String>();
    for (FeatureVar e : state.keySet()) {
      res.put(e.toString(), args[i++]);
    }
    return res;
  }
  
  public List<String> getFeatures(String[] args) {
    List<String> features = new ArrayList<String>();
    int i = 0;
    for (FeatureVar e : state.keySet()) {
      if(i >= args.length)
        break;
      if (args[i].equals("1")) {
        features.add(e.getName());
      } else if (args[i].equals("0")) {
        features.add("-" + e.getName());
      }
      i++;
    }
    return features;
  }
  

	

}
