package experiment;


import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.AccountTest;
import testset.ApplicationTest;
import testset.LogEntryTest;
import testset.TransactionTest;


public class Sampling {
	
	public  void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if(f.getName().equals("TRANSACTIONLOG")){
	              	Configuration.transactionlog=(f.getState().equals("0") ? false : true);
	        	  }	
	        	  if(f.getName().equals("TRANSACTION")) {
	        		  Configuration.transaction=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("OVERDRAFT")) {
	        		  Configuration.overdraft=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("LOGGING")) {
	        		  Configuration.logging=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("LOCK")) {
	        		  Configuration.lock=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("INTERESTESTIMATION")) {
	        		  Configuration.interestestimation=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("INTEREST")) {
	        		  Configuration.interest=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("CREDITWORTHINESS")) {
	        		  Configuration.creditworthiness=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("BANKACCOUNT")) {
	        		  Configuration.bankaccount=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("DAILYLIMIT")) {
	        		  Configuration.dailylimit=(f.getState().equals("0") ? false : true);
	        	  }
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						AccountTest.class, 
						ApplicationTest.class, 
						TransactionTest.class,
						LogEntryTest.class
				    );
				/* fim core junit */
				System.err.println("cont: " + cont + "((( apos os testes))) ");
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
		int totalExecution = 10;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		while (index < totalExecution) {
		Sampling challenge = new Sampling();
		
		
		/** ICPL **/
//		 String path =
//		 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/BankAccount/products";

		/** Chvatal **/
//		 String path =
//		 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/BankAccount/products";

		/** IncLing **/
//		 String path =
//		 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/BankAccount/products";

		/** Random **/
		// String path =
		// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/BankAccount/products";

		/** all_valid_conf **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/BankAccount/products";

		/**Chvatal  T4**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/BankAccount/products";

		/**Chvatal  T3**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/BankAccount/products";
		
		/**Chvatal  T1**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/BankAccount/products";

		/**ICPL_T1**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/BankAccount/products";

		/**ICPL_T3**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/BankAccount/products";

		/** SPLCATool_T1 **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/SPLCATool_T1/BankAccount_1/products";
	
		/** SPLCATool_T2 **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/SPLCATool_T2/BankAccount_1/products";

		/** SPLCATool_T3 **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/SPLCATool_T3/BankAccount_1/products";
	
		/** PLEDGE_25% **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/PLEDGE_25%/BankAccount_1/products";
	
//		/** PLEDGE_50% **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/PLEDGE_50%/BankAccount_1/products";
	
		/** PLEDGE_75% **/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/PLEDGE_75%/BankAccount_1/products";
		
//		/** Most-enabled-disabled**/
//		String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/MostEnabledDisabled/BankAccount_1/products";
	
		/** Baital**/
	      String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Baital/BankAccount_1/products";
		  
		challenge.run(TargetSystem.BANKACCOUNT, path);
		index++;
		}
		finishTime = System.currentTimeMillis() - startTime;
		
		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average/1000)
				+ " number of times performed:" + index);
 }
}