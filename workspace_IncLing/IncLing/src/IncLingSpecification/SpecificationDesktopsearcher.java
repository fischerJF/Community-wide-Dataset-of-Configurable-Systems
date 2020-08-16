package IncLingSpecification;


import IncLingSpecification.Specification;
import guidsl.Tool;


public class SpecificationDesktopsearcher  extends Specification{
	public static boolean BASE = true;
	public static boolean HTML = false;
	public static boolean TXT = false;
	public static boolean LATEX = false;
	public static boolean USER_INTERFACE = false;
	public static boolean COMMAND_LINE = false;
	public static boolean GUI = false;
	public static boolean GUI_PREFERENCES = false;
	public static boolean QUERY_HISTORY = false;
	public static boolean INDEX_HISTORY = false;
	public static boolean SINGLE_DIRECTORY = false;
	public static boolean MULTI_DIRECTORY = false;
	public static boolean NORMAL_VIEW = false;
	public static boolean TREE_VIEW = false;
	public static boolean WINDOWS = false;
	public static boolean LINUX = false;
	
	
	private static SpecificationDesktopsearcher SINGLETON;
    
	public static SpecificationDesktopsearcher getSINGLETON(Tool t) {
		if (SINGLETON == null) {
			SINGLETON = new SpecificationDesktopsearcher();
		}
		tool=t;
		return SINGLETON;
	}
	
	public static String setBase() {
		return (BASE) ? "BASE" : "-BASE";
	}
	public static String setHTML() {
		return (HTML) ? "HTML" : "-HTML";
	}
	
	public static String setTXT() {
		return (TXT) ? "TXT" : "-TXT";
	}
	
	public static String setLATEX() {
		return (LATEX) ? "LATEX" : "-LATEX";
	}
	public static String setUSER_INTERFACE() {
		return (USER_INTERFACE) ? "USER_INTERFACE" : "-USER_INTERFACE";
	}
	public static String setCOMMAND_LINE() {
		return (COMMAND_LINE) ? "COMMAND_LINE" : "-COMMAND_LINE";
	}
	public static String setGUI() {
		return (GUI) ? "GUI" : "-GUI";
	}
	public static String setGUI_PREFERENCES() {
		return (GUI_PREFERENCES) ? "GUI_PREFERENCES" : "-GUI_PREFERENCES";
	}
	public static String setQUERY_HISTORY() {
		return (QUERY_HISTORY) ? "QUERY_HISTORY" : "-QUERY_HISTORY";
	}
	public static String setINDEX_HISTORY() {
		return (INDEX_HISTORY) ? "INDEX_HISTORY" : "-INDEX_HISTORY";
	}
	public static String setSINGLE_DIRECTORY() {
		return (SINGLE_DIRECTORY) ? "SINGLE_DIRECTORY" : "-SINGLE_DIRECTORY";
	}
	public static String setMULTI_DIRECTORY() {
		return (MULTI_DIRECTORY) ? "MULTI_DIRECTORY" : "-MULTI_DIRECTORY";
	}
	public static String setNORMAL_VIEW() {
		return (NORMAL_VIEW) ? "NORMAL_VIEW" : "-NORMAL_VIEW";
	}
	public static String setTREE_VIEW() {
		return (TREE_VIEW) ? "TREE_VIEW" : "-TREE_VIEW";
	}
	public static String setWINDOWS() {
		return (WINDOWS) ? "WINDOWS" : "-WINDOWS";
	}
	public static String setLINUX() {
		return (LINUX) ? "LINUX" : "-LINUX";
	}
	
		

	public static void init(String... args) {
		int index = 0;
		BASE = Boolean.valueOf(args[index++]);
		HTML = Boolean.valueOf(args[index++]);
		TXT = Boolean.valueOf(args[index++]);
		LATEX = Boolean.valueOf(args[index++]);
		USER_INTERFACE = Boolean.valueOf(args[index++]);
		COMMAND_LINE = Boolean.valueOf(args[index++]);
		GUI = Boolean.valueOf(args[index++]);
		GUI_PREFERENCES = Boolean.valueOf(args[index++]);		
		QUERY_HISTORY = Boolean.valueOf(args[index++]);		
		INDEX_HISTORY = Boolean.valueOf(args[index++]);		
		SINGLE_DIRECTORY = Boolean.valueOf(args[index++]);		
		MULTI_DIRECTORY = Boolean.valueOf(args[index++]);		
		NORMAL_VIEW = Boolean.valueOf(args[index++]);		
		TREE_VIEW = Boolean.valueOf(args[index++]);		
		WINDOWS = Boolean.valueOf(args[index++]);		
		LINUX = Boolean.valueOf(args[index++]);		

	}

	public boolean thereIsBase() {
    	return true;
    }
}
