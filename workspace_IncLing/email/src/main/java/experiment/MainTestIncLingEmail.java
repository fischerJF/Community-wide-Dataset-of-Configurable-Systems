package experiment;
import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import IncLing.*;
import IncLingSpecification.SpecificationEmail;
import junit.extensions.ActiveTestSuite;
import junit.framework.TestSuite;
import specifications.Configuration;
import splat.EmailVariables;
import testset.ClientTest;
import testset.EmailTest;
import testset.PL_Iinterface_implTest;
import testset.TestMAB;
import testset.TestMain;
import testset.UtilTest;



public class MainTestIncLingEmail {
	
	public int cont=1;
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			testPrintCombs(combination);
			for (FeatureIncling f : combination.getListFeatures()) {
				if(f.getName().equals("KEYS")){
	              	Configuration.KEYS=(f.getState().equals("0") ? false : true);
	        	  }	
	        	  if(f.getName().equals("ENCRYPT")) {
	        		  Configuration.ENCRYPT=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("AUTORESPONDER")) {
	        		  Configuration.AUTORESPONDER=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("ADDRESSBOOK")) {
	        			Configuration.ADDRESSBOOK=( f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("SIGN")) {
	        		  Configuration.SIGN=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("FORWARD")) {
	        		  Configuration.FORWARD=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("VERIFY")) {
	        		  Configuration.VERIFY=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("DECRYPT")) {
	        			Configuration.DECRYPT=(f.getState().equals("0") ? false : true);
	        	  }
			}
				/* Chama a bibioteca core do junit para rodar a suite de testes */
	
			JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
			    		
						 ClientTest.class,
						 EmailTest.class,
						 PL_Iinterface_implTest.class,
						 TestMAB.class,
						 TestMain.class,
						 UtilTest.class
						 
						);
				System.out.println("\n\n");
			
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("KEYS"); //0
		featureName.add("ENCRYPT"); //1
		featureName.add("AUTORESPONDER");//2
		featureName.add("ADDRESSBOOK");//2
		featureName.add("SIGN");//3
		featureName.add("FORWARD");//4
		featureName.add("VERIFY");
		featureName.add("DECRYPT");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationEmail.getSINGLETON(Configuration.tool), EmailVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}
	public  void testPrintCombs(Combination combination) {
	System.err.println("Contador"+ cont);
			for (FeatureIncling f : combination.getListFeatures()) {

				System.err.print(f.getName() + ": " + f.getState() + " ");
			}
			System.err.println("\n");
			cont++;
	}


	public static void main(String[] args) {
		MainTestIncLingEmail run = new MainTestIncLingEmail();
		run.expRun();
		
		
 }
}