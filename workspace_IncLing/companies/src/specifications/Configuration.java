package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

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

  public static Tool tool = new Tool("modified-model.m");
  public static boolean makeCnfFile = true;
  public static boolean compatSelections = true;

  public static boolean validProduct() {

    SATtest t = new SATtest("test1", compatSelections, compatSelections);
    t.add(setTREE_STRUCTURE());
    t.add(setLOGGING());
    t.add(setCUT_WHATEVER());
    t.add(setCUT_NO_DEPARTMENT());
    t.add(setCUT_NO_MANAGER());
    t.add(setGUI());
    t.add(setPRECEDENCE());
    t.add(setTOTAL_WALKER());
    t.add(setTOTAL_REDUCER());
    t.add(setACCESS_CONTROL());

    return runTest(t, makeCnfFile);
  }

  public static boolean runTest(SATtest t, boolean compat) {
    return (tool.modelDebug(t, makeCnfFile)) ? true : false;
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

  public static String returnProduct() {
    return 
        "TREE_STRUCTURE:"+ Configuration.TREE_STRUCTURE
        + " TOTAL_WALKER:"+ Configuration.TOTAL_WALKER
        + " TOTAL_REDUCER:"+ Configuration.TOTAL_REDUCER
        + " PRECEDENCE:"+ Configuration.PRECEDENCE
        + " LOGGING:"+ Configuration.LOGGING
        + " GUI:"+ Configuration.GUI
        + " CUT_WHATEVER:"+ Configuration.CUT_WHATEVER
        + " CUT_NO_MANAGER:"+ Configuration.CUT_NO_MANAGER
        + " CUT_NO_DEPARTMENT:"+ Configuration.CUT_NO_DEPARTMENT
        + " ACCESS_CONTROL:"+ Configuration.ACCESS_CONTROL
        ;
    }
  public static void productPrint() {
//- TREE_STRUCTURE : 1 - TOTAL_WALKER : 0 - 
    //TOTAL_REDUCER : 0 - PRECEDENCE : 1 - LOGGING : 0 - GUI : 0 - CUT_WHATEVER : 0 - CUT_NO_MANAGER : 1 - CUT_NO_DEPARTMENT : 0 - ACCESS_CONTROL : 0
    System.out.print("conf: "+
         "TREE_STRUCTURE:"+ Configuration.TREE_STRUCTURE
        + " TOTAL_WALKER:"+ Configuration.TOTAL_WALKER
        + " TOTAL_REDUCER:"+ Configuration.TOTAL_REDUCER
        + " PRECEDENCE:"+ Configuration.PRECEDENCE
        + " LOGGING:"+ Configuration.LOGGING
        + " GUI:"+ Configuration.GUI
        + " CUT_WHATEVER:"+ Configuration.CUT_WHATEVER
        + " CUT_NO_MANAGER:"+ Configuration.CUT_NO_MANAGER
        + " CUT_NO_DEPARTMENT:"+ Configuration.CUT_NO_DEPARTMENT
        + " ACCESS_CONTROL:"+ Configuration.ACCESS_CONTROL
        );
    
//
//    if (Configuration.CUT_WHATEVER)
//      System.out.print("CUT_WHATEVER,");
//
//    if (Configuration.ACCESS_CONTROL)
//      System.out.print("ACCESS_CONTROL,");
//
//    if (Configuration.CUT_NO_DEPARTMENT)
//      System.out.print("CUT_NO_DEPARTMENT,");
//
//    if (Configuration.CUT_NO_MANAGER)
//      System.out.print("CUT_NO_MANAGER,");
//
//    if (Configuration.GUI)
//      System.out.print("GUI,");
//
//    if (Configuration.LOGGING)
//      System.out.print("LOGGING ,");
//
//    if (Configuration.PRECEDENCE)
//      System.out.print("PRECEDENCE,");
//
//    if (Configuration.TOTAL_REDUCER)
//      System.out.print("TOTAL_REDUCER,");
//
//    if (Configuration.TREE_STRUCTURE)
//      System.out.print("TREE_STRUCTURE,");

    System.out.println();
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