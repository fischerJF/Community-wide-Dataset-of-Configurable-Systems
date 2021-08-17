package VerificarAssert;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


import SplatOutput.ReadFile;

public class Baseline {

	
	
	public ArrayList leitor(String arquivo) {

		File dir = new File(arquivo);
		ArrayList aux= new ArrayList<>();
		
		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();

		for (int i = 0; i < listas.size(); i++) {

			if (listas.get(i).contains("assert") &&
					!listas.get(i).contains("import") &&
					!listas.get(i).contains("//")) {
  				aux.add(i+1);
			}
			
		}
       return aux;
	}

	public static void main(String[] args) {
		System.out.println("Inicio...\n");
		Baseline ler = new Baseline();
		
		ArrayList baseline= new ArrayList<>();
		ArrayList splat= new ArrayList<>();
		ArrayList varexj= new ArrayList<>();
		
		baseline=ler.leitor("src/VerificarAssert/baseline.txt");
		splat=ler.leitor("src/VerificarAssert/splat.txt");
		varexj=ler.leitor("src/VerificarAssert/varexj.txt");
		
		try {
	       System.out.println("\n\nbaseline - "+"splat - "+"varexj -" );
		for (int i = 0; i < baseline.size()+1; i++) {
           System.out.print(baseline.get(i) +"\t"+splat.get(i)+"\t"+varexj.get(i) );			
    	   System.out.println();
		}
		}catch(Exception e) {
			
		}
		
		System.out.println("\nFim.");
	}
}
