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
import testset.AccountTest;
import testset.ApplicationTest;
import testset.LogEntryTest;
import testset.TransactionTest;



public class BaselineAdapter {
     PowerSet powerset;
     
	public BaselineAdapter() {
		 powerset= new PowerSet();
	}

	public void baselineRun() {
		Feature f1 = new Feature();
		f1.setType(FeatureType.MANDATORY);

		Feature f2 = new Feature();
		f2.setType(FeatureType.OPTIONAL);

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
		spl.addOthersFeature(f2);
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
	
	private void makeProduct (SPL spl) {
		 List<Integer> list = new ArrayList<Integer>();
		for (int cont =0; cont<spl.getOthersFeatureList().size(); cont++) {
			list.add(cont);
		}
		 
		int cont =0;
		Record record = new Record();
		//System.out.println(powerset.getSubsetUsingBitMap(list));
		for (ArrayList<Integer> integer : powerset.getSubsetUsingBitMap(list)) {
			
			starFeature();
			for (Integer integer2 : integer) {
				
				if(integer2 == 0) Configuration.transactionlog=true;
				if(integer2 == 1) Configuration.transaction=true;
				if(integer2 == 2) Configuration.overdraft=true;
				if(integer2 == 3) Configuration.logging=true;
				if(integer2 == 4) Configuration.lock =true;
				if(integer2 == 5) Configuration.interestestimation =true;
				if(integer2 == 6) Configuration.interest =true;
				if(integer2 == 7) Configuration.dailylimit =true;
				if(integer2 == 8) Configuration.creditworthiness =true;
			}

			
			if(Configuration.validProduct() ) {
				
			cont++;
			Configuration.productPrint();
				
			JUnitCore junit = new JUnitCore();
			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));

			 org.junit.runner.Result result = junit.run(
					    AccountTest.class, 
						ApplicationTest.class, 
						TransactionTest.class,
						LogEntryTest.class
					 );

 //			 System.err.println("cont: "+cont+"((( apos os testes))) ");
//			 Configuration.productPrint();
			 System.out.println("\n\n ----------------------- \n\n");
			 starFeature();
				
			}else {
			//	System.err.println("Inválido");
			}
			
		}
		try {
			record.record2();
		}catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Contador de produtos:" + cont);
	}
	
	private void starFeature() {
		Configuration.bankaccount=true;
		Configuration.transactionlog=false;
		Configuration.transaction=false;
		Configuration.overdraft=false;
		Configuration.logging=false;
		Configuration.lock =false;
		Configuration.interestestimation =false;
		Configuration.interest =false;
		Configuration.dailylimit =false; 
		Configuration.creditworthiness =false; 

	}
	
}
