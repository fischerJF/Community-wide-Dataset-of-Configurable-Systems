package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.junit.runner.notification.RunListener;

import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import tests.Example;
import tests.NestedIfBugTest;
import tests.Pilot;
import tests.Pilot_CommandLine;
import tests.Pilot_GUI;
import tests.Pilot_REPAIR;
import tests.TestBasics;
import tests.TestCombinations;
import tests.TestGUIExample;
import tests.TestGUI_Mateus;
import tests.TestProxying;
import tests.TestUtil;

public class BaselineAdapter {
  PowerSet powerset;

  public BaselineAdapter() {
    powerset = new PowerSet();

  }

  public void baselineRun() {
    Feature f1 = new Feature();
    f1.setType(FeatureType.MANDATORY);

    Feature f2 = new Feature();
    f2.setType(FeatureType.OPTIONAL);

    Feature f3 = new Feature();
    f3.setType(FeatureType.OPTIONAL);

    Feature f4 = new Feature();
    f4.setType(FeatureType.OPTIONAL);

    Feature f5 = new Feature();
    f5.setType(FeatureType.OPTIONAL);

    Feature f6 = new Feature();
    f6.setType(FeatureType.OPTIONAL);

    Feature f7 = new Feature();
    f7.setType(FeatureType.OPTIONAL);

    Feature f8 = new Feature();
    f8.setType(FeatureType.OPTIONAL);

    Feature f9 = new Feature();
    f9.setType(FeatureType.OPTIONAL);

    Feature f10 = new Feature();
    f10.setType(FeatureType.OPTIONAL);

    SPL spl = new SPL();
    spl.addOthersFeature(f2);
    spl.addOthersFeature(f3);
    spl.addOthersFeature(f4);
    spl.addOthersFeature(f5);
    spl.addOthersFeature(f6);
    spl.addOthersFeature(f7);
    spl.addOthersFeature(f8);
    spl.addOthersFeature(f9);
    spl.addOthersFeature(f10);

    makeProduct(spl);

  }

  private void makeProduct(SPL spl) {
    List<Integer> list = new ArrayList<Integer>();
    for (int cont = 0; cont < spl.getOthersFeatureList().size(); cont++) {
      list.add(cont);
    }

    int cont = 0;
    Record record = new Record();
    // System.out.println(powerset.getSubsetUsingBitMap(list));
//    for (ArrayList<Integer> integer : powerset.getSubsetUsingBitMap(list)) {
//      starFeature();
//      for (Integer integer2 : integer) {
//
//        if (integer2 == 0)
//          Configuration.LOGGING = true;
//        if (integer2 == 1)
//          Configuration.CUT_WHATEVER = true;
//        if (integer2 == 2)
//          Configuration.CUT_NO_DEPARTMENT = true;
//        if (integer2 == 3)
//          Configuration.CUT_NO_MANAGER = true;
//        if (integer2 == 4)
//          Configuration.GUI = true;
//        if (integer2 == 5)
//          Configuration.PRECEDENCE = true;
//        if (integer2 == 6)
//          Configuration.TOTAL_WALKER = true;
//        if (integer2 == 7)
//          Configuration.TOTAL_REDUCER = true;
//        if (integer2 == 8)
//          Configuration.ACCESS_CONTROL = true;
//      }
    
    //TREE_STRUCTURE:true TOTAL_WALKER:true TOTAL_REDUCER:false PRECEDENCE:true LOGGING:false GUI:false CUT_WHATEVER:true CUT_NO_MANAGER:false CUT_NO_DEPARTMENT:false ACCESS_CONTROL:false
       Configuration.TREE_STRUCTURE=true; //base 
       Configuration.TOTAL_WALKER=true;
       Configuration.TOTAL_REDUCER=false;
       Configuration.PRECEDENCE=true;   // false não da erro
       Configuration.LOGGING=true; // nao muda
       Configuration.GUI=false;//nao muda
       Configuration.CUT_WHATEVER=true;
       Configuration.CUT_NO_MANAGER=false;
       Configuration.CUT_NO_DEPARTMENT=false;
       Configuration.ACCESS_CONTROL=true;//nao muda

      if (Configuration.validProduct()) {
        Configuration.productPrint();
        cont++;

        // /* Chama a blibioteca core do junit para rodar a suite de testes */
        JUnitCore junit = new JUnitCore();
        junit.addListener(
        new RunListernerReport(Configuration.returnProduct(), record));
        org.junit.runner.Result result = junit.run(
//            Example.class,
//            NestedIfBugTest.class, 
//            Pilot_CommandLine.class, 
//            Pilot_GUI.class,
//            Pilot_REPAIR.class, 
//            Pilot.class, 
//            TestBasics.class,
//            TestCombinations.class, 
            TestGUIExample.class  //, 
//            TestProxying.class,
//            TestUtil.class
            );

        System.err.println("cont: " + cont + "((( apos os testes))) ");
        Configuration.productPrint();
        System.out.println("\n\n ----------------------- \n\n");
        starFeature();
        // /* fim core junit */
        //

      }
       else {
       System.err.println("Invalid");
       }
   // }
    try {
      record.record2();
    } catch (Exception e) {
      // TODO: handle exception
    }

    System.out.println("total valid product:" + cont);
  }

  private void starFeature() {
    Configuration.TREE_STRUCTURE = true;
    Configuration.LOGGING = false;
    Configuration.CUT_WHATEVER = false;
    Configuration.CUT_NO_DEPARTMENT = false;
    Configuration.CUT_NO_MANAGER = false;
    Configuration.GUI = false;
    Configuration.PRECEDENCE = false;
    Configuration.TOTAL_WALKER = false;
    Configuration.TOTAL_REDUCER = false;
    Configuration.ACCESS_CONTROL = false;

  }

}
