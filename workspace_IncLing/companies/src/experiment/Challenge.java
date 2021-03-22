package experiment;

import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
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
import tests.TestProxying;
import tests.TestUtil;

public class Challenge {

  public void executeJunitTestCase(ProductGeneration tools) {
    int count = 0;
    Record record = new Record();
    for (Combination combination : tools.getCombsForTest()) {
      for (FeatureCombination f : combination.getListFeatures()) {
        if (f.getName().equals("TREE_STRUCTURE")) {
          Configuration.TREE_STRUCTURE = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("LOGGING")) {
          Configuration.LOGGING = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("CUT_WHATEVER")) {
          Configuration.CUT_WHATEVER = (f.getState().equals("0") ? false: true);
        } else if (f.getName().equals("CUT_NO_DEPARTMENT")) {
          Configuration.CUT_NO_DEPARTMENT = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("CUT_NO_MANAGER")) {
          Configuration.CUT_NO_MANAGER = (f.getState().equals("0") ? false: true);
        } else if (f.getName().equals("GUI")) {
          Configuration.GUI = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("PRECEDENCE")) {
          Configuration.PRECEDENCE = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("TOTAL_WALKER")) {
          Configuration.TOTAL_WALKER = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("TOTAL_REDUCER")) {
          Configuration.TOTAL_REDUCER = (f.getState().equals("0") ? false : true);
        } else if (f.getName().equals("ACCESS_CONTROL")) {
          Configuration.ACCESS_CONTROL = (f.getState().equals("0") ? false : true);
        }
      }
      System.err.println("Configuration:");
      Configuration.productPrint();
      System.out.println("");
      if (Configuration.validProduct()) {
        count++;
        JUnitCore junit = new JUnitCore();
        junit.addListener(
            new RunListernerReport(Configuration.returnProduct(), record));
        org.junit.runner.Result result = junit.run(Example.class,
            NestedIfBugTest.class, Pilot_CommandLine.class, Pilot_GUI.class,
            Pilot_REPAIR.class, Pilot.class, TestBasics.class,
            TestCombinations.class, TestGUIExample.class, TestProxying.class,
            TestUtil.class);
        Configuration.productPrint();
        System.out.println("\n\n ----------------------- \n\n");
      } else {
        System.err.println("****** Invalid ******");
      }
    }
    try {
      record.record2();
    } catch (Exception e) {
    }
    System.out.println("Configurations count:" + count);

  }

  public void run(TargetSystem tg, String path) {
    ProductGeneration products = new ProductGeneration();
    products.run(tg, path);
    executeJunitTestCase(products);
  }

  public static void main(String[] args) {
    long startTime = 0;
    long finishTime = 0;
    int totalExecution = 10;
    int index = 0;
    finishTime = 0;
    startTime = System.currentTimeMillis();
    Challenge challenge = new Challenge();
    while (index < totalExecution) {

      /** all_valid_conf **/
      String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/companies/products";

      challenge.run(TargetSystem.COMPANIES, path);
      finishTime = System.currentTimeMillis() - startTime;
      index++;
    }

    float average = finishTime / index;

    System.out.println("Total time (ms): " + finishTime + " time average (s): "
        + (average / 1000) + average + average + " number of times performed:"
        + index);
  }
}