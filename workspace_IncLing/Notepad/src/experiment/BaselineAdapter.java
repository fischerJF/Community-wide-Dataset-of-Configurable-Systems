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
import specifications.Configuration;
import testset.NotepadJUnitTest_lest;
import testset.TestEditMenuBar;
import testset.TestEditToolBar;
import testset.TestExample_Paulo;
import testset.TestFileMenuBar;
import testset.TestFileToolBar;
import testset.TestFormatMenuBar;
import testset.TestFormatToolBar;
import testset.TestHelp;
import testset.TestTextArea;
import testset.TestWordCount;



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
				//:0 EDITMENUBAR:0 BASETOOLBAR:0 BASEMENUBAR:1 BASE:1 

				if(integer2 == 0) Configuration.BASEMENUBAR=true;
				if(integer2 == 1) Configuration.BASETOOLBAR=true;
				if(integer2 == 2) Configuration.EDITMENUBAR=true;
				if(integer2 == 3) Configuration.EDITTOOLBAR=true;
				if(integer2 == 4) Configuration.FORMATMENUBAR =true;
				if(integer2 == 5) Configuration.FORMATTOOLBAR =true;
				if(integer2 == 6) Configuration.PERSISTENCEMENUBAR =true;
				if(integer2 == 7) Configuration.PERSISTENCETOOLBAR =true;
				if(integer2 == 8) Configuration.PRINTMENUBAR =true;
				if(integer2 == 9) Configuration.PRINTTOOLBAR =true;
				if(integer2 == 10) Configuration.SEARCHMENUBAR =true;
				if(integer2 == 11) Configuration.SEARCHTOOLBAR =true;
				if(integer2 == 12) Configuration.UNDOREDOTOOLBAR =true;
				if(integer2 == 13) Configuration.UNDOREDOMENUBAR =true;
				if(integer2 == 14) Configuration.WORDCOUNTMENUBAR =true;
				if(integer2 == 15) Configuration.WORDCOUNTTOOLBAR =true;

			//	System.out.print(integer2+" ");
				
			}
			
			if(Configuration.validProduct() ) {
				Configuration.productPrint();
				cont++;
			/* Chama a blibioteca core do junit para rodar a suite de testes */
			JUnitCore junit = new JUnitCore();
			 junit.addListener(new TextListener(System.out));
			 org.junit.runner.Result result = junit.run(
//					  TestEditMenuBar.class,
					/*  TestEditToolBar.class,
					  TestFileMenuBar.class,
					  TestFileToolBar.class,
					  TestFormatMenuBar.class,
					  TestFormatToolBar.class,
					  TestTextArea.class,
					  TestHelp.class,
					  TestWordCount.class,
					  TestExample_Paulo.class,
					  NotepadJUnitTest_lest.class*/
					 );
			/* fim core junit */
			System.err.println("cont: "+cont+"((( apos os testes))) ");
				 Configuration.productPrint();
				 System.out.println("\n\n ----------------------- \n\n");
			
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
		Configuration.BASE=true;
		Configuration.BASEMENUBAR=false;
		Configuration.BASETOOLBAR=false;
		Configuration.EDITMENUBAR=false;
		Configuration.EDITTOOLBAR=false;
		Configuration.FORMATMENUBAR =false;
		Configuration.FORMATTOOLBAR =false;
		Configuration.PERSISTENCEMENUBAR =false;
		Configuration.PERSISTENCETOOLBAR =false; 
		Configuration.PRINTMENUBAR =false; 
		Configuration.PRINTTOOLBAR =false; 
		Configuration.SEARCHMENUBAR =false; 
		Configuration.SEARCHTOOLBAR =false; 
		Configuration.UNDOREDOTOOLBAR =false; 
		Configuration.UNDOREDOMENUBAR =false; 
		Configuration.WORDCOUNTMENUBAR = false;
		Configuration.WORDCOUNTTOOLBAR =false; 

	}
	
}
