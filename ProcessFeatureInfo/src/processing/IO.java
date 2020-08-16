package processing;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ast.CompilationUnit;

public class IO {

	public static CompilationUnit getCompilationUnitFromFile(File inputFile) {
		
        CompilationUnit c = null;
		try {
			c = JavaParser.parse(inputFile);
			return c;
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		return null;
	}

	/**
	 * recursive
	 * @param rootPath to a package o directory
	 * @return all .java files inside directory of path, except package-info.java
	 */
	public static List<File> allJavaFilesIn(String rootPath) {

		File directory = new File(rootPath);
		
		List<File> allJavaFiles = new ArrayList<>();
		System.out.println(rootPath);
		
		for (File path : directory.listFiles()) {
			if (path.isFile() && path.getName().endsWith(".java")
					&& !path.getName().endsWith("Test.java")) { // VendingMachine
				allJavaFiles.add(path);
			}
			else if (path.isDirectory()
					&& !path.getName().equalsIgnoreCase("experiment")
					&& !path.getName().equalsIgnoreCase("specifications")) {
				allJavaFiles.addAll(allJavaFilesIn(path.getPath()));
			}
		}
		
		return allJavaFiles;
	}
	
	/*
	 * just prints in console
	 * TODO export to a .csv file
	 */
	public static void generateSpreadsheet(Map<String, FeatureEntry> allInfo) {
		String head = "System,Feature,Classes,Constructors,Methods,Blocks,LOCs,Occurrences,Other Features";
		System.out.println(head);
		
		for (String key : allInfo.keySet()) {
			System.out.println(allInfo.get(key));
		}
	}
}
