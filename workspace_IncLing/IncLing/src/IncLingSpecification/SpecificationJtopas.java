package IncLingSpecification;


import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationJtopas  extends Specification{
	public static boolean BASE = true;
	  public static boolean TOKENPOSONLY = false;
	  public static boolean COUNTLINES = false;
	  public static boolean IMAGEPARTS = false;
	  public static boolean BLOCKCOMMENTS = false;
	  public static boolean LINECOMMENTS = false;
	
	private static SpecificationJtopas SINGLETON;
    
	public static SpecificationJtopas getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationJtopas();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static String setBase() {
	    return (BASE) ? "BASE___" : "-BASE___";
	  }
	  public static String setTOKENPOSONLY() {
	    return (TOKENPOSONLY) ? "TOKENPOSONLY___" : "-TOKENPOSONLY___";
	  }
	  
	  public static String setCOUNTLINES() {
	    return (COUNTLINES) ? "COUNTLINES___" : "-COUNTLINES___";
	  }
	  
	  public static String setIMAGEPARTS() {
	    return (IMAGEPARTS) ? "IMAGEPARTS___" : "-IMAGEPARTS___";
	  }
	  public static String setBLOCKCOMMENTS() {
	    return (BLOCKCOMMENTS) ? "BLOCKCOMMENTS___" : "-BLOCKCOMMENTS___";
	  }
	  
	  public static String setLINECOMMENTS() {
	    return (LINECOMMENTS) ? "LINECOMMENTS___" : "-LINECOMMENTS___";
	  }
	  public static void init(String... args) {
	    int index = 0;
	    BASE = Boolean.valueOf(args[index++]);    
	    TOKENPOSONLY = Boolean.valueOf(args[index++]);
	    IMAGEPARTS = Boolean.valueOf(args[index++]);
	    COUNTLINES = Boolean.valueOf(args[index++]);
	    BLOCKCOMMENTS = Boolean.valueOf(args[index++]);
	    LINECOMMENTS = Boolean.valueOf(args[index++]);
	    
	  }
	  public boolean thereIsBase() {
	    	return true;
	    }
}
