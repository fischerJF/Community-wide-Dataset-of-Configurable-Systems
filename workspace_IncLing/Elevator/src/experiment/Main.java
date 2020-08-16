package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;

import IncLing.*;
import IncLingSpecification.SpecificationElevator;
import IncLingSpecification.SpecificationEmail;
import elevatorsystem.Elevator;
import junit.extensions.ActiveTestSuite;
import junit.framework.TestSuite;
import specifications.Configuration;
import splat.ElevatorVariables;
import splat.EmailVariables;
import testset.ActionsTest;
import testset.ElevatorTest;
import testset.EnvironmentTest;
import testset.FloorTest;
import testset.MainTest;
import testset.PersonTest;



public class Main {
	
	public int cont=1;
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			testPrintCombs(combination);
			for (FeatureIncling f : combination.getListFeatures()) {
				  if(f.getName().equals("weight")) {
	        		  Configuration.weight=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("empty")) {
	        		  Configuration.empty=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("twothirdsfull")) {
	        			Configuration.twothirdsfull=( f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("executivefloor")) {
	        		  Configuration.executivefloor=(f.getState().equals("0") ? false : true);
	        	  }
	        	  if(f.getName().equals("overloaded")) {
	        		  Configuration.overloaded=(f.getState().equals("0") ? false : true);
	        	  }
	        	  
			}
				/* Chama a bibioteca core do junit para rodar a suite de testes */
	
			JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
						ActionsTest.class,
						ElevatorTest.class,
						EnvironmentTest.class,
						FloorTest.class,
						MainTest.class,
						PersonTest.class
						);
			
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("WEIGHT"); //0
		featureName.add("EMPTY"); //1
		featureName.add("TWOTHIRDSFULL");//2
		featureName.add("EXECUTIVEFLOOR");//2
		featureName.add("OVERLOADED");//3
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationElevator.getSINGLETON(Configuration.tool), ElevatorVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}
	public  void testPrintCombs(Combination combination) {
	System.out.println("Contador"+ cont);
			for (FeatureIncling f : combination.getListFeatures()) {

				System.err.print(f.getName() + ": " + f.getState() + " ");
			}
			System.out.println("\n");
			cont++;
	}


	public static void main(String[] args) {
		Main run = new Main();
		run.expRun();
		
		
 }
}