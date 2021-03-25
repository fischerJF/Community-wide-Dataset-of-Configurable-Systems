package experiment;


import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.*;


public class Sampling {
	
	public  void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("BASE")) {
					Configuration.BASE = (f.getState().equals("0") ? false : true);
				}
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
				if (f.getName().equals("SEARCHTOOLBAR")) {
					Configuration.SEARCHTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("UNDOREDOMENUBAR")) {
					Configuration.UNDOREDOMENUBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("UNDOREDOTOOLBAR")) {
					Configuration.UNDOREDOTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WORDCOUNTTOOLBAR")) {
					Configuration.WORDCOUNTTOOLBAR = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WORDCOUNTMENUBAR")) {
					Configuration.WORDCOUNTMENUBAR = (f.getState().equals("0") ? false : true);
				}
								
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						  TestEditToolBar.class,
						  TestFileMenuBar.class,
						  TestFileToolBar.class,
						  TestFormatMenuBar.class,
						  TestFormatToolBar.class,
						  TestTextArea.class,
						  TestHelp.class,
						  TestWordCount.class,
						  TestExample_Paulo.class,
						  NotepadJUnitTest_lest.class
				    );
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
	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}


	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution =1;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
			/**Chvatal **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/Notepad/products";
		
			/**ICPL**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/Notepad/products";
			
			/**IncLing **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/Notepad/products";
			
			/**Random **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/Notepad/products";

			/**all_valid_conf**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/All_valid_conf/Notepad/products";
		
			
			/**Chvatal  T4**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/Notepad/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/Notepad/products";
			
			/**Chvatal  T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/Notepad/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/Notepad/products";
//
			/**ICPL_T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/Notepad/products";

//	      /*YASA_T4*/
//		  String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/Notepad1/products";
		
       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/Notepad1/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/Notepad1/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/Notepad1/products";

			/*CASA_T4*/ 
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/Notepad1/products";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/Notepad1/products";
		
			/*CASA_T2*/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/Notepad1/products";
			
//			/*CASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/Notepad1/products";

			
			
			challenge.run(TargetSystem.NOTEPAD, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (ms): " + (average/1000)
				+ " number of times performed:" + index);

	}
}