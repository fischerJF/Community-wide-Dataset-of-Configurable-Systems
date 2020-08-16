package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.Specification;
import IncLingSpecification.SpecificationCompanies;
import IncLingSpecification.SpecificationGPL;
import specifications.Configuration;
import splat.CompaniesVariables;
import splat.GPLVariables;
import tests.CompaniesTest;
import tests.Example;
import tests.Interceptor;
import tests.NestedIfBugTest;
import tests.Pilot;
import tests.Pilot_CommandLine;
import tests.Pilot_GUI;
import tests.Pilot_REPAIR;
import tests.TestBasics;
import tests.TestCombinations;
import tests.TestGUIExample;
import tests.TestGUI_Mateus;
import tests.TestGUI_Mateus_REPAIR;
import tests.TestObeservability;
import tests.TestProxying;
import tests.TestUndo;
import tests.TestUtil;

public class MainTestCompanies {
  
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
		 
			for (FeatureIncling f : combination.getListFeatures()) {
				if (f.getName().equals("TREE_STRUCTURE")) {
					Configuration.TREE_STRUCTURE = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("LOGGING")) {
					Configuration.LOGGING = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CUT_WHATEVER")) {
					Configuration.CUT_WHATEVER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CUT_NO_DEPARTMENT")) {
					Configuration.CUT_NO_DEPARTMENT = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CUT_NO_MANAGER")) {
					Configuration.CUT_NO_MANAGER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("GUI")) {
					Configuration.GUI = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PRECEDENCE")) {
					Configuration.PRECEDENCE = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TOTAL_WALKER")) {
					Configuration.TOTAL_WALKER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TOTAL_REDUCER")) {
					Configuration.TOTAL_REDUCER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ACCESS_CONTROL")) {
					Configuration.ACCESS_CONTROL = (f.getState().equals("0") ? false : true);
				}
				
      }
			Configuration.productPrint();
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
				 
				   
				    Example.class, 
	           NestedIfBugTest.class, 
	           Pilot_CommandLine.class, /*parou*/
	           Pilot_GUI.class,
	           
	           Pilot_REPAIR.class, 
	           Pilot.class,  
	           TestBasics.class,
	           TestCombinations.class,
	           TestGUI_Mateus.class,  /*parou*/
	          /* TestGUI_Mateus_REPAIR.class//,*/
	           TestGUIExample.class,
	           TestProxying.class,
	           TestUtil.class 
				    
				    
				 );
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("TREE_STRUCTURE"); //0
		featureName.add("LOGGING"); //1
		featureName.add("CUT_WHATEVER");//2
		featureName.add("CUT_NO_DEPARTMENT");//3
		featureName.add("CUT_NO_MANAGER");//4
		featureName.add("GUI");
		featureName.add("PRECEDENCE");
		featureName.add("TOTAL_WALKER");
		featureName.add("TOTAL_REDUCER");
		featureName.add("ACCESS_CONTROL");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationCompanies.getSINGLETON(Configuration.tool), CompaniesVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}

		public static void main(String[] args) {
		MainTestCompanies run = new MainTestCompanies();
		run.expRun();
		
		
 }
}