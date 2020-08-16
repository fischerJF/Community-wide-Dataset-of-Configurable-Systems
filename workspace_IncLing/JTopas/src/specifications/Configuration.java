package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

  
  
  
  
  public static boolean BASE = true;
  public static boolean TOKENPOSONLY = false;
  public static boolean COUNTLINES = false;
  public static boolean IMAGEPARTS = false;
  public static boolean BLOCKCOMMENTS = false;
  public static boolean LINECOMMENTS = false;

  public static Tool tool = new Tool( "modified-model.m" );
  public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    
  public static boolean validProduct() {
    
    SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
    t.add(setBase());
    t.add(setTOKENPOSONLY());
    t.add(setCOUNTLINES());
    t.add(setIMAGEPARTS());
    t.add(setBLOCKCOMMENTS());
    t.add(setLINECOMMENTS());
            
       return runTest( t, makeCnfFile ); 
  }
  
  public static boolean runTest( SATtest t, boolean compat ) {
    return (tool.modelDebug(t, makeCnfFile ))? true: false;
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
  
  
  
  public static void productPrint() {
    System.out.println(
                "TOKENPOSONLY:" + Configuration.TOKENPOSONLY+ 
               " LINECOMMENTS:"+ Configuration.LINECOMMENTS+
               " IMAGEPARTS:"+Configuration.IMAGEPARTS+ 
               " COUNTLINES:" + Configuration.COUNTLINES + 
               " BLOCKCOMMENTS:"+ Configuration.BLOCKCOMMENTS+
               " BASE:" + Configuration.BASE
               
           );
               
        
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

  public static int SMALL_LOOPS = 40;
  public static String INPUT_PIECE;


public static String returnProduct() {
	return
            "TOKENPOSONLY:" + Configuration.TOKENPOSONLY+ 
           " LINECOMMENTS:"+ Configuration.LINECOMMENTS+
           " IMAGEPARTS:"+Configuration.IMAGEPARTS+ 
           " COUNTLINES:" + Configuration.COUNTLINES + 
           " BLOCKCOMMENTS:"+ Configuration.BLOCKCOMMENTS+
           " BASE:" + Configuration.BASE;
}
}