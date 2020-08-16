package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationSudoku  extends Specification{
	public static boolean BASE = true;
	  public static boolean STATES = false;
	  public static boolean UNDO = false;
	  public static boolean COLOR = false;
	  public static boolean SOLVER = false;
	  public static boolean GENERATOR = false;
	  public static boolean EXTENDEDSUDOKU = false;
	  
	private static SpecificationSudoku SINGLETON;
    
	public static SpecificationSudoku getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationSudoku();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
	    return (tool.modelDebug(t, makeCnfFile ))? true: false;
	  }

	  public static String setBase() {
	    return (BASE) ? "BASE___" : "-BASE___";
	  }
	  public static String setSTATES() {
	    return (STATES) ? "STATES___" : "-STATES___";
	  }
	  
	  public static String setUNDO() {
	    return (UNDO) ? "UNDO___" : "-UNDO___";
	  }
	  
	  public static String setCOLOR() {
	    return (COLOR) ? "COLOR___" : "-COLOR___";
	  }
	  public static String setSOLVER() {
	    return (SOLVER) ? "SOLVER___" : "-SOLVER___";
	  }
	  public static String setGENERATOR() {
	    return (GENERATOR) ? "GENERATOR___" : "-GENERATOR___";
	  }
	  public static String setEXTENDEDSUDOKU() {
	    return (EXTENDEDSUDOKU) ? "EXTENDEDSUDOKU___" : "-EXTENDEDSUDOKU___";
	  }
	 
	    

	  public static void init(String... args) {
	    int index = 0;
	    BASE = Boolean.valueOf(args[index++]);
	    STATES = Boolean.valueOf(args[index++]);
	    UNDO = Boolean.valueOf(args[index++]);
	    COLOR = Boolean.valueOf(args[index++]);
	    SOLVER = Boolean.valueOf(args[index++]);
	    GENERATOR = Boolean.valueOf(args[index++]);
	 
	  }
	  public boolean thereIsBase() {
	    	return true;
	    }

}
