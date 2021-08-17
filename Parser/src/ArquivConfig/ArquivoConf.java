package ArquivConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.EscreverArquivo;
import SplatOutput.ReadFile;

public class ArquivoConf {

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		ArrayList<String> features= new ArrayList<String>();
        String conf="";
        String saida="";
		for (int i = 0; i < listas.size(); i++) {

				conf=listas.get(i);
				features=l.splitLine2(conf);
               
		       for(int x = 0; x < features.size(); x++) {
		    	   System.err.println(features.get(x));
		    	   if(x != features.size()-1) {
		    		   saida+=features.get(x)+"\n";
		    	   }else {
		    		   saida+=features.get(x);
		    	   }
		       }
		       String nome="FeatureAmp__"+i+".config";
		       EscreverArquivo escrever= new EscreverArquivo(nome);
				escrever.escrever(saida);
				saida="";
		       System.out.println("\n\n\n");
		}

	}

	public static void main(String[] args) {
		System.out.println("Inicio...\n");
		ArquivoConf ler = new ArquivoConf();
          ler.leitor("src/ArquivConfig/config.txt");
		System.out.println("\nFim.");
	}
}
