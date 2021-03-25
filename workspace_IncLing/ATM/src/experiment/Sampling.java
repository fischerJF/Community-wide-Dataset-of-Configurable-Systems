package experiment;


import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.ATMTest;
import testset.ATMUserInterfaceTest;
import testset.ATMUserInterfaceTest2;
import testset.AccountTest;
import testset.BalanceInquiryTest;
import testset.BankDatabaseTest;
import testset.CashDispenserTest;
import testset.DepositTest;
import testset.LoggerTest;
import testset.WithdrawalTest;


public class Sampling {
	
	public  void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("LOGGING")) {
					Configuration.LOGGING = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("DEPOSITING")) {
					Configuration.DEPOSITING = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WITHDRAWING")) {
					Configuration.WITHDRAWING = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("BALANCE_INQUIRY")) {
					Configuration.BALANCE_INQUIRY = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ADMIN_CONTROL")) {
					Configuration.ADMIN_CONTROL = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("USER_INTERFACE")) {
					Configuration.USER_INTERFACE = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WITHDRAWING_ALL_VALUES")) {
					Configuration.WITHDRAWING_ALL_VALUES = (f.getState().equals("0") ? false : true);
				}
				
			}
			
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(
						Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						AccountTest.class, 
						ATMTest.class, 
						ATMUserInterfaceTest2.class, 
						CashDispenserTest.class, 
						DepositTest.class, 
						WithdrawalTest.class
					);
				Configuration.productPrint();
			} else {
				System.err.println("****** Invalid ******");
			}
		}
		try {
			record.record2();
		} catch (Exception e) {
		
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
		int totalExecution = 2;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
		
			/** ICPL **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/ATM/products";

			/** Chvatal **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/ATM/products";

			/** IncLing **/
//			 String path =
//			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/IncLing/ATM/products";

			/** Random **/
//			 String path =
//			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/RANDOM/ATM/products";

			/** all_valid_conf **/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/All_valid_conf/ATM/products";

			/**Chvatal  T4**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T4/ATM/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T3/ATM/products";

			/**Chvatal  T2**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T2/ATM/products";
			
			/**Chvatal  T1**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T1/ATM/products";

			/**ICPL_T1**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T1/ATM/products";

			/**ICPL_T2**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T2/ATM/products";

			/**ICPL_T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T3/ATM/products";

			
			/*YASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/ATM/products";
			  
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/ATM/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/ATM/products";
	
			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/ATM/";
	
			/*CASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/ATM/products";
			
			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/ATM/products";
		
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/ATM/products";
			
			/*CASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/ATM/products";
	
			
	    challenge.run(TargetSystem.ATM, path);
		finishTime = System.currentTimeMillis() - startTime;
		index++;
	}
	
	float average = finishTime / index;

	System.out.println("Total time (ms): " + finishTime + " time average (ms): " + (average / 1000)
			+ " number of times performed:" + index);

}
}