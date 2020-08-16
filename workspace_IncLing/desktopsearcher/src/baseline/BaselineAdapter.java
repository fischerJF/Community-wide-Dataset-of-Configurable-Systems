package baseline;

import java.util.ArrayList;
import java.util.List;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

import report.Record;
import report.RunListernerReport;
import specifications.Configuration;
import testset.TestAll;
import testset.TestCommandLine;
import testset.TestCommandLineExample_Mateus;
import testset.TestGUIExample;



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
				
				if(integer2 == 0) Configuration.HTML=true;
				if(integer2 == 1) Configuration.TXT=true;
				if(integer2 == 2) Configuration.LATEX=true;
				if(integer2 == 3) Configuration.USER_INTERFACE=true;
				if(integer2 == 4) Configuration.COMMAND_LINE =true;
				if(integer2 == 5) Configuration.GUI =true;
				if(integer2 == 6) Configuration.GUI_PREFERENCES =true;
				if(integer2 == 7) Configuration.QUERY_HISTORY =true;
				if(integer2 == 8) Configuration.INDEX_HISTORY =true;
				if(integer2 == 9) Configuration.SINGLE_DIRECTORY =true;
				if(integer2 == 10) Configuration.MULTI_DIRECTORY =true;
				if(integer2 == 11) Configuration.NORMAL_VIEW =true;
				if(integer2 == 12) Configuration.TREE_VIEW =true;
				if(integer2 == 13) Configuration.WINDOWS =true;
				if(integer2 == 14) Configuration.LINUX =true;

			//	System.out.print(integer2+" ");
				
			}
			
		      
			
			if(Configuration.validProduct() ) {
				Configuration.productPrint();
				cont++;
				
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
 			junit.addListener(new RunListernerReport(Configuration.returnProduct(), record));
			 org.junit.runner.Result result = junit.run(
					 TestCommandLine.class
//					 TestCommandLineExample_Mateus.class
					 );
//			/* fim core junit */
			
			 System.err.println("cont: "+cont+"((( apos os testes))) ");
			 Configuration.productPrint();
			 System.out.println("\n\n ----------------------- \n\n");
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
		Configuration.BASE=true;
		Configuration.HTML=false;
		Configuration.TXT=false;
		Configuration.LATEX=false;
		Configuration.USER_INTERFACE=false;
		Configuration.COMMAND_LINE =false;
		Configuration.GUI =false;
		Configuration.GUI_PREFERENCES =false;
		Configuration.QUERY_HISTORY =false; 
		Configuration.INDEX_HISTORY =false; 
		Configuration.SINGLE_DIRECTORY =false; 
		Configuration.MULTI_DIRECTORY =false; 
		Configuration.NORMAL_VIEW =false; 
		Configuration.WINDOWS =false; 
		Configuration.LINUX =false; 
		Configuration.TREE_VIEW =false; 

	}
	
}
