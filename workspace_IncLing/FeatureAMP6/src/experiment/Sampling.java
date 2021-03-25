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

import testset.AppGUITest;

public class Sampling {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("SkipTrack")) {
					Configuration.skiptrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Metadata")) {
					Configuration.metadata = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("RemoveTrack")) {
					Configuration.removetrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Album")) {
					Configuration.album = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("WAV")) {
					Configuration.wav = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("NiceToHave")) {
					Configuration.nicetohave = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Playlist")) {
					Configuration.playlist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("JumpPosition")) {
					Configuration.jumpposition = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Light")) {
					Configuration.light = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("OpenFolder")) {
					Configuration.openfolder = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("GUI")) {
					Configuration.gui = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("FeatureAMP")) {
					Configuration.featureamp = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("QueueTrack")) {
					Configuration.queuetrack = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Mute")) {
					Configuration.mute = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("TagEditor")) {
					Configuration.tageditor = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Tracknumber")) {
					Configuration.tracknumber = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Codecs")) {
					Configuration.codecs = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Progress")) {
					Configuration.progress = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("AAC")) {
					Configuration.aac = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("PlaylistControls")) {
					Configuration.playlistcontrols = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MultiplePlaylists")) {
					Configuration.multipleplaylists = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("RandomColor")) {
					Configuration.randomcolor = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("SaveAndLoad")) {
					Configuration.saveandload = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ShuffleRepeat")) {
					Configuration.shufflerepeat = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Base")) {
					Configuration.base = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("OGG")) {
					Configuration.ogg = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("YouTube")) {
					Configuration.youtube = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("MP3")) {
					Configuration.mp3 = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("OSColors")) {
					Configuration.oscolors = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Reorder")) {
					Configuration.reorder = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Cover")) {
					Configuration.cover = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Volume")) {
					Configuration.volume = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Skins")) {
					Configuration.skins = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Dark")) {
					Configuration.dark = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("ClearPlaylist")) {
					Configuration.clearplaylist = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("RemeberStatus")) {
					Configuration.remeberstatus = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Progressbar")) {
					Configuration.progressbar = (f.getState().equals("0") ? false : true);
				}
				if (f.getName().equals("Titlebar")) {
					Configuration.titlebar = (f.getState().equals("0") ? false : true);
				}

			}
			System.out.println("\n\n *** Configuration:" + cont+ "\n\n");
			Configuration.productPrint();
			System.out.println("");cont++;
			if (Configuration.validProduct()) {
				
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(AppGUITest.class);
				System.out.println("cont: " + cont + "((( apos os testes))) ");
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
			} else {
				System.out.println("****** Invalid ******");
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
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/FeatureAMP6/products";

			/** Chvatal **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal/FeatureAMP6/products";

			/** IncLing **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/FeatureAMP6/products";

			/** Random **/
//			 String path =
//			 "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/FeatureAMP6/products";

			/** all_valid_conf **/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/FeatureAMP6/products";

			/**Chvatal  T4**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/FeatureAMP6/products";

			/**Chvatal  T3**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/FeatureAMP6/products";
			
			/**Chvatal  T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/FeatureAMP6/products";

			/**ICPL_T1**/
//			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/FeatureAMP6/products";

			/**ICPL_T3**/
			//String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/FeatureAMP6/products";

		
			/*YASA_T4*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T4/FeatureAMP6/products";
       
			/*YASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T3/FeatureAMP6/products";
			  
			/*YASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T2/FeatureAMP6/products";

			/*YASA_T1*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/YASA_T1/FeatureAMP6/products";

			/*CASA_T4*/ 
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T4/FeatureAMP6/products";

			/*CASA_T3*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T3/FeatureAMP6/products";
		
			/*CASA_T2*/
//			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T2/FeatureAMP6/products";
			
//			/*CASA_T1*/
			String path = "C:/Users/labsoft/Documents/workspace_IncLing/Tools/CASA_T1/FeatureAMP6/products";

			
			
			challenge.run(TargetSystem.FeatureAMP6, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (s): " + finishTime + " time average (s): " + (average/1000)
				+ " number of times performed:" + index);

	}
}