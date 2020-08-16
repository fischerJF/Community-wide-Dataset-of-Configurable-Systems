package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.Specification;
import IncLingSpecification.SpecificationGPL;
import specifications.Configuration;
import splat.GPLVariables;
import tests.ConnectedTests_Caio;
import tests.CycleRelated_Caio;
import tests.GraphReturnTests_Caio;
import tests.MultiFeatureTest_Caio;
import tests.NumberTests_Caio;
import tests.TestSuite_NEW;

public class MainTestGPL {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
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
			Configuration.productPrint();
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
						ConnectedTests_Caio.class, CycleRelated_Caio.class,
						GraphReturnTests_Caio.class, MultiFeatureTest_Caio.class, NumberTests_Caio.class,
						TestSuite_NEW.class
						);
				/* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("DIRECTED"); //0
		featureName.add("UNDIRECTED"); //1
		featureName.add("WEIGHTED");//2
		featureName.add("SEARCH");//3
		featureName.add("BFS");//4
		featureName.add("NUMBER");
		featureName.add("CONNECTED");
		featureName.add("STRONGLYCONNECTED");
		featureName.add("CYCLE");
		featureName.add("MSTPRIM");
		featureName.add("MSTKRUSKAL");
		featureName.add("SHORTEST");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationGPL.getSINGLETON(Configuration.tool), GPLVariables.getSINGLETON());
       // executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestGPL run = new MainTestGPL();
		run.expRun();
		
		
 }
}