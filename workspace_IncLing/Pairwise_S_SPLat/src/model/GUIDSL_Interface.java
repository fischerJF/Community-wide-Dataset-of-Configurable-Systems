package model;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import splat.Variables;
import configuration.COV;
import guidsl.SATtest;
import guidsl.Tool;

public class GUIDSL_Interface {

  private Variables v;
  private Tool tool;

  /**
   * Creates a checker to verify if a given configuration is valid according to
   * the loaded model.
   * 
   * @param modelPath
   *          - model (.m)
   * @param v
   *          - reference to the complete set of features that represents the
   *          model.
   * @throws ClassNotFoundException 
   * @throws NoSuchMethodException 
   * @throws InvocationTargetException 
   * @throws IllegalAccessException 
   * @throws SecurityException 
   * @throws IllegalArgumentException 
   */
  public GUIDSL_Interface(String modelFilePath, String subjectName) throws ClassNotFoundException, IllegalArgumentException, SecurityException, IllegalAccessException, InvocationTargetException, NoSuchMethodException {
    // check if model is found
    if (!(new File(modelFilePath)).exists()) {
      throw new RuntimeException("Cannot find .m file");
    }
    // Variables class (for each subject)
    String variablesClassName;
    if (subjectName.equals("notepad")) {
      variablesClassName = "splat.NotepadVariables";
    } else if (subjectName.equals("gpl")) {
      variablesClassName = "splat.GPLVariables";
    } else if (subjectName.equals("zipme")) {
      variablesClassName = "splat.ZipMeVariables"; 
    } else if (subjectName.equals("companies")) {
      variablesClassName = "splat.CompaniesVariables"; 
    } else if (subjectName.equals("xstream")) {
      variablesClassName = "splat.XStreamVariables"; 
    } else if (subjectName.equals("jtopas")) {
      variablesClassName = "splat.JTopasVariables"; 
    } else if (subjectName.equals("email")) {
      variablesClassName = "splat.EmailVariables"; 
    } else if (subjectName.equals("sudoku")) {
      variablesClassName = "splat.SudokuVariables"; 
    } else if (subjectName.equals("berkeleydb")) {
      variablesClassName = "splat.BerkeleyDbVariables"; 
    } else if (subjectName.equals("desktopsearcher")) {
      variablesClassName = "splat.DesktopSearcherVariables"; 
    } else if (subjectName.equals("synoptic")) {
      variablesClassName = "splat.SynopticVariables"; 
    } else if (subjectName.equals("weka")) {
      variablesClassName = "splat.WekaVariables"; 
    } else if (subjectName.equals("prevayler")) {
        variablesClassName = "splat.PrevaylerVariables"; 
    } else if (subjectName.equals("minepump")) {
        variablesClassName = "splat.MinePumpVariables"; 
    } else if (subjectName.equals("elevator")) {
        variablesClassName = "splat.ElevatorVariables"; 
    } else if (subjectName.equals("desktopsearcher")) {
        variablesClassName = "splat.DesktopSearcherVariables"; 
    }
    
    else {
      throw new UnsupportedOperationException("TODO");
    }
    Class<?> variableClazz = Class.forName(variablesClassName);
    this.v = (Variables) variableClazz
        .getMethod("getSINGLETON", new Class<?>[] {})
        .invoke(null, new Object[] {});
    
    if (v == null) {
        throw new RuntimeException("Could not find getSINGLETON() on class " + variableClazz);
    }
    
    tool = new Tool(modelFilePath);
  }

  public GUIDSL_Interface(String modelFilePath, Variables vars) {
	  tool = new Tool(modelFilePath);
	  this.v = vars;
  }

/**
   * Checks if a given configuration is valid according to the model.
   */
  public boolean check(String[] configuration) {
    // result of the test (if you want the selected features
    // are compatible or incompatible)
    boolean result = true;
    
    // isComplete - I'm note sure, because there is no documentation 
    // about this parameter. I understand that it indicates if the features 
    // represent the set of all features, in our case it is true.
    boolean isComplete = true;

    // A SATtest object defines a model test, each test has a name and 
    // an outcome (satifiable or not), that is the result plus the list 
    // of feature selections this information (along with the model predicate) 
    // are submitted to a SAT solver for verifying the outcome.
    SATtest t = new SATtest("testConfiguration", result, isComplete);
    for (String feature : v.getFeatures(configuration)) {
      t.add(feature);
    }
    
    // makeCnfFile - if true, the method will make a file with the CNF 
    // representation of the model + SATtest. False, otherwise.
    boolean makeCnfFile = true;
    boolean currresult = false;
    try{
      currresult = tool.modelDebug(t, makeCnfFile);
    } catch(Exception e){
      e.getStackTrace();
      System.out.println(t.toString());
    }
    return currresult;
   
  }
  
  public static String getOracleModel(String homeDir, String subjectName) {
    String result;
    if (subjectName.equals("companies") 
        || subjectName.equals("gpl")
        || subjectName.equals("notepad")
        || subjectName.equals("zipme")
        || subjectName.equals("xstream")
        || subjectName.equals("jtopas")
        || subjectName.equals("email")
        || subjectName.equals("berkeleydb")
        || subjectName.equals("desktopsearcher")
        || subjectName.equals("synoptic")
        || subjectName.equals("weka")
        || subjectName.equals("elevator")
        || subjectName.equals("desktopsearcher")
        || subjectName.equals("prevayler")
        || subjectName.equals("minepump")
        || subjectName.equals("sudoku")) {
//      result = homeDir + "/src-subjects-splat/" +  subjectName + "/modified-model.m";
      result = homeDir + "/src-subjects/" +  subjectName + "/modified-model.m";
      System.out.println("looking for oracle in:" + result);
    } else if (subjectName.equals("synoptic")){ 
      result = homeDir + "/src-subjects-splat/" +  subjectName + "/" + subjectName + "/modified-model.m";
      System.out.println("looking for oracle in:" + result);
    }else {
      throw new UnsupportedOperationException("Unknown subject - please add the case in this method");
    }
    return result;
  }

  public String check(List<COV> conf) {
    String[] tmp = new String[conf.size()];
    for (int i = 0; i < conf.size(); i++) {
      tmp[i] = conf.get(i).toString();
    }
    return check(tmp) ? "V" : "I";
  }
  

//public static void main(String[] args) 
//    throws IOException, ClassNotFoundException, 
//    IllegalArgumentException, SecurityException, 
//    IllegalAccessException, InvocationTargetException, 
//    NoSuchMethodException {
//  
//  String subjectName = "gpl";
//  String homeDir = (new File(".")).getCanonicalPath();
//  String oracleModel = getOracleModel(homeDir, subjectName);
//  
//  // GUIDSL do not support to load more than one model by execution
//  // so, please do not call GUIDSL_Interface constructor more than once 
//  // in the same execution.
//  GUIDSL_Interface guidsl = new GUIDSL_Interface(oracleModel, subjectName);
//  
//  if (subjectName.equals("notepad")) {
//    testNotepad(guidsl);
//  } else if (subjectName.equals("gpl")) {
//    testGPL(guidsl);
//  } else if (subjectName.equals("zipme")) {
//    testZipme(guidsl);
//  } else if (subjectName.equals("companies")) {
//    testCompanies(guidsl);
//  } else if (subjectName.equals("xstream")) {
//    testXStream(guidsl);
//  } else if (subjectName.equals("jtopas")) {
//    testJTopas(guidsl);
//  } else if (subjectName.equals("email")) {
//    testEmail(guidsl);
//  } else if (subjectName.equals("sudoku")) {
//    testSudoku(guidsl);
//  } else if (subjectName.equals("berkeleydb")) {
//    testBerkeleyDb(guidsl);
//  } else if (subjectName.equals("desktopsearcher")) {
//    testDesktopSearcher(guidsl);
//  } else {
//    throw new UnsupportedOperationException("TODO");
//  }
//  
//}

//private static void testBerkeleyDb(GUIDSL_Interface guidsl) {
//  // TODO Auto-generated method stub
//  
//}
//
//public static void testSudoku(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"0", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//}
//
//public static void testNotepad(GUIDSL_Interface guidsl) {
//  String[] configuration1 = new String[] { "1", "1", "1", "0", "0", "1", "1",
//      "1", "1", "1", "1", "1", "0", "0", "1", "1", "1" };
//  System.out.println(guidsl.check(configuration1));
//
//  String[] configuration2 = new String[] { "1", "0", "0", "?", "?", "?", "?",
//      "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration2));
//  
//  String[] configuration3 = new String[] { "0", "?", "?", "?", "?", "?", "?",
//      "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration3));
//  
//  String[] configuration4 = new String[] { "1", "?", "?", "1", "?", "?", "?",
//      "?", "?", "?", "?", "?", "?", "?", "?", "?", "1" };
//  System.out.println(guidsl.check(configuration4));
//  
//  String[] configuration5 = new String[] { "1", "0", "?", "1", "?", "?", "?",
//      "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration5));
//}
//
//public static void testGPL(GUIDSL_Interface guidsl){
////  String[] configuration1 = new String[]   
////      { "1", "?", "1", "1", "1", "0", "0", "1", "1", "0", "0", "1", "0" };
////  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      { "?", "1", "?", "?", "?", "?", "?", "?", "?", "0", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration2));
////  
////  String[] configuration3 = new String[]   
////      { "0", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
////  System.out.println(guidsl.check(configuration3));
//}
//
//public static void testZipme(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"1", "0", "0", "0", "1", "0", "?", "0", "0", "1", "1", "0", "0", "0" };
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration2));
//  
//  String[] configuration3 = new String[]   
//      {"0", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?" };
//  System.out.println(guidsl.check(configuration3));
//}
//
//public static void testCompanies(GUIDSL_Interface guidsl){
////  String[] configuration1 = new String[]   
////      {"1", "0", "?", "1", "1", "?", "?", "?", "?", "?"};
////  System.out.println(guidsl.check(configuration1));
////  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//  
////  String[] configuration3 = new String[]   
////      {"0", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
////  System.out.println(guidsl.check(configuration3));
//}
//
//public static void testXStream(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"0", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//
//}
//
//public static void testJTopas(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"0", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//}
//
//public static void testEmail(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"0", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//}
//
////BASE, 
////HTML, 
////TXT, 
////LATEX, 
////USER_INTERFACE, 
////COMMAND_LINE, 
////GUI, 
////GUI_PREFERENCES, 
////QUERY_HISTORY, 
////INDEX_HISTORY, 
////SINGLE_DIRECOTORY, 
////MULTI_DIRECTORY, 
////NORMAL_VIEW, 
////TREE_VIEW, 
////WINDOWS, 
////LINUX
//public static void testDesktopSearcher(GUIDSL_Interface guidsl){
//  String[] configuration1 = new String[]   
//      {"0", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration1));
//  
//  String[] configuration2 = new String[]   
//      {"1", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration2));
//  
//  String[] configuration3 = new String[]   
//      {"1", "1", "1", "1", "1", "1", "?", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration3));
//  
//  String[] configuration4 = new String[]   
//      {"1", "1", "1", "1", "1", "1", "1", "?", "?", "?", "?", "?", "?", "?", "?", "?"};
//  System.out.println(guidsl.check(configuration4));
//  
//  String[] configuration5 = new String[]   
//      {"1", "1", "1", "1", "1", "1", "?", "?", "?", "?", "?", "?", "?", "?", "1", "1"};
//  System.out.println(guidsl.check(configuration5));
//}


}
