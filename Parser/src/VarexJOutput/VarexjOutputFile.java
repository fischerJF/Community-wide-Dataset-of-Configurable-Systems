package VarexJOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class VarexjOutputFile {

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains("if ") && !listas.get(i).contains("Caused by: if")) {
				System.out.print(listas.get(i));
			}
			if (listas.get(i).contains("	at tests.") && !listas.get(i).contains("TestSuiteForVarexJReflect.") ) {
				System.out.println("  " + listas.get(i));
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...\n");
		VarexjOutputFile ler = new VarexjOutputFile();

		ler.leitor("src/VarexJOutput/IncLingOutput.txt");
		System.out.println("\nFim.");
	}
}
