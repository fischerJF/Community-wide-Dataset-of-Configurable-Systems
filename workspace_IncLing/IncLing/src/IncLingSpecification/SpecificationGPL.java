package IncLingSpecification;

import java.util.ArrayList;

import IncLing.Combination;
import IncLing.FeatureIncling;
import IncLingSpecification.Specification;
import guidsl.SATtest;
import guidsl.Tool;

public class SpecificationGPL  extends Specification{
	public  boolean base = true;
	public  boolean DIRECTED = false;
	public  boolean UNDIRECTED = false;
	public  boolean WEIGHTED = false;
	public  boolean SEARCH = false;
	public  boolean BFS = false;
	public  boolean NUMBER = false;
	public  boolean CONNECTED = false;
	public  boolean STRONGLYCONNECTED = false;
	public  boolean CYCLE = false;
	public  boolean MSTPRIM = false;
	public  boolean MSTKRUSKAL = false;
	public  boolean SHORTEST = false;
	
	private static SpecificationGPL SINGLETON;
    
	public static SpecificationGPL getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationGPL();
		}
		tool=t;
		return SINGLETON;
	}
	
	   
    
    
	public  boolean validProduct() {
		//productPrint();
		SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
		t.add(setBase());
		t.add(setDIRECTED());
		t.add(setUNDIRECTED());
		t.add(setWEIGHTED());
		t.add(setSEARCH());
		t.add(setBFS());
		t.add(setNUMBER());
		t.add(setCONNECTED());
		t.add(setSTRONGLYCONNECTED());		
		t.add(setCYCLE());
		t.add(setMSTPRIM());
		t.add(setMSTKRUSKAL());
	    t.add(setSHORTEST());
	      
	     return runTest( t, makeCnfFile ); 
	}
	
	

	public  String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public  String setDIRECTED() {
		return (DIRECTED) ? "DIRECTED___" : "-DIRECTED___";
	}
	
	public  String setUNDIRECTED() {
		return (UNDIRECTED) ? "UNDIRECTED___" : "-UNDIRECTED___";
	}
	
	public  String setWEIGHTED() {
		return (WEIGHTED) ? "WEIGHTED___" : "-WEIGHTED___";
	}
	public  String setSEARCH() {
		return (SEARCH) ? "SEARCH___" : "-SEARCH___";
	}
	public  String setBFS() {
		return (BFS) ? "BFS___" : "-BFS___";
	}
	public  String setNUMBER() {
		return (NUMBER) ? "NUMBER___" : "-NUMBER___";
	}
	public  String setCONNECTED() {
		return (CONNECTED) ? "CONNECTED___" : "-CONNECTED___";
	}
	public  String setCYCLE() {
		return (CYCLE) ? "CYCLE___" : "-CYCLE___";
	}

	public  String setMSTPRIM() {
		return (MSTPRIM) ? "MSTPRIM___" : "-MSTPRIM___";
	}
	
	public  String setMSTKRUSKAL() {
		return (MSTKRUSKAL) ? "MSTKRUSKAL___" : "-MSTKRUSKAL___";
	}
	
	public String setSHORTEST() {
		return (SHORTEST) ? "SHORTEST___" : "-SHORTEST___";
	}
	
	public  String setSTRONGLYCONNECTED() {
		return (STRONGLYCONNECTED) ? "STRONGLYCONNECTED___" : "-STRONGLYCONNECTED___";
	}
	
	public  void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		DIRECTED = Boolean.valueOf(args[index++]);
		UNDIRECTED = Boolean.valueOf(args[index++]);
		WEIGHTED  = Boolean.valueOf(args[index++]);
		SEARCH = Boolean.valueOf(args[index++]);
		BFS= Boolean.valueOf(args[index++]);
		NUMBER= Boolean.valueOf(args[index++]);
		CONNECTED= Boolean.valueOf(args[index++]);
		STRONGLYCONNECTED= Boolean.valueOf(args[index++]);
		CYCLE= Boolean.valueOf(args[index++]);
		MSTPRIM= Boolean.valueOf(args[index++]);
		MSTKRUSKAL= Boolean.valueOf(args[index++]);
		SHORTEST= Boolean.valueOf(args[index++]);
		
	}
	
//	public  void productPrint() {
//		System.out.println("\t base:" + ConfigurationGPL.base+ 
//		           "\t DIRECTED:  " + ConfigurationGPL.DIRECTED + 
//		           "\t UNDIRECTED: "+ConfigurationGPL.UNDIRECTED+ 
//		           "\t WEIGHTED:  "+ ConfigurationGPL.WEIGHTED+
//		           "\t SEARCH: "+ConfigurationGPL.SEARCH +
//		           "\t BFS: "+ConfigurationGPL.BFS+
//		           "\t NUMBER: "+ConfigurationGPL.NUMBER+
//		           "\t CONNECTED: "+ConfigurationGPL.CONNECTED+
//		           "\t STRONGLYCONNECTED: "+ConfigurationGPL.STRONGLYCONNECTED+
//		           "\t CYCLE: "+ConfigurationGPL.CYCLE+
//		           "\t MSTPRIM: "+ConfigurationGPL.MSTPRIM+
//		           "\t MSTKRUSKAL: "+ConfigurationGPL.MSTKRUSKAL+
//		           "\t SHORTEST: "+ConfigurationGPL.SHORTEST);
//        System.out.println();
//	}


	public boolean thereIsBase() {
    	return true;
    }


}
