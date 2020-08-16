package specifications;

import guidsl.SATtest;
import guidsl.Tool;

public class Configuration {

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
	
	public static Tool tool = new Tool( "modified-model.m" );
	public static boolean makeCnfFile = true;
    public static boolean compatSelections = true;

    
	public static boolean validProduct() {
		
		SATtest t = new SATtest( "test1", compatSelections, compatSelections ); 
		t.add(setBase());
		t.add(setHTML());
		t.add(setTXT());
		t.add(setLATEX());
		t.add(setUSER_INTERFACE());
		t.add(setCOMMAND_LINE());
		t.add(setGUI());
		t.add(setGUI_PREFERENCES() );
		t.add(setQUERY_HISTORY());
		t.add(setMULTI_DIRECTORY());
		t.add(setINDEX_HISTORY());
		t.add(setSINGLE_DIRECTORY());
		t.add(setNORMAL_VIEW());
		t.add(setTREE_VIEW());
		t.add(setWINDOWS());
	    t.add(setLINUX());
	      
	     return runTest( t, makeCnfFile ); 
	}
	
	public static boolean runTest( SATtest t, boolean compat ) {
		return (tool.modelDebug(t, makeCnfFile ))? true: false;
	}

	public static String setBase() {
		return (BASE) ? "BASE___" : "-BASE___";
	}
	public static String setHTML() {
		return (HTML) ? "HTML___" : "-HTML___";
	}
	
	public static String setTXT() {
		return (TXT) ? "TXT___" : "-TXT___";
	}
	
	public static String setLATEX() {
		return (LATEX) ? "LATEX___" : "-LATEX___";
	}
	public static String setUSER_INTERFACE() {
		return (USER_INTERFACE) ? "USER_INTERFACE___" : "-USER_INTERFACE___";
	}
	public static String setCOMMAND_LINE() {
		return (COMMAND_LINE) ? "COMMAND_LINE___" : "-COMMAND_LINE___";
	}
	public static String setGUI() {
		return (GUI) ? "GUI___" : "-GUI___";
	}
	public static String setGUI_PREFERENCES() {
		return (GUI_PREFERENCES) ? "GUI_PREFERENCES___" : "-GUI_PREFERENCES___";
	}
	public static String setQUERY_HISTORY() {
		return (QUERY_HISTORY) ? "QUERY_HISTORY___" : "-QUERY_HISTORY___";
	}
	public static String setINDEX_HISTORY() {
		return (INDEX_HISTORY) ? "INDEX_HISTORY___" : "-INDEX_HISTORY___";
	}
	public static String setSINGLE_DIRECTORY() {
		return (SINGLE_DIRECTORY) ? "SINGLE_DIRECTORY___" : "-SINGLE_DIRECTORY___";
	}
	public static String setMULTI_DIRECTORY() {
		return (MULTI_DIRECTORY) ? "MULTI_DIRECTORY___" : "-MULTI_DIRECTORY___";
	}
	public static String setNORMAL_VIEW() {
		return (NORMAL_VIEW) ? "NORMAL_VIEW___" : "-NORMAL_VIEW___";
	}
	public static String setTREE_VIEW() {
		return (TREE_VIEW) ? "TREE_VIEW___" : "-TREE_VIEW___";
	}
	public static String setWINDOWS() {
		return (WINDOWS) ? "WINDOWS___" : "-WINDOWS___";
	}
	public static String setLINUX() {
		return (LINUX) ? "LINUX___" : "-LINUX___";
	}
	
		
	public static void productPrint() {
		System.out.println(
				   "WINDOWS:"+Configuration.WINDOWS+
		           " USER_INTERFACE:"+ Configuration.USER_INTERFACE+	        
		           " TXT:" + Configuration.TXT + 
		  		   " TREE_VIEW:"+Configuration.TREE_VIEW+
		           " SINGLE_DIRECTORY:"+Configuration.SINGLE_DIRECTORY +
		  		   " QUERY_HISTORY:"+Configuration.QUERY_HISTORY +
		  		   " NORMAL_VIEW:"+Configuration.NORMAL_VIEW +
		           " MULTI_DIRECTORY:"+Configuration.MULTI_DIRECTORY +
		           " LINUX:"+Configuration.LINUX+
		           " LATEX:"+Configuration.LATEX+ 
		   		   " INDEX_HISTORY:"+Configuration.INDEX_HISTORY +
		           " HTML:" + Configuration.HTML+ 
		           " GUI_PREFERENCES:"+Configuration.GUI_PREFERENCES+
		           " GUI:"+Configuration.GUI+
		           " COMMAND_LINE:"+Configuration.COMMAND_LINE +
		           " BASE:"+Configuration.BASE 
		           );
//        System.out.println();
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

	public static String returnProduct() {
		return "WINDOWS:"+Configuration.WINDOWS+
		           " USER_INTERFACE:"+ Configuration.USER_INTERFACE+	        
		           " TXT:" + Configuration.TXT + 
		  		   " TREE_VIEW:"+Configuration.TREE_VIEW+
		           " SINGLE_DIRECTORY:"+Configuration.SINGLE_DIRECTORY +
		  		   " QUERY_HISTORY:"+Configuration.QUERY_HISTORY +
		  		   " NORMAL_VIEW:"+Configuration.NORMAL_VIEW +
		           " MULTI_DIRECTORY:"+Configuration.MULTI_DIRECTORY +
		           " LINUX:"+Configuration.LINUX+
		           " LATEX:"+Configuration.LATEX+ 
		   		   " INDEX_HISTORY:"+Configuration.INDEX_HISTORY +
		           " HTML:" + Configuration.HTML+ 
		           " GUI_PREFERENCES:"+Configuration.GUI_PREFERENCES+
		           " GUI:"+Configuration.GUI+
		           " COMMAND_LINE:"+Configuration.COMMAND_LINE +
		           " BASE:"+Configuration.BASE ;
	}

}