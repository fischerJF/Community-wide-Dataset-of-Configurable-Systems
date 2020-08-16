package trie;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class PersistTrie {

	private static String getDataDir() throws IOException {
		String homeDir = (new File(".")).getCanonicalPath();
		int i = homeDir.indexOf("src-subjects");
		String hd = homeDir.substring(0, i);
		return hd;
	}

	private static void write(String sufix, TrieST st) {
		long ti = System.currentTimeMillis();
		try {
			String path = getDataDir() + "data/" + sufix;
			FileOutputStream fout = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(st);
			oos.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("WRITE: " + (System.currentTimeMillis() - ti));
	}
	
	public static void cleanTries(String subjectName){
		String path;
		try {
			File f = new File(getDataDir() + "data/" + subjectName + ".ser");
			f.delete();
//			File fSAT = new File(getDataDir() + "data/" + subjectName + "SAT.ser");
//			fSAT.delete();
//			File fUNSAT = new File(getDataDir() + "data/" + subjectName + "UNSAT.ser");
//			fUNSAT.delete();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void writeTrie(String subjectName, TrieST st)
			throws IOException {
		write(subjectName + ".ser", st);
	}

	public static void writeSAT(String subjectName, TrieST st)
			throws IOException {
		write(subjectName + "SAT.ser", st);
	}

	public static void writeUNSAT(String subjectName, TrieST st)
			throws IOException {
		write(subjectName + "UNSAT.ser", st);
	}

	private static TrieST load(String sufix) {
		long ti = System.currentTimeMillis();
		TrieST st = null;
		try {
			String path = getDataDir() + "data/" + sufix;
			File f = new File(path);
			if(f.exists()){
				FileInputStream fin = new FileInputStream(path);
				ObjectInputStream ois = new ObjectInputStream(fin);
				st = (TrieST) ois.readObject();
				ois.close();
			} else {
				st = new TrieST<Boolean>();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("LOAD: " + (System.currentTimeMillis() - ti));
		return st;
	}
	
	public static TrieST loadTrie(String subjectName) {
		return load(subjectName + ".ser");
	}

	public static TrieST loadSAT(String subjectName) {
		return load(subjectName + "SAT.ser");
	}

	public static TrieST loadUNSAT(String subjectName) {
		return load(subjectName + "UNSAT.ser");
	}

}
