package atm;

import java.util.Vector;

public class Logger {
	
	private static Vector<String> logs = new Vector<String>();
	
	public static void log(String text) {
		logs.add(text);
	}
	
	public static void printLog(Screen screen) {
		for (int i=0; i<logs.size(); i++) 
			screen.displayMessageLine(logs.get(i) );
	}
	
	public static String returnLogs() {
		String aux="";
		for (int i=0; i<logs.size(); i++) 
			aux+="\n"+logs.get(i);
		return aux;
	}
	public static void resetLog() {
		logs.clear();
	}

}
