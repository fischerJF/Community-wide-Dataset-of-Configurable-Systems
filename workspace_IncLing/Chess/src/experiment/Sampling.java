package experiment;

import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.AI_PlayerTest;
import testset.BishopTest;
import testset.BoardPanelTest;
import testset.BoardTest;
import testset.KingTest;
import testset.KnightTest;
import testset.MVCTest;
import testset.ModelTest;
import testset.PawnTest;
import testset.PieceTest;
import testset.PlayerTest;
import testset.QueenTest;
import testset.RookTest;
import testset.SpaceTest;
import testset.ViewTest;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int count = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("AI_PLAYER")) {
					Configuration.AI_PLAYER = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("ONLINE_PLAYER")) {
					Configuration.ONLINE_PLAYER = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("OFFLINE_PLAYER")) {
					Configuration.OFFLINE_PLAYER = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				count++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						AI_PlayerTest.class, BishopTest.class, BoardPanelTest.class,
						BoardTest.class, KingTest.class, KnightTest.class, ModelTest.class, MVCTest.class,
						PawnTest.class, PieceTest.class, PlayerTest.class, QueenTest.class, RookTest.class,
						SpaceTest.class, ViewTest.class);
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
		System.out.println("Configurations count:" + count);

	}

	public void run(TargetSystem tg, String path) {
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
		Sampling challenge = new Sampling();
		while (index < totalExecution) {

			/** ICPL **/
//			 String path =
//			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL/Chess/products";

			/** Chvatal **/
//			 String path =
//			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal/Chess/products";

			/** IncLing **/
//			 String path =
//			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/IncLing/Chess/products";

			/** Random **/
			 String path =
			 "C:/Users/labsoft/Documents/workspace_IncLing/Tools/RANDOM/Chess/products";

			/** all_valid_conf **/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/All_valid_conf/Chess/products";

			/**Chvatal  T4**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T4/Chess/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T3/Chess/products";
			
			/**Chvatal  T1**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T1/Chess/products";
		
			/**Chvatal  T2**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/Chvatal_T2/Chess/products";

			/**ICPL_T1**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T1/Chess/products";

			/**ICPL_T2**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T2/Chess/products";

			/**ICPL_T3**/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/ICPL_T3/Chess/products";

			/*YASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/Chess/products";
				  
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/Chess/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/Chess/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/Chess/products";

			/*CASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/Chess/products";
			
			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/Chess/products";
		
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/Chess/products";
			
			/*CASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/Chess/products";

			
			
			challenge.run(TargetSystem.CHESS, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average / 1000)
				+ " number of times performed:" + index);

	}
}