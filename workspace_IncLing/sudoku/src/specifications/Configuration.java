package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

  public static boolean BASE = true;
  public static boolean STATES = false;
  public static boolean UNDO = false;
  public static boolean COLOR = false;
  public static boolean SOLVER = false;
  public static boolean GENERATOR = false;
  public static boolean EXTENDEDSUDOKU = false;
  
  
  public static Tool tool = new Tool( "modified-model.m" );
  public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    
  public static boolean validProduct() {
   
    SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
    t.add(setBase());
    t.add(setSTATES());
    t.add(setUNDO());
    t.add(setCOLOR());
    t.add(setSOLVER());
    t.add(setGENERATOR());
    t.add(setEXTENDEDSUDOKU());
        
       return runTest( t, makeCnfFile ); 
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
 
    
  public static void productPrint() {
    
    System.out.println(/*"conf: */
     "UNDO:" + Configuration.UNDO+
     " STATES:" + Configuration.STATES+
     " SOLVER:" + Configuration.SOLVER+
     " GENERATOR:" + Configuration.GENERATOR+
     " EXTENDEDSUDOKU:" + Configuration.EXTENDEDSUDOKU+
     " COLOR:" + Configuration.COLOR+
     " BASE:" + Configuration.BASE
     
     );
//    if(Configuration.STATES)
//    System.out.print("STATES,");
//    
//    if(Configuration.UNDO)
//    System.out.print("UNDO,");  
//    
//    if(Configuration.COLOR)
//    System.out.print("COLOR,"); 
//    
//    if(Configuration.SOLVER)
//    System.out.print("SOLVER,");
//    
//    if(Configuration.GENERATOR)
//    System.out.print("GENERATOR,");
//    
//    if(Configuration.EXTENDEDSUDOKU)
//    System.out.print("EXTENDEDSUDOKU,");
//    
//     System.out.println();
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

public static String returnProduct() {
	return  "UNDO:" + Configuration.UNDO+
		     " STATES:" + Configuration.STATES+
		     " SOLVER:" + Configuration.SOLVER+
		     " GENERATOR:" + Configuration.GENERATOR+
		     " EXTENDEDSUDOKU:" + Configuration.EXTENDEDSUDOKU+
		     " COLOR:" + Configuration.COLOR+
		     " BASE:" + Configuration.BASE;
}

}