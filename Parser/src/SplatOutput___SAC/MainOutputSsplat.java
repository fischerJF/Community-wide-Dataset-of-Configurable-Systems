package SplatOutput___SAC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class MainOutputSsplat {
	
	public String saida="";

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains(",F") || listas.get(i).contains(",P")) {
				saida+=listas.get(i);
				saida+="\n";
			}
			
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...");
		MainOutputSsplat arquivo = new MainOutputSsplat();

		arquivo.leitor("src/SplatOutput___SAC/SPlaOutput.txt");
//		System.err.println("saida"+ arquivo.saida);
		
		EscreverArquivo escrever= new EscreverArquivo("src/SplatOutput___SAC/FeatureSplatOutput.txt");
		escrever.escrever(arquivo.saida);
		
		FeatureSplatOutput feature = new FeatureSplatOutput();
		feature.inicialization(TargetSystem.EMAIL);

		feature.leitor("src/SplatOutput___SAC/FeatureSplatOutput.txt");
    	feature.featureReplacement();
		System.out.println("Fim");
		
	}
}
