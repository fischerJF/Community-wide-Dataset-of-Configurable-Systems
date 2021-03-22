package experiment;

import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import tests.Addler32CheckSumTest;
import tests.CompressAdlerCSTests;
import tests.Example_Paulo;
import tests.Example_Paulo2;
import tests.ExtractTest;
import tests.GZIPtest;
import tests.LitleFeatures;

public class Challenge {

	public void executeJunitTestCase(ProductGeneration tools) {
		int cont = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("COMPRESS")) {
					Configuration.COMPRESS = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("GZIP")) {
					Configuration.GZIP = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("EXTRACT")) {
					Configuration.EXTRACT = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("ARCHIVECHECK")) {
					Configuration.ARCHIVECHECK = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("CRC")) {
					Configuration.CRC = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("ADLER32CHECKSUM")) {
					Configuration.ADLER32CHECKSUM = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_COMPRESS_ADLER32CHECKSUM")) {
					Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_COMPRESS_CRC")) {
					Configuration.DERIVATIVE_COMPRESS_CRC = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_COMPRESS_GZIP")) {
					Configuration.DERIVATIVE_COMPRESS_GZIP = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_COMPRESS_GZIPCRC")) {
					Configuration.DERIVATIVE_COMPRESS_GZIPCRC = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_EXTRACT_CRC")) {
					Configuration.DERIVATIVE_EXTRACT_CRC = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DERIVATIVE_GZIPCRC")) {
					Configuration.DERIVATIVE_GZIPCRC = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				cont++;
				/* Chama a bibioteca core do junit para rodar a suite de testes */
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(Example_Paulo.class, Example_Paulo2.class,
						Addler32CheckSumTest.class, CompressAdlerCSTests.class,
						// FirstSuit.class,
						GZIPtest.class, LitleFeatures.class, ExtractTest.class);
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

	public void run(TargetSystem tg, String path) {
		ProductGeneration products = new ProductGeneration();
		products.run(tg, path);
		executeJunitTestCase(products);
	}

	public static void main(String[] args) {
		long startTime = 0;
		long finishTime = 0;
		int totalExecution = 5;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		Challenge challenge = new Challenge();
		while (index < totalExecution) {

			/** Chvatal **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/Chvatal/ZipMe/products";

			/** ICPL **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/ICPL/ZipMe/products";

			/** IncLing **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/IncLing/ZipMe/products";

			/** Random **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/RANDOM/ZipMe/products";

			/** all_valid_conf **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/ZipMe/products";

			/** Chvatal_T4 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T4/ZipMe/products";

			/** Chvatal_T3 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T3/ZipMe/products";

			/** Chvatal_T1 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/Chvatal_T1/ZipMe/products";

			/** ICPL_T1 **/
			// String path =
			// "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T1/ZipMe/products";

			/** ICPL_T3 **/
			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/Challenge/workspace_IncLing/Tools/ICPL_T3/ZipMe/products";

			challenge.run(TargetSystem.ZIPME, path);

			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (ms): " + average
				+ " number of times performed:" + index);

	}
}