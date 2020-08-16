package IncLingSpecification;


import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationElevator  extends Specification{
	public  boolean base = true;
	public  boolean weight = false;
	public  boolean empty = false;
	public  boolean twothirdsfull = false;
	public  boolean executivefloor = false;
	public  boolean overloaded = false;
	
	
	private static SpecificationElevator SINGLETON;
    
	public static SpecificationElevator getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationElevator();
		}
		tool=t;
		return SINGLETON;
	}
	

	public  String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public  String setWEIGHT() {
		return (weight) ? "WEIGHT___" : "-WEIGHT___";
	}
	
	public  String setEMPTY() {
		return (empty) ? "EMPTY___" : "-EMPTY___";
	}
	
	public  String setTWOTHIRDSFULL() {
		return (twothirdsfull) ? "TWOTHIRDSFULL___" : "-TWOTHIRDSFULL___";
	}
	public  String setEXECUTIVEFLOOR() {
		return (executivefloor) ? "EXECUTIVEFLOOR___" : "-EXECUTIVEFLOOR___";
	}
	public  String setOVERLOADED() {
		return (overloaded) ? "OVERLOADED___" : "-OVERLOADED___";
	}
		
	public  void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		weight = Boolean.valueOf(args[index++]);
		empty = Boolean.valueOf(args[index++]);
		twothirdsfull = Boolean.valueOf(args[index++]);
		executivefloor = Boolean.valueOf(args[index++]);
		overloaded = Boolean.valueOf(args[index++]);
		
	}
	
	public boolean thereIsBase() {
    	return true;
    }

	


}
