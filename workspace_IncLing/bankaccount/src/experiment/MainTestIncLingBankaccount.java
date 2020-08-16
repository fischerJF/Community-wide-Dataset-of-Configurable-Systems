package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.SpecificationBankaccount;
import specifications.Configuration;
import splat.BankaccountVariables;
import testset.*;



public class MainTestIncLingBankaccount {

	public  void executeJunitTestCase(IncLing incling) {
		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
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
	        	  if(f.getName().equals("INTERESTEST")) {
	        		  Configuration.interest=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("CREDITWORTHINESS")) {
	        		  Configuration.creditworthiness=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("BANKACCOUNT")) {
	        		  Configuration.bankaccount=(f.getState().equals("0") ? false : true);
	        	  }
	         }
			Configuration.productPrint();
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
						AccountTest.class, 
						ApplicationTest.class, 
						TransactionTest.class,
						LogEntryTest.class
				);
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("TRANSACTIONLOG"); //0
		featureName.add("TRANSACTION"); //1
		featureName.add("OVERDRAFT");//2
		featureName.add("LOGGING");//2
		featureName.add("LOCK");//3
		featureName.add("INTERESTESTIMATION");//4
		featureName.add("INTEREST");
		featureName.add("DAILYLIMIT");
		featureName.add("CREDITWORTHINESS");
		featureName.add("BANKACCOUNT");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationBankaccount.getSINGLETON(Configuration.tool), BankaccountVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}
	

	public static void main(String[] args) {
		MainTestIncLingBankaccount run = new MainTestIncLingBankaccount();
		run.expRun();
		
		
 }
}