package util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {
	
	/**
	 * Lists the files in a given directory
	 */
	public static List<String> listFilesDir(String folderPath, List<String> files) {
		File root = new File(folderPath);
		File[] list = root.listFiles();

		if (list == null)
			return files;

		for (File f : list) {
			if (f.isDirectory()) {
				listFilesDir(f.getAbsolutePath(), files);
				// System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				if(f.getName().contains(".class"))
					files.add(folderPath + "/" + f.getName());
				// System.out.println( "File:" + f.getAbsoluteFile() );
			}
		}
		return files;
	}
	
//	public static List<String> listFilesDir(File folderPath) {
//		List<String> files = new ArrayList<String>();
//		for (File fileEntry : folderPath.listFiles()) {
//			if (fileEntry.isDirectory()) {
//				listFilesDir(fileEntry);
//			} else {
//				files.add(folderPath + "/" + fileEntry.getName());
//			}
//		}
//		return files;
//	}
	
	/**
	 * Read all the lines from a file
	 * 
	 * @return A list of all the lines of the file
	 */
	public static List<String> readLinesFrom(String fileName) {
		List<String> lines = new LinkedList<String>();
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(fileName));
			String line = in.readLine();
			while (line != null) {
				lines.add(line);
				line = in.readLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lines;
	}

	/**
	 * Persist lines/data in a given directory
	 */
	public static void save(StringBuffer lines, String dirPath) {
		try {
			FileWriter file = new FileWriter(dirPath);
			BufferedWriter writer = new BufferedWriter(file);
			writer.write(lines.toString());
			writer.flush();
			writer.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("Error on file creation!");

		}
	}

	/**
	 * Persist lines/data in a given directory
	 */
	public static void save(Collection<String> lines, String dirPath) {
		try {
			FileWriter file = new FileWriter(dirPath);
			BufferedWriter writer = new BufferedWriter(file);
			for (String line : lines) {
				writer.write(line + "\n");
			}
			writer.flush();
			writer.close();
			writer.close();

		} catch (Exception e) {
			System.out.println("Error on file creation!");

		}
	}


}
