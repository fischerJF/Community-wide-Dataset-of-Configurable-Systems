package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Serialize list of string.
 * @author sabrinasouto
 */
public class Serializer {
	
	public static void main(String[] args) throws ClassNotFoundException, IOException{
		List<String> instrFunctions = (List<String>)deserialize("/Users/sabrinasouto/workspace/evo-splat/splatgcc/firstRun/instrFunctions.txt");
		int counter = 0;
		for (String ifunc : instrFunctions) {
			System.out.println(counter++  + ": " + ifunc);
		}
	}

	public static void serialize(String path, Object obj) throws IOException {
		FileOutputStream fileOut = new FileOutputStream(path);
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		out.writeObject(obj);
		out.close();
		fileOut.close();
	}
	
	public static Object deserialize(String path) throws IOException, ClassNotFoundException {
		Object obj = null;
		FileInputStream fileIn = new FileInputStream(path);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        obj = in.readObject();
        in.close();
        fileIn.close();
		return obj;
	}

}
