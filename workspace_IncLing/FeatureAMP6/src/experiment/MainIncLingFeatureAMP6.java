package experiment;

import java.util.ArrayList;
import org.junit.runner.JUnitCore;
import IncLing.*;
import IncLingSpecification.SpecificationFeatureAMP6;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import splat.FeatureAMP6Variables;
import testset.*;

public class MainIncLingFeatureAMP6 {

	public void executeJunitTestCase(IncLing incling) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : incling.getCombsForTest()) {
			for (FeatureIncling f : combination.getListFeatures()) {
				if(f.getName().equals("SKIPTRACK")){ 
					 Configuration.skiptrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("METADATA")){ 
					 Configuration.metadata=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("REMOVETRACK")){ 
					 Configuration.removetrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("ALBUM")){ 
					 Configuration.album=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("WAV")){ 
					 Configuration.wav=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("NICETOHAVE")){ 
					 Configuration.nicetohave=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PLAYLIST")){ 
					 Configuration.playlist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("JUMPPOSITION")){ 
					 Configuration.jumpposition=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("LIGHT")){ 
					 Configuration.light=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("OPENFOLDER")){ 
					 Configuration.openfolder=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("GUI")){ 
					 Configuration.gui=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("FEATUREAMP")){ 
					 Configuration.featureamp=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("QUEUETRACK")){ 
					 Configuration.queuetrack=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("MUTE")){ 
					 Configuration.mute=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("TAGEDITOR")){ 
					 Configuration.tageditor=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("TRACKNUMBER")){ 
					 Configuration.tracknumber=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("CODECS")){ 
					 Configuration.codecs=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PROGRESS")){ 
					 Configuration.progress=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("AAC")){ 
					 Configuration.aac=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PLAYLISTCONTROLS")){ 
					 Configuration.playlistcontrols=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("MULTIPLEPLAYLISTS")){ 
					 Configuration.multipleplaylists=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("RANDOMCOLOR")){ 
					 Configuration.randomcolor=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SAVEANDLOAD")){ 
					 Configuration.saveandload=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SHUFFLEREPEAT")){ 
					 Configuration.shufflerepeat=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("BASE")){ 
					 Configuration.base=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("OGG")){ 
					 Configuration.ogg=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("YOUTUBE")){ 
					 Configuration.youtube=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("MP3")){ 
					 Configuration.mp3=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("OSCOLORS")){ 
					 Configuration.oscolors=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("REORDER")){ 
					 Configuration.reorder=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("COVER")){ 
					 Configuration.cover=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("VOLUME")){ 
					 Configuration.volume=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("SKINS")){ 
					 Configuration.skins=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("DARK")){ 
					 Configuration.dark=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("CLEARPLAYLIST")){ 
					 Configuration.clearplaylist=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("REMEBERSTATUS")){ 
					 Configuration.remeberstatus=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("PROGRESSBAR")){ 
					 Configuration.progressbar=(f.getState().equals("0") ? false : true);
					}
					if(f.getName().equals("TITLEBAR")){ 
					 Configuration.titlebar=(f.getState().equals("0") ? false : true);
					}
			}
			if (Configuration.validProduct()) {
				cont++;
				Configuration.productPrint();

				/* Chama a blibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(AppGUITest.class);
				/* fim core junit */
				System.err.println("cont: " + cont + "((( apos os testes))) ");
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
			} else {
//				System.err.println("****** Invalid ******");
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
		featureName.add("SKIPTRACK");
		featureName.add("METADATA");
		featureName.add("REMOVETRACK");
		featureName.add("ALBUM");
		featureName.add("WAV");
		featureName.add("NICETOHAVE");
		featureName.add("PLAYLIST");
		featureName.add("JUMPPOSITION");
		featureName.add("LIGHT");
		featureName.add("OPENFOLDER");
		featureName.add("GUI");
		featureName.add("FEATUREAMP");
		featureName.add("QUEUETRACK");
		featureName.add("MUTE");
		featureName.add("TAGEDITOR");
		featureName.add("TRACKNUMBER");
		featureName.add("CODECS");
		featureName.add("PROGRESS");
		featureName.add("AAC");
		featureName.add("PLAYLISTCONTROLS");
		featureName.add("MULTIPLEPLAYLISTS");
		featureName.add("RANDOMCOLOR");
		featureName.add("SAVEANDLOAD");
		featureName.add("SHUFFLEREPEAT");
		featureName.add("BASE");
		featureName.add("OGG");
		featureName.add("YOUTUBE");
		featureName.add("MP3");
		featureName.add("OSCOLORS");
		featureName.add("REORDER");
		featureName.add("COVER");
		featureName.add("VOLUME");
		featureName.add("SKINS");
		featureName.add("DARK");
		featureName.add("CLEARPLAYLIST");
		featureName.add("REMEBERSTATUS");
		featureName.add("PROGRESSBAR");
		featureName.add("TITLEBAR");
		
		IncLing incling = new IncLing(1000, 10000, featureName,
				SpecificationFeatureAMP6.getSINGLETON(Configuration.tool), FeatureAMP6Variables.getSINGLETON());
		executeJunitTestCase(incling);
	}

	public static void main(String[] args) {
		MainIncLingFeatureAMP6 run = new MainIncLingFeatureAMP6();
		run.expRun();

	}
}