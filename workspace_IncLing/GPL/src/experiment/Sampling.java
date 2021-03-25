package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.*;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import splat.GPLVariables;
import tests.ConnectedTests_Caio;
import tests.CycleRelated_Caio;
import tests.CycleWorkSpaceTest;
import tests.GraphReturnTests_Caio;
import tests.GraphTest;
import tests.JavaUtilityTest;
import tests.MainTest;
import tests.MultiFeatureTest_Caio;
import tests.NetworkGeneratorTest;
import tests.NumberTests_Caio;
import tests.TestSuite_NEW;
import tests.TreeGeneratorTest;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("BASE")) {
					Configuration.base = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DIRECTED")) {
					Configuration.DIRECTED = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("UNDIRECTED")) {
					Configuration.UNDIRECTED = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WEIGHTED")) {
					Configuration.WEIGHTED = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SEARCH")) {
					Configuration.SEARCH = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("BFS")) {
					Configuration.BFS = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("NUMBER")) {
					Configuration.NUMBER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CONNECTED")) {
					Configuration.CONNECTED = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("STRONGLYCONNECTED")) {
					Configuration.STRONGLYCONNECTED = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("CYCLE")) {
					Configuration.CYCLE = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MSTPRIM")) {
					Configuration.MSTPRIM = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MSTKRUSKAL")) {
					Configuration.MSTKRUSKAL = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SHORTEST")) {
					Configuration.SHORTEST = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;

				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(ConnectedTests_Caio.class, CycleRelated_Caio.class,
						ConnectedTests_Caio.class, CycleRelated_Caio.class, CycleWorkSpaceTest.class,
						GraphReturnTests_Caio.class, GraphTest.class, JavaUtilityTest.class, MainTest.class,
						MultiFeatureTest_Caio.class, NetworkGeneratorTest.class, NumberTests_Caio.class,
						TestSuite_NEW.class, TreeGeneratorTest.class);
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
			} else {
				System.err.println("****** Invalid ******");
			}
		}
		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Contador de produtos:" + cont);

	}

	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 1;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
			/** ICPL **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/GPL/products";

			/** Chvatal **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal/GPL/products";

			/** IncLing **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/GPL/products";

			/** Random **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/RANDOM/GPL/products";

			/** all_valid_conf **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/All_valid_conf/GPL/products";

			/**Chvatal  T4**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/GPL/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/GPL/products";
			
			/**Chvatal  T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/GPL/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/GPL/products";

			/**ICPL_T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/GPL/products";

			
	    	/*YASA_T4*/
//		   String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/GPL/products";
		    
		  /*YASA_T3*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/GPL/products";
					  
		  /*YASA_T2 */
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/GPL/products";

		  /*YASA_T1 */
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/GPL/products";

		  /*CASA_T4*/ 
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/GPL/products";

		  /*CASA_T3*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/GPL/products";

		  /*CASA_T2*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/GPL/products";
					
		  /*CASA_T1*/
		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/GPL/products";
			
		   
			challenge.run(TargetSystem.GPL, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average/1000)
				+ " number of times performed:" + index);
	}
}