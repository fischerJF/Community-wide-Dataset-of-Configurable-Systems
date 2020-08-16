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
import tests.ConnectedTests_Caio;
import tests.CycleRelated_Caio;
import tests.CycleWorkSpaceTest;
import tests.GraphReturnTests_Caio;
import tests.GraphTest;
import tests.JavaUtilityTest;
import tests.MainTest;
import tests.MultiFeatureTest_Caio;
import tests.NetworkGeneratorTest;
import tests.NumberTests_Caio;
import tests.TestSuite_NEW;
import tests.TreeGeneratorTest;


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
		f3.setType(FeatureType.OPTIONAL);
		
		
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
				
				//if(integer2 == 0) Configuration.base=true;
				if(integer2 == 0) Configuration.DIRECTED=true;
				if(integer2 == 1) Configuration.UNDIRECTED=true;
				if(integer2 == 2) Configuration.WEIGHTED=true;
				if(integer2 == 3) Configuration.SEARCH =true;
				if(integer2 == 4) Configuration.BFS =true;
				if(integer2 == 5) Configuration.NUMBER =true;
				if(integer2 == 6) Configuration.CONNECTED =true;
				if(integer2 == 7) Configuration.STRONGLYCONNECTED =true;
				if(integer2 == 8) Configuration.CYCLE =true;
				if(integer2 == 9) Configuration.MSTPRIM =true;
				if(integer2 == 10) Configuration.MSTKRUSKAL =true;
				if(integer2 == 11) Configuration.SHORTEST =true;

				//System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
				Configuration.productPrint();
				cont++;
//			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
//			 junit.addListener(new TextListener(System.out));
 			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
			
			 org.junit.runner.Result result = junit.run(
//					    ConnectedTests_Caio.class,
//				  	    CycleRelated_Caio.class,
//				  	    CycleWorkSpaceTest.class,
//				  	    GraphReturnTests_Caio.class,
//				  	    GraphTest.class,
//				  	    JavaUtilityTest.class,
//				  	    MainTest.class,
//				  	    MultiFeatureTest_Caio.class,
//				  	    NetworkGeneratorTest.class,
//				  	    NumberTests_Caio.class,
//						TestSuite_NEW.class,
//						TreeGeneratorTest.class
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
		Configuration.DIRECTED=false;
		Configuration.UNDIRECTED=false;
		Configuration.WEIGHTED=false;
		Configuration.SEARCH=false;
		Configuration.BFS =false;
		Configuration.NUMBER =false;
		Configuration.CONNECTED =false;
		Configuration.STRONGLYCONNECTED =false; 
		Configuration.CYCLE =false; 
		Configuration.MSTPRIM =false; 
		Configuration.MSTKRUSKAL =false; 
		Configuration.SHORTEST =false; 
	}
	
}
