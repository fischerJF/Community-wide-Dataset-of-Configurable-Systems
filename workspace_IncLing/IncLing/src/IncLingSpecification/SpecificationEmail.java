package IncLingSpecification;

import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationEmail  extends Specification{
	public static boolean base = true;
	public static boolean KEYS = true;
	public static boolean ENCRYPT = false;
	public static boolean AUTORESPONDER = false;
	public static boolean ADDRESSBOOK = false;
	public static boolean SIGN = false;
	public static boolean FORWARD = false;
	public static boolean VERIFY = false;
	public static boolean DECRYPT = false;
	
	private static SpecificationEmail SINGLETON;
    
	public static SpecificationEmail getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationEmail();
		}
		tool=t;
		return SINGLETON;
	}
	
	   
    
    
	public static String setBase() {
		return (base) ? "BASE___" : "-BASE___";
	}
	public static String setKEYS() {
		return (KEYS) ? "KEYS___" : "-KEYS___";
	}	
	public static String setENCRYPT() {
		return (ENCRYPT) ? "ENCRYPT___" : "-ENCRYPT___";
	}	
	public static String setAUTORESPONDER() {
		return (AUTORESPONDER) ? "AUTORESPONDER___" : "-AUTORESPONDER___";
	}
	public static String setADDRESSBOOK() {
		return (ADDRESSBOOK) ? "ADDRESSBOOK___" : "-ADDRESSBOOK___";
	}
	public static String setSIGN() {
		return (SIGN) ? "SIGN___" : "-SIGN___";
	}
	public static String setFORWARD() {
		return (FORWARD) ? "FORWARD___" : "-FORWARD___";
	}
	public static String setVERIFY() {
		return (VERIFY) ? "VERIFY___" : "-VERIFY___";
	}
	public static String setDECRYPT() {
		return (DECRYPT) ? "DECRYPT___" : "-DECRYPT___";
	}
	
	public static void init(String... args) {
		int index = 0;
		base = Boolean.valueOf(args[index++]);		
		KEYS  = Boolean.valueOf(args[index++]);
		ENCRYPT = Boolean.valueOf(args[index++]);
		AUTORESPONDER = Boolean.valueOf(args[index++]);
		ADDRESSBOOK = Boolean.valueOf(args[index++]);
		SIGN = Boolean.valueOf(args[index++]);
		FORWARD = Boolean.valueOf(args[index++]);
		VERIFY  = Boolean.valueOf(args[index++]);
		DECRYPT  = Boolean.valueOf(args[index++]);
		
	}
	

	public boolean thereIsBase() {
    	return true;
    }


}
