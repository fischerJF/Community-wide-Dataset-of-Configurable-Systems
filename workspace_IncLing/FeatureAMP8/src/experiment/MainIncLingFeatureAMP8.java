package experiment;

import java.util.ArrayList;
import org.junit.runner.JUnitCore;
import IncLing.*;
import IncLingSpecification.SpecificationFeatureAMP8;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import splat.FeatureAMP8Variables;
import testset.*;

public class MainIncLingFeatureAMP8 {

	public void executeJunitTestCase(IncLing incling) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
				if(f.getName().equals("VOLUMECONTROL")){ 
					 Configuration.volumecontrol=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SKIPTRACK")){ 
					 Configuration.skiptrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PLAYENGINE")){ 
					 Configuration.playengine=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("REMOVETRACK")){ 
					 Configuration.removetrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("WAV")){ 
					 Configuration.wav=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("REORDERPLAYLIST")){ 
					 Configuration.reorderplaylist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PLAYLIST")){ 
					 Configuration.playlist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("CONTROL")){ 
					 Configuration.control=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("LIGHT")){ 
					 Configuration.light=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SAVEANDLOADPLAYLIST")){ 
					 Configuration.saveandloadplaylist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("GUI")){ 
					 Configuration.gui=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("FEATUREAMP")){ 
					 Configuration.featureamp=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("FILESUPPORT")){ 
					 Configuration.filesupport=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("QUEUETRACK")){ 
					 Configuration.queuetrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PROGRESSBAR")){ 
					 Configuration.progressbar=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("MUTE")){ 
					 Configuration.mute=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SHOWTIME")){ 
					 Configuration.showtime=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("LOADFOLDER")){ 
					 Configuration.loadfolder=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("TRACKTIME")){ 
					 Configuration.tracktime=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SHUFFLEREPEAT")){ 
					 Configuration.shufflerepeat=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("OGG")){ 
					 Configuration.ogg=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("MP3")){ 
					 Configuration.mp3=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SKINS")){ 
					 Configuration.skins=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("DARK")){ 
					 Configuration.dark=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("CHOOSEFILE")){ 
					 Configuration.choosefile=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("CLEARPLAYLIST")){ 
					 Configuration.clearplaylist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SHOWCOVER")){ 
					 Configuration.showcover=(f.getState().equals("0") ? false : true);
					}
			}
		
			if (Configuration.validProduct()) {
				cont++;
				Configuration.productPrint();

				/* Chama a blibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(
						ApplicationGUITest.class,
						ID3TagTest.class,
						MP3PlayerTest.class,
						ZuordnungTest.class
						
						);
				/* fim core junit */
				System.err.println("cont: " + cont + "((( apos os testes))) ");
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

	public void expRun() {
		ArrayList<String> featureName = new ArrayList<String>();
		featureName.add("VOLUMECONTROL");
		featureName.add("SKIPTRACK");
		featureName.add("PLAYENGINE");
		featureName.add("REMOVETRACK");
		featureName.add("WAV");
		featureName.add("REORDERPLAYLIST");
		featureName.add("PLAYLIST");
		featureName.add("CONTROL");
		featureName.add("LIGHT");
		featureName.add("SAVEANDLOADPLAYLIST");
		featureName.add("GUI");
		featureName.add("FEATUREAMP");
		featureName.add("FILESUPPORT");
		featureName.add("QUEUETRACK");
		featureName.add("PROGRESSBAR");
		featureName.add("MUTE");
		featureName.add("SHOWTIME");
		featureName.add("LOADFOLDER");
		featureName.add("TRACKTIME");
		featureName.add("SHUFFLEREPEAT");
		featureName.add("OGG");
		featureName.add("MP3");
		featureName.add("SKINS");
		featureName.add("DARK");
		featureName.add("CHOOSEFILE");
		featureName.add("CLEARPLAYLIST");
		featureName.add("SHOWCOVER");
//		
		IncLing incling = new IncLing(1000, 10000, featureName,
				SpecificationFeatureAMP8.getSINGLETON(Configuration.tool), FeatureAMP8Variables.getSINGLETON());
		executeJunitTestCase(incling);
	}

	public static void main(String[] args) {
		MainIncLingFeatureAMP8 run = new MainIncLingFeatureAMP8();
		run.expRun();

	}
}