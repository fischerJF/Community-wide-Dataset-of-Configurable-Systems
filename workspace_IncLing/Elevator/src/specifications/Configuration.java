package specifications;

import java.util.ArrayList;

import IncLing.Combination;
import IncLing.FeatureIncling;
import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

	public static boolean base = true;
	public static boolean weight = false;
	public static boolean empty = false;
	public static boolean twothirdsfull = false;
	public static boolean executivefloor = false;
	public static boolean overloaded = false;

	public static Tool tool = new Tool( "modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    public static boolean validPar(String feature1, String feature2) {
    	SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
    	t.add(feature1);
	    t.add(feature2);
	     return  runTest( t, makeCnfFile );    
    }
    
    public static boolean validCombination(Combination combination) {
    	SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
    	for (FeatureIncling f  : combination.getListFeatures()) {
    		t.add(f.getNameForGuidsl());
    	}
    	
    	return  runTest( t, makeCnfFile );    
    }
    public static boolean runTest( SATtest t, boolean compat ) {
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}
    
    public static boolean validArrayCombination(ArrayList<Combination> combination) {
    	SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
     for (Combination comb : combination) {
    	for (FeatureIncling f  : comb.getListFeatures()) {
    		t.add(f.getNameForGuidsl());
		}
     }    	
	     return  runTest( t, makeCnfFile );    
    }
	public static boolean validProduct() {
	
		return (!overloaded || weight) && (!twothirdsfull || weight) && base;
		            
	}

	public static String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public static String setDIRECTED() {
		return (weight) ? "WEIGHT___" : "-WEIGHT___";
	}
	public static String setEMPTY() {
		return (empty) ? "EMPTY___" : "-EMPTY___";
	}
	public static String setTWOTHIRDSFULL() {
		return (twothirdsfull) ? "TWOTHIRDSFULL___" : "-TWOTHIRDSFULL___";
	}
	public static String setEXECUTIVEFLOOR() {
		return (executivefloor) ? "EXECUTIVEFLOOR___" : "-EXECUTIVEFLOOR___";
	}
	public static String setOVERLOADED() {
		return (overloaded) ? "OVERLOADED___" : "-OVERLOADED___";
	}
	
	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		weight = Boolean.valueOf(args[index++]);
		empty = Boolean.valueOf(args[index++]);
		twothirdsfull = Boolean.valueOf(args[index++]);
		executivefloor = Boolean.valueOf(args[index++]);
		overloaded = Boolean.valueOf(args[index++]);
		
	}
	public static void printProduct() {
		System.out.println("conf: weight:" + weight+ 
				" twothirdsfull:"+twothirdsfull+ 
				" overloaded:"+overloaded +  
				" executivefloor:"+ executivefloor+
				" empty:" + empty + 
				" base:" + base
				) ;
	}
	public static String  returnProduct() {
		return " weight:" + weight+ 
		       " twothirdsfull:"+twothirdsfull+ 
		       " overloaded:"+overloaded +  
		       " executivefloor:"+ executivefloor+
		       " empty:" + empty + 
		       " base:" + base;
	}
	
	public static void main(String[] args) {
		Configuration.base=true;
		Configuration.weight=false;
		Configuration.overloaded=false;
		Configuration.weight=false;
		
		System.out.println(validProduct());
	}

}