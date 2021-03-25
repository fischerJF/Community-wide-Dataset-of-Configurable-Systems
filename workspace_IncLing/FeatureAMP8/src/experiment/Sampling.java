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
import testset.ApplicationGUITest;
import testset.ID3TagTest;
import testset.MP3PlayerTest;
import testset.ZuordnungTest;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("VolumeControl")) {
					Configuration.volumecontrol = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SkipTrack")) {
					Configuration.skiptrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PlayEngine")) {
					Configuration.playengine = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("RemoveTrack")) {
					Configuration.removetrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WAV")) {
					Configuration.wav = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ReorderPlaylist")) {
					Configuration.reorderplaylist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Playlist")) {
					Configuration.playlist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Control")) {
					Configuration.control = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Light")) {
					Configuration.light = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SaveAndLoadPlaylist")) {
					Configuration.saveandloadplaylist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("GUI")) {
					Configuration.gui = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("FeatureAMP")) {
					Configuration.featureamp = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("FileSupport")) {
					Configuration.filesupport = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("QueueTrack")) {
					Configuration.queuetrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ProgressBar")) {
					Configuration.progressbar = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Mute")) {
					Configuration.mute = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ShowTime")) {
					Configuration.showtime = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("LoadFolder")) {
					Configuration.loadfolder = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TrackTime")) {
					Configuration.tracktime = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ShuffleRepeat")) {
					Configuration.shufflerepeat = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("OGG")) {
					Configuration.ogg = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MP3")) {
					Configuration.mp3 = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Skins")) {
					Configuration.skins = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Dark")) {
					Configuration.dark = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ChooseFile")) {
					Configuration.choosefile = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ClearPlaylist")) {
					Configuration.clearplaylist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("showCover")) {
					Configuration.showcover = (f.getState().equals("0") ? false : true);
				}

			}
			System.out.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(ApplicationGUITest.class, ID3TagTest.class,
						MP3PlayerTest.class, ZuordnungTest.class);
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

	}

	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 1;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Sampling challenge = new Sampling();
		while (index < totalExecution) {
			
			/** ICPL **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/FeatureAMP8/products";

			/** Chvatal **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/FeatureAMP8/products";

			/** IncLing **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/FeatureAMP8/products";

			/** Random **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/FeatureAMP8/products";

			/** all_valid_conf **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/FeatureAMP8/products";

			/**Chvatal  T4**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/FeatureAMP8/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/FeatureAMP8/products";
			
			/**Chvatal  T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/FeatureAMP8/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/FeatureAMP8/products";

			/**ICPL_T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/FeatureAMP8/products";


			/*YASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/FeatureAMP8/products";
       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/FeatureAMP8/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/FeatureAMP8/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/FeatureAMP8/products";

			/*CASA_T4*/ 
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/FeatureAMP8/p";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/FeatureAMP8/products";
		
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/FeatureAMP8/products";
			
//			/*CASA_T1*/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/FeatureAMP8/products";

		
			
			challenge.run(TargetSystem.FeatureAMP8, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.err.println("Total time (ms): " + finishTime + " time average (s): " + (average/1000)
				+ " number of times performed:" + index);
	}
}