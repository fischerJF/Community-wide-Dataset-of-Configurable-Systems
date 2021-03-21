package experiment;

import org.junit.runner.JUnitCore;
import Combinations.Combination;
import Combinations.FeatureCombination;
import Main.ProductGeneration;
import Main.TargetSystem;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.ClientTest;
import testset.EmailTest;
import testset.PL_Iinterface_implTest;
import testset.TestMAB;
import testset.TestMain;
import testset.UtilTest;

public class Challenge {

	public void executeJunitTestCase(ProductGeneration tools) {
		int count = 0;
		Record record = new Record();
		for (Combination combination : tools.getCombsForTest()) {
			for (FeatureCombination f : combination.getListFeatures()) {
				if (f.getName().equals("KEYS")) {
					Configuration.KEYS = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("ENCRYPT")) {
					Configuration.ENCRYPT = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("AUTORESPONDER")) {
					Configuration.AUTORESPONDER = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("ADDRESSBOOK")) {
					Configuration.ADDRESSBOOK = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("SIGN")) {
					Configuration.SIGN = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("FORWARD")) {
					Configuration.FORWARD = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("VERIFY")) {
					Configuration.VERIFY = (f.getState().equals("0") ? false : true);
				} else if (f.getName().equals("DECRYPT")) {
					Configuration.DECRYPT = (f.getState().equals("0") ? false : true);
				}
			}
			System.err.println("Configuration:");
			Configuration.productPrint();
			System.out.println("");
			if (Configuration.validProduct()) {
				count++;
				JUnitCore junit = new JUnitCore();
				junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
				org.junit.runner.Result result = junit.run(ClientTest.class, EmailTest.class,
						PL_Iinterface_implTest.class, TestMAB.class, TestMain.class, UtilTest.class);
				Configuration.productPrint();
				System.out.println("\n\n ----------------------- \n\n");
			} else {
				System.err.println("****** Invalid ******");
			}
		}
		try {
			record.record2();
		} catch (Exception e) {
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
		Challenge challenge = new Challenge();
		while (index < totalExecution) {

			String path = "C:/Users/Fischer_PC/Documents/2019_CSS_Journal/workspace_IncLing/Tools/All_valid_conf/email/products";

			challenge.run(TargetSystem.EMAIL, path);
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}

		float average = finishTime / index;
		System.out.println(
				"Total time (ms): " + " time average (s): " + (average / 1000) + " number of times performed:" + index);
	}
}