package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import guidsl.SATtest;
import guidsl.Tool;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.ClientTest;
import testset.EmailTest;
import testset.PL_Iinterface_implTest;
import testset.TestMAB;
import testset.TestMain;
import testset.UtilTest;


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
		
		SPL spl = new SPL();		
		spl.addOthersFeature(f2);
		spl.addOthersFeature(f3);
		spl.addOthersFeature(f4);
		spl.addOthersFeature(f5);
		spl.addOthersFeature(f6);
		spl.addOthersFeature(f7);
		spl.addOthersFeature(f8);
		spl.addOthersFeature(f9);

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
				
				if(integer2 == 0) Configuration.KEYS=true;
				if(integer2 == 1) Configuration.ENCRYPT=true;
				if(integer2 == 2) Configuration.AUTORESPONDER=true;
				if(integer2 == 3) Configuration.ADDRESSBOOK=true;
				if(integer2 == 4) Configuration.SIGN =true;
				if(integer2 == 5) Configuration.FORWARD =true;
				if(integer2 == 6) Configuration.VERIFY =true;
				if(integer2 == 7) Configuration.DECRYPT =true;

				//System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
				cont++;
				Configuration.productPrint();
				
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
			 org.junit.runner.Result result = junit.run(
					 ClientTest.class,
					 EmailTest.class,
					 EmailTest.class,
					 PL_Iinterface_implTest.class,
					 TestMAB.class,
					 TestMain.class,
					 UtilTest.class
					 );
			/* fim core junit */
			  System.err.println("cont: "+cont+"((( apos os testes))) ");
				 Configuration.productPrint();
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
		Configuration.KEYS=false;
		Configuration.ENCRYPT=false;
		Configuration.AUTORESPONDER=false;
		Configuration.ADDRESSBOOK=false;
		Configuration.SIGN =false;
		Configuration.FORWARD =false;
		Configuration.VERIFY =false;
		Configuration.DECRYPT =false; 

	}
	
}
