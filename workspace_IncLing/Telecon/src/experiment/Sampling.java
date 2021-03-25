package experiment;


import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.AbstractSimulationTest;
import testset.BasicSimulationTest;
import testset.CallTest;
import testset.CustomerTest;
import testset.HistoricTest;
import testset.LocalTest;
import testset.LongDistanceTest;
import testset.TimerTest;


public class Sampling {
	
	public  void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("HISTORIC")) {
					Configuration.HISTORIC = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TIMING")) {
					Configuration.TIMING = (f.getState().equals("0") ? false : true);
				}
			}
			Configuration.Telecon=true;
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						AbstractSimulationTest.class,
						BasicSimulationTest.class,
						CallTest.class,
						CustomerTest.class,
						HistoricTest.class,
						LocalTest.class,
						LongDistanceTest.class,
						TimerTest.class
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
			// TODO: handle exception
		}
		System.out.println("Contador de produtos:" + cont);

	}
	

	public void run(TargetSystem tg,String path) {
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
			/**Chvatal **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/Telecom/products";
		
			/**ICPL**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/Telecom/products";
			
			/**IncLing **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/Telecom/products";
			
			/**Random **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/Telecom/products";

			/**all_valid_conf**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/Telecom/products";

			 /**Chvatal_T4**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/Telecom/products";

			/**Chvatal_T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/Telecom/products";
	        
			/**Chvatal_T1**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/Telecom/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/Telecom/products";

			/**ICPL_T3**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/Telecom/products";

		     /*YASA_T4*/
//			 String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/Telecon/products";
	       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/Telecon/products";
				  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/Telecon/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/Telecon/products";

			/*CASA_T4*/ 
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/Telecon/products";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/Telecon/products";
			
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/Telecon/products";
				
			/*CASA_T1*/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/Telecon/products";

			
			
			challenge.run(TargetSystem.TELECOM, path);
		finishTime = System.currentTimeMillis() - startTime;
		index++;
	}
	
	float average = finishTime / index;

	System.out.println("Total time (ms): " + finishTime + " time average (ms): " + (average/1000)
			+ " number of times performed:" + index);

 }
}