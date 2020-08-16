package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import tests.Addler32CheckSumTest;
import tests.CompressAdlerCSTests;
import tests.Example_Paulo;
import tests.Example_Paulo2;
import tests.ExtractTest;
import tests.FirstSuit;
import tests.GZIPtest;
import tests.LitleFeatures;



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
				if(integer2 == 0) Configuration.COMPRESS=true;
				if(integer2 == 1) Configuration.GZIP=true;
				if(integer2 == 2) Configuration.EXTRACT=true;
				if(integer2 == 3) Configuration.ARCHIVECHECK=true;
				if(integer2 == 4) Configuration.CRC =true;
				if(integer2 == 5) Configuration.ADLER32CHECKSUM =true;
				if(integer2 == 6) Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM =true;
				if(integer2 == 7) Configuration.DERIVATIVE_COMPRESS_CRC =true;
				if(integer2 == 8) Configuration.DERIVATIVE_COMPRESS_GZIP =true;
				if(integer2 == 9) Configuration.DERIVATIVE_COMPRESS_GZIPCRC =true;
				if(integer2 == 10) Configuration.DERIVATIVE_EXTRACT_CRC =true;
				if(integer2 == 11) Configuration.DERIVATIVE_GZIPCRC =true;
			

//				System.out.print(integer2+" ");
				
			} 
//			System.out.println();
			
		      
			
			if(Configuration.validProduct() ) {
			  Configuration.productPrint();
				cont++;
//			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
//			 junit.addListener(new TextListener(System.out));
	 			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));

			 org.junit.runner.Result result = junit.run(
			      Example_Paulo.class,
			      Example_Paulo2.class,
			      Addler32CheckSumTest.class,
			      CompressAdlerCSTests.class,
//			      FirstSuit.class,
			      GZIPtest.class,
			      LitleFeatures.class,
			      ExtractTest.class
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
		Configuration.COMPRESS=false;
		Configuration.GZIP=false;
		Configuration.EXTRACT=false;
		Configuration.ARCHIVECHECK =false;
		Configuration.CRC =false;
		Configuration.ADLER32CHECKSUM =false;
		Configuration.DERIVATIVE_COMPRESS_ADLER32CHECKSUM =false;
		Configuration.DERIVATIVE_COMPRESS_CRC =false;
		Configuration.DERIVATIVE_COMPRESS_GZIP =false;
		Configuration.DERIVATIVE_COMPRESS_GZIPCRC =false;
		Configuration.DERIVATIVE_EXTRACT_CRC =false;
		Configuration.DERIVATIVE_GZIPCRC =false;

	}
	
}
