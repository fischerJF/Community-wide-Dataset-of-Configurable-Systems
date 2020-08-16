package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.SpecificationDesktopsearcher;
import specifications.Configuration;
import splat.DesktopSearcherVariables;
import testset.TestAll;
import testset.TestCommandLine;

public class MainTestDesktopsearcher {
	
	public  void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
					if (f.getName().equals("BASE")) {
						Configuration.BASE = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("HTML")) {
						Configuration.HTML = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("TXT")) {
						Configuration.TXT = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("LATEX")) {
						Configuration.LATEX = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("USER_INTERFACE")) {
						Configuration.USER_INTERFACE = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("COMMAND_LINE")) {
						Configuration.COMMAND_LINE = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("GUI")) {
						Configuration.GUI = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("GUI_PREFERENCES")) {
						Configuration.GUI_PREFERENCES = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("QUERY_HISTORY")) {
						Configuration.QUERY_HISTORY = (f.getState().equals("0") ? false : true);
					}
					
					if (f.getName().equals("SINGLE_DIRECTORY")) {
						Configuration.SINGLE_DIRECTORY = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("MULTI_DIRECTORY")) {
						Configuration.MULTI_DIRECTORY = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("NORMAL_VIEW")) {
						Configuration.NORMAL_VIEW = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("TREE_VIEW")) {
						Configuration.TREE_VIEW = (f.getState().equals("0") ? false : true);
					}
					if (f.getName().equals("WINDOWS")) {
					Configuration.WINDOWS = (f.getState().equals("0") ? false : true);
				}
              }
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run(
						TestAll.class
//						TestCommandLine.class
						);
			
		}
	}
	public void expRun() {
		ArrayList<String>  featureName =new ArrayList<String> ();
		featureName.add("HTML"); //1
		featureName.add("TXT");//2
		featureName.add("LATEX");//3
		featureName.add("USER_INTERFACE");//4
		featureName.add("COMMAND_LINE");
		featureName.add("GUI");
		featureName.add("GUI_PREFERENCES");
		featureName.add("QUERY_HISTORY");
		featureName.add("SINGLE_DIRECTORY");
		featureName.add("MULTI_DIRECTORY");
		featureName.add("NORMAL_VIEW");
		featureName.add("TREE_VIEW");
		featureName.add("WINDOWS");
		
		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationDesktopsearcher.getSINGLETON(Configuration.tool), DesktopSearcherVariables.getSINGLETON());
        executeJunitTestCase(incling);
	}


	public static void main(String[] args) {
		MainTestDesktopsearcher run = new MainTestDesktopsearcher();
		run.expRun();
		
		
 }
}