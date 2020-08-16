package IncLingSpecification;


import IncLingSpecification.Specification;
import guidsl.Tool;

public class SpecificationNotepad  extends Specification{
	public static boolean BASE = true;
	public static boolean BASEMENUBAR = false;
	public static boolean BASETOOLBAR = false;
	public static boolean EDITMENUBAR = false;
	public static boolean EDITTOOLBAR = false;
	public static boolean FORMATMENUBAR = false;
	public static boolean FORMATTOOLBAR = false;
	public static boolean PERSISTENCEMENUBAR = false;
	public static boolean PERSISTENCETOOLBAR = false;
	public static boolean PRINTMENUBAR = false;
	public static boolean PRINTTOOLBAR = false;
	public static boolean SEARCHMENUBAR = false;
	public static boolean SEARCHTOOLBAR = false;
	public static boolean UNDOREDOMENUBAR = false;
	public static boolean UNDOREDOTOOLBAR = false;
	public static boolean WORDCOUNTMENUBAR = false;
	public static boolean WORDCOUNTTOOLBAR = false;
	
	private static SpecificationNotepad SINGLETON;
    
	public static SpecificationNotepad getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationNotepad();
		}
		tool=t;
		return SINGLETON;
	}
		
	public static String setBase() {
		return (BASE) ? "BASE___" : "-BASE___";
	}
	public static String setBASEMENUBAR() {
		return (BASEMENUBAR) ? "BASEMENUBAR___" : "-BASEMENUBAR___";
	}	
	public static String setBASETOOLBAR() {
		return (BASETOOLBAR) ? "BASETOOLBAR___" : "-BASETOOLBAR___";
	}
	
	public static String setEDITMENUBAR() {
		return (EDITMENUBAR) ? "EDITMENUBAR___" : "-EDITMENUBAR___";
	}
	public static String setEDITTOOLBAR() {
		return (EDITTOOLBAR) ? "EDITTOOLBAR___" : "-EDITTOOLBAR___";
	}
	public static String setFORMATMENUBAR() {
		return (FORMATMENUBAR) ? "FORMATMENUBAR___" : "-FORMATMENUBAR___";
	}
	public static String setFORMATTOOLBAR() {
		return (FORMATTOOLBAR) ? "FORMATTOOLBAR___" : "-FORMATTOOLBAR___";
	}
	public static String setPERSISTENCEMENUBAR() {
		return (PERSISTENCEMENUBAR) ? "PERSISTENCEMENUBAR___" : "-PERSISTENCEMENUBAR___";
	}
	public static String setPERSISTENCETOOLBAR() {
		return (PERSISTENCETOOLBAR) ? "PERSISTENCETOOLBAR___" : "-PERSISTENCETOOLBAR___";
	}
	public static String setPRINTMENUBAR() {
		return (PRINTMENUBAR) ? "PRINTMENUBAR___" : "-PRINTMENUBAR___";
	}
	public static String setPRINTTOOLBAR() {
		return (PRINTTOOLBAR) ? "PRINTTOOLBAR___" : "-PRINTTOOLBAR___";
	}
	public static String setSEARCHMENUBAR() {
		return (SEARCHMENUBAR) ? "SEARCHMENUBAR___" : "-SEARCHMENUBAR___";
	}
	public static String setSEARCHTOOLBAR() {
		return (SEARCHTOOLBAR) ? "SEARCHTOOLBAR___" : "-SEARCHTOOLBAR___";
	}		
	public static String setUNDOREDOMENUBAR() {
		return (UNDOREDOMENUBAR) ? "UNDOREDOMENUBAR___" : "-UNDOREDOMENUBAR___";
	}	
	public static String setUNDOREDOTOOLBAR() {
		return (UNDOREDOTOOLBAR) ? "UNDOREDOTOOLBAR___" : "-UNDOREDOTOOLBAR___";
	}	
	public static String setWORDCOUNTMENUBAR() {
		return (WORDCOUNTMENUBAR) ? "WORDCOUNTMENUBAR___" : "-WORDCOUNTMENUBAR___";
	}	
	public static String setWORDCOUNTTOOLBAR() {
		return (WORDCOUNTTOOLBAR) ? "WORDCOUNTTOOLBAR___" : "-WORDCOUNTTOOLBAR___";
	}
	
	
	public static void init(String... args) {
		int index = 0;
		BASE = Boolean.valueOf(args[index++]);
		BASETOOLBAR = Boolean.valueOf(args[index++]);
		EDITMENUBAR = Boolean.valueOf(args[index++]);
		EDITTOOLBAR = Boolean.valueOf(args[index++]);
		FORMATMENUBAR = Boolean.valueOf(args[index++]);
		FORMATTOOLBAR = Boolean.valueOf(args[index++]);
		PERSISTENCEMENUBAR = Boolean.valueOf(args[index++]);
		PERSISTENCETOOLBAR = Boolean.valueOf(args[index++]);
		PRINTMENUBAR = Boolean.valueOf(args[index++]);
		PRINTTOOLBAR = Boolean.valueOf(args[index++]);
		SEARCHMENUBAR = Boolean.valueOf(args[index++]);
		SEARCHTOOLBAR = Boolean.valueOf(args[index++]);
		UNDOREDOMENUBAR = Boolean.valueOf(args[index++]);
		UNDOREDOTOOLBAR = Boolean.valueOf(args[index++]);
		WORDCOUNTMENUBAR = Boolean.valueOf(args[index++]);
		WORDCOUNTTOOLBAR = Boolean.valueOf(args[index++]);

	}
	
	public boolean thereIsBase() {
    	return true;
    }


}
