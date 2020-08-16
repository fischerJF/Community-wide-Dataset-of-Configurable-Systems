package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.Specification;
import IncLingSpecification.SpecificationGPL;
import IncLingSpecification.SpecificationSudoku;
import specifications.Configuration;
import splat.GPLVariables;
import splat.SudokuVariables;
import tests.TestMAB;
import tests.TestMain;

public class MainTestSudoku {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
			  if (f.getName().equals("STATES")) {
          Configuration.STATES = (f.getState().equals("0") ? false : true);
        }
        if (f.getName().equals("UNDO")) {
          Configuration.UNDO = (f.getState().equals("0") ? false : true);
        }
        if (f.getName().equals("COLOR")) {
          Configuration.COLOR = (f.getState().equals("0") ? false : true);
        }
        if (f.getName().equals("SOLVER")) {
          Configuration.SOLVER = (f.getState().equals("0") ? false : true);
        }
        if (f.getName().equals("GENERATOR")) {
          Configuration.GENERATOR = (f.getState().equals("0") ? false : true);
        }
        if (f.getName().equals("EXTENDEDSUDOKU")) {
          Configuration.EXTENDEDSUDOKU = (f.getState().equals("0") ? false : true);
        }
			}
        /* Chama a bibioteca core do junit para rodar a suite de testes */
        JUnitCore junit = new JUnitCore();
        junit.addListener(new TextListener(System.out));
        org.junit.runner.Result result = junit.run( 
             TestMAB.class,
             TestMain.class
             );
        /* fim core junit */
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("STATES"); //0
		featureName.add("UNDO"); //1
		featureName.add("COLOR");//2
		featureName.add("SOLVER");//3
		featureName.add("GENERATOR");//4
		featureName.add("EXTENDEDSUDOKU");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationSudoku.getSINGLETON(Configuration.tool), SudokuVariables.getSINGLETON());
//        executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestSudoku run = new MainTestSudoku();
		run.expRun();
		
		
 }
}