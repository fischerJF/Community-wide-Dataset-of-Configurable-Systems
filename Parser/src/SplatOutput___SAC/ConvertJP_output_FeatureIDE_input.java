package SplatOutput___SAC;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import SplatOutput.ReadFile;

public class ConvertJP_output_FeatureIDE_input {
	
	public String saida="";

	public void leitor(String arquivo) {

		File dir = new File(arquivo);

		ReadFile l = new ReadFile(dir);
		List<String> listas = l.getListas();
		List<String> featureline;
		for (int i = 0; i < listas.size(); i++) {

			System.out.println(listas.get(i)+"\n\n");
			featureline = new ArrayList<String>();
			featureline=l.splitLine5(listas.get(i));
			//System.out.println(featureline.get(0)+"\n\n\n");
			writeOutputFile(i+1, featureline);
		}

	}
   
	public static void writeOutputFile(int file, List<String> conf ) {
		String outuput="";
		for (int i = 0; i < conf.size(); i++) {
			outuput+=conf.get(i)+"\n";			
		}
		System.out.print(outuput);
		
		
		File myDir = new File("products/00"+file);
		myDir.mkdir();
		System.out.println(myDir);
		EscreverArquivo escrever= new EscreverArquivo(myDir+"/00"+file+".config");
		escrever.escrever(outuput);
		
	}
	
	public static void main(String[] args) {
		System.out.println("Inicio...");
		ConvertJP_output_FeatureIDE_input arquivo = new ConvertJP_output_FeatureIDE_input();

		arquivo.leitor("src/SplatOutput___SAC/JP_Output.txt");
//		System.err.println("saida"+ arquivo.saida);
		

		System.out.println("Fim");
		
	}
}
