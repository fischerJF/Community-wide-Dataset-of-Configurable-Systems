package SplatOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class Main {
	
	public String saida="";

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains(",F")) {
//				System.out.print(listas.get(i));
				saida+=listas.get(i);
			}
			
			if (listas.get(i).contains("at tests.")) {
				
//				System.out.println("  " + listas.get(i));
				saida+=listas.get(i);
				saida+="\n";
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...");
		Main arquivo = new Main();

		arquivo.leitor("src/SplatOutput/SPlaOutput.txt");
		
		EscreverArquivo escrever= new EscreverArquivo("src/SplatOutput/FeatureSplatOutput.txt");
		escrever.escrever(arquivo.saida);
		
		FeatureSplatOutput feature = new FeatureSplatOutput();
		feature.inicialization(TargetSystem.SUDOKU);

		feature.leitor("src/SplatOutput/FeatureSplatOutput.txt");

		feature.featureReplacement();
		System.out.println("Fim");
		
	}
}
