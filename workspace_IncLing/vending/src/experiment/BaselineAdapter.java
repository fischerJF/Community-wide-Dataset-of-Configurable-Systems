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
import vending.DispenserTest;
import vending.MenuTest;
import vending.VendingMachineTestCase;
import vending.inserCoinTest;

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

		SPL spl = new SPL();
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
		spl.addOthersFeature(f7);
		spl.addOthersFeature(f8);
		spl.addOthersFeature(f9);
		spl.addOthersFeature(f10);
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
					Configuration.base = true;
				if (integer2 == 1)
					Configuration.coinValidation = true;
				if (integer2 == 2)
					Configuration.availability = true;
				if (integer2 == 3)
					Configuration.terminal = true;
				if (integer2 == 4)
					Configuration.keyboard = true;
				if (integer2 == 5)
					Configuration.showStock = true;
				if (integer2 == 6)
					Configuration.flexiblequantity = true;
				if (integer2 == 7)
					Configuration.totalValueCollected = true;
				
		
			}

			if (Configuration.validProduct()) {
				Configuration.productPrint();
				cont++;
				// /* Chama a blibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				// junit.addListener(new TextListener(System.out));
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));

				org.junit.runner.Result result = junit.run(
						DispenserTest.class,
						inserCoinTest.class,
						MenuTest.class,
						VendingMachineTestCase.class
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
		Configuration.base = true;
		Configuration.coinValidation = true;
		Configuration.availability = false;
		Configuration.terminal = false;
		Configuration.keyboard = false;
		Configuration.showStock = false;
		Configuration.flexiblequantity = false;
		Configuration.totalValueCollected = false;
	}

}
