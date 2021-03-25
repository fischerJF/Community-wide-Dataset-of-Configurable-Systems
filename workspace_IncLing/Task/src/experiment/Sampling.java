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
import testset.LastTaskLabelTest;
import testset.TaskEditorPanelTest;
import testset.TaskEditorPanelTest_;
import testset.TaskHistoryPanelTest;
import testset.TaskManagerWindowTest;
import testset.TaskSelectorPanelTest;
import testset.TaskTest;

public class Sampling {
	
	public  void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("OBSERVER")) {
					Configuration.OBSERVER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("REMOVER")) {
					Configuration.REMOVER = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("LOGGIN")) {
					Configuration.LOGGIN = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						LastTaskLabelTest.class, 
						TaskEditorPanelTest_.class,
						TaskEditorPanelTest.class, 
						TaskHistoryPanelTest.class, 
						TaskManagerWindowTest.class,
						TaskSelectorPanelTest.class, 
						TaskTest.class
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

	}
	
	public void run(TargetSystem tg,String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution =1;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
		

			/**Chvatal **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/task/products";
		
			/**ICPL**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/task/products";
			
			/**IncLing **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/task/products";
			
			/**Random **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/task/products";

			/**all_valid_conf**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/task/products";

			 /**Chvatal_T4**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/task/products";

			/**Chvatal_T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/task/products";
	        
			/**Chvatal_T1**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/task/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/task/products";

			/**ICPL_T3**/
//	        String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/task/products";

			
		    /*YASA_T4*/
//		    String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/Task/products";
	       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/Task/products";
				  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/Task/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/Task/products";

			/*CASA_T4*/ 
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/Task/products";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/Task/products";
			
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/Task/products";
				
			/*CASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/Task/products";


	      
			    
	        
	    challenge.run(TargetSystem.TASK, path);
		finishTime = System.currentTimeMillis() - startTime;
		index++;
	}
	
	float average = finishTime / index;

	System.out.println("Total time (ms): " + finishTime + " time average (ms): " + (average/1000)
			+ " number of times performed:" + index);

 }
}