package experiment;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import UnionFind.UnionFind;
import baseline.Feature;
import baseline.FeatureType;
import baseline.PowerSet;
import baseline.SPL;
import guidsl.SATtest;
import guidsl.Tool;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.InTest;
import testset.StopwatchTest;
import testset.TestPerformance;
import testset.TestUF;
import testset.UnionFindTest;

public class BaselineAdapter {
	PowerSet powerset;

	public BaselineAdapter() {
		powerset = new PowerSet();

	}

	public void baselineRun() {
		Feature f2 = new Feature();
		f2.setType(FeatureType.MANDATORY);
		Feature f3 = new Feature();
		f3.setType(FeatureType.OPTIONAL);
		Feature f4 = new Feature();
		f4.setType(FeatureType.OPTIONAL);
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
		SPL spl = new SPL();
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
		spl.addOthersFeature(f7);
		spl.addOthersFeature(f8);
		spl.addOthersFeature(f9);
		spl.addOthersFeature(f10);
		spl.addOthersFeature(f11);
		spl.addOthersFeature(f12);
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
					Configuration.wqu_byheight = true;
				if (integer2 == 1)
					Configuration.quickfind = true;
				if (integer2 == 2)
					Configuration.qu_weighted_modifications = true;
				if (integer2 == 3)
					Configuration.qu_weighted = true;
				if (integer2 == 4)
					Configuration.unionfindspl = true;
				if (integer2 == 5)
					Configuration.quickunion = true;
				if (integer2 == 6)
					Configuration.wqu_halfing = true;
				if (integer2 == 7)
					Configuration.wqu_pathcompression = true;
				if (integer2 == 8)
					Configuration.unionfind = true;
				if (integer2 == 9)
					Configuration.tests = true;
		
			}

			if (Configuration.validProduct()) {
				Configuration.productPrint();
				cont++;
				// /* Chama a blibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				// junit.addListener(new TextListener(System.out));
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));

				org.junit.runner.Result result = junit.run(
//						InTest.class,
//						StopwatchTest.class,
//						TestPerformance.class,
//						TestUF.class,
//						UnionFindTest.class
						);
				// /* fim core junit */
				System.err.println("cont: " + cont + "((( apos os testes))) ");
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
				starFeature();

			} else {
				// System.err.println("Inválido");
			}
		}
		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Contador de produtos:" + cont);
	}

	private void starFeature() {
		Configuration.tests = true;
		Configuration.unionfind = true;
		Configuration.wqu_byheight = false;
		Configuration.quickfind = false;
		Configuration.qu_weighted_modifications = false;
		Configuration.qu_weighted = false;
		Configuration.unionfindspl = false;
		Configuration.quickunion = false;
		Configuration.wqu_halfing = false;
		Configuration.wqu_pathcompression = false;
	}

}
