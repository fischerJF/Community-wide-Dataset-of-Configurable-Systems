package experiment;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import baseline.Feature;
import baseline.FeatureType;
import baseline.PowerSet;
import baseline.SPL;
//import guidsl.SATtest;
//import guidsl.Tool;
import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.Prop4JTest;





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
	spl.addOthersFeature(f11);
	spl.addOthersFeature(f12);
	spl.addOthersFeature(f13);
	spl.addOthersFeature(f14);
	spl.addOthersFeature(f15);
	spl.addOthersFeature(f16);
	spl.addOthersFeature(f17);
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
					if(integer2 ==0) Configuration.operators=true;
					if(integer2 ==1) Configuration.or=true;
					if(integer2 ==2) Configuration.negation=true;
					if(integer2 ==3) Configuration.atmost=true;
					if(integer2 ==4) Configuration.node_writer=true;
					if(integer2 ==5) Configuration.to_cnf=true;
					if(integer2 ==6) Configuration.extended=true;
					if(integer2 ==7) Configuration.tests=true;
					if(integer2 ==8) Configuration.equals=true;
					if(integer2 ==9) Configuration.node_reader  =true;
					if(integer2 ==10) Configuration.implies=true;
					if(integer2 ==11) Configuration.atleast=true;
					if(integer2 ==12) Configuration.choose=true;
					if(integer2 ==13) Configuration.input_output=true;
					if(integer2 ==14) Configuration.and=true;
					if(integer2 ==15) Configuration.satsolver=true;
			}
			
		      
			
			if(Configuration.validProduct() ) {
				Configuration.productPrint();
				cont++;
//			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
//			 junit.addListener(new TextListener(System.out));
 			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
			
			 org.junit.runner.Result result = junit.run(
//				Prop4JTest.class
					 
					 );
			/* fim core junit */
			 System.err.println("cont: "+cont+"((( apos os testes))) ");
			 Configuration.productPrint();
			 System.out.println("\n\n ----------------------- \n\n");
			 starFeature();
			
			}else {
//				System.err.println("Inválido");
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
		Configuration.prop4jspl=true;
		Configuration.operators=false;
		Configuration.or=false;
		Configuration.negation=false;
		Configuration.atmost=false;
		Configuration.node_writer=false;
		Configuration.to_cnf=false;
		Configuration.extended=false;
		Configuration.tests=false;
		Configuration.equals=false;
		Configuration.node_reader  =false;
		Configuration.implies=false;
		Configuration.atleast=false;
		Configuration.choose=false;
		Configuration.input_output=false;
		Configuration.and=false;
		Configuration.satsolver=false;
		}
	
}
