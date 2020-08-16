package telecom;


import java.util.Vector;

public class Historic {
	
	private static Vector<String> records = new Vector<String>();
	
	public static void addRecords(String text) {
		records.add(text);
	}
	
	
	public static String returnRecords() {
		String aux="";
		for (int i=0; i<records.size(); i++) 
			aux+="\n"+records.get(i);
		return aux;
	}
	public static void resetRecords() {
		records.clear();
	}

}
