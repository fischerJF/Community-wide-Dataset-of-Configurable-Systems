package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.SpecificationJtopas;
import specifications.Configuration;
import splat.JTopasVariables;
import tests.TestTokenizerFlags;



public class MainTestIncLingJtopas {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
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
        /* Chama a bibioteca core do junit para rodar a suite de testes */
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run(
          //  TestTokenizerFlags.class
            );
        /* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("TOKENPOSONLY"); //0
		featureName.add("COUNTLINES"); //1
		featureName.add("IMAGEPARTS");//2
		featureName.add("BLOCKCOMMENTS");//2
		featureName.add("LINECOMMENTS");//3
	
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationJtopas.getSINGLETON(Configuration.tool), JTopasVariables.getSINGLETON());
        //executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestIncLingJtopas run = new MainTestIncLingJtopas();
		run.expRun();
		
		
 }
}