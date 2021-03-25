package IncLingSpecification;

import java.util.ArrayList;

import IncLing.Combination;
import IncLing.FeatureIncling;
import guidsl.SATtest;
import guidsl.Tool;

public abstract class Specification {
	
	public static  Tool tool;
	public static  boolean makeCnfFile = true;
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
    public static boolean validArrayCombination(ArrayList<Combination> combination) {
    	SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
     for (Combination comb : combination) {
    	for (FeatureIncling f  : comb.getListFeatures()) {
    		t.add(f.getNameForGuidsl());
		}
     }    	
	     return  runTest( t, makeCnfFile );    
    }
    public static boolean runTest( SATtest t, boolean compat ) {
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}
    public abstract boolean thereIsBase();
}