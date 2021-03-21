package experiment;

import java.util.ArrayList;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import report.Record;
import report.RunListernerReport;
import sampling.Feature;
import sampling.SPL;
import sampling.SamplingConfiguration;
import sampling.Strategy;
import specifications.Configuration;
import testset.AccountTest;
import testset.ApplicationTest;
import testset.LogEntryTest;
import testset.TransactionTest;

public class RunSampling {

	private SPL startFeature(int num) {
		SPL spl = new SPL();

		for (int i = 0; i < num; i++) {
			Feature f = new Feature();
			spl.addOthersFeature(f);
		}

		return spl;
	}

	public void run(Strategy str, int numberFeature, int executionNumber) {

		SPL spl = startFeature(numberFeature);

		SamplingConfiguration conf = new SamplingConfiguration(spl);
		
		// One_Enabled
		if(Strategy.ONE_ENABLED==str) 
		conf.one_Enabled();
		
		// One_Disabled
		else if(Strategy.ONE_DISABLED==str)
		 conf.one_Disabled();
		
		// most_Enabled_Disabled
		else if(Strategy.MOST_ENABLED_DISABLED==str)
		 conf.most_Enabled_Disabled();
		
		runConfiguration(conf, executionNumber);

	}

	private void runConfiguration(SamplingConfiguration conf, int executionNumber) {
		Record record = new Record();

		long startTime = 0;
		long finishTime = 0;
		int totalExecution = executionNumber;
		int index = 0;
		finishTime = 0;
		startTime = System.currentTimeMillis();
		int productCounter=0;
		while (index < totalExecution) {
			productCounter=0;
			for (int j = 0; j < conf.getListConfiguration().size(); j++) {
				ArrayList<Feature> temp = conf.getListConfiguration().get(j).getOthersFeatureList();
				
				Configuration.bankaccount = true;
				Configuration.dailylimit = temp.get(0).getStatus() == 1 ? true : false;
				Configuration.interest = temp.get(1).getStatus() == 1 ? true : false;
				Configuration.overdraft = temp.get(2).getStatus() == 1 ? true : false;
				Configuration.creditworthiness = temp.get(3).getStatus() == 1 ? true : false;
				Configuration.lock = temp.get(4).getStatus() == 1 ? true : false;
				Configuration.logging = temp.get(5).getStatus() == 1 ? true : false;
				Configuration.interestestimation = temp.get(6).getStatus() == 1 ? true : false;
				Configuration.transaction = temp.get(7).getStatus() == 1 ? true : false;
				Configuration.transactionlog = temp.get(8).getStatus() == 1 ? true : false;
				
				Configuration.productPrint();
				if (Configuration.validProduct()) {
					JUnitCore junit = new JUnitCore();
					junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
					org.junit.runner.Result result = junit.run(
							AccountTest.class, 
							ApplicationTest.class, 
							TransactionTest.class,
							LogEntryTest.class
							);
					
					productCounter++;
				
			  }else
				  System.out.println("****** Invalid ******");
				
			}
			finishTime = System.currentTimeMillis() - startTime;
			index++;
		}
		try {
			record.record2();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		float average = finishTime / index;

		System.out.println("Total time (ms): " + finishTime + " time average (s): " + (average/1000)
				+ " number of times performed:" + index);
		System.out.println("\n\nNumber of configuration:" + (productCounter));
	}

	public static void main(String[] args) {
		RunSampling run = new RunSampling();
		
		int numberFeature=10;
		int executionNumber=1;
		
		run.run(Strategy.MOST_ENABLED_DISABLED,numberFeature, executionNumber);
	}

}
