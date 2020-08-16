package specifications;

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
import vending.DispenserInput;
import vending.DispenserTest;
import vending.MenuTest;
import vending.VendingMachineTestCase;
import vending.inserCoinTest;



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
	SPL spl = new SPL();	
	spl.addOthersFeature(f2);
	spl.addOthersFeature(f3);
	makeProduct(spl); }

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
				if(integer2 ==0) Configuration.coinValidation=true;
				if(integer2 ==1) Configuration.availability=true;
				if(integer2 ==2) Configuration.terminal=true;
				if(integer2 ==3) Configuration.keyboard=true;
				if(integer2 ==4) Configuration.showStock=true;
				if(integer2 ==5) Configuration.flexiblequantity=true;
				if(integer2 ==6) Configuration.totalValueCollected=true;
			}
			
		 	
			if(Configuration.validProduct() ) {
				Configuration.productPrint();
				cont++;
//			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
//			 junit.addListener(new TextListener(System.out));
 			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
			
			 org.junit.runner.Result result = junit.run(
//					 DispenserTest.class,
//					 inserCoinTest.class,
//					 MenuTest.class,
//					 VendingMachineTestCase.class
					
					 );
//			/* fim core junit */
			 System.err.println("cont: "+cont+"((( apos os testes))) ");
			 Configuration.productPrint();
			 System.out.println("\n\n ----------------------- \n\n");
			 starFeature();
			
			}else {
				//System.err.println("Inválido");
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
		Configuration.base=true;
		Configuration.coinValidation=true;
		Configuration.availability=true;
		Configuration.terminal=true;
		Configuration.keyboard=true;
		Configuration.showStock=true;
		Configuration.flexiblequantity=true;
		Configuration.totalValueCollected=true;
		}
	
}
