package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import IncLing.*;
import IncLingSpecification.Specification;
import IncLingSpecification.SpecificationGPL;
import IncLingSpecification.SpecificationNotepad;
import specifications.Configuration;
import splat.GPLVariables;
import splat.NotepadVariables;

public class MainTestNotepad {

	public void executeJunitTestCase(IncLing incling) {

		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
				if (f.getName().equals("BASEMENUBAR")) {
					Configuration.BASEMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("BASETOOLBAR")) {
					Configuration.BASETOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("EDITMENUBAR")) {
					Configuration.EDITMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("EDITTOOLBAR")) {
					Configuration.EDITTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("FORMATMENUBAR")) {
					Configuration.FORMATMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("FORMATTOOLBAR")) {
					Configuration.FORMATTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PERSISTENCEMENUBAR")) {
					Configuration.PERSISTENCEMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PERSISTENCETOOLBAR")) {
					Configuration.PERSISTENCETOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PRINTMENUBAR")) {
					Configuration.PRINTMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PRINTTOOLBAR")) {
					Configuration.PRINTTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SEARCHMENUBAR")) {
					Configuration.SEARCHMENUBAR = (f.getState().equals("0") ? false : true);
				}

				if (f.getName().equals("UNDOREDOMENUBAR")) {
					Configuration.UNDOREDOMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("UNDOREDOTOOLBAR")) {
					Configuration.UNDOREDOTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WORDCOUNTMENUBAR")) {
					Configuration.WORDCOUNTMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WORDCOUNTTOOLBAR")) {
					Configuration.WORDCOUNTTOOLBAR = (f.getState().equals("0") ? false : true);
				}

				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new TextListener(System.out));
				org.junit.runner.Result result = junit.run();
				/* fim core junit */
			}
		}
	}

	public void expRun() {
		ArrayList<String> featureName = new ArrayList<String>();
		featureName.add("BASEMENUBAR"); // 0
		featureName.add("BASEMENUBAR"); // 1
		featureName.add("BASETOOLBAR"); // 1
		featureName.add("EDITMENUBAR");// 2
		featureName.add("EDITTOOLBAR");// 3
		featureName.add("FORMATMENUBAR");// 4
		featureName.add("FORMATTOOLBAR");
		featureName.add("PERSISTENCEMENUBAR");
		featureName.add("PERSISTENCETOOLBAR");
		featureName.add("PRINTMENUBAR");
		featureName.add("PRINTTOOLBAR");
		featureName.add("SEARCHMENUBAR");
		featureName.add("UNDOREDOMENUBAR");
		featureName.add("UNDOREDOTOOLBAR");
		featureName.add("WORDCOUNTMENUBAR");
		featureName.add("WORDCOUNTTOOLBAR");

		IncLing incling = new IncLing(1000, 10000, featureName, SpecificationNotepad.getSINGLETON(Configuration.tool),
				NotepadVariables.getSINGLETON());
	//	executeJunitTestCase(incling);
	}

	public static void main(String[] args) {
		MainTestNotepad run = new MainTestNotepad();
		run.expRun();

	}
}