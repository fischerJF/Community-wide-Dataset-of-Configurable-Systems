package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationCompanies  extends Specification{
	public static boolean TREE_STRUCTURE = true;
	  public static boolean LOGGING = false;
	  public static boolean CUT_WHATEVER = false;
	  public static boolean CUT_NO_DEPARTMENT = false;
	  public static boolean CUT_NO_MANAGER = false;
	  public static boolean GUI = false;
	  public static boolean PRECEDENCE = false;
	  public static boolean TOTAL_WALKER = false;
	  public static boolean TOTAL_REDUCER = false;
	  public static boolean ACCESS_CONTROL = false;
	  
	private static SpecificationCompanies SINGLETON;
    
	public static SpecificationCompanies getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationCompanies();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
	    return (tool.modelDebug(t, makeCnfFile ))? true: false;
	  }

	 public static String setTREE_STRUCTURE() {
		    return (TREE_STRUCTURE) ? "TREE_STRUCTURE___" : "-TREE_STRUCTURE___";
		  }

		  public static String setLOGGING() {
		    return (LOGGING) ? "LOGGING___" : "-LOGGING___";
		  }

		  public static String setCUT_WHATEVER() {
		    return (CUT_WHATEVER) ? "CUT_WHATEVER___" : "-CUT_WHATEVER___";
		  }

		  public static String setCUT_NO_DEPARTMENT() {
		    return (CUT_NO_DEPARTMENT) ? "CUT_NO_DEPARTMENT___"
		        : "-CUT_NO_DEPARTMENT___";
		  }

		  public static String setCUT_NO_MANAGER() {
		    return (CUT_NO_MANAGER) ? "CUT_NO_MANAGER___" : "-CUT_NO_MANAGER___";
		  }

		  public static String setGUI() {
		    return (GUI) ? "GUI___" : "-GUI___";
		  }

		  public static String setPRECEDENCE() {
		    return (PRECEDENCE) ? "PRECEDENCE___" : "-PRECEDENCE___";
		  }

		  public static String setTOTAL_WALKER() {
		    return (TOTAL_WALKER) ? "TOTAL_WALKER___" : "-TOTAL_WALKER___";
		  }

		  public static String setTOTAL_REDUCER() {
		    return (TOTAL_REDUCER) ? "TOTAL_REDUCER___" : "-TOTAL_REDUCER___";
		  }

		  public static String setACCESS_CONTROL() {
		    return (ACCESS_CONTROL) ? "ACCESS_CONTROL___" : "-ACCESS_CONTROL___";
		  }

		  public boolean thereIsBase() {
		    	return false;
		    }

		  public static void init(String... args) {
		    int index = 0;
		    TREE_STRUCTURE = Boolean.valueOf(args[index++]);
		    LOGGING = Boolean.valueOf(args[index++]);
		    CUT_WHATEVER = Boolean.valueOf(args[index++]);
		    CUT_NO_DEPARTMENT = Boolean.valueOf(args[index++]);
		    CUT_NO_MANAGER = Boolean.valueOf(args[index++]);
		    GUI = Boolean.valueOf(args[index++]);
		    PRECEDENCE = Boolean.valueOf(args[index++]);
		    TOTAL_WALKER = Boolean.valueOf(args[index++]);
		    TOTAL_REDUCER = Boolean.valueOf(args[index++]);
		    ACCESS_CONTROL = Boolean.valueOf(args[index++]);

		  }

}
