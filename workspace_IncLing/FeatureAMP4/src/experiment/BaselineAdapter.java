package experiment;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import baseline.Feature;
import baseline.FeatureType;
import baseline.PowerSet;
import baseline.SPL;
import guidsl.SATtest;
import guidsl.Tool;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.AppGUITest;

public class BaselineAdapter {
	PowerSet powerset;

	public BaselineAdapter() {
		powerset = new PowerSet();
	}

	public void baselineRun() {
		Feature f1 = new Feature();
		f1.setType(FeatureType.MANDATORY);
		
		Feature f2 = new Feature();
		f2.setType(FeatureType.MANDATORY);
		
		Feature f3 = new Feature();
		f3.setType(FeatureType.MANDATORY);
		
		Feature f4 = new Feature();
		f4.setType(FeatureType.MANDATORY);
		
		Feature f5 = new Feature();
		f5.setType(FeatureType.MANDATORY);
		
		Feature f6 = new Feature();
		f6.setType(FeatureType.MANDATORY);
		
		
		Feature f7 = new Feature();
		f7.setType(FeatureType.OPTIONAL);
		Feature f8 = new Feature();
		f8.setType(FeatureType.OPTIONAL);
		Feature f9 = new Feature();
		f9.setType(FeatureType.OPTIONAL);
		Feature f10 = new Feature();
		f10.setType(FeatureType.OPTIONAL);
		Feature f11 = new Feature();
		f11.setType(FeatureType.OPTIONAL);
		Feature f12 = new Feature();
		f12.setType(FeatureType.OPTIONAL);
		Feature f13 = new Feature();
		f13.setType(FeatureType.OPTIONAL);
		Feature f14 = new Feature();
		f14.setType(FeatureType.OPTIONAL);
		Feature f15 = new Feature();
		f15.setType(FeatureType.OPTIONAL);
		Feature f16 = new Feature();
		f16.setType(FeatureType.OPTIONAL);
		Feature f17 = new Feature();
		f17.setType(FeatureType.OPTIONAL);
		Feature f18 = new Feature();
		f18.setType(FeatureType.OPTIONAL);
		Feature f19 = new Feature();
		f19.setType(FeatureType.OPTIONAL);
		Feature f20 = new Feature();
		f20.setType(FeatureType.OPTIONAL);
		Feature f21 = new Feature();
		f21.setType(FeatureType.OPTIONAL);
		Feature f22 = new Feature();
		f22.setType(FeatureType.OPTIONAL);
		Feature f23 = new Feature();
		f23.setType(FeatureType.OPTIONAL);
		Feature f24 = new Feature();
		f24.setType(FeatureType.OPTIONAL);
		SPL spl = new SPL();
		spl.addOthersFeature(f7);
		spl.addOthersFeature(f8);
		spl.addOthersFeature(f9);
		spl.addOthersFeature(f10);
		spl.addOthersFeature(f11);
		spl.addOthersFeature(f12);
		spl.addOthersFeature(f13);
		spl.addOthersFeature(f14);
		spl.addOthersFeature(f15);
		spl.addOthersFeature(f16);
		spl.addOthersFeature(f17);
		spl.addOthersFeature(f18);
		spl.addOthersFeature(f19);
		spl.addOthersFeature(f20);
		spl.addOthersFeature(f21);
		spl.addOthersFeature(f22);
		spl.addOthersFeature(f23);
		spl.addOthersFeature(f24);
	}

	private void makeProduct(SPL spl) {
		List<Integer> list = new ArrayList<Integer>();
		for (int cont = 0; cont < spl.getOthersFeatureList().size(); cont++) {
			list.add(cont);
		}

		int cont = 0;
		Record record = new Record();
		// System.out.println(powerset.getSubsetUsingBitMap(list));
		for (ArrayList<Integer> integer : powerset.getSubsetUsingBitMap(list)) {

			starFeature();
			for (Integer integer2 : integer) {

				if (integer2 == 0)
					Configuration.player_control = true;
				if (integer2 == 1)
					Configuration.reorder_playlist = true;
				if (integer2 == 2)
					Configuration.title_time = true;
				if (integer2 == 3)
					Configuration.skip_track = true;
				if (integer2 == 4)
					Configuration.clear_playlist = true;
				if (integer2 == 5)
					Configuration.progress_bar = true;
				if (integer2 == 6)
					Configuration.volume_control = true;
				if (integer2 == 7)
					Configuration.remove_track = true;
				if (integer2 == 8)
					Configuration.light = true;
				if (integer2 == 9)
					Configuration.dark = true;
				if (integer2 == 10)
					Configuration.shuffle_repeat = true;
				if (integer2 == 11)
					Configuration.show_cover = true;
				if (integer2 == 12)
					Configuration.ogg = true;
				if (integer2 == 13)
					Configuration.mp3 = true;
				if (integer2 == 14)
					Configuration.save_load_playlist = true;
				if (integer2 == 15)
					Configuration.load_folder = true;
				if (integer2 == 16)
					Configuration.queue_track = true;
				if (integer2 == 17)
					Configuration.mute = true;
				if (integer2 == 18)
					Configuration.playlist = true;
			}

			// if (Configuration.validProduct()) {

			cont++;

			Configuration.productPrint();
			//
			// /* Chama a blibioteca core do junit para rodar a suite de testes */
			// JUnitCore junit = new JUnitCore();
			// junit.addListener(new RunListernerReport(Configuration.returnProduct(),
			// record));
			//
			// org.junit.runner.Result result = junit.run(
			//
			// AppGUITest.class
			//
			// );
			/* fim core junit */
			System.err.println("cont: " + cont + "((( apos os testes))) ");
			Configuration.productPrint();
			System.out.println("\n\n ----------------------- \n\n");
			starFeature();

			// } else {
			// // System.err.println("Inválido");
			// }

		}
		// try {
		// record.record2();
		// } catch (Exception e) {
		// // TODO: handle exception
		// }
		System.out.println("Contador de produtos:" + cont);
	}

	private void starFeature() {
		Configuration.base_featureamp = true;
		Configuration.player_bar = true;
		Configuration.id3_title = true;
		Configuration.progress = true;
		Configuration.skins = true;
		Configuration.file_support = true;
		Configuration.player_control = true;
		Configuration.reorder_playlist = true;
		Configuration.title_time = true;
		Configuration.skip_track = true;
		Configuration.clear_playlist = true;
		Configuration.progress_bar = true;
		Configuration.volume_control = true;
		Configuration.remove_track = true;
		Configuration.light = true;
		Configuration.dark = true;
		Configuration.shuffle_repeat = true;
		Configuration.show_cover = true;
		Configuration.ogg = true;
		Configuration.mp3 = true;
		Configuration.save_load_playlist = true;
		Configuration.load_folder = true;
		Configuration.queue_track = true;
		Configuration.mute = true;
		Configuration.playlist = true;
	}

}
