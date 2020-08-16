package specifications;

import guidsl.SATtest;
import guidsl.Tool;
import specifications.Configuration;

public class Configuration {

	public static boolean base = true;
	public static boolean DIRECTED = true;
	public static boolean UNDIRECTED = false;
	public static boolean WEIGHTED = false;
	public static boolean SEARCH = false;
	public static boolean BFS = false;
	public static boolean NUMBER = false;
	public static boolean CONNECTED = false;
	public static boolean STRONGLYCONNECTED = false;
	public static boolean CYCLE = false;
	public static boolean MSTPRIM = false;
	public static boolean MSTKRUSKAL = false;
	public static boolean SHORTEST = false;
	
	public static Tool tool = new Tool( "modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

	public static boolean validProduct() {
		
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
	
	public static boolean runTest( SATtest t, boolean compat ) {
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}

	public static String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public static String setDIRECTED() {
		return (DIRECTED) ? "DIRECTED___" : "-DIRECTED___";
	}
	
	public static String setUNDIRECTED() {
		return (UNDIRECTED) ? "UNDIRECTED___" : "-UNDIRECTED___";
	}
	
	public static String setWEIGHTED() {
		return (WEIGHTED) ? "WEIGHTED___" : "-WEIGHTED___";
	}
	public static String setSEARCH() {
		return (SEARCH) ? "SEARCH___" : "-SEARCH___";
	}
	public static String setBFS() {
		return (BFS) ? "BFS___" : "-BFS___";
	}
	public static String setNUMBER() {
		return (NUMBER) ? "NUMBER___" : "-NUMBER___";
	}
	public static String setCONNECTED() {
		return (CONNECTED) ? "CONNECTED___" : "-CONNECTED___";
	}
	public static String setCYCLE() {
		return (CYCLE) ? "CYCLE___" : "-CYCLE___";
	}

	public static String setMSTPRIM() {
		return (MSTPRIM) ? "MSTPRIM___" : "-MSTPRIM___";
	}
	
	public static String setMSTKRUSKAL() {
		return (MSTKRUSKAL) ? "MSTKRUSKAL___" : "-MSTKRUSKAL___";
	}
	
	public static String setSHORTEST() {
		return (SHORTEST) ? "SHORTEST___" : "-SHORTEST___";
	}
	
	public static String setSTRONGLYCONNECTED() {
		return (STRONGLYCONNECTED) ? "STRONGLYCONNECTED___" : "-STRONGLYCONNECTED___";
	}
	
	public static void init(String... args) {
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
	
	public static void productPrint() {
		System.out.println( 
				" WEIGHTED:"+ Configuration.WEIGHTED+
				" UNDIRECTED:"+Configuration.UNDIRECTED+ 
				" STRONGLYCONNECTED:"+Configuration.STRONGLYCONNECTED+
				" SHORTEST:"+Configuration.SHORTEST+
				" SEARCH:"+Configuration.SEARCH +
				" NUMBER:"+Configuration.NUMBER+
				" MSTPRIM:"+Configuration.MSTPRIM+
				" MSTKRUSKAL:"+Configuration.MSTKRUSKAL+
				" DIRECTED:" + Configuration.DIRECTED +
				" CYCLE:"+Configuration.CYCLE+
				" CONNECTED:"+Configuration.CONNECTED+
				" BFS:"+Configuration.BFS+
				" BASE:"+Configuration.base
				);
	}
	public static String returnProduct() {
		return 
				   " WEIGHTED:"+ Configuration.WEIGHTED+
				   " UNDIRECTED:"+Configuration.UNDIRECTED+ 
		           " STRONGLYCONNECTED:"+Configuration.STRONGLYCONNECTED+
				   " SHORTEST:"+Configuration.SHORTEST+
		           " SEARCH:"+Configuration.SEARCH +
				   " NUMBER:"+Configuration.NUMBER+
		           " MSTPRIM:"+Configuration.MSTPRIM+
				   " MSTKRUSKAL:"+Configuration.MSTKRUSKAL+
		           " DIRECTED:" + Configuration.DIRECTED +
		           " CYCLE:"+Configuration.CYCLE+
		           " CONNECTED:"+Configuration.CONNECTED+
		           " BFS:"+Configuration.BFS+
		           " BASE:"+Configuration.base
		        ;
   }
	
}