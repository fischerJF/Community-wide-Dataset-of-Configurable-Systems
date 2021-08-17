package SplatOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class MainPairWiseSaida {
	
	public String saida="";

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains(",F")||listas.get(i).contains(",P")) {
				System.out.println(listas.get(i));
				saida+=listas.get(i);
			}
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...");
		MainPairWiseSaida arquivo = new MainPairWiseSaida();

		arquivo.leitor("src/SplatOutput/SPlaOutput.txt");
		
		
	}
}
