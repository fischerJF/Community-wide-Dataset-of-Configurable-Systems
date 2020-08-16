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
//import testset.AppGUITest;

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
		f5.setType(FeatureType.OPTIONAL);
		Feature f6 = new Feature();
		f6.setType(FeatureType.OPTIONAL);
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
		Feature f25 = new Feature();
		f25.setType(FeatureType.OPTIONAL);
		Feature f26 = new Feature();
		f26.setType(FeatureType.OPTIONAL);
		SPL spl = new SPL();
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
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
		spl.addOthersFeature(f25);
		spl.addOthersFeature(f26);
		makeProduct(spl);
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
					Configuration.volumecontrol = true;
				if (integer2 == 1)
					Configuration.skiptrack = true;
				if (integer2 == 2)
					Configuration.removetrack = true;
				if (integer2 == 3)
					Configuration.wav = true;
				if (integer2 == 4)
					Configuration.reorderplaylist = true;
				if (integer2 == 5)
					Configuration.playlist = true;
				if (integer2 == 6)
					Configuration.control = true;
				if (integer2 == 7)
					Configuration.light = true;
				if (integer2 == 8)
					Configuration.saveandloadplaylist = true;
				if (integer2 == 9)
					Configuration.filesupport = true;
				if (integer2 == 10)
					Configuration.queuetrack = true;
				if (integer2 == 11)
					Configuration.progressbar = true;
				if (integer2 == 12)
					Configuration.mute = true;
				if (integer2 == 13)
					Configuration.showtime = true;
				if (integer2 == 14)
					Configuration.loadfolder = true;
				if (integer2 == 15)
					Configuration.tracktime = true;
				if (integer2 == 16)
					Configuration.shufflerepeat = true;
				if (integer2 == 17)
					Configuration.ogg = true;
				if (integer2 == 18)
					Configuration.mp3 = true;
				if (integer2 == 19)
					Configuration.skins = true;
				if (integer2 == 20)
					Configuration.dark = true;
				if (integer2 == 21)
					Configuration.clearplaylist = true;
				if (integer2 == 22)
					Configuration.showcover = true;
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
		Configuration.featureamp = true;
		Configuration.choosefile = true;
		Configuration.playengine = true;
		Configuration.gui = true;
		Configuration.volumecontrol = true;
		Configuration.skiptrack = true;
		Configuration.removetrack = true;
		Configuration.wav = true;
		Configuration.reorderplaylist = true;
		Configuration.playlist = true;
		Configuration.control = true;
		Configuration.light = true;
		Configuration.saveandloadplaylist = true;
		Configuration.filesupport = true;
		Configuration.queuetrack = true;
		Configuration.progressbar = true;
		Configuration.mute = true;
		Configuration.showtime = true;
		Configuration.loadfolder = true;
		Configuration.tracktime = true;
		Configuration.shufflerepeat = true;
		Configuration.ogg = true;
		Configuration.mp3 = true;
		Configuration.skins = true;
		Configuration.dark = true;
		Configuration.clearplaylist = true;
		Configuration.showcover = true;
	}

}
