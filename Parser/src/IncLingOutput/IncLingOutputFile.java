package IncLingOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import SplatOutput.ReadFile;

public class IncLingOutputFile {

	ArrayList<Combination> listCombsIncling;
	ArrayList<Combination> listCombsBaseline;
	
	ArrayList<Combination> iguais = new ArrayList<Combination>() ;
	ArrayList<Combination> diferentes= new ArrayList<Combination>() ;
	ArrayList<Integer> ordemDeprint= new ArrayList<Integer>();
	
	public void leitorIncLing(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
        Combination c;
        listCombsIncling= new ArrayList<Combination>();
		
        for (int i = 0; i < listas.size(); i++) {

			//	System.out.print(listas.get(i));
				String s=listas.get(i).toString();
			    c=new Combination();
				c.comb=l.splitLine2(s);
				listCombsIncling.add(c);
								
		} 
	}
        public void leitorBaseline(String arquivo) {

    		File dir = new File(arquivo);

    		ReadFile l = new ReadFile(dir);
    		List<String> listas = l.getListas();
            Combination c;
            listCombsBaseline= new ArrayList<Combination>();
    		
            for (int i = 0; i < listas.size(); i++) {

    				String s=listas.get(i).toString();
    			    c=new Combination();
    			    String formatado="";
    				 	 formatado = s.replaceAll(":true", ":1");	 
    				 	 formatado = formatado.replaceAll(":false", ":0");
    				 	formatado = formatado.toUpperCase(); 
    			    
    				c.comb=l.splitLine2(formatado);
    				listCombsBaseline.add(c);

    								
    		} 

	}
        public void verficarCombsRepetidos() {
        	int cont=0;
        	for (Combination combination : listCombsBaseline) {
					if(!existeCombinacao(combination.comb)) {
						
						cont++;
					    diferentes.add(combination);
					}else {
						combination.ordem=ordemDeprint.get(ordemDeprint.size()-1);
					iguais.add(combination);
					
					ordemDeprint.size();
					}
			}
        	System.out.println("\n\nNúmero de configurações diferentes entre incling e baseline : "+ cont);
        }
        
        public boolean existeCombinacao(ArrayList<String> bas) {
        	boolean controle=true;
        	int indice=0;
        	for (Combination inc : listCombsIncling) {
        		controle=true;
				int i=0;
        		while(i<inc.comb.size()&& controle ) {
        			//System.out.println(inc.comb.get(i) + " - "+bas.get(i) );
        			if(inc.comb.get(i).equals(bas.get(i))) {
							controle=true;
						}else {
							controle=false;
						}
        			i++;
					}
        		  i--;
					if(controle) {
						inc.ordem=indice;
					
					ordemDeprint.add(indice);
						return true;
					}
					indice++;
				}
        	
			return false;		
        }
        public void sort() {

    		Collections.sort(iguais, new Comparator<Combination>() {

    			public int compare(Combination p1, Combination p2) {
    				return p1.ordem < p2.ordem ? -1 : (p1.ordem > p2.ordem ? +1 : 0);
    			}
    		});

    		
    	}

        public void printDiferentes() {
        	for (Combination combination : diferentes) {
        		for (String feat : combination.comb) {
					System.out.print(feat+" ");
				}
        		System.out.println();
        	}
        }
        
        public void printIguais() {
        	sort();
        	for (Combination combination : iguais) {
        		for (String feat : combination.comb) {
					System.out.print(feat+" ");
				}
        		System.out.println();
			}
        	
        }
        
	public static void main(String[] args) {
		System.out.println("Inicio...\n");
		IncLingOutputFile ler = new IncLingOutputFile();

		ler.leitorIncLing("src/IncLingOutput/IncLingOutput.txt");
		ler.leitorBaseline("src/IncLingOutput/baselineOutput.txt");
		
		ler.verficarCombsRepetidos();
		
		System.err.println("Iguais\n\n");
		ler.printIguais();
		System.err.println("\n\nDiferentes\n\n");
		ler.printDiferentes();
		
		System.out.println("\nFim.");
	}
}
