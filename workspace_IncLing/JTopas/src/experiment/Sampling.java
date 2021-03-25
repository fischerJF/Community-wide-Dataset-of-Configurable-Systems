package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.Feature;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import tests.TestMain;
import tests.TestPatternMatching;
import tests.TestTokenizerFlags;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("BASE")) {
					Configuration.BASE = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TOKENPOSONLY")) {
					Configuration.TOKENPOSONLY = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("COUNTLINES")) {
					Configuration.COUNTLINES = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("IMAGEPARTS")) {
					Configuration.IMAGEPARTS = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("BLOCKCOMMENTS")) {
					Configuration.BLOCKCOMMENTS = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("LINECOMMENTS")) {
					Configuration.LINECOMMENTS = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(TestMain.class, TestPatternMatching.class// ,
				);
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
			/** Chvatal **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/Jtopas/products";

			/** ICPL **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/Jtopas/products";

			/** IncLing **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/Jtopas/products";

			/** Random **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/Jtopas/products";

			/** all_valid_conf **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/Jtopas/products";

			/** Chvatal T4 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/Jtopas/products";

			/** Chvatal T3 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/Jtopas/products";

			/** Chvatal T1 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/Jtopas/products";

			/** ICPL_T1 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/Jtopas/products";

			/** ICPL_T3 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/Jtopas/products";


			
			/*YASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/jTopas/products";
       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/jTopas/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/jTopas/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/jTopas/products";

			/*CASA_T4*/ 
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/jTopas/products";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/jTopas/products";
		
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/jTopas/products";
			
//			/*CASA_T1*/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/jTopas/products";

			
			
			
			challenge.run(TargetSystem.jTOPAS, path);

			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average / 1000)
				+ " number of times performed:" + index);
	}
}