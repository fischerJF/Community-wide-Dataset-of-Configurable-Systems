package SplatOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class ValidProduct {

	List<String> listaFim = new ArrayList<String>();
	public void leitor(String arquivo) {

		File dir = new File(arquivo);
		ReadFile l = new ReadFile(dir);
		List<String>  listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {
            
			splitLine(listas.get(i));
		    listaFim.add("\n\n");
			
		}	
		
		
	
	}
	
	public void parser() {
		for (int i = 0; i < listaFim.size(); i++) {
			if(listaFim.get(i).equals("!")) {
				System.out.print("-");
			}
			if(!listaFim.get(i).equals("?") && !listaFim.get(i).equals("!")) {
			if(listaFim.get(i).equals("	")) {
				System.out.println("  & ");
			}
				System.out.print(listaFim.get(i));
			}
			
		}
	}

	public void splitLine(String line) {
		
		String[] split = line.split("");

		if (split.length <= 0)
			return ;

		for (String string : split) {
			if (!string.isEmpty())
				
				listaFim.add(string);
		}

		
	}
	public static void main(String[] args) {
		System.err.println("inicio...");
		ValidProduct ler = new ValidProduct();

		ler.leitor("ValidProduct.txt");
		ler.parser();
		
		System.err.println("Fim");
		
	}
}
