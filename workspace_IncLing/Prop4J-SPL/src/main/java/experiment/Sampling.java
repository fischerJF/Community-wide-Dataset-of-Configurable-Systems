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
import testset.ChargeUITest;
import testset.IssueCardUITest;
import testset.LogFileTest;
import testset.PaycardUserInterfaceTest;
import testset.PaycardUserInterfaceTest2;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("Paycard")) {
					Configuration.paycard = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Logging")) {
					Configuration.logging = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MaximumRecord")) {
					Configuration.maximumrecord = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("LockOut")) {
					Configuration.lockout = (f.getState().equals("0") ? false : true);
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
						ChargeUITest.class, IssueCardUITest.class, LogFileTest.class,
						PaycardUserInterfaceTest.class, PaycardUserInterfaceTest2.class
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

	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 5 ;
		int index = 0;		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
	
			/**Chvatal **/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal/Paycard/products";
		
			/**ICPL**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL/Paycard/products";
			
			/**IncLing **/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/IncLing/Paycard/products";
			
			/*0*Random **/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/RANDOM/Paycard/products";

			/**all_valid_conf**/
//			String path = "C:/Users/labsoft/Documents0000rkspace_IncLing/Tools/All_valid_conf/Paycard/products";

			/**Chvatal_T4**/
//	        String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T4/Paycard/products";

			/**Chvatal_T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T3/Paycard/products";
	        
			/**Chvatal_T2**/
//	        String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T2/Paycard/products";
			
			/**Chvatal_T1**/
//	        String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T1/Paycard/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/Paycard/products";

			/**ICPL_T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T3/Paycard/products";

			/**ICPL_T2**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T2/Paycard/products";

			/**ICPL_T1**/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T1/Paycard/products";


	      /*YASA_T4*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/Paycard/products";

		  /*YASA_T3*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/Paycard/products";
				  
		  /*YASA_T2 */
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/Paycard/products";

		  /*YASA_T1 */
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/Paycard/products";

		  /*CASA_T4*/ 
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/Paycard/products";

		  /*CASA_T3*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/Paycard/products";

		  /*CASA_T2*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/Paycard/products";
				
		  /*CASA_T1*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/Paycard/products";
		

			
			
			challenge.run(TargetSystem.PAYCARD, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (ms): " + (average/1000)
				+ " number of times performed:" + index);

	}
}