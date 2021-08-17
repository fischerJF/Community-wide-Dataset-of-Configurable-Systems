package BaselineOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class Baseline {

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
        String conf="";
		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains("Configuration:") /*&& listas.get(i).contains("1 Index: 1, Tab count: 1:")*/) {
				System.out.print(listas.get(i));
				conf=listas.get(i);
			}
			if (listas.get(i).contains("at featureAMP.")  /*|| listas.get(i).contains("at tests")*/) {
				System.out.print(conf  );
				System.out.println("  " + listas.get(i));
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...\n");
		Baseline ler = new Baseline();
          ler.leitor("src/BaselineOutput/BaselineOutput.txt");
		System.out.println("\nFim.");
	}
}
